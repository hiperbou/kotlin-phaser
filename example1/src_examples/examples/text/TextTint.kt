
package examples.text

import Koala.initKoala
import Phaser.*

class TextTint: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	var clicks = 0
	
	override fun create() {
	
	    var text = game.add.text(game.world.centerX, game.world.centerY, "Click me", object{ var  font= "65px Arial";  var  fill= "#ffff00";  var  align= "center" })
	
	    // text.tint = 0xff00033
	
	    text.anchor.set(0.5)
	
	    text.inputEnabled = true
	
	    text.events.onInputDown.add(this::down, this)
	
	}
	
	fun down(item:Sprite) {
	
	    clicks++
		val item = item as Text

	    item.text = "clicked " + clicks + " times"
	
	    item.tint = if (item.tint == 0xffffff) 0xff0000 else 0xffffff
	
	}
}