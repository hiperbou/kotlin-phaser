
package examples.sprites

import Koala.initKoala
import Phaser.*

class ChildSprites: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	lateinit var parent:Sprite
	lateinit var child:Sprite
	
	override fun preload() {
	
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	    game.load.spritesheet("mummy", "assets/sprites/metalslug_mummy37x45.png", 37, 45, 18)
	
	}
	
	override fun create() {
	
	    parent = game.add.sprite(100, 100, "mushroom")
	
	    parent.addChild(game.make.sprite(-50, -50, "mummy"))
	    parent.addChild(game.make.sprite(100, 0, "mummy"))
	    parent.addChild(game.make.sprite(200, 200, "mummy"))
	
	    //  This child will move faster because its position is updated as well as the parent
	    child = parent.addChild(game.make.sprite(0, 100, "mummy"))
	
	}
	
	override fun update() {
	
	    parent.x += 0.1
	    child.x += 0.1
	
	}
	
	override fun render() {
	
	    game.debug.text(parent.width.toString(), 32, 32)
	    game.debug.geom(parent.getBounds())
	
	}
}