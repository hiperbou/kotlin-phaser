
package examples.input


import Phaser.*

class GamepadMultiplePads: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update=update })
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser-dude.png")
	    game.load.image("melon", "assets/sprites/melon.png")
	    game.load.spritesheet("controller-indicator", "assets/misc/controller-indicator.png", 16,16)
	
	}
	
	lateinit var pad1:Phaser.SinglePad
	lateinit var pad2:Phaser.SinglePad
	
	lateinit var indicator1:Sprite
	lateinit var indicator2:Sprite
	
	lateinit var player1:Sprite
	lateinit var player2:Sprite
	
	lateinit var melon:Sprite
	
	
	override fun create() {
	
	    game.stage.backgroundColor = "#736357"
	    game.input.gamepad.start()
	
	
	    indicator1 = game.add.sprite(10,10, "controller-indicator")
	    indicator1.scale.x = 2.0
		indicator1.scale.y = 2.0
	    indicator1.animations.frame = 1
	
	    indicator2 = game.add.sprite(10,50, "controller-indicator")
	    indicator2.scale.x = 2.0
		indicator2.scale.y = 2.0
	    indicator2.animations.frame = 1
	
	    player1 = game.add.sprite(300, 300, "phaser")
	    player1.anchor.setTo(0.5,0.5)
	
	    player2 = game.add.sprite(450, 300, "phaser")
	    player2.anchor.setTo(0.5,0.5)
	
	    // This little melon dude is controlled by all gamepads!
	    melon = game.add.sprite(375, 350, "melon")
	    melon.anchor.setTo(0.5,0.5)
	
	    pad1 = game.input.gamepad.pad1
	    pad2 = game.input.gamepad.pad2
	}
	
	override fun update() {
	    // Pad "connected or not" indicator
	    if(game.input.gamepad.supported && game.input.gamepad.active && game.input.gamepad.pad1.connected) {
	        indicator1.animations.frame = 0
	    } else {
	        indicator1.animations.frame = 1
	    }
	    if(game.input.gamepad.supported && game.input.gamepad.active && game.input.gamepad.pad2.connected) {
	        indicator2.animations.frame = 0
	    } else {
	        indicator2.animations.frame = 1
	    }
	
	    if (pad1.isDown(Phaser.Gamepad.XBOX360_DPAD_LEFT) || pad1.axis(Phaser.Gamepad.XBOX360_STICK_LEFT_X) < -0.1)
	    {
	        player1.x--
	    }
	    if (pad1.isDown(Phaser.Gamepad.XBOX360_DPAD_RIGHT) || pad1.axis(Phaser.Gamepad.XBOX360_STICK_LEFT_X) > 0.1)
	    {
	        player1.x++
	    }
	    if (pad1.isDown(Phaser.Gamepad.XBOX360_DPAD_UP) || pad1.axis(Phaser.Gamepad.XBOX360_STICK_LEFT_Y) < -0.1)
	    {
	        player1.y--
	    }
	    if (pad1.isDown(Phaser.Gamepad.XBOX360_DPAD_DOWN) || pad1.axis(Phaser.Gamepad.XBOX360_STICK_LEFT_Y) > 0.1)
	    {
	        player1.y++
	    }
	
	    if (pad2.isDown(Phaser.Gamepad.XBOX360_DPAD_LEFT) || pad2.axis(Phaser.Gamepad.XBOX360_STICK_LEFT_X) < -0.1)
	    {
	        player2.x--
	    }
	    if (pad2.isDown(Phaser.Gamepad.XBOX360_DPAD_RIGHT) || pad2.axis(Phaser.Gamepad.XBOX360_STICK_LEFT_X) > 0.1)
	    {
	        player2.x++
	    }
	    if (pad2.isDown(Phaser.Gamepad.XBOX360_DPAD_UP) || pad2.axis(Phaser.Gamepad.XBOX360_STICK_LEFT_Y) < -0.1)
	    {
	        player2.y--
	    }
	    if (pad2.isDown(Phaser.Gamepad.XBOX360_DPAD_DOWN) || pad2.axis(Phaser.Gamepad.XBOX360_STICK_LEFT_Y) > 0.1)
	    {
	        player2.y++
	    }
	
	
	    // isDown on game.input.gamepad checks ALL gamepad buttons
	    if (game.input.gamepad.isDown(Phaser.Gamepad.XBOX360_DPAD_LEFT))
	    {
	        melon.x--
	    }
	    if (game.input.gamepad.isDown(Phaser.Gamepad.XBOX360_DPAD_RIGHT))
	    {
	        melon.x++
	    }
	    if (game.input.gamepad.isDown(Phaser.Gamepad.XBOX360_DPAD_UP))
	    {
	        melon.y--
	    }
	    if (game.input.gamepad.isDown(Phaser.Gamepad.XBOX360_DPAD_DOWN))
	    {
	        melon.y++
	    }
	
	
	}
	
}