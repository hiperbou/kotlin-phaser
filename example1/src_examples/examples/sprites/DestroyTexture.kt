
package examples.sprites


import Phaser.*

class DestroyTexture: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("plane", "assets/misc/boss1.png")
	
	}
	
	lateinit var sprite1:Sprite
	lateinit var sprite2:Sprite
	lateinit var sprite3:Sprite
	
	override fun create() {
	
	    var bmd = game.add.bitmapData(256, 256)
	    bmd.fill(0, 0, 255, 0.5)
	
	    sprite1 = game.add.sprite(0, 0, bmd)
	    sprite2 = game.add.sprite(200, 0, "plane")
	
	    game.input.onDown.add(this::destroySprite, this)
	
	}
	
	fun destroySprite () {
	
	    sprite1.destroy(true, true)
	
	    //  Create a sprite, this should use a BMD from the pool
	
	    var bmd = game.add.bitmapData(256, 256)
	
	    bmd.fill(255, 0, 255, 0.5)
	
	    sprite3 = game.add.sprite(0, 0, bmd)
	
	}
}