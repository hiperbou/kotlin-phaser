
package examples.sprites

import Koala.initKoala
import Phaser.*

class SpriteTint: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.atlas("atlas", "assets/sprites/seacreatures_json.png", "assets/sprites/seacreatures_json.json")
	
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    sprite = game.add.sprite(game.world.centerX, game.world.centerY, "atlas", "greenJellyfish0000")
	    sprite.anchor.set(0.5)
	
	    sprite.tint = Math.random() * 0xffffff
	
	    game.input.onDown.add(this::changeTint, this)
	
	}
	
	fun changeTint() {
	
	    sprite.tint = Math.random() * 0xffffff
	
	}
	
	override fun update() {
	
	    sprite.rotation += 0.02
	
	}
}