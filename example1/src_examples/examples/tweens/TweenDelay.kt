
package examples.tweens


import Phaser.*

class TweenDelay: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("pic", "assets/pics/TheBrightestLightComesFromTheDarkestPlace_by_Slayer_Ghostown.png")
	    
	}
	
	lateinit var text:Text
	
	override fun create() {
	
	    var pic = game.add.image(game.world.centerX, game.world.centerY, "pic")
	    pic.anchor.set(0.5)
	    pic.alpha = 0.1
	
	    text = game.add.text(game.world.centerX, 100, "2000ms delay", object{ var  font= "32px Arial";  var  fill= "#ff0044";  var  align= "center" })
	    text.anchor.set(0.5)
	
	    //  This tween will wait 2 seconds before starting
	    var tween = game.add.tween(pic).to( object{ var  alpha= 1 }, 2000, "Linear", true, 2000)
	
	    tween.onStart.add(this::started, this)
	    tween.onComplete.add(this::completed, this)
	
	}
	
	fun started() {
	
	    text.text = "tween started"
	
	}
	
	fun completed() {
	
	    text.text = "tween complete"
	
	}
}