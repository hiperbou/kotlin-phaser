
package examples.sprites


import Phaser.*


class AlignMultipleSprites: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("block", "assets/sprites/block.png")
	
	}
	
	override fun create() {
	
	    var sprite1 = game.add.sprite(70, 250, "block")
	    var sprite2 = game.add.sprite(0, 0, "block").alignTo(sprite1, Phaser.RIGHT_CENTER, 16)
	    var sprite3 = game.add.sprite(0, 0, "block").alignTo(sprite2, Phaser.RIGHT_CENTER, 16)
	    var sprite4 = game.add.sprite(0, 0, "block").alignTo(sprite3, Phaser.RIGHT_CENTER, 16)
	    var sprite5 = game.add.sprite(0, 0, "block").alignTo(sprite4, Phaser.RIGHT_CENTER, 16)
	    var sprite6 = game.add.sprite(0, 0, "block").alignTo(sprite5, Phaser.RIGHT_CENTER, 16)
	
	}
}