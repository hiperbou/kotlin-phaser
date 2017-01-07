
package examples.sprites

import Koala.initKoala
import Phaser.*

class Rope: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	lateinit var rope:Phaser.Rope
	lateinit var debugKey:Key
	var shouldDebug = false
	
	override fun preload() {
	
	    game.load.image("snake", "assets/sprites/snake.png")
	
	}
	
	override fun create() {
	
	    var count = 0.0
	    var length = 918 / 20
	    var points = mutableListOf<Point>()
	
	    for(i in 0..20-1)
	    {
	        points.add(Phaser.Point(i.toDouble() * length, 0.0))
	    }
	    rope = game.add.rope(32, this.game.world.centerY, "snake", null, points.toTypedArray())
	    rope.scale.set(0.8)
	
	    rope.updateAnimation = {
	        count += 0.1
	
	        for(i in 0..points.size-1)
	        {
	            points[i].y = Math.sin(i * 0.5 + count) * 20
	        }
	    }
	
	    debugKey = game.input.keyboard.addKey(Phaser.Keyboard.D)
	    debugKey.onDown.add(this::toggleDebug)
	
	}
	
	override fun render() {
	
	    if (shouldDebug)
	    {
	        game.debug.ropeSegments(rope)
	    }
	
	    game.debug.text("(D) to show debug", 20, 32)
	
	}
	
	fun toggleDebug() {
	
	    shouldDebug = !shouldDebug
	
	}
}