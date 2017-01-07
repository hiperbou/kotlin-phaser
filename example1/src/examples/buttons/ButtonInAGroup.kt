
package examples.buttons

import Koala.initKoala
import Phaser.*

class ButtonInAGroup: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("button", "assets/buttons/button_sprite_sheet.png", 193, 71)
	    game.load.image("background","assets/misc/starfield.jpg")
	
	}
	
	lateinit var group:Group
	
	override fun create() {
	
	    game.add.tileSprite(0, 0, 800, 600, "background")
	
	    group = game.add.group()
	
	    var button = game.make.button(game.world.centerX - 95, 400, "button", this::removeGroup, this, 2, 1, 0)
	
	    //window.rich = button
	
	    button.onInputOver.add(this::over, this)
	    button.onInputOut.add(this::out, this)
	
	    // game.input.onDown.add(this::removeGroup, this)
	
	    group.add(button)
	
	}
	
	fun removeGroup() {
	
	    game.world.remove(group)
	
	    // group.destroy()
	
	}
	
	fun over() {
	    console.log("button over")
	}
	
	fun out() {
	    console.log("button out")
	}
	
	fun actionOnClick () {
	
	    console.log("button clicked")
	
	}
}