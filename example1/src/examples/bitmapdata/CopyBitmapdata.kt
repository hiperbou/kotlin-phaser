
package examples.bitmapdata

import Koala.initKoala
import Phaser.*

class CopyBitmapdata: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload,  var  create= create })
	
	override fun preload() {
	
	    game.load.image("pic", "assets/pics/Equality_by_Ragnarok.png")
	
	}
	
	lateinit var bmd:BitmapData
	lateinit var bmd2:BitmapData
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    bmd = game.make.bitmapData(800, 600)
	    bmd.copy("pic")
	    bmd.addToWorld()
	
	    bmd2 = game.make.bitmapData(64, 64)
	    bmd2.circle(32, 32, 32, "rgba(255,0,255,0.2)")
	
	    game.input.addMoveCallback(this::paint, this)
	
	}
	
	fun paint(pointer:Pointer, x:Double, y:Double) {
	
	    if (pointer.isDown)
	    {
	        bmd.draw(bmd2, x - 16, y - 16)
	    }
	
	}
}