
package examples.basics

import Koala.initKoala
import Phaser.*

class E06RenderText: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", { create: create })
	
	override fun create() {
	
	    var text = "- phaser -\n with a sprinkle of \n pixi dust."
	    var style = TextStyle( font= "65px Arial", fill= "#ff0044", align= "center" )
	
	    var t = game.add.text(game.world.centerX-300, 0, text, style)
	
	}
}