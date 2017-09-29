
package examples.time


import Phaser.*

class RemoveEvent: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  render= render })
	
	var counters = mutableListOf<Int>()
	var text = mutableListOf<Text>()
	var timerEvents = mutableListOf<TimerEvent>()
	var i = 9
	
	override fun create() {
	
	    game.stage.backgroundColor = "#6688ee"
	
	    for(i in 0..10-1)
	    {
	        counters.add(0)
	        text.add(game.add.text(game.world.centerX, 80 + (40 * i), "Counter " + i + " = 0", object{ var  font= "32px Arial";  var  fill= "#ffffff";  var  align= "center" }))
	        text[i].anchor.setTo(0.5, 0)
	
	        //  Here we create our timer events. They will be set to loop at a random value between 250ms and 1000ms
	        timerEvents.add(game.time.events.loop(game.rnd.integerInRange(250, 1000), this::updateCounter, this, i))
	    }
	
	    //  Click to remove
	    game.input.onDown.add(this::removeCounter, this)
	
	}
	
	fun updateCounter(idx:Int) {
	
	    counters[idx]++
	
	    text[idx].setText("Counter " + idx + " = " + counters[idx])
	
	}
	
	fun removeCounter() {
	
	    if (i >= 0)
	    {
	        //  Removes the timer, starting with the top one and working down
	        game.time.events.remove(timerEvents[i])
	
	        //  Just updates the text
	        text[i].style.fill = "#3344aa"
	        text[i].setText("Counter " + i + " removed")
	        i--
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Queued events: " + game.time.events.length + " - click to remove", 32, 32)
	
	}
}