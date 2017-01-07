
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class GravityAndDrag: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("ilkke", "assets/sprites/atari800xl.png")
	
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    //  Set the world (global) gravity
	    game.physics.arcade.gravity.y = 100.0
	
	    //  Sprite 1 will use the World (global) gravity
	    sprite = game.add.sprite(100, 96, "ilkke")
	
	    game.physics.arcade.enable(sprite)
	
	    sprite.body.collideWorldBounds = true
	    sprite.body.velocity.x = 200
	    sprite.body.bounce.set(0.9)
	
	    //  Also enable sprite for drag
	    sprite.inputEnabled = true
	    sprite.input.enableDrag()
	
	    sprite.events.onDragStart.add(this::startDrag, this)
	    sprite.events.onDragStop.add(this::stopDrag, this)
	
	    game.add.text(32, 32, "Drag and release the sprite", TextStyle(font="16px Arial",fill="#ffffff" ))
	
	}
	
	fun startDrag() {
	
	    //  You can"t have a sprite being moved by physics AND input, so we disable the physics while being dragged
	    sprite.body.moves = false
	
	}
	
	fun stopDrag() {
	
	    //  And re-enable it upon release
	    sprite.body.moves = true
	
	}
}