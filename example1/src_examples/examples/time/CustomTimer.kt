
package examples.time


import Phaser.*

class CustomTimer: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("picture7", "assets/pics/slayer-sorry_im_the_beast.png")
	
	}
	
	lateinit var timer:Timer
	var total = 0
	
	override fun create() {
	
	    game.stage.backgroundColor = "#000"
	
	    //  Create our Timer
	    timer = game.time.create(false)
	
	    //  Set a TimerEvent to occur after 2 seconds
	    timer.loop(2000, this::updateCounter, this)
	
	    //  Start the timer running - this is important!
	    //  It won"t start automatically, allowing you to hook it to button events and the like.
	    timer.start()
	
	}
	
	fun updateCounter() {
	
	    total++
	
	}
	
	override fun render() {
	
	    game.debug.text("Time until event: " + timer.duration, 32, 32)
	    game.debug.text("Loop Count: " + total, 32, 64)
	
	}
}