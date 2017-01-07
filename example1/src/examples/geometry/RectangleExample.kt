
package examples.geometry

import Koala.initKoala
import Phaser.*

class RectangleExample: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  render= render })
	
	lateinit var floor:Phaser.Rectangle
	
	override fun create() {
	
	    floor = Phaser.Rectangle(0, 550, 800, 50)
	
	}
	
	override fun render() {
	
	    game.debug.geom(floor,"#0fffff")
	
	}
}