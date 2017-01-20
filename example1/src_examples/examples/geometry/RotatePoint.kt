
package examples.geometry


import Phaser.*

class RotatePoint: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var create= create;  var  update= update;  var  render= render })
	
	lateinit var p1:Phaser.Point
	lateinit var p2:Phaser.Point
	
	override fun create() {
	
	    p1 = Phaser.Point(300, 300)
	    p2 = Phaser.Point(400, 300)
	
	}
	
	override fun update() {
	
	    //  We"ll rotate point 1 (the yellow point)
	    //  around point 2 (the red point) by 1 degree
	    //  every update.
	
	    // rotate: fun (x, y, angle, asDegrees, distance) {
	    // p1.rotate(p2.x, p2.y, 1, true, 200)
	    p1.rotate(p2.x, p2.y, 1, true)
	
	}
	
	override fun render() {
	
	    game.context.fillStyle = "rgb(255,255,0)"
	    game.context.fillRect(p1.x, p1.y, 4.0, 4.0)
	
	    game.context.fillStyle = "rgb(255,0,0)"
	    game.context.fillRect(p2.x, p2.y, 4.0, 4.0)
	
	}
}