
package examples.weapon


import Phaser.*

class MultipleBullets: State() {
	
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
	
	    //  Creates 40 bullets, using the "bullet" graphic
	    weapon = game.add.weapon(40, "bullet")
	
	    //  The bullets will be automatically killed when they leave the world bounds
	    weapon.bulletKillType = Phaser.Weapon.KILL_WORLD_BOUNDS
	
	    //  Because our bullet is drawn facing up, we need to offset its rotation:
	    weapon.bulletAngleOffset = 90.0
	
	    //  The speed at which the bullets are fired
	    weapon.bulletSpeed = 400.0
	
	    sprite = add.sprite(320, 500, "ship")
	
	    game.physics.arcade.enable(sprite)
	
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
	
	    var x = sprite.x
	    var y = sprite.y
	
	    if (fireButton.isDown)
	    {
	        weapon.fireRate = 0.0
	        weapon.fire(object{ var  x= x;  var  y= y })
	        weapon.fire(object{ var  x= x + 10;  var  y= y })
	        weapon.fire(object{ var  x= x + 20;  var  y= y })
	        weapon.fire(object{ var  x= x + 30;  var  y= y })
	    }
	    
	    weapon.fireRate = 200.0
	
	}
	
	override fun render() {
	
	    weapon.debug()
	
	}
}