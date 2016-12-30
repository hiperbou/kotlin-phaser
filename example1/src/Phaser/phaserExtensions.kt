package Phaser

/*external interface AssetName

data class Asset(@JsName("name") val name: AssetName, @JsName("url") val url: String) {
    constructor(name: String, url: String) : this(name as AssetName, url)
}*/
data class Asset(val name: String, val url: String)

fun Phaser.StateManager.start(state: State, clearWorld: Boolean? = null, clearCache: Boolean? = null, vararg args: Any): Unit {
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
        preserveDrawingBuffer: Boolean? = null,
        physicsConfig: Any? = null,
        seed: String? = null,
        state: Phaser.State? = null,
        forceSetTimeOut: Boolean? = null,
        multiTextue: Boolean? = null
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
    if (preserveDrawingBuffer != null) out.preserveDrawingBuffer = preserveDrawingBuffer
    if (physicsConfig != null) out.physicsConfig = physicsConfig
    if (seed != null) out.seed = seed
    if (state != null) out.state = state
    if (forceSetTimeOut != null) out.forceSetTimeOut = forceSetTimeOut
    if (multiTextue != null) out.multiTextue = multiTextue
    return out
}

fun Loader.image(asset: Asset) = this.image(asset.name, asset.url)
fun Loader.images(vararg assets: Asset) = assets.forEach { this.image(it.name, it.url) }
fun Loader.images(assets: List<Asset>) = assets.forEach { this.image(it.name, it.url) }
fun Loader.sound(asset: Asset) = this.audio(asset.name, asset.url)
fun Loader.sounds(vararg assets: Asset) = assets.forEach { this.audio(it.name, it.url) }
fun Loader.sounds(assets: List<Asset>) = assets.forEach { this.audio(it.name, it.url) }

interface DirectionObj {
    var up: Boolean
    var down: Boolean
    var left: Boolean
    var right: Boolean
}
