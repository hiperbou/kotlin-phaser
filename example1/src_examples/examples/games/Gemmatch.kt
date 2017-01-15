
package examples.games

import Koala.initKoala
import Phaser.*

class Gemmatch: State() {
	// Example by https://twitter.com/awapblog
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	fun floor(value: Double): Int = Phaser.Math.floorTo(value,null,null).toInt()
	fun floor(value: Int): Int = Phaser.Math.floorTo(value,null,null).toInt()

	fun userData() = object {
		var posX = 0
		var posY = 0
	}

	var PIXI.DisplayObject.posX:
			Int get() = userData.posX
		set(value:Int) { userData.posX = value }

	var PIXI.DisplayObject.posY: Int
		get() = userData.posY
		set(value:Int) { userData.posY = value }

	/*var PIXI.DisplayObject.id: Int
		get() = userData.id
		set(value:Int) { userData.id = value }*/


	var GEM_SIZE = 64
	var GEM_SPACING = 2
	var GEM_SIZE_SPACED = GEM_SIZE + GEM_SPACING
	var BOARD_COLS = 0
	var BOARD_ROWS = 0
	var MATCH_MIN = 3 // min number of same color gems required in a row to be considered a match
	
	lateinit var gems:Group
	var selectedGem:Sprite? = null
	var selectedGemStartPos:dynamic = object{}
	var selectedGemTween:Tween?= null
	var tempShiftedGem:Sprite? = null
	var allowInput = false
	
	override fun preload() {
	
	    game.load.spritesheet("GEMS", "assets/sprites/diamonds32x5.png", GEM_SIZE, GEM_SIZE)
	
	}
	
	override fun create() {
	
	    // fill the screen with as many gems as possible
	    spawnBoard()
	
	    // currently selected gem starting position. used to stop player form moving gems too far.
	    selectedGemStartPos = object{ var  x= 0;  var  y= 0 }
	    
	    // used to disable input while gems are dropping down and respawning
	    allowInput = true
	
	    game.input.addMoveCallback(this::slideGem, this)
	
	}
	
	fun releaseGem() {
	
	    if (tempShiftedGem == null) {
	        selectedGem = null
	        return
	    }
	
	    // when the mouse is released with a gem selected
	    // 1) check for matches
	    // 2) remove matched gems
	    // 3) drop down gems above removed gems
	    // 4) refill the board
	
	    checkAndKillGemMatches()
	
	    removeKilledGems()
	
	    val dropGemDuration = dropGems()
	
	    // delay board refilling until all existing gems have dropped down
	    game.time.events.add(dropGemDuration * 100, this::refillBoard)
	
	    allowInput = false

	    selectedGem = null
	    tempShiftedGem = null
	
	}
	
	fun slideGem(pointer:Pointer, x:Double, y:Double) {
		val x = x.toInt()
		val y = y.toInt()
	    // check if a selected gem should be moved and do it
	
	    if (selectedGem!=null && pointer.isDown)
	    {
			//val selectedGem:Sprite = selectedGem!!
			val cursorGemPosX = getGemPos(x)
			val cursorGemPosY = getGemPos(y)
	
	        if (checkIfGemCanBeMovedHere(selectedGemStartPos.x, selectedGemStartPos.y, cursorGemPosX, cursorGemPosY))
	        {
	            if (cursorGemPosX != selectedGem!!.posX || cursorGemPosY != selectedGem!!.posY)
	            {
	                // move currently selected gem
	                if (selectedGemTween != null)
	                {
	                    game.tweens.remove(selectedGemTween!!)
	                }
	
	                selectedGemTween = tweenGemPos(selectedGem!!, cursorGemPosX, cursorGemPosY)
	
	                gems.bringToTop(selectedGem!!)
	
	                // if we moved a gem to make way for the selected gem earlier, move it back into its starting position
	                if (tempShiftedGem != null)
	                {
						val tempShiftedGem:Sprite = tempShiftedGem!!
	                //    tweenGemPos(tempShiftedGem, selectedGem.posX , selectedGem.posY)
	                    swapGemPosition(selectedGem!!, tempShiftedGem)
	                }
	
	                // when the player moves the selected gem, we need to swap the position of the selected gem with the gem currently in that position 
	                tempShiftedGem = getGem(cursorGemPosX, cursorGemPosY)
	                if (tempShiftedGem == selectedGem)
	                {
	                    tempShiftedGem = null
	                }
	                else
	                {
						val tempShiftedGem:Sprite = tempShiftedGem!!
	                    tweenGemPos(tempShiftedGem, selectedGem!!.posX, selectedGem!!.posY)
	                    swapGemPosition(selectedGem!!, tempShiftedGem)
	                }
	            }
	        }
	    }
	}
	
