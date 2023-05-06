
package examples.loader


import Phaser.*

class LoadTextureAtlas: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    //  Phaser can load Texture Atlas files that use either JSON Hash or JSON Array format.
	
	    //  As with all load operations the first parameter is a unique key, which must be unique between all image files.
	
	    //  Next is the texture atlas itself, in this case seacreatures.png
	
	    //  Finally is the path to the JSON file that goes with the atlas.
	    // game.load.atlas("seacreatures", "assets/sprites/seacreatures_json.png", "assets/sprites/seacreatures_json.json")
	
	    //  Note that the JSON file should be saved with UTF-8 encoding or some browsers (such as Firefox) won"t load it.
	
	    game.load.atlas("test", "assets/sprites/atlas_hash_trim.png", "assets/sprites/atlas_json_array_trim.json", Phaser.Loader.TEXTURE_ATLAS_JSON_HASH)
	
	
	    //  These are just a few images to use in our underwater scene.
	    game.load.image("undersea", "assets/pics/undersea.jpg")
	    game.load.image("coral", "assets/pics/seabed.png")
	
	}
	
	lateinit var octopus:Sprite
	
	override fun create() {
	
	    game.add.sprite(0, 0, "undersea")
	
	    game.add.sprite(0, 0, "test")
	
	    // octopus = game.add.sprite(330, 100, "seacreatures")
	    // octopus.animations.add("swim", Phaser.Animation.generateFrameNames("octopus", 0, 24, "", 4), 30, true)
	    // octopus.animations.play("swim")
	
	    // game.add.tween(octopus).to(object{ var  y= 250 }, 4000, Phaser.Easing.Quadratic::InOut, true, 0, 10000, true)
	
	    game.add.sprite(0, 466, "coral")
	
	}
}