
package examples.arcadephysics


import Phaser.*

class PlatformerTight: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("dude", "assets/games/starstruck/dude.png", 32, 48)
	    game.load.image("background", "assets/games/starstruck/background2.png")
	
	}
	
	lateinit var player:Sprite
	var facing = "left"
	var jumpTimer = 0.0
	lateinit var cursors:CursorKeys
	lateinit var jumpButton:Key
	lateinit var bg:TileSprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    bg = game.add.tileSprite(0, 0, 800, 600, "background")
	
	    game.physics.arcade.gravity.y = 300.0
	
	    player = game.add.sprite(32, 320, "dude")
	    game.physics.enable(player, Phaser.Physics.ARCADE)
	
	    player.body.collideWorldBounds = true
	    player.body.gravity.y = 1000.0
	    player.body.maxVelocity.y = 500.0
	    player.body.setSize(20, 32, 5, 16)
	
	    player.animations.add("left", arrayOf(0, 1, 2, 3), 10, true)
	    player.animations.add("turn", arrayOf(4), 20, true)
	    player.animations.add("right", arrayOf(5, 6, 7, 8), 10, true)
	
	    cursors = game.input.keyboard.createCursorKeys()
	    jumpButton = game.input.keyboard.addKey(Phaser.Keyboard.SPACEBAR)
	
	}
	
	override fun update() {
	
	    // game.physics.arcade.collide(player, layer)
	
	    player.body.velocity.x = 0
	
	    if (cursors.left.isDown)
	    {
	        player.body.velocity.x = -150
	
	        if (facing != "left")
	        {
	            player.animations.play("left")
	            facing = "left"
	        }
	    }
	    else if (cursors.right.isDown)
	    {
	        player.body.velocity.x = 150
	
	        if (facing != "right")
	        {
	            player.animations.play("right")
	            facing = "right"
	        }
	    }
	    else
	    {
	        if (facing != "idle")
	        {
	            player.animations.stop()
	
	            if (facing == "left")
	            {
	                player.frame = 0
	            }
	            else
	            {
	                player.frame = 5
	            }
	
	            facing = "idle"
	        }
	    }
	    
	    if (jumpButton.isDown && player.body.onFloor() && game.time.now > jumpTimer)
	    {
	        player.body.velocity.y = -500
	        jumpTimer = game.time.now + 750
	    }
	
	}
	
	override fun render() {
	
	    // game.debug.text(game.time.physicsElapsed, 32, 32)
	    // game.debug.body(player)
	    game.debug.bodyInfo(player, 16, 24)
	
	}
}