
package examples.groups

import Koala.initKoala
import Phaser.*

class GroupTransformRotate: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	lateinit var robot:Group
	
	override fun preload() {
	
	    game.load.image("eye", "assets/sprites/robot/eye.png")
	    game.load.image("body", "assets/sprites/robot/body.png")
	    game.load.image("arm-l", "assets/sprites/robot/arm-l.png")
	    game.load.image("arm-r", "assets/sprites/robot/arm-r.png")
	    game.load.image("leg-l", "assets/sprites/robot/leg-l.png")
	    game.load.image("leg-r", "assets/sprites/robot/leg-r.png")
	    
	}
	
	override fun create() {
	
	    // Use groups of sprites to create a big robot.
	    // Robot itself, you can subclass group class in a real game.
	    robot = game.add.group()
	
	    robot.x = 300.0
	    robot.y = 200.0
	
	    robot.pivot.x = 300.0
	    robot.pivot.y = 300.0
	
	    // Robot components.
	    robot.create(90, 175, "arm-l")
	    robot.create(549, 175, "arm-r")
	    robot.create(270, 325, "leg-l")
	    robot.create(410, 325, "leg-r")
	    robot.create(219, 32, "body")
	    robot.create(335, 173,"eye")
	
	}
	
	override fun update() {
	
	    robot.rotation += 0.02
	
	}
	
	override fun render() {
	    
	    game.debug.text("The robot is a group and every component is a sprite.", 240, 580)
	
	}
}