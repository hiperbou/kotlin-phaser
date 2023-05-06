
package examples.tweens


import Phaser.*

class EasingSpritesheets: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var preload=preload;  var create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("phaser", "assets/tests/tween/phaser.png", 70, 90)
	    game.load.image("starfield", "assets/misc/starfield.jpg")
	    
	}
	
	override fun create() {
	
	    var item:Sprite
	
	    game.add.tileSprite(0, 0, 800, 600, "starfield")
	
	    for(i in 0..6-1)
	    {
	        item = game.add.sprite(190 + 69 * i, -90, "phaser", i)
	
	        // Add a simple bounce tween to each character"s position.
	        game.add.tween(item).to(object{ var y= 240}, 2400, Phaser.Easing.Bounce::Out, true, 1000 + 400 * i, 0)
	    }
	
	}
}