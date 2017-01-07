
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class QuadtreeCollisionInfos: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("ship", "assets/sprites/xenon2_ship.png")
	    game.load.image("baddie", "assets/sprites/space-baddie.png")
	
	}
	
	lateinit var ship:Sprite
	lateinit var aliens:Group
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    //  Enable the QuadTree
	    game.physics.arcade.skipQuadTree = false
	
	    aliens = game.add.group()
	    aliens.enableBody = true
	
	    for(i in 0..50-1)
	    {
	        var s = aliens.create(game.world.randomX, game.world.randomY, "baddie")
	        s.body.collideWorldBounds = true
	        s.body.bounce.set(1)
	        s.body.velocity.setTo(10 + Math.random() * 40, 10 + Math.random() * 40)
	    }
	
	    ship = game.add.sprite(400, 400, "ship")
	
	    game.physics.enable(ship, Phaser.Physics.ARCADE)
	
	    ship.body.collideWorldBounds = true
	    ship.body.bounce.set(1)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(ship, aliens)
	
	    if (cursors.left.isDown)
	    {
	        ship.body.velocity.x -= 4
	    }
	    else if (cursors.right.isDown)
	    {
	        ship.body.velocity.x += 4
	    }
	
	    if (cursors.up.isDown)
	    {
	        ship.body.velocity.y -= 4
	    }
	    else if (cursors.down.isDown)
	    {
	        ship.body.velocity.y += 4
	    }
	
	}
	
	override fun render() {
	
	    game.debug.quadTree(game.physics.arcade.quadTree)
	
	}
}