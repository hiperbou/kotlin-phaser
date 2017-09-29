
package examples.buttons


import Phaser.*
import kotlin.browser.window

class RotatedButtons: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var update = update })
	
	override fun preload() {
	
	    game.load.spritesheet("button", "assets/buttons/button_sprite_sheet.png", 193, 71)
	    game.load.image("background","assets/misc/starfield.jpg")
	
	}
	
	lateinit var button:Button
	
	
	override fun create() {
	
	    game.stage.backgroundColor = "#cccccc"
	
	    //	The numbers given in parameters are the indexes of the frames, in this order: over, out, down
	    button = game.add.button(game.world.centerX, game.world.centerY, "button", this::actionOnClick, this, 2, 1, 0)
	
	    //	Set the anchor of the sprite in the center, otherwise it would rotate around the top-left corner
	    button.anchor.setTo(0.5, 0.5)
	
	}
	
	fun actionOnClick () {
	    
	    window.alert("Though I'm turning around, you can still click on me")
	
	}
	
	override fun update() {
	    
	    button.angle += 1
	    
	}
}