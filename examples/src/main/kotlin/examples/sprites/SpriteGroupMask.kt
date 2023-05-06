
package examples.sprites


import Phaser.*

class SpriteGroupMask: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("box", "assets/sprites/block.png")
	    game.load.image("platform", "assets/sprites/platform.png")
	
	}
	
	lateinit var group:Group
	
	override fun create() {
	
	    //  A platform the boxes will "rise" out of
	    var platform = game.add.sprite(0, game.world.centerY, "platform")
	    platform.width = game.width
	    platform.height = 8.0
	
	    group = game.add.group()
	
	    //  Box sprite is 95x95
	    var box1 = group.create(200, 300, "box")
	    var box2 = group.create(400, 300, "box")
	    var box3 = group.create(600, 300, "box")
	
	    group.setAll("anchor.x", 0.5)
	    group.setAll("anchor.y", 0.5)
	
	    //  A mask is a Graphics object
	    var mask = game.add.graphics(0, 100)
	
	    //  Shapes drawn to the Graphics object must be filled.
	    mask.beginFill(0xffffff)
	
	    //  Here we"ll draw a rectangle for each group sprite
	    mask.drawRect(130, 0, 140, 200)
	    mask.drawRect(330, 0, 140, 200)
	    mask.drawRect(530, 0, 140, 200)
	
	    //  And apply it to the Group itself
	    group.mask = mask
	
	    game.add.tween(box1).to(object{ var  y= 200 }, 1000, "Sine.easeInOut", true, 0, -1, true)
	    game.add.tween(box2).to(object{ var  y= 200 }, 1000, "Sine.easeInOut", true, 500, -1, true)
	    game.add.tween(box3).to(object{ var  y= 200 }, 1000, "Sine.easeInOut", true, 1000, -1, true)
	
	}
	
	override fun update() {
	
	    group.forEach { box:Group ->
	        box.rotation += 0.04
			Unit
	    }
	
	}
}