
package examples.particles


import Phaser.*

class Snow: State() {
	//  This example was created by Jens Anders Bakke
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("sky", "assets/skies/sky3.png")
	    game.load.spritesheet("snowflakes", "assets/sprites/snowflakes.png", 17, 17)
	    game.load.spritesheet("snowflakes_large", "assets/sprites/snowflakes_large.png", 64, 64)
	
	}
	
	var max = 0.0
	lateinit var front_emitter:Particles.Arcade.Emitter
	lateinit var mid_emitter:Particles.Arcade.Emitter
	lateinit var back_emitter:Particles.Arcade.Emitter
	var update_interval = 4 * 60
	var i = 0
	
	override fun create() {
	
	    game.add.image(0, 0, "sky")
	
	    back_emitter = game.add.emitter(game.world.centerX, -32, 600)
	    back_emitter.makeParticles("snowflakes", arrayOf(0, 1, 2, 3, 4, 5))
	    back_emitter.maxParticleScale = 0.6
	    back_emitter.minParticleScale = 0.2
	    back_emitter.setYSpeed(20, 100)
	    back_emitter.gravity = 0
	    back_emitter.width = game.world.width * 1.5
	    back_emitter.minRotation = 0
	    back_emitter.maxRotation = 40
	
	    mid_emitter = game.add.emitter(game.world.centerX, -32, 250)
	    mid_emitter.makeParticles("snowflakes", arrayOf(0, 1, 2, 3, 4, 5))
	    mid_emitter.maxParticleScale = 1.2
	    mid_emitter.minParticleScale = 0.8
	    mid_emitter.setYSpeed(50, 150)
	    mid_emitter.gravity = 0
	    mid_emitter.width = game.world.width * 1.5
	    mid_emitter.minRotation = 0
	    mid_emitter.maxRotation = 40
	
	    front_emitter = game.add.emitter(game.world.centerX, -32, 50)
	    front_emitter.makeParticles("snowflakes_large", arrayOf(0, 1, 2, 3, 4, 5))
	    front_emitter.maxParticleScale = 1
	    front_emitter.minParticleScale = 0.5
	    front_emitter.setYSpeed(100, 200)
	    front_emitter.gravity = 0
	    front_emitter.width = game.world.width * 1.5
	    front_emitter.minRotation = 0
	    front_emitter.maxRotation = 40
	
	    changeWindDirection()
	
	    back_emitter.start(false, 14000, 20)
	    mid_emitter.start(false, 12000, 40)
	    front_emitter.start(false, 6000, 1000)
	
	}
	
	override fun update() {
	
	    i++
	
	    if (i === update_interval)
	    {
	        changeWindDirection()
	        update_interval = Math.floor(Math.random() * 20) * 60 // 0 - 20sec @ 60fps
	        i = 0
	    }
	
	}
	
	fun changeWindDirection() {
	
	    var multi = Math.floor((max + 200) / 4)
	    val frag = (Math.floor(Math.random() * 100) - multi)
	    max = max + frag
	
	    if (max > 200) max = 150.0
	    if (max < -200) max = -150.0
	
	    setXSpeed(back_emitter, max)
	    setXSpeed(mid_emitter, max)
	    setXSpeed(front_emitter, max)
	
	}
	
	fun setXSpeed(emitter: Particles.Arcade.Emitter, max:Double) {
	
	    emitter.setXSpeed(max - 20, max)
	    emitter.forEachAlive( { p->setParticleXSpeed(p, max) } )
	
	}
	
	fun setParticleXSpeed(particle:Sprite, max:Double) {
	
	    particle.body.velocity.x = max - Math.floor(Math.random() * 30)
	
	}
}