
package examples.filters

import Koala.initKoala
import Phaser.*

class Lightbeams: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var background:Sprite
	lateinit var filter:Filter.LightBeam
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser2.png")
	    game.load.script("filter", "../filters/LightBeam.js")
	
	}
	
	override fun create() {
	
		var logo = game.add.sprite(game.world.centerX, game.world.centerY, "phaser")
		logo.anchor.setTo(0.5, 0.5)
	
		background = game.add.sprite(0, 0)
		background.width = 800.0
		background.height = 600.0
	
		filter = game.add.filter("LightBeam", 800, 600)
	
		//	You have the following values to play with (defaults shown):
		filter.alpha = 0.0
		// filter.red = 1.0
		// filter.green = 1.0
		// filter.blue = 2.0
		// filter.thickness = 70.0
		// filter.speed = 1.0
	
		background.filters = arrayOf(filter)
	
	}
	
	override fun update() {
	
		filter.update()
	
	}
}