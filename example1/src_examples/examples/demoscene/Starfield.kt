
package examples.demoscene

import Koala.initKoala
import Phaser.*

class Starfield: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	fun floor(value: Double): Double = Phaser.Math.floorTo(value,null,null)

	override fun preload() {
	
	    game.load.image("tinystar", "assets/demoscene/star2.png")
	
	}
	
	var distance = 300.0
	var speed = 6.0
	lateinit var star:Sprite
	lateinit var texture:RenderTexture
	
	var max = 400
	var xx = emptyArray<Double>()
	var yy = emptyArray<Double>()
	var zz = emptyArray<Double>()
	
	override fun create() {
	
	    star = game.make.sprite(0, 0, "tinystar")
	    texture = game.add.renderTexture(800, 600, "texture")
	
	    game.add.sprite(0, 0, texture)

		xx = Array<Double>(max, { floor(Math.random() * 800) - 400 });
		yy = Array<Double>(max, { floor(Math.random() * 600) - 300 });
		zz = Array<Double>(max, { floor(Math.random() * 1700) - 100 });
	}
	
	override fun update() {
	
	    texture.clear()
	
	    for(i in 0..max-1)
	    {
	        var perspective = distance / (distance - zz[i])
	        var x = game.world.centerX + xx[i] * perspective
	        var y = game.world.centerY + yy[i] * perspective
	
	        zz[i] += speed
	
	        if (zz[i] > 300)
	        {
	            zz[i] -= 600.0
	        }
	
	        texture.renderXY(star, x, y)
	    }
	
	}
}