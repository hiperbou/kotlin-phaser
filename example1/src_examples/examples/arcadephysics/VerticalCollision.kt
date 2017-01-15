
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class VerticalCollision: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
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
	    sprite1.name = "atari"
	
	    game.physics.enable(sprite1, Phaser.Physics.ARCADE)
	
	    sprite1.body.velocity.y = 100
	
	    //  This adjusts the collision body size.
	    //  220x10 is the width/height.
	    //  See the offset bounding box for another example.
	    sprite1.body.setSize(220, 10, 0, 0)
	
	    sprite2 = game.add.sprite(400, 450, "mushroom")
	    sprite2.name = "mushroom"
	
	    game.physics.enable(sprite2, Phaser.Physics.ARCADE)
	
	    sprite2.body.immovable = true
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(sprite1, sprite2, this::collisionHandler, null, this)
	
	}
	
	fun collisionHandler (obj:Sprite, obj2:Sprite) {
	
	    game.stage.backgroundColor = "#992d2d"
	
	}
	
	override fun render() {
	
	    game.debug.body(sprite1)
	    game.debug.body(sprite2)
	
	}
}