
package examples.tilesprites

import Koala.initKoala
import Phaser.*

class TileSpriteFromAnimatedSprite: State() {
	
	// //var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("waters", "assets/sprites/waters.png", 32, 400, 32)
	
	}
	
	lateinit var water:TileSprite
	
	override fun create() {
	
	    water = game.add.tileSprite(0, 24 * 16, 128 * 16, 24 * 16, "waters")
	
	    // water = game.add.sprite(0, 0, "waters")
	
	    water.animations.add("waves0", arrayOf(0, 1, 2, 3, 2, 1))
	    water.animations.add("waves1", arrayOf(4, 5, 6, 7, 6, 5))
	    water.animations.add("waves2", arrayOf(8, 9, 10, 11, 10, 9))
	    water.animations.add("waves3", arrayOf(12, 13, 14, 15, 14, 13))
	    water.animations.add("waves4", arrayOf(16, 17, 18, 19, 18, 17))
	    water.animations.add("waves5", arrayOf(20, 21, 22, 23, 22, 21))
	    water.animations.add("waves6", arrayOf(24, 25, 26, 27, 26, 25))
	    water.animations.add("waves7", arrayOf(28, 29, 30, 31, 30, 29))
	
	    // change to animation num
	    var n = 7
	    water.animations.play("waves" + n, 8, true)
	
	}
}