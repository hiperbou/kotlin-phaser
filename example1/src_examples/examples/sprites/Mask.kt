
package examples.sprites


import Phaser.*

class Mask: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("chaos", "assets/pics/hotshot-chaos_in_tokyo.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var mask:Graphics
	
	override fun create() {
	
		//	Here we add a Sprite to the display list
	    sprite = game.add.sprite(0, 0, "chaos")
	    sprite.scale.set(2)
	
	    //	A mask is a Graphics object
	    mask = game.add.graphics(0, 0)
	
	    //	Shapes drawn to the Graphics object must be filled.
	    mask.beginFill(0xffffff)
	
	    //	Here we"ll draw a circle
	    mask.drawCircle(100, 100, 100)
	
	    //	And apply it to the Sprite
	    sprite.mask = mask
	
	    //	As you move the mouse / touch, the circle will track the sprite
	    game.input.addMoveCallback(this::move, this)
	
	}
	
	fun move(pointer:Pointer, x:Double, y:Double) {
	
		mask.x = x - 100
		mask.y = y - 100
	
	}
}