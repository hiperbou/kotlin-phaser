
package examples.sprites


import Phaser.*

class OverlapWithoutPhysics: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("atari1", "assets/sprites/atari130xe.png")
	    game.load.image("atari2", "assets/sprites/atari800xl.png")
	
	}
	
	lateinit var sprite1:Sprite
	lateinit var sprite2:Sprite
	lateinit var text:Text
	
	override fun create() {
	
	    sprite1 = game.add.sprite(100, 200, "atari1")
	    sprite1.inputEnabled = true
	    sprite1.input.enableDrag()
	
	    sprite2 = game.add.sprite(400, 400, "atari2")
	    sprite2.inputEnabled = true
	    sprite2.input.enableDrag()
	
	    text = game.add.text(16, 16, "Drag the sprites. Overlapping: false", object{ var  fill= "#ffffff" })
	
	}
	
	override fun update() {
	
	    if (checkOverlap(sprite1, sprite2))
	    {
	        text.text = "Drag the sprites. Overlapping: true"
	    }
	    else
	    {
	        text.text = "Drag the sprites. Overlapping: false"
	    }
	
	}
	
	fun checkOverlap(spriteA:Sprite, spriteB:Sprite):Boolean {
	
	    var boundsA = spriteA.getBounds()
	    var boundsB = spriteB.getBounds()
	
	    return Phaser.Rectangle.intersects(boundsA, boundsB)
	
	}
}