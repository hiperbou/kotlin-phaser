
package examples.arcadephysics


import Phaser.*

class LargerBoundingBox: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/sprites/atari130xe.png")
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	
	}
	
	lateinit var sprite1:Sprite
	lateinit var sprite2:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    sprite1 = game.add.sprite(130, 200, "atari")
	    sprite1.name = "atari"
	
	    game.physics.enable(sprite1, Phaser.Physics.ARCADE)
	    //  In this example the collision box is much larger than the original sprite
	    sprite1.body.setSize(400, 50, -100, 20)
	    sprite1.body.immovable = true
	
	    sprite2 = game.add.sprite(700, 210, "mushroom")
	    sprite2.name = "mushroom"
	    game.physics.enable(sprite2, Phaser.Physics.ARCADE)
	    sprite2.body.velocity.x = -100
	
	
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(sprite1, sprite2, this::collisionHandler, null, this)
	
	}
	
	fun collisionHandler (obj1:Sprite, obj2:Sprite) {
	
	    game.stage.backgroundColor = "#992d2d"
	
	}
	
	override fun render() {
	
	    game.debug.bodyInfo(sprite2, 32, 32)
	
	    game.debug.body(sprite1)
	    game.debug.body(sprite2)
	
	}
}