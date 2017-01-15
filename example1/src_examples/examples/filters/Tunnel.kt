
package examples.filters

import Koala.initKoala
import Phaser.*

class Tunnel: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var background:Sprite
	lateinit var filter:Filter.Tunnel
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser.png")
	    game.load.image("texture", "assets/textures/ooze.png")
	    game.load.script("filter", "https://cdn.rawgit.com/photonstorm/phaser/master/filters/Tunnel.js")
	
	}
	
	override fun create() {
	
		background = game.add.sprite(0, 0, "texture")
		background.width = 800.0
		background.height = 600.0
	
		filter = game.add.filter<Filter.Tunnel>("Tunnel", 800, 600, background.texture)
	
		//	You have the following value to play with (default value is 2.0):
		filter.origin = 1.0
	
		background.filters = arrayOf(filter)
	
		var logo = game.add.sprite(game.world.centerX, game.world.centerY, "phaser")
		logo.anchor.setTo(0.5, 0.5)
	
	}
	
	override fun update() {
	
		filter.update()
	
		//	Uncomment for coolness :)
		// filter.origin = filter.origin + 0.001
	
	}
}