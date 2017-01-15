
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class AccelerateToPointer: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	    game.load.image("arrow", "assets/sprites/arrow.png")
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#0072bc"
	
	    sprite = game.add.sprite(400, 300, "arrow")
	    sprite.anchor.setTo(0.5, 0.5)
	
	    //  Enable Arcade Physics for the sprite
	    game.physics.enable(sprite, Phaser.Physics.ARCADE)
	
	    //  Tell it we don"t want physics to manage the rotation
	    sprite.body.allowRotation = false
	
	}
	
	override fun update() {
	
	    sprite.rotation = game.physics.arcade.moveToPointer(sprite, 60, game.input.activePointer, 500)
	
	}
	
	override fun render() {
	
	    game.debug.spriteInfo(sprite, 32, 32)
	
	}
}