
package examples.input

import Koala.initKoala
import Phaser.*

class GamepadButtons: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.atlas("xbox360", "assets/controllers/xbox360.png", "assets/controllers/xbox360.json")
	
	}
	
	lateinit var pad:Phaser.SinglePad
	
	lateinit var buttonA:DeviceButton
	lateinit var buttonB:DeviceButton
	lateinit var buttonX:DeviceButton
	lateinit var buttonY:DeviceButton
	lateinit var buttonDPadLeft:DeviceButton
	lateinit var buttonDPadRight:DeviceButton
	lateinit var buttonDPadUp:DeviceButton
	lateinit var buttonDPadDown:DeviceButton
	
	lateinit var imageA:Image
	lateinit var imageB:Image
	lateinit var imageX:Image
	lateinit var imageY:Image
	lateinit var imageDPad:Image
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    //  Add some images
	    imageA = game.add.image(500, 300, "xbox360", "360_A")
	    imageB = game.add.image(600, 200, "xbox360", "360_B")
	    imageX = game.add.image(400, 200, "xbox360", "360_X")
	    imageY = game.add.image(500, 100, "xbox360", "360_Y")
	    imageDPad = game.add.image(100, 200, "xbox360", "360_Dpad")
	
	    game.input.gamepad.start()
	
	    pad = game.input.gamepad.pad1
	
	    pad.addCallbacks(this, object{ var  onConnect = { addButtons() } })
	
	}
	
	fun addButtons() {
	
	    //  We can"t do this until we know that the gamepad has been connected and is started
	
	    buttonA = pad.getButton(Phaser.Gamepad.XBOX360_A)
	    buttonB = pad.getButton(Phaser.Gamepad.XBOX360_B)
	    buttonX = pad.getButton(Phaser.Gamepad.XBOX360_X)
	    buttonY = pad.getButton(Phaser.Gamepad.XBOX360_Y)
	
	    buttonA.onDown.add(this::onDown, this)
	    buttonB.onDown.add(this::onDown, this)
	    buttonX.onDown.add(this::onDown, this)
	    buttonY.onDown.add(this::onDown, this)
	
	    buttonA.onUp.add(this::onUp, this)
	    buttonB.onUp.add(this::onUp, this)
	    buttonX.onUp.add(this::onUp, this)
	    buttonY.onUp.add(this::onUp, this)
	
	    //  These won"t work in Firefox, sorry! It uses totally different button mappings
	
	    buttonDPadLeft = pad.getButton(Phaser.Gamepad.XBOX360_DPAD_LEFT)
	    buttonDPadRight = pad.getButton(Phaser.Gamepad.XBOX360_DPAD_RIGHT)
	    buttonDPadUp = pad.getButton(Phaser.Gamepad.XBOX360_DPAD_UP)
	    buttonDPadDown = pad.getButton(Phaser.Gamepad.XBOX360_DPAD_DOWN)
	
	    buttonDPadLeft.onDown.add(this::onDown, this)
	    buttonDPadRight.onDown.add(this::onDown, this)
	    buttonDPadUp.onDown.add(this::onDown, this)
	    buttonDPadDown.onDown.add(this::onDown, this)
	
	    buttonDPadLeft.onUp.add(this::onUp, this)
	    buttonDPadRight.onUp.add(this::onUp, this)
	    buttonDPadUp.onUp.add(this::onUp, this)
	    buttonDPadDown.onUp.add(this::onUp, this)
	
	}
	
	fun onDown(button:DeviceButton, value:Double) {
	
	    if (button.buttonCode === Phaser.Gamepad.XBOX360_A)
	    {
	        imageA.alpha = 0.5
	    }
	    else if (button.buttonCode === Phaser.Gamepad.XBOX360_B)
	    {
	        imageB.alpha = 0.5
	    }
	    else if (button.buttonCode === Phaser.Gamepad.XBOX360_X)
	    {
	        imageX.alpha = 0.5
	    }
	    else if (button.buttonCode === Phaser.Gamepad.XBOX360_Y)
	    {
	        imageY.alpha = 0.5
	    }
	    else if (button.buttonCode === Phaser.Gamepad.XBOX360_DPAD_LEFT)
	    {
	        imageDPad.frameName = "360_Dpad_Left"
	    }
	    else if (button.buttonCode === Phaser.Gamepad.XBOX360_DPAD_RIGHT)
	    {
	        imageDPad.frameName = "360_Dpad_Right"
	    }
	    else if (button.buttonCode === Phaser.Gamepad.XBOX360_DPAD_UP)
	    {
	        imageDPad.frameName = "360_Dpad_Up"
	    }
	    else if (button.buttonCode === Phaser.Gamepad.XBOX360_DPAD_DOWN)
	    {
	        imageDPad.frameName = "360_Dpad_Down"
	    }
	
	}
	
	fun onUp(button:DeviceButton, value:Double) {
	
	    if (button.buttonCode === Phaser.Gamepad.XBOX360_A)
	    {
	        imageA.alpha = 1.0
	    }
	    else if (button.buttonCode === Phaser.Gamepad.XBOX360_B)
	    {
	        imageB.alpha = 1.0
	    }
	    else if (button.buttonCode === Phaser.Gamepad.XBOX360_X)
	    {
	        imageX.alpha = 1.0
	    }
	    else if (button.buttonCode === Phaser.Gamepad.XBOX360_Y)
	    {
	        imageY.alpha = 1.0
	    }
	    else
	    {
	        imageDPad.frameName = "360_Dpad"
	    }
	
	}
}