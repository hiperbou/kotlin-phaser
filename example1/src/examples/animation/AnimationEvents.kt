
package examples.animation

import Koala.initKoala
import Phaser.*

class AnimationEvents: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", { preload: preload, create: create, update: update })
	
	override fun preload() {
	
	    game.load.image("lazur", "assets/pics/thorn_lazur.png")
	    game.load.spritesheet("mummy", "assets/sprites/metalslug_mummy37x45.png", 37, 45, 18)
	
	}
	
	lateinit var back:Image
	lateinit var mummy:Sprite
	lateinit var anim:Animation
	lateinit var loopText:Text
	
	override fun create() {
	
	    back = game.add.image(0, -400, "lazur")
	    back.scale.set(2)
	    back.smoothed = false
	
	    mummy = game.add.sprite(200, 360, "mummy", 5)
	    mummy.scale.set(4)
	    mummy.smoothed = false
	    anim = mummy.animations.add("walk")
	
	    anim.onStart.add({

			game.add.text(32, 32, "Animation started", TextStyle(fill="white"))

		}, this)
	    anim.onLoop.add({

			if (anim.loopCount === 1)
			{
				loopText = game.add.text(32, 64, "Animation looped", TextStyle(fill="white"))
			}
			else
			{
				loopText.text = "Animation looped x2"
				anim.loop = false
			}
		}, this)
	    anim.onComplete.add({
			game.add.text(32, 64+32, "Animation stopped", TextStyle( fill = "white" ))
		}, this)
	
	    anim.play(10, true)
	
	}

	override fun update() {
	
	    if (anim.isPlaying)
	    {
	        back.x -= 1
	    }
	
	}
}