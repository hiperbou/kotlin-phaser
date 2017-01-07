
package examples.text

import Koala.initKoala
import Phaser.*

class BitmaptextAnchorX: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.bitmapFont("desyrel", "assets/fonts/bitmapFonts/desyrel.png", "assets/fonts/bitmapFonts/desyrel.xml")
	
	}
	
	lateinit var line:Phaser.Line
	
	override fun create() {
	
	    var text1 = game.add.bitmapText(400, 70, "desyrel", "Anchor.x = 0", 64)
	
	    var text2 = game.add.bitmapText(400, 270, "desyrel", "Anchor.x = 0.5", 64)
	    text2.anchor.x = 0.5
	
	    var text3 = game.add.bitmapText(400, 470, "desyrel", "Anchor.x = 1", 64)
	    text3.anchor.x = 1.0
	
	    line = Phaser.Line(400, 0, 400, 600)
	
	}
	
	override fun render() {
	
	    game.debug.geom(line)
	
	}
}