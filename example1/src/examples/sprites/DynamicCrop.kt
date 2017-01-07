
package examples.sprites

import Koala.initKoala
import Phaser.*

class DynamicCrop: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("trsi", "assets/pics/trsipic1_lazur.jpg")
	
	}
	
	lateinit var pic:Sprite
	lateinit var cropRect:Rectangle
	var w = 0.0
	var h = 0.0
	
	override fun create() {
	
	    pic = game.add.sprite(0, 0, "trsi")
	
	    w = pic.width
	    h = pic.height
	
	    cropRect = Phaser.Rectangle(0, 0, 128, 128)
	
	    pic.crop(cropRect)
	
	}
	
	override fun update() {
	
	    if (game.input.x < w && game.input.y < h)
	    {
	        pic.x = game.input.x
	        pic.y = game.input.y
	        cropRect.x = game.input.x
	        cropRect.y = game.input.y
	
	        pic.updateCrop()
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("x: " + game.input.x + " y: " + game.input.y, 32, 32)
	
	}
}