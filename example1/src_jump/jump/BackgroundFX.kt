package jump

import Phaser.*

class BackgroundFX(val game:Game, val container:Group){
    //	Original version by @author Mat Groves http://matgroves.com/ @Doormat23 from the Pixi.js examples
    //	Ported to Phaser by Richard Davey

    //var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
    // //var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })

    fun preload() {

        game.load.image("spin1", "assets/sprites/spinObj_01.png")
        game.load.image("spin2", "assets/sprites/spinObj_02.png")
        game.load.image("spin3", "assets/sprites/spinObj_03.png")
        game.load.image("spin4", "assets/sprites/spinObj_04.png")
        game.load.image("spin5", "assets/sprites/spinObj_05.png")
        game.load.image("spin6", "assets/sprites/spinObj_06.png")
        game.load.image("spin7", "assets/sprites/spinObj_07.png")
        game.load.image("spin8", "assets/sprites/spinObj_08.png")

    }

    lateinit var renderTexture: RenderTexture
    lateinit var renderTexture2:RenderTexture
    lateinit var currentTexture:RenderTexture
    lateinit var outputSprite: Phaser.Sprite
    lateinit var stuffContainer: Group
    var count = 0.0

    fun create() {

        // create two render textures.. these dynamic textures will be used to draw the scene into itself
        renderTexture = game.add.renderTexture(960, 640, "texture1")
        renderTexture2 = game.add.renderTexture(960, 640, "texture2")
        currentTexture = renderTexture

        // create a sprite that uses the render texture we created above
        outputSprite = game.add.sprite(960/2, 640/2, currentTexture)
        container.add(outputSprite)

        // align the sprite
        outputSprite.anchor.x = 0.5
        outputSprite.anchor.y = 0.5

        stuffContainer = game.add.group()
        stuffContainer.x = 960/2.0
        stuffContainer.y = 640/2.0
        container.add(stuffContainer)

        // now create some items and randomly position them in the stuff container
        for(i in 0..20-1)
        {
            var item = stuffContainer.create(Math.random() * 400 - 200, Math.random() * 400 - 200, "spin" + Phaser.Math.random(1,8))
            item.anchor.setTo(0.5, 0.5)
        }

        // used for spinning!
        count = 0.0
    }

    fun update() {

        stuffContainer.addAll("rotation", 0.1)

        count += 0.01

        // swap the buffers..
        var temp = renderTexture
        renderTexture = renderTexture2
        renderTexture2 = temp

        // set the texture
        outputSprite.setTexture(renderTexture)

        // twist this up!
        stuffContainer.rotation -= 0.01
        outputSprite.scale.x  = 1 + Math.sin(count) * 0.2
        outputSprite.scale.y  = 1 + Math.sin(count) * 0.2

        // render the stage to the texture
        // the true clears the texture before content is rendered
        renderTexture2.renderXY(container, 0, 0, true)

    }
}