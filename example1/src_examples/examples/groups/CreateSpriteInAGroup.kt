
package examples.groups


import Phaser.*

class CreateSpriteInAGroup: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("ufo", "assets/sprites/ufo.png")
	    game.load.image("baddie", "assets/sprites/space-baddie.png")
	    
	}
	
	lateinit var friendAndFoe:Group
	lateinit var enemies:Group
	
	override fun create() {
	
	    // Create some local groups for later use.
	    friendAndFoe = game.add.group()
	    enemies = game.add.group()
	
	    // You can directly create a sprite and add it to a group
	    // using just one line. 
	    friendAndFoe.create(200, 240, "ufo")
	
	    // Create some enemies.
	    for(i in 0..8-1)
	    {
	        createBaddie()
	    }
	
	    // Tap to create baddie sprites.
	    game.input.onTap.add(this::createBaddie, this)
	
	}
	
	fun createBaddie() {
	
	    enemies.create(360 + Math.random() * 200, 120 + Math.random() * 200,"baddie")
	
	}
	
	override fun render() {
	
	    game.debug.text("Tap screen or click to create baddies.", 16, 24)
	
	}
}