
package examples.groups

import Koala.initKoala
import Phaser.*

class CreateIfNull: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("veg", "assets/sprites/fruitnveg32wh37.png", 32, 32)
	    
	}
	
	lateinit var veg:Group
	
	override fun create() {
	
	    //  Create a group
	    veg = game.add.group()
	
	    //  Add 5 sprites to it - the "false" parameter sets them all to dead
	    veg.createMultiple(5, "veg", 0, false)
	
	    //  Set-up a simple repeating timer
	    game.time.events.repeat(Phaser.Timer.SECOND,  20, this::resurrect, this)
	    
	}
	
	fun resurrect() {
	
	    //  Get a dead item - The Group was seeded with 5 "dead" items,
	    //  so those will be re-used first and then it will start
	    //  creating ones using the following arguments:
	
	    var x = game.world.randomX
	    var y = game.world.randomY
	    var key = "veg"
	    var frame = game.rnd.between(0, 36)
	
	    veg.getFirstDead<Sprite>(true, x, y, key, frame)
	
	}
	
	override fun render() {
	
	    game.debug.text("getFirstDead will be called every second", 32, 32)
	    game.debug.text("Living: " + veg.countLiving() + "   Dead: " + veg.countDead(), 32, 64)
	    
	}
}