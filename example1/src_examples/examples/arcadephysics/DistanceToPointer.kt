
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class DistanceToPointer: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("backdrop", "assets/pics/remember-me.jpg")
	    game.load.image("ball", "assets/sprites/shinyball.png")
	
	}
	
	lateinit var ball:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.world.setBounds(0, 0, 1920, 1200)
	
	    game.add.sprite(0, 0, "backdrop")
	
	    ball = game.add.sprite(game.world.randomX, 200, "ball")
	
	    game.physics.arcade.enable(ball)
	
	    game.camera.follow(ball)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    ball.body.velocity.x = 0
	    ball.body.velocity.y = 0
	
	    if (cursors.left.isDown)
	    {
	        ball.body.velocity.x = -240
	    }
	    else if (cursors.right.isDown)
	    {
	        ball.body.velocity.x = 240
	    }
	
	    if (cursors.up.isDown)
	    {
	        ball.body.velocity.y = -240
	    }
	    else if (cursors.down.isDown)
	    {
	        ball.body.velocity.y = 240
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Distance to pointer: " + game.physics.arcade.distanceToPointer(ball), 32, 32)
	
	}
}