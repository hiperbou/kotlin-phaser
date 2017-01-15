
package examples.sprites

import Koala.initKoala
import Phaser.*

class AddSeveralSprites: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	var timer = 0.0
	var total = 0.0
	
	override fun preload() {
	
	    //  37x45 is the size of each frame
	    //  There are 18 frames in the PNG - you can leave this value blank if the frames fill up the entire PNG, but in this case there are some
	    //  blank frames at the end, so we tell the loader how many to load
	    game.load.spritesheet("mummy", "assets/sprites/metalslug_mummy37x45.png", 37, 45, 18)
	
	}
	
	override fun create() {
	
	    releaseMummy()
	
	}
	
	fun releaseMummy() {
	
	    var mummy = game.add.sprite(-(Math.random() * 800), game.world.randomY, "mummy")
	
	    mummy.scale.setTo(2, 2)
	
	    //  If you prefer to work in degrees rather than radians then you can use Phaser.Sprite.angle
	    //  otherwise use Phaser.Sprite.rotation
	    mummy.angle = game.rnd.angle()
	
	    mummy.animations.add("walk")
	    mummy.animations.play("walk", 20, true)
	
	    game.add.tween(mummy).to(object{ var  x= game.width + (1600 + mummy.x) }, 20000, Phaser.Easing.Linear::None, true)
	
	    total++
	    timer = game.time.now + 100
	
	}
	
	override fun update() {
	
	    if (total < 200 && game.time.now > timer)
	    {
	        releaseMummy()
	    }
	
	}
}