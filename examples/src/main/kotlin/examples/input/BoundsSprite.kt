
package examples.input


import Phaser.*

class BoundsSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("pic", "assets/pics/game14_angel_dawn.png")
	    game.load.image("atari", "assets/sprites/atari800xl.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var bounds:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    //  Our sprite that will act as the drag bounds
	    bounds = game.add.sprite(game.world.centerX, game.world.centerY, "pic")
	    bounds.alpha = 0.5
	    bounds.anchor.set(0.5)
	
	    //  And the sprite we"ll drag
	    sprite = game.add.sprite(300, 300, "atari")
	    sprite.inputEnabled = true
	    sprite.anchor.set(0.5)
	
	    sprite.input.enableDrag()
	    sprite.input.boundsSprite = bounds
	
	}
}