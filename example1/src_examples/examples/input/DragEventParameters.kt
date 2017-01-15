
package examples.input

import Koala.initKoala
import Phaser.*

class DragEventParameters: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("grid", "assets/tests/debug-grid-1920x1920.png")
	    game.load.image("atari", "assets/sprites/atari800xl.png")
	    game.load.image("sonic", "assets/sprites/sonic_havok_sanity.png")
	
	}
	
	var result = "Drag a sprite"
	
	override fun create() {
	
	    game.add.sprite(0, 0, "grid")
	
	    var group = game.add.group()
	
	    group.inputEnableChildren = true
	
	    var atari = group.create(32, 100, "atari")
	
	    //  Enable input and allow for dragging
	    atari.inputEnabled = true
	    atari.input.enableDrag()
	    atari.events.onDragStart.add(this::onDragStart, this)
	    atari.events.onDragStop.add(this::onDragStop, this)
	
	    var sonic = group.create(300, 200, "sonic")
	
	    sonic.inputEnabled = true
	    sonic.input.enableDrag()
	    sonic.events.onDragStart.add(this::onDragStart, this)
	    sonic.events.onDragStop.add(this::onDragStop, this)
	
	    group.onChildInputDown.add(this::onDown, this)
	
	}
	
	fun onDown(sprite:Sprite, pointer:Pointer) {
	
	    result = "Down " + sprite.key
	
	    console.log("down", sprite.key)
	
	}
	
	fun onDragStart(sprite:Sprite, pointer:Pointer) {
	
	    result = "Dragging " + sprite.key
	
	}
	
	fun onDragStop(sprite:Sprite, pointer:Pointer) {
	
	    result = sprite.key + " dropped at x:" + pointer.x + " y: " + pointer.y
	
	    if (pointer.y > 400)
	    {
	        console.log("input disabled on", sprite.key)
	        sprite.input.enabled = false
	
	        sprite.sendToBack()
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text(result, 10, 20)
	
	}
}