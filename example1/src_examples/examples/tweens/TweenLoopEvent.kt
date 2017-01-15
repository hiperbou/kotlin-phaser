
package examples.tweens

import Koala.initKoala
import Phaser.*

class TweenLoopEvent: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("balls", "assets/sprites/balls.png", 17, 17)
	
	}
	
	lateinit var ball:Sprite
	lateinit var tween:Tween
	var bounces = 10
	
	override fun create() {
	
	    ball = game.add.sprite(400, 0, "balls", 0)
	
	    tween = game.add.tween(ball).to( object{ var  y= game.world.height - ball.height }, 1500, Phaser.Easing.Bounce::Out, true, 2500, bounces)
	
	    //	There is a 2.5 second delay at the start, then it calls this fun
	    tween.onStart.add(this::onStart, this)
	
	    //	This tween will repeat 10 times, calling this fun every time it loops
	    tween.onRepeat.add(this::onLoop, this)
	
	    //	When it completes it will call this fun
	    tween.onComplete.add(this::onComplete, this)
	
	}
	
	fun onStart() {
	
		//	Turn off the delay, so it loops seamlessly from here on
		tween.delay(0)
	
	}
	
	fun onLoop() {
	
		bounces--
	
		if (ball.frame === 5)
		{
			ball.frame = 0
		}
		else
		{
			ball.frame++
		}
	
	}
	
	fun onComplete() {
	
	    tween = game.add.tween(ball).to( object{ var  x= 800 - ball.width }, 2000, Phaser.Easing.Exponential::Out, true)
	
	}
	
	override fun render() {
	
		game.debug.text("Bounces: " + bounces, 32, 32)
	
	}
}