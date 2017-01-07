
package examples.input

import Koala.initKoala
import Phaser.*

class PointerOver: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("bunny", "assets/sprites/bunny.png")
	
	}
	
	lateinit var bunny:Sprite
	
	override fun create() {
	
	    bunny = game.add.sprite(game.world.centerX, game.world.centerY, "bunny")
	
	    bunny.alpha = 0.5
	    bunny.anchor.set(0.5)
	
	    bunny.inputEnabled = true
	
	    game.input.addMoveCallback(this::p, this)
	
	    // bunny.input.pixelPerfectOver = true
	
	}
	
	fun p(pointer:Pointer) {
	
	    // console.log(pointer.)
	    //console.log(pointer.event)
	
	}
	
	override fun update() {
	
	    if (bunny.input.pointerOver())
	    {
	        bunny.alpha = 1.0
	    }
	    else
	    {
	        bunny.alpha = 0.5
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Over: " + bunny.input.pointerOver(), 32, 32)
	    game.debug.text(game.input.mouse.locked, 320, 32)
	
	}
}