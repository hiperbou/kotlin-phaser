
package examples.p2physics

import Koala.initKoala
import Phaser.*

class Gravity: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
		game.load.image("arrow", "assets/sprites/xenon2_ship.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var bmd:BitmapData
	
	override fun create() {
	
		//	Enable p2 physics
		game.physics.startSystem(Phaser.Physics.P2JS)
	
		game.stage.backgroundColor = "#124184"
	
		bmd = game.add.bitmapData(800, 600)
		bmd.context.fillStyle = "#ffffff"
	
		var bg = game.add.sprite(0, 0, bmd)
	
		game.physics.p2.gravity.y = 100
	    game.physics.p2.restitution = 0.8
	
		sprite = game.add.sprite(32, 450, "arrow")
	
		game.physics.p2.enable(sprite)
	
		sprite.body.fixedRotation = true
	
	    val text = game.add.text(20, 20, "click to the left / right of the ship", object{ var  fill= "#ffffff";  var  font= "14pt Arial" })
	
		game.input.onDown.add(this::launch, this)
	
	}
	
	fun launch() {
	
		if (game.input.x < sprite.x)
		{
			sprite.body.velocity.x = -200
			sprite.body.velocity.y = -200
		}
		else
		{
			sprite.body.velocity.x = 200
			sprite.body.velocity.y = -200
		}
	
	}
	
	override fun update() {
	
		bmd.context.fillStyle = "#ffff00"
		bmd.context.fillRect(sprite.x, sprite.y, 2.0, 2.0)
	
	}
	
	override fun render() {
	}
}