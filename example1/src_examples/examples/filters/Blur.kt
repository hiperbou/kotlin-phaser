
package examples.filters

import Koala.initKoala
import Phaser.*

//@Todo: example not working in phaser examples
class Blur: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser2.png")
	    game.load.script("filterX", "https://cdn.rawgit.com/photonstorm/phaser/master/filters/BlurX.js")
	    game.load.script("filterY", "https://cdn.rawgit.com/photonstorm/phaser/master/filters/BlurY.js")
	
	}
	
	override fun create() {
	
		var logo = game.add.sprite(game.world.centerX, game.world.centerY, "phaser")
		logo.anchor.setTo(0.5, 0.5)
	
		var blurX = game.add.filter<Filter.BlurX>("BlurX")
		var blurY = game.add.filter<Filter.BlurY>("BlurY")
	
	    blurX.blur = 100
	    blurY.blur = 1
	
		logo.filters = arrayOf(blurX, blurY)
	
	}
}