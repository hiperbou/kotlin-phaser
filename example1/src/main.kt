import Koala.*
import Koala.Sprite
import Phaser.*
import jump.jumpMain
import web.ExamplesConfig
import web.ExamplesWeb
import runExample

val Math = kotlin.js.Math

fun main(args: Array<String>) {
	//runExample(3) //Test examples
	//runExample(examples.basics.E08SpriteRotation())
	//runExample(examples.animation.TwoFrameTest())
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
	//gameMain()
	//ExamplesWeb(ExamplesConfig())
	jumpMain()
}

fun gameMain() {
	val game = initKoala(GameConfig(
			width = gameProperties.screenWidth,
			height = gameProperties.screenHeight,
			parent = "gameDiv",
			renderer = Phaser.AUTO,
			state = MainState()
	))
}

object gameProperties {
	val screenWidth = 800.0
	val screenHeight = 600.0
}

object Assets {
	val panda = Asset("koala", "assets/panda.png")
}



class Panda(x:Double, y:Double) : Sprite(x, y, Assets.panda) {
	init{
		anchor.set(0.5, 0.5);
		//scale.set(2,1)
	}
	override fun update() {
		this.angle += 5;
	}
}

class MainState:State() {
	val keyboard: Keyboard get() = game.input.keyboard
	val key_left by lazy { keyboard.addKey(Keyboard.LEFT) }
	val key_right by lazy { keyboard.addKey(Keyboard.RIGHT) }
	val key_thrust by lazy { keyboard.addKey(Keyboard.UP) }

	lateinit var layer1: Group
	lateinit var layer2: Group

	override fun preload() {
		load.image(Assets.panda)

		game.scale.scaleMode = Phaser.ScaleManager.SHOW_ALL
		game.scale.pageAlignHorizontally = true
		game.scale.pageAlignVertically = true
		game.scale.refresh()
	}

	override fun create() {
		game.add.text(10, 10, "Hello World!", TextStyle(
				font = "40px Arial",
				fill = "red"
		))

		layer1 = game.add.group()
		layer2 = game.add.group()
		layer2.scale.set(2,2)



		for (i in 1..10) {
			layer1.addChild( Panda(Math.random() * gameProperties.screenWidth,
					Math.random() * gameProperties.screenHeight))
		}

		for (i in 1..10) {
			layer2.addChild( Panda( Math.random() * gameProperties.screenWidth,
					Math.random() * gameProperties.screenHeight).apply { tint = 0x00ff00 })
		}

		val p = Panda(Math.random() * gameProperties.screenWidth,
				Math.random() * gameProperties.screenHeight).apply { tint = 0x0000ff }
		//layer1.addChild(p)
		//layer2.addChild(p)
	}

	override fun update() {
		layer1.x++
		layer2.x+=2
		if(layer1.x>100) {
			game.state.start(OtherState())
		}
	}
}

class OtherState:State() {
	val keyboard: Keyboard get() = game.input.keyboard
	val key_left by lazy { keyboard.addKey(Keyboard.LEFT) }
	val key_right by lazy { keyboard.addKey(Keyboard.RIGHT) }
	val key_thrust by lazy { keyboard.addKey(Keyboard.UP) }


	override fun preload() {
		load.image(Assets.panda)
	}

	override fun create() {
		game.add.text(10, 10, "Hello World!", TextStyle(
				font = "40px Arial",
				fill = "red"
		))

		val p = Panda(Math.random() * gameProperties.screenWidth,
				Math.random() * gameProperties.screenHeight).apply {
					tint = 0x0000ff
					scale.set(4,4)
		}
		game.add.existing(p)
	}
}