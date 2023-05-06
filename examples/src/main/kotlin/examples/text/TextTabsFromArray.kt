
package examples.text


import Phaser.*

class TextTabsFromArray: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	lateinit var text:Text
	
	override fun preload() {
	
	    game.load.image("bg", "assets/skies/deepblue.png")
	
	}
	
	override fun create() {
	
	    game.add.image(0, 0, "bg")
	
	    var style = object{ var  font= "16px Courier";  var  fill= "#fff";  var  tabs= arrayOf( 164,120,80 ) }
	
	    var headings = arrayOf( "Name", "Damage", "Speed", "Notes" )
	
	    text = game.add.text(32, 64, "", style)
	    text.parseList(headings)
	
	    var swords = arrayOf(
				arrayOf( "Knife", "1d3", "1", "" ),
				arrayOf( "Dagger", "1d4", "1", "May be thrown" ),
				arrayOf( "Rapier", "1d6", "2", "Max strength damage bonus +1" ),
				arrayOf( "Sabre", "1d6", "3", "Max strength damage bonus +3" ),
				arrayOf( "Cutlass", "1d6", "5", "" ),
				arrayOf( "Scimitar", "2d4", "4", "" ),
				arrayOf( "Long Sword", "1d8+1", "6", "" ),
				arrayOf( "Bastard Sword", "1d10+1", "8", "Requires 2 hands to use effectively" ),
				arrayOf( "Great Sword", "1d12+1", "10", "Must always be used with 2 hands")
		)
	
	    var text2 = game.add.text(32, 120, "", style)
	    text2.parseList(swords)
	
	}
}