
package examples.display


import Phaser.*
import kotlin.browser.window

class GraphicsExample: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create })
	
	override fun create() {
	
	    var graphics = game.add.graphics(100, 100)
	
	    // set a fill and line style
	    graphics.beginFill(0xFF3300)
	    graphics.lineStyle(10, 0xffd900, 1)
	    
	    // draw a shape
	    graphics.moveTo(50,50)
	    graphics.lineTo(250, 50)
	    graphics.lineTo(100, 100)
	    graphics.lineTo(250, 220)
	    graphics.lineTo(50, 220)
	    graphics.lineTo(50, 50)
	    graphics.endFill()
	    
	    // set a fill and line style again
	    graphics.lineStyle(10, 0xFF0000, 0.8)
	    graphics.beginFill(0xFF700B, 1)
	    
	    // draw a second shape
	    graphics.moveTo(210,300)
	    graphics.lineTo(450,320)
	    graphics.lineTo(570,350)
	    graphics.quadraticCurveTo(600, 0, 480,100)
	    graphics.lineTo(330,120)
	    graphics.lineTo(410,200)
	    graphics.lineTo(210,300)
	    graphics.endFill()
	    
	    // draw a rectangle
	    graphics.lineStyle(2, 0x0000FF, 1)
	    graphics.drawRect(50, 250, 100, 100)
	    
	    // draw a circle
	    graphics.lineStyle(0)
	    graphics.beginFill(0xFFFF0B, 0.5)
	    graphics.drawCircle(470, 200, 200)
	    graphics.endFill()
	
	    graphics.lineStyle(20, 0x33FF00)
	    graphics.moveTo(30,30)
	    graphics.lineTo(600, 300)
	
	    //window.graphics = graphics //@todo ????
	
	}
}