
package examples.arcadephysics

import Koala.initKoala
import Phaser.*

class Multiball: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("atari", "assets/sprites/atari130xe.png")
	    game.load.spritesheet("bullets", "assets/sprites/balls.png", 17, 17)
	
	}
	
	lateinit var atari:Sprite
	lateinit var balls:Group
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    balls = game.add.group()
	
	    balls.createMultiple(250, "bullets", 0, false)
	
	    atari = game.add.sprite(300, 450, "atari")
	
	    game.physics.arcade.gravity.y = 400.0
	
	    //  Enable physics on everything added to the world so far (the true parameter makes it recurse down into children)
	    game.physics.arcade.enable(game.world, true)
	
	    atari.body.allowGravity = 0
	    atari.body.immovable = true
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    game.time.events.loop(150, this::fire, this)
	
	    game.add.text(16, 16, "Left / Right to move", object{ var  font= "18px Arial";  var  fill= "#ffffff" })
	
	}
	
	fun fire() {
	
	    var ball = balls.getFirstExists<Sprite>(false)
	
	    if (ball != null)
	    {
	        ball.frame = game.rnd.integerInRange(0,6)
	        ball.exists = true
	        ball.reset(game.world.randomX, 0)
	
	        ball.body.bounce.y = 0.8
	    }
	
	}
	
	fun reflect(a:Sprite, ball:Sprite):Boolean {
	
	    if (ball.y > (atari.y + 5))
	    {
	        return true
	    }
	    else
	    {
	        ball.body.velocity.x = atari.body.velocity.x
	        ball.body.velocity.y *= -(ball.body.bounce.y)
	
	        return false
	    }
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(atari, balls, {a,b->}, this::reflect, this)
	
	    atari.body.velocity.x = 0
	
	    if (cursors.left.isDown)
	    {
	        atari.body.velocity.x = -200
	    }
	    else if (cursors.right.isDown)
	    {
	        atari.body.velocity.x = 200
	    }
	
	    balls.forEachAlive(this::checkBounds, this)
	
	}
	
	fun checkBounds(ball:Sprite) {
	
	    if (ball.y > 600)
	    {
	        ball.kill()
	    }
	
	}
	
	override fun render() {
	
	}
}