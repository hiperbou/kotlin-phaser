
package examples.text

import Koala.initKoala
import Phaser.*

class BitmapFonts: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.bitmapFont("desyrel", "assets/fonts/bitmapFonts/desyrel.png", "assets/fonts/bitmapFonts/desyrel.xml")
	
	}
	
	lateinit var bmpText:BitmapText
	
	override fun create() {
	
	    bmpText = game.add.bitmapText(200, 100, "desyrel", "Phaser & Pixi\nrocking!", 64)
	
	}
	
	override fun update() {
	
	    bmpText.text = "Phaser & Pixi\nrocking!\n" + Math.round(game.time.now)
	
	}
}