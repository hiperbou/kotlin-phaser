
package examples.display


import Phaser.*

class RenderTextureRotation: State() {
	
	// //var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("diver", "assets/sprites/treasure_trap.png")
	    game.load.image("ball", "assets/sprites/spinObj_01.png")
	
	}
	
	lateinit var sprite:Sprite
	lateinit var sprite2:Sprite
	lateinit var conair:Group
	lateinit var texture:RenderTexture
	
	override fun create() {
	
	    texture = game.add.renderTexture(game.width, game.height)
	    game.add.sprite(0, 0, texture)
	
	    conair = game.add.group()
	    sprite = conair.create(256, 256, "diver")
	    sprite.anchor.set(0.5)
	
	    sprite2 = game.make.sprite(200, 200, "ball")
	    sprite2.anchor.set(0.5)
	
	    game.add.tween(sprite.scale).to( object{ var  x= 0.2;  var  y= 0.2 }, 2000, "Sine.easeInOut", true, 500, -1, true)
	
	    game.input.onDown.add(this::drawSprite, this)
	
	    game.add.text(32, 32, "Click to draw Sprite", TextStyle(font="24px Arial",fill="#ffffff" ))
	
	}
	
	fun drawSprite() {
	
	    texture.render(conair)
	    texture.renderXY(sprite2)
	
	}
	
	override fun update() {
	
	    sprite.rotation += 0.01
	    sprite2.rotation += 0.01
	
	    sprite.x = game.input.activePointer.x
	    sprite.y = game.input.activePointer.y
	
	}
}