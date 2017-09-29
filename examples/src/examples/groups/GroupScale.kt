
package examples.groups


import Phaser.*

class GroupScale: State() {
	
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
	        coins.create(game.world.randomX / 2, game.world.randomY / 2, "coin", 0)
	    }
	
	    //  And now we scale it: x2 on the x and y axis
	    coins.scale.set(2, 2)
	
	}
}