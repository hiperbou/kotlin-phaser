
package examples.debug

import Koala.initKoala
import Phaser.*

class DebugCamera: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update=update;  var  render=render  })
	
	lateinit var sprite:Sprite
	var counter = 0.0
	var step = Math.PI * 2 / 360 
	
	
	override fun preload() {
	
	    // Load images to use as the game sprites
	    game.load.image("sprite", "assets/sprites/phaser2.png")
	
	}
	
	override fun create() {
	
	    // Create sprite and put it in the middle of the stage
	    sprite = game.add.sprite(0, 0, "sprite")
	    sprite.alpha = 0.5 
	    sprite.x = game.width / 2 
	    sprite.anchor.x = 0.5
		sprite.anchor.y = 0.5
	
	}
	
	override fun update()
	{
	    // Move sprite up and down smoothly for show
		console.log("counter: ",counter)
	    val tStep = Math.sin( counter )
		console.log("tStep: ", tStep)
	    sprite.y = (game.height/2) + tStep * 30 
	    sprite.rotation += Phaser.Math.degToRad( 0.1 * tStep ) 
	    counter += step 
	}
	
	override fun render() {
	
	    // Camera
	    game.debug.cameraInfo(game.camera, 32, 32)
	
	}
}