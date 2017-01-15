
package examples.geometry

import Koala.initKoala
import Phaser.*

class PolygonExample: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	lateinit var poly:Phaser.Polygon
	lateinit var graphics:Graphics
	
	override fun create() {
	
	    //  Different ways of creating a Polygon:
	
	    //  Array of Point values
	    // poly = Phaser.Polygon([ Phaser.Point(200, 100), Phaser.Point(350, 100), Phaser.Point(375, 200), Phaser.Point(150, 200) ])
	
	    //  Point values as parameters
	    // poly = Phaser.Polygon(Phaser.Point(200, 100), Phaser.Point(350, 100), Phaser.Point(375, 200), Phaser.Point(150, 200))
	
	    //  Array of numbers treated as x/y pairs
	    // poly = Phaser.Polygon(mutableListOf<>(200, 100, 350, 100, 375, 200, 150, 200))
	
	    //  Numbers in x/y pairs as parameters
	    // poly = Phaser.Polygon(200, 100, 350, 100, 375, 200, 150, 200)
	
	    //  Array of mixed-type values
	    // poly = Phaser.Polygon([ Phaser.Point(200, 100), 350, 100, 375, 200, Phaser.Point(150, 200) ])
	
	    //  Mixed-type values as parameters
	    // poly = Phaser.Polygon(Phaser.Point(200, 100), 350, 100, 375, 200, Phaser.Point(150, 200))
	
	    //  Array of Objects with visible x/y properties
	    // poly = Phaser.Polygon([ object{ var  x= 200;  var  y= 100 }, object{ var  x= 350;  var  y= 100 }, object{ var  x= 375;  var  y= 200}, object{ var  x= 150;  var  y= 200 } ])
	
	    //  Objects with visible x/y properties as parameters
	    // poly = Phaser.Polygon( object{ var  x= 200;  var  y= 100 }, object{ var  x= 350;  var  y= 100 }, object{ var  x= 375;  var  y= 200}, object{ var  x= 150;  var  y= 200 })
	
	
	
	    //  You can also create an empty Polygon:
	    poly = Phaser.Polygon()
	
	    //  And then populate it via setTo, using any combination of values as above
	    poly.setTo(arrayOf(Phaser.Point(200, 100), Phaser.Point(350, 100), Phaser.Point(375, 200), Phaser.Point(150, 200) ))
	
	
	
	    graphics = game.add.graphics(0, 0)
	
	    graphics.beginFill(0xFF33ff)
	    graphics.drawPolygon(poly.points)
	    graphics.endFill()
	
	}
}