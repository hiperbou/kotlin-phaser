
package examples.input


import Phaser.*

class CursorKeyMovement: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.stage.backgroundColor = "#007236"
	
	    game.load.image("ball", "assets/sprites/shinyball.png")
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	    game.load.image("phaser", "assets/sprites/sonic_havok_sanity.png")
	
	}
	
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    //  Modify the world and camera bounds
	    game.world.setBounds(-1000, -1000, 2000, 2000)
	
	    for(i in 0..100-1)
	    {
	        game.add.image(game.world.randomX, game.world.randomY, "mushroom")
	    }
	
	    game.add.image(-16, -16, "ball")
	
	    //  This will create a object called "cursors", inside it will contain 4 objects: up, down, left and right.
	    //  These are all Phaser.Key objects, so anything you can do with a Key object you can do with these.
	    cursors = game.input.keyboard.createCursorKeys()
	
	    var text = game.add.text(32, 32, "Cursors to move. Shift + Up / Down to Rotate World", object{ var  fill= "#ffffff" })
	
	}
	
	override fun update() {
	
	    //  For example this checks if the up or down keys are pressed and moves the camera accordingly.
	    if (cursors.up.isDown)
	    {
	        //  If the shift key is also pressed then the world is rotated
	        if (cursors.up.shiftKey)
	        {
	            game.world.rotation += 0.05
	        }
	        else
	        {
	            game.camera.y -= 4
	        }
	    }
	    else if (cursors.down.isDown)
	    {
	        if (cursors.down.shiftKey)
	        {
	            game.world.rotation -= 0.05
	        }
	        else
	        {
	            game.camera.y += 4
	        }
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
	
	    game.debug.cameraInfo(game.camera, 32, 500)
	
	}
}