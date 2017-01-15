
package examples.misc

import Koala.initKoala
import Phaser.*

class GameConfig: State() {
	
	//  You can pass in a configuration object to the Game constructor 
	//  instead of using the parameters, like this:
	
	/*var conf = GameConfig(
	    width = 800
	    height = 600
	    renderer = Phaser.AUTO
	    parent = "gameDiv"
	    transparent = false
	    antialias = false
	    state = this
	    scaleMode = Phaser.ScaleManager.EXACT_FIT
	)
	*/
	//var game = Phaser.Game(conf)
	
	override fun preload() {
	
	    game.load.image("robota", "assets/pics/Robota_UXO_by_Made_of_Bomb.jpg")
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0076a3"
	
	    var sprite = game.add.sprite(0, 50, "robota")
	
	    sprite.scale.set(0.5)
	
	    game.add.tween(sprite).to( object{ var  x= -160 }, 2000, "Sine.easeInOut", true, 0, -1, true)
	
	}
}