
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class BodyDebug: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/sprites/atari130xe.png")
	
	}
	
	lateinit var sprite:Sprite
	var showDebug = true
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.physics.arcade.gravity.y = 100.0
	
	    sprite = game.add.sprite(150, 100, "atari")
	
	    game.physics.arcade.enable(sprite)
	
	    sprite.body.velocity.set(-100, -100)
	    sprite.body.bounce.set(1)
	    sprite.body.collideWorldBounds = true
	
	    game.input.onDown.add(this::toggle, this)
	}
	
	fun toggle() {
	
	    showDebug = if (showDebug) false else true
	
	    if (!showDebug)
	    {
	        game.debug.reset()
	    }
	
	}
	
	override fun render() {
	
	    if (showDebug != null)
	    {
	        game.debug.bodyInfo(sprite, 32, 32)
	        game.debug.body(sprite)
	    }
	
	}
}