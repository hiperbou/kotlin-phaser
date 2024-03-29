
package examples.weapon


import Phaser.*

class AsteroidsBulletWrap: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("bullet", "assets/sprites/shmup-bullet.png")
	    game.load.image("ship", "assets/sprites/thrust_ship.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var weapon:Weapon
	lateinit var cursors:CursorKeys
	lateinit var fireButton:Key
	
	override fun create() {
	
	    //  Creates 30 bullets, using the "bullet" graphic
	    weapon = game.add.weapon(30, "bullet")
	
	    //  The bullets will be automatically killed when they are 2000ms old
	    weapon.bulletKillType = Phaser.Weapon.KILL_LIFESPAN
	    weapon.bulletLifespan = 2000.0
	
	    //  The speed at which the bullet is fired
	    weapon.bulletSpeed = 600.0
	
	    //  Speed-up the rate of fire, allowing them to shoot 1 bullet every 60ms
	    weapon.fireRate = 100.0
	
	    //  Wrap bullets around the world bounds to the opposite side
	    weapon.bulletWorldWrap = true
	
	    sprite = add.sprite(400, 300, "ship")
	
	    sprite.anchor.set(0.5)
	
	    game.physics.arcade.enable(sprite)
	
	    sprite.body.drag.set(70)
	    sprite.body.maxVelocity.set(200)
	
	    //  Tell the Weapon to track the "player" Sprite
	    //  With no offsets from the position
	    //  But the "true" argument tells the weapon to track sprite rotation
	    weapon.trackSprite(sprite, 0, 0, true)
	
	    cursors = input.keyboard.createCursorKeys()
	
	    fireButton = input.keyboard.addKey(Phaser.KeyCode.SPACEBAR)
	
	}
	
	override fun update() {
	
	    if (cursors.up.isDown)
	    {
	        game.physics.arcade.accelerationFromRotation(sprite.rotation, 300, sprite.body.acceleration)
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
	
	    if (fireButton.isDown)
	    {
	        weapon.fire()
	    }
	
	    game.world.wrap(sprite, 16)
	
	}
	
	override fun render() {
	
	    weapon.debug()
	
	}
}