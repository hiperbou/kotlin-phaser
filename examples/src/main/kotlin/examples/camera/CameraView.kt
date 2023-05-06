
package examples.camera


import Phaser.*

class CameraView: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("backdrop", "assets/pics/remember-me.jpg")
	    game.load.image("card", "assets/sprites/mana_card.png")
	
	}
	
	lateinit var card:Sprite
	lateinit var cursors:CursorKeys
	var moving = 0
	
	override fun create() {
	
	    game.world.setBounds(0, 0, 1920, 1200)
	
	    game.add.sprite(0, 0, "backdrop")
	
	    card = game.add.sprite(200, 200, "card")
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	    game.input.onDown.add(this::toggle, this)
	
	}
	
	fun toggle() {
	
	    moving = if (moving == 0)  1 else  0
	
	}
	
	override fun update() {
	
	    if (moving === 0)
	    {
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
	    else
	    {
	        if (cursors.left.isDown)
	        {
	            card.x -= 4
	        }
	        else if (cursors.right.isDown)
	        {
	            card.x += 4
	        }
	
	        if (cursors.up.isDown)
	        {
	            card.y -= 4
	        }
	        else if (cursors.down.isDown)
	        {
	            card.y += 4
	        }
	    }
	
	}
	
	override fun render() {
	
	    game.debug.cameraInfo(game.camera, 500, 32)
	    game.debug.spriteInfo(card, 32, 32)
	
	    game.debug.text("Click to toggle sprite / camera movement with cursors", 32, 550)
	
	}
}