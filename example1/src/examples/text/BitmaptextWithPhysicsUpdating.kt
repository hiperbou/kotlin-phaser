
package examples.text

import Koala.initKoala
import Phaser.*

class BitmaptextWithPhysicsUpdating: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.bitmapFont("desyrel", "assets/fonts/bitmapFonts/desyrel.png", "assets/fonts/bitmapFonts/desyrel.xml")
	    game.load.bitmapFont("stack", "assets/fonts/bitmapFonts/shortStack.png", "assets/fonts/bitmapFonts/shortStack.xml")
	
	}
	
	lateinit var text1:BitmapText
	lateinit var text2:BitmapText
	var words = arrayOf("Ouch!", "bump", "eek", "look out", "careful", "mind out", "watch it!", "OI!", "Owww", "Grrrr", "that hurt", "bully")
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    text1 = game.add.bitmapText(200, 100, "desyrel", "BitmapText", 64)
	    text2 = game.add.bitmapText(400, 400, "stack", "with Physics", 32)
	
	    game.physics.arcade.enable(arrayOf( text1, text2 ))
	
	    text1.body.velocity.setTo(200, 200)
	    text1.body.collideWorldBounds = true
	    text1.body.bounce.set(1)
	
	    text2.body.velocity.setTo(-100, -100)
	    text2.body.collideWorldBounds = true
	    text2.body.bounce.set(1)
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(text1, text2, this::onCollide)
	
	}
	
	fun onCollide(a:Sprite,b:Sprite) {
	
	    text1.text = game.rnd.pick(words)
	
	}
	
	override fun render() {
	    // game.debug.body(text1)
	}
}