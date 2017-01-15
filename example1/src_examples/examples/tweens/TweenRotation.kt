
package examples.tweens

import Koala.initKoala
import Phaser.*

class TweenRotation: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("arrow", "assets/sprites/longarrow-white.png")
	    game.load.image("lemming", "assets/sprites/lemming.png")
	
	}
	
	lateinit var arrow:Sprite
	lateinit var arrow2:Sprite
	lateinit var lemming:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#00aeef"
	
	    arrow2 = game.add.sprite(game.world.centerX, game.world.centerY, "arrow")
	    arrow2.anchor.set(0, 0.5)
	    arrow2.tint = 0x000044
	    arrow2.alpha = 0.5
	
	    arrow = game.add.sprite(game.world.centerX, game.world.centerY, "arrow")
	    arrow.anchor.set(0, 0.5)
	
	    lemming = game.add.sprite(game.world.randomX, game.world.randomY, "lemming")
	    lemming.anchor.set(0.5)
	
	    setNewLocation()
	
	    game.input.onDown.add(this::setNewLocation, this)
	
	}
	
	fun setNewLocation () {
	
	    arrow2.angle = arrow.angle
	
	    lemming.x = game.world.randomX
	    lemming.y = game.world.randomY
	
	    var angleTo = Phaser.Math.radToDeg(arrow.position.angle(lemming.position))
	
	    var shortestAngle = Phaser.Math.getShortestAngle(angleTo, arrow.angle)
	
	    var newAngle = arrow.angle - shortestAngle
	
	    var time = Math.abs(shortestAngle) * 10
	
	    game.add.tween(arrow).to(object{ var  angle= newAngle }, time, "Linear", true)
	
	}
}