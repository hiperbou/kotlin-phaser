
package examples.input


import Phaser.*

class PixelpickAtlasScaled: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.atlas("atlas", "assets/pics/texturepacker_test.png", "assets/pics/texturepacker_test.json")
	
	}
	
	lateinit var chick:Sprite
	lateinit var car:Sprite
	lateinit var mech:Sprite
	lateinit var cop:Sprite
	lateinit var text:Text
	
	override fun create() {
	
	    game.stage.backgroundColor = "#404040"
	
	    //  This demonstrates pixel perfect click detection even if using sprites in a texture atlas.
	
	    chick = game.add.sprite(64, 64, "atlas")
	    chick.frameName = "budbrain_chick.png"
	    chick.inputEnabled = true
	    chick.input.pixelPerfectClick = true
	    chick.events.onInputDown.add(this::clicked, this)
	    chick.scale.set(2)
	
	    cop = game.add.sprite(650, 32, "atlas")
	    cop.frameName = "ladycop.png"
	    cop.inputEnabled = true
	    cop.input.pixelPerfectClick = true
	    cop.events.onInputDown.add(this::clicked, this)
	    cop.scale.set(1, 2.5)
	
	    car = game.add.sprite(100, 400, "atlas")
	    car.frameName = "supercars_parsec.png"
	    car.inputEnabled = true
	    car.input.pixelPerfectClick = true
	    car.events.onInputDown.add(this::clicked, this)
	    car.scale.set(0.5)
	
	    mech = game.add.sprite(240, 100, "atlas")
	    mech.frameName = "titan_mech.png"
	    mech.inputEnabled = true
	    mech.input.pixelPerfectClick = true
	    mech.events.onInputDown.add(this::clicked, this)
	    mech.scale.set(1.5, 1)
	
	    text = game.add.text(16, 16, "Click a sprite", TextStyle(fill="#ffffff" ))
	
	}
	
	fun clicked(sprite:Sprite, pointer:Pointer) {
	
	    text.text = "You clicked " + sprite.frameName
	
	}
}