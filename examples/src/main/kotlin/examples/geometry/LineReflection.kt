
package examples.geometry


import Phaser.*

class LineReflection: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("balls", "assets/sprites/balls.png", 17, 17)
	    game.load.image("arrow", "assets/sprites/asteroids_ship.png")
	
	}
	
	lateinit var handle1:Sprite
	lateinit var handle2:Sprite
	lateinit var handle3:Sprite
	lateinit var handle4:Sprite
	
	lateinit var line1:Phaser.Line
	lateinit var line2:Phaser.Line
	
	lateinit var arrow:Sprite
	lateinit var normal:Phaser.Line
	lateinit var reflection:Phaser.Line
	
	override fun create() {
	
	    game.stage.backgroundColor = "#124184"
	
	    handle1 = game.add.sprite(235, 220, "balls", 0)
	    handle1.anchor.set(0.5)
	    handle1.inputEnabled = true
	    handle1.input.enableDrag(true)
	
	    handle2 = game.add.sprite(377, 437, "balls", 0)
	    handle2.anchor.set(0.5)
	    handle2.inputEnabled = true
	    handle2.input.enableDrag(true)
	
	    handle3 = game.add.sprite(160, 300, "balls", 1)
	    handle3.anchor.set(0.5)
	    handle3.inputEnabled = true
	    handle3.input.enableDrag(true)
	
	    handle4 = game.add.sprite(450, 350, "balls", 1)
	    handle4.anchor.set(0.5)
	    handle4.inputEnabled = true
	    handle4.input.enableDrag(true)
	
	    line1 = Phaser.Line(handle1.x, handle1.y, handle2.x, handle2.y)
	    line2 = Phaser.Line(handle3.x, handle3.y, handle4.x, handle4.y)
	
	    arrow = game.add.sprite(0, 0, "arrow")
	    arrow.anchor.set(0.5)
	
	    normal = Phaser.Line(0, 0, 0, 0)
	    reflection = Phaser.Line(0, 0, 0, 0)
	
	}
	
	var c = "rgb(255,255,255)"
	var p:Point? = Phaser.Point()
	
	override fun update() {
	
	    line1.fromSprite(handle1, handle2, false)
	    line2.fromSprite(handle3, handle4, false)
	
	    p = line1.intersects(line2, true)
	
	    if (p != null)
	    {
	        c = "rgb(0,255,0)"
	
	        //  Update the normal from the intersection point (100px.size)
	        normal.fromAngle(p!!.x, p!!.y, line2.normalAngle, 100)
	
	        //  Either of these is fine:
	        // var outgoing = Phaser.Line.reflect(line1, line2)
	        var outgoing = line1.reflect(line2)
	
	        reflection.fromAngle(p!!.x, p!!.y, outgoing, 200)
	
	        arrow.x = reflection.end.x
	        arrow.y = reflection.end.y
	        arrow.rotation = reflection.angle
	        arrow.visible = true
	    }
	    else
	    {
	        arrow.visible = false
	        c = "rgb(255,255,255)"
	    }
	 
	}
	
	override fun render() {
	
	    game.debug.geom(line1, "#ff0000")
	    game.debug.geom(line2, "#9999ff")
	
	    game.debug.lineInfo(line1, 32, 32)
	    game.debug.lineInfo(line2, 32, 100)
	
	    if (p != null)
	    {
	        game.debug.geom(normal, "#ffffff")
	        game.debug.geom(reflection, "#00ff00")
	
	        game.context.fillStyle = "rgb(255,0,255)"
	        game.context.fillRect(p!!.x - 2, p!!.y - 2, 5.0, 5.0)
	    }
	
	    game.debug.text("Drag the handles", 32, 550)
	
	}
}