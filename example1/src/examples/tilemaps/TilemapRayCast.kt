
package examples.tilemaps

import Koala.initKoala
import Phaser.*

class TilemapRayCast: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("map", "assets/tilemaps/maps/collision_test.json", null, Phaser.Tilemap.TILED_JSON)
	    game.load.image("ground_1x1", "assets/tilemaps/tiles/ground_1x1.png")
	    game.load.image("phaser", "assets/sprites/phaser-dude.png")
	
	}
	
	lateinit var map:Tilemap
	lateinit var layer:TilemapLayer
	lateinit var cursors:CursorKeys
	lateinit var sprite:Sprite
	lateinit var line:Phaser.Line
	var tileHits = arrayOf<Tile>()
	var plotting = false
	
	override fun create() {
	
	    line = Phaser.Line()
	
	    map = game.add.tilemap("map")
	
	    map.addTilesetImage("ground_1x1")
	    
	    layer = map.createLayer("Tile Layer 1")
	
	    layer.resizeWorld()
	
	    map.setCollisionBetween(1, 12)
	
	    layer.debug = true
	
	    sprite = game.add.sprite(260, 70, "phaser")
	
	    game.physics.enable(sprite)
	
	    game.camera.follow(sprite)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    var help = game.add.text(10, 10, "Arrows to move, click and drag to cast a ray", TextStyle(font="16px Arial",fill="#ffffff" ))
	    help.fixedToCamera = true
	
	    game.input.onDown.add(this::startLine, this)
	    game.input.onUp.add(this::raycast, this)
	
	}
	
	fun startLine(pointer:Pointer) {
	
	    if (tileHits.size > 0)
	    {
	        for(i in 0..tileHits.size-1)
	        {
	            tileHits[i].debug = false
	        }
	
	        layer.dirty = true
	    }
	
	    line.start.set(pointer.worldX, pointer.worldY)
	
	    plotting = true
	
	}
	
	fun raycast(pointer:Pointer) {
	
	    line.end.set(pointer.worldX, pointer.worldY)
	//@todo: test this!!
	    tileHits = layer.getRayCastTiles(line, 4, false, false)
	
	    if (tileHits.size > 0)
	    {
	        //  Just so we can visually see the tiles
	        for(i in 0..tileHits.size-1)
	        {
	            tileHits[i].debug = true
	        }
	
	        layer.dirty = true
	    }
	
	    plotting = false
	    
	}
	
	override fun update() {
	
	    if (plotting != null)
	    {
	        line.end.set(game.input.activePointer.worldX, game.input.activePointer.worldY)
	    }
	
	    game.physics.arcade.collide(sprite, layer)
	
	    sprite.body.velocity.x = 0.0
	    sprite.body.velocity.y = 0.0
	
	    if (cursors.up.isDown)
	    {
	        sprite.body.velocity.y = -200.0
	    }
	    else if (cursors.down.isDown)
	    {
	        sprite.body.velocity.y = 200.0
	    }
	
	    if (cursors.left.isDown)
	    {
	        sprite.body.velocity.x = -200.0
	    }
	    else if (cursors.right.isDown)
	    {
	        sprite.body.velocity.x = 200.0
	    }
	
	}
	
	override fun render() {
	
	    game.debug.geom(line)
	
	}
}