	// fill the screen with as many gems as possible
	fun spawnBoard() {
	
	    BOARD_COLS = floor(game.world.width / GEM_SIZE_SPACED)
	    BOARD_ROWS = floor(game.world.height / GEM_SIZE_SPACED)
	
	    gems = game.add.group()
	
	    for(i in 0..BOARD_COLS-1)
	    {
	        for(j in 0..BOARD_ROWS-1)
	        {
	            val gem = gems.create(i * GEM_SIZE_SPACED, j * GEM_SIZE_SPACED, "GEMS")
	            gem.userData = userData()
				gem.name = "gem" + i.toString() + "x" + j.toString()
	            gem.inputEnabled = true
	            gem.events.onInputDown.add(this::selectGem, this)
	            gem.events.onInputUp.add(this::releaseGem, this)
	            randomizeGemColor(gem)
	            setGemPos(gem, i, j) // each gem has a position on the board
	        }
	    }
	
	}
	
	// select a gem and remember its starting position
	fun selectGem(gem:Sprite) {
	    if (allowInput)
	    {
	        selectedGem = gem
	        selectedGemStartPos.x = gem.posX
	        selectedGemStartPos.y = gem.posY
	    }
	
	}
	
	// find a gem on the board according to its position on the board
	fun getGem(posX:Int, posY:Int):Sprite {
	    return gems.iterate("id", calcGemId(posX, posY), Phaser.Group.RETURN_CHILD)
	}
	
	// convert world coordinates to board position
	fun getGemPos(coordinate:Int):Int {
	
	    return floor(coordinate / GEM_SIZE_SPACED)
	
	}
	
	// set the position on the board for a gem
	fun setGemPos(gem:Sprite, posX:Int, posY:Int) {
	
	    gem.posX = posX
	    gem.posY = posY
	    gem.id = calcGemId(posX, posY)
	
	}
	
	// the gem id is used by getGem() to find specific gems in the group
	// each position on the board has a unique id
	fun calcGemId(posX:Int, posY:Int):Int {
	    return posX + posY * BOARD_COLS
	}
	
	// since the gems are a spritesheet, their color is the same as the current frame number
	fun getGemColor(gem:Sprite):Int {
	
	    return gem.frame
	
	}
	
	// set the gem spritesheet to a random frame
	fun randomizeGemColor(gem:Sprite) {
	
	    gem.frame = game.rnd.integerInRange(0, gem.animations.frameTotal - 1)
	
	}
	
	// gems can only be moved 1 square up/down or left/right
	fun checkIfGemCanBeMovedHere(fromPosX:Int, fromPosY:Int, toPosX:Int, toPosY:Int):Boolean {
	
	    if (toPosX < 0 || toPosX >= BOARD_COLS || toPosY < 0 || toPosY >= BOARD_ROWS)
	    {
	        return false
	    }
	
	    if (fromPosX == toPosX && fromPosY >= toPosY - 1 && fromPosY <= toPosY + 1)
	    {
	        return true
	    }
	
	    if (fromPosY == toPosY && fromPosX >= toPosX - 1 && fromPosX <= toPosX + 1)
	    {
	        return true
	    }
	
	    return false
	}
	
