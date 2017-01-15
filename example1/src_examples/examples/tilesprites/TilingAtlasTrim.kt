
package examples.tilesprites

import Koala.initKoala
import Phaser.*

class TilingAtlasTrim: State() {
	
	// //var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.atlas("test", "assets/sprites/tstrim.png", "assets/sprites/tstrim.json")
	
	}

	override fun create() {
	
	    game.add.sprite(0, 0, "test", "ts-trim")
	    game.add.tileSprite(100, 0, 500, 600, "test", "ts-trim")
	
	}
}