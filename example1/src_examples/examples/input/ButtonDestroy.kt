
package examples.input


import Phaser.*

class ButtonDestroy: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("button", "assets/buttons/button_sprite_sheet.png", 193, 71)
	
	}
	
	lateinit var button:Button
	lateinit var text:Text
	override fun create() {
	
	    game.stage.backgroundColor = "#4b0049"
	
	    button = game.add.button(game.world.centerX - 95, 460, "button", this::nukeButton, this, 2, 1, 0)
	
	}
	
	fun nukeButton() {
	
	    button.pendingDestroy = true
	
	    text = game.add.text(game.world.centerX, game.world.centerY, "- button nuked -", object{ var  font= "64px Arial";  var  fill= "#ffffff" })
	
	    text.anchor.set(0.5)
	
	}
}