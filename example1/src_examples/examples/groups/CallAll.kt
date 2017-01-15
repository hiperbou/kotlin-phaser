
package examples.groups

import Koala.initKoala
import Phaser.*

class CallAll: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("item", "assets/buttons/number-buttons-90x90.png", 90, 90)
	    game.load.image("reviveBtn", "assets/buttons/revive-button.png")
	    
	}
	
	override fun create() {
	
	    // Add some items.
	    var item:Sprite
	
	    for(i in 0..3-1)
	    {
	        // Give the items a different alpha increase speed.
	        item = game.add.sprite(290, 98 * (i + 1), "item", i)
	
	        // Enable input.
	        item.inputEnabled = true
	        item.events.onInputUp.add(this::kill)
	
	        // An item besides the left one.
	        item = game.add.sprite(388, 98 * (i + 1), "item", i + 3)
	        item.inputEnabled = true
	        item.events.onInputUp.add(this::kill)
	    }
	
	    // Add a button to revive all the items.
	    game.add.button(270, 400, "reviveBtn", this::reviveAll, this, 0, 0, 0)
	
	}
	
	fun kill(item:Sprite) {
	
	    item.kill()
	
	}
	
	fun reviveAll() {
	
	    game.world.callAll("revive")
	
	}
	
	override fun render() {
	
	    game.debug.text("Tap or click an item to kill it", 160, 500)
	    game.debug.text("Press the Revive button to revive them all.", 160, 520)
	
	}
}