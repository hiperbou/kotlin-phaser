
package examples.groups


import Phaser.*

class Replace: State() {
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create })
	
	override fun preload() {
	
	    game.load.spritesheet("item", "assets/buttons/number-buttons-90x90.png", 90, 90)
	
	}
	
	// Left and right groups
	lateinit var left:Group
	lateinit var right:Group
	
	// The first selected item.
	var selected:Sprite? = null
	
	lateinit var leftText:Text
	lateinit var rightText:Text
	
	override fun create() {
	
	    left = game.add.group()
	    right = game.add.group()
	
	    var item:Sprite
	
	    for(i in 0..3-1)
	    {
	        // Directly create sprites from the left group.
	        item = left.create(290, 98 * (i + 1), "item", i)
	
	        // Enable input
	        item.inputEnabled = true
	        item.events.onInputUp.add(this::select)
	
	        // Add another to the right group.
	        item = right.create(400, 98 * (i + 1), "item", i + 3)
	
	        // Enable input.
	        item.inputEnabled = true
	        item.events.onInputUp.add(this::select)
	    }
	
	    leftText = game.add.text(290, 20, "", TextStyle(font="14px Arial",fill="#fff" ))
	    rightText = game.add.text(400, 20, "", TextStyle(font="14px Arial",fill="#fff" ))
	
	    leftText.text = "Left Group\nTotal: " + left.total
	    rightText.text = "Right Group\nTotal: " + right.total
	
	    game.add.text(260, 450, "Click one item, then another to replace it", TextStyle(font="14px Arial",fill="#fff" ))
	
	}
	
	fun select (item:Sprite, pointer:Pointer) {
	
	    if (selected==null)
	    {
			item.alpha = 0.5
	        selected = item
	    }
	    else
	    {
			run {
				val selected = selected!!
				if (selected.parent !== item.parent) {
					game.add.tween(item).to(object {
						var x = selected.x;
						var y = selected.y
					}, 500, Phaser.Easing.Quartic::Out, true)
					selected.parent.swapChildren(selected, item)
					selected.inputEnabled = false

					leftText.text = "Left Group\nTotal: " + left.total
					rightText.text = "Right Group\nTotal: " + right.total
				} else {
					selected.alpha = 1.0
				}
			}
	        // After checking, now clear the helper var.
	        selected = null
	    }
	    
	}
}