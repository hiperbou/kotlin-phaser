
package examples.sprites


import Phaser.*

class CollideWorldBounds: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	    game.load.image("pineapple", "assets/sprites/pineapple.png")
	
	}
	
	lateinit var pineapples:Group
	
	override fun create() {
	
	    pineapples = game.add.group()
	    pineapples.enableBody = true
	    pineapples.physicsBodyType = Phaser.Physics.ARCADE
	
	    for(i in 0..10-1)
	    {
	        var pineapple = pineapples.create(200 + i * 48,50, "pineapple")
	
	        //This allows your sprite to collide with the world bounds like they were rigid objects
	        pineapple.body.collideWorldBounds=true
	        pineapple.body.gravity.x = game.rnd.integerInRange(-50, 50).toDouble()
	        pineapple.body.gravity.y = 100 + Math.random() * 100
	        pineapple.body.bounce.setTo(0.9, 0.9)
	    }
	
	}
}