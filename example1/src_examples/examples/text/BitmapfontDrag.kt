
package examples.text


import Phaser.*

class BitmapfontDrag: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.bitmapFont("carrier_command", "assets/fonts/bitmapFonts/carrier_command.png", "assets/fonts/bitmapFonts/carrier_command.xml")
	
	}
	
	lateinit var bmpText:BitmapText
	
	override fun create() {

		bmpText = game.add.bitmapText(10, 100, "carrier_command","Drag me around !",34)
	
	    bmpText.inputEnabled = true
	
	    bmpText.input.enableDrag()
	
	}
	
}