
package examples.demoscene


import Phaser.*

class AtariIntro: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/demoscene/atari.png")
	    game.load.image("raster", "assets/demoscene/pink-raster.png")
	    game.load.image("floor", "assets/demoscene/checker-floor.png")
	
	}
	
	lateinit var effect:BitmapData
	lateinit var image:Image
	var mask = Phaser.Rectangle()
	
	override fun create() {
	
	    game.stage.backgroundColor = "#000042"
	
	    var floor = game.add.image(0, game.height, "floor")
	    floor.width = 800.0
	    floor.anchor.y = 1.0
	
	    effect = game.make.bitmapData()
	    effect.load("atari")
	
	    image = game.add.image(game.world.centerX, game.world.centerY, effect)
	    image.anchor.set(0.5)
	    image.smoothed = false
	
	    mask.setTo(0, 0, effect.width, game.cache.getImage("raster").height)
	
	    //  Tween the rasters
	    game.add.tween(mask).to( object{ var  y= -(mask.height - effect.height) }, 3000, Phaser.Easing.Sinusoidal::InOut, true, 0, 100, true)
	
	    //  Tween the image
	    game.add.tween(image.scale).to( object{ var  x= 4;  var  y= 4 }, 3000, Phaser.Easing.Quartic::InOut, true, 0, 100, true)
	
	}
	
	override fun update() {
	
	    effect.alphaMask("raster", effect, mask)
	
	    image.rotation += 0.01
	
	}
}