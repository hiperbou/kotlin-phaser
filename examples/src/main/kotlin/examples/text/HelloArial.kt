
package examples.text


import Phaser.*

class HelloArial: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	override fun create() {
	
	    var style = TextStyle( font= "65px Arial", fill= "#ff0044", align= "center" )
	
	    var text = game.add.text(game.world.centerX, game.world.centerY, "- phaser -\nwith a sprinkle of\npixi dust", style)
	
	    text.anchor.set(0.5)
	
	}
}