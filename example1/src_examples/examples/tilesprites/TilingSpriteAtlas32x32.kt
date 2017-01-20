
package examples.tilesprites


import Phaser.*

class TilingSpriteAtlas32x32: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	// //var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.atlas("pwr2", "assets/sprites/pwr2.png", "assets/sprites/pwr2.json")
	
	}
	
	lateinit var sprite1:TileSprite
	lateinit var sprite2:TileSprite
	var count = 0.0
	
	override fun create() {
	
	    sprite1 = game.add.tileSprite(0, 0, 800, 600, "pwr2", "mushroom2")
	    sprite2 = game.add.tileSprite(0, 0, 800, 600, "pwr2", "hotdog")
	
	}
	
	override fun update() {
	
	    count += 0.005
	
	    sprite1.tileScale.x = 2 + Math.sin(count)
	    sprite1.tileScale.y = 2 + Math.cos(count)
	
	    sprite2.tilePosition.x -= Math.sin(count) * 4
	    sprite2.tilePosition.y -= Math.cos(count) * 4
	
	}
}