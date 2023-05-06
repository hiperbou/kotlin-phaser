
package examples.display


import Phaser.*

class Ellipse: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create })
	
	override fun create() {
	
	    var graphics = game.add.graphics(game.world.centerX, game.world.centerY)
	
	    // var ellipse = Phaser.Ellipse(100, 100, 200, 60)
	
	    //  Our first arc will be a line only
	    graphics.lineStyle(8, 0xffd900)
	
	    graphics.drawEllipse(100, 100, 200, 60)
	
	    // graphics.arc(0, 0, 135, Phaser.getMath.degToRad(0), Phaser.getMath.degToRad(90), false)
	    
	    //  As we wish to draw a 2nd arc on the SAME Graphics object, we need to move the drawing operation
	    // graphics.moveTo(-100, -100)
	
	    //  This will reset the lineStyle
	    // graphics.lineStyle(0)
	
	    //  And this draws a filled arc
	    // graphics.beginFill(0xFF3300)
	
	    //  Note the "true" at the end, this tells it to draw anticlockwise
	    // graphics.arc(-100, -100, 135, Phaser.getMath.degToRad(0), Phaser.getMath.degToRad(90), true)
	
	    // graphics.endFill()
	
	}
}