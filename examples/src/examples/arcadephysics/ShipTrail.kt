
package examples.arcadephysics


import Phaser.*

class ShipTrail: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("chunk", "assets/sprites/chunk.png")
	    game.load.image("arrow", "assets/sprites/asteroids_ship.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var bmd:BitmapData
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    //  Click on the left or right of the game to shoot the space ship in that direction
	
	    game.stage.backgroundColor = "#124184"
	
	    bmd = game.add.bitmapData(800, 600)
	    bmd.context.fillStyle = "#ffffff"
	
	    var bg = game.add.sprite(0, 0, bmd)
	
	    game.physics.arcade.gravity.y = 100.0
	
	    sprite = game.add.sprite(32, 450, "arrow")
	    sprite.anchor.set(0.5)
	
	    game.physics.enable(sprite, Phaser.Physics.ARCADE)
	
	    sprite.body.collideWorldBounds = true
	    sprite.body.bounce.set(0.8)
	
	    game.input.onDown.add(this::launch, this)
	
	}
	
	fun launch() {
	
	    if (game.input.x < sprite.x)
	    {
	        sprite.body.velocity.setTo(-200, -200)
	    }
	    else
	    {
	        sprite.body.velocity.setTo(200, -200)
	    }
	
	}
	
	override fun update() {
	
	    sprite.rotation = sprite.body.angle
	
	    bmd.context.fillRect(sprite.x, sprite.y, 2.0, 2.0)
	
	    bmd.dirty = true
	
	}
	
	override fun render() {
	
	    game.debug.bodyInfo(sprite, 32, 32)
	
	}
}