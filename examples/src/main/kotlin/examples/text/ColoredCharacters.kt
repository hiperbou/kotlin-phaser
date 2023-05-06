
package examples.text


import Phaser.*

class ColoredCharacters: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create })
	
	override fun create() {
	
		var style = TextStyle( font= "65px Arial", fill= "#ffffff", align= "center" )
	
	    var text = game.add.text(game.world.centerX, game.world.centerY, "- phaser -\nwith a sprinkle of\npixi dust", style)
	
	    text.anchor.set(0.5)
	
	    //  And now we"ll color in some of the letters
	    text.addColor("#ffff00", 16)
	    text.addColor("#ffffff", 25)
	
	    text.addColor("#ff00ff", 28)
	    text.addColor("#ffffff", 32)
	
	}
}