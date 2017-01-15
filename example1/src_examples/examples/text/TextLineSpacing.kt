
package examples.text

import Koala.initKoala
import Phaser.*

class TextLineSpacing: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	override fun create() {
	
	    game.stage.backgroundColor = "#5d5d5d"
	
	    var haiku = "Turtles and mushrooms\nYou are in the wrong castle\nFireball mustache"
	
	    var text = game.add.text(100, 64, haiku,  object{ var  font= "32px Arial";  var  fill= "#ffffff";  var  backgroundColor= "rgba(0;  var 255;  var 0;  var 0.25)" })
	    text.lineSpacing = -20
	
	    var haiku2 = "Green hat, Master Sword\nMonsters and chickens beware\nMoney making game"
	
	    var text2 = game.add.text(100, 300, haiku2,  object{ var  font= "32px Arial";  var  fill= "#ffffff";  var  backgroundColor= "rgba(0;  var 255;  var 0;  var 0.25)" })
	    text2.lineSpacing = 40
	
	}
}