
package examples.tilesprites


import Phaser.*

class CollidingWithTilingSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	lateinit var ball:Sprite
	lateinit var tilesprite:TileSprite
	lateinit var cursors:CursorKeys
	
	override fun preload() {
	
	    game.load.image("starfield", "assets/misc/starfield.jpg")
	    game.load.image("ball", "assets/sprites/pangball.png")
	
	}
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.physics.arcade.gravity.y = 200.0
	
	    ball = game.add.sprite(400, 0, "ball")
	    tilesprite = game.add.tileSprite(300, 450, 200, 100, "starfield")

	    game.physics.enable(arrayOf( ball, tilesprite ), Phaser.Physics.ARCADE)

	    ball.body.collideWorldBounds = true
	    ball.body.bounce.set(1)
	
	    tilesprite.body.collideWorldBounds = true
	    tilesprite.body.immovable = true
	    tilesprite.body.allowGravity = false
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(ball, tilesprite)
	
	    if (cursors.left.isDown)
	    {
	        tilesprite.body.x -= 8
	        tilesprite.tilePosition.x -= 8
	    }
	    else if (cursors.right.isDown)
	    {
	        tilesprite.body.x += 8
	        tilesprite.tilePosition.x += 8
	    }
	
	    if (cursors.up.isDown)
	    {
	        tilesprite.tilePosition.y += 8
	    }
	    else if (cursors.down.isDown)
	    {
	        tilesprite.tilePosition.y -= 8
	    }
	
	}
	
	override fun render() {
	
	    // game.debug.body(ball)
	    // game.debug.body(tilesprite)
	
	}
}