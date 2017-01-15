
package examples.video

import Koala.initKoala
import Phaser.*

class SnapshotBlendMode: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	lateinit var video:Video
	lateinit var bmd:BitmapData
	var alpha:dynamic = object{ public var  alpha = 0.2 }
	
	override fun preload() {
	
	    game.load.image("swirl", "assets/pics/swirl1.jpg")
	
	}
	
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
	
	fun camAllowed() {
	
	    bmd = game.add.bitmapData(video.width, video.height)
	    bmd.addToWorld(game.world.centerX, game.world.centerY, 0.5, 0.5)
	
	    //  Grab a frame every 50ms
	    game.time.events.loop(50, this::takeSnapshot, this)
	
	    game.add.tween(alpha).to( object{ var  alpha= 0.5 }, 1000, "Cubic.easeInOut", true, 0, -1, true)
	
	}
	
	fun camBlocked(video:Video, error:Any) {
	
	    console.log("Camera was blocked", video, error)
	
	}
	
	fun takeSnapshot() {
	
	    if (bmd.width !== video.width || bmd.height !== video.height)
	    {
	        bmd.resize(video.width, video.height)
	    }
	
	    video.grab(true, alpha.alpha)
	
	    bmd.draw(video.snapshot)
	
	    bmd.draw("swirl", 0, 0, video.width, video.height, "color")
	
	}
}