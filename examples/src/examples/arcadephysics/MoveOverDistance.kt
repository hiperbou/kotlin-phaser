
package examples.arcadephysics


import Phaser.*

class MoveOverDistance: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("clown", "assets/sprites/clown.png")
	    game.load.image("block", "assets/sprites/block.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var block:Sprite
	var startTime = 0.0
	var endTime = 0.0
	var duration = 0.0
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    sprite = game.add.sprite(200, 300, "clown")
	    block = game.add.sprite(600, 280, "block")
	
	    game.physics.arcade.enable(sprite)
	    game.physics.arcade.enable(block)
	
	    sprite.body.bounce.set(1)
	    sprite.body.collideWorldBounds = true
	
	    block.body.immovable = true
	
	    sprite.body.onMoveComplete.add(this::moveOver, this)
	
	    game.input.onDown.add(this::move, this)
	
	}
	
	fun move() {
	
	    //  Move the Body 300 pixels to the right, over 2000 ms
	    sprite.body.moveTo(2000, 300, Phaser.ANGLE_RIGHT)
	
	    // sprite.body.stopVelocityOnCollide = false
	    // sprite.body.moveTo(Phaser.ANGLE_RIGHT, 2000, 400)
	
	    // sprite.body.moveFrom(2000, 100, Phaser.ANGLE_RIGHT)
	    // sprite.body.moveFrom(2000, 100, 300)
	
	    startTime = game.time.time
	    duration = 0.0
	
	}
	
	fun moveOver() {
	
	    // sprite.body.move(Phaser.ANGLE_LEFT, 400, 3000, moveCallback, this)
	
	    endTime = game.time.time
	    duration = endTime - startTime
	
	}
	
	fun moveCallback(body:Sprite, velocity:Point, percent:Double) {
	
	    velocity.y = -200 + (Math.sin(percent) * 400)
	
	}
	
	override fun update() {
	
	    game.physics.arcade.collide(sprite, block)
	
	}
	
	override fun render() {
	
	    game.debug.text("expire: " + sprite.body.moveTimer, 32, 32)
	    game.debug.text("vx: " + sprite.body.velocity.x, 300, 32)
	    game.debug.text("vy: " + sprite.body.velocity.y, 600, 32)
	    game.debug.text("duration: " + duration, 32, 64)
	    game.debug.text("m: " + sprite.body.isMoving, 300, 64)
	    game.debug.text("sx: 200", 32, 96)
	
	}
	
}