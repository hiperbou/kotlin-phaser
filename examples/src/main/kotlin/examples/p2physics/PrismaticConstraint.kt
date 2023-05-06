
package examples.p2physics


import Phaser.*
import org.khronos.webgl.Float32Array

class PrismaticConstraint: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/sprites/atari800xl.png")
	    game.load.image("lift", "assets/sprites/flectrum.png")
		game.load.image("sky", "assets/skies/cavern2.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var vu1:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.add.image(0, 0, "sky")
	
		//	Enable p2 physics
		game.physics.startSystem(Phaser.Physics.P2JS)
	
	    //  Add 2 sprites which we"ll join with a constraint
	    sprite = game.add.sprite(200, 400, "atari")
	
	    vu1 = game.add.sprite(400, 400, "lift")
	
		game.physics.p2.enable(arrayOf(sprite, vu1))
	
	    sprite.body.fixedRotation = true
	    vu1.body.fixedRotation = true
	
	    var constraint = game.physics.p2.createPrismaticConstraint(sprite, vu1, false, arrayOf(150, 0), arrayOf(-15, 0), Float32Array(arrayOf(0.0f, 1.0f)))
	
	    //  You can also set limits:
	    /*
	    constraint.upperLimitEnabled = true
	    constraint.upperLimit = game.physics.p2.pxm(0.5)
	    constraint.lowerLimitEnabled = true
	    constraint.lowerLimit = game.physics.p2.pxm(-0.5)
	    */
	
	    val text = game.add.text(20, 20, "move with arrow keys", TextStyle(fill="#ffffff" ))
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    sprite.body.setZeroVelocity()
	    vu1.body.setZeroVelocity()
	
	    if (cursors.left.isDown)
	    {
	    	sprite.body.moveLeft(200)
	    }
	    else if (cursors.right.isDown)
	    {
	    	sprite.body.moveRight(200)
	    }
	
	    if (cursors.up.isDown)
	    {
	        vu1.body.moveUp(200)
	    }
	    else if (cursors.down.isDown)
	    {
	        vu1.body.moveDown(200)
	    }
	
	
	}
}