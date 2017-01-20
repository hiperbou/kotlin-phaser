
package examples.arcadephysics


import Phaser.*

class BounceWithGravity: State() {
	// mods by Patrick OReilly 
	// Twitter: @pato_reilly Web: http://patricko.byethost9.com
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    //  You can fill the preloader with as many assets as your game requires
	
	    //  Here we are loading an image. The first parameter is the unique
	    //  string by which we"ll identify the image later in our code.
	
	    //  The second parameter is the URL of the image (relative)
	    game.load.image("flyer", "assets/sprites/phaser-dude.png")
	}
	
	lateinit var image:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    //  This creates a simple sprite that is using our loaded image and displays it on-screen and assign it to a variable
	    image = game.add.sprite(400, 200, "flyer")
	
	    game.physics.enable(image, Phaser.Physics.ARCADE)
	    
	    //  This gets it moving
	    image.body.velocity.setTo(200, 200)
	    
	    //  This makes the game world bounce-able
	    image.body.collideWorldBounds = true
	    
	    //  This sets the image bounce energy for the horizontal  and vertical vectors (as an x,y point). "1" is 100% energy return
	    image.body.bounce.set(0.8)
	
	    image.body.gravity.set(0, 180)
	
	}
	
	override fun update() {
	
	    // nothing required here
	    
	}
	
	override fun render() {
	
	    //debug helper
	    game.debug.spriteInfo(image, 32, 32)
	
	}
}