
package examples.create


import Phaser.*

class RatAttack: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var rats:Group
	lateinit var player:Sprite
	lateinit var cursors:CursorKeys
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    //  These sprites were created with the Phaser Gen Paint app
	    //  also available in the Phaser Examples repo and on the Phaser site.
	
	    var endData = arrayOf(
	        "2222"
	    )
	
	    game.create.texture("endTexture", endData, 1, 1, 1)
	
	    var ratData = arrayOf(
	        ".D...........",
	        "18...........",
	        "1D...........",
	        "18.....1111..",
	        "1D..111DDEE1.",
	        "1811EEE18E0E1",
	        ".1DEEEEEEEEED",
	        "..1EEEEEE41..",
	        ".11E41E1411..",
	        "1111E1E1E111.",
	        ".1111111111.."
	    )
	
	    game.create.texture("ratTexture", ratData, 4, 4, 4)
	
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
	
	    //  Now we"ve got our textures let"s just make some sprites
	
	    var end = game.add.sprite(0, 600-64, "endTexture")
	    end.width = 800.0
	    end.height = 64.0
	
	    rats = game.add.physicsGroup()
	
	    var y = 80
	
	    for(i in 0..9-1)
	    {
	        var rat = rats.create(game.world.randomX, y, "ratTexture")
	        rat.body.velocity.x = game.rnd.between(100, 300).toDouble()
	        y += 48
	    }
	
	    player = game.add.sprite(400, 32, "phaserDude")
	    player.anchor.set(0.5)
	
	    game.physics.arcade.enable(player)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    rats.forEach(this::checkPos, this)
	
	    game.physics.arcade.overlap(player, rats, this::collisionHandler, null, this)
	
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
	
	fun checkPos(rat:Sprite) {
	
	    if (rat.x > 800)
	    {
	        rat.x = -100.0
	    }
	
	}
	
	fun collisionHandler (player:Sprite, rat:Sprite) {
	
	    player.x = 400.0
	    player.y = 320.0
	
	}
}