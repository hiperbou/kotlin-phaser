
package examples.filters


import Phaser.*

class Rotozoomer: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("texture", "assets/pics/lance-overdose-loader_eye.png")
	
	}
	
	lateinit var filter:Filter
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    //  Shader by triggerHLM (https://www.shadertoy.com/view/lsfGDH)
	
	    var fragmentSrc = arrayOf(
				"precision mediump float;",

				"uniform float     time;",
				"uniform vec2      resolution;",
				"uniform sampler2D iChannel0;",

				"float speed = time * 0.2;",
				"float pi = 3.14159265;",

				"void main( void ) {",

				"vec2 position = vec2(640.0/2.0+640.0/2.0*sin(speed*2.0), 360.0/2.0+360.0/2.0*cos(speed*3.0));",
				"vec2 position2 = vec2(640.0/2.0+640.0/2.0*sin((speed+2000.0)*2.0), 360.0/2.0+360.0/2.0*cos((speed+2000.0)*3.0));",

				"vec2 offset = vec2(640.0/2.0, 360.0/2.0) ;",
				"vec2 offset2 = vec2(6.0*sin(speed*1.1), 3.0*cos(speed*1.1));",

				"vec2 oldPos = (gl_FragCoord.xy-offset);",

				"float angle = speed*2.0;",

				"vec2 newPos = vec2(oldPos.x *cos(angle) - oldPos.y *sin(angle),",
				"oldPos.y *cos(angle) + oldPos.x *sin(angle));",

				"newPos = (newPos)*(0.0044+0.004*sin(speed*3.0))-offset2;",
				"vec2 temp = newPos;",
				"newPos.x = temp.x + 0.4*sin(temp.y*2.0+speed*8.0);",
				"newPos.y = (-temp.y + 0.4*sin(temp.x*2.0+speed*8.0));",
				"vec4 final = texture2D(iChannel0,newPos);",
				"//final = texture2D(texCol,gl_FragCoord.xy*vec2(1.0/640, -1.0/360));",
				"gl_FragColor = vec4(final.xyz, 1.0);",

				"}"
		)
	
	    sprite = game.add.sprite(0, 0, "texture")
	    sprite.width = 800.0
	    sprite.height = 600.0
	
	    var customUniforms = object {
	        var iChannel0 = object{ var type= "sampler2D"
				var value = sprite.texture
				var textureData = object{ var  repeat= true } }
	    }
	
	    filter = Phaser.Filter(game, customUniforms, fragmentSrc)
	    filter.setResolution(800, 600)
	
	    sprite.filters = arrayOf( filter )
	
	}
	
	override fun update() {
	
	    filter.update()
	
	}
}