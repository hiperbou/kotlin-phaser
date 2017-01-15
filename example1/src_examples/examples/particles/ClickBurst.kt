
package examples.particles

import Koala.initKoala
import Phaser.*

class ClickBurst: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	lateinit var emitter:Particles.Arcade.Emitter
	
	override fun preload() {
	
	    game.load.image("diamond", "assets/sprites/diamond.png")
	
	}
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = 0x337799
	
	    emitter = game.add.emitter(0, 0, 100)
	
	    emitter.makeParticles("diamond")
	    emitter.gravity = 200
	
	    game.input.onDown.add(this::particleBurst, this)
	
	}
	
	fun particleBurst(pointer:Pointer) {
	
	    //  Position the emitter where the mouse/touch event was
	    emitter.x = pointer.x
	    emitter.y = pointer.y
	
	    //  The first parameter sets the effect to "explode" which means all particles are emitted at once
	    //  The second gives each particle a 2000ms lifespan
	    //  The third is ignored when using burst/explode mode
	    //  The final parameter (10) is how many particles will be emitted in this single burst
	    emitter.start(true, 2000, null, 10)
	
	}
}