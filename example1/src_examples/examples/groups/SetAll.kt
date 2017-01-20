
package examples.groups


import Phaser.*

class SetAll: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	var spriteAlphaIncSpeed = mutableMapOf<Sprite,Double> ()
	var Sprite.alphaIncSpeed:Double
		get() {
			return spriteAlphaIncSpeed.get(this)!!
		}
		set(value:Double) { spriteAlphaIncSpeed.put(this, value) }

	var baseIncSpeed= 0.006
	
	override fun preload() {
	    game.load.spritesheet("item", "assets/buttons/number-buttons-90x90.png", 90, 90)
	}
	
	override fun create() {
	
	    // Add some items.
	    for(i in 0..3-1)
	    {
	        // Give the items a different alpha increase speed.
	        game.add.sprite(290, 98 * (i + 1), "item", i).alphaIncSpeed = baseIncSpeed * (i + 1)
	        game.add.sprite(388, 98 * (i + 1), "item", i + 3).alphaIncSpeed = baseIncSpeed * (i + 4)
	    }
	
	    game.input.onTap.add(this::resetAlpha,this)
	
	}
	
	fun resetAlpha() {
	
	    // Set "alpha" value of all the childs.
	    game.world.setAll("alpha", Math.random())
	
	}
	
	override fun render() {
	
	    game.debug.text("Tap or click to set random alpha of all the items.", 240, 480)
	    
	}
}