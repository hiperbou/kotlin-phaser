
package examples.camera


import Phaser.*

class CameraCull: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	    game.load.image("disk", "assets/sprites/ra_dont_crack_under_pressure.png")
	}
	
	lateinit var s:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#182d3b"
	
	    s = game.add.sprite(game.world.centerX, game.world.centerY, "disk")
	    s.anchor.setTo(0.5, 0.5)
	
	}
	
	override fun update() {
	
	    s.rotation += 0.01
	
	    if (game.input.keyboard.isDown(Phaser.Keyboard.LEFT))
	    {
	        s.x -= 4
	    }
	    else if (game.input.keyboard.isDown(Phaser.Keyboard.RIGHT))
	    {
	        s.x += 4
	    }
	
	    if (game.input.keyboard.isDown(Phaser.Keyboard.UP))
	    {
	        s.y -= 4
	    }
	    else if (game.input.keyboard.isDown(Phaser.Keyboard.DOWN))
	    {
	        s.y += 4
	    }
	
	}
	
	override fun render() {
	
	    game.debug.spriteBounds(s)
	    game.debug.spriteInfo(s, 20, 32)
	
	}
}