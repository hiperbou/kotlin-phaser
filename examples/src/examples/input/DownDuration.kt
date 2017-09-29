
package examples.input


import Phaser.*

class DownDuration: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("bunny", "assets/sprites/bunny.png")
	
	}
	
	lateinit var bunny:Sprite
	var lastDuration = 0.0
	
	override fun create() {
	
	    bunny = game.add.sprite(game.world.centerX, game.world.centerY, "bunny")
	
	    bunny.alpha = 0.5
	    bunny.anchor.set(0.5)
	
	    game.input.onUp.add(this::getTime, this)
	
	}
	
	override fun update() {
	
	    if (game.input.activePointer.isDown)
	    {
	        bunny.alpha = 1.0
	    }
	    else
	    {
	        bunny.alpha = 0.5
	    }
	
	}
	
	fun getTime(pointer:Pointer) {
	
	    // lastDuration = pointer.timeUp - pointer.timeDown
	
	    lastDuration = pointer.duration
	
	}
	
	override fun render() {
	
	    game.debug.text("Duration: " + game.input.activePointer.duration, 32, 32)
	    game.debug.text("Last Duration: " + lastDuration, 32, 64)
	
	}
}