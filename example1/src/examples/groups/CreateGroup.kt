
package examples.groups

import Koala.initKoala
import Phaser.*

class CreateGroup: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create})
	
	 override fun preload() {
	
	    game.load.image("sonic", "assets/sprites/sonic_havok_sanity.png")
	
	}
	
	lateinit var yourGroup:Group
	
	override fun create() {
	
	    //  Here we"ll create a Group
	    yourGroup = game.add.group()
	
	    //  And add 10 sprites to it
	    for(i in 0..10-1)
	    {
	        //  Create a sprite at a random world location
	        yourGroup.create(game.world.randomX, game.world.randomY, "sonic")
	    }
	
	    //  Each sprite is now a member of yourGroup
	
	}
}