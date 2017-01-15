
package examples.sprites

import Koala.initKoala
import Phaser.*

class SpriteRotation: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	    game.load.image("arrow", "assets/sprites/arrow.png")
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0072bc"
	
	    sprite = game.add.sprite(400, 300, "arrow")
	    sprite.anchor.setTo(0.5, 0.5)
	
	}
	
	override fun update() {
	
	    sprite.angle += 1
	
	    //  Note: Due to a bug in Chrome the following doesn"t work atm:
	    //  sprite.angle++
	    //  See: https://code.google.com/p/chromium/issues/detail?id=306851
	
	}
	
	override fun render() {
	
	    game.debug.spriteInfo(sprite, 32, 32)
	    // game.debug.text("angularVelocity: " + sprite.body.angularVelocity, 32, 200)
	    // game.debug.text("angularAcceleration: " + sprite.body.angularAcceleration, 32, 232)
	    // game.debug.text("angularDrag: " + sprite.body.angularDrag, 32, 264)
	    // game.debug.text("deltaZ: " + sprite.body.deltaZ(), 32, 296)
	
	}
}