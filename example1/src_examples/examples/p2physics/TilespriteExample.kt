
package examples.p2physics

import Koala.initKoala
import Phaser.*

class TilespriteExample: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
		game.load.image("sky", "assets/skies/sky4.png")
	    game.load.image("starfield", "assets/misc/starfield.jpg")
	    game.load.spritesheet("veggies", "assets/sprites/fruitnveg64wh37.png", 64, 64)
	
	}
	
	lateinit var sprite:TileSprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.add.image(0, 0, "sky")
	
		//	Enable p2 physics
		game.physics.startSystem(Phaser.Physics.P2JS)
	
	    //  Make things a bit more bouncey
	    game.physics.p2.restitution = 0.8
	
	    //  Add a sprite
	    sprite = game.add.tileSprite(300, 450, 200, 50, "starfield")
	
	    //  Enable if for physics. This creates a default rectangular body.
		game.physics.p2.enable(sprite)
	
	    val veggies = game.add.group()
	    veggies.enableBody = true
	    veggies.physicsBodyType = Phaser.Physics.P2JS
	
	    var vegFrames = arrayOf( 1, 3, 4, 8 )
	
	    for(i in 0..10-1)
	    {
	        var veg = veggies.create(game.world.randomX, game.world.randomY, "veggies", game.rnd.pick(vegFrames))
	        veg.body.setCircle(26)
	    }
	
	    val text = game.add.text(20, 20, "move with arrow keys", TextStyle(fill="#ffffff" ))
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
		sprite.body.setZeroVelocity()
	
	    if (cursors.left.isDown)
	    {
	    	sprite.body.moveLeft(400)
	        sprite.tilePosition.x -= 8
	    }
	    else if (cursors.right.isDown)
	    {
	    	sprite.body.moveRight(400)
	        sprite.tilePosition.x += 8
	    }
	
	    if (cursors.up.isDown)
	    {
	    	sprite.body.moveUp(400)
	        sprite.tilePosition.y -= 8
	    }
	    else if (cursors.down.isDown)
	    {
	    	sprite.body.moveDown(400)
	        sprite.tilePosition.y += 8
	    }
	
	}
}