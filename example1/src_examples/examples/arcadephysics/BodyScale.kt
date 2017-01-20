
package examples.arcadephysics


import Phaser.*

class BodyScale: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
		game.load.spritesheet("gameboy", "assets/sprites/gameboy_seize_color_40x60.png", 40, 60)
	
	}
	
	lateinit var sprite:Sprite
	lateinit var sprite2:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
		game.stage.backgroundColor = "#124184"
	
		//	Here we"re tweening the scale of the sprite, which translates to the scale of the Body as well.
		//	The collision will carry on working even against the scaled body.
	
		sprite = game.add.sprite(200, 300, "gameboy", 2)
		sprite.anchor.set(0.5)
		sprite.smoothed = false
	
		game.physics.enable(sprite, Phaser.Physics.ARCADE)
		sprite.body.immovable = true
	
		sprite2 = game.add.sprite(600, 270, "gameboy", 3)
		game.physics.enable(sprite2, Phaser.Physics.ARCADE)
	
		game.add.tween(sprite.scale).to( object{ var  x= 3;  var  y= 3 }, 2000, Phaser.Easing.Linear::None, true, 0, 1000, true)
	
	}
	
	override fun update() {
	
		sprite2.body.velocity.x = -200
	
		game.physics.arcade.collide(sprite, sprite2)
	
	}
	
	override fun render() {
	
	    // game.debug.body(sprite)
	    // game.debug.body(sprite2)
	
	}
}