
package examples.world


import Phaser.*

class WorldWrap: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("backdrop", "assets/pics/remember-me.jpg")
	    game.load.image("card", "assets/sprites/mana_card.png")
	
	}
	
	lateinit var card:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.world.setBounds(0, 0, 1920, 1200)
	
	    game.add.sprite(0, 0, "backdrop")
	
	    card = game.add.sprite(200, 200, "card")
	
	    game.camera.follow(card)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	        card.x -= 4
	    }
	    else if (cursors.right.isDown)
	    {
	        card.x += 4
	    }
	
	    if (cursors.up.isDown)
	    {
	        card.y -= 4
	    }
	    else if (cursors.down.isDown)
	    {
	        card.y += 4
	    }
	
	    game.world.wrap(card, 0, true)
	
	}
	
	override fun render() {
	
	    game.debug.cameraInfo(game.camera, 500, 32)
	    game.debug.spriteCoords(card, 32, 32)
	
	}
}