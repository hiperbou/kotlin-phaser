
package examples.bitmapdata


import Phaser.*

class AlphaMask: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload,  var  create= create })
	
	override fun preload() {
	
		game.load.image("pic", "assets/pics/questar.png")
		game.load.image("mask", "assets/pics/mask-test2.png")
	
	}
	
	override fun create() {
	
		game.stage.backgroundColor = 0x4d4d4d
	
		game.add.text(64, 10, "Source image", TextStyle(font="16px Arial",fill="#ffffff" ))
		game.add.image(64, 32, "pic")
	
		game.add.text(400, 10, "Alpha mask", TextStyle(font="16px Arial",fill="#ffffff" ))
		game.add.image(400, 32, "mask")
	
		//	Create a bitmap data the same size as our picture
		var bmd = game.make.bitmapData(320, 256)
	
		//	And create an alpha mask image by combining pic and mask from the cache
		bmd.alphaMask("pic", "mask")
	
		//	A BitmapData is just a texture. You need to apply it to a sprite or image
		//	to actually display it:
		game.add.image(game.world.centerX, 320, bmd).anchor.set(0.5, 0)
	
	}
}