
package examples.loader

import Koala.initKoala
import Phaser.*

class LoadAudio: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    //  To load an audio file use the following structure.
	    //  As with all load operations the first parameter is a unique key, which must be unique between all audio files.
	
	    //  The second parameter is an array containing the same audio file but in different formats.
	    //  In this example the music is provided as an mp3 and a ogg (Firefox will want the ogg for example)
	
	    //  The loader works by checking if the browser can support the first file type in the list (mp3 in this case). If it can, it loads it, otherwise
	    //  it moves to the next file in the list (the ogg). If it can"t load any of them the file will error.
	
	    game.load.audio("boden", mutableListOf("assets/audio/bodenstaendig_2000_in_rock_4bit.mp3", "assets/audio/bodenstaendig_2000_in_rock_4bit.ogg"))
	
	    //  If you know you only need to load 1 type of audio file, you can pass a string instead of an array, like this:
	    // game.load.audio("boden", "assets/audio/bodenstaendig_2000_in_rock_4bit.mp3")
	
	}
	
	lateinit var music:Sound
	
	override fun create() {
	
	    game.stage.backgroundColor = "#182d3b"
	
	    music = game.sound.play("boden")
	
	}
	
	override fun render() {
	
	    game.debug.soundInfo(music, 32, 32)
	
	    if (music.isDecoding)
	    {
	        game.debug.text("Decoding MP3 ...", 32, 200)
	    }
	
	}
}