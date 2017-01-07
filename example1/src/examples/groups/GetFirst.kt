
package examples.groups

import Koala.initKoala
import Phaser.*

class GetFirst: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("item", "assets/buttons/number-buttons-90x90.png", 90, 90)
	    game.load.image("reviveBtn", "assets/buttons/revive-button.png")
	    
	}
	
	var timer = 0.0
	var cycle = 0.0
	
	override fun create() {
	
	    // Add some items.
	    var item:Sprite
	
	    for(i in 0..3-1)
	    {
	        // Give the items a different alpha increase speed.
	        item = game.add.sprite(290, 98 * (i + 1), "item", i)
	
	        // An item beside the left one.
	        item = game.add.sprite(388, 98 * (i + 1), "item", i + 3)
	    }
	
	    // Set a timer so we can perform an action after a delay.
	    timer = 0.0
	    cycle = 1000.0
	    
	}
	
	override fun update() {
	    
	    if (game.time.now > timer)
	    {
	        // Update timer.
	        timer = game.time.now + cycle
	        
	        // Get the first alive item and kill it.
	        var item = game.world.getFirstAlive<Sprite>()
	
	        if (item != null)
	        {
	            item.kill()
	        }
	
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("One item will be killed each second.", 280, 420)
	
	    // Get living and dead number of a group.
	    game.debug.text("Living: " + game.world.countLiving() + ", Dead: " + game.world.countDead(), 330, 440)
	    
	}
}