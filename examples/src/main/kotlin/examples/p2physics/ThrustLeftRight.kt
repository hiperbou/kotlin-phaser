
package examples.p2physics


import Phaser.*

class ThrustLeftRight: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("stars", "assets/misc/starfield.jpg")
	    game.load.image("ship", "assets/sprites/thrust_ship2.png")
	
	}
	
	lateinit var ship:Sprite
	lateinit var starfield:TileSprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.world.setBounds(0, 0, 1920, 1200)
	
	    game.physics.startSystem(Phaser.Physics.P2JS)
	    game.physics.p2.restitution = 0.8
	
	    starfield = game.add.tileSprite(0, 0, 800, 600, "stars")
	    starfield.fixedToCamera = true
	
	    ship = game.add.sprite(200, 200, "ship")
	
	    game.physics.p2.enable(ship)
	
	    game.camera.follow(ship)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	        ship.body.thrustLeft(100)
	    }
	    else if (cursors.right.isDown)
	    {
	        ship.body.thrustRight(100)
	    }
	
	    if (cursors.up.isDown)
	    {
	        ship.body.thrust(400)
	    }
	    else if (cursors.down.isDown)
	    {
	        ship.body.reverse(400)
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
}