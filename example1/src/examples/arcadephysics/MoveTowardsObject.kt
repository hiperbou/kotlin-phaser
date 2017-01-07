
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class MoveTowardsObject: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("ball", "assets/sprites/shinyball.png")
	
	}
	
	lateinit var balls:Group
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    balls = game.add.group()
	    balls.enableBody = true
	
	    for(i in 0..50-1)
	    {
	        var ball = balls.create(game.world.randomX, game.world.randomY, "ball")
	    }
	
	}
	
	override fun update() {
	
	    if (game.input.mousePointer.isDown)
	    {
	        //  First is the callback
	        //  Second is the context in which the callback runs, in this case game.physics.arcade
	        //  Third is the parameter the callback expects - it is always sent the Group child as the first parameter
	        balls.forEach(game.physics.arcade::moveToPointer, game.physics.arcade, false, 200)
	    }
	    else
	    {
	        balls.setAll("body.velocity.x", 0)
	        balls.setAll("body.velocity.y", 0)
	    }
	}
}