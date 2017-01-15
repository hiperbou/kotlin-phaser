
package examples.bitmapdata

import Koala.initKoala
import Phaser.*

class Tint: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload,  var  create= create })
	
	override fun preload() {
	
	    game.load.image("crystal", "assets/pics/cougar_dragonsun.png")
	
	}
	
	lateinit var bmd:BitmapData
	
	override fun create() {
	
	    var pic = game.make.image(0, 0, "crystal")
	
	    bmd = game.make.bitmapData(pic.width, pic.height)
	
	    PIXI.CanvasTinter.tintMethod(pic.texture, 0xee4343, bmd.canvas)
	
	    bmd.addToWorld()
	
	}
}