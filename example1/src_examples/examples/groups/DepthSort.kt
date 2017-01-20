
package examples.groups


import Phaser.*

class DepthSort: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser-dude.png")
	    game.load.tilemap("desert", "assets/tilemaps/maps/depthsort.json", null, Phaser.Tilemap.TILED_JSON)
	    game.load.image("ground_1x1", "assets/tilemaps/tiles/ground_1x1.png")
	    game.load.spritesheet("trees", "assets/tilemaps/tiles/walls_1x2.png", 32, 64)
	
	}
	
	lateinit var map:Tilemap
	lateinit var tileset:Tileset
	lateinit var layer:TilemapLayer
	
	lateinit var sprite:Sprite
	lateinit var group:Group
	var oldY = 0
	lateinit var cursors:CursorKeys
	var locs = mutableListOf<Number>()
	
	override fun create() {
	
	    //  Create our tilemap to walk around
	    map = game.add.tilemap("desert")
	    map.addTilesetImage("ground_1x1")
	    layer = map.createLayer("Tile Layer 1")
	
	    //  This group will hold the main player + all the tree sprites to depth sort against
	    group = game.add.group()
	
	    //  Create some trees, each in a unique location
	    for(i in 0..200-1)
	    {
	        createUniqueLocation()
	    }
	
	    sprite = group.create(300, 28, "phaser")
	
	    group.sort()
	
	    //  Move it
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	fun createUniqueLocation() {
		var x = 0
		var y = 0
		var idx  = 0
		do {
	        x = Phaser.Math.snapTo(game.world.randomX, 32).toInt() / 32
	        y = Phaser.Math.snapTo(game.world.randomY, 32).toInt() / 32
	
	        if (y > 17)
	        {
	            y = 17
	        }
	
	        idx = (y * 17) + x
	    }
	    while (locs.indexOf(idx) !== -1)
	
	    locs.add(idx)
	
	    group.create(x * 32, y * 32, "trees", game.rnd.integerInRange(0, 7))
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	        sprite.x -= 2
	    }
	    else if (cursors.right.isDown)
	    {
	        sprite.x += 2
	    }
	
	    if (cursors.up.isDown)
	    {
	        sprite.y -= 2
	    }
	    else if (cursors.down.isDown)
	    {
	        sprite.y += 2
	    }
	
	    group.sort("y", Phaser.Group.SORT_ASCENDING)
	
	}
	
	override fun render() {
	
	    game.debug.text("Sprite z-depth: " + sprite.z, 10, 20)
	
	}
}