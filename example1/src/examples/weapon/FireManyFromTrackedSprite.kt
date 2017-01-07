
package examples.weapon

import Koala.initKoala
import Phaser.*

class FireManyFromTrackedSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("bullet", "assets/bullets/bullet198.png")
	    game.load.image("ship", "assets/sprites/shmup-ship.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var weapon:Weapon
	lateinit var cursors:CursorKeys
	lateinit var fireButton:Key
	lateinit var bulletPositions:Array<Any>
	
	override fun create() {
	
	    //  Creates the bullets, using the "bullet" graphic
	    weapon = game.add.weapon(6*8, "bullet")
	
	    //  The bullet will be automatically killed when it leaves the world bounds
	    weapon.bulletKillType = Phaser.Weapon.KILL_LIFESPAN
	
	    //  Bullets live for 2 seconds
	    weapon.bulletLifespan = 2000
	
	    //  Because our bullet is drawn facing up, we need to offset its rotation:
	    weapon.bulletAngleOffset = 90
	
	    //  The speed at which the bullet is fired
	    weapon.bulletSpeed = 400
	
	    // weapon.bulletAngleVariance = 20
	
	    sprite = add.sprite(320, 500, "ship")
	
	    game.physics.arcade.enable(sprite)
	
	    //  Tell the Weapon to track the "player" Sprite, offset by 14px horizontally, 0 vertically
	    weapon.trackSprite(sprite, 14, 0)
	
	    //  One "set" of bullets, every second
	    weapon.fireRate = 250
	
	    //  Tell the Weapon plugin it can fire more than once per game loop
	    weapon.multiFire = true
	
	    cursors = input.keyboard.createCursorKeys()
	
	    fireButton = input.keyboard.addKey(Phaser.KeyCode.SPACEBAR)
	
	    bulletPositions = arrayOf<Any>(
	        object{ var  x= 0;  var  y= -32 },
	        object{ var  x= -16;  var  y= -16 },
	        object{ var  x= 16;  var  y= -16 },
	        object{ var  x= -32;  var  y= 0 },
	        object{ var  x= 0;  var  y= 0 },
	        object{ var  x= 32;  var  y= 0 }
		)
	
	}
	
	override fun update() {
	
	    sprite.body.velocity.x = 0
	
	    if (cursors.left.isDown)
	    {
	        sprite.body.velocity.x = -200
	    }
	    else if (cursors.right.isDown)
	    {
	        sprite.body.velocity.x = 200
	    }
	
	    if (fireButton.isDown)
	    {
	        //  Fire 6 bullets in an arrow formation:
	        weapon.fireMany(bulletPositions)
	    }
	
	}
	
	override fun render() {
	
	    weapon.debug()
	
	}
}