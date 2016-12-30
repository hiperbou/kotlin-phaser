package examples

import Koala.initKoala
import Phaser.*

fun main2(args: Array<String>) {
    val game = initKoala(GameConfig(
            width = gameProperties.screenWidth,
            height = gameProperties.screenHeight,
            parent = "gameDiv",
            //state = E01LoadAnImage()
            //state = E02ClickOnAnImage()
            //state = E03MoveAnImage()
            //state = E04ImageFollowInput()
            //state = E05LoadAnAnimation()
            //state = E06RenderText()
            state = E07TweenAnImage()
    ))
}


class E01LoadAnImage: State() {
    override fun preload() {
        //  You can fill the preloader with as many assets as your game requires

        //  Here we are loading an image. The first parameter is the unique
        //  string by which we'll identify the image later in our code.

        //  The second parameter is the URL of the image (relative)
        game.load.image("einstein", "assets/pics/ra_einstein.png")
    }

    override fun create() {

        //  This creates a simple sprite that is using our loaded image and
        //  displays it on-screen
        game.add.sprite(0, 0, "einstein")
    }
}

class E02ClickOnAnImage: State() {
    lateinit var text: Text
    var counter = 0

    override fun preload() {
        //  You can fill the preloader with as many assets as your game requires

        //  Here we are loading an image. The first parameter is the unique
        //  string by which we'll identify the image later in our code.

        //  The second parameter is the URL of the image (relative)
        game.load.image("einstein", "assets/pics/ra_einstein.png")
    }

    override fun create() {
        //  This creates a simple sprite that is using our loaded image and
        //  displays it on-screen and assign it to a variable
        val image = game.add.sprite(game.world.centerX, game.world.centerY, "einstein")

        //  Moves the image anchor to the middle, so it centers inside the game properly
        image.anchor.set(0.5)

        //  Enables all kind of input actions on this image (click, etc)
        image.inputEnabled = true

        text = game.add.text(250, 16, "", TextStyle(fill = "white"))

        image.events.onInputDown.add(this::listener, this)
    }

    fun listener ()  {
        counter++;
        text.text = "You clicked " + counter + " times!";
    }
}

class E03MoveAnImage: State() {
    override fun preload() {
        //  You can fill the preloader with as many assets as your game requires

        //  Here we are loading an image. The first parameter is the unique
        //  string by which we'll identify the image later in our code.

        //  The second parameter is the URL of the image (relative)
        game.load.image("einstein", "assets/pics/ra_einstein.png")
    }

    override fun create() {
        //  This creates a simple sprite that is using our loaded image and
        //  displays it on-screen
        //  and assign it to a variable
        val image = game.add.sprite(0, 0, "einstein")

        game.physics.enable(image, Phaser.Physics.ARCADE)

        image.body.velocity.x=150;
    }
}

class E04ImageFollowInput: State() {
    lateinit var sprite: Sprite

    override fun preload() {
        //  You can fill the preloader with as many assets as your game requires

        //  Here we are loading an image. The first parameter is the unique
        //  string by which we'll identify the image later in our code.

        //  The second parameter is the URL of the image (relative)
        game.load.image("phaser", "assets/sprites/phaser.png")
    }

    override fun create() {
        //  To make the sprite move we need to enable Arcade Physics
        game.physics.startSystem(Phaser.Physics.ARCADE)

        sprite = game.add.sprite(game.world.centerX, game.world.centerY, "phaser")
        sprite.anchor.set(0.5)

        //  And enable the Sprite to have a physics body:
        game.physics.arcade.enable(sprite)
    }

    override fun update () {
        //  If the sprite is > 8px away from the pointer then let's move to it
        if (game.physics.arcade.distanceToPointer(sprite, game.input.activePointer) > 8)
        {
            //  Make the object seek to the active pointer (mouse or touch).
            game.physics.arcade.moveToPointer(sprite, 300);
        }
        else
        {
            //  Otherwise turn off velocity because we're close enough to the pointer
            sprite.body.velocity.set(0);
        }
    }

    override fun render () {
        game.debug.inputInfo(32, 32);
    }
}

class E05LoadAnAnimation: State() {
    override fun preload() {
        game.load.atlasJSONHash("bot", "assets/sprites/running_bot.png", "assets/sprites/running_bot.json")
    }

    override fun create() {
        //  This sprite is using a texture atlas for all of its animation data
        var bot = game.add.sprite(200, 200, "bot")

        //  Here we add a new animation called 'run'
        //  We haven't specified any frames because it's using every frame in the texture atlas
        bot.animations.add("run")

        //  And this starts the animation playing by using its key ("run")
        //  15 is the frame rate (15fps)
        //  true means it will loop when it finishes
        bot.animations.play("run", 15, true)

    }
}

class E06RenderText: State() {
    override fun create() {
        val text = "- phaser -\n with a sprinkle of \n pixi dust.";
        val style = TextStyle( font = "65px Arial", fill = "#ff0044", align = "center")

        var t = game.add.text(game.world.centerX-300, 0, text, style);

    }
}

class E07TweenAnImage: State() {
    lateinit var tween:Tween
    var prev = -400
    //var t = Date.now()
    lateinit var sprite:Sprite

    override fun preload() {
        game.forceSingleUpdate = true

        //  You can fill the preloader with as many assets as your game requires

        //  Here we are loading an image. The first parameter is the unique
        //  string by which we'll identify the image later in our code.

        //  The second parameter is the URL of the image (relative)
        game.load.image("einstein", "assets/pics/ra_einstein.png")
    }

    override fun create() {
        sprite = game.add.sprite(-400, 0, "einstein")
        // var sprite = game.add.sprite(0, 0, 'einstein');

        //  Here we create a tween on the sprite created above
        tween = game.add.tween(sprite)

        //  The object defines the properties to tween.
        //  In this case it will move to x 600
        //  The 6000 is the duration in ms - 6000ms = 6 seconds
        //tween.to(js("({ x : 800 })"), 5000, "Linear", true, 0);
        tween.to(object{ val x = 800 }, 5000, "Linear", true, 0);
        //tween.to(object{ x = 800 }, 5000, "Linear", true, 0);

    }
}