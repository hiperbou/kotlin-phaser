
package examples.input


import Phaser.*

class DragUpdate: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("ship", "assets/sprites/ship.png")
	    game.load.image("ball", "assets/sprites/longarrow.png")
	
	}
	
	var angle = 0.0
	lateinit var dragSprite:Sprite
	lateinit var copySprite:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2f0f1c"
	
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
	
	    copySprite = game.add.sprite(dragSprite.x + 220, dragSprite.y, "ball")
	    copySprite.anchor.set(0, 0.5)
	    copySprite.alpha = 0.5
	    copySprite.angle = 180.0
	
	    var text = game.add.text(32, 32, "drag the ship", object{ var  font= "32px Arial";  var  fill= "#f9b4cf" })
	    text.setShadow(6, 6, "rgba(0,0,0,0.8)", 5)
	
	}
	
	fun dragStart() {
	
	    copySprite.alpha = 1.0
	
	}
	
	fun dragUpdate(sprite:Sprite, pointer:Pointer, dragX:Double, dragY:Double, snapPoint:Point) {
	
	    //  As we drag the ship around inc the angle
	    angle += 0.01
	
	    //  This just circles the copySprite around the sprite being dragged
	    copySprite.x = dragSprite.x + 220 * Math.cos(angle)
	    copySprite.y = dragSprite.y + 220 * Math.sin(angle)
	
	    //  And this points the copySprite at the current pointer
	    copySprite.rotation = game.physics.arcade.angleToPointer(copySprite)
	
	}
	
	fun dragStop() {
	
	    copySprite.alpha = 0.5
	
	}
}