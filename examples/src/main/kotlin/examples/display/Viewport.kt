
package examples.display


import Phaser.*
import kotlinx.browser.window
import kotlin.browser.window

class Viewport: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update;  var  render= render })
	
	override fun create() {
	
	    game.stage.backgroundColor = "#440e62"
	
	}
	
	override fun update() {
	
	}
	
	override fun render() {
	
	    var x = 32
	    var y = 0
	    var yi = 32

		y += yi
	    game.debug.text("Viewport", x, y)
	
	    //game.debug.text("Viewport Width: " + game.scale.v.viewportWidth, x, y += yi)
		y += yi
	    game.debug.text("window.innerWidth: " + window.innerWidth, x, y)
		y += yi
	    game.debug.text("window.outerWidth: " + window.outerWidth, x, y)
	
	    ///game.debug.text("Viewport Height: " + game.scale.viewportHeight, x, y += yi)
		y += yi
	    game.debug.text("window.innerHeight: " + window.innerHeight, x, y)
		y += yi
	    game.debug.text("window.outerHeight: " + window.outerHeight, x, y)

		y += yi*2
	    game.debug.text("Document", x, y)
	
	    //game.debug.text("Document Width: " + game.scale.documentWidth, x, y += yi)
	    //game.debug.text("Document Height: " + game.scale.documentHeight, x, y += yi)
	
	    //  Device: How to get device size.
	
	    //  Use window.screen.width for device width and window.screen.height for device height. 
	    //  .availWidth and .availHeight give you the device size minus UI taskbars. (Try on an iPhone.) 
	    //  Device size is static and does not change when the page is resized or rotated.
	
	    x = 350
	    y = 0

		y += yi
	    game.debug.text("Device", x, y)

		y += yi
	    game.debug.text("window.screen.width: " + window.screen.width, x, y)
		y += yi
	    game.debug.text("window.screen.availWidth: " + window.screen.availWidth, x, y)
		y += yi
	    game.debug.text("window.screen.height: " + window.screen.height, x, y)
		y += yi
	    game.debug.text("window.screen.availHeight: " + window.screen.availHeight, x, y)
	
	}
}