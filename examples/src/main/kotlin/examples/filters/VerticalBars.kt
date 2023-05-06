
package examples.filters


import Phaser.*

class VerticalBars: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  create= create;  var  update= update })
	
	lateinit var filter:Filter
	lateinit var sprite:Sprite
	
	override fun create() {
	
	    //  From http://glslsandbox.com/e#16133.0
	
	    var fragmentSrc = arrayOf(


				"precision mediump float;",

				"uniform float     time;",
				"uniform vec2      resolution;",

				"#define PI 0.01",

				"void main( void ) {",

				"vec2 p = ( gl_FragCoord.xy / resolution.xy ) - 0.5;",

				"float sx = 0.2*sin( 25.0 * p.y - time * 5.);",

				"float dy = 0.9/ ( 50. * abs(p.y - sx));",

				"gl_FragColor = vec4( (p.x + 0.5) * dy, 0.5 * dy, dy-1.65, 5.0 );",

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