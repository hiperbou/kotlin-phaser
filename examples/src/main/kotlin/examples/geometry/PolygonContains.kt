
package examples.geometry


import Phaser.*

class PolygonContains: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update;  var  render= render })
	
	lateinit var poly:Polygon
	lateinit var graphics:Graphics
	
	override fun create() {
	
	    poly = Phaser.Polygon(arrayOf(Phaser.Point(200, 100), Phaser.Point(350, 100), Phaser.Point(375, 200), Phaser.Point(150, 200) ))
	
	    graphics = game.add.graphics(0, 0)
	
	    graphics.beginFill(0xFF33ff)
	    graphics.drawPolygon(poly.points)
	    graphics.endFill()
	
	}
	
	override fun update() {
	
	    graphics.clear()
	
	    if (poly.contains(game.input.x, game.input.y))
	    {
	        graphics.beginFill(0xFF3300)
	    }
	    else
	    {
	        graphics.beginFill(0xFF33ff)
	    }
	
	    graphics.drawPolygon(poly.points)
	    graphics.endFill()
	
	}
	
	override fun render() {
	
	    game.debug.text(game.input.x.toString() + " x " + game.input.y, 32, 32)
	
	}
}