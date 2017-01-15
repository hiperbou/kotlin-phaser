
package examples.p2physics

import Koala.initKoala
import Phaser.*

class PickUpObject: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("tetrisblock1", "assets/sprites/tetrisblock1.png")
	    game.load.image("tetrisblock2", "assets/sprites/tetrisblock2.png")
	    game.load.image("tetrisblock3", "assets/sprites/tetrisblock3.png")
	
	    game.load.physics("physicsData", "assets/physics/sprites.json")
	
	}
	
	lateinit var tetris1:Sprite
	lateinit var tetris2:Sprite
	lateinit var tetris3:Sprite
	lateinit var mouseBody: p2.Body
	lateinit var mouseConstraint:Physics.P2.RevoluteConstraint
	
	override fun create() {
	        
	    //  Enable p2 physics
	    game.physics.startSystem(Phaser.Physics.P2JS)
	    game.physics.p2.gravity.y = 1000
	    
	    tetris1 = game.add.sprite(300, 100, "tetrisblock1")
	    tetris2 = game.add.sprite(375, 200, "tetrisblock2")
	    tetris3 = game.add.sprite(450, 300, "tetrisblock3")
	    
	    //  Create collision group for the blocks
	    var blockCollisionGroup = game.physics.p2.createCollisionGroup()
	    
	    //  This part is vital if you want the objects with their own collision groups to still collide with the world bounds
	    //  (which we do) - what this does is adjust the bounds to use its own collision group.
	    game.physics.p2.updateBoundsCollisionGroup()
	    
	    //  Enable the physics bodies on all the sprites
	    game.physics.p2.enable(arrayOf( tetris1, tetris2, tetris3 ), false)
	    
	    tetris1.body.clearShapes()
	    tetris1.body.loadPolygon("physicsData", "tetrisblock1")
	    tetris1.body.setCollisionGroup(blockCollisionGroup)
	    tetris1.body.collides(arrayOf(blockCollisionGroup))
	    
	    tetris2.body.clearShapes()
	    tetris2.body.loadPolygon("physicsData", "tetrisblock2")
	    tetris2.body.setCollisionGroup(blockCollisionGroup)
	    tetris2.body.collides(arrayOf(blockCollisionGroup))
	    
	    tetris3.body.clearShapes()
	    tetris3.body.loadPolygon("physicsData", "tetrisblock3")
	    tetris3.body.setCollisionGroup(blockCollisionGroup)
	    tetris3.body.collides(arrayOf(blockCollisionGroup))
	    
	    // create physics body for mouse which we will use for dragging clicked bodies
	    mouseBody = p2.Body()
	    game.physics.p2.world.addBody(mouseBody)
	        
	    // attach pointer events
	    game.input.onDown.add(this::click, this)
	    game.input.onUp.add(this::release, this)
	    game.input.addMoveCallback(this::move, this)
	}
	
	fun click(pointer:Pointer) {
	
	    var bodies = game.physics.p2.hitTest(pointer.position, arrayOf( tetris1.body, tetris2.body, tetris3.body ))
	    
	    // p2 uses different coordinate system, so convert the pointer position to p2"s coordinate system
	    var physicsPos = arrayOf(game.physics.p2.pxmi(pointer.position.x), game.physics.p2.pxmi(pointer.position.y))
	    
	    if (bodies.isNotEmpty())
	    {
	        var clickedBody = bodies[0]
	        
	        var localPointInBody = arrayOf(0.0, 0.0)
	        // this fun takes physicsPos and coverts it to the body"s local coordinate system
	        clickedBody.toLocalFrame(localPointInBody, physicsPos)
	        
	        // use a revoluteContraint to attach mouseBody to the clicked body
	        mouseConstraint = game.physics.p2.createRevoluteConstraint(mouseBody, arrayOf(0, 0), clickedBody, arrayOf(game.physics.p2.mpxi(localPointInBody[0]), game.physics.p2.mpxi(localPointInBody[1]) ))
	    }   
	
	}
	
	fun release() {
	
	    // remove constraint from object"s body
	    game.physics.p2.removeConstraint(mouseConstraint)
	
	}
	
	fun move(pointer:Pointer) {
	
	    // p2 uses different coordinate system, so convert the pointer position to p2"s coordinate system
	    mouseBody.position[0] = game.physics.p2.pxmi(pointer.position.x)
	    mouseBody.position[1] = game.physics.p2.pxmi(pointer.position.y)
	
	}
	
	override fun update() {
	}
	
	override fun render() {
	
	//  game.debug.text(result, 32, 32)
	
	}
}