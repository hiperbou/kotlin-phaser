
package examples.arcadephysics


import Phaser.*

class WorldBoundsEvent: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("space", "assets/skies/space3.png")
	    game.load.spritesheet("face", "assets/sprites/metalface78x92.png", 78, 92)
	}
	
	override fun create() {
	
	    game.add.sprite(0, 0, "space")
	
	    var face = game.add.sprite(0, 0, "face")
	
	    //  A simple animation that flashes the "eyes" of the sprite
	    face.animations.add("flash", arrayOf(0,1,2,3,2,1,0), 24, false)
	
	    //  Set-up the physics body
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.physics.arcade.enable(face)
	    
	    face.body.velocity.setTo(200, 200)
	    face.body.bounce.set(1)
	    
	    face.body.collideWorldBounds = true
	
	    //  By default the Signal is empty, so we create it here:
	    face.body.onWorldBounds = Phaser.Signal()
	
	    //  And then listen for it
	    face.body.onWorldBounds.add(this::hitWorldBounds, this)
	
	}
	
	fun hitWorldBounds(sprite:Sprite) {
	
	    //  Play the flash animation.
	    //  
	    //  Sometimes you"ll notice it doesn"t always start, i.e. if the sprite
	    //  collides with the world bounds quickly before the previous "flash"
	    //  has completed. This is just because the animation needs to complete
	    //  before playing again, the event did actually occur twice.
	
	    sprite.play("flash")
	    
	}
}