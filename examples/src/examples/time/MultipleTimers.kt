
package examples.time


import Phaser.*

class MultipleTimers: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("picture1", "assets/pics/cougar_sanity_train.png")
	    game.load.image("picture2", "assets/pics/cougar-face_of_nature.png")
	    game.load.image("picture3", "assets/pics/destop-rewarding.png")
	    game.load.image("picture4", "assets/pics/unknown-the_starwars_pic.png")
	
	}
	
	lateinit var text:Text
	
	override fun create() {
	
	    var pic1 = game.add.sprite(0, 200, "picture1")
	    var pic2 = game.add.sprite(200, 200, "picture2")
	    var pic3 = game.add.sprite(400, 200, "picture3")
	    var pic4 = game.add.sprite(600, 200, "picture4")
	
	    var pics = mutableListOf( pic1, pic2, pic3, pic4 )
	    var i = 0
	
	    pics.forEach( {pic->
	
	        pic.scale.set(0.5)
	        pic.visible = false
	
	        game.time.events.add(1000 + (i * 500), this::showPicture, this, pic)
	        i++
	
	    })
	
	    // var style = TextStyle( font= "32px Arial", fill= "#52bace", align= "center" )
	    // text = game.add.text(game.world.centerX, 64, "Events: " + game.time.events.size, style)
	    // text.anchor.set(0.5)
	
	}
	
	override fun update() {
	
	    // text.text = "Events: " + game.time.events.size
	
	}
	
	fun showPicture(pic:Sprite) {
	
	    if (pic.y == 200.0)
	    {
	        pic.y = 400.0
	    }
	    else
	    {
	        pic.y = 200.0
	    }
	
	    // pic.x = game.rnd.between(0, game.width - pic.width)
	    // pic.y = game.rnd.between(0, game.height - pic.height)
	    pic.visible = true
	
	    game.time.events.add(2000, this::removePicture, this, pic)
	    // game.time.events.add(game.rnd.between(1000, 3000), removePicture, this, pic)
	
	}
	
	fun removePicture(pic:Sprite) {
	
	    // if (pic.y === 200)
	    // {
	    //     pic.y = 400
	    // }
	    // else
	    // {
	    //     pic.y = 200
	    // }
	
	    pic.visible = false
	
	    game.time.events.add(2000, this::showPicture, this, pic)
	    // game.time.events.add(game.rnd.between(1000, 3000), showPicture, this, pic)
	
	}
}