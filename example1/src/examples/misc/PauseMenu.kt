
package examples.misc

import Koala.initKoala
import Phaser.*

class PauseMenu: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	var w = 800
	var h = 600
	lateinit var emitter:Particles.Arcade.Emitter
	lateinit var pause_label:Text
	lateinit var choiseLabel:Text
	lateinit var menu:Sprite

	override fun preload() {
	    game.load.image("diamond", "assets/sprites/diamond.png")
	    game.load.image("menu", "assets/buttons/number-buttons-90x90.png", 270, 180)
	}
	
	override fun create() {
	    /*
	        Code from example diamond burst
	    */
	    game.stage.backgroundColor = "#337799"
	    emitter = game.add.emitter(game.world.centerX, 100, 200)
	    emitter.makeParticles("diamond")
	    emitter.start(false, 5000, 20)
	
	
	    /*
	        Code for the pause menu
	    */
	
	    // Create a label to use as a button
	    pause_label = game.add.text(w - 100, 20, "Pause", object{ var  font= "24px Arial";  var  fill= "#fff" })
	    pause_label.inputEnabled = true
	    pause_label.events.onInputUp.add( {p->
	        // When the paus button is pressed, we pause the game
	        game.paused = true
	
	        // Then add the menu
	        menu = game.add.sprite(w/2, h/2, "menu")
	        menu.anchor.setTo(0.5, 0.5)
	
	        // And a label to illustrate which menu item was chosen. (This is not necessary)
	        choiseLabel = game.add.text(w/2, h-150, "Click outside menu to continue", object{ var  font= "30px Arial";  var  fill= "#fff" })
	        choiseLabel.anchor.setTo(0.5, 0.5)
	    })
	
	    // Add a input listener that can help us return from being paused
	    game.input.onDown.add(this::unpause)
	}

	// And finally the method that handels the pause menu
	fun unpause(event:Pointer){
		// Only act if paused
		if(game.paused){
			// Calculate the corners of the menu
			var x1 = w/2 - 270/2
			var x2 = w/2 + 270/2
			var y1 = h/2 - 180/2
			var y2 = h/2 + 180/2

			// Check if the click was inside the menu
			if(event.x > x1 && event.x < x2 && event.y > y1 && event.y < y2 ){
				// The choicemap is an array that will help us see which item was clicked
				var choisemap = mutableListOf("one", "two", "three", "four", "five", "six")

				// Get menu local coordinates for the click
				var x = event.x - x1
				var y = event.y - y1

				// Calculate the choice
				var choise = Math.floor(x / 90) + 3*Math.floor(y / 90)

				// Display the choice
				choiseLabel.text = "You chose menu item: " + choisemap[choise]
			}
			else{
				// Remove the menu and the label
				menu.destroy()
				choiseLabel.destroy()

				// Unpause the game
				game.paused = false
			}
		}
	}
	
}