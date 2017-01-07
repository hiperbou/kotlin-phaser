
package examples.weapon

import Koala.initKoala
import Phaser.*

class FireMany: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    //  Bullet Sprites from http://opengameart.org/content/bullet-collection-1-m484
	
	    game.load.image("bullet", "assets/bullets/bullet22.png")
	
	}
	
	lateinit var weapon:Weapon
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
	
	    //  One "set" of bullets, every second
	    weapon.fireRate = 250
	
	    bulletPositions = arrayOf<Any>(
	        object{ var  x= 100;  var  y= 600 },
	        object{ var  x= 200;  var  y= 550 },
	        object{ var  x= 300;  var  y= 500 },
	        object{ var  x= 400;  var  y= 450 },
	        object{ var  x= 500;  var  y= 500 },
	        object{ var  x= 600;  var  y= 550 },
	        object{ var  x= 700;  var  y= 600 }
		)
	
	    game.input.onDown.add(this::fire, this)
	
	}
	
	fun fire () {
	
	    weapon.fireMany(bulletPositions)
	
	}
	
	override fun render() {
	
	    weapon.debug()
	
	    game.debug.text("Click to fire", 600, 32)
	
	}
}