
package examples.sprites


import Phaser.*

class ScaleASprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create})
	
	override fun preload() {
	
	    game.load.image("disk", "assets/sprites/darkwing_crazy.png")
	
	}
	
	override fun create() {
	
	    for(i in 0..15-1)
	    {
	        //  Create 15 sprites at random x/y locations
	        var sprite = game.add.sprite(game.world.randomX, game.world.randomY, "disk")
	
	        //  Pick a random number between -2 and 6
	        var rand = game.rnd.realInRange(-2, 6)
	
	        //  Set the scale of the sprite to the random value
	        sprite.scale.setTo(rand, rand)
	
	        //  You can also scale sprites like this:
	        //  sprite.scale.x = value
	        //  sprite.scale.y = value
	
	    }
	    
	}
}