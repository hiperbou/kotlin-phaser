
package examples.games


import Phaser.*

class Tanks: State() {
	
	class EnemyTank (val index:Int, val game:Game, val player:Sprite, val bullets:Group) {
	    var x = game.world.randomX
	    var y = game.world.randomY
	
	    var health = 3

	    var fireRate = 1000
	    var nextFire = 0.0
	    var alive = true
	
	    val shadow = game.add.sprite(x, y, "enemy", "shadow")
	    val tank = game.add.sprite(x, y, "enemy", "tank1")
	    val turret = game.add.sprite(x, y, "enemy", "turret")

		init {
			shadow.anchor.set(0.5)
			tank.anchor.set(0.5)
			turret.anchor.set(0.3, 0.5)

			tank.name = index.toString()
			game.physics.enable(tank, Phaser.Physics.ARCADE)
			tank.body.immovable = false
			tank.body.collideWorldBounds = true
			tank.body.bounce.setTo(1, 1)

			tank.angle = game.rnd.angle()

			game.physics.arcade.velocityFromRotation(tank.rotation, 100, tank.body.velocity)
		}

	
		fun damage():Boolean {

			health -= 1

			if (health <= 0)
			{
				alive = false

				shadow.kill()
				tank.kill()
				turret.kill()

				return true
			}

			return false

		}

		fun update() {

			shadow.x = tank.x
			shadow.y = tank.y
			shadow.rotation = tank.rotation

			turret.x = tank.x
			turret.y = tank.y
			turret.rotation = game.physics.arcade.angleBetween(tank, player)

			if (game.physics.arcade.distanceBetween(tank, player) < 300)
			{
				if (game.time.now > nextFire && bullets.countDead() > 0)
				{
					nextFire = game.time.now + fireRate

					var bullet:Sprite = bullets.getFirstDead()!!

					bullet.reset(turret.x, turret.y)

					bullet.rotation = game.physics.arcade.moveToObject(bullet, player, 500)
				}
			}

		}
	}
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	override fun preload() {
	
	    game.load.atlas("tank", "assets/games/tanks/tanks.png", "assets/games/tanks/tanks.json")
	    game.load.atlas("enemy", "assets/games/tanks/enemy-tanks.png", "assets/games/tanks/tanks.json")
	    game.load.image("logo", "assets/games/tanks/logo.png")
	    game.load.image("bullet", "assets/games/tanks/bullet.png")
	    game.load.image("earth", "assets/games/tanks/scorched_earth.png")
	    game.load.spritesheet("kaboom", "assets/games/tanks/explosion.png", 64, 64, 23)
	    
	}
	
	lateinit var land:TileSprite
	
	lateinit var shadow:Sprite
	lateinit var tank:Sprite
	lateinit var turret:Sprite
	
	var enemies = mutableListOf<EnemyTank>()
	lateinit var enemyBullets:Group
	var enemiesTotal = 0
	var enemiesAlive = 0
	lateinit var explosions:Group
	
	lateinit var logo:Sprite
	
	var currentSpeed = 0
	lateinit var cursors:CursorKeys
	
	lateinit var bullets:Group
	var fireRate = 100
	var nextFire = 0.0
	
