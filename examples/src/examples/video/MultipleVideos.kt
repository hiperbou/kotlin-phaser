
package examples.video


import Phaser.*

class MultipleVideos: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.add.text(100, 100, "Loading videos ...", object{ var  font= "65px Arial";  var  fill= "#ff0044" })
	
	    game.load.video("liquid", "assets/video/skull.mp4")
	    game.load.video("space", "assets/video/wormhole.mp4")
	
	}
	
	lateinit var video1:Video
	lateinit var video2:Video
	
	override fun create() {
	
	    video1 = game.add.video("space")
	    video2 = game.add.video("liquid")
	
	    video1.play(true)
	    video2.play(true)
	
	    //  x, y, anchor x, anchor y, scale x, scale y
	    video1.addToWorld(400, 300, 0.5, 0.5)
	
	    video2.addToWorld(780, 580, 1, 1, 0.5, 0.5)
	
	}
}