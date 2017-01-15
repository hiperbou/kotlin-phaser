
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class RotateToSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("arrow", "assets/sprites/longarrow.png")
	    game.load.image("ball", "assets/sprites/shinyball.png")
	
	}
	
	lateinit var arrow:Sprite
	lateinit var sprite1:Sprite
	lateinit var sprite2:Sprite
	lateinit var sprite3:Sprite
	lateinit var sprite4:Sprite
	lateinit var sprite5:Sprite
	lateinit var sprite6:Sprite
	
	lateinit var target:Sprite
	
	
	
	override fun create() {
	
	    game.stage.backgroundColor = "#363636"
	
	    arrow = game.add.sprite(400, 300, "arrow")
	    arrow.anchor.setTo(0.1, 0.5)
	
	    sprite1 = game.add.sprite(200, 200, "ball")
	    sprite1.anchor.set(0.5)
	
	    sprite2 = game.add.sprite(100, 500, "ball")
	    sprite2.anchor.set(0.5)
	
	    sprite3 = game.add.sprite(300, 100, "ball")
	    sprite3.anchor.set(0.5)
	
	    sprite4 = game.add.sprite(600, 400, "ball")
	    sprite4.anchor.set(0.5)
	
	    sprite5 = game.add.sprite(500, 200, "ball")
	    sprite5.anchor.set(0.5)
	
	    sprite6 = game.add.sprite(300, 450, "ball")
	    sprite6.anchor.set(0.5)
	
	    target = sprite6
	    target.tint = 0xff0000
	
	}
	
	override fun update() {
	
	    var a = game.physics.arcade.angleBetween(arrow, target)
	    var t = Phaser.Math.rotateToAngle(arrow.rotation, a, 0.01)
	
	    if (t === arrow.rotation)
	    {
	        target.tint = 0xffffff
	        target = game.rnd.pick(arrayOf(sprite1, sprite2, sprite3, sprite4, sprite5, sprite6))
	        target.tint = 0xff0000
	    }
	    else
	    {
	        arrow.rotation = t
	    }
	
	}
}