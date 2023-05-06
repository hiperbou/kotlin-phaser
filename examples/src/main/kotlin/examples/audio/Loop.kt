
package examples.audio


import Phaser.*

class Loop: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", { preload: preload, create: create })
	
	override fun preload() {
	
	    game.load.image("speakers","assets/sprites/speakers.png")
	
	    game.load.audio("bass", "assets/audio/tech/bass.mp3")
	    game.load.audio("drums", "assets/audio/tech/drums.mp3")
	    game.load.audio("percussion", "assets/audio/tech/percussion.mp3")
	    game.load.audio("synth1", "assets/audio/tech/synth1.mp3")
	    game.load.audio("synth2", "assets/audio/tech/synth2.mp3")
	    game.load.audio("top1", "assets/audio/tech/top1.mp3")
	    game.load.audio("top2", "assets/audio/tech/top2.mp3")
	
	}
	
	lateinit var bass:Sound
	lateinit var drums:Sound
	lateinit var percussion:Sound
	lateinit var synth1:Sound
	lateinit var synth2:Sound
	lateinit var top1:Sound
	lateinit var top2:Sound
	
	lateinit var text:Text
	lateinit var sounds:List<Sound>
	lateinit var current:Sound
	lateinit var speakers:Image
	var loopCount = 0
	
	override fun create() {
	
	    game.stage.backgroundColor = "#838282"
	
	    speakers = game.add.image(game.world.centerX, 500, "speakers")
	    speakers.anchor.set(0.5, 1)
	
	    var style = TextStyle( font= "65px Arial", fill= "#52bace", align= "center" )
	    text = game.add.text(game.world.centerX, 100, "decoding", style)
	    text.anchor.set(0.5)
	
	    bass = game.add.audio("bass")
	    drums = game.add.audio("drums")
	    percussion = game.add.audio("percussion")
	    synth1 = game.add.audio("synth1")
	    synth2 = game.add.audio("synth2")
	    top1 = game.add.audio("top1")
	    top2 = game.add.audio("top2")
	
	    sounds = listOf(bass, drums, percussion, synth1, synth2, top1, top2 )
	
	    //  Being mp3 files these take time to decode, so we can"t play them instantly
	    //  Using setDecodedCallback we can be notified when they"re ALL ready for use.
	    //  The audio files could decode in ANY order, we can never be sure which it"ll be.
	
	    game.sound.setDecodedCallback(sounds.toTypedArray(), this::start, this)
	
	}
	
	fun start() {
	
	    sounds = sounds.drop(1)
	
	    bass.loopFull(0.6)
	    bass.onLoop.add(this::hasLooped, this)
	
	    text.text = "bass"
	
	}
	
	fun hasLooped(sound:Sound) {
	
	    loopCount++
	
	    if (loopCount === 1)
	    {
	        sounds.drop(1)
	        drums.loopFull(0.6)
	        text.text = "drums"
	        game.add.tween(speakers.scale).to( object{ var x = 1.3; var y = 1.1 }, 230, "Sine.easeInOut", true, 0, -1, true)
	    }
	    else if (loopCount === 2)
	    {
	        current = game.rnd.pick(sounds.toTypedArray())
	        current.loopFull()
	        text.text = current.key
	    }
	    else if (loopCount > 2)
	    {
	        current.stop()
	        current = game.rnd.pick(sounds.toTypedArray())
	        current.loopFull()
	        text.text = current.key
	    }
	
	}
}