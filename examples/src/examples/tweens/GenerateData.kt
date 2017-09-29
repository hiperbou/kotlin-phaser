
package examples.tweens


import Phaser.*

class GenerateData: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("wasp", "assets/sprites/wasp.png")
	    game.load.image("sky", "assets/skies/cavern1.png")
	
	}
	
	lateinit var bugs:Group
	var index = 0
	lateinit var data:Array<Point>
	var pos = mutableListOf<Point>()
	
	override fun create() {
	
	    game.add.image(0, 0, "sky")
	
	    //  We don"t want it to actually run, so we use game.make.tween instead of game.add.tween
	
	    var tweenData = object{ var  x= 0;  var  y= 0 }
	
	    //  Here we"ll tween the values held in the tweenData object to x: 500, y: 300
	    val tween = game.make.tween(tweenData).to( object{ var  x= 100;  var  y= 400 }, 2000, "Sine.easeInOut")
	
	    //  Set the tween to yoyo so it loops smoothly
	    tween.yoyo(true)
	
	    //  We have 3 interpolation methods available: linearInterpolation (the default), bezierInterpolation and catmullRomInterpolation.
	
	    // tween.interpolation(Phaser.getMath.bezierInterpolation)
	    // tween.interpolation(Phaser.getMath.catmullRomInterpolation)
	
	    //  Generates the tween data at a rate of 60 frames per second.
	    //  This is useful if you"ve got a lot of objects all using the same tween, just at different coordinates.
	    //  It saves having to calculate the same tween across the properties of all objects involved in the motion.
	    //  Instead you can pre-calculate it in advance and trade that in for a bit of memory to store it in an array.
	    data = tween.generateData(60) as Array<Point>
	
	    // console.log(data)
	
	    //  Now create some sprites to shown the tween data in action
	    bugs = game.add.group()
	
	    pos.add(Phaser.Point(32, 0))
	    pos.add(Phaser.Point(300, 100))
	    pos.add(Phaser.Point(600, 70))
	
	    bugs.create(pos[0].x, pos[0].y, "wasp")
	    bugs.create(pos[1].x, pos[1].y, "wasp")
	    bugs.create(pos[2].x, pos[2].y, "wasp")
	
	}
	
	override fun update() {
	
	    //  A simple data playback.
	
	    //  Each element of the array contains an object that includes whatever properties were tweened
	    //  In this case the x and y properties
	
	    //  Because the tween data is pre-generated we can apply it however we want:
	    //  Directly, by adding to the coordinates
	    bugs.getAt(0).x = pos[0].x + data[index].x
	    bugs.getAt(0).y = pos[0].y + data[index].y
	
	    //  Half one of the values
	    bugs.getAt(1).x = pos[1].x + (data[index].x / 2)
	    bugs.getAt(1).y = pos[1].y + data[index].y
	
	    //  Inverse one of the values
	    bugs.getAt(2).x = pos[2].x - data[index].x
	    bugs.getAt(2).y = pos[2].y + data[index].y
	
	    //  You can do all kinds of effects by modifying the tween data,
	    //  without having loads of active tweens running.
	
	    //  This just advances the tween data index
	    //  It"s crude and doesn"t take target device speed into account at all, but works as an example
	    index++
	
	    if (index === data.size)
	    {
	        index = 0
	    }
	
	}
}