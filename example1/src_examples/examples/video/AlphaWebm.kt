
package examples.video


import Phaser.*

class AlphaWebm: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("pic", "assets/pics/thalion-rain.png")
	    game.load.video("space", "assets/video/alpha-webm.webm")
	    game.load.bitmapFont("desyrel", "assets/fonts/bitmapFonts/desyrel.png", "assets/fonts/bitmapFonts/desyrel.xml")
	
	}
	
	lateinit var video:Video
	lateinit var text:BitmapText
	
	override fun create() {
	
	    //  This only works in Chrome
	    //  No other browser supports webm files with alpha transparency (yet)
	
	    var pic = game.add.image(400, 300, "pic")
	    pic.anchor.set(0.5)
	    pic.scale.set(4)
	    pic.smoothed = false
	
	    text = game.add.bitmapText(400, 300, "desyrel", "Phaser\nAlpha Videos", 64)
	    text.anchor.set(0.5)
	    text.align = "center"
	
	    video = game.add.video("space")
	
	    video.play(true)
	
	    video.addToWorld(400, 300, 0.5, 0.5)
	
	}
	
	override fun update() {
	
	    text.text = "Phaser kicking\nAlpha Video Channels\n" + Math.round(video.progress * 100) + "%"
	
	}
}