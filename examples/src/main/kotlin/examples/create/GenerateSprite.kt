
package examples.create


import Phaser.*

class GenerateSprite: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var player:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    //  This sprite was created with the Phaser Gen Paint app
	    //  also available in the Phaser Examples repo and on the Phaser site.
	
	    var dudeData = arrayOf(
	        ".......3.....",
	        "......333....",
	        "....5343335..",
	        "...332333333.",
	        "..33333333333",
	        "..37773337773",
	        "..38587778583",
	        "..38588888583",
	        "..37888888873",
	        "...333333333.",
	        ".F....5556...",
	        "3E34.6757.6..",
	        ".E.55.666.5..",
	        "......777.5..",
	        ".....6..7....",
	        ".....7..7...."
	    )
	
	    game.create.texture("phaserDude", dudeData, 4, 4, 0)
	
	    player = game.add.sprite(300, 300, "phaserDude")
	    player.anchor.set(0.5)
	
	    game.physics.arcade.enable(player)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    player.body.velocity.x = 0.0
	    player.body.velocity.y = 0.0
	
	    if (cursors.left.isDown)
	    {
	        player.body.velocity.x = -200.0
	        player.scale.x = 1.0
	    }
	    else if (cursors.right.isDown)
	    {
	        player.body.velocity.x = 200.0
	        player.scale.x = -1.0
	    }
	
	    if (cursors.up.isDown)
	    {
	        player.body.velocity.y = -200.0
	    }
	    else if (cursors.down.isDown)
	    {
	        player.body.velocity.y = 200.0
	    }
	
	}
}