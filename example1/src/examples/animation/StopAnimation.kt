
package examples.animation

import Koala.initKoala
import Phaser.*

class StopAnimation: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", { preload: preload, create: create })
	
	override fun preload() {
	
	    game.load.atlas("seacreatures", "assets/sprites/seacreatures_json.png", "assets/sprites/seacreatures_json.json")
	    game.load.image("undersea", "assets/pics/undersea.jpg")
	    game.load.image("coral", "assets/pics/seabed.png")
	
	}
	
	lateinit var greenJellyfish:Sprite
	
	override fun create() {
	
	    game.add.image(0, 0, "undersea")
	
	    //  We add this sprite so you can see what frame 1 looks like
	    game.add.sprite(32, 32, "seacreatures", "greenJellyfish0000")
	
	    greenJellyfish = game.add.sprite(330, 100, "seacreatures")
	    greenJellyfish.animations.add("swim", Phaser.Animation.generateFrameNames("greenJellyfish", 0, 39, "", 4), 30, true)
	    greenJellyfish.animations.play("swim")
	
	    game.add.image(0, 466, "coral")
	
	    game.add.tween(greenJellyfish).to(object{ var y = 250 }, 4000, Phaser.Easing.Quadratic::InOut, true, 0, 1000, true)
	
	    game.input.onDown.addOnce(this::stopAnimation, this)
	
	}
	
	fun stopAnimation() {
	
	    //  This will just top the animation from running, freezing it at its current frame
	    // greenJellyfish.animations.stop()
	
	    //  This method will reset the frame to frame 1 after stopping
	    greenJellyfish.animations.stop(null, true)
	
	}
}