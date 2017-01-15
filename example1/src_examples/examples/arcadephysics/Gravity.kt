
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class Gravity: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("ilkke", "assets/sprites/ilkke.png")
	
	}
	
	lateinit var sprite1:Sprite
	lateinit var sprite2:Sprite
	lateinit var sprite3:Sprite
	lateinit var sprite4:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    //  Set the world (global) gravity
	    game.physics.arcade.gravity.y = 100.0
	
	    //  Sprite 1 will use the World (global) gravity
	    sprite1 = game.add.sprite(100, 96, "ilkke")
	
	    //  Sprite 2 is set to ignore the global gravity and use its own value
	    sprite2 = game.add.sprite(300, 96, "ilkke")
	
	    //  Sprite 3 will use both the world gravity and its own gravityScale modifier
	    sprite3 = game.add.sprite(500, 96, "ilkke")
	
	    //  Sprite 4 will ignore all gravity
	    sprite4 = game.add.sprite(700, 96, "ilkke")
	
	    // Enable physics on those sprites
	    game.physics.enable( arrayOf( sprite1, sprite2, sprite3, sprite4 ), Phaser.Physics.ARCADE)
	
	    sprite1.body.collideWorldBounds = true
	    sprite1.body.bounce.y = 0.8
	    
	    sprite2.body.collideWorldBounds = true
	    sprite2.body.bounce.y = 0.8
	    sprite2.body.gravity.y = 200
	    
	    sprite3.body.collideWorldBounds = true
	    sprite3.body.bounce.y = 0.8
	    sprite3.body.gravity.y = 50
	
	    sprite4.body.allowGravity = false
	
	}
	
	override fun render() {
	
	    game.debug.text("world gravity", sprite1.x - 32, 64)
	    game.debug.text("local gravity", sprite2.x - 32, 64)
	    game.debug.text("local / 2", sprite3.x - 32, 64)
	    game.debug.text("no gravity", sprite4.x - 32, 64)
	
	}
}