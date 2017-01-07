
package examples.p2physics

import Koala.initKoala
import Phaser.*

class Springs: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/sprites/atari130xe.png")
	    game.load.image("ball", "assets/sprites/red_ball.png")
		game.load.image("sky", "assets/skies/cavern2.png")
	
	}
	
	lateinit var sprite1:Sprite
	lateinit var sprite2:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.add.image(0, 0, "sky")
	
		//	Enable p2 physics
		game.physics.startSystem(Phaser.Physics.P2JS)
	
	    //  Add 2 sprites which we"ll join with a spring
	    sprite1 = game.add.sprite(400, 300, "ball")
		sprite2 = game.add.sprite(400, 400, "atari")
	
		game.physics.p2.enable(arrayOf(sprite1, sprite2))
	
	    sprite1.body.collideWorldBounds = true
	    sprite2.body.collideWorldBounds = true
	
	    //  Create our spring
	    //  The parameters are: createSpring(sprite1, sprite2, restLength, stiffness, damping, worldA, worldB, localA, localB)
	    //  See the docs for more details
	    var spring = game.physics.p2.createSpring(sprite1, sprite2, 20, 10, 1)
	
	    val text = game.add.text(20, 20, "move with arrow keys", TextStyle(fill="#ffffff" ))
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
		sprite2.body.setZeroVelocity()
	
	    if (cursors.left.isDown)
	    {
	    	sprite2.body.moveLeft(400)
	    }
	    else if (cursors.right.isDown)
	    {
	    	sprite2.body.moveRight(400)
	    }
	
	}
	
}