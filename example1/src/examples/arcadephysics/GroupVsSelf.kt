
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class GroupVsSelf: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.spritesheet("spinner", "assets/sprites/bluemetal_32x32x4.png", 32, 32)
	
	}
	
	lateinit var sprites:Group
	
	override fun create() {
	
	    //  Here we create a group, populate it with sprites, give them all a random velocity
	    //  and then check the group against itself for collision
	
	    sprites = game.add.physicsGroup(Phaser.Physics.ARCADE)
	
	    for(i in 0..90-1)
	    {
	        var s = sprites.create(game.rnd.integerInRange(100, 700), game.rnd.integerInRange(32, 200), "spinner")
	        s.animations.add("spin", arrayOf(0, 1, 2, 3))
	        s.play("spin", 20, true)
	        s.body.velocity.set(game.rnd.integerInRange(-200, 200), game.rnd.integerInRange(-200, 200))
	    }
	
	    sprites.setAll("body.collideWorldBounds", true)
	    sprites.setAll("body.bounce.x", 1)
	    sprites.setAll("body.bounce.y", 1)
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(sprites)
	
	}
}