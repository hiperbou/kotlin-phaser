
package examples.text


import Phaser.*

class TextBounds: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	lateinit var text:Text
	var ipsum = "Click to change alignment\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Quid ergo aliud intellegetur nisi uti ne quae pars naturae neglegatur?\n\nSi longus, levis Ita relinquet duas, de quibus etiam atque etiam consideret. Optime, inquam. Sed quanta sit alias, nunc tantum possitne esse tanta.\n\nQuid, si etiam iucunda memoria est praeteritorum malorum?"
	
	//  The different types of alignment this demo cycles through
	//  h = horizontal, v = vertical
	//  a = the text alignment (see comments below)
	var align = arrayOf<dynamic>(
	    object{ var  h= "left";  var  v= "top";  var  a= "left" },
	    object{ var  h= "center";  var  v= "top";  var  a= "center" },
	    object{ var  h= "right";  var  v= "top";  var  a= "right" },
	    object{ var  h= "left";  var  v= "middle";  var  a= "left" },
	    object{ var  h= "center";  var  v= "middle";  var  a= "center" },
	    object{ var  h= "right";  var  v= "middle";  var  a= "right" },
	    object{ var  h= "left";  var  v= "bottom";  var  a= "left" },
	    object{ var  h= "center";  var  v= "bottom";  var  a= "center" },
	    object{ var  h= "right";  var  v= "bottom";  var  a= "right" }
	)
	
	var i = 0
	
	override fun preload() {
	
	    game.load.image("bg", "assets/skies/deepblue.png")
	
	}
	
	override fun create() {
	
	    game.add.image(0, 0, "bg")
	
	    var style = TextStyle( font= "16px Arial", fill= "#fff",
	        align= "left", // the alignment of the text is independent of the bounds, try changing to "center" or "right"
	        boundsAlignH= "left",
	        boundsAlignV= "top",
	        wordWrap= true,
			wordWrapWidth= 300 )
	
	    text = game.add.text(0, 0, ipsum, style)
	
	    text.setTextBounds(16, 16, 768, 568)
	
	    game.input.onDown.add(this::changeAlign, this)
	
	}
	
	fun changeAlign() {
	
	    i++
	
	    if (i === align.size)
	    {
	        i = 0
	    }
	
	    //  Un-comment this line to keep the text left-aligned
	    text.align = align[i].a
	
	    text.boundsAlignH = align[i].h
	    text.boundsAlignV = align[i].v
	
	}
	
	override fun render() {
	
	    //  Un-comment to see the text bounds rect to which the text is aligned
	    // game.debug.geom(text.textBounds, "rgba(255,0,0,0.5)")
	
	}
}