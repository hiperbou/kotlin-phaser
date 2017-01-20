
package examples.display


import Phaser.*

class TintSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
		game.load.image("pic", "assets/pics/barbarian_loading.png")
	
	}
	
	lateinit var pic:Sprite
	
	override fun create() {
	
		pic = game.add.sprite(game.world.centerX, game.world.centerY, "pic")
		pic.anchor.set(0.5)
	
	    game.time.events.loop(Phaser.Timer.SECOND * 2, this::changeTint, this)
	
	}
	
	fun changeTint() {
	
		pic.tint = Math.random() * 0xffffff
	
	}
}