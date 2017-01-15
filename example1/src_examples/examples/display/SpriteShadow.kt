
package examples.display

import Koala.initKoala
import Phaser.*

class SpriteShadow: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("hotdog", "assets/sprites/hotdog.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var shadow:Sprite
	var offset = Phaser.Point(10.0, 8.0)
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0c9fc7"
	
	    shadow = game.add.sprite(game.world.centerX, game.world.centerY, "hotdog")
	    shadow.anchor.set(0.5)
	    shadow.tint = 0x000000
	    shadow.alpha = 0.6
	
	    sprite = game.add.sprite(game.world.centerX, game.world.centerY, "hotdog")
	    sprite.anchor.set(0.5)
	
	    game.input.addMoveCallback(this::move, this)
	
	}
	
	fun move(pointer:Pointer, x:Double, y:Double) {
	
	    sprite.x = x
	    sprite.y = y
	
	    shadow.x = sprite.x + offset.x
	    shadow.y = sprite.y + offset.y
	
	}
}