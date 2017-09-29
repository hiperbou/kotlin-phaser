
package examples.p2physics


import Phaser.*

class PlatformerMaterial: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/sprites/block.png")
	    game.load.image("background", "assets/games/starstruck/background2.png")
	    game.load.spritesheet("dude", "assets/games/starstruck/dude.png", 32, 48)
	
	}
	
	lateinit var sprite:Sprite
	
	lateinit var player:Sprite
	var facing = "left"
	var jumpTimer = 0.0
	lateinit var cursors:CursorKeys
	lateinit var jumpButton:Key
	var yAxis = p2.vec2.fromValues(0, 1)
	
	override fun create() {
	
	    val bg = game.add.tileSprite(0, 0, 800, 600, "background")
	
	    //  Enable p2 physics
	    game.physics.startSystem(Phaser.Physics.P2JS)
	
	    game.physics.p2.gravity.y = 350
	    game.physics.p2.world.defaultContactMaterial.friction = 0.3
	    game.physics.p2.world.setGlobalStiffness(1e5)
	
	    //  Add a sprite
	    player = game.add.sprite(200, 200, "dude")
	    player.animations.add("left", arrayOf(0, 1, 2, 3), 10, true)
	    player.animations.add("turn", arrayOf(4), 20, true)
	    player.animations.add("right", arrayOf(5, 6, 7, 8), 10, true)
	
	    //  Enable if for physics. This creates a default rectangular body.
	    game.physics.p2.enable(player)
	    
	    player.body.fixedRotation = true
	    player.body.damping = 0.5
	
	    var spriteMaterial = game.physics.p2.createMaterial("spriteMaterial", player.body)
	    var worldMaterial = game.physics.p2.createMaterial("worldMaterial")
	    var boxMaterial = game.physics.p2.createMaterial("worldMaterial")
	
	    //  4 trues = the 4 faces of the world in left, right, top, bottom order
	    game.physics.p2.setWorldMaterial(worldMaterial, true, true, true, true)
	
	    //  A stack of boxes - you"ll stick to these
	    for(i in 1..4-1)
	    {
	        var box = game.add.sprite(300, 645 - (95 * i), "atari")
	        game.physics.p2.enable(box)
	        box.body.mass = 6
	        // box.body.static = true
	        box.body.setMaterial(boxMaterial)
	    }
	
	    //  Here is the contact material. It"s a combination of 2 materials, so whenever shapes with
	    //  those 2 materials collide it uses the following settings.
	
	    var groundPlayerCM = game.physics.p2.createContactMaterial(spriteMaterial, worldMaterial, ContactMaterialOptions( friction= 0.0) )
	    var groundBoxesCM = game.physics.p2.createContactMaterial(worldMaterial, boxMaterial, ContactMaterialOptions( friction= 0.6))
	
	    //  Here are some more options you can set:
	
	    // contactMaterial.friction = 0.0     // Friction to use in the contact of these two materials.
	    // contactMaterial.restitution = 0.0  // Restitution (i.e. how bouncy it is!) to use in the contact of these two materials.
	    // contactMaterial.stiffness = 1e3    // Stiffness of the resulting ContactEquation that this ContactMaterial generate.
	    // contactMaterial.relaxation = 0     // Relaxation of the resulting ContactEquation that this ContactMaterial generate.
	    // contactMaterial.frictionStiffness = 1e7    // Stiffness of the resulting FrictionEquation that this ContactMaterial generate.
	    // contactMaterial.frictionRelaxation = 3     // Relaxation of the resulting FrictionEquation that this ContactMaterial generate.
	    // contactMaterial.surfaceVelocity = 0.0        // Will add surface velocity to this material. If bodyA rests on top if bodyB, and the surface velocity is positive, bodyA will slide to the right.
	
	    val text = game.add.text(20, 20, "move with arrow, space to jump", TextStyle(fill="#ffffff" ))
	
	    cursors = game.input.keyboard.createCursorKeys()
	    jumpButton = game.input.keyboard.addKey(Phaser.Keyboard.SPACEBAR)
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	        player.body.moveLeft(200)
	
	        if (facing != "left")
	        {
	            player.animations.play("left")
	            facing = "left"
	        }
	    }
	    else if (cursors.right.isDown)
	    {
	        player.body.moveRight(200)
	
	        if (facing != "right")
	        {
	            player.animations.play("right")
	            facing = "right"
	        }
	    }
	    else
	    {
	        player.body.velocity.x = 0
	
	        if (facing != "idle")
	        {
	            player.animations.stop()
	
	            if (facing == "left")
	            {
	                player.frame = 0
	            }
	            else
	            {
	                player.frame = 5
	            }
	
	            facing = "idle"
	        }
	    }
	    
	    if (jumpButton.isDown && game.time.now > jumpTimer && checkIfCanJump())
	    {
	        player.body.moveUp(300)
	        jumpTimer = game.time.now + 750
	    }
	
	}
	
	fun checkIfCanJump():Boolean {
	
	    var result = false

		val mm = game.physics.p2.world.narrowphase.contactEquations.size - 1
		for(i in 0..mm)
	    {
	        var c = game.physics.p2.world.narrowphase.contactEquations[i]
	
	        if (c.bodyA === player.body.data || c.bodyB === player.body.data)
	        {
	            var d = p2.vec2.dot(c.normalA, yAxis)
	
	            if (c.bodyA === player.body.data)
	            {
	                d *= -1
	            }
	
	            if (d > 0.5)
	            {
	                result = true
	            }
	        }
	    }
	    
	    return result
	
	}
}