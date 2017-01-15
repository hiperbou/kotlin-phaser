
package examples.groups

import Koala.initKoala
import Phaser.*

class BringAGroupToTop: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("beast", "assets/pics/shadow_of_the_beast2_karamoon.png")
	    game.load.image("snot", "assets/pics/nslide_snot.png")
	    game.load.image("atari1", "assets/sprites/atari130xe.png")
	    game.load.image("sonic", "assets/sprites/sonic_havok_sanity.png")
	
	}
	
	lateinit var group1:Group
	lateinit var group2:Group
	
	override fun create() {
	
	    //  Create a background image
	    var bg = game.add.sprite(0, 0, "beast")
	    bg.width = 800.0
	
	    //  Create a Group that will sit above the background image
	    group1 = game.add.group()
	
	    //  Create a Group that will sit above Group 1
	    group2 = game.add.group()
	
	    //  Now let"s create some random sprites and enable them all for drag and "bring to top"
	    for(i in 0..10-1)
	    {
	        var tempSprite = game.add.sprite(game.world.randomX, game.world.randomY, "atari1")
	
	        tempSprite.name = "atari" + i
	        tempSprite.inputEnabled = true
	        tempSprite.input.enableDrag(false, true)
	
	        group1.add(tempSprite)
	
	        //  Sonics
	
	        tempSprite = game.add.sprite(game.world.randomX, game.world.randomY, "sonic")
	
	        tempSprite.name = "sonic" + i
	        tempSprite.inputEnabled = true
	        tempSprite.input.enableDrag(false, true)
	
	        group2.add(tempSprite)
	    }
	
	    //  Create a foreground image - everything should appear behind this, even when dragged
	    var snot = game.add.sprite(game.world.centerX, game.world.height, "snot")
	    snot.anchor.setTo(0.5, 1)
	
	}
	
	override fun update() {
	
	    if (game.input.keyboard.isDown(Phaser.Keyboard.ONE))
	    {
	        game.world.bringToTop(group1)
	    }
	
	    if (game.input.keyboard.isDown(Phaser.Keyboard.TWO))
	    {
	        game.world.bringToTop(group2)
	    }
	
	}
	
	override fun render() {
	    game.debug.inputInfo(32, 32)
	}
}