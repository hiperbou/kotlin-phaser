
package examples.display

import Koala.initKoala
import Phaser.*

class ArcDetails: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var info:Text
	lateinit var graphics1:Graphics
	lateinit var graphics2:Graphics
	var angle:dynamic = object{ var  min= 0;  var  max= 0 }
	
	override fun create() {
	
	    game.stage.backgroundColor = 0x2d2d2d
	
	    graphics1 = game.add.graphics(0, 0)
	    graphics2 = game.add.graphics(0, 0)
	
	    var style = TextStyle( font= "24px Arial", fill= "#ffffff", align= "center" )
	
	    info = game.add.text(32, 32, "Arc", style)
	
	    game.add.text(130, 500, "Clockwise", style)
	    game.add.text(530, 500, "Anticlockwise", style)
	
	    add.tween(angle).to( object{ var  max= 360 }, 6000, "Linear", true, 0, -1, true)
	
	}
	
	override fun update() {
	
	    info.text = "Arc maxAngle: " + Math.round(angle.max)
	
	    graphics1.clear()
	    graphics1.lineStyle(2, 0xffffff)
	    graphics1.beginFill(0x00bff3)
	    graphics1.arc(200, 300, 160, angle.min, Phaser.Math.degToRad(angle.max), false)
	    graphics1.endFill()
	
	    graphics2.clear()
	    graphics2.lineStyle(2, 0xffffff)
	    graphics2.beginFill(0xa000f3)
	    graphics2.arc(600, 300, 160, angle.min, Phaser.Math.degToRad(angle.max), true/*, 128*/)
	    graphics2.endFill()
	
	}
}