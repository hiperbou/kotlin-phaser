
package examples.input


import Phaser.*

class PixelpickSpritesheet: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("mummy", "assets/sprites/metalslug_mummy37x45.png", 37, 45, 18)
	
	}
	
	lateinit var b:Sprite
	
	override fun create() {
	
	    Phaser.Canvas.setSmoothingEnabled(game.context, false)
	
	    b = game.add.sprite(game.world.centerX, game.world.centerY, "mummy")
	
	    b.anchor.set(0.5)
	    b.scale.set(6)
	    b.smoothed = false
	
	    b.animations.add("walk")
	    b.animations.play("walk", 5, true)
	
	    //  Listen for input events on this sprite
	    b.inputEnabled = true
	
	    //  Check the pixel data of the sprite
	    b.input.pixelPerfectOver = true
	
	    //  Enable the hand cursor
	    b.input.useHandCursor = true
	
	}
	
	override fun render() {
	
	    game.debug.spriteInputInfo(b, 32, 32)
	    //game.debug.geom(b.input._tempPoint)
	
	}
}