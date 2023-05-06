
package examples.arcadephysics


import Phaser.*

class LauncherFollowWorld: State() {
	// mods by Patrick OReilly
	// twitter: @pato_reilly
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("background","assets/misc/starfield.jpg")
	    game.load.image("player","assets/sprites/phaser-dude.png")
	    game.load.image("analog", "assets/tests/fusia.png")
	    game.load.image("arrow", "assets/sprites/longarrow2.png")
	}
	
	lateinit var myTween:Tween
	lateinit var player:Sprite
	lateinit var arrow:Sprite
	lateinit var analog:Sprite
	var catchFlag = false
	var launchVelocity = 0.0
	var launched = false
	
	override fun create() {
	    
	    game.world.setBounds(0, 0, 5000, 600)
	    game.add.tileSprite(0, 0, 5000, 600, "background")
	    
	    var graphics = game.add.graphics(0,0)
	    graphics.beginFill(0x049e0c)
	    graphics.drawRect(395, 400, 10, 250)
	    
	    analog = game.add.sprite(400, 400, "analog")
	    analog.width = 8.0
	    analog.rotation = 220.0
	    analog.alpha = 0.0
	    analog.anchor.setTo(0.5, 0.0)
	    
	    arrow = game.add.sprite(400, 400, "arrow")
	    arrow.anchor.setTo(0.1, 0.5)
	    arrow.alpha = 0.0
	
	    player = game.add.sprite(150, 320, "player")
	    player.anchor.setTo(0.5, 0.5)
	
	    game.physics.enable(player, Phaser.Physics.ARCADE)
	
	    player.body.collideWorldBounds = true
	    player.body.bounce.set(0.9)
	    player.body.drag.set(20, 0)
	
	    // Enable input.
	    player.inputEnabled = true
	    player.input.start(0, true)
	    player.events.onInputDown.add(this::set)
	    player.events.onInputUp.add(this::launch)
	    
	    // this tween is to make the camera return to left side of world when done launching
	    // so it is not used until then
	    myTween = game.add.tween(player).to(object{ var x= 150}, 5000, Phaser.Easing.Linear::None)
	    myTween.onComplete.add(this::reappear, this)
	    game.camera.follow(player, Phaser.Camera.FOLLOW_TOPDOWN)
	}
	
	fun reappear() {
	    
	    launched = false
	    player.alpha = 1.0
	}
	
	fun set(player:Sprite,pointer:Pointer) {
	
	    //disallow launching until reset
	    if (!launched)
	    {
	        catchFlag = true
	        game.camera.follow(null)
	        player.body.moves = false
	        player.body.gravity.set(0)
	        player.body.velocity.set(0)
	    }
	}
	
	fun launch() {
	    
	    if (catchFlag)
	    {
	        catchFlag = false
	        launched = true
	        game.camera.follow(player, Phaser.Camera.FOLLOW_TOPDOWN)
	    
	        arrow.alpha = 0.0
	        analog.alpha = 0.0
	        val Xvector = (arrow.x - player.x) * 3
	        val Yvector = (arrow.y - player.y) * 3
	        player.body.moves = true
	        player.body.gravity.setTo(0, 180)
	        player.body.velocity.setTo(Xvector, Yvector)
	    }
	}
	
	override fun update() {
	
	    arrow.rotation = game.physics.arcade.angleBetween(arrow, player)
	    
	    //  Track the player sprite to the mouse    
	    if (catchFlag)
	    {   
	        var distance = game.physics.arcade.distanceToPointer(arrow)
	        val theta = game.physics.arcade.angleToPointer(arrow)
	        
	        // Govern the distance the sprite is dragged away from launch post
	        if (distance > 300)
	        { 
	            distance = 300.0
	            val adjacentX = Math.cos(theta) * distance
	            val oppositeY = Math.sin(theta) * distance
	            player.x = 400 + adjacentX
	            player.y = 400 + oppositeY
	            analog.height = distance
	        }
	        else
	        {
	            player.x = game.input.activePointer.worldX
	            player.y = game.input.activePointer.worldY
	            analog.height = distance
	        }
	        
	        arrow.alpha = 1.0
	        analog.alpha = 0.5
	        analog.rotation = arrow.rotation - Math.PI/2
	        launchVelocity = analog.height
	    }
	    
	    //check sprite motion and if done, return camera to left side of world
	    var tweening = myTween.isRunning
	
	    if (!tweening && launched && (player.x >= game.world.width-20 || player.body.deltaX() == 0))
	    {
	        player.body.velocity.setTo(0, 0)
	        player.alpha = 0.0
	        player.body.moves = false
	        player.x = 150.0
	        player.y = 320.0
	        myTween.start()
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Drag the sprite and release to launch", 32, 32, "rgb(0,255,0)")
	    game.debug.cameraInfo(game.camera, 32, 64)
	    game.debug.spriteCoords(player, 32, 150)
	    game.debug.text("Launch Velocity: " + launchVelocity, 550, 32, "rgb(0,255,0)")
	
	}
}