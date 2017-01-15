
package examples.groups

import Koala.initKoala
import Phaser.*

class Sort: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("trees", "assets/tilemaps/tiles/walls_1x2.png", 32, 64)
	
	}
	lateinit var group:Group
	override fun create() {
	
	    group = game.add.group()
	
	    var locs = mutableListOf<Double>()
	
	    for(i in 0..16-1)
	    {
	        //  This line tests integer sorting
	        // locs.add((i * 32) + getMath.random())
	
	        //  This one tests float sorting
	        locs.add((i * 32) + Math.random())
	    }
	
	    console.log(locs)
	
	    //  Shuffle our positions
	    locs = Phaser.ArrayUtils.shuffle(locs.toTypedArray()).toMutableList()
	
	    console.log(locs)
	
	    for(i in 0..16-1)
	    {
	        group.create(400, locs[i], "trees", 0)
	    }
	
	    game.input.onDown.add(this::sort, this)
	
	}
	
	fun sort() {
	
	    group.sort("y", Phaser.Group.SORT_ASCENDING)
	
	    for(i in 0..16-1)
	    {
	        console.log(group.children[i].z, "=", group.children[i].y)
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Click to sort", 10, 20)
	
	}
}