
package examples.misc


import Phaser.*

class Template: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser.png")
	
	}
	
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    sprite = game.add.sprite(0, 0, "phaser")
	
	}
	
	override fun update() {
	
	    sprite.x = game.input.x
	    sprite.y = game.input.y
	
	}
	
	override fun render() {
	
	}
}