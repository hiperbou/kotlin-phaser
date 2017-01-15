
package examples.groups

import Koala.initKoala
import Phaser.*

class GroupTransformTween: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	lateinit var robot:Group
	lateinit var eye:Sprite
	lateinit var body:Sprite
	lateinit var leftArm:Sprite
	lateinit var rightArm:Sprite
	lateinit var leftLeg:Sprite
	lateinit var rightLeg:Sprite
	
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
	
	    // Robot components.
	    leftArm = robot.create(90, 175, "arm-l")
	    rightArm = robot.create(549, 175, "arm-r")
	    leftLeg = robot.create(270, 325, "leg-l")
	    rightLeg = robot.create(410, 325, "leg-r")
	    body = robot.create(219, 32, "body")
	    eye = robot.create(335, 173,"eye")
	
	    // Tween the robot"s size, so all the components also scaled.
	    game.add.tween(robot.scale).to( object{ var x= 1.2;  var  y= 1.2}, 1000, Phaser.Easing.Back::InOut, true, 0, 0).yoyo(true)
	
	}
	
	override fun render() {
	
	    game.debug.text("The robot is a group and every component is a sprite.", 32,32)
	
	}
}