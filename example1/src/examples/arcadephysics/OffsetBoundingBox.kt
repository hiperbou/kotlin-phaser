
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class OffsetBoundingBox: State() {
	
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
	
	    sprite1 = game.add.sprite(150, 200, "atari")
	    sprite1.name = "atari"
	
	    sprite2 = game.add.sprite(700, 220, "mushroom")
	    sprite2.name = "mushroom"
	
	    game.physics.enable(arrayOf(sprite1,sprite2), Phaser.Physics.ARCADE)
	
	    //  This adjusts the collision body size to be a 100x50 box.
	    //  50, 25 is the X and Y offset of the newly sized box.
	    
	    sprite1.body.setSize(100, 50, 50, 25)
	    sprite1.body.immovable = true
	    
	    sprite2.body.velocity.x = -100
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(sprite1, sprite2, this::collisionHandler, null, this)
	
	}
	
	fun collisionHandler (obj1:Sprite, obj2:Sprite) {
	
	    game.stage.backgroundColor = "#992d2d"
	
	}
	
	override fun render() {
	
	    game.debug.bodyInfo(sprite1, 32, 32)
	
	    game.debug.body(sprite1)
	    game.debug.body(sprite2)
	
	}
}