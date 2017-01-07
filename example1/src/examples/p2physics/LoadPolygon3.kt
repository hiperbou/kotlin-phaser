
package examples.p2physics

import Koala.initKoala
import Phaser.*

class LoadPolygon3: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
		game.load.image("contra2", "assets/pics/contra2.png")
	
	}
	
	lateinit var contra:Sprite
	
	override fun create() {
	
		//	Enable p2 physics
		game.physics.startSystem(Phaser.Physics.P2JS)
	
		contra = game.add.sprite(game.world.centerX, game.world.centerY - 200, "contra2")
	
		//	Enable the physics body on this sprite and turn on the visual debugger
		game.physics.p2.enable(contra, true)
	
		contra.body.clearShapes()
	
		//	You can specify the addition of a polygon to a body in 3 different ways:
	
		contra.body.addPolygon( {  } ,    10, 191  ,  26, 158  ,  25, 186  ,  13, 204  )
		// contra.body.addPolygon( object{ var } , arrayOf(   10, 191  ,  26, 158  ,  25, 186  ,  13, 204  ))
		// contra.body.addPolygon( object{ var } , [   arrayOf(10, 191)  ,  arrayOf(26, 158)  ,  arrayOf(25, 186)  ,  arrayOf(13, 204)  ])
	
	}
}