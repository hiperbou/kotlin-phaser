
package examples.sprites


import Phaser.*

class RotatedAtlasFrameSupport: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.atlas("atlas", "assets/sprites/atlas_rotated.png", "assets/sprites/atlas_rotated.json")
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = "#404040"
	
	    //  These two are both rotated
	    var cactuar = game.add.sprite(0, 0, "atlas", "cactuar")
	    var contra = game.add.sprite(300, 0, "atlas", "contra1")
	
	    contra.tint = 0xff0000
	
	    //   Should be 83x169 (the original dimensions, even though rotated in the atlas)
	    console.log(contra.width, contra.height)
	
	    //  But this one isn"t
	    var lulu = game.add.sprite(500, 0, "atlas", "shocktroopers_lulu2")
	
	}
}