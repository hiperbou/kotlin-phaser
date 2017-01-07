
package examples.tilesprites

import Koala.initKoala
import Phaser.*

class SpriteSheetTilingSprite: State() {
	
	// //var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })

	lateinit var cursors:CursorKeys
	var count = 0.0
	
	override fun preload() {
	
	    game.load.image("starfield", "assets/misc/starfield.jpg")
	    game.load.spritesheet("mummy", "assets/sprites/metalslug_mummy37x45.png", 37, 45, 18)
	    game.load.atlas("seacreatures", "assets/sprites/seacreatures_json.png", "assets/sprites/seacreatures_json.json")
	
	}
	
	lateinit var sprite:TileSprite
	
	override fun create() {
	
	    sprite = game.add.tileSprite(0, 0, 800, 600, "mummy")
	    sprite.animations.add("walk")
	    sprite.animations.play("walk", 20, true)
	
	    // sprite = game.add.tileSprite(0, 0, 800, 600, "seacreatures", "octopus0002")
	    // sprite.animations.add("swim", Phaser.Animation.generateFrameNames("octopus", 0, 24, "", 4), 30, true)
	    // sprite.animations.play("swim")
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    count += 0.005
	
	    sprite.tileScale.x = 2 + Math.sin(count)
	    sprite.tileScale.y = 2 + Math.cos(count)
	    
	    sprite.tilePosition.x += 1
	    sprite.tilePosition.y += 1
	
	    if (cursors.left.isDown)
	    {
	        sprite.tilePosition.x += 4
	    }
	    else if (cursors.right.isDown)
	    {
	        sprite.tilePosition.x -= 4
	    }
	
	    if (cursors.up.isDown)
	    {
	        sprite.tilePosition.y += 4
	    }
	    else if (cursors.down.isDown)
	    {
	        sprite.tilePosition.y -= 4
	    }
	
	}
	
	override fun render() {
	
	    // game.debug.renderText(sprite.frame, 32, 32)
	
	}
}