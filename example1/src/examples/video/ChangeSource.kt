
package examples.video

import Koala.initKoala
import Phaser.*

class ChangeSource: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.video("liquid", "assets/video/liquid2.mp4")
	
	}
	
	lateinit var video:Video
	lateinit var sprite:Image
	
	override fun create() {
	
	    video = game.add.video("liquid")
	
	    video.onPlay.addOnce(this::start, this)
	
	    sprite = video.addToWorld(400, 300, 0.5, 0.5)
	
	    video.play()
	
	}
	
	fun start() {
	
	    //  After 5 seconds we"ll swap to a video
	    game.time.events.add(5000, this::changeSource, this)
	
	    //  This would swap on a mouse click
	    // game.input.onDown.add(this::changeSource, this)
	
	}
	
	fun changeSource() {
	
	    video.changeSource("assets/video/skull.mp4")
	
	}
	
	override fun render() {
	
	    game.debug.text("Video width: " + video.video.videoWidth, 600, 32)
	    game.debug.text("Video height: " + video.video.videoHeight, 600, 64)
	
	    game.debug.text("Video Time: " + video.currentTime, 32, 32)
	    game.debug.text("Video Duration: " + video.duration, 32, 64)
	
	}
}