
package examples.audio

import Koala.initKoala
import Phaser.*

class FadeIn: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", { preload: preload, create: create, render: render })
	
	override fun preload() {
	
	    game.load.image("disk", "assets/sprites/ra_dont_crack_under_pressure.png")
	    game.load.audio("boden", "assets/audio/goaman_intro.mp3")
	
	}
	
	lateinit var music:Sound
	
	override fun create() {
	
	    game.stage.backgroundColor = "#182d3b"
	    game.input.touch.preventDefault = false
	
	    music = game.add.audio("boden")
	    music.onDecoded.add(this::start, this)
	
	    game.add.sprite(game.world.centerX, game.world.centerY, "disk")
	    .anchor.setTo(0.5, 0.5)
	
	}
	
	fun start() {
	
	    music.fadeIn(4000)
	
	}
	
	override fun render() {
	    game.debug.soundInfo(music, 20, 32)
	}
	
}