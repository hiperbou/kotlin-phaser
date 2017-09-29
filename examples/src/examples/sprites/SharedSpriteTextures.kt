
package examples.sprites


import Phaser.*

class SharedSpriteTextures: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    //  We load a TexturePacker JSON file and image and show you how to make several unique sprites from the same file
	    game.load.atlas("atlas", "assets/pics/texturepacker_test.png", "assets/pics/texturepacker_test.json")
	
	}
	
	lateinit var chick:Sprite
	lateinit var car:Sprite
	lateinit var mech:Sprite
	lateinit var robot:Sprite
	lateinit var cop:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#404040"
	
	    chick = game.add.sprite(64, 64, "atlas")
	
	    //  You can set the frame based on the frame name (which TexturePacker usually sets to be the filename of the image itself)
	    chick.frameName = "budbrain_chick.png"
	
	    //  Or by setting the frame index
	    //chick.frame = 0
	
	    cop = game.add.sprite(600, 64, "atlas")
	    cop.frameName = "ladycop.png"
	
	    robot = game.add.sprite(50, 300, "atlas")
	    robot.frameName = "robot.png"
	
	    car = game.add.sprite(100, 400, "atlas")
	    car.frameName = "supercars_parsec.png"
	
	    mech = game.add.sprite(250, 100, "atlas")
	    mech.frameName = "titan_mech.png"
	
	}
}