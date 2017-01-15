
package examples.display

import Koala.initKoala
import Phaser.*

class RenderTextureImage: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("ball", "assets/sprites/spinObj_01.png")
	
	}
	
	lateinit var ball:Sprite
	lateinit var texture:RenderTexture
	
	override fun create() {
	
	    ball = game.make.sprite(0, 0, "ball")
	
	    texture = game.add.renderTexture(game.width, game.height)
	
	    game.add.sprite(0, 0, texture)
	
	}
	
	override fun update() {
	
	    if (!game.input.activePointer.position.isZero())
	    {
	        texture.renderXY(ball, game.input.activePointer.x, game.input.activePointer.y, true)
	    }
	
	}
}