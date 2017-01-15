
package examples.p2physics

import Koala.initKoala
import Phaser.*

class LoadPolygon1: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
		game.load.image("contra2", "assets/pics/contra2.png")
	
		//	Load our physics data exported from PhysicsEditor
		game.load.physics("physicsData", "assets/physics/sprites.json")
	
	}
	
	lateinit var contra:Sprite
	var start = false
	
	override fun create() {
	
		//	Enable p2 physics
		game.physics.startSystem(Phaser.Physics.P2JS)
	
		contra = game.add.sprite(400, 300, "contra2")
	
		//	Enable the physics body on this sprite and turn on the visual debugger
		game.physics.p2.enable(contra, true)
	
		//	Clear the shapes and load the "contra2" polygon from the physicsData JSON file in the cache
		contra.body.clearShapes()
		contra.body.loadPolygon("physicsData", "contra2")
	
		//	Just starts it rotating
		game.input.onDown.add({s->  start = true }, this)
	
	}
	
	override fun update() {
	
		if (start != null)
		{
			contra.body.rotateLeft(5)
		}
	
	}
	
	override fun render() {
	
	}
}