
package examples.text


import Phaser.*

class TextGradient: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	lateinit var text:Text
	
	override fun create() {
	
	    text = game.add.text(game.world.centerX, game.world.centerY, "- phaser gradient text -")
	
	    //  Centers the text
	    text.anchor.set(0.5)
	    text.align = "center"
	
	    //  Our font + size
	    text.font = "Arial"
	    text.fontWeight = "bold"
	    text.fontSize = 70
	
	    //  Here we create a linear gradient on the Text context.
	    //  This uses the exact same method of creating a gradient as you do on a normal Canvas context.
	    var grd = text.context.createLinearGradient(0.0, 0.0, 0.0, text.height)
	
	    //  Add in 2 color stops
	    grd.addColorStop(0.0, "#8ED6FF")
	    grd.addColorStop(1.0, "#004CB3")
	
	    //  And apply to the Text
	    text.fill = grd
	
	}
}