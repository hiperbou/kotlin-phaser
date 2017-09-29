
package examples.particles


import Phaser.*

class SmokeTrail: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	lateinit var emitter:Particles.Arcade.Emitter
	
	override fun preload() {
	
	    game.load.image("smoke", "assets/particles/smoke-puff.png")
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = "#03273e"
	
	    //	Emitters have a center point and a width/height, which extends from their center point to the left/right and up/down
	    emitter = game.add.emitter(game.world.centerX, 500, 400)
	
	    //	This emitter will have a width of 800px, so a particle can emit from anywhere in the range emitter.x += emitter.width / 2
	    // emitter.width = 800
	
	    emitter.makeParticles("smoke")
	
	    emitter.setXSpeed(0, 0)
	    emitter.setYSpeed(0, 0)
	
	    emitter.setRotation(0, 0)
	    emitter.setAlpha(0.1, 1, 3000)
	    emitter.setScale(0.4, 2, 0.4, 2, 6000, Phaser.Easing.Quintic::Out)
	    emitter.gravity = -100
	
	    emitter.start(false, 4000, 20)
	
	    emitter.emitX = 64
	    emitter.emitY = 500
	
	    game.add.tween(emitter).to( object{ var  emitX= 800-64 }, 1000, Phaser.Easing.Sinusoidal::InOut, true, 0, Int.MAX_VALUE, true)
	    game.add.tween(emitter).to( object{ var  emitY= 200 }, 4000, Phaser.Easing.Sinusoidal::InOut, true, 0, Int.MAX_VALUE, true)
	
	}
	
	override fun update() {
	
	    emitter.customSort(this::scaleSort, this)
	
	}
	
	fun scaleSort(a:Particle, b:Particle):Int {
	
	    if (a.scale.x < b.scale.x)
	    {
	        return -1
	    }
	    else if (a.scale.x > b.scale.x)
	    {
	        return 1
	    }
	    else
	    {
	        return 0
	    }
	
	}
	
	override fun render() {
		// game.debug.text(emitter.total, 32, 32)
	}
}