
package examples.input

import Koala.initKoala
import Phaser.*

class FollowMouse: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("ball", "assets/sprites/shinyball.png")
	
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    sprite = game.add.sprite(game.world.centerX, game.world.centerY, "ball")
	    game.physics.enable(sprite, Phaser.Physics.ARCADE)
	
	}
	
	override fun update() {
	
	    //  only move when you click
	    if (game.input.mousePointer.isDown)
	    {
	        //  400 is the speed it will move towards the mouse
	        game.physics.arcade.moveToPointer(sprite, 400)
	
	        //  if it"s overlapping the mouse, don"t move any more
	        if (Phaser.Rectangle.contains(sprite.body, game.input.x, game.input.y))
	        {
	            sprite.body.velocity.setTo(0, 0)
	        }
	    }
	    else
	    {
	        sprite.body.velocity.setTo(0, 0)
	    }
	
	}
}