
package examples.tweens


import Phaser.*

class TweenReuse: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("beball", "assets/sprites/beball1.png")
	    game.load.image("bikkuriman", "assets/sprites/bikkuriman.png")
	    game.load.image("darkwing_crazy", "assets/sprites/darkwing_crazy.png")
	
	}
	
	lateinit var sprites:Group
	lateinit var tween:Tween
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2384e7"
	
	    sprites = game.add.group()
	
	    sprites.create(100, 100, "beball")
	    sprites.create(200, 100, "bikkuriman")
	    sprites.create(300, 100, "darkwing_crazy")
	    sprites.create(400, 100, "beball")
	    sprites.create(500, 100, "bikkuriman")
	    sprites.create(600, 100, "darkwing_crazy")
	
	    //  We will use the same reference over each time, rather than creating ones
	    tween = game.add.tween(sprites.cursor).to( object{ var  y= 500 }, 2000, Phaser.Easing.Bounce::Out, true)
	    tween.onComplete.add(this::tween2, this)
	
	}
	
	fun tween2() {
	
	    sprites.next()
	
	    //  The second tween alphs to nothing
	    tween = game.add.tween(sprites.cursor).to( object{ var  alpha= 0 }, 2000, Phaser.Easing.Bounce::Out, true)
	    tween.onComplete.add(this::tween3, this)
	
	}
	
	fun tween3() {
	
	    sprites.next()
	
	    //  The third tween scales up
	    tween = game.add.tween(sprites.cursor.scale).to( object{ var  x= 2;  var  y= 2 }, 2000, Phaser.Easing.Bounce::Out, true)
	    tween.onComplete.add(this::tween4, this)
	
	}
	
	fun tween4() {
	
	    sprites.next()
	
	    //  The fourth tween does y pos + alpha
	    tween = game.add.tween(sprites.cursor).to( object{ var  y= 500;  var  alpha= 0.2 }, 2000, Phaser.Easing.Bounce::Out, true)
	    tween.onComplete.add(this::tween5, this)
	
	}
	
	fun tween5() {
	
	    sprites.next()
	
	    //  The fifth tween moves left
	    tween = game.add.tween(sprites.cursor).to( object{ var  x= 100 }, 2000, Phaser.Easing.Bounce::Out, true)
	    tween.onComplete.add(this::tween6, this)
	
	}
	
	fun tween6() {
	
	    sprites.next()
	
	    //  The sixth tween moves left
	    tween = game.add.tween(sprites.cursor).to( object{ var  x= 300;  var  y= 400 }, 2000, Phaser.Easing.Bounce::Out, true)
	
	}
	
}