
package examples.text


import Phaser.*

class WordWrap: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0072bc"
	
		var style = TextStyle( font= "bold 60pt Arial", fill= "white", align= "left", wordWrap= true, wordWrapWidth= 450 )
	
	    var text = game.add.text(game.world.centerX, game.world.centerY, "phaser with a sprinkle of pixi dust", style)
	
	    text.anchor.set(0.5)
	
	}
}