
package examples.geometry

import Koala.initKoala
import Phaser.*

class LineRandomPoint: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var bmd:BitmapData
	var lines = mutableListOf<Line>()
	
	lateinit var colors:Array<ColorComponents>
	var i = 0
	lateinit var p:Phaser.Point
	
	override fun create() {
	
	    colors = Phaser.Color.HSVColorWheel()
	
	    //  Create some Lines, we"ll store them in this array
	    lines = mutableListOf<Line>()
	
	    for(c in 0..50-1)
	    {
	        lines.add(Phaser.Line(game.world.randomX, game.world.randomY, game.world.randomX, game.world.randomY))
	    }
	
	    //  Create a BitmapData just to plot to
	    bmd = game.add.bitmapData(game.width, game.height)
	    bmd.addToWorld()
	
	    //  We"ll re-use this point object for the plot
	    p = Phaser.Point()
	
	}
	
	override fun update() {
	
	    //  Plot pixels against the lines
	
	    for(c in 0..lines.size-1)
	    {
	        lines[c].random(p)
	
	        //  We"ll floor it as setPixel needs integer values and random returns floats
	        p.floor()
	
	        bmd.setPixel(p.x, p.y, colors[i].r, colors[i].g, colors[i].b)
	    }
	    
	    i = Phaser.Math.wrapValue(i, 1, 359)
	
	}
}