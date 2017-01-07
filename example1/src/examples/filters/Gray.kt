
package examples.filters

import Koala.initKoala
import Phaser.*

class Gray: State() {
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser2.png")
	    game.load.script("gray", "https://cdn.rawgit.com/photonstorm/phaser/master/filters/Gray.js")
	
	}
	
	override fun create() {
	
	    for(i in 0..8-1)
	    {
	        var logo = game.add.sprite(game.world.randomX, -150 + game.world.randomY, "phaser")
	        logo.anchor.set(0.5)
	        logo.scale.set(game.rnd.realInRange(0.2, 1))
	        game.add.tween(logo).to(object{ var  y= "+300" }, 1000 + game.rnd.between(1000,2000), "Bounce.easeOut", true, 0, -1, true)
	    }
	
	    // var logo = game.add.sprite(game.world.centerX, game.world.centerY, "phaser")
	    // logo.anchor.setTo(0.5, 0.5)
	
	    var gray = game.add.filter<Filter.Gray>("Gray")
	
	    game.world.filters = arrayOf(gray)
	
	}
}