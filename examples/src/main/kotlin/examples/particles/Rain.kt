
package examples.particles


import Phaser.*

class Rain: State() {
	//	This example was created by Jens Anders Bakke
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
		game.load.image("sky", "assets/skies/underwater3.png")
		game.load.spritesheet("rain", "assets/sprites/rain.png", 17, 17)
	
	}
	
	override fun create() {
	
		game.add.image(0, 0, "sky")
	
		var emitter = game.add.emitter(game.world.centerX, 0, 400)
	
		emitter.width = game.world.width
		// emitter.angle = 30 // uncomment to set an angle for the rain.
	
		emitter.makeParticles("rain")
	
		emitter.minParticleScale = 0.1
		emitter.maxParticleScale = 0.5
	
		emitter.setYSpeed(300, 500)
		emitter.setXSpeed(-5, 5)
	
		emitter.minRotation = 0.0
		emitter.maxRotation = 0.0
	
		emitter.start(false, 1600, 5, 0)
	
	}
}