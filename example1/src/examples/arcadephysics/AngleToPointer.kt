
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class AngleToPointer: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	    game.load.image("arrow", "assets/sprites/arrow.png")
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#0072bc"
	
	    sprite = game.add.sprite(400, 300, "arrow")
	    sprite.anchor.setTo(0.5, 0.5)
	
	}
	
	override fun update() {
	
	    //  This will update the sprite.rotation so that it points to the currently active pointer
	    //  On a Desktop that is the mouse, on mobile the most recent finger press.
	    sprite.rotation = game.physics.arcade.angleToPointer(sprite)
	
	}
	
	override fun render() {
	
	    game.debug.spriteInfo(sprite, 32, 32)
	
	}
}