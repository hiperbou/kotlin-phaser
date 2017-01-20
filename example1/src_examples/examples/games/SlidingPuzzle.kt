
package examples.games


import Phaser.*



class SlidingPuzzle: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	fun floor(value: Double): Int = Phaser.Math.floorTo(value,null,null).toInt()

	fun userData() = object {
		var posX = 0
		var posY = 0
		var currentIndex = 0
		var destIndex = 0
		var black:Boolean = false
	}

	var PIXI.DisplayObject.posX:
			Int get() = userData.posX
			set(value:Int) { userData.posX = value }

	var PIXI.DisplayObject.posY: Int
		get() = userData.posY
		set(value:Int) { userData.posY = value }

	var PIXI.DisplayObject.currentIndex: Int
		get() = userData.currentIndex
		set(value:Int) { userData.currentIndex = value }

	var PIXI.DisplayObject.destIndex: Int
		get() = userData.destIndex
		set(value:Int) { userData.destIndex = value }

	var PIXI.DisplayObject.black: Boolean
		get() = userData.black
		set(value:Boolean) { userData.black = value }


	var PIECE_WIDTH = 200
	var   PIECE_HEIGHT = 200
	var    BOARD_COLS = 0
	var    BOARD_ROWS = 0
	
	lateinit var piecesGroup:Group
	var   piecesAmount = 0
	var  shuffledIndexArray = mutableListOf<Int>()
	
	override fun preload() {
	    game.load.spritesheet("background", "assets/games/sliding-puzzle/bl.jpg", PIECE_WIDTH, PIECE_HEIGHT)
	}
	
	override fun create() {
	    prepareBoard()
	}
	
	fun prepareBoard() {
	
	    var piecesIndex = 0
		var piece:Sprite
	
	    BOARD_COLS = floor(game.world.width / PIECE_WIDTH)
	    BOARD_ROWS = floor(game.world.height / PIECE_HEIGHT)
	
	    piecesAmount = BOARD_COLS * BOARD_ROWS
	
	    shuffledIndexArray = createShuffledIndexArray()
	
	    piecesGroup = game.add.group()

		for (i in 0..BOARD_ROWS-1)
	    {
			for (j in 0..BOARD_COLS-1)
	        {
	            if (shuffledIndexArray[piecesIndex]>0) {
	                piece = piecesGroup.create(j * PIECE_WIDTH, i * PIECE_HEIGHT, "background", shuffledIndexArray[piecesIndex])
					piece.userData = userData()
				}
	            else { //initial position of black piece
	                piece = piecesGroup.create(j * PIECE_WIDTH, i * PIECE_HEIGHT)
					piece.userData = userData()
	                piece.black = true
	            }
	            piece.name = "piece" + i.toString() + "x" + j.toString()
	            piece.currentIndex = piecesIndex
	            piece.destIndex = shuffledIndexArray[piecesIndex]
	            piece.inputEnabled = true
	            piece.events.onInputDown.add(this::selectPiece, this)
	            piece.posX = j
	            piece.posY = i
	            piecesIndex++
	        }
	    }
	
	}
	
	fun selectPiece(piece:Sprite) {
	
	    var blackPiece = canMove(piece)
	
	    //if there is a black piece in neighborhood
	    if (blackPiece!=null) {
	        movePiece(piece, blackPiece)
	    }
	
	}
	
	fun canMove(piece:Sprite):Sprite? {
	
	    var foundBlackElem:Sprite? = null
	
	    piecesGroup.children.forEach( { element ->
	        if (element.posX === (piece.posX - 1) && element.posY === piece.posY && element.black ||
	            element.posX === (piece.posX + 1) && element.posY === piece.posY && element.black ||
	            element.posY === (piece.posY - 1) && element.posX === piece.posX && element.black ||
	            element.posY === (piece.posY + 1) && element.posX === piece.posX && element.black) {
	            foundBlackElem = element as Sprite
	            //return
	        }
	    })
	
	    return foundBlackElem
	}
	
	fun movePiece(piece:Sprite, blackPiece:Sprite) {
	
	    var tmpPiece = object {
	        var posX:Int = piece.posX
	        var posY:Int = piece.posY
	        var currentIndex:Int = piece.currentIndex
	    }
	
	    game.add.tween(piece).to(object{var x = blackPiece.posX * PIECE_WIDTH; var y = blackPiece.posY * PIECE_HEIGHT}, 300, Phaser.Easing.Linear::None, true)
	
	    //change places of piece and blackPiece
	    piece.posX = blackPiece.posX
	    piece.posY = blackPiece.posY
	    piece.currentIndex = blackPiece.currentIndex
	    piece.name ="piece" + piece.posX.toString() + "x" + piece.posY.toString()
	
	    //piece is the black
	    blackPiece.posX = tmpPiece.posX
	    blackPiece.posY = tmpPiece.posY
	    blackPiece.currentIndex = tmpPiece.currentIndex
	    blackPiece.name ="piece" + blackPiece.posX.toString() + "x" + blackPiece.posY.toString()
	
	    //after every move check if puzzle is completed
	    checkIfFinished()
	}
	
	fun checkIfFinished() {
	
	    var isFinished = true
	
	    piecesGroup.children.forEach( { element ->
	        if (element.currentIndex !== element.destIndex) {
	            isFinished = false
	            return
	        }
	    })

	    if (isFinished) {
	        showFinishedText()
	    }
	
	}
	
	fun showFinishedText() {
	
	    var style = TextStyle( font= "40px Arial", fill= "#FFF", align= "center")
	
	    var text = game.add.text(game.world.centerX, game.world.centerY, "Congratulations! \nYou made it!", style)
	
	    text.anchor.set(0.5)
	
	}
	
	fun createShuffledIndexArray():MutableList<Int> {
	
	    var indexArray = mutableListOf<Int>()
	
	    for(i in 0..piecesAmount-1)
	    {
	        indexArray.add(i)
	    }
	
	    return shuffle(indexArray)
	
	}
	
	fun shuffle(array:MutableList<Int>):MutableList<Int> {
	
	    var counter = array.size
	        var temp = 0
	        var index = 0
	
	    while (counter > 0)
	    {
	        index = floor(Math.random() * counter)
	
	        counter--
	
	        temp = array[counter]
	        array[counter] = array[index]
	        array[index] = temp
	    }
	
	    return array
	    
	}
}