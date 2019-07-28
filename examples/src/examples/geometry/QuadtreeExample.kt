
package examples.geometry


import Phaser.*

class QuadtreeExample: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update;  var  render= render })
	
	lateinit var marker:Phaser.Rectangle
	lateinit var quadTree:QuadTree
	var rects = mutableListOf<Rectangle>()

	var flaggedRect = mutableMapOf<Rectangle,Boolean> ()
	var Rectangle.flagged:Boolean
		get() {
			return flaggedRect.getOrElse(this) { false }
		}
		set(value:Boolean) { flaggedRect.put(this, value) }

	override fun create() {
	
	    quadTree = Phaser.QuadTree(0, 0, 800, 600, 10, 4, 0)
	
	    for(i in 0..48-1)
	    {
	        var x = game.world.randomX
	        var y = game.world.randomY
	
	        if (x > 760)
	        {
	            x = 760.0
	        }
	
	        if (y > 560)
	        {
	            y = 560.0
	        }
	
	        var rect = Phaser.Rectangle(x, y, 32, 32)
	        rect.id = i
	        rect.flagged = false
	        rects.add(rect)
	        quadTree.insert(rect)
	    }
	
	    marker = Phaser.Rectangle(0, 0, 128, 128)
	
	    game.input.onDown.add(this::retrieve, this)
	
	}
	
	fun retrieve() {
	
	    for(i in 0..rects.size-1)
	    {
	        rects[i].flagged = false
	    }
	
	    var found = quadTree.retrieve(marker)
	
	    console.log(found)
	
	    for(i in 0..found.size-1)
	    {
	        found[i].flagged = true
	    }
	
	}
	
	override fun update() {
	
	    marker.x = game.input.x
	    marker.y = game.input.y
	
	}
	
	override fun render() {
	
	    game.debug.quadTree(quadTree)
	
	    for(i in 0..rects.size-1)
	    {
	        if (rects[i].flagged)
	        {
	            game.debug.geom(rects[i], "#ff0000")
	        }
	        else
	        {
	            game.debug.geom(rects[i])
	        }
	
	        game.debug.text(rects[i].id, rects[i].x + 4, rects[i].y + 16)
	    }
	
	    game.debug.geom(marker, "#00bff3", false)
	
	}
}