
package examples.audio

import Koala.initKoala
import Phaser.*

class RemoveSound: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", { preload: preload, create: create, render: render })
	
	override fun preload() {
	
	    game.load.image("greenie", "assets/sprites/wizball.png")
	    game.load.audio("wizball", arrayOf("assets/audio/oedipus_wizball_highscore.mp3", "assets/audio/oedipus_wizball_highscore.ogg"))
	
	}
	
	lateinit var s:Sprite
	lateinit var music:Sound
	
	override fun create() {
	
	    game.stage.backgroundColor = "#182d3b"
	    game.input.touch.preventDefault = false
	
	    music = game.add.audio("wizball")
	
	    music.play()
	
	    s = game.add.sprite(game.world.centerX, game.world.centerY, "greenie")
	    s.anchor.set(0.5)
	
	    game.input.onDown.add(this::removeMusic, this)
	
	}
	
	fun removeMusic() {
	
	    music.destroy()
	
	    game.cache.removeSound("wizball")
	
	}
	
	override fun render() {
	
	    if (game.cache.checkSoundKey("wizball"))
	    {
	        game.debug.soundInfo(music, 20, 32)
	    }
	
	}
	
}