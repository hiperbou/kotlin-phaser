
package examples.weapon

import Koala.initKoala
import Phaser.*

class BulletSpeedVariance: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("bullet", "assets/sprites/bullet.png")
	    game.load.image("ship", "assets/sprites/shmup-ship.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var weapon:Weapon
	lateinit var cursors:CursorKeys
	lateinit var fireButton:Key
	
	override fun create() {
	
	    //  Creates 30 bullets, using the "bullet" graphic
	    weapon = game.add.weapon(30, "bullet")
	
	    //  The bullet will be automatically killed when it leaves the world bounds
	    weapon.bulletKillType = Phaser.Weapon.KILL_WORLD_BOUNDS
	
	    //  Because our bullet is drawn facing up, we need to offset its rotation:
	    weapon.bulletAngleOffset = 90
	
	    //  The speed at which the bullet is fired
	    weapon.bulletSpeed = 400
	
	    //  Speed-up the rate of fire, allowing them to shoot 1 bullet every 60ms
	    weapon.fireRate = 60
	
	    //  Add a variance to the bullet speed by +- this value
	    weapon.bulletSpeedVariance = 200
	
	    sprite = add.sprite(320, 500, "ship")
	
	    game.physics.arcade.enable(sprite)
	
	    //  Tell the Weapon to track the "player" Sprite, offset by 14px horizontally, 0 vertically
	    weapon.trackSprite(sprite, 14, 0)
	
	    cursors = input.keyboard.createCursorKeys()
	
	    fireButton = input.keyboard.addKey(Phaser.KeyCode.SPACEBAR)
	
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
	        weapon.fire()
	    }
	
	}
	
	override fun render() {
	
	    weapon.debug()
	
	}
}