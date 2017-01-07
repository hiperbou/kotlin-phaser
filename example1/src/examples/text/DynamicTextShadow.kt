
package examples.text

import Koala.initKoala
import Phaser.*

class DynamicTextShadow: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var text:Text
	
	override fun create() {
	
		game.stage.setBackgroundColor(0xfbf6d5)
	
	    text = game.add.text(game.world.centerX, 250, "  dynamic shadows  ")
	    text.anchor.set(0.5)
	    text.align = "center"
	
	    text.font = "Arial Black"
	    text.fontSize = 70
	    text.fontWeight = "bold"
	    text.fill = "#ec008c"
	
	    text.setShadow(0, 0, "rgba(0, 0, 0, 0.5)", 0)
	
	}
	
	override fun update() {
	
		var offset = moveToXY(game.input.activePointer, text.x, text.y, 8.0)
	
	    text.setShadow(offset.x, offset.y, "rgba(0, 0, 0, 0.5)", distanceToPointer(text, game.input.activePointer) / 30)
	
	}
	
	fun distanceToPointer(displayObject:PIXI.DisplayObject, pointer:Pointer):Double {
	
	    val _dx = displayObject.x - pointer.x
	    val _dy = displayObject.y - pointer.y
	    
	    return Math.sqrt(_dx * _dx + _dy * _dy)
	
	}
	
	fun moveToXY(displayObject:Pointer, x:Double, y:Double, speed:Double):dynamic {
	
	    var _angle = Math.atan2(y - displayObject.y, x - displayObject.x)
	    
	    var x = Math.cos(_angle) * speed
	    var y = Math.sin(_angle) * speed
	
	    return object{ var  x= x;  var  y= y }
	
	}
}