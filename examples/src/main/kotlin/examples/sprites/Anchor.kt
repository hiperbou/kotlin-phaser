
package examples.sprites


import Phaser.*

class Anchor: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("pic", "assets/pics/lance-overdose-loader_eye.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var point:Point
	var dec = false
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0072bc"
	
	    point = Phaser.Point(300.0, 300.0)
	
	    sprite = game.add.sprite(point.x, point.y, "pic")
	
	    game.input.onDown.add(this::updateAnchor, this)
	
	}
	
	override fun update() {
	
	    // Un-comment this to see the effect of rotation combined with the anchor
	    // sprite.rotation += 0.01
	
	}
	
	fun updateAnchor() {
	
	    if (dec)
	    {
	        sprite.anchor.x -= 0.1
	        sprite.anchor.y -= 0.1
	
	        if (sprite.anchor.x <= 0)
	        {
	            dec = false
	        }
	    }
	    else
	    {
	        sprite.anchor.x += 0.1
	        sprite.anchor.y += 0.1
	
	        if (sprite.anchor.x >= 1)
	        {
	            dec = true
	        }
	    }
	
	}
	
	override fun render() {
	
	    game.debug.geom(point, "rgb(0,255,0)")
	
	    game.debug.text("Anchor X: " + sprite.anchor.x + " Y: " + sprite.anchor.y, 32, 32)
	    game.debug.text("Sprite X: " + sprite.x + " Y: " + sprite.y, 32, 64)
	    game.debug.text("Click to adjust the anchor", 32, 96)
	
	}
}