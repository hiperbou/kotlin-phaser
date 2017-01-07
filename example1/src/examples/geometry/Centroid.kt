
package examples.geometry

import Koala.initKoala
import Phaser.*

class Centroid: State() {
	// Example: Phaser.Point.centroid
	// Author: Lewis "SEPTiMUS" Lane
	// URL: http://www.rotates.org - https://github.com/lewster32
	// Instructions: Click to add points. Points can be dragged. Centroid is displayed as a white cross, points as red rings.
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	    game.load.spritesheet("centroid", "assets/sprites/centroid.png", 16, 16)
	}
	
	var points = mutableListOf<Point>()
	var over = false
	lateinit var currentPoint:Image
	lateinit var centroid:Image

	override fun create() {
	
	    currentPoint = game.add.image(10, 10, "centroid")
	    currentPoint.anchor.set(0.5)
	
	    currentPoint.alpha = 0.5
	
	    centroid = game.add.image(10, 10, "centroid", 1)
	    centroid.anchor.set(0.5)
	    centroid.visible = false
	
	    game.input.onTap.add(this::onTapHandler, this)
	
	}
	
	fun onTapHandler() {
	
	    if (!over)
	    {
	        var img = game.add.sprite(game.input.activePointer.position.x, game.input.activePointer.position.y, "centroid", 0)
	
	        points.add(img.position)
	
	        img.anchor.set(0.5)
	        img.alpha = 0.25
	        img.inputEnabled = true
	        img.input.enableDrag(true)
	        img.defaultCursor = "move"
	
	        img.events.onInputOver.add({sprite->
	            sprite.alpha = 1.0
	            sprite.scale.setTo(1.2, 1.2)
	            over = true
	        }, img)
	
	        img.events.onInputOut.add({sprite->
	            sprite.alpha = 0.25
	            sprite.scale.setTo(1, 1)
	            over = false
	        }, img)
	    }
	
	}
	
	override fun update() {
	
	    currentPoint.position.copyFrom(game.input.activePointer.position)
	
	    if (points.size > 0)
	    {
	        var c = Phaser.Point.centroid(points.toTypedArray())
	
	        centroid.position.copyFrom(c)
	
	        if (!centroid.visible)
	        {
	            centroid.visible = true
	        }
	    }
	
	}
	
	override fun render() {
	
	    game.world.forEachAlive( { child->
	        game.debug.text(Phaser.Math.roundTo(child.x, 0).toString() + "," + Phaser.Math.roundTo(child.y, 0), child.x - 10, child.y + 25, "#ff1e00", "12px Courier")
	    })
	
	    if (centroid.visible)
	    {
	        game.debug.text("Points may be dragged.", 10, 20)
	        game.debug.text(Phaser.Math.roundTo(centroid.x, 0).toString() + "," + Phaser.Math.roundTo(centroid.y, 0), centroid.x - 10, centroid.y - 15, "#fff", "bold 12px Courier")
	    }
	    else
	    {
	        game.debug.text("Click anywhere to add points.", 10, 20)
	    }
	
	}
}