
package examples.animation


import Phaser.*

class LoadTexture: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", { preload: preload, create: create })
	
	override fun preload() {
	
	    game.load.spritesheet("mummy", "assets/sprites/metalslug_mummy37x45.png", 37, 45, 18)
	    game.load.spritesheet("monster", "assets/sprites/metalslug_monster39x40.png", 39, 40)
	
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    sprite = game.add.sprite(300, 200, "monster")
	
	    sprite.animations.add("walk", arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
	    sprite.animations.play("walk", 20, true)
	    sprite.scale.set(4)
	    sprite.smoothed = false
	
	    game.input.onDown.add(this::changeTexture, this)
	
	}
	
	fun changeTexture() {
	
	    if (sprite.key === "monster")
	    {
	        sprite.loadTexture("mummy", 0, false)
	    }
	    else
	    {
	        sprite.loadTexture("monster", 0, false)
	    }
	
	    // sprite.smoothed = false
	
	}
}