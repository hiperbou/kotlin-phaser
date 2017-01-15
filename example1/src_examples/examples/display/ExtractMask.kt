
package examples.display

import Koala.initKoala
import Phaser.*

class ExtractMask: State() {
	
	// //var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("font", "assets/demoscene/knighthawks.png")
	
	}
	
	lateinit var font:BitmapData
	lateinit var mask:BitmapData
	
	override fun create() {
	
		font = game.make.bitmapData(320, 150)
		mask = game.make.bitmapData(320, 150)
		mask.fill(50, 50, 50)
	
		font.draw("font")
	
		font.update()
	
		game.add.sprite(0, 0, font)
		game.add.sprite(0, 150, mask)
	
		game.input.onDown.add(this::getMask, this)
	
	}
	
	fun getMask () {
	
		font.extract(mask, 237, 0, 140)
	
	}
}