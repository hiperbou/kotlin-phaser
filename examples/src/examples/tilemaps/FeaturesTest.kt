
package examples.tilemaps


import Phaser.*

class FeaturesTest: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("map", "assets/tilemaps/maps/features_test_rotated.json", null, Phaser.Tilemap.TILED_JSON)
	
	    game.load.image("ground_1x1", "assets/tilemaps/tiles/ground_1x1.png")
	    game.load.image("walls_1x2", "assets/tilemaps/tiles/walls_1x2.png")
	    game.load.image("tiles2", "assets/tilemaps/tiles/tiles2.png")
	    game.load.image("phaser", "assets/sprites/arrow.png")
	    game.load.spritesheet("coin", "assets/sprites/coin.png", 32, 32)
	    game.load.image("bunny", "assets/sprites/bunny.png")
	
	}
	
	lateinit var map:Tilemap
	lateinit var layer:TilemapLayer
	
	lateinit var sprite:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    map = game.add.tilemap("map")
	
	    map.addTilesetImage("ground_1x1")
	    map.addTilesetImage("coin")
	    map.addTilesetImage("walls_1x2")
	    map.addTilesetImage("tiles2")
	
	    map.setCollisionBetween(1, 12)
	
	    //  This will set Tile ID 26 (the coin) to call the hitCoin fun when collided with
	    map.setTileIndexCallback(26, this::hitCoin, this)
	
	    //  This will set the map location 2, 0 to call the fun
	    map.setTileLocationCallback(2, 0, 1, 1, this::hitCoin, this)
	
	    layer = map.createLayer("Tile Layer 1")
	    layer.resizeWorld()
	    layer.debugSettings.forceFullRedraw = true
	
	    var layer3 = map.createLayer("Tile Layer 3")
	
	
	    sprite = game.add.sprite(260, 100, "phaser")
	    sprite.anchor.set(0.5)
	    game.physics.enable(sprite)
	
	    sprite.body.setSize(16, 16, 8, 8)
	
	    //  We"ll set a lower max angular velocity here to keep it from going totally nuts
	    sprite.body.maxAngular = 500
	
	    //  Apply a drag otherwise the sprite will just spin and never slow down
	    sprite.body.angularDrag = 50
	
	    game.camera.follow(sprite)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	fun hitCoin(sprite:Sprite, tile:Tile):Boolean {
	
	    tile.alpha = 0.2
	
	    layer.dirty = true
	
	    return false
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(sprite, layer)
	
	    sprite.body.velocity.x = 0.0
	    sprite.body.velocity.y = 0.0
	    sprite.body.angularVelocity = 0
	
	    if (cursors.left.isDown)
	    {
	        sprite.body.angularVelocity = -200
	    }
	    else if (cursors.right.isDown)
	    {
	        sprite.body.angularVelocity = 200
	    }
	
	    if (cursors.up.isDown)
	    {
	        game.physics.arcade.velocityFromAngle(sprite.angle, 200, sprite.body.velocity)
	    }
	
	}
	
	override fun render() {
	
	    game.debug.body(sprite)
	
	}
}