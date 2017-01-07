
package examples.text

import Koala.initKoala
import Phaser.*

class RetroFont1: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("knightHawks", "assets/fonts/retroFonts/KNIGHT3.png")
	
	}
	
	lateinit var font:RetroFont
	
	override fun create() {
	
	    font = game.add.retroFont("knightHawks", 31, 25, Phaser.RetroFont.TEXT_SET6, 10, 1, 1)
	
	    for(c in 1..19-1)
	    {
	        var i = game.add.image(game.world.centerX, 6 + c * 32, font)
	        i.tint = Math.random() * 0xFFFFFF
	        i.anchor.set(0.5, 1)
	    }
	
	}
	
	override fun update() {
	
		font.text = "phaser x: " + game.input.x + " y: " + game.input.y
	
	}
}