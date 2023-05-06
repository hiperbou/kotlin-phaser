
package examples.tweens


import Phaser.*

class Repeat: State() {
	
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
	
	    //  Create our tween. This will fade the sprite to alpha 1 over the duration of 2 seconds
	    var tween = game.add.tween(sprite).to( object{ var  alpha= 1 }, 2000, "Linear", true)
	
	    //  And this tells it to repeat, i.e. fade in again 10 times.
	    //  The 1000 tells it to wait for 1 second before restarting the fade.
	    tween.repeat(10, 1000)
	
	}
}