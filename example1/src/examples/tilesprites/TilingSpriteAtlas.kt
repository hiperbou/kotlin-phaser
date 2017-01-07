
package examples.tilesprites

import Koala.initKoala
import Phaser.*

class TilingSpriteAtlas: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	// //var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	var count = 0.0
	
	override fun preload() {
	
	    game.load.atlas("seacreatures", "assets/sprites/seacreatures_json.png", "assets/sprites/seacreatures_json.json")
	
	}
	
	lateinit var sprite:TileSprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0072bc"
	
	    //  "seacreatures" is our texture atlas in the cache
	    //  "octopus0002" is a frame within that atlas
	
	    sprite = game.add.tileSprite(0, 0, 800, 600, "seacreatures", "octopus0002")
	
	}
	
	override fun update() {
	
	    count += 0.005
	
	    sprite.tileScale.x = 2 + Math.sin(count)
	    sprite.tileScale.y = 2 + Math.cos(count)
	    
	    sprite.tilePosition.x += 1
	    sprite.tilePosition.y += 1
	
	}
}