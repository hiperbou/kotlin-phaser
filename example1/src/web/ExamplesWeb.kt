package web

import Koala.initKoala
import Phaser.*


class ExamplesWeb(val config: ExamplesConfig)
{
    object exampleDivProperties {
        val screenWidth = 800.0
        val screenHeight = 600.0
    }

    var currentExample = 0
    lateinit var game: Game
    var topBarGame:Game
        var topBar = TopBar(this::runCurrentGame,this::prevExample, this::nextExample)

    init {
        topBarGame = startTopBar()
    }

    private fun runExample(example:ExampleInfo): Game {
        return initKoala(GameConfig(
                width = exampleDivProperties.screenWidth,
                height = exampleDivProperties.screenHeight,
                renderer = example.renderer,
                parent = "gameDiv",
                state = example.state
        ))
    }

    private fun runCurrentGame() {
        val example = getExampleInfo(currentExample)
        topBar.title.text = example.name
        game = runExample(example)
        setupScale(topBarGame)
        setupScale(game)
    }

    private fun setupScale(game:Game){
        game.scale.scaleMode = Phaser.ScaleManager.SHOW_ALL
        game.scale.pageAlignHorizontally = true
        game.scale.pageAlignVertically = true
        game.scale.refresh()
    }

    private fun changeExample(exampleNum:Int)
    {
        currentExample = Math.clamp(exampleNum, config.minExample, config.maxExample).toInt()
        console.log("ChangeExample", currentExample)
        game.destroy()
        runCurrentGame()
    }

    private fun startTopBar(): Game {
        return initKoala(GameConfig(
                width = exampleDivProperties.screenWidth,
                height = 70,
                renderer = AUTO,
                parent = "topBarDiv",
                state = topBar
        ))
    }

    fun prevExample(){
        changeExample(--currentExample)
    }

    fun nextExample(){
        changeExample(++currentExample)
    }


    data class ExampleInfo(val state:Phaser.State, val name:String, val renderer:Number)

    fun getExampleInfo(n: Int):ExampleInfo {
        val state = getExampleState(n)
        val name = state::class.js.name
        val renderer = getExampleRenderer(n)
        return ExampleInfo(state,name,renderer)
    }

    class TopBar(val onReady:()->Unit, val onPrev:()->Unit, val onNext:()->Unit): State() {
        lateinit var title: Text

        override fun preload() {
            game.load.spritesheet("button", "assets/exampleWeb/button_sprite_sheet.png", 193, 71)
            game.load.image("arrow","assets/exampleWeb/arrow.png")
        }

        override fun create() {
            val margin = 32
            val buttonWidth = 190
            val arrowOffsetX = 95
            val arrowOffsetY = 30
            game.stage.backgroundColor = "#000000"

            val prevButton = game.add.button(margin, 0, "button", onPrev, this, 2, 1, 0)
            val nextButton = game.add.button(game.world.width - margin - buttonWidth, 0, "button", onNext, this, 2, 1, 0)

            val prevArrow = game.add.image(prevButton.x + arrowOffsetX, arrowOffsetY,"arrow")
            prevArrow.anchor.set(0.5)
            prevArrow.scale.x = -1.0
            game.add.image(nextButton.x + arrowOffsetX, arrowOffsetY, "arrow").anchor.set(0.5)

            title = game.add.text(0, 0, "Loading...",
                    TextStyle(fill="#ffffff",
                            boundsAlignH ="center",
                            boundsAlignV ="middle"))
            title.setShadow(3, 3, "rgba(0,0,0,0.5)", 2)
            title.setTextBounds(margin+buttonWidth, 0, game.world.width - margin*2 - buttonWidth*2, 70)
            onReady()
        }
    }
}

