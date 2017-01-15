
package examples.sprites

import Koala.initKoala
import Phaser.*

class VerticalCrop: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create ;  var  update = update})
	
	override fun preload() {
	    game.load.image("trsi", "assets/pics/trsipic1_lazur.jpg")
	}
	
	lateinit var pic:Sprite
	lateinit var cropRect:Rectangle
	
	override fun create() {
	
	    pic = game.add.sprite(game.world.centerX, 550, "trsi")
	
	    pic.anchor.setTo(0.5, 1)
	
	    cropRect = Phaser.Rectangle(0, 0, pic.width, 0)
	
	    //	Here we"ll tween the crop rect, from a height of zero to full height, and back again
	    var tween = game.add.tween(cropRect).to( object{ var  height= pic.height }, 3000, Phaser.Easing.Bounce::Out, false, 0, 1000, true)
	
	    pic.crop(cropRect)
	
	    tween.start()
	
	}
	
	override fun update() {
	
	    pic.updateCrop()
	
	}
}