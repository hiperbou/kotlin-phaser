
package examples.audio

import Koala.initKoala
import Phaser.*

class Ios: State() {
	//@todo: does not work
	//  Comment out the line below to see the rocker switch work as expected
	//window.PhaserGlobal = object { val disableWebAudio = true }
	
	//var game = Phaser.Game(400, 400, Phaser.CANVAS, "phaser-example", { preload: preload, create: create, render: render })
	
	override fun preload() {
	
	    game.stage.disableVisibilityChange = true
	    game.scale.scaleMode = Phaser.ScaleManager.SHOW_ALL
	
	    game.load.audio("music", "rave_digger.mp3")
	
	}
	lateinit var music:Sound

	override fun create() {
	
	    game.stage.backgroundColor = "#182d3b"
	
	    music = game.add.audio("music")
	
	    game.input.onDown.addOnce(fun() { music.play() })
	
	}
	
	override fun render() {
	
	    game.debug.soundInfo(music, 20, 32)
	
	}
}