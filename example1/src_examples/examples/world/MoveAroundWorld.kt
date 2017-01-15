
package examples.world

import Koala.initKoala
import Phaser.*

class MoveAroundWorld: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.stage.backgroundColor = "#007236"
	
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	    game.load.image("phaser", "assets/sprites/sonic_havok_sanity.png")
	
	}
	
	lateinit var cursors:CursorKeys
	lateinit var d:Sprite
	
	override fun create() {
	
	    //  Modify the world and camera bounds
	    // game.world.setBounds(-2000, -2000, 4000, 4000)
	
	    game.world.resize(3000, 600)
	
	    for(i in 0..100-1)
	    {
	        game.add.sprite(game.world.randomX, game.world.randomY, "mushroom")
	    }
	
	    game.add.text(600, 800, "- phaser -", object{ var  font= "32px Arial";  var  fill= "#330088";  var  align= "center" })
	
	    var g = game.add.group()
	    g.x = 500.0
	
	    // d = game.add.sprite(1000, 300, "phaser")
	    d = g.create(100, 300, "phaser")
	    d.anchor.setTo(0.5, 0.5)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    d.angle += 1
	
	    if (cursors.up.isDown)
	    {
	        if (cursors.up.shiftKey)
	        {
	            d.angle++
	        }
	        else
	        {
	            game.camera.y -= 4
	        }
	    }
	    else if (cursors.down.isDown)
	    {
	        if (cursors.down.shiftKey)
	        {
	            d.angle--
	        }
	        else
	        {
	            game.camera.y += 4
	        }
	    }
	
	    if (cursors.left.isDown)
	    {
	        if (cursors.left.shiftKey)
	        {
	            game.world.rotation -= 0.05
	        }
	        else
	        {
	            game.camera.x -= 4
	        }
	    }
	    else if (cursors.right.isDown)
	    {
	        if (cursors.right.shiftKey)
	        {
	            game.world.rotation += 0.05
	        }
	        else
	        {
	            game.camera.x += 4
	        }
	    }
	
	}
	
	override fun render() {
	
	    game.debug.cameraInfo(game.camera, 32, 32)
	
	}
}