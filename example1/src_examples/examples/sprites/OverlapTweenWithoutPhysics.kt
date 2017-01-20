
package examples.sprites


import Phaser.*

class OverlapTweenWithoutPhysics: State() {
	
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
	
	    sprite2 = game.add.sprite(400, 100, "atari2")
	
	    game.add.tween(sprite2).to( object{ var  y= 400 }, 3000, Phaser.Easing.Cubic::InOut, true, 0, Int.MAX_VALUE, true)
	
	    text = game.add.text(16, 16, "Drag the sprite. Overlapping: false", object{ var  fill= "#ffffff" })
	
	}
	
	override fun update() {
	
	    if (checkOverlap(sprite1, sprite2))
	    {
	        text.text = "Drag the sprite. Overlapping: true"
	    }
	    else
	    {
	        text.text = "Drag the sprite. Overlapping: false"
	    }
	
	}
	
	fun checkOverlap(spriteA:Sprite, spriteB:Sprite):Boolean {
	
	    var boundsA = spriteA.getBounds()
	    var boundsB = spriteB.getBounds()
	
	    return Phaser.Rectangle.intersects(boundsA, boundsB)
	
	}
}