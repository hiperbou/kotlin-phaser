
package examples.groups


import Phaser.*

class AddASpriteToGroup: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	lateinit var friendAndFoe:Group
	lateinit var enemies:Group
	
	override fun preload() {
	
	    game.load.image("ufo", "assets/sprites/ufo.png")
	    game.load.image("baddie", "assets/sprites/space-baddie.png")
	    
	}
	
	override fun create() {
	
	    //  Here we create 2 groups
	    friendAndFoe = game.add.group()
	    enemies = game.add.group()
	
	    for(i in 0..16-1)
	    {
	        //  This creates a Phaser.Sprite instance within the group
	        //  It will be randomly placed within the world and use the "baddie" image to display
	        enemies.create(360 + Math.random() * 200, 120 + Math.random() * 200, "baddie")
	    }
	
	    //  You can also add existing sprites to a group.
	    //  Here we"ll create a local sprite called "ufo"
	    var ufo = game.add.sprite(200, 240, "ufo")
	
	    //  And then add it to the group
	    friendAndFoe.add(ufo)
	
	}
}