
package examples.p2physics


import Phaser.*

class TilemapGravity: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("map", "assets/tilemaps/maps/collision_test.json", null, Phaser.Tilemap.TILED_JSON)
	    game.load.image("ground_1x1", "assets/tilemaps/tiles/ground_1x1.png")
	    game.load.image("walls_1x2", "assets/tilemaps/tiles/walls_1x2.png")
	    game.load.image("tiles2", "assets/tilemaps/tiles/tiles2.png")
	    game.load.spritesheet("dude", "assets/games/starstruck/dude.png", 32, 48)
	
	}
	
	lateinit var player:Sprite
	var facing = "left"
	var jumpTimer = 0.0
	lateinit var cursors:CursorKeys
	lateinit var jumpButton:Key
	
	lateinit var map:Tilemap
	lateinit var layer:TilemapLayer
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.P2JS)
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    map = game.add.tilemap("map")
	
	    map.addTilesetImage("ground_1x1")
	    map.addTilesetImage("walls_1x2")
	    map.addTilesetImage("tiles2")
	    
	    layer = map.createLayer("Tile Layer 1")
	
	    layer.resizeWorld()
	
	    //  Set the tiles for collision.
	    //  Do this BEFORE generating the p2 bodies below.
	    map.setCollisionBetween(1, 12)
	
	    //  Convert the tilemap layer into bodies. Only tiles that collide (see above) are created.
	    //  This call returns an array of body objects which you can perform addition actions on if
	    //  required. There is also a parameter to control optimising the map build.
	    game.physics.p2.convertTilemap(map, layer)
	
	    game.physics.p2.restitution = 0.5
	    game.physics.p2.gravity.y = 300.0
	
	    player = game.add.sprite(100, 200, "dude")
	    player.animations.add("left", arrayOf(0, 1, 2, 3), 10, true)
	    player.animations.add("turn", arrayOf(4), 20, true)
	    player.animations.add("right", arrayOf(5, 6, 7, 8), 10, true)
	
	    game.physics.p2.enable(player)
	    
	    player.body.fixedRotation = true
	    // player.body.setMaterial(characterMaterial)
	
	    game.camera.follow(player)
	
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
	
	    var yAxis = p2.vec2.fromValues(0, 1)
	    var result = false
	
	    for(i in 0..game.physics.p2.world.narrowphase.contactEquations.size-1)
	    {
	        var c = game.physics.p2.world.narrowphase.contactEquations[i]
	
	        if (c.bodyA === player.body.data || c.bodyB === player.body.data)
	        {
	            var d = p2.vec2.dot(c.normalA, yAxis) // Normal dot Y-axis
	            if (c.bodyA === player.body.data) d *= -1
	            if (d > 0.5) result = true
	        }
	    }
	    
	    return result
	
	}
	
	override fun render() {
	
	}
}