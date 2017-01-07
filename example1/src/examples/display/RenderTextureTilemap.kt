
package examples.display

import Koala.initKoala
import Phaser.*

class RenderTextureTilemap: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("level3", "assets/tilemaps/maps/cybernoid.json", null, Phaser.Tilemap.TILED_JSON)
	    game.load.spritesheet("tiles", "assets/tilemaps/tiles/cybernoid.png", 16, 16)
	    game.load.image("phaser", "assets/sprites/phaser-ship.png")
	    game.load.image("chunk", "assets/sprites/chunk.png")
	
	}
	
	lateinit var map:Tilemap
	lateinit var texture:RenderTexture
	lateinit var stamp:Sprite
	var tx = 0.0
	var ty = 0.0
	lateinit var cursors:CursorKeys
	lateinit var sprite:Sprite
	lateinit var emitter:Particles.Arcade.Emitter
	
	override fun create() {
	
	    map = game.add.tilemap("level3")
	    map.setCollisionByExclusion(arrayOf(7, 32, 35, 36, 47))
	
	    game.world.setBounds(0, 0, map.widthInPixels, map.heightInPixels)
	
	    stamp = game.add.sprite(0, 0, "tiles", 3)
	
	    texture = game.add.renderTexture(game.width, game.height)
	
	    var rtMap = game.add.sprite(0, 0, texture)
	    rtMap.fixedToCamera = true
	
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
	
	    sprite.body.tilePadding.set(32, 32)
	
	    game.camera.follow(sprite)
	
	    renderMap()
	
	}
	
	fun renderMap() {
	
	    var cx:Int = Phaser.Math.snapToFloor(game.camera.x, 16).toInt() / 16
	    var cy:Int = Phaser.Math.snapToFloor(game.camera.y, 16).toInt() / 16
	
	    // console.log(game.camera.x, "=", cx, game.camera.y, "=", cy)
	
	    var tile:Tile?
	    //  800/16 = 50
	    //  600/16 = 37.5
	    var w = cx + 50
	    var h = cy + 38
	    var dx = 0
	    var dy = 0
	    var cls = true
	
	    for(y in cy..h-1)
	    {
	        for(x in cx..w-1)
	        {
	            tile = map.getTile(x, y)
	
	            if (tile!=null)
	            {
	                stamp.frame = tile.index - 1
	                texture.renderXY(stamp, dx, dy, cls)
	                cls = false
	            }
	
	            dx += 16
	        }
	        
	        dx = 0
	        dy += 16
	    }
	
	    tx = game.camera.x
	    ty = game.camera.y
	
	}
	
	fun particleBurst() {
	
	    emitter.x = sprite.x
	    emitter.y = sprite.y
	    emitter.start(true, 2000, null, 1)
	
	}
	
	override fun update() {
	
	    if (game.camera.x !== tx || game.camera.y !== ty)
	    {
	        renderMap()
	    }
	
	    // game.physics.arcade.collide(sprite, layer)
	    // game.physics.arcade.collide(emitter, layer)
	
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
	
	    // game.debug.text(game.camera.x, 32, 32)
	    // game.debug.text(game.camera.y, 32, 64)
	
	}
}