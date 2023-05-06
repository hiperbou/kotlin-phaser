
package examples.display


import Phaser.*

class GraphicsChild: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/demoscene/atari.png")
	
	}
	
	override fun create() {
	
	    var graphics = game.add.graphics(260, 260)
	
	    graphics.beginFill(0x027a71)
	    graphics.lineStyle(4, 0x02fdeb, 1)
	    
	    graphics.moveTo(0, 0)
	    graphics.lineTo(250, 0)
	    graphics.lineTo(250, 200)
	    graphics.lineTo(125, 100)
	    graphics.lineTo(0, 200)
	    graphics.lineTo(0, 0)
	    graphics.endFill()
	    
	    var sprite = game.make.sprite(32, -48, "atari")
	
	    graphics.addChild(sprite)
	
	}
}