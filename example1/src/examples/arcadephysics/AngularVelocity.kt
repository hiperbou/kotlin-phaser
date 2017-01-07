
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class AngularVelocity: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	    game.load.image("arrow", "assets/sprites/arrow.png")
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#0072bc"
	
	    sprite = game.add.sprite(400, 300, "arrow")
	    sprite.anchor.setTo(0.5, 0.5)
	
	    game.physics.enable(sprite, Phaser.Physics.ARCADE)
	
	}
	
	override fun update() {
	
	    sprite.body.velocity.x = 0
	    sprite.body.velocity.y = 0
	    sprite.body.angularVelocity = 0
	
	    if (game.input.keyboard.isDown(Phaser.Keyboard.LEFT))
	    {
	        sprite.body.angularVelocity = -200
	    }
	    else if (game.input.keyboard.isDown(Phaser.Keyboard.RIGHT))
	    {
	        sprite.body.angularVelocity = 200
	    }
	
	    if (game.input.keyboard.isDown(Phaser.Keyboard.UP))
	    {
	        game.physics.arcade.velocityFromAngle(sprite.angle, 300, sprite.body.velocity)
	    }
	
	}
	
	override fun render() {
	
	    game.debug.spriteInfo(sprite, 32, 32)
	    game.debug.text("angularVelocity: " + sprite.body.angularVelocity, 32, 200)
	    game.debug.text("angularAcceleration: " + sprite.body.angularAcceleration, 32, 232)
	    game.debug.text("angularDrag: " + sprite.body.angularDrag, 32, 264)
	    game.debug.text("deltaZ: " + sprite.body.deltaZ(), 32, 296)
	
	}
}