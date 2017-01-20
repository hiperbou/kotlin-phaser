
package examples.input


import Phaser.*

class InputEnableGroup: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	var text = ""
	
	override fun preload() {
	
	    game.load.image("beball", "assets/sprites/beball1.png")
	    game.load.image("bikkuriman", "assets/sprites/bikkuriman.png")
	
	}
	
	override fun create() {
	
	    var group = game.add.group()
	
	    //  This will automatically inputEnable all children added to the Group
	    group.inputEnableChildren = true
	
	    for(i in 0..10-1)
	    {
	        var sprite = group.create(64 + (64 * i), 400, "beball")
	
	        sprite.name = "child" + i
	
	        sprite.events.onInputDown.add(this::clickedSprite, this)
	    }
	
	}
	
	fun clickedSprite(sprite:Sprite) {
	
	    text = sprite.name
	
	    sprite.y -= 16
	
	}
	
	override fun render() {
	
	    if (text === "")
	    {
	        game.debug.text("Click the Sprites", 32, 32)
	    }
	    else
	    {
	        game.debug.text("You clicked: " + text, 32, 32)
	    }
	
	}
}