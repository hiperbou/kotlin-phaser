
package examples.input


import Phaser.*

class TouchEvents: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  render= render })
	
	override fun create() {
	
	    game.stage.backgroundColor = "#454645"
	
	    game.input.onUp.add({ pointer->
	      console.log("UP")
	    })
	
	    game.input.onDown.add({ pointer->
	      console.log("DOWN")
	    })
	
	    game.input.onTap.add({ pointer->
	      console.log("TAP")
	    })
	
	}
	
	override fun render() {
	
	    //  Just renders out the pointer data when you touch the canvas
	    game.debug.pointer(game.input.mousePointer)
	    game.debug.pointer(game.input.pointer1)
	    game.debug.pointer(game.input.pointer2)
	
	}
}