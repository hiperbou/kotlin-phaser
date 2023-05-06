
package examples.text


import Phaser.*

class TextWithPhysics: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var text1:Text
	lateinit var text2:Text
	
	override fun create() {
	
	    game.stage.backgroundColor = 0xbdbdbd
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    text1 = game.add.text(20, 50, "Text Objects", object{ var  font= "62px Arial Black";  var  fill= "#c51b7d" })
	    text1.stroke = "#de77ae"
	    text1.strokeThickness = 16.0
	    text1.setShadow(2, 2, "#333333", 2, true, false)
	
	    text2 = game.add.text(200, 300, "with physics", object{ var  font= "62px Arial Black";  var  fill= "#c51b7d" })
	    text2.stroke = "#de77ae"
	    text2.strokeThickness = 16.0
	    text2.setShadow(2, 2, "#333333", 2, false, true)
	
	    game.physics.arcade.enable(arrayOf<Text>( text1, text2 ))
	
	    text1.body.velocity.setTo(200, 200)
	    text1.body.collideWorldBounds = true
	    text1.body.bounce.set(1)
	
	    text2.body.velocity.setTo(-100, -100)
	    text2.body.collideWorldBounds = true
	    text2.body.bounce.set(1)
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(text1, text2)
	
	}
}