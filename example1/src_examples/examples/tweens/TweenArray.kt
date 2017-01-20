
package examples.tweens


import Phaser.*

class TweenArray: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("ball", "assets/sprites/pangball.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var tween:Tween
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2384e7"
	
	    sprite = game.add.sprite(100, 250, "ball")
	
	    tween = game.add.tween(sprite)
	    tween.to(object { var x = arrayOf(500, 500, 100, 100); var y = arrayOf(250, 150, 150, 250) }, 3000, "Linear")
	    tween.start()
	
	    game.input.onDown.add(this::again, this)
	
	}
	
	fun again() {
	
	    if (!tween.isRunning)
	    {
	        sprite.position.setTo(100, 250)
	        tween.start()
	    }
	
	}
}