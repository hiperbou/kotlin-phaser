
package examples.tilemaps


import Phaser.*

class CsvMap: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("map", "assets/tilemaps/csv/catastrophi_level2.csv", null, Phaser.Tilemap.CSV)
	    game.load.image("tiles", "assets/tilemaps/tiles/catastrophi_tiles_16.png")
	
	}
	
	lateinit var map:Tilemap
	lateinit var layer:TilemapLayer
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    //  Because we"re loading CSV map data we have to specify the tile size here or we can"t render it
	    map = game.add.tilemap("map", 16, 16)
	
	    //  Now add in the tileset
	    map.addTilesetImage("tiles")
	    
	    //  Create our layer
	    layer = map.createLayer(0)
	
	    //  Resize the world
	    layer.resizeWorld()
	
	    //  Allow cursors to scroll around the map
	    cursors = game.input.keyboard.createCursorKeys()
	
	    var help = game.add.text(16, 16, "Arrows to scroll", TextStyle(font="14px Arial",fill="#ffffff" ))
	    help.fixedToCamera = true
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	        game.camera.x -= 4
	    }
	    else if (cursors.right.isDown)
	    {
	        game.camera.x += 4
	    }
	
	    if (cursors.up.isDown)
	    {
	        game.camera.y -= 4
	    }
	    else if (cursors.down.isDown)
	    {
	        game.camera.y += 4
	    }
	
	}
	
	override fun render() {
	
	}
}