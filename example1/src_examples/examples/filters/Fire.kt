
package examples.filters


import Phaser.*

class Fire: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var background:Sprite
	lateinit var filter:Filter.Fire
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser2.png")
	    game.load.script("filter", "https://cdn.rawgit.com/photonstorm/phaser/master/filters/Fire.js")
	
	}
	
	override fun create() {
	
		var logo = game.add.sprite(game.world.centerX, game.world.centerY, "phaser")
		logo.anchor.setTo(0.5, 0.5)
	
		background = game.add.sprite(0, 0)
		background.width = 800.0
		background.height = 600.0
	
		filter = game.add.filter<Filter.Fire>("Fire", 800, 600)
		filter.alpha = 0.0
	
		background.filters = arrayOf(filter)
	
	}
	
	override fun update() {
	
		filter.update()
	
	}
}