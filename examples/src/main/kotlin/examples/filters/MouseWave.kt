
package examples.filters


import Phaser.*

class MouseWave: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var filter:Filter
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    //  From http://glslsandbox.com/e#18418.1
	
	    var fragmentSrc = arrayOf(

				"precision mediump float;",

				"uniform float     time;",
				"uniform vec2      resolution;",
				"uniform vec2      mouse;",

				"#define PI 3.1415926535897932384626433832795",

				"float rand(vec2 v)",
				"{",
				"return fract(sin(dot(v.xy,vec2(33.9898,78.233))) * 43758.5453);",
				"}",

				"void main()",
				"{",

				"vec2 pos = (gl_FragCoord.xy / resolution) * 2. - 1.;",

				"float m = mouse.y * 2. - 1.;",

				"float amp = 0.50;          // amplitud",
				"float offset = m * .01 * 50. * time;   // periodo en segundos",

				"vec3 color;",

				"const float wide = 0.5;",

				"for(float n = -wide; n <= wide; n += .05){",

				"float rnd1 = rand(vec2(1.,n));",
				"float rnd2 = rand(vec2(n,1.));",
				"float rnd3 = rand(vec2(n,n));",

				"float r = 0.006 / abs(sin(PI * pos.x * pow(3., rnd1) + offset * rnd1) + ((pos.y + (rnd1 * n)) / amp));",
				"float g = 0.006 / abs(sin(PI * pos.x * pow(3., rnd2) + offset * rnd2) + ((pos.y + (rnd2 * n)) / amp));",
				"float b = 0.006 / abs(sin(PI * pos.x * pow(3., rnd3) + offset * rnd3) + ((pos.y + (rnd3 * n)) / amp));",

				"color += vec3(r, g, b);",

				"}",

				"gl_FragColor = vec4(color, 1);",
				"}"
		)
	
	    filter = Phaser.Filter(game, null, fragmentSrc)
	    filter.setResolution(800, 600)
	
	    sprite = game.add.sprite()
	    sprite.width = 800.0
	    sprite.height = 600.0
	
	    sprite.filters = arrayOf( filter )
	
	}
	
	override fun update() {
	
	    filter.update(game.input.mousePointer)
	
	}
}