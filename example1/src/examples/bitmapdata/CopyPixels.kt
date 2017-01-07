
package examples.bitmapdata

import Koala.initKoala
import Phaser.*

class CopyPixels: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload,  var  create= create,  var  update= update })
	
	override fun preload() {
	
	    game.load.image("pic", "assets/pics/hotshot-chaos_in_tokyo.png")
	
	}
	
	lateinit var bmd:BitmapData
	lateinit var area:Rectangle
	var dropTime = 0.0
	
	override fun create() {
	
		game.stage.backgroundColor = "#2d2d2d"
	
		bmd = game.make.bitmapData(800, 600)
	
		bmd.addToWorld()
	
		area = Phaser.Rectangle(0, 300, 200, 16)
	
		bmd.copyRect("pic", area, 300, 0)
	
	}
	
	override fun update() {
	
		if (area.y > 0 && game.time.now > dropTime)
		{
			for(y in 0..area.y.toInt())
			{
				bmd.copyRect("pic", area, 300, y)
			}
	
			area.y--
			dropTime = game.time.now + 25
		}
	
	}
}