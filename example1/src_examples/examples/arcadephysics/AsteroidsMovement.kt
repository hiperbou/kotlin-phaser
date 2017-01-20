
package examples.arcadephysics


import Phaser.*

class AsteroidsMovement: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("space", "assets/skies/deep-space.jpg")
	    game.load.image("bullet", "assets/games/asteroids/bullets.png")
	    game.load.image("ship", "assets/games/asteroids/ship.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var cursors:CursorKeys
	
	var bullet:Sprite? = null
	lateinit var bullets:Group
	var bulletTime = 0.0
	
	override fun create() {
	
	    //  This will run in Canvas mode, so let"s gain a little speed and display
	    game.renderer.clearBeforeRender = false
	    game.renderer.roundPixels = true
	
	    //  We need arcade physics
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    //  A spacey background
	    game.add.tileSprite(0, 0, game.width, game.height, "space")
	
	    //  Our ships bullets
	    bullets = game.add.group()
	    bullets.enableBody = true
	    bullets.physicsBodyType = Phaser.Physics.ARCADE
	
	    //  All 40 of them
	    bullets.createMultiple(40, "bullet")
	    bullets.setAll("anchor.x", 0.5)
	    bullets.setAll("anchor.y", 0.5)
	
	    //  Our player ship
	    sprite = game.add.sprite(300, 300, "ship")
	    sprite.anchor.set(0.5)
	
	    //  and its physics settings
	    game.physics.enable(sprite, Phaser.Physics.ARCADE)
	
	    sprite.body.drag.set(100)
	    sprite.body.maxVelocity.set(200)
	
	    //  Game input
	    cursors = game.input.keyboard.createCursorKeys()
	    game.input.keyboard.addKeyCapture(arrayOf(Phaser.Keyboard.SPACEBAR))
	
	}
	
	override fun update() {
	
	    if (cursors.up.isDown)
	    {
	        game.physics.arcade.accelerationFromRotation(sprite.rotation, 200, sprite.body.acceleration)
	    }
	    else
	    {
	        sprite.body.acceleration.set(0)
	    }
	
	    if (cursors.left.isDown)
	    {
	        sprite.body.angularVelocity = -300
	    }
	    else if (cursors.right.isDown)
	    {
	        sprite.body.angularVelocity = 300
	    }
	    else
	    {
	        sprite.body.angularVelocity = 0
	    }
	
	    if (game.input.keyboard.isDown(Phaser.Keyboard.SPACEBAR))
	    {
	        fireBullet()
	    }
	
	    screenWrap(sprite)
	
	    bullets.forEachExists(this::screenWrap, this)
	
	}
	
	fun fireBullet () {
	
	    if (game.time.now > bulletTime)
	    {
	        bullet = bullets.getFirstExists<Sprite>(false)
	
	        if (bullet != null)
	        {
				val bullet = bullet!!
	            bullet.reset(sprite.body.x + 16, sprite.body.y + 16)
	            bullet.lifespan = 2000
	            bullet.rotation = sprite.rotation
	            game.physics.arcade.velocityFromRotation(sprite.rotation, 400, bullet.body.velocity)
	            bulletTime = game.time.now + 50
	        }
	    }
	
	}
	
	fun screenWrap(sprite:Sprite) {
	
	    if (sprite.x < 0)
	    {
	        sprite.x = game.width
	    }
	    else if (sprite.x > game.width)
	    {
	        sprite.x = 0.0
	    }
	
	    if (sprite.y < 0)
	    {
	        sprite.y = game.height
	    }
	    else if (sprite.y > game.height)
	    {
	        sprite.y = 0.0
	    }
	
	}
	
	override fun render() {
	}
}