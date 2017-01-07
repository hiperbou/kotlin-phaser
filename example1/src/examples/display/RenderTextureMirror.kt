
package examples.display

import Koala.initKoala
import Phaser.*

class RenderTextureMirror: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("ball", "assets/sprites/pangball.png")
	
	}
	
	lateinit var ball:Sprite
	lateinit var texture:RenderTexture
	
	override fun create() {
	
	    //  Here we"ll create a renderTexture the same size as our game
	    texture = game.add.renderTexture(800, 600, "mousetrail")
	
	    //  This is the sprite that will be drawn to the texture
	    //  Note that we "make" it, not "add" it, as we don"t want it on the display list.
	    ball = game.make.sprite(0, 0, "ball")
	    // ball = game.add.sprite(0, 0, "ball")
	    ball.anchor.set(0.5)
	
	    //  This is the sprite that is drawn to the display. We"ve given it the renderTexture as its texture.
	    game.add.sprite(0, 0, texture)
	
	}
	
	override fun update() {
	
	    //  This time we"ll draw the ball sprite twice, in a mirror effect
	    texture.renderXY(ball, game.input.activePointer.x, game.input.activePointer.y, true)
	    texture.renderXY(ball, game.input.activePointer.x, 600 - game.input.activePointer.y, false)
	
	}
}