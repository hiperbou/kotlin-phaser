
package examples.demoscene


import Phaser.*

class UnlimitedBobs: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	var i:Int = 0
	lateinit var r:Phaser.Rectangle
	lateinit var bmd:BitmapData
	lateinit var bmdDest:BitmapData
	lateinit var floor:Image
	
	override fun preload() {
	
	    game.load.image("bob", "assets/demoscene/ball-tlb.png")
	    game.load.image("floor", "assets/demoscene/checker-floor.png")
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = "#000042"
	
	    floor = game.add.image(0, game.height, "floor")
	    floor.width = 800.0
	    floor.anchor.y = 1.0
	
	    bmd = game.make.bitmapData(game.width, game.height)
	
	    bmdDest = game.make.bitmapData(game.width, game.height)
	    bmdDest.addToWorld()
	
	    game.input.addMoveCallback(this::paint, this)
	
	    i = 0
	    r = Phaser.Rectangle(0, 0, game.width, game.height)
	
	    //  r = the rotation, s = the scale
	    // data = object{ var  r= 0;  var  s= 0.5 }
	
	    //  Change the tween duration, ease type, values, etc for different effects
	    // game.add.tween(data).to( object{ var  r= 360;  var  s= 2 }, 2000, Phaser.Easing.Sinusoidal::InOut, true, 0, Int.MAX_VALUE, true)
	
	}
	
	fun paint(pointer:Pointer, x:Double, y:Double) {
	
	    if (pointer.isDown)
	    {
	        bmd.draw("bob", x, y)
	    }
	
	}
	
	override fun update() {
	
	    bmd.fill(0, 0, 0, 0.05)
	
	    // bmdDest.draw(floor)
	
	   bmdDest.copy(bmd, 0, 0)
	
	}
}