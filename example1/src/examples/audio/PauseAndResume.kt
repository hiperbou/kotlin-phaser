
package examples.audio

import Koala.initKoala
import Phaser.*

class PauseAndResume: State() {
	
	//window.PhaserGlobal = { disableWebAudio: true }
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", { preload: preload, create: create, update: update, render: render })
	
	override fun preload() {
	
	    game.load.image("disk", "assets/sprites/ra_dont_crack_under_pressure.png")
	
	    //  Firefox doesn"t support mp3 files, so use ogg
	    game.load.audio("boden", arrayOf("assets/audio/bodenstaendig_2000_in_rock_4bit.mp3", "assets/audio/bodenstaendig_2000_in_rock_4bit.ogg"))
	    // game.load.audio("boden", ["assets/audio/time.mp3"])
	
	}
	
	lateinit var s:Sprite
	lateinit var music:Sound
	
	override fun create() {
	
	    game.stage.backgroundColor = "#182d3b"
	    game.input.touch.preventDefault = false
	
	    music = game.add.audio("boden")
	    music.play()
	
	    s = game.add.sprite(game.world.centerX, game.world.centerY, "disk")
	    s.anchor.setTo(0.5, 0.5)
	
	    game.input.onDown.add(this::changeVolume, this)
	
	}
	
	fun changeVolume(pointer:Pointer) {
	
	    if (pointer.y < 300)
	    {
	        music.pause()
	    }
	    else
	    {
	        music.resume()
	    }
	
	}
	
	override fun update() {
	    s.rotation += 0.01
	}
	
	override fun render() {
	    game.debug.soundInfo(music, 20, 32)
	}
	
}