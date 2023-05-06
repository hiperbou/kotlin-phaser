
package examples.buttons


import Phaser.*

class ChangingTheFrames: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("button", "assets/buttons/number-buttons-90x90.png", 90,90)
	    game.load.image("background","assets/misc/starfield.jpg")
	
	}
	
	lateinit var button:Button
	
	
	override fun create() {
	
	    //  Setting the background colour
	    game.stage.backgroundColor = "#182d3b"
	
	    // The numbers given in parameters are the indexes of the frames, in this order: over, out, down
	    button = game.add.button(game.world.centerX, game.world.centerY, "button", this::actionOnClick, this, 1, 0, 2)
	
	    //  setting the anchor to the center
	    button.anchor.setTo(0.5, 0.5)
	
	}
	
	fun actionOnClick () {
	    
	    //  Manually changing the frames of the button, i.e, how it will look when you play with it
	    button.setFrames(4, 3, 5)
	
	}
}