	// count how many gems of the same color lie in a given direction
	// eg if moveX=1 and moveY=0, it will count how many gems of the same color lie to the right of the gem
	// stops counting as soon as a gem of a different color or the board end is encountered
	fun countSameColorGems(startGem:Sprite, moveX:Int, moveY:Int):Int {
	
	    var curX = startGem.posX + moveX
	    var curY = startGem.posY + moveY
	    var count = 0
	
	    while (curX >= 0 && curY >= 0 && curX < BOARD_COLS && curY < BOARD_ROWS && getGemColor(getGem(curX, curY)) == getGemColor(startGem))
	    {
	        count++
	        curX += moveX
	        curY += moveY
	    }
	
	    return count
	
	}
	
	// swap the position of 2 gems when the player drags the selected gem into a location
	fun swapGemPosition(gem1:Sprite, gem2:Sprite) {
	
	    var tempPosX = gem1.posX
	    var tempPosY = gem1.posY
	    setGemPos(gem1, gem2.posX, gem2.posY)
	    setGemPos(gem2, tempPosX, tempPosY)
	
	}

	fun resetTempShiftedGem(){
		tempShiftedGem = null
	}

	// count how many gems of the same color are above, below, to the left and right
	// if there are more than 3 matched horizontally or vertically, kill those gems
	// if no match was made, move the gems back into their starting positions
	fun checkAndKillGemMatches() {
	
	    if (selectedGem == null) return

	    if (tempShiftedGem == null )   return

	    var canKill = false
	
	    // process the selected gem
	
	    var countUp = countSameColorGems(selectedGem!!, 0, -1)
	    var countDown = countSameColorGems(selectedGem!!, 0, 1)
	    var countLeft = countSameColorGems(selectedGem!!, -1, 0)
	    var countRight = countSameColorGems(selectedGem!!, 1, 0)
	
	    var countHoriz = countLeft + countRight + 1
	    var countVert = countUp + countDown + 1
	
	    if (countVert >= MATCH_MIN)
	    {
	        killGemRange(selectedGem!!.posX, selectedGem!!.posY - countUp, selectedGem!!.posX, selectedGem!!.posY + countDown)
	        canKill = true
	    }
	
	    if (countHoriz >= MATCH_MIN)
	    {
	        killGemRange(selectedGem!!.posX - countLeft, selectedGem!!.posY, selectedGem!!.posX + countRight, selectedGem!!.posY)
	        canKill = true
	    }
	
	    // now process the shifted (swapped) gem
	
	    countUp = countSameColorGems(tempShiftedGem!!, 0, -1)
	    countDown = countSameColorGems(tempShiftedGem!!, 0, 1)
	    countLeft = countSameColorGems(tempShiftedGem!!, -1, 0)
	    countRight = countSameColorGems(tempShiftedGem!!, 1, 0)
	
	    countHoriz = countLeft + countRight + 1
	    countVert = countUp + countDown + 1
	
	    if (countVert >= MATCH_MIN)
	    {
	        killGemRange(tempShiftedGem!!.posX, tempShiftedGem!!.posY - countUp, tempShiftedGem!!.posX, tempShiftedGem!!.posY + countDown)
	        canKill = true
	    }
	
	    if (countHoriz >= MATCH_MIN)
	    {
	        killGemRange(tempShiftedGem!!.posX - countLeft, tempShiftedGem!!.posY, tempShiftedGem!!.posX + countRight, tempShiftedGem!!.posY)
	        canKill = true
	    }
	
	    if (!canKill) // there are no matches so swap the gems back to the original positions
	    {
	        var gem = selectedGem
	
	        if (gem!!.posX != selectedGemStartPos.x || gem.posY != selectedGemStartPos.y)
	        {
	            if (selectedGemTween != null)
	            {
	                game.tweens.remove(selectedGemTween!!)
	            }
	
	            selectedGemTween = tweenGemPos(gem, selectedGemStartPos.x, selectedGemStartPos.y)
	
	            if (tempShiftedGem != null)
	            {
	                tweenGemPos(tempShiftedGem!!, gem.posX, gem.posY)
	            }
	
	            swapGemPosition(gem, tempShiftedGem!!)

				resetTempShiftedGem()
	
	        }
	    }
	
	}
	
