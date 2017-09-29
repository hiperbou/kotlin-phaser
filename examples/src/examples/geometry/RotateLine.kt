
package examples.geometry


import Phaser.*

class RotateLine: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update;  var  render= render })
	
	lateinit var line:Phaser.Line
	
	override fun create() {
	
	    game.stage.backgroundColor = "#011052"
	
	    line = Phaser.Line(300, 100, 500, 500)
	
	}
	
	override fun update() {
	
	    line.rotate(1, true)
	 
	}
	
	override fun render() {
	
	    game.debug.geom(line)
	
	}
}