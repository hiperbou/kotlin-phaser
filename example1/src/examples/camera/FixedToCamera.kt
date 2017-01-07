
package examples.camera

import Koala.initKoala
import Phaser.*

class FixedToCamera: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render = render })
	
	override fun preload() {
	
	    game.stage.backgroundColor = "#007236"
	
	    game.load.image("mushroom", "assets/sprites/mushroom2.png")
	    game.load.image("sonic", "assets/sprites/sonic_havok_sanity.png")
	    game.load.image("phaser", "assets/sprites/phaser1.png")
	
	}
	
	lateinit var cursors:CursorKeys
	lateinit var logo1:Sprite
	lateinit var logo2:Sprite
	
	override fun create() {
	
	    //  Modify the world and camera bounds
	    game.world.resize(6000, 600)
	
	    for(i in 0..200-1)
	    {
	        game.add.sprite(game.world.randomX, game.world.randomY, "mushroom")
	    }
	
	    game.add.text(32, 32, "this text is on the background\nuse arrows to scroll", object{ var  font= "32px Arial";  var  fill= "#f26c4f";  var  align= "left" })
	
	    logo1 = game.add.sprite(100, 300, "phaser")
	    logo1.fixedToCamera = true
	
	    logo2 = game.add.sprite(500, 100, "phaser")
	    logo2.fixedToCamera = true
	
	    var t = game.add.text(200, 500, "this text is fixed to the camera", object{ var  font= "32px Arial";  var  fill= "#ffffff";  var  align= "center" })
	    t.fixedToCamera = true
	    t.cameraOffset.setTo(200, 500)
	
	    game.add.tween(logo2.cameraOffset).to( object{ var  y= 400 }, 2000, Phaser.Easing.Back::InOut, true, 0, 2000, true)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	        game.camera.x -= 4
	    }
	    else if (cursors.right.isDown)
	    {
	        game.camera.x += 4
	    }
	
	}
	
	override fun render() {
	
	    // game.debug.cameraInfo(game.camera, 32, 32)
	
	}
}