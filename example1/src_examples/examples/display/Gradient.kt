
package examples.display

import Koala.initKoala
import Phaser.*

class Gradient: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    // game.load.image("hotdog", "assets/sprites/hotdog.png")
	
	}
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0c9fc7"
	
	    /**
	    * Interpolates the two given colours based on the supplied step and currentStep properties.
	    *
	    * @method Phaser.Color.interpolateColor
	    * @static
	    * @param object{ var number} color1 - The first color value.
	    * @param object{ var number} color2 - The second color value.
	    * @param object{ var number} steps - The number of steps to run the interpolation over.
	    * @param object{ var number} currentStep - The currentStep value. If the interpolation will take 100 steps, a currentStep value of 50 would be half-way between the two.
	    * @param object{ var number} alpha - The alpha of the returned color.
	    * @returns object{ var number} The interpolated color value.
	    */
	    // interpolateColor: fun (color1, color2, steps, currentStep, alpha) {
	
	    var out = mutableListOf<String>()
	
	    var bmd = game.add.bitmapData(800, 600)
	    bmd.addToWorld()
	
	    var y = 0
	
	    for(i in 0..30-1)
	    {
	        var c = Phaser.Color.interpolateColor(0x66d973, 0x40b54d, 30, i)
	
	        // console.log(Phaser.Color.getWebRGB(c))
	
	        bmd.rect(0, y, 800, y+2, Phaser.Color.getWebRGB(c))
	
	        out.add(Phaser.Color.getWebRGB(c))
	
	        y += 2
	    }
	
	    for(i in 0..60-1)
	    {
	        var c = Phaser.Color.interpolateColor(0x40b54d, 0x1d962b, 60, i)
	
	        // console.log(Phaser.Color.getWebRGB(c))
	
	        bmd.rect(0, y, 800, y+2, Phaser.Color.getWebRGB(c))
	
	        out.add(Phaser.Color.getWebRGB(c))
	
	        y += 2
	    }
	
	    // console.log(out)
	    console.log(JSON.stringify(out))
	
	}
	
}