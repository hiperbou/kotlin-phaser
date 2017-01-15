
package examples.tilemaps

import Koala.initKoala
import Phaser.*

class DualView: State() {
	
	// //var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.tilemap("map", "assets/tilemaps/maps/dual_view.json", null, Phaser.Tilemap.TILED_JSON)
	
	    game.load.image("platforms", "assets/tilemaps/tiles/kenny_platformer_64x64.png")
	    game.load.image("ground", "assets/tilemaps/tiles/kenny_ground_64x64.png")
	    game.load.image("items", "assets/tilemaps/tiles/kenny_items_64x64.png")
	
	    game.load.image("arrow", "assets/sprites/arrow.png")
	
	}
	
	lateinit var map:Tilemap
	lateinit var sprite:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#01555f"
	
	    map = game.add.tilemap("map")
	
	    map.enableDebug = true
	
	    //  Tilesets must always be added first
	    map.addTilesetImage("kenny_platformer_64x64", "platforms")
	    map.addTilesetImage("kenny_ground_64x64", "ground")
	    map.addTilesetImage("kenny_items_64x64", "items")
	
	    //  Then create the layers
	    var layerLeft = map.createLayer("Left", 400, 600)
	    var layerRight = map.createLayer("Left", 400, 600)
	
	    layerRight.x = 404.0
	
	    game.world.setBounds(0, 0, 4000, 4000)
	
	    sprite = game.add.sprite(260, 100, "arrow")
	    sprite.anchor.set(0.5)
	    game.physics.enable(sprite)
	
	    sprite.body.maxAngular = 500
	    sprite.body.angularDrag = 50
	
	    game.camera.follow(sprite)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
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
	        game.physics.arcade.velocityFromAngle(sprite.angle, 400, sprite.body.velocity)
	    }
	
	}
}