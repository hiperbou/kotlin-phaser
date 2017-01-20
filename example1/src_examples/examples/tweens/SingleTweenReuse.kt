
package examples.tweens


import Phaser.*

class SingleTweenReuse: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("bikkuriman", "assets/sprites/bikkuriman.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var tween:Tween
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2384e7"
	
	    sprite = game.add.sprite(400, 100, "bikkuriman")
	
	    tween = game.add.tween(sprite).to( object{ var  y= 500 }, 2000, Phaser.Easing.Bounce::Out, true)
	    tween.onComplete.addOnce(this::tween2, this)
	
	    //  Notice the use of addOnce above. If you don"t use that then you *must* do:
	    // tween.onComplete.removeAll()
	    //  before using the tween again, or it will fire both onComplete callbacks.
	
	}
	
	fun tween2() {
	
	    tween.to( object{ var  alpha= 0.5 }, 2000, Phaser.Easing.Bounce::Out, true)
	    tween.onComplete.addOnce(this::tween3, this)
	
	}
	
	fun tween3() {
	
	    tween.to( object{ var  x= 2;  var  y= 2 }, 2000, Phaser.Easing.Bounce::Out, true)
	    tween.onComplete.addOnce(this::tween4, this)
	
	}
	
	fun tween4() {
	
	    tween.to( object{ var  y= 500;  var  alpha= 1 }, 2000, Phaser.Easing.Bounce::Out, true)
	    tween.onComplete.addOnce(this::tween5, this)
	
	}
	
	fun tween5() {
	
	    tween.to( object{ var  x= 400;  var  y= 100;  var  alpha= 1 }, 2000, Phaser.Easing.Bounce::Out, true)
	    tween.onComplete.addOnce(this::tween2, this)
	
	}
}