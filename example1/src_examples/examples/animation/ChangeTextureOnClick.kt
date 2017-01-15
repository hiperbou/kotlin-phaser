
package examples.animation

import Koala.initKoala
import Phaser.*

class ChangeTextureOnClick: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", { preload: preload, create: create, render: render })
	
	override fun preload() {
	
	    game.load.atlasJSONHash("bot", "assets/sprites/running_bot.png", "assets/sprites/running_bot.json")
	    game.load.spritesheet("mummy", "assets/sprites/metalslug_mummy37x45.png", 37, 45, 18)
	
	}
	
	lateinit var bot:Sprite
	
	override fun create() {
	
	    bot = game.add.sprite(200, 200, "bot")
	
	    bot.animations.add("run")
	
	    bot.animations.play("run", 15, true)
	
	    game.input.onDown.addOnce(this::changeMummy, this)
	
	}
	
	fun changeMummy() {
	
	    bot.loadTexture("mummy", 0)
	
	    bot.animations.add("walk")
	
	    bot.animations.play("walk", 30, true)
	
	}
	
	override fun render() {
	
	    game.debug.body(bot)
	
	}
}