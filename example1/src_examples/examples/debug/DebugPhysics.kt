
package examples.debug

import Koala.initKoala
import Phaser.*

class DebugPhysics: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render  })
	
	lateinit var sprite:Sprite
	var counter = 0.0
	var step = Math.PI * 2 / 360
	
	override fun preload() {
	
	    game.load.image("sprite", "assets/sprites/phaser2.png")
	
	}
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    sprite = game.add.sprite(game.world.centerX, game.world.centerY, "sprite")
	    sprite.anchor.set(0.5)
	
	    game.physics.arcade.enable(sprite)
	    
	}
	
	override fun update()
	{
	    // Move sprite up and down smoothly for show
	    var tStep = Math.sin(counter)
	    sprite.body.y = 120 + tStep * 60
	    counter += step
	}
	
	override fun render() {
	
	    game.debug.body(sprite)
	
	}
}