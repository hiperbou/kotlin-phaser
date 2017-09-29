
package examples.sprites


import Phaser.*

class HorizontalCrop: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update = update })
	
	override fun preload() {
	    game.load.image("trsi", "assets/pics/trsipic1_lazur.jpg")
	}
	
	lateinit var pic:Image
	lateinit var cropRect:Rectangle
	
	override fun create() {
	
	    pic = game.add.image(game.world.centerX, 550, "trsi")
	
	    pic.anchor.setTo(0.5, 1)
	
	    cropRect = Phaser.Rectangle(0, 0, 0, pic.height)
	
	    console.log(cropRect)
	
	    // Here we"ll tween the crop rect, from a width of zero to full width, and back again
	    var tween = game.add.tween(cropRect).to( object{ var  width= pic.width }, 3000, Phaser.Easing.Bounce::Out, false, 0, 1000, true)
	
	    pic.crop(cropRect)
	
	    tween.start()
	
	}
	
	override fun update() {
	
	    pic.updateCrop()
	
	}
}