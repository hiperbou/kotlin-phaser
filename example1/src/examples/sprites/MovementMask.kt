
package examples.sprites

import Koala.initKoala
import Phaser.*

class MovementMask: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("box", "assets/sprites/block.png")
	    game.load.image("platform", "assets/sprites/platform.png")
	
	}
	
	lateinit var box:Sprite
	
	override fun create() {
	
	    //  A platform the box will "rise" out of
	    var platform = game.add.sprite(150, game.world.centerY, "platform")
	    platform.height = 8.0
	
	    //  Box sprite is 95x95
	    box = game.add.sprite(570, 400, "box")
	    box.anchor.set(0.5)
	
	    //  A mask is a Graphics object
	    var mask = game.add.graphics(0, 0)
	
	    //  Shapes drawn to the Graphics object must be filled.
	    mask.beginFill(0xffffff)
	
	    //  Here we"ll draw a rectangle
	    mask.drawRect(platform.x, platform.y - 200, platform.width, 200)
	
	    //	And apply it to the Sprite
	    //  Comment out this line to see the mask visually
	    box.mask = mask
	
	    game.add.tween(box).to(object{ var  y= 200 }, 500, "Sine.easeInOut", true, 0, -1, true)
	    game.add.tween(box).to(object{ var  x= 232 }, 3000, "Sine.easeInOut", true, 0, -1, true)
	
	}
	
	override fun update() {
	
	    box.rotation += 0.04
	
	}
}