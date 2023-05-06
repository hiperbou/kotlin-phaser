
package examples.geometry


import Phaser.*

class CenterLine: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update;  var  render= render })
	
	lateinit var line:Line
	
	override fun create() {
	
	    game.stage.backgroundColor = "#124184"
	
	    line = Phaser.Line(100, 100, 200, 200)
	
	}
	
	override fun update() {
	
	    line.centerOn(game.input.activePointer.x, game.input.activePointer.y)
	    line.rotate(0.05)
	 
	}
	
	override fun render() {
	
	    game.debug.geom(line)
	    game.debug.lineInfo(line, 32, 32)
	
	}
}