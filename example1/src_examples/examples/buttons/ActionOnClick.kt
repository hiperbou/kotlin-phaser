
package examples.buttons


import Phaser.*

class ActionOnClick: State() {
	
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
	
	    button = game.add.button(game.world.centerX - 95, 400, "button", this::actionOnClick, this, 2, 1, 0)
	
	    button.onInputOver.add(this::over, this)
	    button.onInputOut.add(this::out, this)
	    button.onInputUp.add(this::up, this)
	
	}
	
	fun up() {
	    console.log("button up")
	}
	
	fun over() {
	    console.log("button over")
	}
	
	fun out() {
	    console.log("button out")
	}
	
	fun actionOnClick () {
	
	    background.visible =! background.visible
	
	}
}