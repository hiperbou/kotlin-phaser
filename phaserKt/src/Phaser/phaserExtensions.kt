package Phaser

/*val AUTO:Number = 0// AUTO renderer - picks between WebGL or Canvas based on device.
val CANVAS:Number = 1//Canvas Renderer.
val WEBGL:Number = 2// WebGL Renderer.
val HEADLESS:Number = 3//Headless renderer (not visual output)
val WEBGL_MULTI:Number = 4//WebGL Renderer with MultiTexture support enabled.
*/
val kPI2 = kotlin.math.PI*2
val kPI = kotlin.math.PI

fun Phaser.Math.Companion.sin(value:Double):Double { return kotlin.math.sin(value) }
fun Phaser.Math.Companion.cos(value:Double):Double { return kotlin.math.cos(value) }
val Phaser.Math.Companion.PI2:Double get() { return kPI2 }
val Phaser.Math.Companion.PI: Double get() { return kPI }
fun Phaser.Math.Companion.round(value: Number): Int { return kotlin.math.round(value.toDouble()).toInt()}
fun Phaser.Math.Companion.floor(value: Number): Int { return kotlin.math.round(value.toDouble()).toInt()}
fun Phaser.Math.Companion.atan2(x: Double,y:Double): Double { return kotlin.math.atan2(x,y)}
fun Phaser.Math.Companion.sqrt(value: Double): Double { return kotlin.math.sqrt(value)}
fun Phaser.Math.Companion.abs(value: Double): Double { return kotlin.math.abs(value)}
fun Phaser.Math.Companion.random(): Double { return kotlin.random.Random.nextDouble()}
fun Phaser.Math.Companion.random(min: Int, max: Int): Int{ return (random()*(max-min)+min).toInt() }

@JsName("cropKt")
fun Phaser.Sprite.crop(rect: Phaser.Rectangle, copy: Boolean?=null) {
    cropJs(rect,copy)
}

@JsName("destroyKt")
fun Phaser.Sprite.destroy(destroyChildren: Boolean?=null, unknown: Boolean?=null) {
    destroyJs(destroyChildren,unknown)
}

@JsName("reviveKt")
fun Phaser.Sprite.revive(health: Number=100): Phaser.Sprite {
    return reviveJs(health)
}

@JsName("resetKt")
fun Phaser.Sprite.reset(x: Number?=null, y: Number?=null, health: Number?=null): Phaser.Sprite {
    return resetJs(x,y,health)
}
@JsName("setScaleMinMaxKt")
fun Phaser.Sprite.setScaleMinMax(minX: Number?=null, minY: Number?=null, maxX: Number?=null, maxY: Number?=null): Unit = setScaleMinMaxJs(minX,minY,maxX,maxY)

@JsName("setTextureKt")
fun PIXI.Sprite.setTexture(texture: PIXI.Texture): Unit
{
    setTextureJs(texture, undefined)
}
@JsName("setTextureKt2")
fun PIXI.Sprite.setTexture(texture: Phaser.RenderTexture): Unit
{
    setTextureJs(texture, undefined)
}
@JsName("setTextureKt3")
fun PIXI.Sprite.setTexture(texture: PIXI.Texture, destroyBase: Boolean): Unit
{
    setTextureJs(texture,destroyBase)
}
@JsName("setTextureKt4")
fun PIXI.Sprite.setTexture(texture: Phaser.RenderTexture, destroyBase: Boolean): Unit
{
    setTextureJs(texture,destroyBase)
}
@JsName("getBoundsKt")
fun PIXI.DisplayObjectContainer.getBounds(): Phaser.Rectangle
{
    return getBoundsJs(null)
}
@JsName("getBoundsKt1")
fun PIXI.DisplayObjectContainer.getBounds(targetCoordinateSpace: PIXI.Matrix): Phaser.Rectangle
{
    return getBoundsJs(targetCoordinateSpace)
}
@JsName("getBoundsKt2")
fun PIXI.DisplayObjectContainer.getBounds(targetCoordinateSpace: PIXI.DisplayObject): Phaser.Rectangle
{
    return getBoundsJs(targetCoordinateSpace)
}
@JsName("alignKt")
fun PIXI.DisplayObject.alignTo(container: PIXI.DisplayObject, position: Number?=null, offsetX: Number?=null, offsetY: Number?=null): PIXI.Sprite
{
    return alignToJs(container,position,offsetX,offsetY)
}

