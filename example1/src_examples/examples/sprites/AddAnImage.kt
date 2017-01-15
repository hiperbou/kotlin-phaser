
package examples.sprites

import Koala.initKoala
import Phaser.*

class AddAnImage: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("pic", "assets/pics/acryl_bladerunner.png")
	
	}
	
	override fun create() {
	
	    //  This simply creates an Image using the picture we loaded above and positions it at 100 x 100
	
	    //  The difference between an Image and a Sprite is that you cannot animate or add a physics body to an Image
	
	    var image = game.add.image(100, 100, "pic")
	
	}
}