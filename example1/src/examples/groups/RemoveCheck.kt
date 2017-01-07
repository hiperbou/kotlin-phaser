
package examples.groups

import Koala.initKoala
import Phaser.*

class RemoveCheck: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	 override fun preload() {
	
	    game.load.image("wasp", "assets/sprites/wasp.png")
	    game.load.image("sonic", "assets/sprites/sonic_havok_sanity.png")
	    game.load.image("phaser", "assets/sprites/phaser.png")
	
	}
	
	lateinit var group:Group
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    group = game.add.group()
	
	    //  First we"ll create 10 "wasp" sprites in the group
	    for(i in 0..10-1)
	    {
	        group.create(game.world.randomX, game.world.randomY, "wasp")
	    }
	
	    //  And now we"ll create a sprite that is NOT in the group
	    sprite = game.add.sprite(200, 20, "sonic")
	
	    input.onDown.add(this::remove, this)
	
	}
	
	fun remove() {
	
	    //  This should do nothing, because sprite isn"t a child of the group
	    group.remove(sprite)
	
	}
	
	override fun render() {
	
	    game.debug.text("Group size: " + group.total, 32, 32)
	
	}
}