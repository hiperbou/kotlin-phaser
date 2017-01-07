
package examples.loader

import Koala.initKoala
import Phaser.*

class LoadImage: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    //  Specify a unique key and a URL path
	    //  The key must be unique between all images.
	    game.load.image("imageKey", "assets/sprites/phaser2.png")
	
	}
	
	override fun create() {
	
	    game.add.sprite(0, 0, "imageKey")
	
	}
}