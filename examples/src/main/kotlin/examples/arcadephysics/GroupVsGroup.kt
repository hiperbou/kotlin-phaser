
package examples.arcadephysics


import Phaser.*

class GroupVsGroup: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser-dude.png")
	    game.load.image("bullet", "assets/misc/bullet0.png")
	    game.load.spritesheet("veggies", "assets/sprites/fruitnveg32wh37.png", 32, 32)
	
	}
	
	lateinit var sprite:Sprite
	lateinit var bullets:Group
	lateinit var veggies:Group
	lateinit var cursors:CursorKeys
	
	var bulletTime = 0.0
	var bullet:Sprite? = null
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    //  This will check Group vs. Group collision (bullets vs. veggies!)
	
	    veggies = game.add.group()
	    veggies.enableBody = true
	    veggies.physicsBodyType = Phaser.Physics.ARCADE
	
	    for(i in 0..50-1)
	    {
	        var c = veggies.create(game.world.randomX, Math.random() * 500, "veggies", game.rnd.integerInRange(0, 36))
	        c.name = "veg" + i
	        c.body.immovable = true
	    }
	
	    bullets = game.add.group()
	    bullets.enableBody = true
	    bullets.physicsBodyType = Phaser.Physics.ARCADE
	
	    for(i in 0..20-1)
	    {
	        var b = bullets.create(0, 0, "bullet")
	        b.name = "bullet" + i
	        b.exists = false
	        b.visible = false
	        b.checkWorldBounds = true
	        b.events.onOutOfBounds.add(this::resetBullet, this)
	    }
	
	    sprite = game.add.sprite(400, 550, "phaser")
	    game.physics.enable(sprite, Phaser.Physics.ARCADE)
	
	    cursors = game.input.keyboard.createCursorKeys()
	    game.input.keyboard.addKeyCapture(arrayOf( Phaser.Keyboard.SPACEBAR ))
	
	}
	
	override fun update() {
	
	    //  As we don"t need to exchange any velocities or motion we can the "overlap" check instead of "collide"
	    game.physics.arcade.overlap(bullets, veggies, this::collisionHandler, null, this)
	
	    sprite.body.velocity.x = 0
	    sprite.body.velocity.y = 0
	
	    if (cursors.left.isDown)
	    {
	        sprite.body.velocity.x = -300
	    }
	    else if (cursors.right.isDown)
	    {
	        sprite.body.velocity.x = 300
	    }
	
	    if (game.input.keyboard.isDown(Phaser.Keyboard.SPACEBAR))
	    {
	        fireBullet()
	    }
	
	}
	
	fun fireBullet () {
	
	    if (game.time.now > bulletTime)
	    {
	        bullet = bullets.getFirstExists<Sprite>(false)
	
	        if (bullet != null)
	        {
				val bullet = bullet!!
	            bullet.reset(sprite.x + 6, sprite.y - 8)
	            bullet.body.velocity.y = -300
	            bulletTime = game.time.now + 150
	        }
	    }
	
	}
	
	//  Called if the bullet goes out of the screen
	fun resetBullet(bullet:Sprite) {
	
	    bullet.kill()
	
	}
	
	//  Called if the bullet hits one of the veg sprites
	fun collisionHandler (bullet:Sprite, veg:Sprite) {
	
	    bullet.kill()
	    veg.kill()
	
	}
}