@JsName("enableKt")
fun Phaser.Physics.Arcade.enable(spr: Sprite, children: Boolean? = undefined): Unit
{
    enableJs(spr,children)
}
@JsName("enableKt2")
fun Phaser.Physics.Arcade.enable(array: Array<Sprite>, children: Boolean? = undefined): Unit
{
    enableJs(array,children)
}
@JsName("enableKt3")
fun Phaser.Physics.Arcade.enable(spr: BitmapText, children: Boolean? = undefined): Unit
{
    enableJs(spr,children)
}
@JsName("enableKt4")
fun Phaser.Physics.Arcade.enable(array: Array<BitmapText>, children: Boolean? = undefined): Unit
{
    enableJs(array,children)
}
@JsName("enableKt5")
fun Phaser.Physics.Arcade.enable(spr: Text, children: Boolean? = undefined): Unit
{
    enableJs(spr,children)
}
@JsName("enableKt6")
fun Phaser.Physics.Arcade.enable(array: Array<Text>, children: Boolean? = undefined): Unit
{
    enableJs(array,children)
}
@JsName("enableKt7")
fun Phaser.Physics.Arcade.enable(group: Group, children: Boolean? = undefined): Unit
{
    enableJs(group,children)
}
@JsName("enableKt8")
fun Phaser.Physics.Arcade.enable(array: Array<Group>, children: Boolean? = undefined): Unit
{
    enableJs(array,children)
}
@JsName("enableKt9")
fun Phaser.Physics.Arcade.enable(spr: Graphics, children: Boolean? = undefined): Unit
{
    enableJs(spr,children)
}
@JsName("enableKt10")
fun Phaser.Physics.Arcade.enable(array: Array<Graphics>, children: Boolean? = undefined): Unit
{
    enableJs(array,children)
}

/*external interface AssetName

data class Asset(@JsName("name") val name: AssetName, @JsName("url") val url: String) {
    constructor(name: String, url: String) : this(name as AssetName, url)
}*/
data class Asset(val name: String, val url: String)

fun Phaser.StateManager.start(state: Phaser.State, clearWorld: Boolean? = null, clearCache: Boolean? = null, vararg args: Any): Unit {
    val stateID = state::class.js.name
    add(stateID, state, false)
    start(stateID )
}

external interface GameStateType

fun GameStateType(name: String): GameStateType = name as GameStateType

open class GameState(game: Phaser.Game) {
    open fun preload() {
    }

    open fun create() {
    }

    open fun update() {
    }

    open fun render() {
    }
}

fun Game(config:Phaser.IGameConfig):Game {
    return Game(config.width, config.height, config.renderer,
            config.parent, config.state, config.transparent,
            config.antialias, config.physicsConfig)
}

external interface PhaserState {
    fun add(state: GameStateType, clazz: (game: Phaser.Game) -> GameState)
    fun start(state: GameStateType)
}


external interface TextStyle {
    var font: String
    var fontStyle: String
    var fontVariant: String
    var fontWeight: Int
    var fontSize: String
    var backgroundColor: String
    var fill: String
    var align: String
    var boundsAlignH: String
    var boundsAlignV: String
    var stroke: String
    var strokeThickness: Number
    var wordWrap: Boolean
    var wordWrapWidth: Int
    var tabs: Int
}

