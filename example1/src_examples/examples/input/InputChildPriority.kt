
package examples.input

import Koala.initKoala
import Phaser.*

class InputChildPriority: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("background", "assets/pics/bubble-on.png")
	    game.load.image("close", "assets/sprites/orb-red.png")
	
	}
	
	lateinit var popup:Sprite
	var tween:Tween? = null
	
	override fun create() {
	
	    game.stage.backgroundColor = "#4b0049"
	
	    //  You can drag the pop-up window around
	    popup = game.add.sprite(game.world.centerX, game.world.centerY, "background")
	    popup.anchor.set(0.5)
	    popup.inputEnabled = true
	    popup.input.enableDrag()
	
	    //  Position the close button to the top-right of the popup sprite (minus 8px for spacing)
	    var pw = (popup.width / 2) - 30
	    var ph = (popup.height / 2) - 8
	
	    //  And click the close button to close it down again
	    var closeButton = game.make.sprite(pw, -ph, "close")
	    closeButton.inputEnabled = true
	    closeButton.input.priorityID = 1
	    closeButton.events.onInputDown.add(this::closeWindow, this)
	
	    //  Add the "close button" to the popup window image
	    popup.addChild(closeButton)
	
	    //  Hide it awaiting a click
	    popup.scale.set(0)
	
	    //  Pop the window open
	    game.input.onDown.add(this::openWindow, this)
	
	}
	
	fun openWindow() {
	
	    if ((tween!=null && tween!!.isRunning) || popup.scale.x.toInt() == 1)
	    {
	        return
	    }
	    
	    //  Create a tween that will pop-open the window, but only if it"s not already tweening or open
	    tween = game.add.tween(popup.scale).to( object{ var  x= 1;  var  y= 1 }, 1000, Phaser.Easing.Elastic::Out, true)
	
	}
	
	fun closeWindow() {
	
	    if (tween!=null && tween!!.isRunning || popup.scale.x.toInt() == 0)
	    {
	        return
	    }
	
	    //  Create a tween that will close the window, but only if it"s not already tweening or closed
	    tween = game.add.tween(popup.scale).to( object{ var  x= 0;  var  y= 0 }, 500, Phaser.Easing.Elastic::In, true)
	
	}
	
	override fun render() {
	
	    game.debug.text("Click to open window + drag + close", 32, 32)
	
	}
}