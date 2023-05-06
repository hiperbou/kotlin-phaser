
package examples.filters


import Phaser.*

class Vortex: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("metal", "assets/textures/metal.png")
	
	}
	
	lateinit var filter:Filter
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    //  Shader by GhettoWolf (https://www.shadertoy.com/view/Xdl3WH)
	
	    var fragmentSrc = arrayOf(
				"precision mediump float;",

				"uniform float     time;",
				"uniform vec2      resolution;",
				"uniform sampler2D iChannel0;",

				"#ifdef GL_ES",
				"precision highp float;",
				"#endif",

				"#define PI 3.1416",

				"void main( void ) {",

				"//map the xy pixel co-ordinates to be between -1.0 to +1.0 on x and y axes",
				"//and alter the x value according to the aspect ratio so it isn't 'stretched'",

				"vec2 p = (2.0 * gl_FragCoord.xy / resolution.xy - 1.0) * vec2(resolution.x / resolution.y, 1.0);",

				"//now, this is the usual part that uses the formula for texture mapping a ray-",
				"//traced cylinder using the vector p that describes the position of the pixel",
				"//from the centre.",

				"vec2 uv = vec2(atan(p.y, p.x) * 1.0/PI, 1.0 / sqrt(dot(p, p))) * vec2(2.0, 1.0);",

				"//now this just 'warps' the texture read by altering the u coordinate depending on",
				"//the val of the v coordinate and the current time",

				"uv.x += sin(2.0 * uv.y + time * 0.5);",

				"//this divison makes the color value 'darker' into the distance, otherwise",
				"//everything will be a uniform brightness and no sense of depth will be present.",

				"vec3 c = texture2D(iChannel0, uv).xyz / (uv.y * 0.5 + 1.0);",

				"gl_FragColor = vec4(c, 1.0);",

				"}"
		)
	
	    //  Texture must be power-of-two sized or the filter will break
	    sprite = game.add.sprite(0, 0, "metal")
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