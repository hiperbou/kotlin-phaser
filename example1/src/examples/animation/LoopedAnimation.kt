
package examples.animation

import Koala.initKoala
import Phaser.*

class LoopedAnimation: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", { preload: preload, create: create, update: update })
	
	override fun preload() {
	    game.load.atlasJSONHash("bot", "assets/sprites/running_bot.png", "assets/sprites/running_bot.json")
	}
	
	lateinit var bot:Sprite
	
	override fun create() {
	
	    //  This sprite is using a texture atlas for all of its animation data
	    bot = game.add.sprite(200, 200, "bot")
	
	    //  Here we add a animation called "run"
	    //  We haven"t specified any frames because it"s using every frame in the texture atlas
	    bot.animations.add("run")
	
	    //  And this starts the animation playing by using its key ("run")
	    //  15 is the frame rate (15fps)
	    //  true means it will loop when it finishes
	    bot.animations.play("run", 15, true)
	
	}
	
	override fun update() {
	
	    bot.x -= 2
	
	    if (bot.x < -bot.width)
	    {
	        bot.x = game.world.width
	    }
	
	}
}