
package examples.p2physics


import Phaser.*

class MouseSpring: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  preRender= preRender;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("gummi", "wip/gummi.png")
	    game.load.image("cow", "wip/cow48.png")
	    game.load.image("cursor", "assets/sprites/enemy-bullet.png")
	
	}
	
	lateinit var cow:Sprite
	lateinit var line:Phaser.Line
	lateinit var mouseBody:Sprite
	lateinit var mouseSpring: Physics.P2.Spring
	var drawLine = false
	
	override fun create() {
	        
	    game.stage.backgroundColor = "#304871"
	
	    game.physics.startSystem(Phaser.Physics.P2JS)
	    game.physics.p2.gravity.y = 100.0
	    game.physics.p2.restitution = 0.8
	
	    //  Create an object to pick-up
	
	    cow = game.add.sprite(200, 200, "cow")
	    // game.physics.p2.enable(cow, false)
	    game.physics.p2.enable(cow, true)
	    cow.body.setCircle(20)
	
	    //  Create our Mouse Cursor / Spring
	
	    mouseBody = game.add.sprite(100, 100, "cursor")
	    game.physics.p2.enable(mouseBody, true)
	    mouseBody.body.static = true
	    mouseBody.body.setCircle(10)
	    mouseBody.body.data.shapes[0].sensor = true
	
	    //  Debug spring line
	
	    line = Phaser.Line(cow.x, cow.y, mouseBody.x, mouseBody.y)
	
	    game.input.onDown.add(this::click, this)
	    game.input.onUp.add(this::release, this)
	    game.input.addMoveCallback(this::move, this)
	
	}
	
	fun click(pointer:Pointer) {
	
	    var bodies = game.physics.p2.hitTest(pointer.position, arrayOf(cow.body ))
	    
	    if (bodies.isNotEmpty())
	    {
	        //  Attach to the first body the mouse hit
	        mouseSpring = game.physics.p2.createSpring(mouseBody, bodies[0], 0, 30, 1)
	        line.setTo(cow.x, cow.y, mouseBody.x, mouseBody.y)
	        drawLine = true
	    }
	
	}
	
	fun release() {
	
	    game.physics.p2.removeSpring(mouseSpring)
	
	    drawLine = false
	
	}
	
	fun move(pointer:Pointer, x:Double, y:Double/*, isDown:Boolean*/) {
	
	    mouseBody.body.x = x
	    mouseBody.body.y = y
	    line.setTo(cow.x, cow.y, mouseBody.x, mouseBody.y)
	
	}
	
	override fun preRender() {
	
	    if (line != null)
	    {
	        line.setTo(cow.x, cow.y, mouseBody.x, mouseBody.y)
	    }
	
	}
	
	override fun render() {
	
	    if (drawLine != null)
	    {
	        game.debug.geom(line)
	    }
	
	}
}