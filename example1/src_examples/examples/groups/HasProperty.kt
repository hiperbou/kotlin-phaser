
package examples.groups


import Phaser.*

class HasProperty: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("coin", "assets/sprites/coin.png", 32, 32)
	
	}
	
	lateinit var coins:Group
	
	override fun create() {
	
	    coins = game.add.group()
	
	    //  Create 10 children
	    coins.createMultiple(10, "coin")
	
	    //  Add the same animation to all sprites in the group:
	    coins.callAll("animations.add", "animations", "spin", arrayOf(0, 1, 2, 3, 4, 5), 10, true)
	
	    //  Pluck out a child from the Group
	    var test = coins.getAt(2)
	
	    console.log(test.x)
	
	    // var key = mutableListOf( "animations", "currentAnim", "currentFrame", "centerXS" )
	    // var key = mutableListOf( "animations", "currentAnim", "frameTotal" )
	    // var key = mutableListOf( "animations", "currentAnim" )
	    // var key = mutableListOf( "position", "x" )
	
	    // console.log(hasProperty(test, key))
	
	    // console.log("position.x" in test)
	
	    coins.addAll("x", 10)
	
	    //  We"re going to check for: child.x
	    console.log(test.x)
	
	}

	/*fun hasProperty (child, key) {

	    var len = key.size

	    console.log("hasProperty", key, len)

	    if (len === 1 && key[0] in child)
	    {
	        return true
	    }
	    else if (len === 2 && key[0] in child && key[1] in child[key[0]])
	    {
	        return true
	    }
	    else if (len === 3 && key[0] in child && key[1] in child[key[0]] && key[2] in child[key[0]][key[1]])
	    {
	        return true
	    }
	    else if (len === 4 && key[0] in child && key[1] in child[key[0]] && key[2] in child[key[0]][key[1]] && key[3] in child[key[0]][key[1]][key[2]])
	    {
	        return true
	    }

	    return false

	}*/
}