
package examples.input


import Phaser.*

class Drag: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("grid", "assets/tests/debug-grid-1920x1920.png")
	    game.load.image("atari", "assets/sprites/atari800xl.png")
	
	}
	
	override fun create() {
	
	    game.add.sprite(0, 0, "grid")
	
	    var atari1 = game.add.sprite(300, 300, "atari")
	
	    //  Input Enable the sprites
	    atari1.inputEnabled = true
	
	    //  Allow dragging - the "true" parameter will make the sprite snap to the center
	    atari1.input.enableDrag(true)
	
	}
}