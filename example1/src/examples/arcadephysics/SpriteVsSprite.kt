
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class SpriteVsSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/sprites/atari130xe.png")
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	
	}
	
	lateinit var sprite1:Sprite
	lateinit var sprite2:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    //  This will check Sprite vs. Sprite collision
	
	    sprite1 = game.add.sprite(50, 200, "atari")
	    sprite2 = game.add.sprite(700, 220, "mushroom")
	
	    game.physics.enable( arrayOf( sprite1, sprite2 ), Phaser.Physics.ARCADE)
	
	    sprite1.name = "atari"
	    sprite1.body.velocity.x = 100
	    
	    sprite2.name = "mushroom"
	    sprite2.body.velocity.x = -100
	
	}
	
	override fun update() {
	
	    // object1, object2, collideCallback, processCallback, callbackContext
	    game.physics.arcade.collide(sprite1, sprite2, this::collisionHandler, null, this)
	
	}
	
	fun collisionHandler (obj:Sprite, obj2:Sprite) {
	
	    //  The two sprites are colliding
	    game.stage.backgroundColor = "#992d2d"
	
	}
	
	override fun render() {
	
	    game.debug.body(sprite1)
	    game.debug.body(sprite2)
	
	}
}