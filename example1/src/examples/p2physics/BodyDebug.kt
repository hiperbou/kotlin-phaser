
package examples.p2physics

import Koala.initKoala
import Phaser.*

class BodyDebug: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
		game.load.image("contra2", "assets/pics/contra2.png")
		game.load.image("bunny", "assets/sprites/bunny.png")
		game.load.image("block", "assets/sprites/block.png")
		game.load.image("wizball", "assets/sprites/wizball.png")
	
		game.load.physics("physicsData", "assets/physics/sprites.json")
	
	}
	
	lateinit var contra:Sprite
	lateinit var bunny:Sprite
	lateinit var block:Sprite
	lateinit var wizball:Sprite
	
	var result = "Click a body"
	
	override fun create() {
	
		//	Enable p2 physics
		game.physics.startSystem(Phaser.Physics.P2JS)
	
		contra = game.add.sprite(100, 200, "contra2")
		bunny = game.add.sprite(550, 200, "bunny")
		block = game.add.sprite(300, 400, "block")
		wizball = game.add.sprite(500, 500, "wizball")
	
		game.physics.p2.enable(arrayOf( contra, bunny ), true)
		game.physics.p2.enable(arrayOf( block, wizball ), true)
	
		//	Convex polys
		contra.body.clearShapes()
		contra.body.loadPolygon("physicsData", "contra2")
	
		bunny.body.clearShapes()
		bunny.body.loadPolygon("physicsData", "bunny")
	
		//	Circle
		wizball.body.setCircle(45)
	
		game.input.onDown.add(this::click, this)
	
		console.log(contra.body.debug)
		console.log(block.body.debug)
	
	}
	
	fun click(pointer:Pointer) {
	
		//	You can hitTest against an array of Sprites, an array of Phaser.Physics.P2.Body objects, or don"t give anything
		//	in which case it will check every Body in the whole world.
	
		var bodies = game.physics.p2.hitTest(pointer.position, arrayOf( contra, bunny, block, wizball ))
	
		if (bodies.size === 0)
		{
			result = "You didn't click a Body"
		}
		else
		{
			result = "You clicked: "
	
			for(i in 0..bodies.size-1)
			{
				//	The bodies that come back are p2.Body objects.
				//	The parent property is a Phaser.Physics.P2.Body which has a property called "sprite"
				//	This relates to the sprites we created earlier.
				//	The "key" property is just the texture name, which works well for this demo but you probably need something more robust for an actual game.
				result = result + bodies[i].parent.sprite.key
	
				if (i < bodies.size - 1)
				{
					result = result + ", "
				}
			}
	
		}
	
	}
	
	override fun update() {
	
		bunny.body.rotateLeft(2)
	
	}
	
	override fun render() {
	
		game.debug.text(result, 32, 32)
	
	}
}