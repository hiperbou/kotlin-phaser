
package examples.camera


import Phaser.*

class MovingTheCamera: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	}
	
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    //  Make our game world 2000x2000 pixels in size (the default is to match the game size)
	    game.world.setBounds(0, 0, 2000, 2000)
	
	    for(i in 0..150-1)
	    {
	        game.add.sprite(game.world.randomX, game.world.randomY, "mushroom")
	    }
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    if (cursors.up.isDown)
	    {
	        game.camera.y -= 4
	    }
	    else if (cursors.down.isDown)
	    {
	        game.camera.y += 4
	    }
	
	    if (cursors.left.isDown)
	    {
	        game.camera.x -= 4
	    }
	    else if (cursors.right.isDown)
	    {
	        game.camera.x += 4
	    }
	
	}
	
	override fun render() {
	
	    game.debug.cameraInfo(game.camera, 32, 32)
	
	}
}