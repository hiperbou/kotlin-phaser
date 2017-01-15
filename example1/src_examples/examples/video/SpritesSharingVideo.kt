
package examples.video

import Koala.initKoala
import Phaser.*

class SpritesSharingVideo: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.video("liquid", "assets/video/liquid512x512.mp4")
	    // game.load.video("liquid", "assets/video/liquid2.mp4")
	
	}
	
	lateinit var video:Video
	lateinit var group:Group
	
	override fun create() {
	
	    group = game.add.group()
	
	    video = game.add.video("liquid")
	
	    for(i in 0..10-1)
	    {
	        var sprite = group.create<Sprite>(game.world.randomX, game.world.randomY, video)
	        sprite.anchor.set(0.5)
	        sprite.scale.set(game.rnd.realInRange(0.2, 0.5))
	        game.add.tween(sprite).to( object{ var  angle= 360 }, game.rnd.between(4000, 8000), "Sine.easeInOut", true, 0, -1, true)
	    }
	
	    video.play(true)
	
	}
}