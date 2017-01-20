
package examples.filters


import Phaser.*

class MultipleShaders: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var filter:Filter
	lateinit var filter2:Filter
	lateinit var sprite:Sprite

	override fun preload() {
	
	    //  From http://glslsandbox.com/e#20450.0
	    game.load.shader("blueDots", "assets/shaders/blue-dots.frag")
	    game.load.shader("bacteria", "assets/shaders/bacteria.frag")
	
	}
	
	override fun create() {
	
	    filter = Phaser.Filter(game, null, game.cache.getShader("blueDots"))
	
	    filter.setResolution(400, 600)
	
	    sprite = game.add.sprite()
	    sprite.width = 400.0
	    sprite.height = 600.0
	
	    sprite.filters = arrayOf( filter )
	
	    filter2 = Phaser.Filter(game, null, game.cache.getShader("bacteria"))
	
	    filter2.setResolution(400, 600)
	
	    var sprite2 = game.add.sprite(400)
	    sprite2.width = 400.0
	    sprite2.height = 600.0
	
	    sprite2.filters = arrayOf( filter2 )
	
	
	
	}
	
	override fun update() {
	
	    filter.update()
	    filter2.update()
	
	}
}