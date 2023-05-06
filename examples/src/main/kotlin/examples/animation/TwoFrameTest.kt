
package examples.animation


import Phaser.*

class TwoFrameTest: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", { preload: preload, create: create, update: update, render: render })
	
	override fun preload() {
	
	    game.load.spritesheet("player", "assets/sprites/spaceman.png", 16, 16)
	
	}
	
	lateinit var cursors:CursorKeys
	lateinit var player:Sprite
	lateinit var left:Animation
	lateinit var right:Animation
	
	override fun create() {
	
	    game.stage.backgroundColor = "#ff00ff"
	
	    player = game.add.sprite(48, 48, "player", 1)
	    player.smoothed = false
	    player.scale.set(4)
	
	    left = player.animations.add("left", arrayOf(8,9), 10, true)
	    right = player.animations.add("right", arrayOf(1,2), 10, true)
	    player.animations.add("up", arrayOf(11,12,13), 10, true)
	    player.animations.add("down", arrayOf(4,5,6), 10, true)
	
	    left.enableUpdate = true
	    right.enableUpdate = true
	
	    // left.onUpdate.add(fun(anim, f) { console.log("l", f) })
	    // right.onUpdate.add(fun(anim, f) { console.log("r", f) })
	
	    game.physics.enable(player, Phaser.Physics.ARCADE)
	
	    game.camera.follow(player)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    player.body.velocity.set(0)
	
	    if (cursors.left.isDown)
	    {
	        player.body.velocity.x = -100.0
	        player.play("left")
	    }
	    else if (cursors.right.isDown)
	    {
	        player.body.velocity.x = 100.0
	        player.play("right")
	    }
	    else if (cursors.up.isDown)
	    {
	        player.body.velocity.y = -100.0
	        player.play("up")
	    }
	    else if (cursors.down.isDown)
	    {
	        player.body.velocity.y = 100.0
	        player.play("down")
	    }
	    else
	    {
	        player.animations.stop()
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text(player.frame, 32, 32)
	
	    // game.debug.body(player)
	
	}
}