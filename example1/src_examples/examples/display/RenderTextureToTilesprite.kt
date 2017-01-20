
package examples.display


import Phaser.*

class RenderTextureToTilesprite: State() {
	
	////var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("ball", "assets/sprites/spinObj_01.png")
	
	}
	
	lateinit var ball:Sprite
	lateinit var texture:RenderTexture
	
	override fun create() {
	
	    ball = game.make.sprite(0, 0, "ball")
	
	    texture = game.add.renderTexture(256, 256)
	
	    texture.renderXY(ball, 0, 0, false)
	    texture.renderXY(ball, 50, 50, false)
	    texture.renderXY(ball, 100, 100, false)
	
	    game.cache.addImage("tsTexture", "", texture.getImage())
	
	    var ts = game.add.tileSprite(0, 0, 800, 600, "tsTexture")
	
	    ts.textureDebug = true
	
	}
	
	override fun update() {
	
	}
}