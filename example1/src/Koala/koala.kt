package Koala

import Phaser.Asset
import Phaser.Game
import Phaser.GameConfig
import kotlin.properties.Delegates
/*
var phaserGame:Phaser.Game by Delegates.notNull()

open class Sprite(x:Double, y:Double, key: String, frame:String?) : Phaser.Sprite(phaserGame,x,y,key,frame) {
    constructor(x:Double, y:Double, key: String) : this(x,y,key,undefined)
    init{
        //game.add.existing(this);
    }
}*/
/*
fun initKoala(config:Phaser.IGameConfig):Game {
    //phaserGame = Game(config)
    //width, height, renderer, parent, state, transparent, antialias, physicsConfig
    phaserGame = Game(config.width, config.height, config.renderer,
            config.parent, config.state, config.transparent,
            config.antialias, config.physicsConfig)
    return phaserGame
}
*/




//var currentModule:Module = Module("koala.dummymodule",listOf(), listOf(), listOf())
//val modules = mutableListOf<Module>()
//object KoalaStates {
//    val Main = GameStateType("KoalaMain")
//}

/*fun maincfc(args: Array<String>) {
    addModule(currentModule)
    koalaStart()
}

fun koalaStart() {
    val game = Phaser.Game(gameProperties.screenWidth, gameProperties.screenHeight, "auto", "gameDiv")
    game.state.add(KoalaStates.Main, ::KoalaMainState)
    game.state.start(KoalaStates.Main)
}

fun start(game: Phaser.Game, scene:(game: Phaser.Game) -> Scene){
    game.state.start(GameStateType(scene))
}

class KoalaMainState(val game: Phaser.Game) : GameState(game) {
    val load = game.load

    override fun preload() {
        load.images(currentModule.assets)
        load.sounds(currentModule.soundAssets)
    }

    override fun create() {
        currentModule.scenes.forEach {
            game.state.add(GameStateType(it), it)
        }

        game.state.start(GameStateType( currentModule.scenes[0] ))
    }
}
*/







/*fun addModule(module:Module) {
    modules.add(module)
}*/

//open class Scene(game: Phaser.Game) : GameState(game) {

//}

//open class Module(val name:String, val scenes:List<(game: Phaser.Game) -> Scene>, val assets:List<Asset>,
//                  val soundAssets:List<Asset>)

/*fun addModule(module:Module) {
    game.module(module.name).body {
        module.assets.forEach { game.addAsset(it) }
        module.soundAssets.forEach { game.addAudio(it) }
        module.scenes.forEach {
            val scene:Scene = it()
            game.createScene(scene.name, scene)
        }
    }
}*/


//fun GameStateType(scene:(game: Phaser.Game) -> Scene):GameStateType {
//    return GameStateType(scene.toString())
//}




/*class KoalaState(val game: Phaser.Game, val module:Module) : GameState(game) {
    val load = game.load

    override fun preload() {
        load.images(module.assets)
        load.sounds(module.soundAssets)
    }

    override fun create() {
        module.scenes.forEach {
            game.state.add(GameStateType(it), it)
        }

        game.state.start(GameStateType( module.scenes[0] ))
    }
}*/
