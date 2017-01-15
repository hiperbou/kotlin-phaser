
package examples.groups

import Koala.initKoala
import Phaser.*

class CallAllAnimations: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("coin", "assets/sprites/coin.png", 32, 32)
	
	}
	
	lateinit var coins:Group
	
	override fun create() {
	
	    //  Here we create our coins group
	    coins = game.add.group()
	
	    //  Now let"s add 50 coins into it
	    for(i in 0..50-1)
	    {
	        coins.create(game.world.randomX, game.world.randomY, "coin", 0)
	    }
	
	    //  Now using the power of callAll we can add the same animation to all coins in the group:
	    coins.callAll("animations.add", "animations", "spin", arrayOf(0, 1, 2, 3, 4, 5), 10, true)
	
	    //  And play them
	    coins.callAll("animations.play", "animations", "spin")
	
	}
}