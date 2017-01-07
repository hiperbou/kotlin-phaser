
package examples.filters

import Koala.initKoala
import Phaser.*

class Basic: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.image("metal", "assets/textures/metal.png")
	
	}
	
	lateinit var filter:Filter
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    var fragmentSrc = arrayOf(

				"precision mediump float;",

				"varying vec2 vTextureCoord;",
				"uniform sampler2D uSampler;",

				"void main(void) {",

				"vec4 texColor = texture2D(uSampler, vTextureCoord);",

				"if (vTextureCoord.x < 0.1) {",
				"texColor = vec4(1.0, 0.0, 1.0, 1.0);",
				"}",

				"gl_FragColor = texColor;",

				"}"
		)
	
	    //  Texture must be power-of-two sized or the filter will break
	    sprite = game.add.sprite(0, 0, "metal")
	
	    filter = Phaser.Filter(game, null, fragmentSrc)
	
	    sprite.filters = arrayOf( filter )
	
	}
}