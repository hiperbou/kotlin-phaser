
package examples.p2physics


import Phaser.*

class ImpactEvents: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("stars", "assets/misc/starfield.jpg")
	    game.load.spritesheet("ship", "assets/sprites/humstar.png", 32, 32)
	    game.load.image("panda", "assets/sprites/spinObj_01.png")
	    game.load.image("sweet", "assets/sprites/spinObj_06.png")
	
	}
	
	lateinit var ship:Sprite
	lateinit var starfield:TileSprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.P2JS)
	    game.physics.p2.restitution = 0.9
	
	    starfield = game.add.tileSprite(0, 0, 800, 600, "stars")
	    starfield.fixedToCamera = true
	
	    var panda = game.add.sprite(game.world.randomX, game.world.randomY, "panda")
	    game.physics.p2.enable(panda, false)
	    panda.body.setRectangle(40, 40, 0, 0)
	
	    var sweet = game.add.sprite(game.world.randomX, game.world.randomY, "sweet")
	    game.physics.p2.enable(sweet, false)
	    sweet.body.setRectangle(40, 40, 0, 0)
	
	    ship = game.add.sprite(200, 200, "ship")
	    ship.scale.set(2)
	    ship.smoothed = false
	    ship.animations.add("fly", arrayOf(0,1,2,3,4,5), 10, true)
	    ship.play("fly")
	
	    //  Create our physics body - a 28px radius circle. Set the "false" parameter below to "true" to enable debugging
	    game.physics.p2.enable(ship, false)
	
	    ship.body.setCircle(28)
	    ship.body.fixedRotation = true
	
	    game.camera.follow(ship)
	
	    //  Here we create a Body specific callback.
	    //  Note that only impact events between the ship and the panda are used here, the sweet/candy object is ignored.
	    ship.body.createBodyCallback(panda, this::hitPanda, this)
	
	    //  And before this will happen, we need to turn on impact events for the world
	    game.physics.p2.setImpactEvents(true)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	fun hitPanda(body1:Physics.P2.Body, body2:Physics.P2.Body) {
	
	    //  body1 is the space ship (as it"s the body that owns the callback)
	    //  body2 is the body it impacted with, in this case our panda
	    //  As body2 is a Phaser.Physics.P2.Body object, you access its owner (the sprite) via the sprite property:
	    body2.sprite.alpha -= 0.1
	
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
	        starfield.tilePosition.x += (ship.body.velocity.x as Double * 16) * game.time.physicsElapsed
	    }
	
	    if (!game.camera.atLimit.y)
	    {
	        starfield.tilePosition.y += (ship.body.velocity.y as Double * 16) * game.time.physicsElapsed
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Collide with the Panda!", 32, 32)
	
	}
}