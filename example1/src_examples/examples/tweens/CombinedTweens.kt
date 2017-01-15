
package examples.tweens

import Koala.initKoala
import Phaser.*

class CombinedTweens: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var preload=preload;  var create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("pig", "assets/sprites/invaderpig.png", 124, 104)
	    game.load.image("starfield", "assets/misc/starfield.jpg")
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	    
	}
	
	lateinit var mushroom:Sprite
	lateinit var pig:Sprite
	lateinit var pigArrives:Tween
	lateinit var s:Tween
	
	override fun create() {
	
	    game.add.tileSprite(0, 0, 800, 600, "starfield")
	
	    pig = game.add.sprite(-50, 200, "pig", 1)
	
	    pig.scale.setTo(0.5, 0.5)
	
	    mushroom = game.add.sprite(380, 200, "mushroom")
	    mushroom.anchor.setTo(0.5, 0.5)
	
	    pigArrives = game.add.tween(pig)
	    
	    pigArrives.to(object{ var x=150}, 1000, Phaser.Easing.Bounce::Out)
	    pigArrives.onComplete.add(this::firstTween, this)
	    pigArrives.start()
	
	}
	
	fun firstTween() {
	
	    s = game.add.tween(mushroom.scale)
	    s.to(object{ var x= 2;  var  y=2}, 1000, Phaser.Easing.Linear::None)
	    s.onComplete.add(this::theEnd, this)
	    s.start()
	
	}
	
	fun theEnd() {
	    
	    val e = game.add.tween(pig)
	    
	    e.to(object{ var  x= -150 }, 1000, Phaser.Easing.Bounce::Out)
	    e.start()
	
	}
}