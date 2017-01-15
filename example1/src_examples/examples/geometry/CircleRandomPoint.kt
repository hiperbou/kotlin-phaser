
package examples.geometry

import Koala.initKoala
import Phaser.*

class CircleRandomPoint: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var bmd:BitmapData
	lateinit var circle:Phaser.Circle
	
	lateinit var colors:Array<ColorComponents>
	var i = 0
	lateinit var p:Point
	
	override fun create() {
	
	    colors = Phaser.Color.HSVColorWheel()
	
	    //  Create a Circle
	    circle = Phaser.Circle(game.world.centerX, game.world.centerY, 500)
	
	    //  Create a BitmapData just to plot Circle points to
	    bmd = game.add.bitmapData(game.width, game.height)
	    bmd.addToWorld()
	
	    //  And display our circle on the top
	    var graphics = game.add.graphics(0, 0)
	    graphics.lineStyle(1, 0x00ff00, 1)
	    graphics.drawCircle(circle.x, circle.y, circle.diameter)
	
	    p = Phaser.Point()
	
	}
	
	override fun update() {
	
	    for(c in 0..10-1)
	    {
	        circle.random(p)
	
	        //  We"ll floor it as setPixel needs integer values and random returns floats
	        p.floor()
	
	        bmd.setPixel(p.x, p.y, colors[i].r, colors[i].g, colors[i].b)
	    }
	    
	    i = Phaser.Math.wrapValue(i, 1, 359).toInt()
	
	}
}