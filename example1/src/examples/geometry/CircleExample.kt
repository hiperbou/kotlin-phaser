
package examples.geometry

import Koala.initKoala
import Phaser.*

class CircleExample: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  render= render })
	
	lateinit var circle:Phaser.Circle

	override fun create() {
	
	    circle = Phaser.Circle(game.world.centerX, 100,64)
	
	}
	
	override fun render() {
	
	    game.debug.geom(circle,"#cfffff")
	    game.debug.text("Diameter : "+circle.diameter,50,200)
	    game.debug.text("Circumference : "+circle.circumference(),50,230)
	
	}
}