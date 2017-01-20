
package examples.misc


import Phaser.*

class AntialiasGame: State() {
	
	var transparent = false
	var antialias = false
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", this, transparent, antialias)
	
	override fun preload() {
	
	    game.load.image("girl", "assets/pics/manga-girl.png")
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0076a3"
	
	    var sprite = game.add.sprite(32, -100, "girl")
	    sprite.scale.set(4)
	
	}
	
	override fun render() {
	
	    game.debug.text("Anti-alias: " + game.antialias, 10, 32)
	    // game.debug.text("Anti-alias: " + Phaser.Canvas.getSmoothingEnabled(game.context), 10, 32)
	    // game.debug.text("Anti-alias: " + game.renderer.renderSession.smoothProperty, 10, 32)
	
	}
}