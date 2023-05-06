
package examples.text


import Phaser.*

class Littera: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.bitmapFont("shortStack", "assets/fonts/bitmapFonts/shortStack.png", "assets/fonts/bitmapFonts/shortStack.fnt")
	
	}
	
	override fun create() {
	
	    game.add.bitmapText(32, 32, "shortStack", "This font was generated using the\nfree Littera web site\n\nhttp://kvazars.com/littera/", 32)
	
	}
}