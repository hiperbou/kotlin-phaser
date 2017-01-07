
package examples.particles

import Koala.initKoala
import Phaser.*

class RandomSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	lateinit var emitter:Particles.Arcade.Emitter
	
	override fun preload() {
	
	    game.load.image("carrot", "assets/sprites/carrot.png")
	    game.load.image("star", "assets/misc/star_particle.png")
	    game.load.image("diamond", "assets/sprites/diamond.png")
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = 0x337799
	
	    emitter = game.add.emitter(game.world.centerX, 200, 200)
	
	    //  Here we"re passing an array of image keys. It will pick one at random when emitting a particle.
	    emitter.makeParticles(arrayOf("diamond", "carrot", "star"))
	
	    emitter.start(false, 5000, 20)
	
	}
}