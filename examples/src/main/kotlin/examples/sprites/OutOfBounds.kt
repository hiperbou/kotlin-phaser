
package examples.sprites


import Phaser.*

class OutOfBounds: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("alien", "assets/sprites/space-baddie.png")
	    game.load.image("ship", "assets/sprites/shmup-ship.png")
	
	}
	
	lateinit var player:Sprite
	lateinit var aliens:Group
	
	override fun create() {
	
	    //  We only want world bounds on the left and right
	    game.physics.setBoundsToWorld()
	
	    player = game.add.sprite(400, 500, "ship")
	    player.anchor.setTo(0.5, 0.5)
	
	    aliens = game.add.group()
	    aliens.enableBody = true
	    aliens.physicsBodyType = Phaser.Physics.ARCADE
	
	    for(y in 0..4-1)
	    {
	        for(x in 0..10-1)
	        {
	            var alien = aliens.create(200 + x * 48, y * 50, "alien")
	            alien.name = "alien" + x.toString() + y.toString()
	            alien.checkWorldBounds = true
	            alien.events.onOutOfBounds.add(this::alienOut, this)
	            alien.body.velocity.y = 50 + Math.random() * 200
	        }
	    }
	
	}
	
	fun alienOut(alien:Sprite) {
	
	    //  Move the alien to the top of the screen again
	    alien.reset(alien.x, 0)
	
	    //  And give it a random velocity
	    alien.body.velocity.y = 50 + Math.random() * 200
	
	}
}