
package examples.particles


import Phaser.*

class DiamondBurst: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	lateinit var emitter:Particles.Arcade.Emitter
	
	override fun preload() {
	
	    game.load.image("diamond", "assets/sprites/diamond.png")
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = "#337799"
	
	    emitter = game.add.emitter(game.world.centerX, 200, 200)
	
	    emitter.makeParticles("diamond")
	
	    //	false means don"t explode all the sprites at once, but instead release at a rate of 20 particles per frame
	    //	The 5000 value is the lifespan of each particle
	    emitter.start(false, 5000, 20)
	
	}
}