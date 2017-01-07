
package examples.time

import Koala.initKoala
import Phaser.*

class BasicRepeatEvent: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("ball", "assets/sprites/pangball.png")
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = "#6688ee"
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.physics.arcade.gravity.y = 150.0
	
	    //  Here we"ll create a basic repeating event.
	
	    //  The way a repeating event works is that it is placed into the queue once, 
	    //  and when it runs its "repeatCounter" is reduced by 1 and it"s moved back into the queue again.
	    //  To this end the queue will only ever have 1 event actually in it.
	
	    //  The first parameter is how long to wait before the event fires. In this case 2 seconds (you could pass in 2000 as the value as well.)
	    //  The second parameter is how many times the event will run in total. Here we"ll run it 10 times.
	    //  The next two parameters are the fun to call ("createBall") and the context under which that will happen.
	
	    //  Once the event has been called 10 times it will never be called again.
	
	    game.time.events.repeat(Phaser.Timer.SECOND * 2,  10, this::createBall, this)
	
	}
	
	fun createBall() {
	
	    //  A bouncey ball sprite just to visually see what"s going on.
	
	    var ball = game.add.sprite(game.world.randomX, 0, "ball")
	
	    game.physics.enable(ball, Phaser.Physics.ARCADE)
	
	    ball.body.bounce.y = 0.9
	    ball.body.collideWorldBounds = true
	
	}
	
	override fun render() {
	
	    game.debug.text("Time until event: " + game.time.events.duration, 32, 32)
	    game.debug.text("Next tick: " + game.time.events.next, 32, 64)
	
	}
}