
package examples.animation

import Koala.initKoala
import Phaser.*

class FrameUpdate: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", { preload: preload, create: create })
	
	override fun preload() {
	
	    game.load.spritesheet("mummy", "assets/sprites/metalslug_mummy37x45.png", 37, 45, 18)
	}
	
	lateinit var text:Text
	
	override fun create() {
	
	    var mummy = game.add.sprite(300, 200, "mummy")
	
	    var walk = mummy.animations.add("walk")
	
	    walk.enableUpdate = true
	    walk.onUpdate.add(this::onUpdate, this)
	
	    mummy.animations.play("walk", 5, true)
	
	    text = game.add.text(300, 264, "Frame 1", TextStyle( font = "28px Arial", fill = "#ff0044"))
	
	}
	
	fun onUpdate(anim:Animation, frame:Frame) {
	
	    text.text = "Frame " + frame.index
	
	}
}