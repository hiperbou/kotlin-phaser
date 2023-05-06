
package examples.text


import Phaser.*

class CenterTextOnSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("pic", "assets/pics/fof_background.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var text:Text
	
	override fun create() {
	
	    game.stage.backgroundColor = 0x5d5d5d
	
	    sprite = game.add.sprite(200, 200, "pic")
	    sprite.inputEnabled = true
	    sprite.input.enableDrag()
	
	    var style = object{ var  font= "32px Arial";  var  fill= "#ff0044";  var  wordWrap= true;  var  wordWrapWidth= sprite.width;  var  align= "center";  var  backgroundColor= "#ffff00" }
	
	    text = game.add.text(0, 0, "- text on a sprite -\ndrag me", style)
	    text.anchor.set(0.5)
	
	}
	
	override fun update() {
	
	    text.x = Math.floor(sprite.x + sprite.width / 2).toDouble()
	    text.y = Math.floor(sprite.y + sprite.height / 2).toDouble()
	
	}
}