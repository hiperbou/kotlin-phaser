
package examples.arcadephysics


import Phaser.*

class Snake: State() {
	// Snake by Patrick OReilly and Richard Davey
	// Twitter: @pato_reilly Web: http://patricko.byethost9.com
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var render = render })
	
	override fun preload() {
	
	    game.load.image("ball","assets/sprites/shinyball.png")
	
	}
	
	lateinit var cursors:CursorKeys
	lateinit var snakeHead:Sprite //head of snake sprite
	var snakeSection = mutableListOf<Sprite>() //array of sprites that make the snake body sections
	var snakePath = mutableListOf<Point>() //arrary of positions(points) that have to be stored for the path the sections follow
	var numSnakeSections = 30 //number of snake body sections
	var snakeSpacer = 6 //parameter that sets the spacing between sections
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.world.setBounds(0, 0, 800, 600)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    snakeHead = game.add.sprite(400, 300, "ball")
	    snakeHead.anchor.setTo(0.5, 0.5)
	
	    game.physics.enable(arrayOf(snakeHead), Phaser.Physics.ARCADE)
	    
	    //  Init snakeSection array
		//for (var i = 1; i <= numSnakeSections-1; i++)
	    for(i in 1..numSnakeSections-1)
	    {
	        snakeSection.add(game.add.sprite(400, 300, "ball"))
	        snakeSection[i-1].anchor.setTo(0.5, 0.5)
	    }
	    
	    //  Init snakePath array
	    //for (var i = 0; i <= numSnakeSections * snakeSpacer; i++)
		for(i in 0..numSnakeSections * snakeSpacer)
	    {
	        snakePath.add(Phaser.Point(400, 300))
	    }
	
	}
	
	override fun update() {
	
	    snakeHead.body.velocity.setTo(0, 0)
	    snakeHead.body.angularVelocity = 0
	
	    if (cursors.up.isDown)
	    {
	        snakeHead.body.velocity.copyFrom(game.physics.arcade.velocityFromAngle(snakeHead.angle, 300))
	
	        // Everytime the snake head moves, insert the location at the start of the array, 
	        // and knock the last position off the end
	
	        var part = snakePath.removeAt(snakePath.lastIndex)

	        part.setTo(snakeHead.x, snakeHead.y)
	
	        snakePath.add(0, part)

			//for (var i = 1; i <= numSnakeSections - 1; i++)
	        for(i in 1..numSnakeSections - 1)
	        {
	            snakeSection[i-1].x = (snakePath[i * snakeSpacer]).x
	            snakeSection[i-1].y = (snakePath[i * snakeSpacer]).y
	        }
	    }
	
	    if (cursors.left.isDown)
	    {
	        snakeHead.body.angularVelocity = -300
	    }
	    else if (cursors.right.isDown)
	    {
	        snakeHead.body.angularVelocity = 300
	    }
	
	}
	
	override fun render() {
	
	    game.debug.spriteInfo(snakeHead, 32, 32)
	
	}
}