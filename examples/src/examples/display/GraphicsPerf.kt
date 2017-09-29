
package examples.display


import Phaser.*

class GraphicsPerf: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	override fun create() {
	
	    //console.time("create")
	
	    var graphics = game.add.graphics(0, 0)
	
	    for(i in 0..1000-1)
	    {
	        graphics.beginFill(0x44447a)
	        graphics.moveTo(i, i)
	        graphics.lineTo(i + 1, i + 1)
	        graphics.lineTo(i + 2, i + 4)
	        graphics.lineTo(i + 3, i + 6)
	        graphics.lineTo(i + 4, i + 7)
	        graphics.lineTo(i, i)
	        graphics.endFill()
	    }
	
	    //console.timeEnd("create")
	
	}
}