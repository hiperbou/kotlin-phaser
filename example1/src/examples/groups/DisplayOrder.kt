
package examples.groups

import Koala.initKoala
import Phaser.*

class DisplayOrder: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("atari1", "assets/sprites/atari130xe.png")
	    game.load.image("atari2", "assets/sprites/atari800xl.png")
	    game.load.image("card", "assets/sprites/mana_card.png")
	
	}
	
	lateinit var items:Group
	lateinit var card:Sprite
	
	override fun create() {
	
	    items = game.add.group()
	
	    //  Items are rendered in the depth order in which they are added to the Group
	    items.create(64, 100, "atari1")
	    card = items.create(240, 80, "card")
	    items.create(280, 100, "atari2")
	
	    //  This event will be fired only once
	    game.input.onTap.add(this::removeCard, this)
	
	}
	
	fun removeCard() {
	
	    //  Now let"s kill the card sprite
	    card.kill()
	
	    game.input.onTap.add(this::replaceCard, this)
	
	}
	
	fun replaceCard() {
	
	    //  And bring it back to life again. It will render in the same place as before?
	    var deadCard = items.getFirstDead<Sprite>()
	
	    deadCard!!.revive()
	
	}
}