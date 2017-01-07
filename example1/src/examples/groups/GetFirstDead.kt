
package examples.groups

import Koala.initKoala
import Phaser.*

class GetFirstDead: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("veg", "assets/sprites/fruitnveg32wh37.png", 32, 32)
	    
	}
	
	lateinit var veg:Group
	
	override fun create() {
	
	    //  Create a group
	    veg = game.add.group()
	
	    //  Add 20 sprites to it - the "false" parameter sets them all to dead
	    veg.createMultiple(20, "veg", 0, false)
	
	    //  Set-up a simple repeating timer
	    game.time.events.repeat(Phaser.Timer.SECOND,  20, this::resurrect, this)
	    
	}
	
	fun resurrect() {
	
	    //  Get a dead item
	    var item = veg.getFirstDead<Sprite>()
	
	    if (item != null)
	    {
	        //  And bring it back to life
	        item.reset(game.world.randomX, game.world.randomY)
	
	        //  This just changes its frame
	        item.frame = game.rnd.integerInRange(0, 36)
	    }
	
	}
	
	override fun update() {
	}
	
	override fun render() {
	
	    game.debug.text("One item will be resurrected every second", 32, 32)
	    game.debug.text("Living: " + veg.countLiving() + "   Dead: " + veg.countDead(), 32, 64)
	    
	}
}