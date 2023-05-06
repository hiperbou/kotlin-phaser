
package examples.tweens


import Phaser.*

class AlphaText: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("space", "assets/misc/starfield.png", 138, 15)
	    game.load.image("logo", "assets/sprites/phaser2.png")
	    
	}
	
	override fun create() {
	
	    var t = game.add.tileSprite(0, 0, 800, 600, "logo")
	    t.alpha = 0.1
	
	    var style = TextStyle( font= "65px Arial", fill= "#ff0044", align= "center" )
	    var text = game.add.text(game.world.centerX, game.world.centerY, "- phaser -\nwith a sprinkle of\npixi dust", style)
	    text.anchor.set(0.5)
	    text.alpha = 0.1
	
	    game.add.tween(text).to( object{ var  alpha= 1 }, 2000, "Linear", true)
	
	}
}