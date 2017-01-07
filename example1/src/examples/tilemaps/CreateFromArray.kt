
package examples.tilemaps

import Koala.initKoala
import Phaser.*

class CreateFromArray: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    //  tiles are 16x16 each
	    game.load.image("tiles", "assets/tilemaps/tiles/sci-fi-tiles.png")
	
	}
	
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    //  Create some map data dynamically
	    //  Map size is 128x128 tiles
	    var data = ""
	
	    for(y in 0..128-1)
	    {
	        for(x in 0..128-1)
	        {
	            data += game.rnd.between(0, 20).toString()
	
	            if (x < 127)
	            {
	                data += ","
	            }
	        }
	
	        if (y < 127)
	        {
	            data += "\n"
	        }
	    }
	
	    // console.log(data)
	
	    //  Add data to the cache
	    game.cache.addTilemap("dynamicMap", null, data, Phaser.Tilemap.CSV)
	
	    //  Create our map (the 16x16 is the tile size)
	    val map = game.add.tilemap("dynamicMap", 16, 16)
	
	    //  "tiles" = cache image key, 16x16 = tile size
	    map.addTilesetImage("tiles", "tiles", 16, 16)
	
	    //  0 is important
	    val layer = map.createLayer(0)
	
	    //  Scroll it
	    layer.resizeWorld()
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	        game.camera.x--
	    }
	    else if (cursors.right.isDown)
	    {
	        game.camera.x++
	    }
	
	    if (cursors.up.isDown)
	    {
	        game.camera.y--
	    }
	    else if (cursors.down.isDown)
	    {
	        game.camera.y++
	    }
	
	}
}