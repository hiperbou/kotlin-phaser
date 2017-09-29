
package examples.particles


import Phaser.*

class DestroyEmitter: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
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
	
	    emitter.x = pointer.x
	    emitter.y = pointer.y
	
	    emitter.start(true, 4000, null, 10)
	
	    //  And 2 seconds later we"ll destroy the emitter
	    game.time.events.add(2000, this::destroyEmitter, this)
	
	}
	
	fun destroyEmitter() {
	
	    emitter.destroy()
	
	}
}