
package examples.games


import Phaser.*

class Invaders: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.image("bullet", "assets/games/invaders/bullet.png")
	    game.load.image("enemyBullet", "assets/games/invaders/enemy-bullet.png")
	    game.load.spritesheet("invader", "assets/games/invaders/invader32x32x4.png", 32, 32)
	    game.load.image("ship", "assets/games/invaders/player.png")
	    game.load.spritesheet("kaboom", "assets/games/invaders/explode.png", 128, 128)
	    game.load.image("starfield", "assets/games/invaders/starfield.png")
	    game.load.image("background", "assets/games/starstruck/background2.png")
	
	}
	
	lateinit var player:Sprite
	lateinit var aliens:Group
	lateinit var bullets:Group
	var bulletTime = 0.0
	lateinit var cursors:CursorKeys
	lateinit var fireButton:Key
	lateinit var explosions:Group
	lateinit var starfield:TileSprite
	var score = 0
	var scoreString = ""
	lateinit var scoreText:Text
	lateinit var lives:Group
	var enemyBullet:Sprite? = null
	var firingTimer = 0.0
	lateinit var stateText:Text
	var livingEnemies = mutableListOf<Sprite>()
	
	lateinit var enemyBullets:Group
	
	override fun create() {
	
	    game.physics.startSystem(Phaser.Physics.ARCADE)
	
	    //  The scrolling starfield background
	    starfield = game.add.tileSprite(0, 0, 800, 600, "starfield")
	
	    //  Our bullet group
	    bullets = game.add.group()
	    bullets.enableBody = true
	    bullets.physicsBodyType = Phaser.Physics.ARCADE
	    bullets.createMultiple(30, "bullet")
	    bullets.setAll("anchor.x", 0.5)
	    bullets.setAll("anchor.y", 1)
	    bullets.setAll("outOfBoundsKill", true)
	    bullets.setAll("checkWorldBounds", true)
	
	    // The enemy"s bullets
	    enemyBullets = game.add.group()
	    enemyBullets.enableBody = true
	    enemyBullets.physicsBodyType = Phaser.Physics.ARCADE
	    enemyBullets.createMultiple(30, "enemyBullet")
	    enemyBullets.setAll("anchor.x", 0.5)
	    enemyBullets.setAll("anchor.y", 1)
	    enemyBullets.setAll("outOfBoundsKill", true)
	    enemyBullets.setAll("checkWorldBounds", true)
	
	    //  The hero!
	    player = game.add.sprite(400, 500, "ship")
	    player.anchor.setTo(0.5, 0.5)
	    game.physics.enable(player, Phaser.Physics.ARCADE)
	
	    //  The baddies!
	    aliens = game.add.group()
	    aliens.enableBody = true
	    aliens.physicsBodyType = Phaser.Physics.ARCADE
	
	    createAliens()
	
	    //  The score
	    scoreString = "Score : "
	    scoreText = game.add.text(10, 10, scoreString + score, object{ var  font= "34px Arial";  var  fill= "#fff" })
	
	    //  Lives
	    lives = game.add.group()
	    game.add.text(game.world.width - 100, 10, "Lives : ", object{ var  font= "34px Arial";  var  fill= "#fff" })
	
	    //  Text
	    stateText = game.add.text(game.world.centerX,game.world.centerY," ", object{ var  font= "84px Arial";  var  fill= "#fff" })
	    stateText.anchor.setTo(0.5, 0.5)
	    stateText.visible = false
	
	    for(i in 0..3-1) 
	    {
	        var ship = lives.create(game.world.width - 100 + (30 * i), 60, "ship")
	        ship.anchor.setTo(0.5, 0.5)
	        ship.angle = 90.0
	        ship.alpha = 0.4
	    }
	
	    //  An explosion pool
	    explosions = game.add.group()
	    explosions.createMultiple(30, "kaboom")
	    explosions.forEach(this::setupInvader, this)
	
	    //  And some controls to play the game with
	    cursors = game.input.keyboard.createCursorKeys()
	    fireButton = game.input.keyboard.addKey(Phaser.Keyboard.SPACEBAR)
	    
	}
	
	fun createAliens () {
	
	    for(y in 0..4-1)
	    {
	        for(x in 0..10-1)
	        {
	            var alien = aliens.create(x * 48, y * 50, "invader")
	            alien.anchor.setTo(0.5, 0.5)
	            alien.animations.add("fly", arrayOf( 0, 1, 2, 3 ), 20, true)
	            alien.play("fly")
	            alien.body.moves = false
	        }
	    }
	
	    aliens.x = 100.0
	    aliens.y = 50.0
	
	    //  All this does is basically start the invaders moving. Notice we"re moving the Group they belong to, rather than the invaders directly.
	    var tween = game.add.tween(aliens).to( object{ var  x= 200 }, 2000, Phaser.Easing.Linear::None, true, 0, 1000, true)
	
	    //  When the tween loops it calls descend
	    tween.onLoop.add(this::descend, this)
	}
	
	fun setupInvader(invader:Sprite) {
	
	    invader.anchor.x = 0.5
	    invader.anchor.y = 0.5
	    invader.animations.add("kaboom")
	
	}
	
	fun descend() {
	
	    aliens.y += 10
	
	}
	
	override fun update() {
	
	    //  Scroll the background
	    starfield.tilePosition.y += 2
	
	    if (player.alive)
	    {
	        //  Reset the player, then check for movement keys
	        player.body.velocity.setTo(0, 0)
	
	        if (cursors.left.isDown)
	        {
	            player.body.velocity.x = -200.0
	        }
	        else if (cursors.right.isDown)
	        {
	            player.body.velocity.x = 200.0
	        }
	
	        //  Firing?
	        if (fireButton.isDown)
	        {
	            fireBullet()
	        }
	
	        if (game.time.now > firingTimer)
	        {
	            enemyFires()
	        }
	
	        //  Run collision
	        game.physics.arcade.overlap(bullets, aliens, this::collisionHandler, null, this)
	        game.physics.arcade.overlap(enemyBullets, player, this::enemyHitsPlayer, null, this)
	    }
	
	}
	
	override fun render() {
	
	    // for(i in 0..aliens.size-1)
	    // {
	    //     game.debug.body(aliens.childrenarrayOf(i))
	    // }
	
	}
	
	fun collisionHandler (bullet:Sprite, alien:Sprite) {
	
	    //  When a bullet hits an alien we kill them both
	    bullet.kill()
	    alien.kill()
	
	    //  Increase the score
	    score += 20
	    scoreText.text = scoreString + score
	
	    //  And create an explosion :)
	    var explosion:Sprite = explosions.getFirstExists(false)!!
	    explosion.reset(alien.body.x, alien.body.y)
	    explosion.play("kaboom", 30, false, true)
	
	    if (aliens.countLiving() == 0)
	    {
	        score += 1000
	        scoreText.text = scoreString + score
	
	        enemyBullets.callAll("kill",this)
	        stateText.text = " You Won, \n Click to restart"
	        stateText.visible = true
	
	        //the "click to restart" handler
	        game.input.onTap.add(this::restart,this)
	    }
	
	}
	
	fun enemyHitsPlayer (player:Sprite,bullet:Sprite) {
	    
	    bullet.kill()
	
	    val live:Sprite? = lives.getFirstAlive()
	
	    if (live!=null)
	    {
	        live.kill()
	    }
	
	    //  And create an explosion :)
	    var explosion:Sprite = explosions.getFirstExists(false)!!
	    explosion.reset(player.body.x, player.body.y)
	    explosion.play("kaboom", 30, false, true)
	
	    // When the player dies
	    if (lives.countLiving() < 1)
	    {
	        player.kill()
	        enemyBullets.callAll("kill")
	
	        stateText.text=" GAME OVER \n Click to restart"
	        stateText.visible = true
	
	        //the "click to restart" handler
	        game.input.onTap.add(this::restart,this)
	    }
	
	}
	
	fun enemyFires () {
	
	    //  Grab the first bullet we can from the pool
	    enemyBullet = enemyBullets.getFirstExists(false)!!
	
	    livingEnemies.clear()
	
	    aliens.forEachAlive({alien:Sprite->
	
	        // put every living enemy in an array
	        livingEnemies.add(alien)
	    })
	
	
	    if (enemyBullet!=null && livingEnemies.size > 0)
	    {
	        
	        var random=game.rnd.integerInRange(0,livingEnemies.size-1)
	
	        // randomly select one of them
	        var shooter=livingEnemies[random]
	        // And fire the bullet from this enemy
	        enemyBullet!!.reset(shooter.body.x, shooter.body.y)
	
	        game.physics.arcade.moveToObject(enemyBullet!!,player,120)
	        firingTimer = game.time.now + 2000
	    }
	
	}
	
	fun fireBullet () {
	
	    //  To avoid them being allowed to fire too fast we set a time limit
	    if (game.time.now > bulletTime)
	    {
	        //  Grab the first bullet we can from the pool
	        val bullet:Sprite? = bullets.getFirstExists(false)
	
	        if (bullet!=null)
	        {
	            //  And fire it
	            bullet.reset(player.x, player.y + 8)
	            bullet.body.velocity.y = -400.0
	            bulletTime = game.time.now + 200
	        }
	    }
	
	}
	
	fun resetBullet(bullet:Bullet) {
	
	    //  Called if the bullet goes out of the screen
	    bullet.kill()
	
	}
	
	fun restart () {
	
	    //  A level starts
	    
	    //resets the life count
	    lives.callAll("revive")
	    //  And brings the aliens back from the dead :)
	    aliens.removeAll()
	    createAliens()
	
	    //revives the player
	    player.revive()
	    //hides the text
	    stateText.visible = false
	
	}
}