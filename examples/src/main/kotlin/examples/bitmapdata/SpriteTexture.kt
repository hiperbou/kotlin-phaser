
package examples.bitmapdata


import Phaser.*

class SpriteTexture: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create,  var  update= update })
	
	override fun preload() {
	
	    game.load.image("pic", "assets/pics/questar.png")
	
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    //  Create a BitmapData
	    var bmd = game.make.bitmapData(320, 256)
	
	    //  Draw an image to it
	    bmd.copy("pic")
	
	    //  Draw a few random shapes to it
	    bmd.circle(100, 100, 32, "rgba(255,0,0,0.8)")
	    bmd.rect(110, 40, 64, 120, "rgba(255,0,255,0.8)")
	
	    //  Here the sprite uses the BitmapData as a texture
	    sprite = game.add.sprite(300, 300, bmd)
	
	    sprite.anchor.set(0.5)
	
	    //  And you can do Spritey things with it as usual
	
	}
	
	override fun update() {
	
	    sprite.rotation += 0.01
	
	}
}