
package examples.video

import Koala.initKoala
import Phaser.*

class DolbyDigitalPlus: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.add.text(100, 100, "Loading videos ...", object{ var  font= "65px Arial";  var  fill= "#ff0044" })
	
	    game.load.video("dolby", "assets/video/MP4_HPL40_30fps_channel_id_51.mp4")
	
	}
	
	lateinit var video:Video
	
	override fun create() {
	
	    video = game.add.video("dolby")
	
	    video.play(true)
	
	    //  x, y, anchor x, anchor y, scale x, scale y
	    video.addToWorld(400, 300, 0.5, 0.5, 0.5, 0.5)
	
	}
}