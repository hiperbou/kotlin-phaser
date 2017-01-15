
package examples.filters

import Koala.initKoala
import Phaser.*

class Pixelate: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/pics/mighty_no_09_cover_art_by_robduenas.jpg")
	
	    game.load.shader("pixelate", "assets/shaders/pixelate.frag")
	
	}
	
	override fun create() {
	
		var logo = game.add.sprite(game.world.centerX, game.world.centerY, "phaser")
	
		logo.anchor.set(0.5)
	
		var pixelate = game.add.filter<Filter.Pixelate>("Pixelate", null, game.cache.getShader("pixelate"))
	
	    // filter = Phaser.Filter(game, null, game.cache.getShader("bacteria"))
	
		logo.filters = arrayOf(pixelate)
	
	    game.add.tween(pixelate).to( object{ var  sizeX= 100;  var  sizeY= 100 }, 5000, "Quad.easeInOut", true, 0, -1, true)
	
	}
}