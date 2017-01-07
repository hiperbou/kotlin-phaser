
package examples.tweens

import Koala.initKoala
import Phaser.*

class Bubbles: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("space", "assets/pics/thalion-rain.png")
	    game.load.image("ball", "assets/particles/bubble256.png")
	    
	}
	
	lateinit var bg:TileSprite
	
	override fun create() {
	
	    bg = game.add.tileSprite(0, 0, 800, 600, "space")
	
	    var delay = 0
	
	    for(i in 0..40-1)
	    {
	        var sprite = game.add.sprite(-100 + (game.world.randomX), 600, "ball")
	
	        sprite.scale.set(game.rnd.realInRange(0.1, 0.6))
	
	        var speed = game.rnd.between(4000, 6000)
	
	        game.add.tween(sprite).to(object{ var  y= -256 }, speed, Phaser.Easing.Sinusoidal::InOut, true, delay, 1000, false)
	
	        delay += 200
	    }
	
	}
	
	override fun update() {
	
	    bg.tilePosition.y += 0.4
	
	}
}