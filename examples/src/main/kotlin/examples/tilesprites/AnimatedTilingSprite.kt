
package examples.tilesprites


import Phaser.*

class AnimatedTilingSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	// //var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	    game.load.image("disk", "assets/sprites/p2.jpeg")
	}
	
	lateinit var tilesprite:TileSprite
	lateinit var cursors:CursorKeys
	var count = 0.0
	
	override fun create() {
	
	    tilesprite = game.add.tileSprite(0, 0, 512, 512, "disk")
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    count += 0.005
	
	    tilesprite.tileScale.x = 2 + Math.sin(count)
	    tilesprite.tileScale.y = 2 + Math.cos(count)
	    
	    tilesprite.tilePosition.x += 1
	    tilesprite.tilePosition.y += 1
	
	    if (cursors.left.isDown)
	    {
	        tilesprite.x -= 4
	    }
	    else if (cursors.right.isDown)
	    {
	        tilesprite.x += 4
	    }
	
	    if (cursors.up.isDown)
	    {
	        tilesprite.y -= 4
	    }
	    else if (cursors.down.isDown)
	    {
	        tilesprite.y += 4
	    }
	
	}
}