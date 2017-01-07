
package examples.tweens

import Koala.initKoala
import Phaser.*

class Easing: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("shadow", "assets/tests/tween/shadow.png", 138, 15)
	    game.load.spritesheet("phaser", "assets/tests/tween/phaser.png", 70, 90)
	    
	}
	
	override fun create() {
	
	    var item:Sprite
	    var shadow:Sprite
	    var tween:Tween
	
	    // Sets background color to white.
	    game.stage.backgroundColor = "#ffffff"
	
	    for(i in 0..6-1)
	    {
	        // Add a shadow to the location which characters will land on.
	        // And tween their size to make them look like a real shadow.
	        // Put the following code before items to give shadow a lower
	        // render order.
	        shadow = game.add.sprite(190 + 69 * i, 284, "shadow")
	
	        // Set shadow"s size 0 so that it"ll be invisible at the beginning.
	        shadow.scale.setTo(0.0, 0.0)
	
	        // Also set the origin to the center since we don"t want to
	        // see the shadow scale to the left top.
	        shadow.anchor.setTo(0.5, 0.5)
	        game.add.tween(shadow.scale).to(object{ var x= 1.0;  var  y= 1.0}, 2400, Phaser.Easing.Bounce::Out, true)
	
	        // Add characters on top of shadows.
	        item = game.add.sprite(190 + 69 * i, -50, "phaser", i)
	
	        // Set origin to the center to make the rotation look better.
	        item.anchor.setTo(0.5, 0.5)
	
	        // Add a simple bounce tween to each character"s position.
	        tween = game.add.tween(item).to( object{ var  y= 245 }, 2400, Phaser.Easing.Bounce::Out, true)
	    }
	
	}
}