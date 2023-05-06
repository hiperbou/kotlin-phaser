
package examples.input


import Phaser.*

class WordInput: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create })
	
	var word = "phaser"
	var correct = mutableMapOf<Char,Boolean>()
	lateinit var bmd:BitmapData
	
	override fun create() {
	   
	    //  Here we"ll create a simple array where each letter of the word to enter represents one element:
	    for(i in 0..word.length-1)
	    {
	        correct.put(word[i],false)
	    }
	
	    //  This is our BitmapData onto which we"ll draw the word being entered
	    bmd = game.make.bitmapData(800, 200)
	    bmd.context.font = "64px Arial"
	    bmd.context.fillStyle = "#ffffff"
	    bmd.context.fillText(word, 64.0, 64.0)
	    bmd.addToWorld()
	
	    //  Capture all key presses
	    game.input.keyboard.addCallbacks(this, {}, {}, this::keyPress)
	
	}
	
	fun keyPress(char:Char) {
	
	    //  Clear the BMD
	    bmd.cls()
	
	    //  Set the x value we"ll start drawing the text from
	    var x = 64.0
	
	    //  Loop through each letter of the word being entered and check them against the key that was pressed
	    for(i in 0..word.length-1)
	    {
	        var letter = word[i]
	
	        //  If they pressed one of the letters in the word, flag it as correct
	        if (char == letter)
	        {
	            correct[letter] = true
	        }
	
	        //  Now draw the word, letter by letter, changing colour as required
	        if (correct[letter]==true)
	        {
	            bmd.context.fillStyle = "#00ff00"
	        }
	        else
	        {
	            bmd.context.fillStyle = "#ffffff"
	        }
	
	        bmd.context.fillText(letter.toString(), x, 64.0)
	
	        x += bmd.context.measureText(letter.toString()).width
	    }
	
	}
}