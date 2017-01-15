
package examples.input

import Koala.initKoala
import Phaser.*

class BoundsRect: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/sprites/atari800xl.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var bounds:Phaser.Rectangle
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    bounds = Phaser.Rectangle(100, 100, 500, 400)
	
	    //  Create a graphic so you can see the bounds
	    var graphics = game.add.graphics(bounds.x, bounds.y)
	    graphics.beginFill(0x000077)
	    graphics.drawRect(0, 0, bounds.width, bounds.height)
	
	    sprite = game.add.sprite(300, 300, "atari")
	    sprite.inputEnabled = true
	    sprite.anchor.set(0.5)
	
	    sprite.input.enableDrag()
	    sprite.input.boundsRect = bounds
	
	}
}