
package examples.input

import Koala.initKoala
import Phaser.*

class InputOrder: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	var text = ""
	
	override fun preload() {
	
	    game.load.image("block", "assets/sprites/block.png")
	
	}
	
	override fun create() {
	
	    //  When you click a Sprite, the top-most one in the display list,
	    //  i.e. the one created LAST, will receive the input event.
	    //  Not the ones below it.
	
	    for(i in 0..10-1)
	    {
	        var sprite = game.add.sprite(64 + (64 * i), 200 + (i*4), "block")
	
	        sprite.name = "block" + i
	
	        sprite.inputEnabled = true
	
	        sprite.events.onInputDown.add(this::clickedSprite, this)
	    }
	
	}
	
	fun clickedSprite(sprite:Sprite) {
	
	    text = sprite.name + " RenderOrderID: " + sprite.renderOrderID
	
	    sprite.tint = 0xff0000
	
	}
	
	override fun render() {
	
	    if (text === "")
	    {
	        game.debug.text("Click the Sprites", 32, 32)
	    }
	    else
	    {
	        game.debug.text("You clicked: " + text, 32, 32)
	    }
	
	}
}