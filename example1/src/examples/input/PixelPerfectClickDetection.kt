
package examples.input

import Koala.initKoala
import Phaser.*

class PixelPerfectClickDetection: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("bunny", "assets/sprites/bunny.png")
	
	}
	
	lateinit var bunny:Sprite
	
	override fun create() {
	
	    bunny = game.add.sprite(game.world.centerX, game.world.centerY, "bunny")
	
	    bunny.anchor.set(0.5)
	
	    //  Listen for input events on this sprite
	    bunny.inputEnabled = true
	
	    //  This will check the pixel every time the mouse moves, which is really expensive!
	    //  You can also only do a pixel perfect check on click, which is much cheaper - so
	    //  pick the right one accordingly.
	    bunny.input.pixelPerfectOver = true
	
	    //  Enable the hand cursor
	    bunny.input.useHandCursor = true
	
	}
	
	override fun update() {
	
	    //  Rotate slowly
	    bunny.angle += 0.05
	
	}
	
	override fun render() {
	
	    game.debug.spriteInputInfo(bunny, 32, 32)
	    //game.debug.geom(bunny.input._tempPoint)
	
	}
}