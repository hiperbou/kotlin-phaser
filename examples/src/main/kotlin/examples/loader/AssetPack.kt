
package examples.loader


import Phaser.*

class AssetPack: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.pack("level1", "assets/asset-pack1.json", null, this)
	    game.load.image("test", "assets/sprites/ilkke.png")
	
	}
	
	lateinit var music:Sound
	
	override fun create() {
	
	    game.stage.backgroundColor = "#182d3b"
	
	    game.add.image(0, 0, "starwars")
	    game.add.image(0, 300, "spaceship")
	    game.add.image(700, 360, "test")
	
	    music = game.sound.play("boden")
	
	    game.add.bitmapText(380, 150, "desyrel", "Bitmap Fonts", 48)
	
	    var mummy = game.add.sprite(370, 232, "mummy")
	    mummy.animations.add("walk")
	    mummy.animations.play("walk", 20, true)
	
	}
	
	override fun render() {
	
	    game.debug.soundInfo(music, 370, 32)
	
	    if (music.isDecoding)
	    {
	        game.debug.text("Decoding MP3 ...", 32, 200)
	    }
	
	}
}