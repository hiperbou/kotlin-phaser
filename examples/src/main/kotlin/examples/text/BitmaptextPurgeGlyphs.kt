
package examples.text


import Phaser.*

class BitmaptextPurgeGlyphs: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.bitmapFont("gem", "assets/fonts/bitmapFonts/gem.png", "assets/fonts/bitmapFonts/gem.xml")
	
	}
	
	lateinit var bmpText:BitmapText
	var text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quid ergo aliud intellegetur nisi uti ne quae pars naturae neglegatur? Si longus, levis Ita relinquet duas, de quibus etiam atque etiam consideret. Optime, inquam. Sed quanta sit alias, nunc tantum possitne esse tanta.\n\nQuid, si etiam iucunda memoria est praeteritorum malorum? Consequatur summas voluptates non modo parvo, sed per me nihilo, si potest Atque his de rebus et splendida est eorum et illustris oratio. Mihi enim satis est, ipsis non satis. Ergo ita: non posse honeste vivi, nisi honeste vivatur? Mihi quidem Antiochum, quem audis, satis belle videris attendere. Et quod est munus, quod opus sapientiae? Ex rebus enim timiditas, non ex vocabulis nascitur. Ex ea difficultate illae fallaciloquae, ut ait Accius, malitiae natae sunt. Nonne videmus quanta perturbatio rerum omnium consequatur, quanta confusio? Quae cum magnifice primo dici viderentur, considerata minus probabantur.\n\n---> Click to remove text"
	
	override fun create() {
	
	    game.stage.backgroundColor = 0x272822
	
	    bmpText = game.add.bitmapText(32, 32, "gem", text, 16)
	
	    bmpText.maxWidth = 400.0
	
	    //  Click to remove text and purge glyphs
	    game.input.onDown.add(this::chopText, this)
	
	}
	
	fun chopText() {
	
	    bmpText.text = text.substring(0, 26)
	
	    var purged = bmpText.purgeGlyphs()
	
	    game.add.bitmapText(32, 128, "gem", "Purged " + purged + " glyphs", 32)
	
	}
}