
package examples.buttons

import Koala.initKoala
import Phaser.*

class DisableButtonOnClick: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("button", "assets/buttons/button_sprite_sheet.png", 193, 71)
	
	}
	
	lateinit var button:Button
	
	override fun create() {
	
	    game.stage.backgroundColor = "#182d3b"
	
	    button = game.add.button(game.world.centerX - 95, 400, "button", this::actionOnClick, this, 2, 1, 0)
	
	    button.onInputOver.add(this::over, this)
	    button.onInputOut.add(this::out, this)
	
	}
	
	fun over() {
	    console.log("button over")
	}
	
	fun out() {
	    console.log("button out")
	}
	
	fun actionOnClick () {
	
	    console.log("click")
	
	    button.inputEnabled = false
	
	    // game.canvas.style.cursor = "default"
	
	}
}