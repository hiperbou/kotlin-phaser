
package examples.games


import Phaser.*

class Starstruck: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("level1", "assets/games/starstruck/level1.json", null, Phaser.Tilemap.TILED_JSON)
	    game.load.image("tiles-1", "assets/games/starstruck/tiles-1.png")
	    game.load.spritesheet("dude", "assets/games/starstruck/dude.png", 32, 48)
	    game.load.spritesheet("droid", "assets/games/starstruck/droid.png", 32, 32)
	    game.load.image("starSmall", "assets/games/starstruck/star.png")
	    game.load.image("starBig", "assets/games/starstruck/star2.png")
	    game.load.image("background", "assets/games/starstruck/background2.png")
	
	}
	
	lateinit var map:Tilemap
	lateinit var tileset:Tileset
	lateinit var layer:TilemapLayer
	lateinit var player:Sprite
	var facing = "left"
	var jumpTimer = 0.0
	lateinit var cursors:CursorKeys
	lateinit var jumpButton:Key
	lateinit var bg:TileSprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#000000"
	
	    bg = game.add.tileSprite(0, 0, 800, 600, "background")
	    bg.fixedToCamera = true
	
	    map = game.add.tilemap("level1")
	
	    map.addTilesetImage("tiles-1")
	
	    map.setCollisionByExclusion(arrayOf( 13, 14, 15, 16, 46, 47, 48, 49, 50, 51 ))
	
	    layer = map.createLayer("Tile Layer 1")
	
	    //  Un-comment this on to see the collision tiles
	    // layer.debug = true
	
	    layer.resizeWorld()
	
	    game.physics.arcade.gravity.y = 250.0
	
	    player = game.add.sprite(32, 32, "dude")
	    game.physics.enable(player, Phaser.Physics.ARCADE)
	
	    player.body.bounce.y = 0.2
	    player.body.collideWorldBounds = true
	    player.body.setSize(20, 32, 5, 16)
	
	    player.animations.add("left", arrayOf(0, 1, 2, 3), 10, true)
	    player.animations.add("turn", arrayOf(4), 20, true)
	    player.animations.add("right", arrayOf(5, 6, 7, 8), 10, true)
	
	    game.camera.follow(player)
	
	    cursors = game.input.keyboard.createCursorKeys()
	    jumpButton = game.input.keyboard.addKey(Phaser.Keyboard.SPACEBAR)
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(player, layer)
	
	    player.body.velocity.x = 0.0
	
	    if (cursors.left.isDown)
	    {
	        player.body.velocity.x = -150.0
	
	        if (facing != "left")
	        {
	            player.animations.play("left")
	            facing = "left"
	        }
	    }
	    else if (cursors.right.isDown)
	    {
	        player.body.velocity.x = 150.0
	
	        if (facing != "right")
	        {
	            player.animations.play("right")
	            facing = "right"
	        }
	    }
	    else
	    {
	        if (facing != "idle")
	        {
	            player.animations.stop()
	
	            if (facing == "left")
	            {
	                player.frame = 0
	            }
	            else
	            {
	                player.frame = 5
	            }
	
	            facing = "idle"
	        }
	    }
	    
	    if (jumpButton.isDown && player.body.onFloor() && game.time.now > jumpTimer)
	    {
	        player.body.velocity.y = -250.0
	        jumpTimer = game.time.now + 750
	    }
	
	}
	
	override fun render() {
	
	    // game.debug.text(game.time.physicsElapsed, 32, 32)
	    // game.debug.body(player)
	    // game.debug.bodyInfo(player, 16, 24)
	
	}
}