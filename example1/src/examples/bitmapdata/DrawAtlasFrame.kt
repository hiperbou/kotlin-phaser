
package examples.bitmapdata

import Koala.initKoala
import Phaser.*

class DrawAtlasFrame: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload,  var  create= create,  var  update= update })
	
	override fun preload() {
	
	    game.load.atlas("atlas", "assets/sprites/atlas_hash_trim.png", "assets/sprites/atlas_json_hash_trim.json")
	
	}
	
	lateinit var bmd:BitmapData
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2d2d8d"
	
	    bmd = game.add.bitmapData(800, 600)
	    bmd.addToWorld(8, 8)
	
	    sprite = game.add.sprite(100, 64, "atlas", "contra3")
	    sprite.tint = 0
	
	    bmd.draw(sprite)
	
	    sprite.tint = 0xffffff
	
	}
	
	override fun update() {
	
	    if (game.input.activePointer.isDown)
	    {
	        // bmd.draw(jellyfish, game.input.activePointer.position.x, game.input.activePointer.position.y)
	    }
	
	}
}