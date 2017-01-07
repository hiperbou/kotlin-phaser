
package examples.text

import Koala.initKoala
import Phaser.*

class RemoveText: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	lateinit var text:Text
	
	override fun create() {
	
	    text = game.add.text(game.world.centerX, game.world.centerY, "- phaser -\nclick to remove", object{ var  font= "65px Arial";  var  fill= "#ff0044";  var  align= "center" })
	    text.anchor.setTo(0.5, 0.5)
	
	    game.input.onDown.add(this::removeText, this)
	
	}
	
	fun removeText() {
	
	    text.destroy()
	
	}
}