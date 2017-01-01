package examples

import Koala.initKoala
import Phaser.GameConfig
import examples.basics.*

/**
 * Created by hiperbou on 31/12/2016.
 */

object exampleProperties {
    val screenWidth = 800.0
    val screenHeight = 600.0
}

fun runExample(state:Phaser.State) {
    val game = initKoala(GameConfig(
            width = exampleProperties.screenWidth,
            height = exampleProperties.screenHeight,
            parent = "gameDiv",
            state = state
    ))
}

fun runExample(exampleToRun:Int) {
    runExample(when(exampleToRun){
        1-> E01LoadAnImage()
        2-> E02ClickOnAnImage()
        3-> E03MoveAnImage()
        4-> E04ImageFollowInput()
        5-> E05LoadAnAnimation()
        6-> E06RenderText()
        7-> E07TweenAnImage()
        8-> E08SpriteRotation()

        else-> E01LoadAnImage()
    })
}
