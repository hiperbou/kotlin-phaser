
package examples.p2physics

import Koala.initKoala
import Phaser.*

class CollideWorldBounds: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("stars", "assets/misc/starfield.jpg")
	    game.load.spritesheet("ship", "assets/sprites/humstar.png", 32, 32)
	
	}
	
	lateinit var ship:Sprite
	lateinit var starfield:TileSprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    starfield = game.add.tileSprite(0, 0, 800, 600, "stars")
	
	    game.physics.startSystem(Phaser.Physics.P2JS)
	
	    game.physics.p2.restitution = 0.8
	
	    ship = game.add.sprite(200, 200, "ship")
	    ship.scale.set(2)
	    ship.smoothed = false
	    ship.animations.add("fly", arrayOf(0,1,2,3,4,5), 10, true)
	    ship.play("fly")
	
	    //  Create our physics body. A circle assigned the playerCollisionGroup
	    game.physics.p2.enable(ship)
	
	    ship.body.setCircle(28)
	
	    //  This boolean controls if the player should collide with the world bounds or not
	    ship.body.collideWorldBounds = true
	
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
	
	}
}