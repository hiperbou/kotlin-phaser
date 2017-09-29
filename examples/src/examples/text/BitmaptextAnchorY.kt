
package examples.text


import Phaser.*

class BitmaptextAnchorY: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.bitmapFont("desyrel", "assets/fonts/bitmapFonts/desyrel.png", "assets/fonts/bitmapFonts/desyrel.xml")
	
	}
	
	lateinit var line1:Phaser.Line
	lateinit var line2:Phaser.Line
	
	override fun create() {
	
	    var text = game.add.bitmapText(400, 300, "desyrel", "Middle Earth", 64)
	    text.anchor.x = 0.5
	    text.anchor.y = 0.5
	
	    line1 = Phaser.Line(400, 0, 400, 600)
	    line2 = Phaser.Line(0, 300, 800, 300)
	
	}
	
	override fun render() {
	
	    game.debug.geom(line1)
	    game.debug.geom(line2)
	
	}
}