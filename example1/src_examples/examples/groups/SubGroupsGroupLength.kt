
package examples.groups

import Koala.initKoala
import Phaser.*

class SubGroupsGroupLength: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	// Groups for storing friends and enemies, may use for collision later.
	lateinit var friendAndFoe:Group
	lateinit var enemies:Group
	
	// Groups for teaming up stuff.
	lateinit var normalBaddies:Group
	lateinit var purpleBaddies:Group
	
	override fun preload() {
	
	    game.load.image("ufo", "assets/sprites/ufo.png")
	    game.load.image("baddie", "assets/sprites/space-baddie.png")
	    game.load.image("purple-baddie", "assets/sprites/space-baddie-purple.png")
	    
	}
	
	override fun create() {
	
	    // Create some local groups for later use.
	    friendAndFoe = game.add.group()
	    enemies = game.add.group()
	    normalBaddies = game.add.group()
	    purpleBaddies = game.add.group()
	
	    
	    enemies.add(normalBaddies)
	    enemies.add(purpleBaddies)
	
	
	    // Create a ufo as a friend sprite.
	    friendAndFoe.create(200, 240, "ufo")
	
	    // Create some enemies.
	    for(i in 0..16-1)
	    {
	        createBaddie()
	    }
	
	    // Tap to create baddie sprites.
	    game.input.onTap.add(this::createBaddie, this)
	
	}
	
	fun createBaddie() {
	
	    var baddie:Sprite
	
	    // Of course, the baddies created will belong to their respective groups
	    if (Math.random() > 0.5)
	    {
	        baddie = purpleBaddies.create(360 + Math.random() * 200, 120 + Math.random() * 200, "purple-baddie")
	    }
	    else
	    {
	        baddie = normalBaddies.create(360 + Math.random() * 200, 120 + Math.random() * 200, "baddie")
	    }
	    
	}
	
	override fun render() {
	
	    game.debug.style = "#fff"
	    game.debug.text("Tap screen or click to create baddies.", 16, 24)
	    game.debug.text("enemies: " + enemies.length + " (actually " + enemies.length + " groups)", 16, 48)
	    game.debug.text("normal baddies: " + normalBaddies.length, 16, 60)
	    game.debug.text("purple baddies: " + purpleBaddies.length, 16, 72)
	    game.debug.text("friends: " + friendAndFoe.length, 16, 96)
	
	}
}