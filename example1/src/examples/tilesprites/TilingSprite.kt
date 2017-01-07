
package examples.tilesprites

import Koala.initKoala
import Phaser.*

class TilingSprite: State() {
	
	// //var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	lateinit var tilesprite:TileSprite
	lateinit var cursors:CursorKeys
	
	override fun preload() {
	
	    game.load.image("starfield", "assets/misc/starfield.jpg")
	
	}
	
	override fun create() {
	
	    tilesprite = game.add.tileSprite(0, 0, 800, 600, "starfield")
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	        tilesprite.tilePosition.x += 8
	    }
	    else if (cursors.right.isDown)
	    {
	        tilesprite.tilePosition.x -= 8
	    }
	
	    if (cursors.up.isDown)
	    {
	        tilesprite.tilePosition.y += 8
	    }
	    else if (cursors.down.isDown)
	    {
	        tilesprite.tilePosition.y -= 8
	    }
	
	}
}