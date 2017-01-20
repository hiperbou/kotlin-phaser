
package examples.input


import Phaser.*

class KeyboardJustpressed: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update })
	
	override fun preload() {
	
	    game.load.image("phaser", "assets/sprites/phaser-dude.png")
	    game.load.image("bullet", "assets/misc/bullet0.png")
	
	}
	
	lateinit var sprite:Sprite
	var bullet:Sprite? = null
	lateinit var bullets:Group
	var bulletTime = 0.0
	
	//  Left, right and space key for controls
	lateinit var leftKey:Key
	lateinit var rightKey:Key
	lateinit var spaceKey:Key
	
	//  Helpful text display for justPressed funs.
	lateinit var textLeft:Text
	lateinit var textRight:Text
	lateinit var textSpace:Text
	lateinit var textLeft2:Text
	lateinit var textRight2:Text
	lateinit var textSpace2:Text
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    game.stage.backgroundColor = "#2d2d2d"
	
	    bullets = game.add.group()
	
	    bullets.enableBody = true
	
	    bullets.physicsBodyType = Phaser.Physics.ARCADE
	
	    bullets.createMultiple(10, "bullet")
	    bullets.callAll("events.onOutOfBounds.add",  "events.onOutOfBounds", this::resetBullet, this)
	    bullets.setAll("checkWorldBounds", true)
	
	    sprite = game.add.sprite(400, 550, "phaser")
	
	    game.physics.enable(sprite, Phaser.Physics.ARCADE)
		
		//  Register the keys.
		leftKey = game.input.keyboard.addKey(Phaser.Keyboard.LEFT)
		rightKey = game.input.keyboard.addKey(Phaser.Keyboard.RIGHT)
		spaceKey = game.input.keyboard.addKey(Phaser.Keyboard.SPACEBAR)
	
	    //  Stop the following keys from propagating up to the browser
	    game.input.keyboard.addKeyCapture(mutableListOf( Phaser.Keyboard.LEFT, Phaser.Keyboard.RIGHT, Phaser.Keyboard.SPACEBAR ))
		
		//  Add some debugging text.
		textLeft = game.add.text(20, 20, "Left was pressed 250 ms ago? NO", object{ var  font= "16px Arial";  var  fill= "#ffffff";  var  align= "center" })
		textRight = game.add.text(20, 60, "Right was pressed 500 ms ago? NO", object{ var  font= "16px Arial";  var  fill= "#ffffff";  var  align= "center" })
		textSpace = game.add.text(20, 100, "Space was pressed 1000 ms ago? NO", object{ var  font= "16px Arial";  var  fill= "#ffffff";  var  align= "center" })
		
		textLeft2 = game.add.text(600, 20, "Is left still down? NO", object{ var  font= "16px Arial";  var  fill= "#ffffff";  var  align= "center" })
		textRight2 = game.add.text(600, 60, "Is right still down? NO", object{ var  font= "16px Arial";  var  fill= "#ffffff";  var  align= "center" })
		textSpace2 = game.add.text(600, 100, "Is space still down? NO", object{ var  font= "16px Arial";  var  fill= "#ffffff";  var  align= "center" })
	
	}
	
	override fun update() {
	
	    sprite.body.velocity.x = 0.0
	    sprite.body.velocity.y = 0.0
	
		//  If true, it means that this key is down. If not, it means that the key is not down (was released/not pressed)
	    if (leftKey.isDown)
	    {
	        sprite.body.velocity.x = -200.0
			textLeft2.text = "Is left still down? YES"
	    } 
		else 
		{
			textLeft2.text = "Is left still down? NO"
		}
		
	    if (rightKey.isDown)
	    {
	        sprite.body.velocity.x = 200.0
			textRight2.text = "Is right still down? YES"
	    }
		else 
		{
			textRight2.text = "Is right still down? NO"
		}
	
	    if (spaceKey.isDown)
	    {
	        fireBullet()
			textSpace2.text = "Is space still down? YES"
	    }
		else 
		{
			textSpace2.text = "Is space still down? NO"
		}
		
		//  downDuration (previously called "justPressed") does not schedule key pressing, it"s merely indicative 
	    //  of key states. 
	    //  
	    //  In this case the downDuration fun tells us that between this current time and 250 milliseconds ago, 
	    //  this key was pressed (not the same as holding down) and if it was pressed between that slice of time, it returns
		//  true, otherwise false.
		if (leftKey.downDuration(250))
		{
			textLeft.text = "Left was pressed 250 ms ago? YES"
		} 
		else
		{
			textLeft.text = "Left was pressed 250 ms ago? NO"
		}
		
		if (rightKey.downDuration(500))
		{
			textRight.text = "Right was pressed 500 ms ago? YES"
		} 
		else
		{
			textRight.text = "Right was pressed 500 ms ago? NO"
		}
		
		if (spaceKey.downDuration(1000))
		{
			textSpace.text = "Space was pressed 1000 ms ago? YES"
		} 
		else
		{
			textSpace.text = "Space was pressed 1000 ms ago? NO"
		}
	
	}
	
	fun fireBullet () {
	
	    if (game.time.now > bulletTime)
	    {
	        bullet = bullets.getFirstExists<Sprite>(false)
	
	        if (bullet != null)
	        {
	            bullet!!.reset(sprite.x + 6, sprite.y - 8)
	            bullet!!.body.velocity.y = -300.0
	            bulletTime = game.time.now + 250
	        }
	    }
	
	}
	
	//  Called if the bullet goes out of the screen
	fun resetBullet(bullet:Bullet) {
	
	    bullet.kill()
	
	}
	
}