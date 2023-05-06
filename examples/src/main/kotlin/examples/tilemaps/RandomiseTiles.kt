
package examples.tilemaps


import Phaser.*

class RandomiseTiles: State() {
	
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
	lateinit var marker:Graphics
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    map = game.add.tilemap("desert")
	
	    map.addTilesetImage("Desert", "tiles")
	
	    layer = map.createLayer("Ground")
	
	    layer.resizeWorld()
	
	    marker = game.add.graphics()
	    marker.lineStyle(2, 0x00bff3, 1)
	    marker.drawRect(0, 0, 32 * 6, 32 * 6)
	
	    sprite = game.add.sprite(450, 80, "car")
	    sprite.anchor.setTo(0.5, 0.5)
	
	    game.physics.enable(sprite)
	
	    game.camera.follow(sprite)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    game.input.onDown.add(this::randomiseTiles, this)
	
	}
	
	fun randomiseTiles() {
	
	    map.random(layer.getTileX(sprite.x), layer.getTileY(sprite.y), 6, 6)
	
	}
	
	override fun update() {
	
	    marker.x = layer.getTileX(sprite.x) * 32.0
	    marker.y = layer.getTileY(sprite.y) * 32.0
	
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
	
	    game.debug.text("Click to randomise tiles", 32, 32, "rgb(0,0,0)")
	    game.debug.text("Tile X: " + layer.getTileX(sprite.x), 32, 48, "rgb(0,0,0)")
	    game.debug.text("Tile Y: " + layer.getTileY(sprite.y), 32, 64, "rgb(0,0,0)")
	
	}
}