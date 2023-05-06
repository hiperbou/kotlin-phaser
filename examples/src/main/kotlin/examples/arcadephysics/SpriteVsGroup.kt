
package examples.arcadephysics


import Phaser.*

class SpriteVsGroup: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser-dude.png")
	    game.load.spritesheet("veggies", "assets/sprites/fruitnveg32wh37.png", 32, 32)
	
	}
	
	lateinit var sprite:Sprite
	lateinit var group:Group
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    sprite = game.add.sprite(32, 200, "phaser")
	
	    game.physics.arcade.enable(sprite)
	    
	    group = game.add.physicsGroup()
	
	    for(i in 0..50-1)
	    {
	        var c = group.create(game.rnd.between(100, 770), game.rnd.between(0, 570), "veggies", game.rnd.between(0, 35))
	        c.body.mass = -100
	    }
	
	    for(i in 0..20-1)
	    {
	        var c = group.create(game.rnd.between(100, 770), game.rnd.between(0, 570), "veggies", 17)
	    }
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    if (game.physics.arcade.collide(sprite, group, this::collisionHandler, this::processHandler, this))
	    {
	        console.log("boom")
	    }
	
	    // game.physics.arcade.overlap(sprite, group, this::collisionHandler, null, this)
	
	    sprite.body.velocity.x = 0
	    sprite.body.velocity.y = 0
	
	    if (cursors.left.isDown)
	    {
	        sprite.body.velocity.x = -200
	    }
	    else if (cursors.right.isDown)
	    {
	        sprite.body.velocity.x = 200
	    }
	
	    if (cursors.up.isDown)
	    {
	        sprite.body.velocity.y = -200
	    }
	    else if (cursors.down.isDown)
	    {
	        sprite.body.velocity.y = 200
	    }
	
	}
	
	fun processHandler (player:Sprite, veg:Sprite):Boolean {
	
	    return true
	
	}
	
	fun collisionHandler (player:Sprite, veg:Sprite) {
	
	    if (veg.frame == 17)
	    {
	        veg.kill()
	    }
	
	}
}