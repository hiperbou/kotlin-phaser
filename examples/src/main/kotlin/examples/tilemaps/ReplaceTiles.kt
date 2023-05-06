
package examples.tilemaps


import Phaser.*

class ReplaceTiles: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("desert", "assets/tilemaps/maps/desert.json", null, Phaser.Tilemap.TILED_JSON)
	    game.load.image("tiles", "assets/tilemaps/tiles/tmw_desert_spacing.png")
	    game.load.image("car", "assets/sprites/car90.png")
	
	}
	
	lateinit var map:Tilemap
	lateinit var layer:TilemapLayer
	
	lateinit var cursors:CursorKeys
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    map = game.add.tilemap("desert")
	
	    map.addTilesetImage("Desert", "tiles")
	
	    layer = map.createLayer("Ground")
	
	    layer.resizeWorld()
	
	    sprite = game.add.sprite(450, 80, "car")
	    sprite.anchor.setTo(0.5, 0.5)
	
	    game.physics.enable(sprite)
	
	    game.camera.follow(sprite)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    game.input.onDown.add(this::replaceTiles, this)
	
	}
	
	fun replaceTiles() {
	
	    //  This will replace every instance of tile 31 (cactus plant) with tile 46 (the sign post).
	    //  It does this across the whole layer of the map unless a region is specified.
	
	    //  You can also pass in x, y, width, height values to control the area in which the replace happens
	
	    map.replace(31, 46)
	
	}
	
	override fun update() {
	
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
	        sprite.body.velocity.copyFrom(game.physics.arcade.velocityFromAngle(sprite.angle, 300))
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Click to replace tiles", 32, 32, "rgb(0,0,0)")
	    game.debug.text("Tile X: " + layer.getTileX(sprite.x), 32, 48, "rgb(0,0,0)")
	    game.debug.text("Tile Y: " + layer.getTileY(sprite.y), 32, 64, "rgb(0,0,0)")
	
	}
}