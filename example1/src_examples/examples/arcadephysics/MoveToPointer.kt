
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class MoveToPointer: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("backdrop", "assets/pics/remember-me.jpg")
	    game.load.image("ball", "assets/sprites/shinyball.png")
	
	}
	
	lateinit var ball:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.world.setBounds(0, 0, 1920, 1200)
	
	    game.add.sprite(0, 0, "backdrop")
	
	    ball = game.add.sprite(game.world.randomX, 200, "ball")
	
	    game.physics.arcade.enable(ball)
	
	    game.camera.follow(ball)
	
	    game.input.onDown.add(this::moveBall, this)
	
	}
	
	fun moveBall() {
	
	    //  If we don"t it"ll look very wrong
	    game.camera.follow()
	
	    game.physics.arcade.moveToPointer(ball, 100)
	
	    //  The maxTime parameter lets you control how fast it will arrive at the Pointer coords
	    // game.physics.arcade.moveToPointer(ball, 100, game.input.activePointer, 1000)
	
	
	}
	
	override fun render() {
	
	    game.debug.text("distance: " + game.physics.arcade.distanceToPointer(ball), 32, 32)
	
	}
}