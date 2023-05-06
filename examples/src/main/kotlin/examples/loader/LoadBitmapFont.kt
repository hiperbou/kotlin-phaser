
package examples.loader


import Phaser.*

class LoadBitmapFont: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    //  Phaser can load Bitmap Fonts.
	
	    //  As with all load operations the first parameter is a unique key, which must be unique between all image files.
	    //  Next is the bitmap font file itself, in this case desyrel.png
	    //  Finally is the path to the XML file that goes with the font.
	
	    game.load.bitmapFont("desyrel", "assets/fonts/bitmapFonts/desyrel.png", "assets/fonts/bitmapFonts/desyrel.xml")
	
	    //  Note that the XML file should be saved with UTF-8 encoding or some browsers (such as Firefox) won"t load it.
	
	    //  There are various tools that can create Bitmap Fonts and the XML file needed.
	    //  On Windows you can use the free app BMFont: http://www.angelcode.com/products/bmfont/
	    //  On OS X we recommend Glyph Designer: http://www.71squared.com/en/glyphdesigner
	
	}
	
	lateinit var text:BitmapText
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0072bc"
	
	    text = game.add.bitmapText(200, 100, "desyrel","Bitmap Fonts!",64)
	
	}
	
	override fun update() {
	
	    text.setText("Bitmap Fonts!\nx: " + Math.round(game.input.x) + " y: " + Math.round(game.input.y))
	
	}
}