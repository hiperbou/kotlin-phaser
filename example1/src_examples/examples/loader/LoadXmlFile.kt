
package examples.loader


import Phaser.*

class LoadXmlFile: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    //  Phaser can load XML files.
	
	    //  It does this using an XMLHttpRequest.
	    
	    //  If loading a file from outside of the domain in which the game is running 
	    //  a "Access-Control-Allow-Origin" header must be present on the server.
	    //  No parsing of the text file is performed, it"s literally just the raw data.
	
	    game.load.xml("octopus", "assets/sprites/octopus.xml")
	
	}
	
	lateinit var text:Text
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0072bc"
	
	    var xml = game.cache.getXML("octopus")
	
	    console.log(xml)
	
	    // text = xml.split("\n")
	
	}
	
	override fun render() {
	
	    for(i in 0..30-1)
	    {
	        // game.debug.text(text[i], 32, i * 20)
	    }
	
	}
}