	override fun create() {
	
	    //  Resize our game world to be a 2000 x 2000 square
	    game.world.setBounds(-1000, -1000, 2000, 2000)
	
	    //  Our tiled scrolling background
	    land = game.add.tileSprite(0, 0, 800, 600, "earth")
	    land.fixedToCamera = true
	
	    //  The base of our tank
	    tank = game.add.sprite(0, 0, "tank", "tank1")
	    tank.anchor.setTo(0.5, 0.5)
	    tank.animations.add("move", arrayOf("tank1", "tank2", "tank3", "tank4", "tank5", "tank6"), 20, true)
	
	    //  This will force it to decelerate and limit its speed
	    game.physics.enable(tank, Phaser.Physics.ARCADE)
	    tank.body.drag.set(0.2)
	    tank.body.maxVelocity.setTo(400, 400)
	    tank.body.collideWorldBounds = true
	
	    //  Finally the turret that we place on-top of the tank body
	    turret = game.add.sprite(0, 0, "tank", "turret")
	    turret.anchor.setTo(0.3, 0.5)
	
	    //  The enemies bullet group
	    enemyBullets = game.add.group()
	    enemyBullets.enableBody = true
	    enemyBullets.physicsBodyType = Phaser.Physics.ARCADE
	    enemyBullets.createMultiple(100, "bullet")
	    
	    enemyBullets.setAll("anchor.x", 0.5)
	    enemyBullets.setAll("anchor.y", 0.5)
	    enemyBullets.setAll("outOfBoundsKill", true)
	    enemyBullets.setAll("checkWorldBounds", true)
	
	    //  Create some baddies to waste :)
	    enemies = mutableListOf<EnemyTank>()
	
	    enemiesTotal = 20
	    enemiesAlive = 20
	
	    for(i in 0..enemiesTotal-1)
	    {
	        enemies.add(EnemyTank(i, game, tank, enemyBullets))
	    }
	
	    //  A shadow below our tank
	    shadow = game.add.sprite(0, 0, "tank", "shadow")
	    shadow.anchor.setTo(0.5, 0.5)
	
	    //  Our bullet group
	    bullets = game.add.group()
	    bullets.enableBody = true
	    bullets.physicsBodyType = Phaser.Physics.ARCADE
	    bullets.createMultiple(30, "bullet", 0, false)
	    bullets.setAll("anchor.x", 0.5)
	    bullets.setAll("anchor.y", 0.5)
	    bullets.setAll("outOfBoundsKill", true)
	    bullets.setAll("checkWorldBounds", true)
	
	    //  Explosion pool
	    explosions = game.add.group()
	
	    for(i in 0..10-1)
	    {
	        var explosionAnimation = explosions.create(0, 0, "kaboom", 0, false)
	        explosionAnimation.anchor.setTo(0.5, 0.5)
	        explosionAnimation.animations.add("kaboom")
	    }
	
	    tank.bringToTop()
	    turret.bringToTop()
	
	    logo = game.add.sprite(0, 200, "logo")
	    logo.fixedToCamera = true
	
	    game.input.onDown.add(this::removeLogo, this)
	
	    game.camera.follow(tank)
	    game.camera.deadzone = Phaser.Rectangle(150, 150, 500, 300)
	    game.camera.focusOnXY(0, 0)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	fun removeLogo () {
	
	    game.input.onDown.remove(this::removeLogo, this)
	    logo.kill()
	
	}
	
	override fun update() {
	
	    game.physics.arcade.overlap(enemyBullets, tank, this::bulletHitPlayer, null, this)
	
	    enemiesAlive = 0
	
	    for(i in 0..enemies.size-1)
	    {
	        if (enemies[i].alive)
	        {
	            enemiesAlive++
	            game.physics.arcade.collide(tank, enemies[i].tank)
	            game.physics.arcade.overlap(bullets, enemies[i].tank, this::bulletHitEnemy, null, this)
	            enemies[i].update()
	        }
	    }
	
	    if (cursors.left.isDown)
	    {
	        tank.angle -= 4
	    }
	    else if (cursors.right.isDown)
	    {
	        tank.angle += 4
	    }
	
	    if (cursors.up.isDown)
	    {
	        //  The speed we"ll travel at
	        currentSpeed = 300
	    }
	    else
	    {
	        if (currentSpeed > 0)
	        {
	            currentSpeed -= 4
	        }
	    }
	
	    if (currentSpeed > 0)
	    {
	        game.physics.arcade.velocityFromRotation(tank.rotation, currentSpeed, tank.body.velocity)
	    }
	
	    land.tilePosition.x = -game.camera.x
	    land.tilePosition.y = -game.camera.y
	
	    //  Position all the parts and align rotations
	    shadow.x = tank.x
	    shadow.y = tank.y
	    shadow.rotation = tank.rotation
	
	    turret.x = tank.x
	    turret.y = tank.y
	
	    turret.rotation = game.physics.arcade.angleToPointer(turret)
	
	    if (game.input.activePointer.isDown)
	    {
	        //  Boom!
	        fire()
	    }
	
	}
	
	fun bulletHitPlayer (tank:Sprite, bullet:Sprite) {
	
	    bullet.kill()
	
	}
	
	fun bulletHitEnemy (tank:Sprite, bullet:Sprite) {
	
	    bullet.kill()

	    var destroyed = enemies[parseInt(tank.name)].damage()
	
	    if (destroyed)
	    {
	        var explosionAnimation:Sprite = explosions.getFirstExists(false)!!
	        explosionAnimation.reset(tank.x, tank.y)
	        explosionAnimation.play("kaboom", 30, false, true)
	    }
	
	}
	
	fun fire () {
	
	    if (game.time.now > nextFire && bullets.countDead() > 0)
	    {
	        nextFire = game.time.now + fireRate
	
	        var bullet:Sprite = bullets.getFirstExists(false)!!
	
	        bullet.reset(turret.x, turret.y)
	
	        bullet.rotation = game.physics.arcade.moveToPointer(bullet, 1000, game.input.activePointer, 500)
	    }
	
	}
	
	override fun render() {
	
	    // game.debug.text("Active Bullets: " + bullets.countLiving() + " / " + bullets.size, 32, 32)
	    game.debug.text("Enemies: " + enemiesAlive + " / " + enemiesTotal, 32, 32)
	
	}
	
}