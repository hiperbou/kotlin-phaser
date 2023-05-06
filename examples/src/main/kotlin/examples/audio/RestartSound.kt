
package examples.audio


import Phaser.*

class RestartSound: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", { preload: preload, create: create, update: update, render: render })
	
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
	
	    game.input.onDown.add(this::restartMusic, this)
	
	}
	
	fun restartMusic() {
	
	    music.restart() //@todo, it seems that Phaser just plays another sound over and over :S
	
	}
	
	override fun update() {
	
	    s.rotation += 0.01
	
	}
	
	override fun render() {
	
	    game.debug.soundInfo(music, 20, 32)
	
	}
	
}