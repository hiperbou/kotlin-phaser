
package examples.tilemaps


import Phaser.*

class MultiLayer: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.tilemap("map", "assets/tilemaps/maps/multiple-layers.json", null, Phaser.Tilemap.TILED_JSON)
	
	    game.load.image("kenny_platformer", "assets/tilemaps/tiles/kenny_platformer.png")
	
	    game.load.image("arrow", "assets/sprites/arrow.png")
	
	}
	
	lateinit var map:Tilemap
	
	lateinit var sprite:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#01555f"
	
	    map = game.add.tilemap("map")
	
	    map.addTilesetImage("kenny_platformer")
	
	    var layer1 = map.createLayer("Tile Layer 1")
	
	    layer1.resizeWorld()
	
	    map.createLayer("Tile Layer 2")
	    map.createLayer("Tile Layer 3")
	    map.createLayer("Tile Layer 4")
	
	    sprite = game.add.sprite(260, 100, "arrow")
	    sprite.anchor.set(0.5)
	    game.physics.enable(sprite)
	
	    sprite.body.maxAngular = 500
	    sprite.body.angularDrag = 50
	
	    game.camera.follow(sprite)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    // game.physics.arcade.collide(sprite, layer)
	
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
	        game.physics.arcade.velocityFromAngle(sprite.angle, 400, sprite.body.velocity)
	    }
	
	}
}