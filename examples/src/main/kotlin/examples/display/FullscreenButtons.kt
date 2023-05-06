
package examples.display


import Phaser.*

class FullscreenButtons: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("dragon", "assets/pics/cougar_dragonsun.png")
	    game.load.spritesheet("button", "assets/buttons/button_sprite_sheet.png", 193, 71)
	
	}
	
	lateinit var button:Button
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    sprite = game.add.sprite(game.world.centerX, game.world.centerY, "dragon")
	    sprite.anchor.set(0.5)
	
	    game.stage.backgroundColor = "#000"
	
	    // Stretch to fill
	    game.scale.fullScreenScaleMode = Phaser.ScaleManager.EXACT_FIT
	
	    // Keep original size
	    // game.scale.fullScreenScaleMode = Phaser.ScaleManager.NO_SCALE
	
	    // Maintain aspect ratio
	    // game.scale.fullScreenScaleMode = Phaser.ScaleManager.SHOW_ALL
	
	    button = game.add.button(game.world.centerX - 95, 500, "button", this::actionOnClick, this, 2, 1, 0)
	    button.visible = false
	
	    game.scale.onFullScreenChange.add(this::onChangeFullScreen, this)

	    game.input.onDown.add(this::gofull, this)
	
	}

	fun onChangeFullScreen(scale:ScaleManager) {

		if (scale.isFullScreen) {
			onEnterFullScreen();
		} else {
			onLeaveFullScreen();
		}

	}

	fun onEnterFullScreen() {
	
	    button.visible = true
	
	}
	
	fun onLeaveFullScreen() {
	
	    button.visible = false
	    
	}
	
	fun gofull() {
	
	    game.scale.startFullScreen()
	
	}
	
	fun actionOnClick () {
	
	    sprite.tint = Math.random() * 0xFFFFFF
	
	}
	
	override fun update() {
	
	}
	
	override fun render() {
	
	    if (game.scale.isFullScreen)
	    {
	        game.debug.text("ESC to leave fullscreen", 270, 16)
	    }
	    else
	    {
	        game.debug.text("Click / Tap to go fullscreen", 270, 16)
	    }
	
	}
}