
package examples.geometry

import Koala.initKoala
import Phaser.*

class RectangleRandomPoint: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var bmd:BitmapData
	lateinit var rectangle:Phaser.Rectangle
	
	lateinit var colors:Array<ColorComponents>
	var i = 0
	lateinit var p:Phaser.Point
	
	override fun create() {
	
	    colors = Phaser.Color.HSVColorWheel()
	
	    //  Create a Rectangle
	    rectangle = Phaser.Rectangle(100, 200, 600, 200)
	
	    //  Create a BitmapData just to plot the points to
	    bmd = game.add.bitmapData(game.width, game.height)
	    bmd.addToWorld()
	
	    p = Phaser.Point()
	
	}
	
	override fun update() {
	
	    for(c in 0..10-1)
	    {
	        rectangle.random(p)
	
	        //  We"ll floor it as setPixel needs integer values and random returns floats
	        p.floor()
	
	        bmd.setPixel(p.x, p.y, colors[i].r, colors[i].g, colors[i].b)
	    }
	    
	    i = Phaser.Math.wrapValue(i, 1, 359)
	
	}
}