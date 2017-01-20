
package examples.loader


import Phaser.*

class LoadJsonFile: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    //  Phaser can load JSON files.
	
	    //  It does this using an XMLHttpRequest.
	    
	    //  If loading a file from outside of the domain in which the game is running 
	    //  a "Access-Control-Allow-Origin" header must be present on the server.
	
	    game.load.json("version", "http://phaser.io/version.json")
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0072bc"
	
	    var phaserJSON = game.cache.getJSON("version")
	
	    var text = game.add.text(100, 100, "Current Phaser version: " + phaserJSON.version, object{ var  fill= "#ffffff" })
	    text.setShadow(2, 2, "rgba(0,0,0,0.5)", 0)
	
	    var text2 = game.add.text(100, 200, "Name: " + phaserJSON.name, object{ var  fill= "#ffffff" })
	    text2.setShadow(2, 2, "rgba(0,0,0,0.5)", 0)
	
	    var text3 = game.add.text(100, 300, "Released: " + phaserJSON.released, object{ var  fill= "#ffffff" })
	    text3.setShadow(2, 2, "rgba(0,0,0,0.5)", 0)
	
	}
}