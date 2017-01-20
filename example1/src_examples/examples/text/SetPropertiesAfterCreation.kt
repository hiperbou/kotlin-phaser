
package examples.text


import Phaser.*

class SetPropertiesAfterCreation: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.bitmapFont("desyrel", "assets/fonts/bitmapFonts/desyrel.png", "assets/fonts/bitmapFonts/desyrel.xml")
	
	}
	
	lateinit var text:BitmapText
	
	override fun create() {
	
	    text = game.add.bitmapText(0, 100, "desyrel", "I'm growing", 64)
	
	}
	
	override fun update() {
	
		if (text.fontSize < 250)
		{
			text.fontSize += 1
		}
	
	}
}