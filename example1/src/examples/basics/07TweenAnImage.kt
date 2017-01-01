
package examples.basics

import Koala.initKoala
import Phaser.*

class E07TweenAnImage: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", { preload: preload, create: create, update: update, render: render })
	lateinit var tween:Tween
	var prev = -400
	lateinit var sprite:Sprite
	
	override fun preload() {
	
	    game.forceSingleUpdate = true
	
	    //  You can fill the preloader with as many assets as your game requires
	
	    //  Here we are loading an image. The first parameter is the unique
	    //  string by which we"ll identify the image later in our code.
	
	    //  The second parameter is the URL of the image (relative)
	    game.load.image("einstein", "assets/pics/ra_einstein.png")
	    // game.load.image("einstein", "assets/sprites/chunk.png")
	}
	
	override fun create() {
	
	    sprite = game.add.sprite(-400, 0, "einstein")
	    // var sprite = game.add.sprite(0, 0, "einstein")
	
	    //  Here we create a tween on the sprite created above
	    tween = game.add.tween(sprite)
	
	    //  The object defines the properties to tween.
	    //  In this case it will move to x 600
	    //  The 6000 is the duration in ms - 6000ms = 6 seconds
	    // tween.to(object{var  x= 500var  y= 500 }, 5000, "Linear", true, 2000)
	    tween.to(object{var  x= 800 }, 5000, "Linear", true, 0)
	
	    //  And this starts it going
	    // tween.start()

	}
}