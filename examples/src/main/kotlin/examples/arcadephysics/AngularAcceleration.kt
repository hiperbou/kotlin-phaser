
package examples.arcadephysics


import Phaser.*

class AngularAcceleration: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	    game.load.image("arrow", "assets/sprites/arrow.png")
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	    
	    game.stage.backgroundColor = "#0072bc"
	
	    sprite = game.add.sprite(400, 300, "arrow")
	    sprite.anchor.setTo(0.5, 0.5)
	
	    game.physics.enable(sprite, Phaser.Physics.ARCADE)
	
	    //  We"ll set a lower max angular velocity here to keep it from going totally nuts
	    sprite.body.maxAngular = 500
	
	    //  Apply a drag otherwise the sprite will just spin and never slow down
	    sprite.body.angularDrag = 50
	
	}
	
	override fun update() {
	
	    //  Reset the acceleration
	    sprite.body.angularAcceleration = 0
	
	    //  Apply acceleration if the left/right arrow keys are held down
	    if (game.input.keyboard.isDown(Phaser.Keyboard.LEFT))
	    {
	        sprite.body.angularAcceleration -= 200
	    }
	    else if (game.input.keyboard.isDown(Phaser.Keyboard.RIGHT))
	    {
	        sprite.body.angularAcceleration += 200
	    }
	
	}
	
	override fun render() {
	
	    game.debug.spriteInfo(sprite, 32, 32)
	    game.debug.text("angularVelocity: " + sprite.body.angularVelocity, 32, 200)
	    game.debug.text("angularAcceleration: " + sprite.body.angularAcceleration, 32, 232)
	    game.debug.text("angularDrag: " + sprite.body.angularDrag, 32, 264)
	    game.debug.text("deltaZ: " + sprite.body.deltaZ(), 32, 296)
	
	}
}