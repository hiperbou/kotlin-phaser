
package examples.sprites

import Koala.initKoala
import Phaser.*

class Pivot: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("arrow", "assets/sprites/arrow.png")
	
	}
	
	lateinit var arrow1:Sprite
	lateinit var arrow2:Sprite
	lateinit var arrow3:Sprite
	lateinit var arrow4:Sprite
	
	override fun create() {
	
	    game.stage.backgroundColor = "#3e5f96"
	
	    arrow1 = game.add.sprite(200, 150, "arrow")
	    arrow1.pivot.x = 100.0
	
	    arrow2 = game.add.sprite(600, 150, "arrow")
	    arrow2.pivot.y = 100.0
	
	    arrow3 = game.add.sprite(200, 450, "arrow")
	    arrow3.pivot.x = 100.0
	    arrow3.pivot.y = 100.0
	
	    arrow4 = game.add.sprite(600, 450, "arrow")
	    arrow4.pivot.x = 100.0
	    arrow4.anchor.set(0.5)
	
	}
	
	override fun update() {
	
	    arrow1.rotation += 0.05
	    arrow2.rotation += 0.05
	    arrow3.rotation += 0.05
	    arrow4.rotation += 0.05
	
	}
	
	override fun render() {
	
	    game.debug.geom(Phaser.Point(arrow1.x, arrow1.y), "#ffff00")
	    game.debug.geom(Phaser.Point(arrow2.x, arrow2.y), "#ffff00")
	    game.debug.geom(Phaser.Point(arrow3.x, arrow3.y), "#ffff00")
	    game.debug.geom(Phaser.Point(arrow4.x, arrow4.y), "#ffff00")
	
	}
}