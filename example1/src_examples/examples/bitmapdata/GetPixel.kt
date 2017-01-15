
package examples.bitmapdata

import Koala.initKoala
import Phaser.*

class GetPixel: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload,  var  create= create })
	
	override fun preload() {
	
	    game.load.image("wheel", "assets/pics/color_wheel_swirl.png")
	
	}
	
	lateinit var bmd:BitmapData
	lateinit var tooltip:BitmapData
	lateinit var sprite:Sprite
	
	override fun create() {
	
		bmd = game.make.bitmapData(800, 600)
		bmd.draw("wheel", -200, -100)
		bmd.update()
		bmd.addToWorld()
	
		tooltip = game.make.bitmapData(64, 64)
		sprite = game.add.sprite(0, 0, tooltip)
	
		game.input.addMoveCallback(this::updateTooltip, this)
	
	}
	
	fun updateTooltip(pointer:Pointer, x:Double, y:Double) {
	
		if (x >= 0 && x <= bmd.width && y >= 0 && y <= bmd.height)
		{
			var color = bmd.getPixelRGB(x, y)
	
			tooltip.fill(0, 0, 0)
			tooltip.rect(1, 1, 62, 62, color.rgba)
		
			sprite.x = x.toDouble()
			sprite.y = y.toDouble()
		}
	
	}
}