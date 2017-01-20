
package examples.groups


import Phaser.*

class Recycling: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	lateinit var enemies:Group
	
	override fun preload() {
	
	    game.load.image("baddie", "assets/sprites/space-baddie.png")
	    game.load.spritesheet("button", "assets/buttons/baddie-buttons.png", 224, 70)
	    
	}
	
	override fun create() {
	
	    // Create a enemies group to store the baddies
	    enemies = game.add.group()
	
	    // Create some enemies.
	    for(i in 0..8-1)
	    {
	        // Since the getFirstExists<Sprite>() which we"ll use for recycling
	        // cannot allocate objects, create them manually here.
	        enemies.create(360 + Math.random() * 200, 120 + Math.random() * 200, "baddie")
	    }
	
	    // Create buttons to create and kill baddies.
	    game.add.button(16, 50, "button", this::createBaddie,this, 0, 0, 0)
	    game.add.button(16, 130, "button", this::killBaddie,this, 1, 1, 1)
	
	}
	
	fun killBaddie() {
	
	    var baddie = enemies.getFirstAlive<Sprite>()
	
	    if (baddie != null)
	    {
	        baddie.kill()
	    }
	
	}
	
	fun createBaddie() {
	
	    // Recycle using getFirstExists<Sprite>(false)
	    // Notice that this method will not create objects if there"s no one
	    // available, and it won"t change size of this group.
	    var enemy = enemies.getFirstExists<Sprite>(false)
	
	    if (enemy != null)
	    {
	        enemy.revive()
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Recycle baddies from a group using getFirstExists.", 16, 24)
	    game.debug.text("Notice that you cannot add more than 8 baddies since we only create 8 instance.", 16, 36)
	    game.debug.text("Living baddies: " + (enemies.countLiving()), 340, 420)
	
	}
}