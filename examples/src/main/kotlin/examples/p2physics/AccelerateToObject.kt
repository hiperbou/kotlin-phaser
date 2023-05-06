
package examples.p2physics


import Phaser.*

class AccelerateToObject: State() {
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update=update })
	lateinit var bullets:Group
	lateinit var cursors:CursorKeys
	lateinit var ship:Sprite
	override fun preload() {
	    game.load.image("car", "assets/sprites/car.png")
	    game.load.image("tinycar", "assets/sprites/tinycar.png")
	}
	
	override fun create() {
	    game.physics.startSystem(Phaser.Physics.P2JS)
	    bullets = game.add.group()
	    for(i in 0..10-1) {
	        var bullet = bullets.create(game.rnd.integerInRange(200, 1700), game.rnd.integerInRange(-200, 400), "tinycar")
	        game.physics.p2.enable(bullet,false)
	    }
	    cursors = game.input.keyboard.createCursorKeys()
	    ship = game.add.sprite(32, game.world.height - 150, "car")
	    game.physics.p2.enable(ship)
	}
	
	override fun update() {
	    bullets.forEachAlive(this::moveBullets,this)  //make bullets accelerate to ship
	
	    if (cursors.left.isDown) {  ship.body.rotateLeft(100)}   //ship movement
	    else if (cursors.right.isDown){  ship.body.rotateRight(100)}
	    else {  ship.body.setZeroRotation()}
	    if (cursors.up.isDown){  ship.body.thrust(400)}
	    else if (cursors.down.isDown){  ship.body.reverse(400)}
	}
	
	
	fun moveBullets(bullet:Sprite) { 
	     accelerateToObject(bullet,ship,30.0)  //start accelerateToObject on every bullet
	}
	
	fun accelerateToObject(obj1:Sprite, obj2:Sprite, speed:Double = 60.0) {
	    var angle = Math.atan2(obj2.y - obj1.y, obj2.x - obj1.x)
	    obj1.body.rotation = angle + Phaser.Math.degToRad(90)  // correct angle of angry bullets (depends on the sprite used)
	    obj1.body.force.x = Math.cos(angle) * speed    // accelerateToObject 
	    obj1.body.force.y = Math.sin(angle) * speed
	}
}