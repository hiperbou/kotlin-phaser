import Koala.*
import Koala.Sprite
import Phaser.*
import examples.runExample

val Math = kotlin.js.Math

fun main(args: Array<String>) {
	//runExample(5) //Test examples
	//runExample(examples.basics.E08SpriteRotation())
	//runExample(examples.animation.TwoFrameTest())
	runExample(examples.audio.SoundComplete())
	//gameMain()
}

fun gameMain() {
	val game = initKoala(GameConfig(
			width = gameProperties.screenWidth,
			height = gameProperties.screenHeight,
			parent = "gameDiv",
			state = MainState()
	))
}

object gameProperties {
	val screenWidth = 640.0
	val screenHeight = 480.0
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