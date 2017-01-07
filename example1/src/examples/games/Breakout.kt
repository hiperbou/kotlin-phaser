
package examples.games

import Koala.initKoala
import Phaser.*


class Breakout: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.atlas("breakout", "assets/games/breakout/breakout.png", "assets/games/breakout/breakout.json")
	    game.load.image("starfield", "assets/misc/starfield.jpg")
	
	}
	
	lateinit var ball:Sprite
	lateinit var paddle:Sprite
	lateinit var bricks:Group
	
	var ballOnPaddle = true
	
	var lives = 3
	var score = 0
	
	lateinit var scoreText:Text
	lateinit var livesText:Text
	lateinit var introText:Text
	
	lateinit var s:TileSprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    //  We check bounds collisions against all walls other than the bottom one
	    game.physics.arcade.checkCollision.down = false
	
	    s = game.add.tileSprite(0, 0, 800, 600, "starfield")
	
	    bricks = game.add.group()
	    bricks.enableBody = true
	    bricks.physicsBodyType = Phaser.Physics.ARCADE
	
	    var brick:Sprite
	
	    for(y in 0..4-1)
	    {
	        for(x in 0..15-1)
	        {
	            brick = bricks.create(120 + (x * 36), 100 + (y * 52), "breakout", "brick_" + (y+1) + "_1.png")
	            brick.body.bounce.set(1)
	            brick.body.immovable = true
	        }
	    }
	
	    paddle = game.add.sprite(game.world.centerX, 500, "breakout", "paddle_big.png")
	    paddle.anchor.setTo(0.5, 0.5)
	
	    game.physics.enable(paddle, Phaser.Physics.ARCADE)
	
	    paddle.body.collideWorldBounds = true
	    paddle.body.bounce.set(1)
	    paddle.body.immovable = true
	
	    ball = game.add.sprite(game.world.centerX, paddle.y - 16, "breakout", "ball_1.png")
	    ball.anchor.set(0.5)
	    ball.checkWorldBounds = true
	
	    game.physics.enable(ball, Phaser.Physics.ARCADE)
	
	    ball.body.collideWorldBounds = true
	    ball.body.bounce.set(1)
	
	    ball.animations.add("spin", arrayOf( "ball_1.png", "ball_2.png", "ball_3.png", "ball_4.png", "ball_5.png" ), 50, true, false)
	
	    ball.events.onOutOfBounds.add(this::ballLost, this)
	
	    scoreText = game.add.text(32, 550, "score: 0", object{ var  font= "20px Arial";  var  fill= "#ffffff";  var  align= "left" })
	    livesText = game.add.text(680, 550, "lives: 3", object{ var  font= "20px Arial";  var  fill= "#ffffff";  var  align= "left" })
	    introText = game.add.text(game.world.centerX, 400, "- click to start -", object{ var  font= "40px Arial";  var  fill= "#ffffff";  var  align= "center" })
	    introText.anchor.setTo(0.5, 0.5)
	
	    game.input.onDown.add(this::releaseBall, this)
	
	}
	
	override fun update() {
	
	    //  Fun, but a little sea-sick inducing :) Uncomment if you like!
	    // s.tilePosition.x += (game.input.speed.x / 2)
	
	    paddle.x = game.input.x
	
	    if (paddle.x < 24)
	    {
	        paddle.x = 24.0
	    }
	    else if (paddle.x > game.width - 24)
	    {
	        paddle.x = game.width - 24
	    }
	
	    if (ballOnPaddle)
	    {
	        ball.body.x = paddle.x
	    }
	    else
	    {
	        game.physics.arcade.collide(ball, paddle, this::ballHitPaddle, null, this)
	        game.physics.arcade.collide(ball, bricks, this::ballHitBrick, null, this)
	    }
	
	}
	
	fun releaseBall () {
	
	    if (ballOnPaddle)
	    {
	        ballOnPaddle = false
	        ball.body.velocity.y = -300.0
	        ball.body.velocity.x = -75.0
	        ball.animations.play("spin")
	        introText.visible = false
	    }
	
	}
	
	fun ballLost () {
	
	    lives--
	    livesText.text = "lives: " + lives
	
	    if (lives === 0)
	    {
	        gameOver()
	    }
	    else
	    {
	        ballOnPaddle = true
	
	        ball.reset(paddle.body.x + 16, paddle.y - 16)
	        
	        ball.animations.stop()
	    }
	
	}
	
	fun gameOver () {
	
	    ball.body.velocity.setTo(0, 0)
	    
	    introText.text = "Game Over!"
	    introText.visible = true
	
	}
	
	fun ballHitBrick (_ball:Sprite, _brick:Sprite) {
	
	    _brick.kill()
	
	    score += 10
	
	    scoreText.text = "score: " + score
	
	    //  Are they any bricks left?
	    if (bricks.countLiving() == 0)
	    {
	        //  New level starts
	        score += 1000
	        scoreText.text = "score: " + score
	        introText.text = "- Next Level -"
	
	        //  Let"s move the ball back to the paddle
	        ballOnPaddle = true
	        ball.body.velocity.set(0)
	        ball.x = paddle.x + 16
	        ball.y = paddle.y - 16
	        ball.animations.stop()
	
	        //  And bring the bricks back from the dead :)
	        bricks.callAll("revive")
	    }
	
	}
	
	fun ballHitPaddle (_ball:Sprite, _paddle:Sprite) {
	
	    var diff = 0.0
	
	    if (_ball.x < _paddle.x)
	    {
	        //  Ball is on the left-hand side of the paddle
	        diff = _paddle.x - _ball.x
	        _ball.body.velocity.x = (-10 * diff)
	    }
	    else if (_ball.x > _paddle.x)
	    {
	        //  Ball is on the right-hand side of the paddle
	        diff = _ball.x -_paddle.x
	        _ball.body.velocity.x = (10 * diff)
	    }
	    else
	    {
	        //  Ball is perfectly in the middle
	        //  Add a little random X to stop it bouncing straight up!
	        _ball.body.velocity.x = 2 + Math.random() * 8
	    }
	
	}
}