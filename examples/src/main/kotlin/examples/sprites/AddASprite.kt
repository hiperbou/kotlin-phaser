
package examples.sprites


import Phaser.*

class AddASprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	
	}
	
	override fun create() {
	
	    //  This simply creates a sprite using the mushroom image we loaded above and positions it at 200 x 200
	    var test = game.add.sprite(200, 200, "mushroom")
	
	}
}