
package examples.filters

import Koala.initKoala
import Phaser.*

class Plasma: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var background:Sprite
	lateinit var filter:Filter
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser2.png")
	    game.load.script("filter", "https://cdn.rawgit.com/photonstorm/phaser/master/filters/Plasma.js")
	
	}
	
	override fun create() {
	
		background = game.add.sprite(0, 0)
		background.width = 800.0
		background.height = 600.0
	
		filter = game.add.filter("Plasma", 800, 600)
	
		//	You have the following values to play with (defaults shown below):
	
		// filter.size = 0.03
		// filter.redShift = 0.5
		// filter.greenShift = 0.5
		// filter.blueShift = 0.9
	
		background.filters = arrayOf(filter)
	
		var logo = game.add.sprite(game.world.centerX, game.world.centerY, "phaser")
		logo.anchor.setTo(0.5, 0.5)
	
	}
	
	override fun update() {
	
		filter.update()
	
		//	Uncomment for coolness :)
		// filter.blueShift -= 0.001
	
	}
}