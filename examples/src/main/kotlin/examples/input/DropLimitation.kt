
package examples.input


import Phaser.*

class DropLimitation: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var render=render})
	
	override fun preload() {
	    game.load.spritesheet("item", "assets/buttons/number-buttons-90x90.png", 90, 90)
	}
	
	override fun create() {
	
	    // Add some items to left side, and set a onDragStop listener
	    // to limit its location when dropped.
	
	    var item:Sprite
	
	    for(i in 0..6-1)
	    {
	        // Directly create sprites on the left group.
	        item = game.add.sprite(90, 90 * i, "item", i)
	
	        // Enable input detection, then it"s possible be dragged.
	        item.inputEnabled = true
	
	        // Make this item draggable.
	        item.input.enableDrag()
	        
	        // Then we make it snap to left and right side,
	        // also we make it only snap when released.
	        item.input.enableSnap(90, 90, false, true)
	
	        // Limit drop location to only the 2 columns.
	        item.events.onDragStop.add(this::fixLocation)
	    }
	}
	
	override fun render() {
	
	    game.debug.text("Group Left.", 100, 560)
	    game.debug.text("Group Right.", 280, 560)
	
	}
	
	fun fixLocation(item:Sprite) {
	
	    // Move the items when it is already dropped.
	    if (item.x < 90) {
	        item.x = 90.0
	    }
	    else if (item.x > 180 && item.x < 270) {
	        item.x = 180.0
	    }
	    else if (item.x > 360) {
	        item.x = 270.0
	    }
	
	}
}