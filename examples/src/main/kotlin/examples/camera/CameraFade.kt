
package examples.camera


import Phaser.*

class CameraFade: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("background","assets/tests/debug-grid-1920x1920.png")
	    game.load.image("player","assets/sprites/phaser-dude.png")
	
	}
	
	lateinit var player:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.add.tileSprite(0, 0, 1920, 1920, "background")
	
	    game.world.setBounds(0, 0, 1920, 1920)
	
	    game.physics.startSystem(Phaser.Physics.P2JS)
	
	    player = game.add.sprite(game.world.centerX, game.world.centerY, "player")
	
	    game.physics.p2.enable(player)
	
	    player.body.fixedRotation = true
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    //  Notice that the sprite doesn"t have any momentum at all,
	    //  it"s all just set by the camera follow type.
	    //  0.1 is the amount of linear interpolation to use.
	    //  The smaller the value, the smooth the camera (and the longer it takes to catch up)
	    game.camera.follow(player, Phaser.Camera.FOLLOW_LOCKON, 0.1, 0.1)
	
	    //  Listen for this signal to reset once the fade is over
	    game.camera.onFadeComplete.add(this::resetFade, this)
	
	    game.input.onDown.add(this::fade, this)
	
	}
	
	fun fade() {
	
	    //  You can set your own fade color and duration
	    game.camera.fade(0x000000, 4000)
	
	}
	
	fun resetFade() {
	
	    game.camera.resetFX()
	
	}
	
	override fun update() {
	
	    player.body.setZeroVelocity()
	
	    if (cursors.up.isDown)
	    {
	        player.body.moveUp(300)
	    }
	    else if (cursors.down.isDown)
	    {
	        player.body.moveDown(300)
	    }
	
	    if (cursors.left.isDown)
	    {
	        player.body.velocity.x = -300.0
	    }
	    else if (cursors.right.isDown)
	    {
	        player.body.moveRight(300)
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Arrows to move. Click to fade", 32, 32)
	
	}
}