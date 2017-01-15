
package examples.demoscene

import Koala.initKoala
import Phaser.*

class RasterFont: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("knightHawks", "assets/demoscene/knighthawks.png")
	    game.load.image("raster", "assets/demoscene/multi-color-raster.png")
	
	}
	
	lateinit var font:BitmapData
	lateinit var alpha:BitmapData
	lateinit var raster:BitmapData
	var mask = Phaser.Rectangle()
	
	override fun create() {
	
	    font = game.make.bitmapData()
	    alpha = game.make.bitmapData()
	    raster = game.make.bitmapData()
	
	    //  Load the font
	    font.load("knightHawks")
	
	    //  Extract all the pink pixels into the alpha bmd
	    font.extract(alpha, 237, 0, 140, 255, true)
	
	    raster.resize(font.width, font.height)
	
	    //  Display the 4 stages of the process
	    game.add.image(0, 0, "knightHawks")
	    game.add.image(360, 0, alpha)
	    game.add.image(0, 200, raster)
	    game.add.image(360, 200, font)
	
	    //  Tween the rasters
	    mask.setTo(0, 0, font.width, game.cache.getImage("raster").height)
	
	    game.add.tween(mask).to( object{ var  y= -(mask.height - font.height) }, 4000, Phaser.Easing.Sinusoidal::InOut, true, 0, 100, true)
	
	}
	
	override fun update() {
	
	    raster.cls()
	    raster.alphaMask("raster", alpha, mask)
	
	    font.draw(raster)
	
	}
}