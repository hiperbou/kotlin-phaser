
package examples.filters


import Phaser.*

//@Todo: example not working in phaser examples
class CheckerWave: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var background:Sprite
	lateinit var filter:Filter.CheckerWave
	
	override fun preload() {
	
	    game.load.image("s", "assets/pics/undersea.jpg")
	    game.load.image("phaser", "assets/sprites/phaser.png")
	    game.load.script("filter", "https://cdn.rawgit.com/photonstorm/phaser/master/filters/CheckerWave.js")
	
	}
	
	override fun create() {
	
		game.add.sprite(0, 0, "s")
	
		background = game.add.sprite(0, 0)
		background.width = 800.0
		background.height = 600.0
	
		filter = game.add.filter<Filter.CheckerWave>("CheckerWave", 800, 600)
		filter.alpha = 0.2
	
		background.filters = arrayOf(filter)
	
		var logo = game.add.sprite(game.world.centerX, 100, "phaser")
		logo.anchor.setTo(0.5, 0.5)
	
	}
	
	override fun update() {
	
		filter.update()
	
	}
}