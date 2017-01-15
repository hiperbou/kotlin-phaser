
package examples.groups

import Koala.initKoala
import Phaser.*

class FilterByProperty: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("blue", "assets/sprites/blue_ball.png")
	    game.load.image("red", "assets/sprites/orb-red.png")
	    game.load.image("card", "assets/sprites/mana_card.png")
	    game.load.image("hotdog", "assets/sprites/hotdog.png")
	
	}
	
	lateinit var items:Group
	
	override fun create() {
	
	    items = game.add.group()
	
	    //  Add in a bunch of different sprites
	
	    for(i in 0..10-1)
	    {
	        items.create(game.world.randomX, game.world.randomY, "blue")
	        items.create(game.world.randomX, game.world.randomY, "red")
	        items.create(game.world.randomX, game.world.randomY, "card")
	    }
	
	    game.input.onDown.add(this::pickCard, this)
	
	}
	
	fun pickCard() {
	
	    //  Here we"ll get the first child from the Group who"s "key" value matches "card"
	    var card = items.iterate("key", "card", Phaser.Group.RETURN_CHILD)
	
	    if (card !== null)
	    {
	        //  We"ve got a card, so let"s turn it into a hotdog
	        card.loadTexture("hotdog")
	    }
	
	}
}