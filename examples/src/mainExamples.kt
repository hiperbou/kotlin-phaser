
import Phaser.AUTO
import Phaser.Game
import Phaser.GameConfig
import Phaser.State
import web.ExamplesConfig
import web.ExamplesWeb

object exampleProperties {
    val screenWidth = 800.0
    val screenHeight = 600.0
}

fun runExample(state: State): Game {
    return Game(GameConfig(
            width = exampleProperties.screenWidth,
            height = exampleProperties.screenHeight,
            renderer = AUTO,
            //renderer = Phaser.CANVAS,
            //renderer = Phaser.WEBGL,
            parent = "gameDiv",
            state = state
    ))
}

fun main(args: Array<String>) {
    //runExample(examples.basics.E08SpriteRotation())
    //runExample(examples.animation.TwoFrameTest())
    //runExample(examples.animation.LoopedAnimation())
    //runExample(examples.arcadephysics.LauncherFollowWorld())
    //runExample(examples.audio.SoundComplete())
    //runExample(examples.camera.BasicFollow())
    //runExample(examples.debug.DebugSprite())
    //runExample(examples.display.PixiRenderTexture())
    //runExample(examples.filters.SpiralGalaxy())
    //runExample(examples.filters.PixiFilter())
    //runExample(examples.games.Breakout())
    //runExample(examples.games.Invaders())
    //runExample(examples.games.MatchingPairs())
    //runExample(examples.games.Simon())
    //runExample(examples.games.Starstruck())
    //runExample(examples.games.SlidingPuzzle())
    //runExample(examples.games.Tanks())
    //runExample(examples.games.Gemmatch())
    //runExample(examples.games.Yahtzee())
    //runExample(examples.groups.SetAll())
    //runExample(examples.input.WordInput())
    //runExample(examples.loader.LoadVideo())
    //runExample(examples.misc.PauseMenu())
    //runExample(examples.p2physics.PostbroadphaseCallback())
    //runExample(examples.particles.AutoScale())
    //runExample(examples.tilemaps.TilemapRayCast())
    //runExample(examples.tilesprites.TilingSpriteAtlas32x32())
    //runExample(examples.tweens.GenerateData())
    //runExample(examples.video.MultipleVideos())
    //runExample(examples.buttons.RotatedButtons())
    //runExample(examples.demoscene.Starfield())
    //runExample(examples.sprites.RotateSpriteAroundPoint())
    //runExample(examples.weapon.FireMany())
    ExamplesWeb(ExamplesConfig())
}