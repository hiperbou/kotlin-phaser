
package examples.tweens


import Phaser.*
import Phaser.Math.Companion.linearInterpolation

class Interpolation: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.WEBGL, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("logo", "assets/sprites/phaser2.png")
	    
	}
	
	lateinit var logo:Sprite
	lateinit var text:Text
	lateinit var tween:Tween
	var method = 0
	
	override fun create() {
	
	    logo = add.sprite(0, 0, "logo")
	    logo.scale.set(0.5)
	
	    var style = TextStyle( font= "48px Arial", fill= "#ff0044", align= "center" )
	    text = game.add.text(game.world.centerX, game.world.centerY, "Linear Interpolation", style)
	    text.anchor.set(0.5)
	
	    var w = game.width - logo.width
	    var h = game.height - logo.height
	
	    //  You can tween between an array of values by defining an array as the destination value
	    //  It will tween through them using the interpolation fun (default is linear)
	    //  The -1 at the end just makes the tween repeat forever.
	
	    tween = game.add.tween(logo).to( object  { var x = arrayOf(w, w, 0, 0); var y = arrayOf(0, h, h, 0) }, 4000, "Sine.easeInOut", true, -1, 0)
	
	    tween.onLoop.add(this::changeMethod, this)
	
	}
	
	fun changeMethod() {
	
	    method++
	
	    if (method === 1)
	    {
	        tween.interpolation(Phaser.Math.Companion::bezierInterpolation)
	        text.text = "Bezier Interpolation"
	    }
	    else if (method === 2)
	    {
	        tween.interpolation(Phaser.Math.Companion::catmullRomInterpolation)
	        text.text = "CatmullRom Interpolation"
	    }
	    else if (method === 3)
	    {
	        method = 0
	        tween.interpolation(Phaser.Math.Companion::linearInterpolation)
	        text.text = "Linear Interpolation"
	    }
	
	}
}