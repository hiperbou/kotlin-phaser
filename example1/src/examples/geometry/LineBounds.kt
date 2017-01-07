
package examples.geometry

import Koala.initKoala
import Phaser.*

class LineBounds: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create;  var  update= update;  var  render= render })
	
	lateinit var line:Phaser.Line
	var setting = false
	
	override fun create() {
	
	    line = Phaser.Line(64, 64, 200, 300)
	
	    game.input.onDown.add(this::click, this)
	
	}
	
	override fun update() {
	
	    if (setting)
	    {
	        if (game.input.activePointer.isDown)
	        {
	            line.end.set(game.input.activePointer.x, game.input.activePointer.y)
	        }
	        else
	        {
	            setting = false
	        }
	    }
	
	}
	
	fun click(pointer:Pointer) {
	
	    setting = true
	    line.start.set(pointer.x, pointer.y)
	
	}
	
	override fun render() {
	
	    game.debug.geom(line)
	    game.debug.rectangle(line)
	
	}
}