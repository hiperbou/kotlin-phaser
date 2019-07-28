
package examples.particles


import Phaser.*

class ParticleAlpha: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	lateinit var emitter:Particles.Arcade.Emitter
	
	override fun preload() {
	
	    game.load.image("corona", "assets/particles/blue.png")
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = "#000000"
	
	    emitter = game.add.emitter(game.world.centerX, 500, 200)
	
	    emitter.makeParticles("corona")
	
	    emitter.setRotation(0, 0)
	    emitter.setAlpha(0.3, 0.8)
	    emitter.setScale(0.5, 1)
	    emitter.gravity = -200.0
	
	    //	false means don"t explode all the sprites at once, but instead release at a rate of one particle per 100ms
	    //	The 5000 value is the lifespan of each particle before it"s killed
	    emitter.start(false, 5000, 100)
	
	}
	
	override fun render() {
		// game.debug.text(emitter.total, 32, 32)
	}
}