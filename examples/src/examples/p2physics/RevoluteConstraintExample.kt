
package examples.p2physics


import Phaser.*

class RevoluteConstraintExample: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("vu", "assets/sprites/vu.png")
	    game.load.image("ball", "assets/sprites/arrow.png")
		game.load.image("sky", "assets/skies/cavern2.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.add.image(0, 0, "sky")
	
		//	Enable p2 physics
		game.physics.startSystem(Phaser.Physics.P2JS)
	
	    //  Add 2 sprites which we"ll join with a constraint
	    sprite = game.add.sprite(400, 300, "ball")
	
	    var vu1 = game.add.sprite(400, 300, "vu")
	
		game.physics.p2.enable(arrayOf(sprite, vu1))
	
	    //  So they don"t collide with each other
	    sprite.body.clearCollision(true, true)
	    vu1.body.clearCollision(true, true)
	
	    var constraint = game.physics.p2.createRevoluteConstraint(sprite, arrayOf( 50, 100 ), vu1, arrayOf( 0.0, 0.0 ))
	
	    val text = game.add.text(20, 20, "rotate with arrow keys", TextStyle(fill="#ffffff" ))
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	    	sprite.body.rotateLeft(50)
	    }
	    else if (cursors.right.isDown)
	    {
	    	sprite.body.rotateRight(50)
	    }
	
	}
}