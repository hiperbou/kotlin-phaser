
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class DirectBodyMovement: State() {
	
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
	
	    sprite1 = game.add.sprite(300, 50, "atari")
	    sprite2 = game.add.sprite(400, 450, "mushroom")
	
	    game.physics.arcade.enable(arrayOf( sprite1, sprite2 ))
	
	    game.add.tween(sprite1.body).to( object{ var  y= 400 }, 3000, Phaser.Easing.Linear::None, true)
	
	}
	
	override fun update() {
	
	    game.physics.arcade.overlap(sprite1, sprite2, this::overlapHandler, null, this)
	
	}
	
	fun overlapHandler (obj1:Sprite, obj2:Sprite) {
	
	    game.stage.backgroundColor = "#992d2d"
	
	    obj2.kill()
	
	}
	
	override fun render() {
	
	    game.debug.body(sprite1)
	    game.debug.body(sprite2)
	
	}
}