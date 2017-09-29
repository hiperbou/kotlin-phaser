
package examples.text


import Phaser.*

class RetroFont2: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("goldFont", "assets/fonts/retroFonts/gold_font.png")
	    game.load.image("bluePink", "assets/fonts/retroFonts/bluepink_font.png")
	    game.load.image("forgotten", "assets/pics/forgotten_worlds.png")
	
	}
	
	lateinit var font1:RetroFont
	lateinit var font2:RetroFont
	lateinit var image1:Image
	lateinit var image2:Image
	
	override fun create() {
	
	    font1 = game.add.retroFont("goldFont", 16, 16, "!     :() ,?." + Phaser.RetroFont.TEXT_SET10, 20, 0, 0)
	    font1.text = "phaser brings you retro style bitmap fonts"
	
	    image1 = game.add.image(game.world.centerX, 48, font1)
	    image1.anchor.set(0.5)
	
	    font2 = game.add.retroFont("bluePink", 32, 32, Phaser.RetroFont.TEXT_SET2, 10)
	    font2.setText("phaser 2\nin the house", true, 0, 8, Phaser.RetroFont.ALIGN_CENTER)
	
	    image2 = game.add.image(game.world.centerX, 220, font2)
	    image2.anchor.set(0.5)
	
	    game.add.image(0, game.height - 274, "forgotten")
	
	    game.time.events.loop(Phaser.Timer.SECOND * 2, this::change, this)
	
	}
	
	fun change() {
	
	    image2.tint = Math.random() * 0xFFFFFF
	
	}
	
	override fun update() {
	
		image2.rotation += (2 * game.time.physicsElapsed)
	
	}
}