
package examples.arcadephysics


import Phaser.*

class BodyEnable: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
		game.load.spritesheet("gameboy", "assets/sprites/gameboy_seize_color_40x60.png", 40, 60)
	
	}
	
	lateinit var sprite:Sprite
	lateinit var sprite2:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
		game.stage.backgroundColor = "#124184"
	
		sprite = game.add.sprite(300, 0, "gameboy", 2)
		sprite2 = game.add.sprite(300, 400, "gameboy", 3)
	
		game.physics.arcade.enable(arrayOf(sprite, sprite2))
	
		game.physics.arcade.gravity.y = 200.0
	
		sprite.body.bounce.y = 0.95
		sprite.body.collideWorldBounds = true
	
		sprite2.body.allowGravity = false
		sprite2.body.immovable = true
	
		game.input.onDown.add(this::toggleBody, this)
	
	}
	
	fun toggleBody() {
	
		//	Here we simply disable the body entirely
		//	This stops all motion and collision checks against it
		//	without actually destroying the body object itself.
	
		if (sprite2.body.enable)
		{
			sprite2.body.enable = false
		}
		else
		{
			sprite2.body.enable = true
		}
	
	}
	
	override fun update() {
	
		game.physics.arcade.collide(sprite, sprite2)
	
	}
	
	override fun render() {
	
		game.debug.text("Click to disable body1", 32, 32)
	
		if (sprite2.body.enable)
		{
		    game.debug.body(sprite2)
		}
	
	}
}