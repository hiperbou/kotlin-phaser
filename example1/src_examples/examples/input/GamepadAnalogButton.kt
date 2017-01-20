
package examples.input


import Phaser.*

class GamepadAnalogButton: State() {
	// Try this demo on Chrome with an XBOX 360 controller.
	// Use left and right triggers.
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update=update })
	
	override fun preload() {
	
	    game.load.spritesheet("controller-indicator", "assets/misc/controller-indicator.png", 16,16)
	
	}
	
	lateinit var pad:Phaser.SinglePad
	lateinit var leftTriggerButton:DeviceButton
	lateinit var rightTriggerButton:DeviceButton
	lateinit var leftTriggerGfx:Graphics
	lateinit var rightTriggerGfx:Graphics
	
	lateinit var indicator:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#736357"
	
	    setupScene()
	
	    game.input.gamepad.start()
	
	    pad = game.input.gamepad.pad1
	
	    pad.addCallbacks(this, object{ var  onConnect = { addButtons() } })
	
	}
	
	fun addButtons() {
	
	    leftTriggerButton = pad.getButton(Phaser.Gamepad.XBOX360_LEFT_TRIGGER)
	
	    leftTriggerButton.onDown.add(this::onLeftTrigger)
	    leftTriggerButton.onUp.add(this::onLeftTrigger)
	    leftTriggerButton.onFloat.add(this::onLeftTrigger)
	
	    rightTriggerButton = pad.getButton(Phaser.Gamepad.XBOX360_RIGHT_TRIGGER)
	
	    rightTriggerButton.onDown.add(this::onRightTrigger)
	    rightTriggerButton.onUp.add(this::onRightTrigger)
	    rightTriggerButton.onFloat.add(this::onRightTrigger)
	
	}
	
	fun onLeftTrigger(button:DeviceButton, value:Double) {
	
	    leftTriggerGfx.clear()
	    leftTriggerGfx.beginFill(0xFF700B, 1)
	    leftTriggerGfx.lineStyle(2, 0xFFFFFF, 1)
	    leftTriggerGfx.drawRect(0, -value*500, 50, value*500 + 5)
	    leftTriggerGfx.endFill()
	}
	
	fun onRightTrigger(buttonCode:DeviceButton, value:Double) {
	
	    rightTriggerGfx.clear()
	    rightTriggerGfx.beginFill(0xFF700B, 1)
	    rightTriggerGfx.lineStyle(2, 0xFFFFFF, 1)
	    rightTriggerGfx.drawRect(0, -value*500, 50, value*500 + 5)
	    rightTriggerGfx.endFill()
	}
	
	override fun update() {
	
	    if (game.input.gamepad.supported && game.input.gamepad.active && game.input.gamepad.pad1.connected)
	    {
	        indicator.animations.frame = 0
	    }
	    else
	    {
	        indicator.animations.frame = 1
	    }
	
	}
	
	fun setupScene() {
	
	    indicator = game.add.sprite(10,10, "controller-indicator")
	    indicator.scale.x = 2.0
		indicator.scale.y = 2.0
	    indicator.animations.frame = 0
	
	    leftTriggerGfx = game.add.graphics(300,550)
	    leftTriggerGfx.beginFill(0xFF700B, 1)
	    leftTriggerGfx.lineStyle(2, 0xFFFFFF, 1)
	    leftTriggerGfx.drawRect(0, 0, 50, 5)
	    leftTriggerGfx.endFill()
	
	    rightTriggerGfx = game.add.graphics(450,550)
	    rightTriggerGfx.beginFill(0xFF700B, 1)
	    rightTriggerGfx.lineStyle(2, 0xFFFFFF, 1)
	    rightTriggerGfx.drawRect(0, 0, 50, 5)
	    rightTriggerGfx.endFill()
	
	}
}