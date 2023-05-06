
package examples.display


import Phaser.*

class RenderTextureTrail: State() {
	
	// //var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	
	}
	
	lateinit var mushroom:Sprite
	lateinit var texture:RenderTexture
	
	override fun create() {
	
	    //  Here we"ll create a renderTexture the same size as our game
	    texture = game.add.renderTexture(800, 600, "mousetrail")
	
	    //  This is the sprite that will be drawn to the texture
	    //  Note that we "make" it, not "add" it, as we don"t want it on the display list
	    mushroom = game.make.sprite(0, 0, "mushroom")
	    mushroom.anchor.set(0.5)
	    // mushroom.scale.set(2, 1)
	    // mushroom.angle = 45
	
	    //  This is the sprite that is drawn to the display. We"ve given it the renderTexture as its texture.
	    game.add.sprite(0, 0, texture)
	
	}
	
	override fun update() {
	
	    if (!game.input.activePointer.position.isZero())
	    {
	        //  Here we draw the mushroom sprite to the renderTexture at the pointer coordinates.
	        texture.renderXY(mushroom, game.input.activePointer.x, game.input.activePointer.y)
	    }
	
	}
}