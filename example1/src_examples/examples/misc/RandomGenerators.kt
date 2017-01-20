
package examples.misc


import Phaser.*

class RandomGenerators: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var create= create })
	
	override fun create() {
	
	    game.stage.backgroundColor = "#454645"
	
	    var style = TextStyle( font= "14px Arial", fill= "#ff0044", align= "center" )
	
	    game.add.text(32, 30, "Integer: " + game.rnd.integer(), style)
	    game.add.text(32, 60, "Frac: " + game.rnd.frac(), style)
	    game.add.text(32, 90, "Real: " + game.rnd.real(), style)
	    game.add.text(32, 120, "Integer in Range (100-200): " + game.rnd.integerInRange(100, 200), style)
	
	}
}