
package examples.particles


import Phaser.*

class ParticleScale: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	lateinit var emitter:Particles.Arcade.Emitter
	
	override fun preload() {
	
	    game.load.image("sky", "assets/skies/sky4.png")
	    game.load.spritesheet("veggies", "assets/sprites/fruitnveg32wh37.png", 32, 32)
	
	}
	
	override fun create() {
	
	    game.add.image(0, 0, "sky")
	
	    emitter = game.add.emitter(game.world.centerX, game.world.centerY, 20)
	
	    emitter.makeParticles("veggies", arrayOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20), 20, true, true)
	
	    emitter.minParticleSpeed.setTo(-200, -300)
	    emitter.maxParticleSpeed.setTo(200, -400)
	    emitter.minParticleScale = 0.5
	    emitter.maxParticleScale = 2
	    emitter.gravity = 150
	    emitter.bounce.setTo(0.5, 0.5)
	    emitter.angularDrag = 30
	
	    emitter.start(false, 6000, 100)
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(emitter)
	
	}
	
	override fun render() {
	
	    for(i in 0..emitter.total-1)
	    {
	        if (emitter.children[i].visible)
	        {
	            //  Uncomment this to see the physics bodies
	            // game.debug.body(emitter.children[i])
	        }
	    }
	
	}
}