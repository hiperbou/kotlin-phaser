
package examples.input

import Koala.initKoala
import Phaser.*

class KeyExample: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser-dude.png")
	
	}
	
	lateinit var sprite:Sprite
	
	lateinit var upKey:Key
	lateinit var downKey:Key
	lateinit var leftKey:Key
	lateinit var rightKey:Key
	
	override fun create() {
	
	    game.stage.backgroundColor = "#736357"
	
	    sprite = game.add.sprite(300, 300, "phaser")
	
	    //  In this example we"ll create 4 specific keys (up, down, left, right) and monitor them in our update fun
	
	    upKey = game.input.keyboard.addKey(Phaser.Keyboard.UP)
	    downKey = game.input.keyboard.addKey(Phaser.Keyboard.DOWN)
	    leftKey = game.input.keyboard.addKey(Phaser.Keyboard.LEFT)
	    rightKey = game.input.keyboard.addKey(Phaser.Keyboard.RIGHT)
	
	}
	
	override fun update() {
	
	    if (upKey.isDown)
	    {
	        sprite.y--
	    }
	    else if (downKey.isDown)
	    {
	        sprite.y++
	    }
	
	    if (leftKey.isDown)
	    {
	        sprite.x--
	    }
	    else if (rightKey.isDown)
	    {
	        sprite.x++
	    }
	
	}
}