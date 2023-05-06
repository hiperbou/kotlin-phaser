
package examples.filters


import Phaser.*

class Fireball: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var filter:Filter
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    //  From http://glslsandbox.com/e#20112.1
	
	    var fragmentSrc = arrayOf(
				"precision mediump float;",

				"uniform float     time;",
				"uniform vec2      resolution;",
				"uniform vec2      mouse;",

				"// Yuldashev Mahmud Effect took from shaderToy mahmud9935@gmail.com",

				"float snoise(vec3 uv, float res)",
				"{",
				"const vec3 s = vec3(1e0, 1e2, 1e3);",

				"uv *= res;",

				"vec3 uv0 = floor(mod(uv, res))*s;",
				"vec3 uv1 = floor(mod(uv+vec3(1.), res))*s;",

				"vec3 f = fract(uv); f = f*f*(3.0-2.0*f);",

				"vec4 v = vec4(uv0.x+uv0.y+uv0.z, uv1.x+uv0.y+uv0.z,",
				"uv0.x+uv1.y+uv0.z, uv1.x+uv1.y+uv0.z);",

				"vec4 r = fract(sin(v*1e-1)*1e3);",
				"float r0 = mix(mix(r.x, r.y, f.x), mix(r.z, r.w, f.x), f.y);",

				"r = fract(sin((v + uv1.z - uv0.z)*1e-1)*1e3);",
				"float r1 = mix(mix(r.x, r.y, f.x), mix(r.z, r.w, f.x), f.y);",

				"return mix(r0, r1, f.z)*2.-1.;",
				"}",

				"void main( void ) {",

				"vec2 p = -.5 + gl_FragCoord.xy / resolution.xy;",
				"p.x *= resolution.x/resolution.y;",

				"float color = 3.0 - (3.*length(2.*p));",

				"vec3 coord = vec3(atan(p.x,p.y)/6.2832+.5, length(p)*.4, .5);",

				"for(int i = 1; i <= 7; i++)",
				"{",
				"float power = pow(2.0, float(i));",
				"color += (1.5 / power) * snoise(coord + vec3(0.,-time*.05, time*.01), power*16.);",
				"}",

				"gl_FragColor = vec4( color, pow(max(color,0.),2.)*0.4, pow(max(color,0.),3.)*0.15 , 1.0);",

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
	
	    filter.update()
	
	}
}