
package examples.p2physics


import Phaser.*

class ContactEvents: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("contra2", "assets/pics/contra2.png")
	    game.load.image("block", "assets/sprites/block.png")
	    game.load.image("wizball", "assets/sprites/wizball.png")
	    game.load.image("tetrisblock1", "assets/sprites/tetrisblock1.png")
	    game.load.image("tetrisblock2", "assets/sprites/tetrisblock2.png")
	    game.load.image("tetrisblock3", "assets/sprites/tetrisblock3.png")
	
	    game.load.physics("physicsData", "assets/physics/sprites.json")
	
	}
	
	lateinit var contra:Sprite
	lateinit var block:Sprite
	lateinit var wizball:Sprite
	lateinit var tetris1:Sprite
	lateinit var tetris2:Sprite
	lateinit var tetris3:Sprite
	
	lateinit var cursors:CursorKeys
	
	var result = "Move with the cursors"
	
	override fun create() {
	
	    //  Enable p2 physics
	    game.physics.startSystem(Phaser.Physics.P2JS)
	
	    game.physics.p2.restitution = 0.9
	
	    contra = game.add.sprite(200, 200, "contra2")
	    block = game.add.sprite(500, 200, "block")
	    wizball = game.add.sprite(500, 500, "wizball")
	    tetris1 = game.add.sprite(100, 450, "tetrisblock1")
	    tetris2 = game.add.sprite(300, 450, "tetrisblock2")
	    tetris3 = game.add.sprite(650, 350, "tetrisblock3")
	
	    //  Enable the physics bodies on all the sprites
	    game.physics.p2.enable(arrayOf( contra, block, wizball, tetris1, tetris2, tetris3 ), false)
	
	    //  The following just loads the polygon data into the objects
	    contra.body.clearShapes()
	    contra.body.loadPolygon("physicsData", "contra2")
	
	    wizball.body.setCircle(45)
	
	    tetris1.body.clearShapes()
	    tetris1.body.loadPolygon("physicsData", "tetrisblock1")
	
	    tetris2.body.clearShapes()
	    tetris2.body.loadPolygon("physicsData", "tetrisblock2")
	
	    tetris3.body.clearShapes()
	    tetris3.body.loadPolygon("physicsData", "tetrisblock3")
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    //  Check for the block hitting another object
	    block.body.onBeginContact.add(this::blockHit, this)
	
	}
	
	fun blockHit (body: Physics.P2.Body?, bodyB:Physics.P2.Body) {//, shapeA, shapeB, equation) {
	
	    //  The block hit something.
	    //  
	    //  This callback is sent 5 arguments:
	    //  
	    //  The Phaser.Physics.P2.Body it is in contact with. *This might be null* if the Body was created directly in the p2 world.
	    //  The p2.Body this Body is in contact with.
	    //  The Shape from this body that caused the contact.
	    //  The Shape from the contact body.
	    //  The Contact Equation data array.
	    //  
	    //  The first argument may be null or not have a sprite property, such as when you hit the world bounds.
	    if (body != null)
	    {
	        result = "You last hit: " + body.sprite.key
	    }
	    else
	    {
	        result = "You last hit: The wall :)"
	    }
	
	}
	
	override fun update() {
	
	    block.body.setZeroVelocity()
	
	    if (cursors.left.isDown)
	    {
	        block.body.moveLeft(200)
	    }
	    else if (cursors.right.isDown)
	    {
	        block.body.moveRight(200)
	    }
	
	    if (cursors.up.isDown)
	    {
	        block.body.moveUp(200)
	    }
	    else if (cursors.down.isDown)
	    {
	        block.body.moveDown(200)
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text(result, 32, 32)
	
	}
}