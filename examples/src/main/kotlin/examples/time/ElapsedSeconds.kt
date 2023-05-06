
package examples.time


import Phaser.*

class ElapsedSeconds: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("picture7", "assets/pics/slayer-sorry_im_the_beast.png")
	
	}
	
	// lateinit var timer:Timer
	// var total = 0
	
	override fun create() {
	
	    // game.stage.backgroundColor = "#000"
	
	}
	
	fun updateCounter() {
	
	}
	
	override fun render() {
	
	    game.debug.text("Elapsed seconds: " + game.time.totalElapsedSeconds(), 32, 32)
	
	}
}