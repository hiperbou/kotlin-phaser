
package examples.games


import Phaser.*
import kotlinx.browser.window
import kotlin.browser.window

class Simon: State() {
	// mods by Patrick OReilly
	// Twitter: @pato_reilly Web: http://patricko.byethost9.com
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.spritesheet("item", "assets/buttons/number-buttons.png", 160, 160)
	}
	
	lateinit var simon:Group
	var N = 1
	var userCount = 0
	var currentCount = 0
	var sequenceCount = 16
	var sequenceList = mutableListOf<Int>()
	var simonSez = false
	var timeCheck = 0.0
	var litSquare:Int = 0
	var winner:Boolean = false
	var loser:Boolean = false
	var intro:Boolean = false
	
	override fun create() {
	
	    simon = game.add.group()
	    var item:Sprite
	
	    for(i in 0..3-1)
	    {
	        item = simon.create(150 + 168 * i, 150, "item", i)
	        // Enable input.
	        item.inputEnabled = true
	        item.input.start(0, true)
	        item.events.onInputDown.add(this::select)
	        item.events.onInputUp.add(this::release)
	        item.events.onInputOut.add(this::moveOff)
	        simon.getAt(i).alpha = 0
	    }
	
	    for(i in 0..3-1)
	    {
	        item = simon.create(150 + 168 * i, 318, "item", i + 3)
	        // Enable input.
	        item.inputEnabled = true
	        item.input.start(0, true)
	        item.events.onInputDown.add(this::select)
	        item.events.onInputUp.add(this::release)
	        item.events.onInputOut.add(this::moveOff)
	        simon.getAt(i + 3).alpha = 0
	    }
	
	    introTween()
	    setUp()
		window.setTimeout({
			simonSequence()
			intro = false
		}, 6000)
	
	}
	
	fun restart() {
	
	    N = 1
	    userCount = 0
	    currentCount = 0
	    sequenceList.clear()
	    winner = false
	    loser = false
	    introTween()
	    setUp()
	    window.setTimeout({
			simonSequence()
			intro=false}, 6000)
	
	}
	
	fun introTween() {
	
	    intro = true
	
	    for(i in 0..6-1)
	    {
	        var flashing = game.add.tween(simon.getAt(i)).to( object{ var  alpha= 1 }, 500, Phaser.Easing.Linear::None, true, 0, 4, true)
	        var final = game.add.tween(simon.getAt(i)).to( object{ var  alpha= .25 }, 500, Phaser.Easing.Linear::None, true)
	
	        flashing.chain(final)
	        flashing.start()
	    }
	
	}
	
	override fun update() {
	
	    if (simonSez)
	    {
	        if (game.time.now - timeCheck >700-N*40)
	        {
	            simon.getAt(litSquare).alpha = .25
	            game.paused = true
	
	            window.setTimeout(
	            {
	                if ( currentCount< N)
	                {
	                    game.paused = false
	                    simonSequence()
	                }
	                else
	                {
	                    simonSez = false
	                    game.paused = false
	                }
	            }, 400 - N * 20)
	        }
	    }
	}
	
	fun playerSequence(selected:Sprite) {
	
	    val correctSquare = sequenceList[userCount]
	    userCount++
	    val thisSquare = simon.getIndex(selected)
	
	    if (thisSquare == correctSquare)
	    {
	        if (userCount == N)
	        {
	            if (N == sequenceCount)
	            {
	                winner = true
	                window.setTimeout({
						restart()
					}, 3000)
	            }
	            else
	            {
	                userCount = 0
	                currentCount = 0
	                N++
	                simonSez = true
	            }
	        }
	    }
	    else
	    {
	        loser = true
	        window.setTimeout(
					{  restart()
					}, 3000)
	    }
	
	}
	
	fun simonSequence () {
	
	    simonSez = true
	    litSquare = sequenceList[currentCount]
	    simon.getAt(litSquare).alpha = 1
	    timeCheck = game.time.now
	    currentCount++
	
	}
	
	fun setUp() {
	
	    for(i in 0..sequenceCount-1)
	    {
	        val thisSquare = game.rnd.integerInRange(0,5)
	        sequenceList.add(thisSquare)
	    }
	
	}
	
	fun select(item:Sprite, pointer:Pointer) {
	
	    if (!simonSez && !intro && !loser && !winner)
	    {
	        item.alpha = 1.0
	    }
	
	}
	
	fun release(item:Sprite, pointer:Pointer) {
	
	    if (!simonSez && !intro && !loser && !winner)
	    {
	        item.alpha = .25
	        playerSequence(item)
	    }
	}
	
	fun moveOff(item:Sprite, pointer:Pointer) {
	
	    if (!simonSez && !intro && !loser && !winner)
	    {
	        item.alpha = .25
	    }
	
	}
	
	override fun render() {
	
	    if (!intro)
	    {
	        if (simonSez)
	        {
	            game.debug.text("Simon Sez", 360, 96, "rgb(255,0,0)")
	        }
	        else
	        {
	            game.debug.text("Your Turn", 360, 96, "rgb(0,255,0)")
	        }
	    }
	    else
	    {
	        game.debug.text("Get Ready", 360, 96, "rgb(0,0,255)")
	    }
	
	    if (winner)
	    {
	        game.debug.text("You Win!", 360, 32, "rgb(0,0,255)")
	    }
	    else if (loser)
	    {
	        game.debug.text("You Lose!", 360, 32, "rgb(0,0,255)")
	    }
	
	}
}