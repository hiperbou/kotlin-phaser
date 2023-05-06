
package examples.text


import Phaser.*

class TextTabs: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	lateinit var text:Text
	
	override fun preload() {
	
	    game.load.image("bg", "assets/skies/deepblue.png")
	
	}
	
	override fun create() {
	
	    game.add.image(0, 0, "bg")
	
	    //  You can either set the tab size in the style object:
	    var style = TextStyle( font= "20px Courier", fill= "#fff", tabs= 132 )
	
	    text = game.add.text(100, 64, "Armor\tSpells\tDamage\tWeapons", style)
	
	    //  Or you can modify the tabs property directly:
	    // text.tabs = 132
	
	    var text2 = game.add.text(100, 120, "100\tFire\t+50\tAxe\n67\tIce\t+23\tStaff", style)
	
	}
}