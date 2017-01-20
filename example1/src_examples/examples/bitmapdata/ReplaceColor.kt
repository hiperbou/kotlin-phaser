
package examples.bitmapdata


import Phaser.*

class ReplaceColor: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload,  var  create= create })
	
	override fun preload() {
	
	    game.load.image("crystal", "assets/pics/jim_sachs_time_crystal.png")
	
	}
	
	lateinit var bmd:BitmapData
	
	override fun create() {
	
		bmd = game.make.bitmapData()
	    bmd.load("crystal")
	    bmd.addToWorld(game.world.centerX, game.world.centerY, 0.5, 0.5)
	
		game.input.onDown.add(this::recolor, this)
	
	}
	
	fun recolor () {
	
	    // replaceRGB: fun (sourceR, sourceG, sourceB, sourceA, destR, destG, destB, destA, region) {
	
		bmd.replaceRGB(0, 85, 255, 255, 0, 250, 40, 255)
	
	}
}