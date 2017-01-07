
package examples.groups

import Koala.initKoala
import Phaser.*

class ForEach: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	var spriteAlphaIncSpeed = mutableMapOf<Sprite,Double> ()
	var Sprite.alphaIncSpeed:Double
		get() {
			return spriteAlphaIncSpeed.get(this)!!
		}
		set(value) { spriteAlphaIncSpeed.put(this, value) }

	var baseAlphaIncSpeed = 0.006
	
	override fun preload() {
	    game.load.spritesheet("item", "assets/buttons/number-buttons-90x90.png", 90, 90)
	}
	
	override fun create() {
	
	    for(i in 0..3-1)
	    {
	        //  Note: alphaIncSpeed is a property we"re adding to Phaser.Sprite, not a pre-existing one
	        game.add.sprite(290, 98 * (i + 1), "item", i).alphaIncSpeed = baseAlphaIncSpeed * (i + 1)
	        game.add.sprite(388, 98 * (i + 1), "item", i + 3).alphaIncSpeed = baseAlphaIncSpeed * (i + 4)
	    }
	
	}
	
	override fun update() {
	
	    // Animating alpha property of each item using.forEach(this::) method.
	    game.world.forEach( { item:Sprite ->

	        // Update alpha first.
	        item.alpha -= item.alphaIncSpeed
	
	        // Check for switch between increasing and descreasing.
	        if (item.alpha < 0.001 || item.alpha > 0.999)
	        {
	            item.alphaIncSpeed *= -1
	        }

	    })

	}
	
	override fun render() {
	
	    game.debug.text("Alpha of items is always changing.", 280, 480)
	
	}
}