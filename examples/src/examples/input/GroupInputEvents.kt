
package examples.input


import Phaser.*

class GroupInputEvents: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("beball", "assets/sprites/beball1.png")
	    game.load.image("bikkuriman", "assets/sprites/bikkuriman.png")
	
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
	
	        var sprite2 = group2.create(64 + (64 * i), 350, "bikkuriman")
	        sprite2.name = "group2-child-" + i
	    }
	
	    //  And now we"ll listen to the Group events
	    group1.onChildInputDown.add(this::onDown, this)
	    group2.onChildInputDown.add(this::onDown, this)
	
	    group1.onChildInputOver.add(this::onOver, this)
	    group2.onChildInputOver.add(this::onOver, this)
	
	    group1.onChildInputOut.add(this::onOut, this)
	    group2.onChildInputOut.add(this::onOut, this)
	
	}
	
	fun onDown(sprite:Sprite) {
	
	    text = "onDown: " + sprite.name
	
	    sprite.tint = 0x00ff00
	
	}
	
	fun onOver(sprite:Sprite) {
	
	    text = "onOver: " + sprite.name
	
	    sprite.tint = 0xff0000
	
	}
	
	fun onOut(sprite:Sprite) {
	
	    text = "onOut: " + sprite.name
	
	    sprite.tint = 0xffffff
	
	}
	
	override fun render() {
	
	    if (text === "")
	    {
	        game.debug.text("Interact with the Sprites.", 32, 32)
	    }
	    else
	    {
	        game.debug.text(text, 32, 32)
	    }
	
	}
}