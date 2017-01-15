
package examples.input

import Koala.initKoala
import Phaser.*

class OutOfGameMouseUp: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("rain", "assets/pics/thalion-rain.png")
	    game.load.image("bubble", "assets/pics/bubble-on.png")
	
	}
	
	lateinit var bubble:Image
	
	override fun create() {
	
	    game.add.tileSprite(0, 0, 800, 600, "rain")
	
	    bubble = game.add.image(game.world.centerX, game.world.centerY, "bubble")
	    bubble.anchor.set(0.5)
	
	    bubble.inputEnabled = true
	
	    //  Even if you release the mouse button outside of the game window
	    //  the "onUp" fun will still be called.
	
	    bubble.events.onInputDown.add(this::onDown, this)
	    bubble.events.onInputUp.add(this::onUp, this)
	
	}
	
	fun onDown() {
	
	    bubble.alpha = 0.3
	
	}
	
	fun onUp() {
	
	    bubble.alpha = 1.0
	
	}
}