
package examples.video

import Koala.initKoala
import Phaser.*

class TakeSnapshotFromStream: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	lateinit var video:Video
	
	override fun create() {
	
	    //  No properties at all means we"ll create a video stream from a webcam
	    video = game.add.video()
	
	    //  If access to the camera is allowed
	    video.onAccess.add(this::camAllowed, this)
	
	    //  If access to the camera is denied
	    video.onError.add(this::camBlocked, this)
	
	    //  As soon as the stream starts this will fire
	    video.onPlay.add(this::takeSnapshot, this)
	
	    //  Start the stream
	    video.startMediaStream()
	
	}
	
	fun camAllowed() {
	
	    var cam = video.addToWorld()
	    cam.scale.set(0.5)
	
	    var grab = video.snapshot.addToWorld(game.width, game.height)
	    grab.anchor.set(1)
	
	    game.add.text(400, 32, "Click to grab", TextStyle(font="bold 26px Arial",fill="#ffffff" ))
	
	    game.input.onDown.add(this::takeSnapshot, this)
	
	}
	
	fun camBlocked(video:Video, error:Any) {
	
	    console.log("Camera was blocked", video, error)
	
	}
	
	fun takeSnapshot() {
	
	    video.grab()
	
	    // grab: fun (clear, alpha, blendMode) {
	    // video.grab(false, 0.5, "multiply")
	    // video.grab(false, 1, "overlay")
	
	}
}