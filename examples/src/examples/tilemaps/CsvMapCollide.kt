
package examples.tilemaps


import Phaser.*

class CsvMapCollide: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("map", "assets/tilemaps/csv/catastrophi_level2.csv", null, Phaser.Tilemap.CSV)
	    game.load.image("tiles", "assets/tilemaps/tiles/catastrophi_tiles_16.png")
	    game.load.spritesheet("player", "assets/sprites/spaceman.png", 16, 16)
	
	}
	
	lateinit var map:Tilemap
	lateinit var layer:TilemapLayer
	lateinit var cursors:CursorKeys
	lateinit var player:Sprite
	
	override fun create() {
	
	    //  Because we"re loading CSV map data we have to specify the tile size here or we can"t render it
	    map = game.add.tilemap("map", 16, 16)
	
	    //  Now add in the tileset
	    map.addTilesetImage("tiles")
	    
	    //  Create our layer
	    layer = map.createLayer(0)
	
	    //  Resize the world
	    layer.resizeWorld()
	
	    //  This isn"t totally accurate, but it"ll do for now
	    map.setCollisionBetween(54, 83)
	
	    //  Un-comment this on to see the collision tiles
	    // layer.debug = true
	
	    //  Player
	    player = game.add.sprite(48, 48, "player", 1)
	    player.animations.add("left", arrayOf(8,9), 10, true)
	    player.animations.add("right", arrayOf(1,2), 10, true)
	    player.animations.add("up", arrayOf(11,12,13), 10, true)
	    player.animations.add("down", arrayOf(4,5,6), 10, true)
	
	    game.physics.enable(player, Phaser.Physics.ARCADE)
	
	    player.body.setSize(10, 14, 2, 1)
	
	    game.camera.follow(player)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    var help = game.add.text(16, 16, "Arrows to move", TextStyle(font="14px Arial",fill="#ffffff" ))
	    help.fixedToCamera = true
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(player, layer)
	
	    player.body.velocity.set(0)
	
	    if (cursors.left.isDown)
	    {
	        player.body.velocity.x = -100.0
	        player.play("left")
	    }
	    else if (cursors.right.isDown)
	    {
	        player.body.velocity.x = 100.0
	        player.play("right")
	    }
	    else if (cursors.up.isDown)
	    {
	        player.body.velocity.y = -100.0
	        player.play("up")
	    }
	    else if (cursors.down.isDown)
	    {
	        player.body.velocity.y = 100.0
	        player.play("down")
	    }
	    else
	    {
	        player.animations.stop()
	    }
	
	}
	
	override fun render() {
	
	    // game.debug.body(player)
	
	}
}