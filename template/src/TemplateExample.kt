
import Phaser.*

class TemplateExample : State() {
	
    enum class Images { LOGO, LOGO_TEXT, PHASER }

	override fun preload() {
		game.load.image(Images.LOGO.name, "assets/logo.png")
		game.load.image(Images.LOGO_TEXT.name, "assets/logo-text.png")
		game.load.image(Images.PHASER.name, "assets/phaser.png")
	}
	
	lateinit var logos:Group
	
	override fun create() {
        game.stage.backgroundColor = "#FFFFFF";

        game.physics.setBoundsToWorld()

        logos = game.add.group()
        logos.enableBody = true
        logos.physicsBodyType = Phaser.Physics.ARCADE

        (0..3).forEach { y ->
            (0..9).forEach { x ->
                val logo = logos.create( Math.random()*800, 150 + Math.random() * 400, Images.LOGO.name)
                logo.checkWorldBounds = true
                logo.events.onOutOfBounds.add({ logo:Sprite ->
                    logo.reset(-64, 200 + Math.random() * 400)
                    logo.body.velocity.x = 50 + Math.random() * 200
                    logo.body.velocity.y = Math.random() * 100
                })
                logo.body.velocity.x = 50 + Math.random() * 200
                logo.body.velocity.y = Math.random() * 100
            }
        }

        game.add.sprite(100, 10, Images.LOGO_TEXT.name)
        game.add.sprite(300, 150, Images.PHASER.name)
    }
}