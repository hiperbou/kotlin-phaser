
package examples.camera


import Phaser.*

class BasicFollow: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("background","assets/tests/debug-grid-1920x1920.png")
	    game.load.image("player","assets/sprites/phaser-dude.png")
	
	}
	
	lateinit var player:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.add.tileSprite(0, 0, 1920, 1920, "background")
	
	    game.world.setBounds(0, 0, 1920, 1920)
	
	    game.physics.startSystem(Phaser.Physics.P2JS)
	
	    player = game.add.sprite(game.world.centerX, game.world.centerY, "player")
	
	    game.physics.p2.enable(player)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    game.camera.follow(player)
	
	}
	
	override fun update() {
	
	    player.body.setZeroVelocity()
	
	    if (cursors.up.isDown)
	    {
	        player.body.moveUp(300)
	    }
	    else if (cursors.down.isDown)
	    {
	        player.body.moveDown(300)
	    }
	
	    if (cursors.left.isDown)
	    {
	        player.body.velocity.x = -300.0
	    }
	    else if (cursors.right.isDown)
	    {
	        player.body.moveRight(300)
	    }
	
	}
	
	override fun render() {
	
	    game.debug.cameraInfo(game.camera, 32, 32)
	    game.debug.spriteCoords(player, 32, 500)
	
	}
}