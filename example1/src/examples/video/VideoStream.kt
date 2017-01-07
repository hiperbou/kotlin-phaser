
package examples.video

import Koala.initKoala
import Phaser.*

class VideoStream: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	lateinit var video:Video
	lateinit var sprite:Image
	
	override fun create() {
	
	    //  No properties at all means we"ll create a video stream from a webcam
	    video = game.add.video()
	
	    //  If access to the camera is allowed
	    video.onAccess.add(this::camAllowed, this)
	
	    //  If access to the camera is denied
	    video.onError.add(this::camBlocked, this)
	
	    //  Start the stream
	    video.startMediaStream()
	
	}
	
	fun camAllowed(video:Video) {
	
	    console.log("--> camera was allowed", video)
	
	    sprite = video.addToWorld()
	
	    game.input.onDown.add(this::stopCam, this)
	
	}
	
	fun camBlocked(video:Video, error:Any) {
	
	    console.log("camera was blocked", video, error)
	
	}
	
	fun stopCam() {
	
	    console.log("camera stopped")
	
	    video.stop()
	
	}
}