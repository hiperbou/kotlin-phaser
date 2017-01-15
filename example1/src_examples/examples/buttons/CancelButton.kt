
package examples.buttons

import Koala.initKoala
import Phaser.*

class CancelButton: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("button", "assets/buttons/button_sprite_sheet.png", 193, 71)
	    game.load.image("background","assets/misc/starfield.jpg")
	
	}
	
	lateinit var button:Button
	lateinit var background:TileSprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#182d3b"
	
	    background = game.add.tileSprite(0, 0, 800, 600, "background")
	
	    button = game.add.button(game.world.centerX - 95, 400, "button", this::onUp, this, 2, 1, 0)
	
	}
	
	fun onUp(button:Button, pointer:Pointer, isOver:Boolean) {
	
	    //  In this example if the Pointer is no longer over the Button, then we"ll treat it
	    //  as if the user cancelled the operation and didn"t want to press the Button after all
	
	    if (isOver)
	    {
	        background.visible =! background.visible
	    }
	}
}