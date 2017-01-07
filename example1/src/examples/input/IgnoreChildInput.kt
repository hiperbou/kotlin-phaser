
package examples.input

import Koala.initKoala
import Phaser.*

class IgnoreChildInput: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("beball", "assets/sprites/beball1.png")
	    game.load.image("bikkuriman", "assets/sprites/bikkuriman.png")
	    game.load.image("square", "assets/sprites/50x50.png")
	
	}
	
	var text = ""
	lateinit var group1:Group
	lateinit var group2:Group
	
	override fun create() {
	
	    //  Let"s create 2 Groups
	    group1 = game.add.group()
	    group2 = game.add.group()
	
	    //  This will automatically inputEnable all children added to both Groups
	    group1.inputEnableChildren = true
	    group2.inputEnableChildren = true
	
	    //  Create 10 Sprites per Group
	    for(i in 0..10-1)
	    {
	        var sprite1 = group1.create(64 + (64 * i), 150, "beball")
	        sprite1.name = "group1-child-" + i
	        sprite1.events.onInputDown.add(this::clickedSprite, this)
	
	        var sprite2 = group2.create(64 + (64 * i), 350, "bikkuriman")
	        sprite2.name = "group2-child-" + i
	        sprite2.events.onInputDown.add(this::clickedSprite, this)
	    }
	
	    //  Our toggle switch
	    var toggle = add.sprite(800-66, 16, "square")
	    toggle.inputEnabled = true
	    toggle.events.onInputDown.add(this::toggleGroup, this)
	
	}
	
	fun toggleGroup () {
	
	    //  By setting ignoreChildInput to true we can tell Group 2s children
	    //  to ignore all input events
	
	    group2.ignoreChildInput = if (group2.ignoreChildInput) false else true
	
	}
	
	fun clickedSprite(sprite:Sprite) {
	
	    text = sprite.name
	
	    sprite.tint = 0xff0000
	
	}
	
	override fun render() {
	
	    if (text === "")
	    {
	        game.debug.text("Click the Sprites. Click the square to toggle Group 2 input.", 32, 32)
	    }
	    else
	    {
	        game.debug.text("You clicked: " + text, 32, 32)
	    }
	
	    game.debug.text("Group2.ignoreChildInput: " + group2.ignoreChildInput, 32, 64)
	
	}
}