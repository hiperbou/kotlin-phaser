
package examples.text


import Phaser.*

class CleanText: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.bitmapFont("desyrel", "assets/fonts/bitmapFonts/desyrel.png", "assets/fonts/bitmapFonts/desyrel.xml")
	
	}
	
	override fun create() {
	
	    var dirtyString = "The Desyrel™ font doesn\"t have\na trademark character\nor a €Euro sign.\nString.size: "
	
	    var text1 = game.add.bitmapText(100, 64, "desyrel", dirtyString + (dirtyString.length), 32)
	
	    //  Clean the string. This will remove all characters the font data doesn"t support
	    //var cleanString = text1.cleanText(dirtyString)
	
	    //var text2 = game.add.bitmapText(100, 300, "desyrel", cleanString + (cleanString.size), 32)
	
	}
}