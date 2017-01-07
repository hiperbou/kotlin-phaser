
package examples.particles

import Koala.initKoala
import Phaser.*

class WhenParticlesCollide: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var leftEmitter:Particles.Arcade.Emitter
	lateinit var rightEmitter:Particles.Arcade.Emitter
	
	override fun preload() {
	
	    game.load.image("sky", "assets/skies/cavern2.png")
	    game.load.spritesheet("balls", "assets/sprites/balls.png", 17, 17)
	
	}
	
	override fun create() {
	
	    game.add.image(0, 0, "sky")
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    leftEmitter = game.add.emitter(50, game.world.centerY - 200)
	    leftEmitter.bounce.setTo(0.5, 0.5)
	    leftEmitter.setXSpeed(100, 200)
	    leftEmitter.setYSpeed(-50, 50)
	    leftEmitter.makeParticles("balls", 0, 250, true, true)
	
	    rightEmitter = game.add.emitter(game.world.width - 50, game.world.centerY - 200)
	    rightEmitter.bounce.setTo(0.5, 0.5)
	    rightEmitter.setXSpeed(-100, -200)
	    rightEmitter.setYSpeed(-50, 50)
	    rightEmitter.makeParticles("balls", 1, 250, true, true)
	
	    // explode, lifespan, frequency, quantity
	    leftEmitter.start(false, 5000, 20)
	    rightEmitter.start(false, 5000, 20)
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(leftEmitter, rightEmitter, this::change, null, this)
	
	}
	
	fun change(a:Sprite, b:Sprite) {
	
	    a.frame = 3
	    b.frame = 3
	
	}
}