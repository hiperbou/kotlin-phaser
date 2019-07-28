
package examples.text


import Phaser.*

class KernOfDuty: State() {
	
	//var game = Phaser.Game(800, 480, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	var content = arrayOf(
	    " ",
	    "photon storm presents",
	    "a phaser production",
	    " ",
	    "Kern of Duty",
	    " ",
	    "directed by rich davey",
	    "rendering by mat groves",
	    "    ",
	    "03:45, November 4th, 2014",
	    "somewhere in the north pacific",
	    "mission control bravo ..."
			)
	
	lateinit var text:Text
	var index = 0
	var line = ""
	
	override fun preload() {
	    game.load.image("cod", "assets/pics/cod.jpg")
	}
	
	override fun create() {
	
	    game.add.sprite(0, 0, "cod")
	
	    text = game.add.text(32, 380, "", TextStyle(font="30pt Courier", fill= "#19cb65", stroke= "#119f4e", strokeThickness= 2))
	
	    nextLine()
	
	}
	
	fun updateLine() {
	
	    if (line.length < content[index].length)
	    {
	        line = content[index].substring(0, line.length + 1)
	        // text.text = line
	        text.setText(line)
	    }
	    else
	    {
	        //  Wait 2 seconds then start a line
	        game.time.events.add(Phaser.Timer.SECOND * 2, this::nextLine, this)
	    }
	
	}
	
	fun nextLine() {
	
	    index++
	
	    if (index < content.size)
	    {
	        line = ""
	        game.time.events.repeat(80, content[index].length + 1, this::updateLine, this)
	    }
	
	}
}