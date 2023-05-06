
package examples.text


import Phaser.*

class UpdateText: State() {
	//  Example created by Arlefreak (https://github.com/Arlefreak)
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var text:Text
	var count:Int = 0

	override fun create() {
	
	    count = 0
	
	    text = game.add.text(game.world.centerX, game.world.centerY, "- You have clicked -\n0 times !",
				TextStyle(
					font= "65px Arial",
		fill= "#ff0044",
		align= "center"
		))
	
	    text.anchor.setTo(0.5, 0.5)
	
	}
	
	override fun update() {
	
	    game.input.onDown.add(this::updateText, this)
	
	}
	
	
	fun updateText() {
	
	    count++
	
	    text.setText("- You have clicked -\n" + count + " times !")
	
	}
}