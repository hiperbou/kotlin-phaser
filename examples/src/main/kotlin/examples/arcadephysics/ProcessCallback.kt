
package examples.arcadephysics


import Phaser.*

class ProcessCallback: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/sprites/atari130xe.png")
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	
	}
	
	lateinit var sprite1:Sprite
	lateinit var sprite2:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    //  This will check Sprite vs. Sprite collision using a custom process callback
	    sprite1 = game.add.sprite(0, 200, "atari")
	    sprite2 = game.add.sprite(750, 220, "mushroom")
	
	    game.physics.enable(arrayOf<Phaser.Sprite>(sprite1,sprite2), Phaser.Physics.ARCADE)
	
	    //  We"ll use random velocities so we can test it in our processCallback
	    sprite1.body.velocity.x = 50 + Math.random() * 100
	    sprite2.body.velocity.x = -(50 + Math.random() * 100)
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(sprite1, sprite2, this::collisionCallback, this::processCallback, this)
	
	}
	
	fun processCallback (obj1:Sprite, obj2:Sprite):Boolean {
	
	    //  This fun can perform your own additional checks on the 2 objects that collided.
	    //  For example you could test for velocity, health, etc.
	    //  This fun needs to return either true or false. If it returns true then collision carries on (separating the two objects).
	    //  If it returns false the collision is assumed to have failed and aborts, no further checks or separation happen.
	
	    if (obj1.body.speed > obj2.body.speed)
	    {
	        return true
	    }
	    else
	    {
	        return false
	    }
	
	}
	
	fun collisionCallback (obj1:Sprite, obj2:Sprite) {
	
	    game.stage.backgroundColor = "#992d2d"
	
	}
	
	override fun render() {
	
	    game.debug.text("The processCallback will only collide if sprite1 is going fastest.", 32, 32)
	    game.debug.text("Sprite 1 speed: " + sprite1.body.speed, 32, 64)
	    game.debug.text("Sprite 2 speed: " + sprite2.body.speed, 32, 96)
	
	}
	
}