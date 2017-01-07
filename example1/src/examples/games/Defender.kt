
package examples.games

import Koala.initKoala
import Phaser.*

class Defender: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("player", "assets/games/defender/ship.png")
	    game.load.image("star", "assets/demoscene/star2.png")
	    game.load.image("baddie", "assets/sprites/space-baddie.png")
	    game.load.atlas("lazer", "assets/games/defender/laser.png", "assets/games/defender/laser.json")
	
	}
	
	lateinit var stars:Group
	lateinit var baddies:Group
	lateinit var lazers:Group
	lateinit var player:Sprite
	lateinit var cursors:CursorKeys
	lateinit var fireButton:Key
	var bulletTime = 0.0
	var frameTime = 0.0
	lateinit var frames:MutableList<String>
	var prevCamX = 0.0
	
	override fun create() {
	
	    game.world.setBounds(0, 0, 800*4, 600)
	
	    frames = Phaser.Animation.generateFrameNames("frame", 2, 30, "", 2).toMutableList()
	    frames.add(0, "frame02")
	
	    stars = game.add.group()
	
	    for(i in 0..128-1)
	    {
	        stars.create(game.world.randomX, game.world.randomY, "star")
	    }
	
	    baddies = game.add.group()
	
	    for(i in 0..16-1)
	    {
	        baddies.create(game.world.randomX, game.world.randomY, "baddie")
	    }
	
	    lazers = game.add.group()
	
	    player = game.add.sprite(100, 300, "player")
	    player.anchor.x = 0.5
	
	    game.camera.follow(player, Phaser.Camera.FOLLOW_LOCKON, 0.1)
	
	    cursors = game.input.keyboard.createCursorKeys()
	    fireButton = game.input.keyboard.addKey(Phaser.Keyboard.SPACEBAR)
	
	    prevCamX = game.camera.x
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	        player.x -= 8
	        player.scale.x = -1.0
	    }
	    else if (cursors.right.isDown)
	    {
	        player.x += 8
	        player.scale.x = 1.0
	    }
	
	    if (cursors.up.isDown)
	    {
	        player.y -= 8
	    }
	    else if (cursors.down.isDown)
	    {
	        player.y += 8
	    }
	
	    if (fireButton.isDown)
	    {
	        fireBullet()
	    }
	
	    lazers.forEachAlive(this::updateBullets, this)
	
	    prevCamX = game.camera.x
	
	}
	
	fun updateBullets(lazer:Sprite) {
	
	    // if (game.time.now > frameTime)
	    // {
	    //     frameTime = game.time.now + 500
	    // }
	    // else
	    // {
	    //     return
	    // }
	
	    //  Adjust for camera scrolling
	    var camDelta = game.camera.x - prevCamX
	    lazer.x += camDelta
	
	    if (lazer.animations.frameName !== "frame30")
	    {
	        lazer.animations.next()
	    }
	    else
	    {
	        if (lazer.scale.x == 1.0)
	        {
	            lazer.x += 16
	
	            if (lazer.x > (game.camera.view.right - 224))
	            {
	                lazer.kill()
	            }
	        }
	        else
	        {
	            lazer.x -= 16
	
	            if (lazer.x < (game.camera.view.left - 224))
	            {
	                lazer.kill()
	            }
	        }
	    }
	
	}
	
	fun fireBullet () {
	
	    if (game.time.now > bulletTime)
	    {
	        //  Grab the first bullet we can from the pool
	        val lazer:Sprite = lazers.getFirstDead(true, player.x + 24 * player.scale.x, player.y + 8, "lazer")
	
	        lazer.animations.add("fire", frames.toTypedArray(), 60)
	        lazer.animations.frameName = "frame02"
	
	        lazer.scale.x = player.scale.x
	
	        if (lazer.scale.x == 1.0)
	        {
	            // lazer.anchor.x = 1
	        }
	        else
	        {
	            // lazer.anchor.x = 0
	        }
	
	        //  Lazers start out with a width of 96 and expand over time
	        // lazer.crop(Phaser.Rectangle(244-96, 0, 96, 2), true)
	
	        bulletTime = game.time.now + 250
	    }
	
	}
}