
package examples.sprites

import Koala.initKoala
import Phaser.*

class FixedScale: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create})
	
	override fun preload() {
	
	    game.load.image("disk", "assets/sprites/copy-that-floppy.png")
	    game.load.image("ball", "assets/sprites/mushroom2.png")
	
	}
	
	lateinit var parent:Sprite
	lateinit var child:Sprite
	
	override fun create() {
	
	    parent = game.add.sprite(100, 100, "disk")
	    parent.name = "disk"
	
	    child = game.make.sprite(0, 0, "ball")
	    parent.addChild(child)
	
	    //  Fix the scale of the child so it will never scale below 1 or above 2
	    child.setScaleMinMax(1, 2)
	
	    //  Even though the parent will scale, the child will remain at its own scale (and this is carried on down to any of its children)
	    game.add.tween(parent.scale).to( object{ var  x= 3;  var  y= 3 }, 2000, Phaser.Easing.Linear::None, true, 0, 1000, true)
	    
	}
}