
package examples.geometry

import Koala.initKoala
import Phaser.*

class LineMidpoint: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("balls", "assets/sprites/balls.png", 17, 17)
	
	}
	
	lateinit var handle1:Sprite
	lateinit var handle2:Sprite
	
	lateinit var line:Phaser.Line
	lateinit var mid:Phaser.Point
	
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
	
	    line = Phaser.Line(handle1.x, handle1.y, handle2.x, handle2.y)
	    mid = Phaser.Point()
	
	}
	
	override fun update() {
	
	    line.fromSprite(handle1, handle2, false)
	
	    line.midPoint(mid)
	 
	}
	
	override fun render() {
	
	    game.debug.geom(line)
	    game.debug.geom(mid, "#ffff00")
	    game.debug.lineInfo(line, 32, 32)
	
	    game.debug.text("Drag the handles", 32, 550)
	
	}
}