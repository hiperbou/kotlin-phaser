
package examples.animation

import Koala.initKoala
import Phaser.*

class DestroyAnimation: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", { preload: preload, create: create, update: update, render: render })
	
	override fun preload() {
	
	    game.load.spritesheet("mummy", "assets/sprites/metalslug_mummy37x45.png", 37, 45, 18)
	
	}
	
	lateinit var sprites:Group
	var rip = 0
	
	override fun create() {
	
	    sprites = game.add.group()
	
	    game.time.events.loop(50, this::createSprite, this)
	
	}
	
	fun createSprite() {
	
	    var mummy = sprites.create<Sprite>(0, game.world.randomY, "mummy")
	
	    mummy.animations.add("walk")
	
	    mummy.play("walk", 10, true)
	
	}
	
	override fun update() {
	
	    sprites.setAll("x", 10, true, true, 1)
	
	    sprites.forEach(this::checkSprite, this, true)
	
	}
	
	fun checkSprite(sprite:Sprite) {
	
	    try {
	        if (sprite.x > game.width)
	        {
	            rip++
	            sprites.remove(sprite, true)
	        }
	    }
	    catch (e:Exception)
	    {
	        console.log(sprite)
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Group size: " + sprites.total, 32, 32)
	    game.debug.text("Destroyed: " + rip, 32, 64)
	
	}
}