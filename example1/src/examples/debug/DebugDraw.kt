
package examples.debug

import Koala.initKoala
import Phaser.*

class DebugDraw: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  render=render  })
	
	var rect = Phaser.Rectangle( 100, 100, 100, 100 ) 
	var circle = Phaser.Circle( 280, 150, 100 ) 
	var point = Phaser.Point( 100.0, 280.0 )
	
	override fun render() {
	
	    // Draw debug tools
	    game.debug.geom( rect, "rgba(255,0,0,1)" ) 
	    game.debug.geom( circle, "rgba(255,255,0,1)" ) 
	    game.debug.geom( point, "rgba(255,255,255,1)" ) 
	    game.debug.pixel( 200, 280, "rgba(0,255,255,1)" ) 
	    game.debug.text( "This is debug text", 100, 380 )
	
	
	}
}