	// kill all gems from a starting position to an end position
	fun killGemRange(fromX:Int, fromY:Int, toX:Int, toY:Int) {
	
	    val fromX = Phaser.Math.clamp(fromX, 0, BOARD_COLS - 1).toInt()
		val fromY = Phaser.Math.clamp(fromY , 0, BOARD_ROWS - 1).toInt()
		val toX = Phaser.Math.clamp(toX, 0, BOARD_COLS - 1).toInt()
		val toY = Phaser.Math.clamp(toY, 0, BOARD_ROWS - 1).toInt()

	    for(i in fromX..toX)
	    {
	        for(j in fromY..toY)
	        {
	            var gem = getGem(i, j)
	            gem.kill()
	        }
	    }
	
	}
	
	// move gems that have been killed off the board
	fun removeKilledGems() {
	
	    gems.forEach({ gem:Sprite ->
	        if (!gem.alive) {
	            setGemPos(gem, -1,-1)
	        }
	    })
	
	}
	
	// animated gem movement
	fun tweenGemPos(gem:Sprite, newPosX:Int, newPosY:Int, durationMultiplier:Int=1):Tween {
	    console.log("Tween ",gem.name," from ",gem.posX, ",", gem.posY, " to ", newPosX, ",", newPosY)
	    return game.add.tween(gem).to(object{var x = newPosX  * GEM_SIZE_SPACED; var y = newPosY * GEM_SIZE_SPACED}, 100 * durationMultiplier, Phaser.Easing.Linear::None, true)
	}
	
	// look for gems with empty space beneath them and move them down
	fun dropGems():Int {
	
	    var dropRowCountMax = 0
	
	    for(i in 0..BOARD_COLS-1)
	    {
	        var dropRowCount = 0
			for(j in BOARD_ROWS-1 downTo 0)
	        {
	            var gem = getGem(i, j)
	
	            if (gem == null)
	            {
	                dropRowCount++
	            }
	            else if (dropRowCount > 0)
	            {
	                setGemPos(gem, gem.posX, gem.posY + dropRowCount)
	                tweenGemPos(gem, gem.posX, gem.posY, dropRowCount)
	            }
	        }
	
	        dropRowCountMax = Math.max(dropRowCount, dropRowCountMax).toInt()
	    }
	
	    return dropRowCountMax
	
	}
	
	// look for any empty spots on the board and spawn gems in their place that fall down from above
	fun refillBoard() {
	    var maxGemsMissingFromCol = 0
	
	    for(i in 0..BOARD_COLS-1)
	    {
	        var gemsMissingFromCol = 0

			for(j in BOARD_ROWS - 1 downTo 0 )
	        {
	            var gem = getGem(i, j)
	
	            if (gem == null)
	            {
	                gemsMissingFromCol++
	                gem = gems.getFirstDead()!!
	                gem.reset(i * GEM_SIZE_SPACED, -gemsMissingFromCol * GEM_SIZE_SPACED)
	                randomizeGemColor(gem)
	                setGemPos(gem, i, j)
	                tweenGemPos(gem, gem.posX, gem.posY, gemsMissingFromCol * 2)
	            }
	        }
	
	        maxGemsMissingFromCol = Math.max(maxGemsMissingFromCol, gemsMissingFromCol).toInt()
	    }
	
	    game.time.events.add(maxGemsMissingFromCol * 2 * 100, this::boardRefilled)
	
	}
	
	// when the board has finished refilling, re-enable player input
	fun boardRefilled() {
	
	    allowInput = true
	
	}
}