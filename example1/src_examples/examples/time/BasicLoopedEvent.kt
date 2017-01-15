
package examples.time

import Koala.initKoala
import Phaser.*

class BasicLoopedEvent: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("ball", "assets/sprites/pangball.png")
	
	}
	
	var counter = 0
	lateinit var text:Text
	
	override fun create() {
	
	    game.stage.backgroundColor = "#6688ee"
	
	    text = game.add.text(game.world.centerX, game.world.centerY, "Counter: 0", object{ var  font= "64px Arial";  var  fill= "#ffffff";  var  align= "center" })
	    text.anchor.setTo(0.5, 0.5)
	
	    //  Here we"ll create a basic looped event.
	    //  A looped event is like a repeat event but with no limit, it will literally repeat itself forever, or until you stop it.
	
	    //  The first parameter is how long to wait before the event fires. In this case 1 second (you could pass in 1000 as the value as well.)
	    //  The next two parameters are the fun to call ("updateCounter") and the context under which that will happen.
	
	    game.time.events.loop(Phaser.Timer.SECOND, this::updateCounter, this)
	
	}
	
	fun updateCounter() {
	
	    counter++
	
	    text.setText("Counter: " + counter)
	
	}
	
	override fun render() {
	
	    game.debug.text("Time until event: " + game.time.events.duration, 32, 32)
	    game.debug.text("Next tick: " + game.time.events.next, 32, 64)
	
	}
}