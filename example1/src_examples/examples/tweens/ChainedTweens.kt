
package examples.tweens


import Phaser.*

class ChainedTweens: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("kirito", "assets/sprites/kirito_by_vali233.png")
	    game.load.image("asuna", "assets/sprites/asuna_by_vali233.png")
	
	}
	
	lateinit var text:Text
	lateinit var tweenA:Tween
	lateinit var tweenB:Tween
	
	override fun create() {
	
	    game.renderer.renderSession.roundPixels = true
	    game.stage.backgroundColor = "#124184"
	
	    game.add.text(16, 16, "Tween Chain Demo", object{ var  font= "16px Arial";  var  fill= "#ffffff" })
	    text = game.add.text(680, 16, "Click to Start", object{ var  font= "16px Arial";  var  fill= "#ffffff" })
	
	    var spriteA = game.add.sprite(64, 100, "kirito")
	    var spriteB = game.add.sprite(64, 300, "asuna")
	
	    tweenA = game.add.tween(spriteA).to( object{ var  x= 600 }, 2000, "Quart.easeOut")
	    tweenB = game.add.tween(spriteB).to( object{ var  x= 600 }, 2000, "Quart.easeOut")
	
	    tweenA.chain(tweenB)
	
	    game.input.onDown.add(this::start, this)
	
	}
	
	fun start() {
	
	    tweenA.start()
	
	    text.visible = false
	
	}
}