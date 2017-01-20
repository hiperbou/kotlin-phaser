
package examples.games


import Phaser.*

import kotlin.collections.getOrElse

class MatchingPairs: State() {
	// mods by Patrick OReilly 
	// twitter: @pato_reilly
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.tilemap("matching", "assets/tilemaps/maps/phaser_tiles.json", null, Phaser.Tilemap.TILED_JSON)
	    game.load.image("tiles", "assets/tilemaps/tiles/phaser_tiles.png")//, 100, 100, -1, 1, 1)    
	}
	
	var timeCheck = 0.0
	var flipFlag = false
	
	var startList = mutableListOf<Int>()
	var squareList = mutableListOf<Int>()

	var currentNum:Int = 0;
	
	var masterCounter = 0
	var squareCounter = 0
	lateinit var square1Num:Number
	lateinit var square2Num:Number
	lateinit var savedSquareX1:Number
	lateinit var savedSquareY1:Number
	lateinit var savedSquareX2:Number
	lateinit var savedSquareY2:Number
	
	lateinit var map:Tilemap
	lateinit var tileset:Tileset
	lateinit var layer:TilemapLayer
	
	lateinit var marker:Graphics
	lateinit var currentTile:Tile
	var currentTilePosition:Int = 0
	
	var tileBack = 25
	var timesUp = "+"
	var youWin = "+"
	
	var myCountdownSeconds = 0.0


	override fun create() {
	
	        map = game.add.tilemap("matching")
	
	        map.addTilesetImage("Desert", "tiles")
	
	        //tileset = game.add.tileset("tiles")
	    
	        layer = map.createLayer("Ground")//.tilemapLayer(0, 0, 600, 600, tileset, map, 0)
	
	        //layer.resizeWorld()
	
	        marker = game.add.graphics()
	        marker.lineStyle(2, 0x00FF00, 1)
	        marker.drawRect(0, 0, 100, 100)
	    
	    	randomizeTiles()

	}
	
	override fun update() {

	    countDownTimer()
	    
	    if (layer.getTileX(game.input.activePointer.worldX) <= 5) // to prevent the marker from going out of bounds
	    {
	        marker.x = layer.getTileX(game.input.activePointer.worldX) * 100.0
	        marker.y = layer.getTileY(game.input.activePointer.worldY) * 100.0
	    }
	
	    if (flipFlag == true) 
	    {
	        if (game.time.totalElapsedSeconds() - timeCheck > 0.5)
	        {
	            flipBack()
	        }
	    }
	    else
	    {
	        processClick()
	    }
	}
	   
	   
	fun countDownTimer() {
	  
	    var timeLimit = 120
	  
	    val mySeconds = game.time.totalElapsedSeconds()
	    myCountdownSeconds = timeLimit - mySeconds
	    
	    if (myCountdownSeconds <= 0) 
	        {
	        // time is up
	        timesUp = "Time is up!" 
	        myCountdownSeconds = 0.0
	
	    }
	}
	
	fun processClick() {
		if(marker.x<0 || marker.y<0) return
	    currentTile = map.getTile(layer.getTileX(marker.x), layer.getTileY(marker.y))!!
	    currentTilePosition = ((layer.getTileY(game.input.activePointer.worldY).toInt()+1)*6)-(6-(layer.getTileX(game.input.activePointer.worldX).toInt()+1))
	        
	    if (game.input.mousePointer.isDown)
	        {
	        // check to make sure the tile is not already flipped
	        if (currentTile.index == tileBack)
	        {
	            // get the corresponding item out of squareList
	                currentNum = squareList[currentTilePosition-1]
	            flipOver()
	                squareCounter++
	            // is the second tile of pair flipped?
	            if  (squareCounter == 2) 
	            {
	                // reset squareCounter
	                squareCounter = 0
	                square2Num = currentNum
	                // check for match
	                if (square1Num == square2Num)
	                {
	                    masterCounter++    
	                    
	                    if (masterCounter == 18) 
	                    {
	                        // go "win"
	                        youWin = "Got them all!"
	                    }                       
	                }
	                else
	                {
	                    savedSquareX2 = layer.getTileX(marker.x)
	                    savedSquareY2 = layer.getTileY(marker.y)
	                        flipFlag = true
	                        timeCheck = game.time.totalElapsedSeconds()
	                }   
	            }   
	            else
	            {
	                savedSquareX1 = layer.getTileX(marker.x)
	                savedSquareY1 = layer.getTileY(marker.y)
	                    square1Num = currentNum
	            }           
	        }           
	    }    
	}
	 
	fun flipOver() {
	 
	    map.putTile(currentNum, layer.getTileX(marker.x), layer.getTileY(marker.y))
	}
	 
	fun flipBack() {
	        
	    flipFlag = false
	    
	    map.putTile(tileBack, savedSquareX1, savedSquareY1)
	    map.putTile(tileBack, savedSquareX2, savedSquareY2)
	 
	}
	 
	fun randomizeTiles() {
	
		for (num in 1..18)
	    {
	        startList.add(num)
	    }
		for (num in 1..18)
	    {
	        startList.add(num)
	    }
	
	    // for debugging
	    val myString1 = startList.toString()
	  
	    // randomize squareList
		for (i in 1..36)
	    {
	        var randomPosition = game.rnd.integerInRange(0,startList.size - 1)
	
	        var thisNumber = startList[randomPosition]
	
	        squareList.add(thisNumber)
	        var a = startList.indexOf(thisNumber)
	
	        startList.removeAt( a )
	    }
	    
	    // for debugging
	    val myString2 = squareList.toString()

		for (col in 0..5)
	    {
			for (row in 0..5)
	        {
	            map.putTile(tileBack, col, row)
	        }
	    }
	}
	
	fun getHiddenTile():Int {
		val index = currentTilePosition-1
		if(index<0 || index>squareList.size) return 0
	    val thisTile = squareList[index]
	    return thisTile
	}
	
	override fun render() {

	    game.debug.text(timesUp, 620, 208, "rgb(0,255,0)")
	    game.debug.text(youWin, 620, 240, "rgb(0,255,0)")
	
	    game.debug.text("Time: " + myCountdownSeconds, 620, 15, "rgb(0,255,0)")
	
	    //game.debug.text("squareCounter: " + squareCounter, 620, 272, "rgb(0,0,255)")
	    game.debug.text("Matched Pairs: " + masterCounter, 620, 304, "rgb(0,0,255)")
	
	    //game.debug.text("startList: " + myString1, 620, 208, "rgb(255,0,0)")
	    //game.debug.text("squareList: " + myString2, 620, 240, "rgb(255,0,0)")

	    //game.debug.text("Tile: " + map.getTile(layer.getTileX(marker.x), layer.getTileY(marker.y)).index, 620, 48, "rgb(255,0,0)")

	    game.debug.text("LayerX: " + layer.getTileX(marker.x), 620, 80, "rgb(255,0,0)")
	    game.debug.text("LayerY: " + layer.getTileY(marker.y), 620, 112, "rgb(255,0,0)")

	    game.debug.text("Tile Position: " + currentTilePosition, 620, 144, "rgb(255,0,0)")
	    game.debug.text("Hidden Tile: " + getHiddenTile(), 620, 176, "rgb(255,0,0)")
	}
}