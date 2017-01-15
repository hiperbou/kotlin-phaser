
package examples.sprites

import Koala.initKoala
import Phaser.*

class AlignTextToSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("pic", "assets/pics/ladycop.png")
	
	}
	
	override fun create() {
	
	    var style = TextStyle( font= "32px Courier", fill= "#00ff44" )
	
	    var sprite1 = game.add.sprite(220, 160, "pic")
	
	    var text1 = game.add.text(0, 0, "Phaser", style)
	    var text2 = game.add.text(0, 0, "2.4.9", style)
	    var text3 = game.add.text(0, 0, "Aligning Text", style)
	
	    text1.alignTo(sprite1, Phaser.RIGHT_TOP, 16)
	    text2.alignTo(sprite1, Phaser.RIGHT_CENTER, 16)
	    text3.alignTo(sprite1, Phaser.RIGHT_BOTTOM, 16)
	
	}
}