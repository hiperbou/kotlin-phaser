
package examples.sprites


import Phaser.*

class RotateSpriteAroundPoint: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("ship", "assets/sprites/shmup-ship2.png")
	    game.load.image("ball", "assets/sprites/blue_ball.png")
	
	}
	
	lateinit var ship:Sprite
	lateinit var orb:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.stage.backgroundColor = "#001255"
	
	    ship = game.add.sprite(400, 300, "ship")
	    ship.anchor.setTo(0.5, 0.5)
	
	    game.physics.arcade.enable(ship)
	
	    orb = game.add.sprite(400, 300, "ball")
	    orb.anchor.setTo(0.5)
	    orb.pivot.x = 100.0
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    ship.body.velocity.x = 0.0
	    ship.body.velocity.y = 0.0
	
	    if (cursors.left.isDown)
	    {
	        ship.body.velocity.x = -300.0
	    }
	    else if (cursors.right.isDown)
	    {
	        ship.body.velocity.x = 300.0
	    }
	
	    if (cursors.up.isDown)
	    {
	        ship.body.velocity.y = -300.0
	    }
	    else if (cursors.down.isDown)
	    {
	        ship.body.velocity.y = 300.0
	    }
	
	    orb.rotation += 0.05
	
	}
	
	override fun preRender() {
	
	    orb.x = ship.x
	    orb.y = ship.y
	
	    // orb.position.rotate(ship.x, ship.y, 2, true, 100)
	
	}
}