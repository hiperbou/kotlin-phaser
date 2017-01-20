
package examples.particles


import Phaser.*

class ZeroGravity: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("balls", "assets/sprites/balls.png", 17, 17)
	
	}
	
	override fun create() {
	
	    var emitter = game.add.emitter(game.world.centerX, game.world.centerY, 250)
	
	    emitter.makeParticles("balls", arrayOf(0, 1, 2, 3, 4, 5))
	
	    emitter.minParticleSpeed.setTo(-400, -400)
	    emitter.maxParticleSpeed.setTo(400, 400)
	    emitter.gravity = 0
	    emitter.start(false, 4000, 15)
	
	}
}