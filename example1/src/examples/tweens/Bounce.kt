
package examples.tweens

import Koala.initKoala
import Phaser.*

class Bounce: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("ball", "assets/sprites/yellow_ball.png")
	
	}
	
	lateinit var ball:Sprite
	
	override fun create() {
	
	    ball = game.add.sprite(300, 0, "ball")
	
	    startBounceTween()
	}
	
	fun startBounceTween() {
	
	    ball.y = 0.0
	
	    var bounce=game.add.tween(ball)
	
	    bounce.to(object{ var  y= game.world.height-ball.height }, 1000 + Math.random() * 3000, Phaser.Easing.Bounce::In)
	    bounce.onComplete.add(this::startBounceTween, this)
	    bounce.start()
	
	}
}