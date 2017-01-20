
package examples.time


import Phaser.*

class BasicTimedEvent: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("bisley", "assets/pics/alex-bisleys_horsy_5.png")
	
	}
	
	lateinit var picture:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#6688ee"
	
	    picture = game.add.sprite(game.world.centerX, game.world.centerY, "bisley")
	    picture.anchor.setTo(0.5, 0.5)
	
	    //  Here we"ll create a basic timed event. This is a one-off event, it won"t repeat or loop:
	    //  The first parameter is how long to wait before the event fires. In this case 4 seconds (you could pass in 4000 as the value as well.)
	    //  The next parameter is the fun to call ("fadePicture") and finally the context under which that will happen.
	
	    game.time.events.add(Phaser.Timer.SECOND * 4, this::fadePicture, this)
	
	}
	
	fun fadePicture() {
	
	    game.add.tween(picture).to( object{ var  alpha= 0 }, 2000, Phaser.Easing.Linear::None, true)
	
	}
	
	override fun render() {
	
	    game.debug.text("Time until event: " + game.time.events.duration, 32, 32)
	
	}
}