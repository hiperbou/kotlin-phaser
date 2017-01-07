
package examples.p2physics

import Koala.initKoala
import Phaser.*

class BasicMovement: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/sprites/atari130xe.png")
		game.load.image("sky", "assets/skies/sunset.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.add.image(0, 0, "sky")
	
		//	Enable p2 physics
		game.physics.startSystem(Phaser.Physics.P2JS)
	
	    //  Make things a bit more bouncey
	    game.physics.p2.restitution = 0.8
	
	    //  Add a sprite
		sprite = game.add.sprite(200, 200, "atari")
	
	    //  Enable if for physics. This creates a default rectangular body.
		game.physics.p2.enable(sprite)
	
	    //  Modify a few body properties
		sprite.body.setZeroDamping()
		sprite.body.fixedRotation = true
	
	    val text = game.add.text(20, 20, "move with arrow keys", TextStyle(fill="#ffffff" ))
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
		sprite.body.setZeroVelocity()
	
	    if (cursors.left.isDown)
	    {
	    	sprite.body.moveLeft(400)
	    }
	    else if (cursors.right.isDown)
	    {
	    	sprite.body.moveRight(400)
	    }
	
	    if (cursors.up.isDown)
	    {
	    	sprite.body.moveUp(400)
	    }
	    else if (cursors.down.isDown)
	    {
	    	sprite.body.moveDown(400)
	    }
	
	}
}