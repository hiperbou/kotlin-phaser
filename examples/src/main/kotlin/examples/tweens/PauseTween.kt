
package examples.tweens


import Phaser.*

class PauseTween: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	lateinit var p:Sprite
	lateinit var tween:Tween
	lateinit var button:Button
	var flag = true
	
	override fun preload() {
	
	    game.load.image("diamond", "assets/sprites/diamond.png")
	    game.load.spritesheet("button", "assets/buttons/button_sprite_sheet.png", 193, 71)
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = 0x2d2d2d
	
	    p = game.add.sprite(100, 100, "diamond")
	
	    tween = game.add.tween(p).to(object{ var  x= 600 }, 4000, Phaser.Easing.Linear::None, true, 0, 1000, true)
	
	    button = game.add.button(game.world.centerX, 400, "button", this::actionOnClick, this, 2, 1, 0)
	
	}
	
	fun actionOnClick() {
	
	    if (flag != null)
	    {
	        tween.pause()
	    }
	    else
	    {
	        tween.resume()
	    }
	
	    flag = !flag
	
	}
}