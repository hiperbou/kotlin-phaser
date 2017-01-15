
package examples.display

import Koala.initKoala
import Phaser.*

class Graphics2: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create })
	
	override fun create() {
	
	    var graphics = game.add.graphics(300, 200)
	
	    graphics.lineStyle(1, 0xff0000, 1)
	    graphics.moveTo(0, 0)  
	    graphics.lineTo(100, 0)
	
	    graphics.lineStyle(1, 0x00ff00, 1)
	    graphics.moveTo(100, 0)  
	    graphics.lineTo(100, 100)
	
	    graphics.lineStyle(1, 0x0000ff, 1)
	    graphics.moveTo(100, 100)  
	    graphics.lineTo(0, 100)
	
	    graphics.lineStyle(1, 0xff00ff, 1)
	    graphics.moveTo(0, 100)  
	    graphics.lineTo(0, 0)
	
	}
}