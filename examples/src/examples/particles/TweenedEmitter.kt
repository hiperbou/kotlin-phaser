
package examples.particles


import Phaser.*

class TweenedEmitter: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var emitter:Particles.Arcade.Emitter

	override fun preload() {
	
	    game.load.image("bubble", "assets/particles/bubble.png")
	    game.load.image("water", "assets/demoscene/blue-raster-floor.png")
	
	}
	
	override fun create() {
	
	    game.add.tileSprite(0, 344, 800, 256, "water")
	
	    emitter = game.add.emitter(game.world.centerX, 32, 250)
	
	    emitter.makeParticles("bubble")
	
	    emitter.setXSpeed(0, 0)
	    emitter.setYSpeed(200, 200)
	
	    emitter.particleBringToTop = true
	    emitter.setRotation(0, 0)
	    emitter.setAlpha(0.1, 1, 2000)
	    emitter.setScale(0.1, 2, 0.1, 2, 4000)
	    emitter.gravity = 100.0
	
	    emitter.start(false, 5000, 50)
	
	    emitter.emitX = 200.0
	
	    //game.add.tween(emitter).to( object{ var  emitX= 700 }, 2000, Phaser.Easing.Sinusoidal::InOut, true, 0, Int.MAX_VALUE, true)
	    game.add.tween(emitter).to( object{ var  emitX= 600 }, 2000, Phaser.Easing.Back::InOut, true, 0, Int.MAX_VALUE, true)
	
	}
	
	override fun update() {
	
	
	}
	
}