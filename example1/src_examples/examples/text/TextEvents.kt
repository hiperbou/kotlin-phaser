
package examples.text

import Koala.initKoala
import Phaser.*

class TextEvents: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	var clicks = 0
	
	override fun create() {
	
	    var text = game.add.text(game.world.centerX, game.world.centerY, "click and drag me", object{ var  font= "65px Arial";  var  fill= "#ff0044";  var  align= "center" })
	
	    text.anchor.set(0.5)
	
	    text.inputEnabled = true
	
	    text.input.enableDrag()
	
	    text.events.onInputOver.add(this::over, this)
	    text.events.onInputOut.add(this::out, this)
	
	    text.events.onInputDown.add(this::down, this)
	    text.events.onInputUp.add(this::up, this)
	
	}
	
	fun over(item:Sprite) {
		val item = item as Text
	    item.fill = "#ffff44"
	    item.text = "clicked " + clicks + " times"
	
	}
	
	fun out(item:Sprite) {
		val item = item as Text
	    item.fill = "#ff0044"
	    item.text = "click and drag me"
	
	}
	
	fun down(item:Sprite) {
		val item = item as Text
	    clicks++
	
	    item.text = "clicked " + clicks + " times"
	
	}
	
	fun up(item:Sprite) {
		val item = item as Text
	    item.text = "thanks for clicking!"
	
	}
}