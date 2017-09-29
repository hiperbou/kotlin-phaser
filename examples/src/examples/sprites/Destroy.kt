
package examples.sprites


import Phaser.*

class Destroy: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("plane", "assets/misc/boss1.png")
	    game.load.image("sky", "assets/tests/sky-2x.png")
	
	}
	
	override fun create() {
	
	    game.add.sprite(0, 0, "sky")
	
	    var mx = game.width - game.cache.getImage("plane").width
	    var my = game.height - game.cache.getImage("plane").height
	
	    for(i in 0..5-1)
	    {
	        var sprite = game.add.sprite(game.rnd.integerInRange(0, mx), game.rnd.integerInRange(0, my), "plane")
	
	        sprite.inputEnabled = true
	
	        sprite.input.useHandCursor = true
	
	        sprite.events.onInputDown.add(this::destroySprite, this)
	    }
	
	}
	
	fun destroySprite(sprite:Sprite) {
	
	    sprite.destroy()
	
	}
}