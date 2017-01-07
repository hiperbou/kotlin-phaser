
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class AngleBetween: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("arrow", "assets/sprites/longarrow.png")
	    game.load.image("ball", "assets/sprites/pangball.png")
	
	}
	
	lateinit var arrow:Sprite
	lateinit var target:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#0072bc"
	
	    arrow = game.add.sprite(200, 250, "arrow")
	    arrow.anchor.setTo(0.1, 0.5)
	
	    target = game.add.sprite(600, 400, "ball")
	    target.anchor.setTo(0.5, 0.5)
	    target.inputEnabled = true
	    target.input.enableDrag(true)
	
	}
	
	override fun update() {
	
	    arrow.rotation = game.physics.arcade.angleBetween(arrow, target)
	
	}
	
	override fun render() {
	
	    game.debug.text("Drag the ball", 32, 32)
	    game.debug.spriteInfo(arrow, 32, 100)
	
	}
}