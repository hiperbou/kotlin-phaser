
package examples.sprites


import Phaser.*

class RotateAndScale: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create})
	
	override fun preload() {
	
	    game.load.image("disk", "assets/sprites/copy-that-floppy.png")
	
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    sprite = game.add.sprite(400, 100, "disk")
	
	    game.add.tween(sprite).to( object{ var  angle= 45 }, 2000, Phaser.Easing.Linear::None, true)
	    game.add.tween(sprite.scale).to( object{ var  x= 2;  var  y= 2 }, 2000, Phaser.Easing.Linear::None, true)
	    
	}
}