
package examples.filters

import Koala.initKoala
import Phaser.*

class Dotwave: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var filter:Filter
	
	override fun create() {
	
	    var fragmentSrc = arrayOf(


				"precision mediump float;",

				"uniform vec2      resolution;",
				"uniform float     time;",

				"#define PI 90",

				"void main( void ) {",

				"vec2 p = ( gl_FragCoord.xy / resolution.xy ) - 0.0;",

				"float sx = 0.5 + 0.5 * sin( 100.0 * p.x - 1. * pow(time, 0.5)*5.) * sin( 5.0 * p.x - 1. * pow(time, 0.9)*5.);",

				"float dy = 1.0/ ( 1000. * abs(p.y - sx));",

				"dy += 1./ (25. * length(p - vec2(p.x, 0.)));",

				"gl_FragColor = vec4( (p.x + 0.3) * dy, 0.3 * dy, dy, 1.1 );",

				"}")
	
	    filter = Phaser.Filter(game, null, fragmentSrc)
	    filter.setResolution(800, 600)
	
	    var sprite = game.add.sprite()
	    sprite.width = 800.0
	    sprite.height = 600.0
	
	    sprite.filters = arrayOf(filter)
	
	}
	
	override fun update() {
	
	    filter.update()
	
	}
}