
package examples.geometry


import Phaser.*

class RectangleIntersects: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update;  var  render= render })
	
	lateinit var rectA:Phaser.Rectangle
	lateinit var rectB:Phaser.Rectangle
	
	override fun create() {
	
	    rectA = Phaser.Rectangle(0, 0, 200, 100)
	    rectB = Phaser.Rectangle(100, 100, 500, 400)
	
	}
	
	override fun update() {
	
	    rectA.x = game.input.activePointer.x
	    rectA.y = game.input.activePointer.y
	
	}
	
	override fun render() {
	
	    game.debug.geom(rectA, "rgba(200,0,0,0.5)")
	    game.debug.geom(rectB, "rgba(0,0,255,0.5)")
	
	    var intersects = Phaser.Rectangle.intersection(rectA, rectB)
	
	    game.debug.geom(intersects, "rgba(255,0,0,1)")
	
	}
}