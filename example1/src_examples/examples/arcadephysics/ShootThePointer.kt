
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class ShootThePointer: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("arrow", "assets/sprites/arrow.png")
	    game.load.image("bullet", "assets/sprites/purple_ball.png")
	    
	}
	
	lateinit var sprite:Sprite
	lateinit var bullets:Group
	
	var fireRate = 100
	var nextFire = 0.0
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#313131"
	
	    bullets = game.add.group()
	    bullets.enableBody = true
	    bullets.physicsBodyType = Phaser.Physics.ARCADE
	
	    bullets.createMultiple(50, "bullet")
	    bullets.setAll("checkWorldBounds", true)
	    bullets.setAll("outOfBoundsKill", true)
	    
	    sprite = game.add.sprite(400, 300, "arrow")
	    sprite.anchor.set(0.5)
	
	    game.physics.enable(sprite, Phaser.Physics.ARCADE)
	
	    sprite.body.allowRotation = false
	
	}
	
	override fun update() {
	
	    sprite.rotation = game.physics.arcade.angleToPointer(sprite)
	
	    if (game.input.activePointer.isDown)
	    {
	        fire()
	    }
	
	}
	
	fun fire() {
	
	    if (game.time.now > nextFire && bullets.countDead() > 0)
	    {
	        nextFire = game.time.now + fireRate
	
	        var bullet = bullets.getFirstDead<Sprite>()!!
	
	        bullet.reset(sprite.x - 8, sprite.y - 8)
	
	        game.physics.arcade.moveToPointer(bullet, 300)
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Active Bullets: " + bullets.countLiving() + " / " + bullets.total, 32, 32)
	    game.debug.spriteInfo(sprite, 32, 450)
	
	}
}