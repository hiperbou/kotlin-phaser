
package examples.sprites


import Phaser.*

class Spritesheet: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var sprite:Sprite
	
	override fun preload() {
	
	    //  37x45 is the size of each frame
	    //  There are 18 frames in the PNG - you can leave this value blank if the frames fill up the entire PNG, but in this case there are some
	    //  blank frames at the end, so we tell the loader how many to load
	    game.load.spritesheet("ms", "assets/sprites/metalslug_mummy37x45.png", 37, 45, 18)
	
	}
	
	override fun create() {
	
	    sprite = game.add.sprite(40, 100, "ms")
	
	    sprite.animations.add("walk")
	
	    sprite.animations.play("walk", 50, true)
	
	    game.add.tween(sprite).to(object{ var  x= game.width }, 10000, Phaser.Easing.Linear::None, true)
	
	}
	
	//  update isn"t called until "create" has completed. If you need to process stuff before that point (i.e. while the preload is still happening)
	//  then create a fun called loadUpdate() and use that
	override fun update() {
	    
	    if (sprite.x >= 300)
	    {
	        sprite.scale.x += 0.01
	        sprite.scale.y += 0.01
	    }
	
	}
}