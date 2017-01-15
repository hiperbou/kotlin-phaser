
package examples.tweens

import Koala.initKoala
import Phaser.*

class TweenSeveralProperties: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("sky", "assets/skies/sky4.png")
	    game.load.spritesheet("phaser", "assets/tests/tween/phaser.png", 70, 90)
	    
	}
	
	override fun create() {
	
	    game.add.sprite(0, 0, "sky")
	
	    var item:Sprite
	
	    for(i in 0..6-1)
	    {
	        item = game.add.sprite(190 + 69 * i, -100, "phaser", i)
	        item.anchor.setTo(0.5,0.5)
	
	        // Add a simple bounce tween to each character"s position.
	        game.add.tween(item).to(object{ var y= 240}, 2400, Phaser.Easing.Bounce::Out, true, 1000 + 400 * i, 0)
	
	        // Add another rotation tween to the same character.
	        game.add.tween(item).to(object{ var angle= 360}, 2400, Phaser.Easing.Cubic::In, true, 1000 + 400 * i, 0)
	    }
	
	}
}