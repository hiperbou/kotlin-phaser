
package examples.tilemaps

import Koala.initKoala
import Phaser.*

class Mario: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.tilemap("mario", "assets/tilemaps/maps/super_mario.json", null, Phaser.Tilemap.TILED_JSON)
	    game.load.image("tiles", "assets/tilemaps/tiles/super_mario.png")
	    game.load.image("player", "assets/sprites/phaser-dude.png")
	
	}
	
	lateinit var map:Tilemap
	lateinit var layer:TilemapLayer
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.stage.backgroundColor = "#787878"
	
	    map = game.add.tilemap("mario")
	
	    map.addTilesetImage("SuperMarioBros-World1-1", "tiles")
	    
	    layer = map.createLayer("World1")
	
	    layer.resizeWorld()
	
	    layer.wrap = true
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	        game.camera.x -= 8
	    }
	    else if (cursors.right.isDown)
	    {
	        game.camera.x += 8
	    }
	
	    if (cursors.up.isDown)
	    {
	        game.camera.y -= 8
	    }
	    else if (cursors.down.isDown)
	    {
	        game.camera.y += 8
	    }
	
	}
}