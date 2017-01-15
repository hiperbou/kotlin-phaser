
package examples.filters

import Koala.initKoala
import Phaser.*

class Bacteria: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var filter:Filter
	
	override fun preload() {
	
	    //  From http://glslsandbox.com/e#20193.0
	    game.load.shader("bacteria", "assets/shaders/bacteria.frag")
	
	}
	
	override fun create() {
	
	    filter = Phaser.Filter(game, null, game.cache.getShader("bacteria"))
	
	    filter.addToWorld(0, 0, 800, 600)
	
	}
	
	override fun update() {
	
	    filter.update()
	
	}
}