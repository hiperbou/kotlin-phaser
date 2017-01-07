
package examples.text

import Koala.initKoala
import Phaser.*

class BitmapFontCacheAsBitmap: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.bitmapFont("desyrel", "assets/fonts/bitmapFonts/desyrel.png", "assets/fonts/bitmapFonts/desyrel.xml")
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	
	}
	
	override fun create() {
	
	    // var txt1 = game.add.bitmapText(0, 0, "desyrel","0x0", 30)
	
	    var bob = game.add.sprite(200, 200, "mushroom")
	    var bob2 = game.add.sprite(300, 200, "mushroom")
	    
	    // var txt2 = game.add.bitmapText(25, 25, "desyrel", "25x25", 30)
	    // var txt3 = game.add.bitmapText(50, 50, "desyrel", "50x50", 60)
	
	    // txt1.cacheAsBitmap = true
	    bob.cacheAsBitmap = true
	    bob2.cacheAsBitmap = true
	    // txt2.cacheAsBitmap = true
	    // txt3.cacheAsBitmap = true
	    
	}
}