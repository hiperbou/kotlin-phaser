
package examples.p2physics

import Koala.initKoala
import Phaser.*

class WorldMove: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("stars", "assets/misc/starfield.jpg")
	    game.load.spritesheet("ship", "assets/sprites/humstar.png", 32, 32)
	    game.load.image("ball", "assets/sprites/shinyball.png")
	
	}
	
	lateinit var ship:Sprite
	lateinit var starfield:TileSprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.world.setBounds(0, 0, 1600, 1200)
	
	    game.physics.startSystem(Phaser.Physics.P2JS)
	    game.physics.p2.restitution = 0.9
	
	    starfield = game.add.tileSprite(0, 0, 800, 600, "stars")
	    starfield.fixedToCamera = true
	
	    val balls = game.add.group()
	    balls.enableBody = true
	    balls.physicsBodyType = Phaser.Physics.P2JS
	
	    for(i in 0..50-1)
	    {
	        var ball = balls.create(game.world.randomX, game.world.randomY, "ball")
	        ball.body.setCircle(16)
	    }
	
		ship = game.add.sprite(200, 200, "ship")
	    ship.scale.set(2)
	    ship.smoothed = false
	    ship.animations.add("fly", arrayOf(0,1,2,3,4,5), 10, true)
	    ship.play("fly")
	
	    //  Create our physics body - a 28px radius circle. Set the "false" parameter below to "true" to enable debugging
		game.physics.p2.enable(ship, false)
	    ship.body.setCircle(28)
	
		game.camera.follow(ship)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    ship.body.setZeroVelocity()
	
	    if (cursors.left.isDown)
	    {
			ship.body.moveLeft(200)
	    }
	    else if (cursors.right.isDown)
	    {
			ship.body.moveRight(200)
	    }
	
	    if (cursors.up.isDown)
	    {
	    	ship.body.moveUp(200)
	    }
	    else if (cursors.down.isDown)
	    {
	        ship.body.moveDown(200)
	    }
	
	    if (!game.camera.atLimit.x)
	    {
	        starfield.tilePosition.x -= (ship.body.velocity.x as Double * game.time.physicsElapsed)
	    }
	
	    if (!game.camera.atLimit.y)
	    {
	        starfield.tilePosition.y -= (ship.body.velocity.y as Double * game.time.physicsElapsed)
	    }
	
	}
	
	override fun render() {
	
	}
}