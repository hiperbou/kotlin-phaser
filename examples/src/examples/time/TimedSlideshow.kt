
package examples.time


import Phaser.*

class TimedSlideshow: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("picture1", "assets/pics/cougar_sanity_train.png")
	    game.load.image("picture2", "assets/pics/cougar-face_of_nature.png")
	    game.load.image("picture3", "assets/pics/destop-rewarding.png")
	    game.load.image("picture4", "assets/pics/destop-unknown.png")
	    game.load.image("picture5", "assets/pics/questar.png")
	    game.load.image("picture6", "assets/pics/seven_seas_andromeda_fairfax.png")
	    game.load.image("picture7", "assets/pics/slayer-sorry_im_the_beast.png")
	
	}
	
	lateinit var pictureA:Sprite
	lateinit var pictureB:Sprite
	lateinit var timer:Timer
	var current = 3
	
	override fun create() {
	
	    game.stage.backgroundColor = "#000"
	
	    pictureA = game.add.sprite(game.world.centerX, game.world.centerY, "picture1")
	    pictureA.anchor.setTo(0.5, 0.5)
	    pictureA.scale.setTo(2, 2)
	
	    pictureB = game.add.sprite(game.world.centerX, game.world.centerY, "picture2")
	    pictureB.anchor.setTo(0.5, 0.5)
	    pictureB.scale.setTo(2, 2)
	    pictureB.alpha = 0.0
	
	    //  Create our Timer
	    timer = game.time.create(false)
	
	    //  Set a TimerEvent to occur after 3 seconds
	    timer.add(3000, this::fadePictures, this)
	
	    //  Start the timer running - this is important!
	    //  It won"t start automatically, allowing you to hook it to button events and the like.
	    timer.start()
	
	}
	
	fun fadePictures() {
	
	    //  Cross-fade the two pictures
	    var tween:Tween
	
	    if (pictureA.alpha == 1.0)
	    {
	        tween = game.add.tween(pictureA).to( object{ var  alpha= 0 }, 2000, Phaser.Easing.Linear::None, true)
	        game.add.tween(pictureB).to( object{ var  alpha= 1 }, 2000, Phaser.Easing.Linear::None, true)
	    }
	    else
	    {
	        game.add.tween(pictureA).to( object{ var  alpha= 1 }, 2000, Phaser.Easing.Linear::None, true)
	        tween = game.add.tween(pictureB).to( object{ var  alpha= 0 }, 2000, Phaser.Easing.Linear::None, true)
	    }
	
	    //  When the cross-fade is complete we swap the image being shown by the now hidden picture
	    tween.onComplete.add(this::changePicture, this)
	
	}
	
	fun changePicture() {
	
	    if (pictureA.alpha == 0.0)
	    {
	        pictureA.loadTexture("picture" + current)
	    }
	    else
	    {
	        pictureB.loadTexture("picture" + current)
	    }
	
	    current++
	
	    if (current > 7)
	    {
	        current = 1
	    }
	
	    //  And set a TimerEvent to occur after 3 seconds
	    timer.add(3000, this::fadePictures, this)
	
	}
	
	override fun render() {
	
	    game.debug.text("Time until event: " + timer.duration, 10, 20)
	
	}
}