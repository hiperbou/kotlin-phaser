
package examples.tilemaps

import Koala.initKoala
import Phaser.*

class SciFly: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("level3", "assets/tilemaps/maps/cybernoid.json", null, Phaser.Tilemap.TILED_JSON)
	    game.load.image("tiles", "assets/tilemaps/tiles/cybernoid.png", 16, 16)
	    game.load.image("phaser", "assets/sprites/phaser-ship.png")
	    game.load.image("chunk", "assets/sprites/chunk.png")
	
	}
	
	lateinit var map:Tilemap
	lateinit var layer:TilemapLayer
	lateinit var cursors:CursorKeys
	lateinit var sprite:Sprite
	lateinit var emitter:Particles.Arcade.Emitter
	
	override fun create() {
	
	    //  A Tilemap object just holds the data needed to describe the map (i.e. the json exported from Tiled, or the CSV exported from elsewhere).
	    //  You can add your own data or manipulate the data (swap tiles around, etc) but in order to display it you need to create a TilemapLayer.
	    map = game.add.tilemap("level3")
	
	    map.addTilesetImage("CybernoidMap3BG_bank.png", "tiles")
	
	    layer = map.createLayer(0)
	
	    //  Basically this sets EVERY SINGLE tile to fully collide on all faces
	    map.setCollisionByExclusion(arrayOf(7, 32, 35, 36, 47))
	
	    layer.resizeWorld()
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    emitter = game.add.emitter(0, 0, 200)
	
	    emitter.makeParticles("chunk")
	    emitter.minRotation = 0
	    emitter.maxRotation = 0
	    emitter.gravity = 150
	    emitter.bounce.setTo(0.5, 0.5)
	
	    sprite = game.add.sprite(300, 90, "phaser")
	    sprite.anchor.set(0.5)
	
	    game.physics.enable(sprite)
	
	    //  Because both our body and our tiles are so tiny,
	    //  and the body is moving pretty fast, we need to add
	    //  some tile padding to the body. WHat this does
	    sprite.body.tilePadding.set(32, 32)
	
	    game.camera.follow(sprite)
	
	}
	
	fun particleBurst() {
	
	    emitter.x = sprite.x
	    emitter.y = sprite.y
	    emitter.start(true, 2000, null, 1)
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(sprite, layer)
	    game.physics.arcade.collide(emitter, layer)
	
	    sprite.body.velocity.x = 0.0
	    sprite.body.velocity.y = 0.0
	
	    if (cursors.up.isDown)
	    {
	        sprite.body.velocity.y = -200.0
	        particleBurst()
	    }
	    else if (cursors.down.isDown)
	    {
	        sprite.body.velocity.y = 200.0
	        particleBurst()
	    }
	
	    if (cursors.left.isDown)
	    {
	        sprite.body.velocity.x = -200.0
	        sprite.scale.x = -1.0
	        particleBurst()
	    }
	    else if (cursors.right.isDown)
	    {
	        sprite.body.velocity.x = 200.0
	        sprite.scale.x = 1.0
	        particleBurst()
	    }
	
	}
	
	override fun render() {
	
	    // game.debug.body(sprite)
	
	}
}