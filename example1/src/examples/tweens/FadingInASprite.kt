
package examples.tweens

import Koala.initKoala
import Phaser.*

class FadingInASprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("space", "assets/misc/starfield.png", 138, 15)
	    game.load.image("logo", "assets/sprites/phaser2.png")
	    
	}
	
	override fun create() {
	
	    game.add.tileSprite(0, 0, 800, 600, "space")
	
	    var sprite = game.add.sprite(game.world.centerX, game.world.centerY, "logo")
	
	    sprite.anchor.setTo(0.5, 0.5)
	    sprite.alpha = 0.0
	
	    game.add.tween(sprite).to( object{ var  alpha= 1 }, 2000, Phaser.Easing.Linear::None, true, 0, 1000, true)
	
	}
}