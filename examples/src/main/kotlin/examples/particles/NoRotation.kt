
package examples.particles


import Phaser.*

class NoRotation: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("alien", "assets/sprites/space-baddie.png")
	
	}
	
	override fun create() {
	
	    var emitter = game.add.emitter(game.world.centerX, game.world.centerY, 250)
	
	    emitter.makeParticles("alien")
	
	    emitter.minParticleSpeed.setTo(-300, -300)
	    emitter.maxParticleSpeed.setTo(300, 300)
	
	    //  By setting the min and max rotation to zero, you disable rotation on the particles fully
	    emitter.minRotation = 0.0
	    emitter.maxRotation = 0.0
	
	    emitter.start(false, 4000, 15)
	
	}
}