fun TextStyle(
        font: String? = null, // "bold 20pt Arial"
        fontStyle: String? = null, // (from font)
        fontVariant: String? = null, // (from font)
        fontWeight: Int? = null, // (from font)
        fontSize: String? = null, // (from font)
        backgroundColor: String? = null,
        fill: String? = null, // 'black'
        align: String? = null, // 'left'
        boundsAlignH: String? = null, //
        boundsAlignV: String? = null, //
        stroke: String? = null, // 'black'
        strokeThickness: Number? = null, // 0
        wordWrap: Boolean? = null, // false
        wordWrapWidth: Int? = null, // 100
        tabs: Int? = null // 0
): TextStyle {
    var out = js("({})")
    if (font != null) out.font = font
    if (fontStyle != null) out.fontStyle = fontStyle
    if (fontVariant != null) out.fontVariant = fontVariant
    if (fontWeight != null) out.fontWeight = fontWeight
    if (fontSize != null) out.fontSize = fontSize
    if (backgroundColor != null) out.backgroundColor = backgroundColor
    if (fill != null) out.fill = fill
    if (align != null) out.align = align
    if (boundsAlignH != null) out.boundsAlignH = boundsAlignH
    if (boundsAlignV != null) out.boundsAlignV = boundsAlignV
    if (stroke != null) out.stroke = stroke
    if (strokeThickness != null) out.strokeThickness = strokeThickness
    if (wordWrap != null) out.wordWrap = wordWrap
    if (wordWrapWidth != null) out.wordWrapWidth = wordWrapWidth
    if (tabs != null) out.tabs = tabs
    return out
}

fun GameConfig(
        enableDebug: Boolean? = null,
        width: Number? = null,
        height: Number? = null,
        renderer: Number? = null,
        parent: Any? = null,
        transparent: Boolean? = null,
        antialias: Boolean? = null,
        resolution: Number? = null,
        physicsConfig: Any? = null,
        state: Phaser.State? = null
): IGameConfig {
    var out = js("({})")
    if (enableDebug != null) out.enableDebug = enableDebug
    if (width != null) out.width = width
    if (height != null) out.height = height
    if (renderer != null) out.renderer = renderer
    if (parent != null) out.parent = parent
    if (transparent != null) out.transparent = transparent
    if (antialias != null) out.antialias = antialias
    if (resolution != null) out.resolution = resolution
    if (physicsConfig != null) out.physicsConfig = physicsConfig
    if (state != null) out.state = state
    return out
}

interface IGameConfig {
    var width: Number? //
    var height: Number? //
    var renderer: Number? //
    var parent: Any? //
    var transparent: Boolean? //
    var antialias: Boolean? //
    var resolution: Number? //
    var physicsConfig: Any? //
    var state: Phaser.State? //
}

fun ContactMaterialOptions(
        friction: Number? = null,
        restitution: Number? = null,
        stiffness: Number? = null,
        relaxation: Number? = null,
        frictionStiffness: Number? = null,
        frictionRelaxation: Number? = null,
        surfaceVelocity: Number? = null
): IContactMaterialOptions {
    var out = js("({})")
    if (friction != null) out.friction = friction
    if (restitution != null) out.restitution = restitution
    if (stiffness != null) out.stiffness = stiffness
    if (relaxation != null) out.relaxation = relaxation
    if (frictionStiffness != null) out.frictionStiffness = frictionStiffness
    if (frictionRelaxation != null) out.frictionRelaxation = frictionRelaxation
    if (surfaceVelocity != null) out.surfaceVelocity = surfaceVelocity
    return out
}
interface IContactMaterialOptions {
    var friction: Number
    var restitution: Number
    var stiffness: Number
    var relaxation: Number
    var frictionStiffness: Number
    var frictionRelaxation: Number
    var surfaceVelocity: Number
}

fun Phaser.Loader.image(asset: Asset) = this.image(asset.name, asset.url)
fun Phaser.Loader.images(vararg assets: Asset) = assets.forEach { this.image(it.name, it.url) }
fun Phaser.Loader.images(assets: List<Asset>) = assets.forEach { this.image(it.name, it.url) }
fun Phaser.Loader.sound(asset: Asset) = this.audio(asset.name, asset.url)
fun Phaser.Loader.sounds(vararg assets: Asset) = assets.forEach { this.audio(it.name, it.url) }
fun Phaser.Loader.sounds(assets: List<Asset>) = assets.forEach { this.audio(it.name, it.url) }

interface DirectionObj {
    var up: Boolean
    var down: Boolean
    var left: Boolean
    var right: Boolean
}
