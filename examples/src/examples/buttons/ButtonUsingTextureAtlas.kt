
package examples.buttons


import Phaser.*

class ButtonUsingTextureAtlas: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.atlas("button", "assets/buttons/button_texture_atlas.png", "assets/buttons/button_texture_atlas.json")
	    game.load.image("background","assets/misc/starfield.jpg")
	
	}
	
	lateinit var button:Button
	lateinit var background:TileSprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#182d3b"
	
	    background = game.add.tileSprite(0, 0, 800, 600, "background")
	
	    button = game.add.button(game.world.centerX - 95, 400, "button", this::actionOnClick, this, "over", "out", "down")
	
	    button.onInputOver.add(this::over, this)
	    button.onInputOut.add(this::out, this)
	
	}
	
	fun over() {
	    console.log("button over")
	}
	
	fun out() {
	    console.log("button out")
	}
	
	fun actionOnClick (b:Button) {
	
	    background.visible =! background.visible
	
	}
}