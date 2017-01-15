
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class GlobalPause: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("car", "assets/sprites/car90.png")
	    game.load.image("baddie", "assets/sprites/space-baddie.png")
	
	}
	
	lateinit var car:Sprite
	lateinit var aliens:Group
	lateinit var cursors:CursorKeys
	lateinit var spaceKey:Key
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    aliens = game.add.group()
	    aliens.enableBody = true
	
	    for(i in 0..50-1)
	    {
	        var s = aliens.create(game.world.randomX, game.world.randomY, "baddie")
	        s.name = "alien" + s
	        s.body.collideWorldBounds = true
	        s.body.bounce.setTo(0.8, 0.8)
	        s.body.velocity.setTo(10 + Math.random() * 40, 10 + Math.random() * 40)
	    }
	
	    car = game.add.sprite(400, 300, "car")
	    car.name = "car"
	    car.anchor.set(0.5)
	
	    game.physics.enable(car, Phaser.Physics.ARCADE)
	
	    car.body.collideWorldBounds = true
	    car.body.bounce.set(0.8)
	    car.body.allowRotation = true
	    car.body.immovable = true
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    spaceKey = input.keyboard.addKey(Phaser.Keyboard.SPACEBAR)
	    spaceKey.onDown.add(this::togglePause, this)
	
	}
	
	fun togglePause() {
	
	    game.physics.arcade.isPaused = if (game.physics.arcade.isPaused) false else true
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(car, aliens)
	
	    car.body.velocity.x = 0
	    car.body.velocity.y = 0
	    car.body.angularVelocity = 0
	
	    if (cursors.left.isDown)
	    {
	        car.body.angularVelocity = -200
	    }
	    else if (cursors.right.isDown)
	    {
	        car.body.angularVelocity = 200
	    }
	
	    if (cursors.up.isDown)
	    {
	        car.body.velocity.copyFrom(game.physics.arcade.velocityFromAngle(car.angle, 300))
	    }
	
	}
	
	override fun render() {
	}
}