
package examples.misc

import Koala.initKoala
import Phaser.*

class RepeatableRandomNumbers: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update;  var  render= render })
	
	override fun create() {
	
	    game.rnd.sow(arrayOf(123))
	    console.log("A")
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	
	    game.rnd.sow(arrayOf(0))
	    console.log("B")
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	
	    game.rnd.sow(arrayOf(123))
	    console.log("C")
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	    console.log(game.rnd.integer())
	}
	
	override fun update() {
	}
	
	override fun render() {
	}
}