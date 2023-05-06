
package examples.geometry


import Phaser.*

class LineIntersection: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("balls", "assets/sprites/balls.png", 17, 17)
	
	}
	
	lateinit var handle1:Sprite
	lateinit var handle2:Sprite
	lateinit var handle3:Sprite
	lateinit var handle4:Sprite
	
	lateinit var line1:Phaser.Line
	lateinit var line2:Phaser.Line
	
	override fun create() {
	
	    game.stage.backgroundColor = "#124184"
	
	    handle1 = game.add.sprite(100, 200, "balls", 0)
	    handle1.anchor.set(0.5)
	    handle1.inputEnabled = true
	    handle1.input.enableDrag(true)
	
	    handle2 = game.add.sprite(400, 300, "balls", 0)
	    handle2.anchor.set(0.5)
	    handle2.inputEnabled = true
	    handle2.input.enableDrag(true)
	
	    handle3 = game.add.sprite(200, 400, "balls", 1)
	    handle3.anchor.set(0.5)
	    handle3.inputEnabled = true
	    handle3.input.enableDrag(true)
	
	    handle4 = game.add.sprite(500, 500, "balls", 1)
	    handle4.anchor.set(0.5)
	    handle4.inputEnabled = true
	    handle4.input.enableDrag(true)
	
	    line1 = Phaser.Line(handle1.x, handle1.y, handle2.x, handle2.y)
	    line2 = Phaser.Line(handle3.x, handle3.y, handle4.x, handle4.y)
	
	}
	
	var c = "rgb(255,255,255)"
	var p:Point? = Phaser.Point()
	
	override fun update() {
	
	    line1.fromSprite(handle1, handle2, false)
	    line2.fromSprite(handle3, handle4, false)
	
	    p = line1.intersects(line2, true)
	
	    if (p!=null)
	    {
	        c = "rgb(0,255,0)"
	    }
	    else
	    {
	        c = "rgb(255,255,255)"
	    }
	 
	}
	
	override fun render() {
	
	    game.debug.geom(line1, c)
	    game.debug.geom(line2, c)
	
	    game.debug.lineInfo(line1, 32, 32)
	    game.debug.lineInfo(line2, 32, 100)
	
	    if (p!=null)
	    {
	        game.context.fillStyle = "rgb(255,0,255)"
	        game.context.fillRect(p!!.x - 2, p!!.y - 2, 5.0, 5.0)
	    }
	
	    game.debug.text("Drag the handles", 32, 550)
	
	}
}