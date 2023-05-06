
package examples.camera


import Phaser.*

class WorldSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("backdrop", "assets/pics/remember-me.jpg")
	    game.load.image("card", "assets/sprites/mana_card.png")
	
	}
	
	lateinit var card:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.forceSingleUpdate = true
	
	    game.world.setBounds(0, 0, 1920, 1200)
	
	    game.add.sprite(0, 0, "backdrop")
	
	    card = game.add.sprite(200, 200, "card")
	    card.anchor.set(0.5)
	
	    game.physics.enable(card, Phaser.Physics.ARCADE)
	    card.body.collideWorldBounds = true
	
	    game.camera.follow(card)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    card.body.velocity.x = 0.0
	    card.body.velocity.y = 0.0
	
	    if (cursors.left.isDown)
	    {
	        // card.x -= 4
	        card.body.velocity.x = -240.0
	    }
	    else if (cursors.right.isDown)
	    {
	        // card.x += 4
	        card.body.velocity.x = 240.0
	    }
	
	    if (cursors.up.isDown)
	    {
	        // card.y -= 4
	        card.body.velocity.y = -240.0
	    }
	    else if (cursors.down.isDown)
	    {
	        // card.y += 4
	        card.body.velocity.y = 240.0
	    }
	
	}
	
	override fun render() {
	
	    game.debug.cameraInfo(game.camera, 500, 32)
	    game.debug.spriteCoords(card, 32, 32)
	
	    game.debug.rectangle(object{ var x=400+game.camera.x;  var y=0+game.camera.y;  var width=1;  var height=600})
	    game.debug.rectangle(object{ var x=0+game.camera.x;  var y=300+game.camera.y;  var width=800;  var height=1})
	
	}
}