
package examples.particles


import Phaser.*

class ParticlesVsPlatforms: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var emitter:Particles.Arcade.Emitter
	lateinit var platform:Sprite
	
	override fun preload() {
	
	    game.load.spritesheet("balls", "assets/sprites/balls.png", 17, 17)
	    game.load.image("platform", "assets/sprites/platform.png")
	
	}
	
	override fun create() {
	
	    emitter = game.add.emitter(50, game.world.centerY - 200)
	    emitter.bounce.setTo(1)
	    emitter.setXSpeed(100, 200)
	    emitter.setYSpeed(-50, 50)
	    emitter.makeParticles("balls", 0, 250, true, true)
	
	    platform = game.add.sprite(300, 500, "platform")
	    platform.width = 200.0
	
	    game.physics.arcade.enable(platform)
	
	    platform.body.immovable = true
	
	    // explode, lifespan, frequency, quantity
	    emitter.start(false, 5000, 20)
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(emitter, platform, this::change, null, this)
	
	}
	
	fun change(platform:Sprite, particle:Sprite) {
	
	    particle.kill()
	
	}
	
}