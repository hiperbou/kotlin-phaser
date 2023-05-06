
package examples.input


import Phaser.*

class OutOfGame: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("rain", "assets/pics/thalion-rain.png")
	    game.load.image("bubble", "assets/pics/bubble-on.png")
	
	}
	
	lateinit var bubble:Image
	
	override fun create() {
	
	    game.add.tileSprite(0, 0, 800, 600, "rain")
	
	    bubble = game.add.image(game.world.centerX, game.world.centerY, "bubble")
	    bubble.anchor.set(0.5)
	
	}
	
	override fun update() {
	
	    if (game.input.activePointer.withinGame)
	    {
	        bubble.alpha = 1.0
	    }
	    else
	    {
	        bubble.alpha = 0.3
	    }
	
	}
	
	override fun render() {
	
	    game.debug.inputInfo(32, 32)
	    game.debug.pointer(game.input.activePointer)
	
	}
}