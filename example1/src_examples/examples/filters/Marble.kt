
package examples.filters


import Phaser.*

class Marble: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var background:Sprite
	lateinit var filter:Filter.Marble
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser2.png")
	    game.load.script("filter", "https://cdn.rawgit.com/photonstorm/phaser/master/filters/Marble.js")
	
	}
	
	override fun create() {
	
		var logo = game.add.sprite(game.world.centerX, game.world.centerY, "phaser")
		logo.anchor.setTo(0.5, 0.5)
	
		background = game.add.sprite(0, 0)
		background.width = 800.0
		background.height = 600.0
	
		filter = game.add.filter<Filter.Marble>("Marble", 800, 600)
		filter.alpha = 0.2
	
		//	The following properties are available (shown at default values)
	
		//	filter.speed = 10.0
		//	filter.intensity = 0.30
	
		background.filters = arrayOf(filter)
	
	}
	
	override fun update() {
	
		filter.update()
	
	}
}