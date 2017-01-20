
package examples.groups


import Phaser.*

class RemoveBetween: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	 override fun preload() {
	
	    game.load.image("wasp", "assets/sprites/wasp.png")
	    game.load.image("sonic", "assets/sprites/sonic_havok_sanity.png")
	    game.load.image("phaser", "assets/sprites/phaser.png")
	
	}
	
	lateinit var sprites:Group
	
	override fun create() {
	
	    sprites = game.add.group()
	
	    //  First we"ll create 10 "wasp" sprites
	    for(i in 0..10-1)
	    {
	        sprites.create(game.world.randomX, game.world.randomY, "wasp")
	    }
	
	    //  Next we"ll create 10 "sonic" sprites
	    for(i in 0..10-1)
	    {
	        sprites.create(game.world.randomX, game.world.randomY, "sonic")
	    }
	
	    //  Finally we"ll create 10 "phaser" sprites
	    for(i in 0..10-1)
	    {
	        sprites.create(game.world.randomX, game.world.randomY, "phaser")
	    }
	
	    input.onDown.add(this::remove, this)
	
	}
	
	fun remove() {
	
	    //  This will remove all of the "sonic" sprites from the Group
	    //  because we"re removing all sprites between indexes 10 through to 19
	    sprites.removeBetween(10, 19)
	
	}
	
	override fun render() {
	
	    game.debug.text("Group size: " + sprites.total, 32, 32)
	
	}
}