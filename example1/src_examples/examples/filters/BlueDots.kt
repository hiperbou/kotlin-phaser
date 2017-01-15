
package examples.filters

import Koala.initKoala
import Phaser.*

class BlueDots: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var filter:Filter
	lateinit var sprite:Sprite
	
	override fun preload() {
	
	    //  From http://glslsandbox.com/e#20450.0
	    game.load.shader("blueDots", "assets/shaders/blue-dots.frag")
	
	}
	
	override fun create() {
	
	    filter = Phaser.Filter(game, null, game.cache.getShader("blueDots"))
	
	    filter.setResolution(400, 600)
	
	    sprite = game.add.sprite()
	    sprite.width = 400.0
	    sprite.height = 600.0
	
	    sprite.filters = arrayOf( filter )
	
	}
	
	override fun update() {
	
	    filter.update()
	
	}
}