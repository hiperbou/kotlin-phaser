
package examples.video

import Koala.initKoala
import Phaser.*

class LoadAsBlob: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.add.text(100, 100, "Loading videos ...", object{ var  font= "65px Arial";  var  fill= "#ff0044" })
	
	    game.load.video("space", "assets/video/wormhole.mp4", "canplaythrough", true)
	
	}
	
	lateinit var video:Video
	
	override fun create() {
	
	    video = game.add.video("space")
	
	    video.play(true)
	
	    //  x, y, anchor x, anchor y, scale x, scale y
	    video.addToWorld()
	
	}
}