
package examples.filters


import Phaser.*

class MouseRay: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var filter:Filter
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    //  From http://glslsandbox.com/e#20326.0
	
	    var fragmentSrc = arrayOf(
				"precision mediump float;",

				"uniform float     time;",
				"uniform vec2      resolution;",
				"uniform vec2      mouse;",

				"float rand(int seed, float ray) {",
				"return mod(sin(float(seed)*1.0+ray*1.0)*1.0, 1.0);",
				"}",

				"void main( void ) {",
				"float pi = 3.14159265359;",
				"vec2 position = ( gl_FragCoord.xy / resolution.xy ) - mouse;",
				"position.y *= resolution.y/resolution.x;",
				"float ang = atan(position.y, position.x);",
				"float dist = length(position);",
				"gl_FragColor.rgb = vec3(0.5, 0.5, 0.5) * (pow(dist, -1.0) * 0.05);",
				"for (float ray = 0.0; ray < 18.0; ray += 1.0) {",
				"//float rayang = rand(5234, ray)*6.2+time*5.0*(rand(2534, ray)-rand(3545, ray));",
				"//float rayang = time + ray * (1.0 * (1.0 - (1.0 / 1.0)));",
				"float rayang = (((ray) / 9.0) * 3.14) + (time * 0.1            );",
				"rayang = mod(rayang, pi*2.0);",
				"if (rayang < ang - pi) {rayang += pi*2.0;}",
				"if (rayang > ang + pi) {rayang -= pi*2.0;}",
				"float brite = 0.3 - abs(ang - rayang);",
				"brite -= dist * 0.2;",
				"if (brite > 0.0) {",
				"gl_FragColor.rgb += vec3(sin(ray*mouse.y+0.0)+1.0, sin(ray*mouse.y+2.0)+1.0, sin(ray*mouse.y+4.0)+1.0) * brite;",
				"}",
				"}",
				"gl_FragColor.a = 1.0;",
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
	
	    filter.update(game.input.activePointer)
	
	}
}