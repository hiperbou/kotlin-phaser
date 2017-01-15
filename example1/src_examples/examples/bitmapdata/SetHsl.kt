
package examples.bitmapdata

import Koala.initKoala
import Phaser.*

class SetHsl: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload,  var  create= create })
	
	override fun preload() {
	
	    game.load.image("pic", "assets/tests/ships.png")
	
	}
	
	lateinit var bmd:BitmapData
	
	override fun create() {
	
		game.stage.backgroundColor = "#2d2d2d"
	
		bmd = game.make.bitmapData()
	
		bmd.load("pic")
	
		var sprite = bmd.addToWorld(game.world.centerX, game.world.centerY, 0.5, 0.5, 3, 3)
		sprite.smoothed = false
	
		game.input.onDown.add(this::startProcess, this)
	
	}
	
	fun startProcess () {
	
		//	fixed h
		// bmd.setHSL(0.2)
	
		//	shift
		bmd.shiftHSL(0.1)
	
		// bmd.shiftHSL(0.1, null, null, Phaser.Rectangle(32, 32, 100, 100))
	
		//	white hit
		// bmd.shiftHSL(null, null, 1.0)
	
		//	desaturation
		// bmd.shiftHSL(null, -1.0, null)
	
	}
}