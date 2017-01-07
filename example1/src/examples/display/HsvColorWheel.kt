
package examples.display

import Koala.initKoala
import Phaser.*

class HsvColorWheel: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	var i = 0
	lateinit var bmd:BitmapData
	lateinit var colors:Array<ColorComponents>
	
	override fun create() {
	
		bmd = game.add.bitmapData(800, 600)
	
		game.add.sprite(0, 0, bmd)
	
		colors = Phaser.Color.HSVColorWheel()
	
	    game.input.addMoveCallback(this::paint, this)
	    game.input.addMoveCallback(this::paint2, this)
	    game.input.addMoveCallback(this::paint3, this)
	    game.input.addMoveCallback(this::paint4, this)
		game.input.addMoveCallback(this::paint5, this)
	
	    game.input.keyboard.addKey(Phaser.Keyboard.SPACEBAR).onDown.add(this::remove, this)
	
	}
	
	fun remove() {
	
	    game.input.deleteMoveCallback(this::paint3, this)
	
	}
	
	fun paint(pointer:Pointer, x:Double, y:Double) {
	
		if (pointer.isDown)
		{
			bmd.circle(x, y, 16, colors[i].rgba)
	
			i = Phaser.Math.wrapValue(i, 1, 359).toInt()
		}
	
	}
	
	fun paint2(pointer:Pointer, x:Double, y:Double) {
	
	    if (pointer.isDown)
	    {
	        bmd.circle(x, y + 64, 8, colors[i].rgba)
	    }
	
	}
	
	fun paint3(pointer:Pointer, x:Double, y:Double) {
	
	    if (pointer.isDown)
	    {
	        bmd.circle(x, y - 64, 8, colors[i].rgba)
	    }
	
	}
	
	fun paint4(pointer:Pointer, x:Double, y:Double) {
	
	    if (pointer.isDown)
	    {
	        bmd.circle(x - 64, y, 8, colors[i].rgba)
	    }
	
	}
	
	fun paint5(pointer:Pointer, x:Double, y:Double) {
	
	    if (pointer.isDown)
	    {
	        bmd.circle(x + 64, y, 8, colors[i].rgba)
	    }
	
	}
}