
package examples.geometry

import Koala.initKoala
import Phaser.*

class EllipseRandomPoint: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var bmd:BitmapData
	lateinit var ellipse:Ellipse
	
	lateinit var colors:Array<ColorComponents>
	var i = 0
	lateinit var p:Phaser.Point
	
	override fun create() {
	
	    colors = Phaser.Color.HSVColorWheel()
	
	    //  Create an Ellipse
	    ellipse = Phaser.Ellipse(game.world.centerX, game.world.centerY, 300, 550)
	
	    //  Create a BitmapData just to plot the points to
	    bmd = game.add.bitmapData(game.width, game.height)
	    bmd.addToWorld()
	
	    p = Phaser.Point()
	
	}
	
	override fun update() {
	
	    for(c in 0..10-1)
	    {
	        ellipse.random(p)
	
	        //  We"ll floor it as setPixel needs integer values and random returns floats
	        p.floor()
	
	        bmd.setPixel(p.x, p.y, colors[i].r, colors[i].g, colors[i].b)
	    }
	    
	    i = Phaser.Math.wrapValue(i, 1, 359)
	
	}
}