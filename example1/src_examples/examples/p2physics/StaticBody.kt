
package examples.p2physics

import Koala.initKoala
import Phaser.*

class StaticBody: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("wizball", "assets/sprites/wizball.png")
	    game.load.image("atari", "assets/sprites/atari130xe.png")
		game.load.image("sky", "assets/skies/sunset.png")
	
	}
	
	lateinit var static1:Sprite
	lateinit var static2:Sprite
	lateinit var sprite:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.add.image(0, 0, "sky")
	
		//	Enable p2 physics
		game.physics.startSystem(Phaser.Physics.P2JS)
	
	    //  Make things a bit more bouncey
	    game.physics.p2.restitution = 0.8
	
	    //  Add a sprite
		sprite = game.add.sprite(400, 300, "wizball")
	    game.physics.p2.enable(sprite)
	    sprite.body.setCircle(44)
	
	    //  Create two static objects
	    static1 = game.add.sprite(200, 200, "atari")
	    static2 = game.add.sprite(500, 500, "atari")
	
	    //  Enable if for physics. This creates a default rectangular body.
	    game.physics.p2.enable( arrayOf( static1, static2 ))
	
	    //  Make static
	    static1.body.static = true
		static2.body.static = true
	
	    val text = game.add.text(20, 20, "move with arrow keys", TextStyle(fill="#ffffff" ))
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	    	sprite.body.rotateLeft(80)
	    }
	    else if (cursors.right.isDown)
	    {
	    	sprite.body.rotateRight(80)
	    }
	    else
	    {
	        sprite.body.setZeroRotation()
	    }
	
	    if (cursors.up.isDown)
	    {
	    	sprite.body.thrust(400)
	    }
	    else if (cursors.down.isDown)
	    {
	    	sprite.body.reverse(400)
	    }
	
	}
}