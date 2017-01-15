
package examples.input

import Koala.initKoala
import Phaser.*

class DragUpdateMultiple: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("grid", "assets/tests/debug-grid-1920x1920.png")
	    game.load.image("ship", "assets/sprites/ship.png")
	    game.load.image("ball", "assets/sprites/pangball.png")
	
	}
	
	var angle = 0.0
	lateinit var dragSprite:Sprite
	lateinit var copySprite:Sprite
	
	override fun create() {
	
	    game.add.sprite(0, 0, "grid").alpha = 0.4
	
	    dragSprite = game.add.sprite(game.world.centerX, game.world.centerY, "ship")
	    dragSprite.anchor.set(0.5)
	
	    //  Input Enable the sprite
	    dragSprite.inputEnabled = true
	
	    //  Allow dragging
	    dragSprite.input.enableDrag()
	
	    //  Drag events
	    dragSprite.events.onDragStart.add(this::dragStart)
	    dragSprite.events.onDragUpdate.add(this::dragUpdate)
	    dragSprite.events.onDragStop.add(this::dragStop)
	
	    copySprite = game.add.sprite(dragSprite.x + 200, dragSprite.y, "ball")
	    copySprite.anchor.set(0.5)
	    copySprite.alpha = 0.5
	
	    // game.add.tween(angle).to( object{ var  x= 360 }, 2000, "Linear", true, 0, -1)
	
	}
	
	fun dragStart() {
	
	    copySprite.alpha = 1.0
	
	}
	
	fun dragUpdate(sprite:Sprite, pointer:Pointer, dragX:Double, dragY:Double, snapPoint:Point) {
	
	    //  As we drag the ship around inc the angle
	    angle += 0.01
	
	    copySprite.x = dragSprite.x + 200 * Math.cos(angle)
	    copySprite.y = dragSprite.y + 200 * Math.sin(angle)
	
	}
	
	fun dragStop() {
	
	    copySprite.alpha = 0.5
	
	}
	
	override fun update() {
	
	
	}
	
	override fun render() {
	
	 
	}
}