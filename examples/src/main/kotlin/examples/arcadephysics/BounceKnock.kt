
package examples.arcadephysics


import Phaser.*

class BounceKnock: State() {
	// mods by Patrick OReilly 
	// Twitter: @pato_reilly Web: http://patricko.byethost9.com
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("dude", "assets/sprites/phaser-dude.png")
	    game.load.image("ball", "assets/sprites/pangball.png")
	    
	}
	
	lateinit var image:Image
	lateinit var cursors:CursorKeys
	lateinit var ball:Sprite
	lateinit var knocker:Sprite
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    cursors = game.input.keyboard.createCursorKeys()
	    
	    //  This creates a simple sprite that is using our loaded image and
	    //  displays it on-screen
	    //  and assign it to a variable
	    ball = game.add.sprite(400, 200, "ball")
	
	    knocker = game.add.sprite(400, 200, "dude")
	
	    game.physics.enable(arrayOf<PIXI.Sprite>(knocker,ball), Phaser.Physics.ARCADE)
	
	    knocker.body.immovable = true
	
	    //  This gets it moving
	    ball.body.velocity.setTo(200, 200)
	
	    //  This makes the game world bounce-able
	    ball.body.collideWorldBounds = true
	
	    //  This sets the image bounce energy for the horizontal 
	    //  and vertical vectors (as an x,y point). "1" is 100% energy return
	    ball.body.bounce.setTo(1, 1)
	
	
	}
	
	//  Move the knocker with the arrow keys
	override fun update() {
	
	    //  Enable physics between the knocker and the ball
	    game.physics.arcade.collide(knocker, ball)
	
	    if (cursors.up.isDown)
	    {
	        knocker.body.velocity.y = -300
	    }
	    else if (cursors.down.isDown)
	    {
	        knocker.body.velocity.y =  300
	    }
	    else if (cursors.left.isDown)
	    {
	        knocker.body.velocity.x = -300
	    }
	    else if (cursors.right.isDown)
	    {
	        knocker.body.velocity.x = 300
	    } 
	    else
	    {
	        knocker.body.velocity.setTo(0, 0)
	    }
	    
	}
	
	override fun render() {
	
	    //debug helper
	    game.debug.spriteInfo(ball, 32, 32)
	
	}
}