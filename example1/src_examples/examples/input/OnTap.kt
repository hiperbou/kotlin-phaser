
package examples.input

import Koala.initKoala
import Phaser.*

class OnTap: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("TheEnd", "assets/pics/TheEnd_by_Iloe_and_Made.jpg")
	    game.load.image("BountyHunter", "assets/pics/Bounty_Hunter_by_Anathematixs_Desire.png")
	
	}
	
	lateinit var pic:Sprite
	
	override fun create() {
	
	    pic = game.add.sprite(game.world.centerX, game.world.centerY, "TheEnd")
	    pic.alpha = 0.5
	    pic.anchor.set(0.5)
	    pic.scale.set(0.6)
	
	    game.add.text(16, 16, "tap or double-tap the image", object{ var  font= "32px Arial";  var  fill= "#ffffff" })
	
	    game.input.onTap.add(this::onTap, this)
	
	}
	
	fun onTap(pointer:Pointer, doubleTap:Boolean) {
	
	    if (doubleTap)
	    {
	        //  They double-tapped, so swap the image
	        if (pic.key === "TheEnd")
	        {
	            pic.loadTexture("BountyHunter")
	        }
	        else
	        {
	            pic.loadTexture("TheEnd")
	        }
	    }
	    else
	    {
	        //  A single tap (tap duration was < game.input.tapRate) so change alpha
	        pic.alpha = if (pic.alpha == 0.5)  1.0 else 0.5
	    }
	
	}
}