
package examples.animation

import Koala.initKoala
import Phaser.*

class ChangeFrame: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", { preload: preload, create: create })
	
	override fun preload() {
	
	    game.load.atlas("seacreatures", "assets/sprites/seacreatures_json.png", "assets/sprites/seacreatures_json.json")
	    game.load.image("undersea", "assets/pics/undersea.jpg")
	
	}
	
	lateinit var greenJellyfish:Sprite
	
	override fun create() {
	
	    game.add.image(0, 0, "undersea")
	
	    greenJellyfish = game.add.sprite(330, 100, "seacreatures", "greenJellyfish0000")
	
	    game.input.onDown.add(this::changeFrame, this)
	
	}
	
	fun changeFrame(pointer:Pointer) {
	
	    greenJellyfish.frameName = "greenJellyfish0010"
	
	}
}