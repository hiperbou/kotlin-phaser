
package examples.display

import Koala.initKoala
import Phaser.*

class GraphicsInputEvents: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create })
	
	lateinit var graphics:Graphics
	
	override fun create() {
	
	    graphics = game.add.graphics(300, 200)
	
	    drawShape(0x027a71, 0x02fdeb)
	
	    graphics.inputEnabled = true
	    graphics.input.useHandCursor = true
	
	    graphics.events.onInputDown.add(this::onDown, this)
	    graphics.events.onInputUp.add(this::onUp, this)
	    graphics.events.onInputOver.add(this::onOver, this)
	    graphics.events.onInputOut.add(this::onOut, this)
	
	}
	
	fun drawShape(fill:Int, style:Int) {
	
	    graphics.clear()
	
	    graphics.beginFill(fill)
	    graphics.lineStyle(4, style, 1)
	
	    graphics.moveTo(0, 0)
	    graphics.lineTo(250, 0)
	    graphics.lineTo(250, 200)
	    graphics.lineTo(125, 100)
	    graphics.lineTo(0, 200)
	    graphics.lineTo(0, 0)
	
	    graphics.endFill()
	
	}
	
	fun onOver() {
	
	    drawShape(0xab3602, 0xeb6702)
	
	}
	
	fun onDown() {
	
	    drawShape(0x717a02, 0xebfd02)
	
	}
	
	fun onUp() {
	
	    drawShape(0x027a71, 0x02fdeb)
	
	}
	
	fun onOut() {
	
	    drawShape(0x027a71, 0x02fdeb)
	
	}
}