
package examples.tilemaps


import Phaser.*

class TileProperties: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("map", "assets/tilemaps/maps/tile_properties.json", null, Phaser.Tilemap.TILED_JSON)
	    game.load.image("tiles", "assets/tilemaps/tiles/gridtiles.png")
	
	}
	
	lateinit var map:Tilemap
	lateinit var layer:TilemapLayer
	lateinit var marker:Graphics
	
	// lateinit var sprite:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    map = game.add.tilemap("map")
	
	    map.addTilesetImage("tiles")
	
	    // map.setCollisionBetween(1, 12)
	
	    layer = map.createLayer("Tile Layer 1")
	
	    layer.resizeWorld()
	
	    //  Our painting marker
	    marker = game.add.graphics()
	    marker.lineStyle(2, 0xffffff, 1)
	    marker.drawRect(0, 0, 32, 32)
	
	    game.input.addMoveCallback(this::updateMarker, this)
	
	    game.input.onDown.add(this::getTileProperties, this)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	fun getTileProperties() {
	
	    var x = layer.getTileX(game.input.activePointer.worldX)
	    var y = layer.getTileY(game.input.activePointer.worldY)
	
	    var tile = map.getTile(x, y, layer)!!
	
	    tile.properties.wibble = true
	
	}
	
	fun updateMarker() {
	
	    marker.x = layer.getTileX(game.input.activePointer.worldX) * 32
	    marker.y = layer.getTileY(game.input.activePointer.worldY) * 32
	
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
	
	    // game.debug.text("Current Layer: " + currentLayer.name, 16, 550)
	    // game.debug.text("1-3 Switch Layers. SPACE = Show All. Cursors = Move Camera", 16, 570)
	
	}
}