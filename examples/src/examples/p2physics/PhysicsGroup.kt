
package examples.p2physics


import Phaser.*

class PhysicsGroup: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("ball", "assets/sprites/pangball.png")
	
	}
	
	override fun create() {
	
	    //  Enable p2 physics
	    game.physics.startSystem(Phaser.Physics.P2JS)
	
	    game.stage.backgroundColor = "#124184"
	
	    game.physics.p2.gravity.y = 100
	    game.physics.p2.restitution = 1.0
	
	    var group = game.add.physicsGroup(Phaser.Physics.P2JS)
	
	    for(i in 0..32-1)
	    {
	        var ball = group.create(game.world.randomX, game.rnd.between(0, 100), "ball")
	        ball.body.setCircle(16)
	        ball.body.fixedRotation = true
	    }
	
	}
}