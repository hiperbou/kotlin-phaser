
package examples.games

import Koala.initKoala
import Phaser.*

class Yahtzee: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example")
	
	class Die(val game:Yahtzee) {
		var value = 1
		var locked = false
		var sprite:Sprite
		init{
			sprite = game.make.sprite(0, 0, "dice", "dieWhite1")
			sprite.inputEnabled = true
			sprite.input.useHandCursor = true
			sprite.events.onInputDown.add(this::clicked, this)
		}

	    fun roll() {
	        if (!locked)
	        {
	            value = game.rnd.between(1, 6).toInt()
	            sprite.frameName = "dieWhite" + value
	        }
	    }
	
	    fun clicked() {
	        if (game.canLock)
	        {
	            if (locked)
	            {
	                unlock()
	            }
	            else
	            {
	                lock()
	            }
	        }
	    }
	
	    fun lock() {
	        if (!locked)
	        {
	            locked = true
	            sprite.frameName = "dieRed" + value
	        }
	    }
	    
	    fun unlock() {
	        if (locked)
	        {
	            locked = false
	            sprite.frameName = "dieWhite" + value
	        }
	    }
	
	    fun reset() {
	        unlock()
	        roll()
	    }
	
	}
	
	class Cup(val game:Yahtzee) {

	    val die1 = Die(game)
	    val die2 = Die(game)
	    val die3 = Die(game)
	    val die4 = Die(game)
	    val die5 = Die(game)
		val diceMap = mapOf(Pair("die1",die1),
				Pair("die2",die2),Pair("die3",die3),
				Pair("die4",die4),Pair("die5",die5))
	    fun reset() {
	        die1.reset()
	        die2.reset()
	        die3.reset()
	        die4.reset()
	        die5.reset()
	    }
	
	    fun shake() {
	        die1.roll()
	        die2.roll()
	        die3.roll()
	        die4.roll()
	        die5.roll()
	    }

		data class DieData(var  total:Int, var  qty:Int,  var  value:Int )

		fun getDie(value:Int):DieData {
			var out = DieData( total= 0, qty= 0, value= value)
	        for(i in 1..5)
	        {
	            if (diceMap.get("die" + i)!!.value == value)
	            {
	                out.total += value
	                out.qty++
	            }
	        }
	        return out
	    }
	
	    fun getFullSet():Array<DieData> {
	        return arrayOf(
	            getDie(1),
	            getDie(2),
	            getDie(3),
	            getDie(4),
	            getDie(5),
	            getDie(6)
	        )
	
	    }
	
	}
	
	//  Yahtzee combos:
	//  
	//  Top Row:
	//  
	//  1s, 2s, 3s, 4s, 5s, 6s
	//  
	//  Top Row Bonus: 35 points for getting 63+
	//  
	//  Bottom Row:
	//  
	//  Three of a Kind
	//  Four of a Kind
	//  Full House (any 3 + any 2)
	//  Small straight (1,2,3,4 - 2,3,4,5 - 3,4,5,6)
	//  Large straight (1,2,3,4,5 - 2,3,4,5,6)
	//  Chance (sum of all dice)
	//  Yahtzee (5 of a kind)
	
	class ComboSingle(val game:Yahtzee, var value:Int) {
		var score = 0
	    var played = false
	
	    fun check():Int {
	        var dice = game.cup.getDie(value)
	        return (dice.qty)
	    }
	
	    fun play() {
	        var dice = game.cup.getDie(value)
	        score = dice.total
	        played = true
	    }
	}
	
	class ComboChance (val game:Yahtzee) {
	    var score = 0
	    var played = false
	
	    fun check():Int {
	        var set = game.cup.getFullSet()
	        var score = 0
	
	        for(i in 0..set.size-1)
	        {
	            score += set[i].total
	        }
	
	        return score
	
	    }
	
	    fun play() {
	        var set = game.cup.getFullSet()
	        for(i in 0..set.size-1)
	        {
	            score += set[i].total
	        }
	        played = true
	    }
	
	}
	
	class ComboStraight(val game:Yahtzee, var size:Int, var points:Int) {
	    var score = 0
	    var played = false
	
	    //  Small straight (1,2,3,4 - 2,3,4,5 - 3,4,5,6)
	    //  11223
	    //  Large straight (1,2,3,4,5 - 2,3,4,5,6)
	
	    fun check():Boolean {
	        var set = game.cup.getFullSet()
	
	        //  A small straight means the set cannot have a qty 3+ anywhere
	        //  A large straight means it cannot have a qty 2+ anywhere
	
	        for(i in 0..set.size-1)
	        {
	            if (set[i].qty >= size)
	            {
	                return false
	            }
	        }
	        return true
	
	    }
	
	    fun play() {
	        played = true
	        score = points
		}
	
	}
	
	class ComboFullHouse (val game:Yahtzee) {
	    var score = 0
	
	    var played = false
	
	    fun check () :Boolean {
	        var set = game.cup.getFullSet()
	
	        //  Full House (any 3 + any 2)
	
	        var any3 = false
	        var any2 = false
	
	        for(i in 0..set.size-1)
	        {
	            if (set[i].qty == 3)
	            {
	                any3 = true
	            }
	            else if (set[i].qty == 2)
	            {
	                any2 = true
	            }
	        }
	        return (any3 && any2)
	    }
	
	    fun play () {
	        played = true
	        score = 35
	    }
	
	}
	
	class ComboXOfAKind (val game:Yahtzee, var value:Int, var usePoints:Boolean, var points:Int = 0) {
	    var score = 0
	    var played = false
	
	    fun check ():Boolean {
	
	        var set = game.cup.getFullSet()
	
	        for(i in 0..set.size-1)
	        {
	            if (set[i].qty >= value)
	            {
	                return true
	            }
	        }
	
	        return false
	
	    }
	
	    fun play () {
	
	        if (usePoints == false)
	        {
	            var set = game.cup.getFullSet()
	
	            for(i in 0..set.size-1)
	            {
	                if (set[i].qty >= value)
	                {
	                    score = set[i].value * value
	                }
	            }
	        }
	        else
	        {
	            score = points
	        }
	
	        played = true
	
	    }
	
	}

	lateinit var cup:Cup

	val combo1 = ComboSingle(this, 1)
	val combo2 = ComboSingle(this, 2)
	val combo3 = ComboSingle(this, 3)
	val combo4 = ComboSingle(this, 4)
	val combo5 = ComboSingle(this, 5)
	val combo6 = ComboSingle(this, 6)

	val upperBonus = 0

	val comboThreeOfAKind = ComboXOfAKind(this, 3, false)
	val comboFourOfAKind = ComboXOfAKind(this, 4, false)
	val comboFullHouse = ComboFullHouse(this)
	val comboSmallStraight = ComboStraight(this, 3, 30)
	val comboLargeStraight = ComboStraight(this, 2, 40)
	val comboChance = ComboChance(this)
	val comboYahtzee = ComboXOfAKind(this, 5, true, 50)

	var total = 0

	var roll = 1
	lateinit var rollButton:Sprite
	var canLock = false
	

	override fun preload() {

		load.baseURL = "assets/games/yahtzee/"
		load.image("board")
		load.image("glow")
		load.image("roll")
		load.atlas("dice")
	}

	override fun create() {
		var style = TextStyle( font= "65px Arial", fill= "#ff0044", align= "center" )
		var text = game.add.text(game.world.centerX, game.world.centerY, "- phaser -\nwith a sprinkle of\npixi dust", style)

		add.image(0, 0, "board")

		cup = Cup(this)

		//  Position the die
		for(i in 1..5)
		{
			val die = cup.diceMap.get("die" + i)!!.sprite

			die.x = 120.0 * i
			die.y = 32.0

			world.add(die)
		}

		//  Score sheet

		//var style = TextStyle( font= "65px Arial", fill= "#ff0044", align= "center" )
		//var text = game.add.text(game.world.centerX, game.world.centerY, "- phaser -\nwith a sprinkle of\npixi dust", style)

		rollButton = add.sprite(world.centerX, 528, "roll")
		rollButton.anchor.x = 0.5
		rollButton.inputEnabled = true
		rollButton.input.useHandCursor = true
		rollButton.events.onInputDown.add(this::doRoll, this)

	}

	fun doRoll() {

		console.log("\n\nRoll " + roll)

		cup.shake()

		roll++

		canLock = true

		console.log("1s", combo1.check())
		console.log("2s", combo2.check())
		console.log("3s", combo3.check())
		console.log("4s", combo4.check())
		console.log("5s", combo5.check())
		console.log("6s", combo6.check())
		console.log("3ofaK", comboThreeOfAKind.check())
		console.log("4ofaK", comboFourOfAKind.check())
		console.log("full", comboFullHouse.check())
		console.log("sm. straight", comboSmallStraight.check())
		console.log("lg. straight", comboLargeStraight.check())
		console.log("yahtzee", comboYahtzee.check())
		console.log("chance", comboChance.check())

	}

}

	
