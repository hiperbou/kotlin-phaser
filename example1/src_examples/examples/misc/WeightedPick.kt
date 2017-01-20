
package examples.misc


import Phaser.*

class WeightedPick: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("bg", "assets/skies/deepblue.png")
	
	}
	
	override fun create() {
	
	    game.add.image(0, 0, "bg")
	
	    var test = arrayOf(0,1,2,3,4,5,6,7,8,9)
	
	    var total = mutableListOf(0,0,0,0,0,0,0,0,0,0)
	
	    for(i in 0..1000000-1)
	    {
	        val rnd = game.rnd.weightedPick(test)
	
	        total[rnd]++
	    }
	
	    var style = object{ val font = "24px Courier"; val fill = "#fff"; val tabs = arrayOf(150)}


		var list = mutableListOf<Array<Int>>()

		for (i in 0..total.size-1)
	    {
	        list.add(arrayOf(i, total[i]))
	    }

		var listFinal = mutableListOf(
				arrayOf("Value", "Total" )
		)
		list.forEach { listFinal.add(arrayOf(it[0].toString(), it[1].toString())) }

	    val text = game.add.text(200, 64, "", style)
	    text.parseList(listFinal.toTypedArray())
	
	}
}