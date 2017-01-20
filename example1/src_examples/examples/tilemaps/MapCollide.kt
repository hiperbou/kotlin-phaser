
package examples.tilemaps


import Phaser.*

class MapCollide: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("mario", "assets/tilemaps/maps/super_mario.json", null, Phaser.Tilemap.TILED_JSON)
	    game.load.image("tiles", "assets/tilemaps/tiles/super_mario.png")
	    game.load.image("player", "assets/sprites/phaser-dude.png")
	
	}
	
	lateinit var map:Tilemap
	lateinit var tileset:Tileset
	lateinit var layer:TilemapLayer
	lateinit var p:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#787878"
	
	    map = game.add.tilemap("mario")
	
	    map.addTilesetImage("SuperMarioBros-World1-1", "tiles")
	
	    //  14 = ? block
	    // map.setCollisionBetween(14, 15)
	
	    map.setCollisionBetween(15, 16)
	    map.setCollisionBetween(20, 25)
	    map.setCollisionBetween(27, 29)
	    map.setCollision(40)
	    
	    layer = map.createLayer("World1")
	
	    layer.scale.set(0.5)
	
	    //  Un-comment this on to see the collision tiles
	    // layer.debug = true
	
	    layer.resizeWorld()
	
	    p = game.add.sprite(32, 32, "player")
	
	    game.physics.enable(p)
	
	    game.physics.arcade.gravity.y = 250.0
	
	    p.body.bounce.y = 0.2
	    //p.body.linearDamping = 1
	    p.body.collideWorldBounds = true
	
	    game.camera.follow(p)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(p, layer)
	
	    p.body.velocity.x = 0.0
	
	    if (cursors.up.isDown)
	    {
	        if (p.body.onFloor())
	        {
	            p.body.velocity.y = -200.0
	        }
	    }
	
	    if (cursors.left.isDown)
	    {
	        p.body.velocity.x = -150.0
	    }
	    else if (cursors.right.isDown)
	    {
	        p.body.velocity.x = 150.0
	    }
	
	}
	
	override fun render() {
	
	    // game.debug.body(p)
	    game.debug.bodyInfo(p, 32, 320)
	
	}
}