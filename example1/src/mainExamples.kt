import Koala.initKoala
import Phaser.AUTO
import Phaser.Game
import Phaser.GameConfig
import Phaser.State
import examples.basics.*
import kotlin.browser.window

object exampleProperties {
    val screenWidth = 800.0
    val screenHeight = 600.0
}

fun runExample(state: State): Game {
    return initKoala(GameConfig(
            width = exampleProperties.screenWidth,
            height = exampleProperties.screenHeight,
            renderer = AUTO,
            //renderer = Phaser.CANVAS,
            //renderer = Phaser.WEBGL,
            parent = "gameDiv",
            state = state
    ))
}
