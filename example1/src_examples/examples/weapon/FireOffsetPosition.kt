
package examples.weapon


import Phaser.*

class FireOffsetPosition: State() {
	
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
	
	        weapon.fireOffset(0, -32)
	
	        weapon.fireOffset(-16, -16)
	        weapon.fireOffset(16, -16)
	
	        weapon.fireOffset(-32, 0)
	        weapon.fireOffset(0, 0)
	        weapon.fireOffset(32, 0)
	    }
	
	}
	
	override fun render() {
	
	    weapon.debug()
	
	}
}