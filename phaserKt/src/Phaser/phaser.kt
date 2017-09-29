@file:JsModule("Phaser")
@file:JsNonModule

package Phaser

import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.Event
import org.w3c.dom.events.KeyboardEvent
import org.w3c.dom.events.MouseEvent
import org.w3c.files.Blob
import org.w3c.xhr.XMLHttpRequest


external var VERSION: String
external var DEV_VERSION: String
//var GAMES: Array<Phaser.Game>

external var AUTO: Number

external var CANVAS: Number

external var WEBGL: Number

external var HEADLESS: Number

external var WEBGL_MULTI: Number


external val BITMAPDATA: Number

external val BITMAPTEXT: Number

external val BUTTON: Number

external val CANVAS_FILTER: Number

external val CIRCLE: Number

external val ELLIPSE: Number

external val EMITTER: Number

external val GRAPHICS: Number

external val GROUP: Number

external val IMAGE: Number

external val LINE: Number

external val MATRIX: Number

external val POINT: Number

external val POINTER: Number

external val POLYGON: Number

external val RECTANGLE: Number

external val ROUNDEDRECTANGLE: Number

external val RENDERTEXTURE: Number

external val RETROFONT: Number

external val SPRITE: Number

external val SPRITEBATCH: Number

external val TEXT: Number

external val TILEMAP: Number

external val TILEMAPLAYER: Number

external val TILESPRITE: Number

external val WEBGL_FILTER: Number

external val ROPE: Number

external val CREATURE: Number

external val VIDEO: Number

external val NONE: Number

external val LEFT: Number

external val RIGHT: Number

external val UP: Number

external val DOWN: Number

external val HORIZONTAL: Number

external val VERTICAL: Number

external val LANDSCAPE: Number

external val PORTRAIT: Number

external val ANGLE_UP: Number

external val ANGLE_DOWN: Number

external val ANGLE_LEFT: Number

external val ANGLE_RIGHT: Number

external val ANGLE_NORTH_EAST: Number

external val ANGLE_NORTH_WEST: Number

external val ANGLE_SOUTH_EAST: Number

external val ANGLE_SOUTH_WEST: Number

external val TOP_LEFT: Number

external val TOP_CENTER: Number

external val TOP_RIGHT: Number

external val LEFT_TOP: Number

external val LEFT_CENTER: Number

external val LEFT_BOTTOM: Number

external val CENTER: Number

external val RIGHT_TOP: Number

external val RIGHT_CENTER: Number

external val RIGHT_BOTTOM: Number

external val BOTTOM_LEFT: Number

external val BOTTOM_CENTER: Number

external val BOTTOM_RIGHT: Number

external val MIDDLE_LEFT: Number

external val MIDDLE_CENTER: Number

external val MIDDLE_RIGHT: Number


external open class Animation {
    constructor(game: Phaser.Game, parent: Phaser.Sprite, name: String, frameData: Phaser.FrameData, frames: Array<Number>, frameRate: Number? = definedExternally, loop: Boolean? = definedExternally)
    constructor(game: Phaser.Game, parent: Phaser.Sprite, name: String, frameData: Phaser.FrameData, frames: Array<String>, frameRate: Number? = definedExternally, loop: Boolean? = definedExternally)

    open var currentFrame: Phaser.Frame
    open var delay: Number
    open var enableUpdate: Boolean
    open var frame: Number
    open var frameTotal: Number
    open var game: Phaser.Game
    open var isFinished: Boolean
    open var isPaused: Boolean
    open var isPlaying: Boolean
    open var killOnComplete: Boolean
    open var loop: Boolean
    open var loopCount: Number
    open var name: String
    open var onComplete: Phaser.Signal
    open var onLoop: Phaser.Signal
    open var onStart: Phaser.Signal2<Sprite, Animation>
    open var onUpdate: Phaser.SignalAnimationFrame
    open var paused: Boolean
    open var reversed: Boolean
    open var speed: Number
    open fun complete(): Unit
    open fun destroy(): Unit
    open fun next(quantity: Number? = definedExternally): Unit
    open fun onPause(): Unit
    open fun onResume(): Unit
    open fun play(frameRate: Number? = definedExternally, loop: Boolean? = definedExternally, killOnComplete: Boolean? = definedExternally): Phaser.Animation
    open fun previous(quantity: Number? = definedExternally): Unit
    open fun restart(): Unit
    open fun reverse(): Animation
    open fun reverseOnce(): Animation
    open fun setFrame(frameId: String? = definedExternally, useLocalFrameIndex: Boolean? = definedExternally): Unit
    open fun setFrame(frameId: Number? = definedExternally, useLocalFrameIndex: Boolean? = definedExternally): Unit
    open fun stop(resetFrame: Boolean? = definedExternally, dispatchComplete: Boolean? = definedExternally): Unit
    open fun update(): Boolean
    open fun updateCurrentFrame(signalUpdate: Boolean, fromPlay: Boolean? = definedExternally): Boolean
    open fun updateFrameData(frameData: FrameData): Unit

    companion object {
        //fun generateFrameNames(prefix: String, start: Number, stop: Number, suffix: String? = definedExternally, zeroPad: Number? = definedExternally): MutableList<String>
        fun generateFrameNames(prefix: String, start: Number, stop: Number, suffix: String? = definedExternally, zeroPad: Number? = definedExternally): Array<String>
    }
}


external open class AnimationManager(sprite: Phaser.Sprite) {
    open var currentAnim: Phaser.Animation
    open var currentFrame: Phaser.Frame
    open var frame: Number
    open var frameData: Phaser.FrameData
    open var frameName: String
    open var frameTotal: Int
    open var game: Phaser.Game
    open var isLoaded: Boolean
    open var name: String
    open var paused: Boolean
    open var sprite: Phaser.Sprite
    open var updateIfVisible: Boolean
    //open fun add(name: String, frames: Array<Number>? = definedExternally, frameRate: Number? = definedExternally, loop: Boolean? = definedExternally, useNumericIndex: Boolean? = definedExternally): Phaser.Animation
    //open fun add(name: String, frames: Array<String>? = definedExternally, frameRate: Number? = definedExternally, loop: Boolean? = definedExternally, useNumericIndex: Boolean? = definedExternally): Phaser.Animation
    open fun add(name: String): Phaser.Animation

    open fun add(name: String, frames: Array<Int>): Phaser.Animation
    open fun add(name: String, frames: Array<Int>?, frameRate: Number?): Phaser.Animation
    open fun add(name: String, frames: Array<Int>?, frameRate: Number?, loop: Boolean?): Phaser.Animation
    open fun add(name: String, frames: Array<Int>?, frameRate: Number?, loop: Boolean?, useNumericIndex: Boolean?): Phaser.Animation
    open fun add(name: String, frames: Array<String>?): Phaser.Animation
    open fun add(name: String, frames: Array<String>?, frameRate: Number?): Phaser.Animation
    open fun add(name: String, frames: Array<String>?, frameRate: Number?, loop: Boolean?): Phaser.Animation
    open fun add(name: String, frames: Array<String>?, frameRate: Number?, loop: Boolean?, useNumericIndex: Boolean?): Phaser.Animation
    open fun copyFrameData(frameData: Phaser.FrameData, frame: String): Boolean
    open fun copyFrameData(frameData: Phaser.FrameData, frame: Number): Boolean
    open fun destroy(): Unit
    open fun getAnimation(name: String): Phaser.Animation
    open fun next(quantity: Number? = definedExternally): Unit
    open fun play(name: String, frameRate: Number? = definedExternally, loop: Boolean? = definedExternally, killOnComplete: Boolean? = definedExternally): Phaser.Animation
    open fun previous(quantity: Number? = definedExternally): Unit
    open fun stop(name: String? = definedExternally, resetFrame: Boolean? = definedExternally): Unit
    open fun update(): Boolean
    open fun validateFrames(frames: Array<Phaser.Frame>, useNumericIndex: Boolean? = definedExternally): Boolean
}


external open class AnimationParser {
    companion object {
        fun JSONData(game: Phaser.Game, json: Any): Phaser.FrameData
        fun JSONDataHash(game: Phaser.Game, json: Any): Phaser.FrameData
        fun JSONDataPyxel(game: Phaser.Game, json: Any): Phaser.FrameData
        fun spriteSheet(game: Phaser.Game, key: String, frameWidth: Number, frameHeight: Number, frameMax: Number? = definedExternally, margin: Number? = definedExternally, spacing: Number? = definedExternally, skipFrames: Number? = definedExternally): Phaser.FrameData
        fun XMLData(game: Phaser.Game, xml: Any): Phaser.FrameData
    }
}


external open class AudioSprite(game: Phaser.Game, key: String) {
    open var game: Phaser.Game
    open var key: String
    open var config: Any
    open var autoplayKey: String
    open var autoplay: Boolean
    open var sounds: Any
    open fun get(marker: String): Phaser.Sound
    open fun play(marker: String, volume: Number? = definedExternally): Phaser.Sound
    open fun stop(marker: String): Phaser.Sound
    open var allowMultiple: Boolean
}


external open class ArraySet(list: Array<Any>) {
    open var position: Number
    open var list: Array<Any>
    open var total: Number
    open var first: Any
    open var next: Any
    open fun add(item: Any): Any
    open fun getByKey(property: String, value: Any): Any
    open fun getIndex(item: Any): Number
    open fun exists(item: Any): Boolean
    open fun reset(): Unit
    open fun remove(item: Any): Any
    open fun removeAll(destoy: Boolean? = definedExternally): Unit
    open fun setAll(key: Any, value: Any): Unit
    open fun callAll(key: String, vararg parameter: Any): Unit
}


external open class ArrayUtils {
    companion object {
        fun <T> getRandomItem(objects: Array<T>, startIndex: Number? = definedExternally, length: Number? = definedExternally): T
        fun <T> removeRandomItem(objects: Array<T>, startIndex: Number? = definedExternally, length: Number? = definedExternally): T
        fun <T> shuffle(array: Array<T>): Array<T>
        fun <T> transposeMatrix(array: Array<T>): T
        fun rotateMatrix(matrix: Any, direction: Number): Any
        fun rotateMatrix(matrix: Any, direction: String): Any
        fun findClosest(value: Number, arr: Array<Number>): Number
        fun rotate(array: Array<Any>): Any
        fun rotateLeft(array: Array<Any>): Any
        fun rotateRight(array: Array<Any>): Any
        fun numberArray(start: Number, end: Number): Array<Number>
        fun numberArrayStep(start: Number, end: Number? = definedExternally, step: Number? = definedExternally): Array<Number>
    }
}


external interface BitmapFont {

    var base: PIXI.BaseTexture
    var data: HTMLImageElement
    var font: Phaser.BMFont
    var url: String
}


external interface BMFont {
    var chars: Array<Phaser.BMFontChar>
    var font: String
    var lineHeight: Number
    var size: Number
}


external interface BMFontChar {
    var x: Number
    var y: Number
    var width: Number
    var height: Number
    var xOffset: Number
    var yOffset: Number
    var xAdvance: Number
    var kerning: Array<Number>
    var texture: PIXI.BaseTexture
}

external interface `T$0` {
    var r: Number
    var g: Number
    var b: Number
    var x: Number
    var y: Number
}


external open class BitmapData(game: Phaser.Game, key: String, width: Number? = definedExternally, height: Number? = definedExternally, skipPool: Boolean? = definedExternally) {
    open var baseTexture: PIXI.BaseTexture
    open var buffer: ArrayBuffer
    open var canvas: HTMLCanvasElement
    open var context: CanvasRenderingContext2D
    open var ctx: CanvasRenderingContext2D
    open var data: Uint8Array
    open var dirty: Boolean
    open var disableTextureUpload: Boolean
    open var game: Phaser.Game
    open var height: Double
    open var imageData: ImageData
    open var key: String
    open var op: String
    open var pixels: Uint32Array
    open var smoothed: Boolean
    open var smoothProperty: String
    open var texture: PIXI.Texture
    open var textureFrame: Phaser.Frame
    open var type: Number
    open var width: Double
    open fun add(`object`: Any): Phaser.BitmapData
    open fun addToWorld(x: Number? = definedExternally, y: Number? = definedExternally, anchorX: Number? = definedExternally, anchorY: Number? = definedExternally, scaleX: Number? = definedExternally, scaleY: Number? = definedExternally): Phaser.Image
    open fun alphaMask(source: Any, mask: Any? = definedExternally, sourceRect: Phaser.Rectangle? = definedExternally, maskRect: Phaser.Rectangle? = definedExternally): Phaser.BitmapData
    open fun blendAdd(): Phaser.BitmapData
    open fun blendColor(): Phaser.BitmapData
    open fun blendColorBurn(): Phaser.BitmapData
    open fun blendColorDodge(): Phaser.BitmapData
    open fun blendDarken(): Phaser.BitmapData
    open fun blendDestinationAtop(): Phaser.BitmapData
    open fun blendDestinationIn(): Phaser.BitmapData
    open fun blendDestinationOut(): Phaser.BitmapData
    open fun blendDestinationOver(): Phaser.BitmapData
    open fun blendDifference(): Phaser.BitmapData
    open fun blendExclusion(): Phaser.BitmapData
    open fun blendHardLight(): Phaser.BitmapData
    open fun blendHue(): Phaser.BitmapData
    open fun blendLighten(): Phaser.BitmapData
    open fun blendLuminosity(): Phaser.BitmapData
    open fun blendMultiply(): Phaser.BitmapData
    open fun blendOverlay(): Phaser.BitmapData
    open fun blendReset(): Phaser.BitmapData
    open fun blendSaturation(): Phaser.BitmapData
    open fun blendScreen(): Phaser.BitmapData
    open fun blendSoftLight(): Phaser.BitmapData
    open fun blendSourceAtop(): Phaser.BitmapData
    open fun blendSourceIn(): Phaser.BitmapData
    open fun blendSourceOut(): Phaser.BitmapData
    open fun blendSourceOver(): Phaser.BitmapData
    open fun blendXor(): Phaser.BitmapData
    open fun circle(x: Number, y: Number, radius: Number, fillStyle: String? = definedExternally): Phaser.BitmapData
    open fun clear(x: Number? = definedExternally, y: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally): Phaser.BitmapData
    open fun cls(): Phaser.BitmapData
    open fun copy(source: Any? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally, tx: Number? = definedExternally, ty: Number? = definedExternally, newWidth: Number? = definedExternally, newHeight: Number? = definedExternally, rotate: Number? = definedExternally, anchorX: Number? = definedExternally, anchorY: Number? = definedExternally, scaleX: Number? = definedExternally, scaleY: Number? = definedExternally, alpha: Number? = definedExternally, blendMode: String? = definedExternally, roundPx: Boolean? = definedExternally): Phaser.BitmapData
    open fun copyPixels(source: Any, area: Phaser.Rectangle, x: Number, y: Number, alpha: Number? = definedExternally): Unit
    open fun copyRect(source: Any, area: Phaser.Rectangle, x: Number? = definedExternally, y: Number? = definedExternally, alpha: Number? = definedExternally, blendMode: String? = definedExternally, roundPx: Boolean? = definedExternally): Phaser.BitmapData
    open fun copyTransform(source: Any, blendMode: String? = definedExternally, roundPx: Boolean? = definedExternally): Phaser.BitmapData
    open fun destroy(): Unit
    open fun draw(source: Any, x: Number? = definedExternally, y: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally, blendMode: String? = definedExternally, roundPx: Boolean? = definedExternally): Phaser.BitmapData
    open fun drawFull(parent: Any, blendMode: String? = definedExternally, roundPx: Boolean? = definedExternally): Phaser.BitmapData
    open fun drawGroup(group: Phaser.Group, blendMode: String? = definedExternally, roundPx: Boolean? = definedExternally): Phaser.BitmapData
    open fun extract(destination: Phaser.BitmapData, r: Number, g: Number, b: Number, a: Number? = definedExternally, resize: Boolean? = definedExternally, r2: Number? = definedExternally, g2: Number? = definedExternally, b2: Number? = definedExternally): Phaser.BitmapData
    open fun fill(r: Number, g: Number, b: Number, a: Number? = definedExternally): Phaser.BitmapData
    open fun generateTexture(key: String): PIXI.Texture
    open fun getBounds(rect: Phaser.Rectangle? = definedExternally): Phaser.Rectangle
    open fun getFirstPixel(direction: Number): `T$0`
    open fun getPixel(x: Number, y: Number, out: Any? = definedExternally): Any
    open fun getPixelRGB(x: Number, y: Number, out: Any? = definedExternally, hsl: Boolean? = definedExternally, hsv: Boolean? = definedExternally): ColorComponents
    open fun getPixel32(x: Number, y: Number): Number
    open fun getPixels(rect: Phaser.Rectangle): ImageData
    open fun getTransform(translateX: Number, translateY: Number, scaleX: Number, scaleY: Number, skewX: Number, skewY: Number): Any
    open fun line(x1: Number, y1: Number, x2: Number, y2: Number, color: String? = definedExternally, width: Number? = definedExternally): Phaser.BitmapData
    open fun load(source: Any): Phaser.BitmapData
    open fun move(x: Number, y: Number, wrap: Boolean? = definedExternally): Phaser.BitmapData
    open fun moveH(distance: Number, wrap: Boolean? = definedExternally): Phaser.BitmapData
    open fun moveV(distance: Number, wrap: Boolean? = definedExternally): Phaser.BitmapData
    open fun processPixel(callback: (color: Number, x: Number, y: Number) -> Unit, callbackContext: Any, x: Number? = definedExternally, y: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally): Phaser.BitmapData
    open fun processPixelRGB(callback: (color: ColorComponents, x: Number, y: Number) -> Unit, callbackContext: Any, x: Number? = definedExternally, y: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally): Phaser.BitmapData
    open fun rect(x: Number, y: Number, width: Number, height: Number, fillStyle: String? = definedExternally): Phaser.BitmapData
    open fun render(): Phaser.BitmapData
    open fun replaceRGB(r1: Number, g1: Number, b1: Number, a1: Number, r2: Number, g2: Number, b2: Number, a2: Number, region: Phaser.Rectangle? = definedExternally): Phaser.BitmapData
    open fun resize(width: Number, height: Number): Phaser.BitmapData
    open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
    open fun setHSL(h: Number? = definedExternally, s: Number? = definedExternally, l: Number? = definedExternally, region: Phaser.Rectangle? = definedExternally): Phaser.BitmapData
    open fun setPixel(x: Number, y: Number, red: Number, green: Number, blue: Number, immediate: Boolean? = definedExternally): Phaser.BitmapData
    open fun setPixel32(x: Number, y: Number, red: Number, green: Number, blue: Number, alpha: Number, immediate: Boolean? = definedExternally): Phaser.BitmapData
    open fun shadow(color: String, blur: Number? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally): Phaser.BitmapData
    open fun shiftHSL(h: Number? = definedExternally, s: Number? = definedExternally, l: Number? = definedExternally, region: Phaser.Rectangle? = definedExternally): Phaser.BitmapData
    open fun text(text: String, x: Number? = definedExternally, y: Number? = definedExternally, font: String? = definedExternally, color: String? = definedExternally, shadow: Boolean? = definedExternally): Phaser.BitmapData
    open fun textureLine(line: Phaser.Line, key: String, repeat: String? = definedExternally): Phaser.BitmapData
    open fun update(x: Number? = definedExternally, y: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally): Phaser.BitmapData

    companion object {
        fun getTransform(translateX: Number, translateY: Number, scaleX: Number, scaleY: Number, skewX: Number, skewY: Number): Any
    }
}

external interface `T$1` {
    var width: Number
    var text: String
    var end: Boolean
    var chars: Array<String>
}


external open class BitmapText(game: Phaser.Game, x: Number, y: Number, font: String, text: String? = definedExternally, size: Number? = definedExternally, align: String? = definedExternally) : PIXI.DisplayObjectContainer {
    open var align: String
    open var alive: Boolean
    open var anchor: Phaser.Point
    open var animations: Phaser.AnimationManager
    open var angle: Number
    open var autoCull: Boolean
    open var body: dynamic /* Phaser.Physics.Arcade.Body | Phaser.Physics.P2.Body | Phaser.Physics.Ninja.Body | Any */
    open var bottom: Number
    open var cameraOffset: Phaser.Point
    open var checkWorldBounds: Boolean
    open var data: Any
    open var destroyPhase: Boolean
    open var debug: Boolean
    open var dirty: Boolean
    open var events: Phaser.Events
    open var exists: Boolean
    open var fixedToCamera: Boolean
    open var font: String
    open var fontSize: Double
    open var fresh: Boolean
    open var game: Phaser.Game
    open var input: Phaser.InputHandler
    open var inputEnabled: Boolean
    open var inCamera: Boolean
    open var inWorld: Boolean
    open var key: dynamic /* String | Phaser.RenderTexture | Phaser.BitmapData | Phaser.Video | PIXI.Texture */
    open var left: Number
    open var name: String
    open var components: Any
    open var lifespan: Number
    open var maxWidth: Number
    open var offsetX: Number
    open var offsetY: Number
    open var outOfBoundsKill: Boolean
    open var pendingDestroy: Boolean
    open var physicsType: Number
    open var previousPosition: Phaser.Point
    open var previousRotation: Number
    override var position: Phaser.Point
    open var renderOrderID: Number
    open var right: Number
    open var text: String
    open var smoothed: Boolean
    open var textWidth: Double
    open var textHeight: Double
    open var tint: Number
    open var top: Number
    open var type: Number
    open var world: Phaser.Point
    override var x: Double
    override var y: Double
    //open var z: Double
    open fun alignIn(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any

    open fun alignIn(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun destroy(destroyChildren: Boolean? = definedExternally): Unit
    open fun kill(): Unit
    open fun postUpdate(): Unit
    open fun preUpdate(): Unit
    open fun purgeGlyphs(): Number
    open fun reset(x: Number, y: Number, health: Number? = definedExternally): Phaser.BitmapText
    open fun revive(health: Number? = definedExternally): Phaser.BitmapText
    open fun scanLine(data: Any, scale: Number, text: String): `T$1`
    open fun setText(text: String): Unit
    open fun update(): Unit
    open fun updateText(): Unit
    open fun updateTransform(): Unit
}


external open class Bullet(game: Phaser.Game, x: Number, y: Number, key: Any? = definedExternally, frame: Any? = definedExternally) : Phaser.Sprite {
    override fun kill(): Phaser.Bullet
    override fun update(): Unit
}


external open class Button(game: Phaser.Game, x: Number, y: Number, key: String, callback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally, overFrame: String? = definedExternally, outFrame: String? = definedExternally, downFrame: String? = definedExternally, upFrame: String? = definedExternally)
    : Phaser.Image {
    open var forceOut: Boolean
    open var freezeFrames: Boolean
    open var onDownSound: dynamic /* Phaser.Sound | Phaser.AudioSprite */
    open var onDownSoundMarker: String
    open var onInputDown: Phaser.Signal
    open var onInputOut: Phaser.Signal
    open var onInputOver: Phaser.Signal
    open var onInputUp: Phaser.Signal
    open var onOutSound: dynamic /* Phaser.Sound | Phaser.AudioSprite */
    open var onOutSoundMarker: String
    open var onOverSound: dynamic /* Phaser.Sound | Phaser.AudioSprite */
    open var onOverSoundMarker: String
    open var onOverMouseOnly: Boolean
    open var onUpSound: dynamic /* Phaser.Sound | Phaser.AudioSprite */
    open var onUpSoundMaker: String
    open var physicsType: Number
    override var type: Number
    open fun clearFrames(): Unit
    open fun setDownSound(sound: Phaser.Sound, marker: String? = definedExternally): Unit
    open fun setDownSound(sound: Phaser.AudioSprite, marker: String? = definedExternally): Unit
    open fun setFrames(overFrame: String? = definedExternally, outFrame: String? = definedExternally, downFrame: String? = definedExternally, upFrame: String?): Unit
    open fun setFrames(overFrame: String? = definedExternally, outFrame: String? = definedExternally, downFrame: String? = definedExternally, upFrame: Number?): Unit
    open fun setFrames(overFrame: String? = definedExternally, outFrame: String? = definedExternally, downFrame: Number? = definedExternally, upFrame: String?): Unit
    open fun setFrames(overFrame: String? = definedExternally, outFrame: String? = definedExternally, downFrame: Number? = definedExternally, upFrame: Number?): Unit
    open fun setFrames(overFrame: String? = definedExternally, outFrame: Number? = definedExternally, downFrame: String? = definedExternally, upFrame: String?): Unit
    open fun setFrames(overFrame: String? = definedExternally, outFrame: Number? = definedExternally, downFrame: String? = definedExternally, upFrame: Number?): Unit
    open fun setFrames(overFrame: String? = definedExternally, outFrame: Number? = definedExternally, downFrame: Number? = definedExternally, upFrame: String?): Unit
    open fun setFrames(overFrame: String? = definedExternally, outFrame: Number? = definedExternally, downFrame: Number? = definedExternally, upFrame: Number?): Unit
    open fun setFrames(overFrame: Number? = definedExternally, outFrame: String? = definedExternally, downFrame: String? = definedExternally, upFrame: String?): Unit
    open fun setFrames(overFrame: Number? = definedExternally, outFrame: String? = definedExternally, downFrame: String? = definedExternally, upFrame: Number?): Unit
    open fun setFrames(overFrame: Number? = definedExternally, outFrame: String? = definedExternally, downFrame: Number? = definedExternally, upFrame: String?): Unit
    open fun setFrames(overFrame: Number? = definedExternally, outFrame: String? = definedExternally, downFrame: Number? = definedExternally, upFrame: Number?): Unit
    open fun setFrames(overFrame: Number? = definedExternally, outFrame: Number? = definedExternally, downFrame: String? = definedExternally, upFrame: String?): Unit
    open fun setFrames(overFrame: Number? = definedExternally, outFrame: Number? = definedExternally, downFrame: String? = definedExternally, upFrame: Number?): Unit
    open fun setFrames(overFrame: Number? = definedExternally, outFrame: Number? = definedExternally, downFrame: Number? = definedExternally, upFrame: String?): Unit
    open fun setFrames(overFrame: Number? = definedExternally, outFrame: Number? = definedExternally, downFrame: Number? = definedExternally, upFrame: Number?): Unit
    open fun setFrames(overFrame: Number? = definedExternally, outFrame: Number? = definedExternally, downFrame: Number? = definedExternally): Unit
    open fun onInputOverHandler(sprite: Phaser.Button, pointer: Phaser.Pointer): Unit
    open fun onInputOutHandler(sprite: Phaser.Button, pointer: Phaser.Pointer): Unit
    open fun onInputDownHandler(sprite: Phaser.Button, pointer: Phaser.Pointer): Unit
    open fun onInputUpHandler(sprite: Phaser.Button, pointer: Phaser.Pointer, isOver: Boolean): Unit
    open fun removedFromWorld(): Unit
    open fun setOutSound(sound: Phaser.Sound, marker: String? = definedExternally): Unit
    open fun setOutSound(sound: Phaser.AudioSprite, marker: String? = definedExternally): Unit
    open fun setOverSound(sound: Phaser.Sound, marker: String? = definedExternally): Unit
    open fun setOverSound(sound: Phaser.AudioSprite, marker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.Sound? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.Sound? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.Sound? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.Sound? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.Sound? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.Sound? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.Sound? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.AudioSprite? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.Sound? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.Sound? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.AudioSprite? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.Sound? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.Sound? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.Sound? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.AudioSprite? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.AudioSprite? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.Sound? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.AudioSprite? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.Sound? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.Sound? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.Sound? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.AudioSprite? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.Sound? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.AudioSprite? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.Sound? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.AudioSprite? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.AudioSprite? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.Sound? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.Sound? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.AudioSprite? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.AudioSprite? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.AudioSprite? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.AudioSprite? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.Sound? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.Sound? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.Sound? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.AudioSprite? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.Sound? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.Sound? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.AudioSprite? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.AudioSprite? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.Sound? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.AudioSprite? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.Sound? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.AudioSprite? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.Sound? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.AudioSprite? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.AudioSprite? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.AudioSprite? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.AudioSprite? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.Sound? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.Sound? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.AudioSprite? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.AudioSprite? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.Sound? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.AudioSprite? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.AudioSprite? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.AudioSprite? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.AudioSprite? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.Sound? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setSounds(overSound: Phaser.AudioSprite? = definedExternally, overMarker: String? = definedExternally, downSound: Phaser.AudioSprite? = definedExternally, downMarker: String? = definedExternally, outSound: Phaser.AudioSprite? = definedExternally, outMarker: String? = definedExternally, upSound: Phaser.AudioSprite? = definedExternally, upMarker: String? = definedExternally): Unit
    open fun setState(newState: Number): Unit
    open fun setUpSound(sound: Phaser.Sound, marker: String? = definedExternally): Unit
    open fun setUpSound(sound: Phaser.AudioSprite, marker: String? = definedExternally): Unit
}


external open class PointerMode {
    companion object {
        var CURSOR: Number
        var CONTACT: Number
    }
}


external open class Cache(game: Phaser.Game) {
    open var autoResolveURL: Boolean
    open var game: Phaser.Game
    open var onSoundUnlock: Phaser.Signal
    open fun addBinary(key: String, binaryData: Any): Unit
    open fun addBitmapData(key: String, bitmapData: Phaser.BitmapData, frameData: Phaser.FrameData? = definedExternally): Phaser.BitmapData
    open fun addBitmapFont(key: String, url: String, data: Any, atlasData: Any, atlasType: String, xSpacing: Number? = definedExternally, ySpacing: Number? = definedExternally): Unit
    open fun addBitmapFontFromAtlas(key: String, atlasKey: String, atlasFrame: String, dataKey: String, dataType: String? = definedExternally, xSpacing: Number? = definedExternally, ySpacing: Number? = definedExternally): Unit
    open fun addCanvas(key: String, canvas: HTMLCanvasElement, context: CanvasRenderingContext2D? = definedExternally): Unit
    open fun addDefaultImage(): Unit
    open fun addImage(key: String, url: String, data: Any): HTMLImageElement
    open fun addJSON(key: String, urL: String, data: Any): Unit
    open fun addMissingImage(): Unit
    open fun addPhysicsData(key: String, url: String, JSONData: Any, format: Number): Unit
    open fun addRenderTexture(key: String, texture: RenderTexture): Unit
    open fun addShader(key: String, url: String, data: Any): Unit
    open fun addSound(key: String, url: String, data: Any, webAudio: Boolean, audioTag: Boolean): Unit
    open fun addSpriteSheet(key: String, url: String?, data: Any, frameWidth: Number, frameHeight: Number, frameMax: Number? = definedExternally, margin: Number? = definedExternally, spacing: Number? = definedExternally, skipFrames: Number? = definedExternally): Unit
    open fun addText(key: String, url: String, data: Any): Unit
    open fun addTextureAtlas(key: String, url: String, data: Any, atlasData: Any, format: Number): Unit
    open fun addTilemap(key: String, url: String?, mapData: Any, format: Number): Unit
    open fun addVideo(key: String, url: String, data: Any, isBlob: Boolean? = definedExternally): Unit
    open fun addXML(key: String, url: String, data: Any): Unit
    open fun checkBinaryKey(key: String): Boolean
    open fun checkBitmapDataKey(key: String): Boolean
    open fun checkBitmapFontKey(key: String): Boolean
    open fun checkCanvasKey(key: String): Boolean
    open fun checkImageKey(key: String): Boolean
    open fun checkJSONKey(key: String): Boolean
    open fun checkKey(cache: Number, key: String): Boolean
    open fun checkPhysicsKey(key: String): Boolean
    open fun checkRenderTextureKey(key: String): Boolean
    open fun checkShaderKey(key: String): Boolean
    open fun checkSoundKey(key: String): Boolean
    open fun checkTextKey(key: String): Boolean
    open fun checkTextureKey(key: String): Boolean
    open fun checkTilemapKey(key: String): Boolean
    open fun checkURL(url: String): Any
    open fun checkUrl(url: String): Any
    open fun checkXMLKey(key: String): Boolean
    open fun checkVideoKey(key: String): Boolean
    open fun clearGLTextures(): Unit
    open fun decodedSound(key: String, data: Any): Unit
    open fun destroy(): Unit
    open fun getBaseTexture(key: String, cache: Number? = definedExternally): PIXI.BaseTexture
    open fun getBinary(key: String): Any
    open fun getBitmapData(key: String): Phaser.BitmapData
    open fun getBitmapFont(key: String): Phaser.BitmapFont
    open fun getCanvas(key: String): HTMLCanvasElement
    open fun getFrame(key: String, cache: Number? = definedExternally): Phaser.Frame
    open fun getFrameByIndex(key: String, index: Number, cache: Number? = definedExternally): Phaser.Frame
    open fun getFrameByName(key: String, name: String, cache: Number? = definedExternally): Phaser.Frame
    open fun getFrameCount(key: String, cache: Number? = definedExternally): Number
    open fun getFrameData(key: String, cache: Number? = definedExternally): Phaser.FrameData
    open fun getImage(key: String, full: Boolean? = definedExternally): HTMLImageElement
    open fun getItem(key: String, cache: Number, method: String? = definedExternally, property: String? = definedExternally): Any
    open fun getJSON(key: String, clone: Boolean? = definedExternally): dynamic
    open fun getKeys(cache: Number): Array<String>
    open fun getPhysicsData(key: String, `object`: String? = definedExternally, fixtureKey: String? = definedExternally): Array<Any>
    open fun getRenderTexture(key: String): Phaser.CachedRenderTexture
    open fun getShader(key: String): String
    open fun getSound(key: String): Phaser.Sound
    open fun getSoundData(key: String): Any
    open fun getSpriteSheetKey(key: String): Boolean
    open fun getText(key: String): String
    open fun getTextKeys(): Array<String>
    open fun getTexture(key: String): Phaser.RenderTexture
    open fun getTextureAtlasKey(key: String): Boolean
    open fun getTextureFrame(key: String): Phaser.Frame
    open fun getTilemap(key: String): Any
    open fun getTilemapData(key: String): Any
    open fun getURL(url: String): Any
    open fun getXML(key: String): Any
    open fun getVideo(key: String): Phaser.Video
    open fun hasFrameData(key: String, cache: Number? = definedExternally): Boolean
    open fun isSoundDecoded(key: String): Boolean
    open fun isSoundReady(key: String): Boolean
    open fun isSpriteSheet(key: String): Boolean
    open fun reloadSound(key: String): Unit
    open fun reloadSoundComplete(key: String): Unit
    open fun removeBinary(key: String): Unit
    open fun removeBitmapData(key: String): Unit
    open fun removeBitmapFont(key: String): Unit
    open fun removeCanvas(key: String): Unit
    open fun removeImage(key: String, removeFromPixi: Boolean? = definedExternally): Unit
    open fun removeJSON(key: String): Unit
    open fun removePhysics(key: String): Unit
    open fun removeRenderTexture(key: String): Unit
    open fun removeShader(key: String): Unit
    open fun removeSound(key: String): Unit
    open fun removeSpriteSheet(key: String): Unit
    open fun removeText(key: String): Unit
    open fun removeTextureAtlas(key: String): Unit
    open fun removeTilemap(key: String): Unit
    open fun removeXML(key: String): Unit
    open fun removeVideo(key: String): Unit
    open fun updateFrameData(key: String, frameData: Any, cache: Number? = definedExternally): Unit
    open fun updateSound(key: String, property: String, value: Phaser.Sound): Unit

    companion object {
        var BINARY: Number
        var BITMAPDATA: Number
        var BITMAPFONT: Number
        var CANVAS: Number
        var IMAGE: Number
        var JSON: Number
        var PHYSICS: Number
        var RENDER_TEXTURE: Number
        var SHADER: Number
        var SOUND: Number
        var SPRITE_SHEET: Number
        var TEXT: Number
        var TEXTURE: Number
        var TEXTURE_ATLAS: Number
        var TILEMAP: Number
        var XML: Number
        var VIDEO: Number
        var DEFAULT: PIXI.Texture
        var MISSING: PIXI.Texture
    }
}

external interface CachedRenderTexture {
    var frame: Phaser.Frame
    var texture: Phaser.RenderTexture
}

external interface `T$2` {
    var x: Boolean
    var y: Boolean
}


external open class Camera(game: Phaser.Game, id: Number, x: Number, y: Number, width: Number, height: Number) {
    open var atLimit: `T$2`
    open var bounds: Phaser.Rectangle
    open var deadzone: Phaser.Rectangle
    open var displayObject: PIXI.DisplayObject
    open var id: Number
    open var fx: Phaser.Graphics
    open var game: Phaser.Game
    open var height: Number
    open var lerp: Phaser.Point
    open var position: Phaser.Point
    open var roundPx: Boolean
    open var scale: Phaser.Point
    open var shakeIntensity: Number
    open var onFadeComplete: Phaser.Signal
    open var onFlashComplete: Phaser.Signal
    open var onShakeComplete: Phaser.Signal
    open var target: Phaser.Sprite
    open var totalInView: Number
    open var view: Phaser.Rectangle
    open var visible: Boolean
    open var width: Number
    open var world: Phaser.World
    open var x: Double
    open var y: Double
    open fun checkBounds(): Unit
    open fun fade(color: Number? = definedExternally, duration: Number? = definedExternally, force: Boolean? = definedExternally, alpha: Number? = definedExternally): Boolean
    open fun flash(color: Number? = definedExternally, duration: Number? = definedExternally, force: Boolean? = definedExternally, alpha: Number? = definedExternally): Boolean
    open fun focusOn(displayObject: PIXI.DisplayObject): Unit
    open fun focusOnXY(x: Number, y: Number): Unit
    open fun follow(): Unit
    open fun follow(target: Phaser.Sprite?, style: Number? = definedExternally, lerpX: Number? = definedExternally, lerpY: Number? = definedExternally): Unit
    open fun reset(): Unit
    open fun resetFX(): Unit
    open fun setBoundsToWorld(): Unit
    open fun setPosition(x: Number, y: Number): Unit
    open fun setSize(width: Number, height: Number): Unit
    open fun shake(intensity: Number? = definedExternally, duration: Number? = definedExternally, force: Boolean? = definedExternally, direction: Number? = definedExternally, shakeBounds: Boolean? = definedExternally): Boolean
    open fun unfollow(): Unit
    open fun update(): Unit

    companion object {
        var FOLLOW_LOCKON: Number
        var FOLLOW_PLATFORMER: Number
        var FOLLOW_TOPDOWN: Number
        var FOLLOW_TOPDOWN_TIGHT: Number
        var SHAKE_BOTH: Number
        var SHAKE_HORIZONTAL: Number
        var SHAKE_VERTICAL: Number
        var ENABLE_FX: Number
    }
}


external open class Canvas {
    companion object {
        fun addToDOM(canvas: HTMLCanvasElement, parent: HTMLElement, overflowHidden: Boolean? = definedExternally): HTMLCanvasElement
        fun create(parent: HTMLDivElement, width: Number? = definedExternally, height: Number? = definedExternally, id: String? = definedExternally, skipPool: Boolean? = definedExternally): HTMLCanvasElement
        fun getSmoothingEnabled(context: CanvasRenderingContext2D): Boolean
        fun getSmoothingPrefix(context: CanvasRenderingContext2D): String
        fun removeFromDOM(canvas: HTMLCanvasElement): Unit
        fun setBackgroundColor(canvas: HTMLCanvasElement, color: String): HTMLCanvasElement
        fun setImageRenderingBicubic(canvas: HTMLCanvasElement): HTMLCanvasElement
        fun setImageRenderingCrisp(canvas: HTMLCanvasElement): HTMLCanvasElement
        fun setSmoothingEnabled(context: CanvasRenderingContext2D, value: Boolean): CanvasRenderingContext2D
        fun setTouchAction(canvas: HTMLCanvasElement, value: String): HTMLCanvasElement
        fun setTransform(context: CanvasRenderingContext2D, translateX: Number, translateY: Number, scaleX: Number, scaleY: Number, skewX: Number, skewY: Number): CanvasRenderingContext2D
        fun setUserSelect(canvas: HTMLCanvasElement, value: String? = definedExternally): HTMLCanvasElement
    }
}


external open class Circle(x: Number? = definedExternally, y: Number? = definedExternally, diameter: Number? = definedExternally) {
    open var area: Number
    open var bottom: Number
    open var diameter: Number
    open var empty: Boolean
    open var left: Number
    open var radius: Number
    open var right: Number
    open var top: Number
    open var x: Number
    open var y: Number
    open fun circumference(): Number
    open fun circumferencePoint(angle: Number, asDegrees: Boolean? = definedExternally, out: Phaser.Point? = definedExternally): Phaser.Point
    open fun clone(output: Phaser.Circle): Phaser.Circle
    open fun contains(x: Number, y: Number): Boolean
    open fun copyFrom(source: Any): Circle
    open fun copyTo(dest: Any): Any
    open fun distance(dest: Any, round: Boolean? = definedExternally): Number
    open fun getBounds(): Phaser.Rectangle
    open fun offset(dx: Number, dy: Number): Phaser.Circle
    open fun offsetPoint(point: Phaser.Point): Phaser.Circle
    open fun random(out: Phaser.Point? = definedExternally): Phaser.Point
    open fun scale(x: Number, y: Number? = definedExternally): Phaser.Rectangle
    open fun setTo(x: Number, y: Number, diameter: Number): Circle
    override fun toString(): String

    companion object {
        fun circumferencePoint(a: Phaser.Circle, angle: Number, asDegrees: Boolean, out: Phaser.Point? = definedExternally): Phaser.Point
        fun contains(a: Phaser.Circle, x: Number, y: Number): Boolean
        fun equals(a: Phaser.Circle, b: Phaser.Circle): Boolean
        fun intersects(a: Phaser.Circle, b: Phaser.Circle): Boolean
        fun intersectsRectangle(c: Phaser.Circle, r: Phaser.Rectangle): Boolean
    }
}


external open class Color {
    companion object {
        fun componentToHex(color: Number): String
        fun createColor(r: Number? = definedExternally, g: Number? = definedExternally, b: Number? = definedExternally, a: Number? = definedExternally, h: Number? = definedExternally, s: Number? = definedExternally, l: Number? = definedExternally, v: Number? = definedExternally): ColorComponents
        fun fromRGBA(rgba: Number, out: ColorComponents? = definedExternally): ColorComponents
        fun getAlpha(color: Number): Number
        fun getAlphaFloat(color: Number): Number
        fun getBlue(color: Number): Number
        fun getColor(red: Number, green: Number, blue: Number): Number
        fun getColor32(alpha: Number, red: Number, green: Number, blue: Number): Number
        fun getGreen(color: Number): Number
        fun getRandomColor(min: Number? = definedExternally, max: Number? = definedExternally, alpha: Number? = definedExternally): Number
        fun getRed(color: Number): Number
        fun getRGB(color: Number): RGBColor
        fun getWebRGB(color: Number): String
        fun getWebRGB(color: RGBColor): String
        fun hexToRGBArray(color: Number): Array<Number>
        fun hexToRGB(h: String): Number
        fun hexToColor(hex: String, out: ColorComponents? = definedExternally): ColorComponents
        fun HSLtoRGB(h: Number, s: Number, l: Number, out: ColorComponents? = definedExternally): ColorComponents
        fun HSLColorWheel(s: Number? = definedExternally, l: Number? = definedExternally): Array<ColorComponents>
        fun HSVtoRGB(h: Number, s: Number, v: Number, out: ColorComponents? = definedExternally): ColorComponents
        fun HSVColorWheel(s: Number? = definedExternally, v: Number? = definedExternally): Array<ColorComponents>
        fun hueToColor(p: Number, q: Number, t: Number): Number
        fun interpolateColor(color1: Number, color2: Number, steps: Number, currentStep: Number, alpha: Number? = definedExternally): Number
        fun interpolateColorWithRGB(color: Number, r: Number, g: Number, b: Number, steps: Number, currentStep: Number): Number
        fun interpolateRGB(r1: Number, g1: Number, b1: Number, r2: Number, g2: Number, b2: Number, steps: Number, currentStep: Number): Number
        fun packPixel(r: Number, g: Number, b: Number, a: Number): Number
        fun RGBArrayToHex(rgb: Array<Number>): Number
        fun RGBtoHSL(r: Number, g: Number, b: Number, out: ColorComponents? = definedExternally): ColorComponents
        fun RGBtoHSV(r: Number, g: Number, b: Number, out: ColorComponents? = definedExternally): ColorComponents
        fun RGBtoString(r: Number, g: Number, b: Number, a: Number? = definedExternally, prefix: String? = definedExternally): String
        fun toRGBA(r: Number, g: Number, b: Number, a: Number): Number
        fun toABGR(r: Number, g: Number, b: Number, a: Number): Number
        fun unpackPixel(rgba: Number, out: ColorComponents? = definedExternally, hsl: Boolean? = definedExternally, hsv: Boolean? = definedExternally): ColorComponents
        fun updateColor(out: ColorComponents): ColorComponents
        fun valueToColor(value: String, out: ColorComponents? = definedExternally): ColorComponents
        fun webToColor(web: String, out: ColorComponents? = definedExternally): ColorComponents
        fun blendNormal(a: Number): Number
        fun blendLighten(a: Number, b: Number): Number
        fun blendDarken(a: Number, b: Number): Number
        fun blendMultiply(a: Number, b: Number): Number
        fun blendAverage(a: Number, b: Number): Number
        fun blendAdd(a: Number, b: Number): Number
        fun blendSubtract(a: Number, b: Number): Number
        fun blendDifference(a: Number, b: Number): Number
        fun blendNegation(a: Number, b: Number): Number
        fun blendScreen(a: Number, b: Number): Number
        fun blendExclusion(a: Number, b: Number): Number
        fun blendOverlay(a: Number, b: Number): Number
        fun blendSoftLight(a: Number, b: Number): Number
        fun blendHardLight(a: Number, b: Number): Number
        fun blendColorDodge(a: Number, b: Number): Number
        fun blendColorBurn(a: Number, b: Number): Number
        fun blendLinearDodge(a: Number, b: Number): Number
        fun blendLinearBurn(a: Number, b: Number): Number
        fun blendLinearLight(a: Number, b: Number): Number
        fun blendVividLight(a: Number, b: Number): Number
        fun blendPinLight(a: Number, b: Number): Number
        fun blendHardMix(a: Number, b: Number): Number
        fun blendReflect(a: Number, b: Number): Number
        fun blendGlow(a: Number, b: Number): Number
        fun blendPhoenix(a: Number, b: Number): Number
    }
}

external interface RGBColor {
    var r: Number
    var g: Number
    var b: Number
    var a: Number
}

external interface ColorComponents : RGBColor {
    var h: Number
    var s: Number
    var v: Number
    var l: Number
    var color: Number
    var color32: Number
    var rgba: String
}


external open class Create(game: Phaser.Game) {
    open var bmd: Phaser.BitmapData
    open var canvas: HTMLCanvasElement
    open var ctx: CanvasRenderingContext2D
    open var game: Phaser.Game
    open var palettes: Any
    open fun grid(key: String, width: Number, height: Number, cellWidth: Number, cellHeight: Number, color: String): PIXI.Texture
    open fun texture(key: String, data: Any, pixelWidth: Number? = definedExternally, pixelHeight: Number? = definedExternally, palette: Number? = definedExternally): PIXI.Texture

    companion object {
        var PALETTE_ARNE: Number
        var PALETTE_JMP: Number
        var PALETTE_CGA: Number
        var PALETTE_C64: Number
        var PALETTE_JAPANESE_MACHINE: Number
    }
}

external interface CursorKeys {
    var up: Phaser.Key
    var down: Phaser.Key
    var left: Phaser.Key
    var right: Phaser.Key
}


external open class Device {
    open var android: Boolean
    open var arora: Boolean
    open var audioData: Boolean
    open var cancelFullScreen: String
    open var canHandleAlpha: Boolean
    open var canUseMultiply: Boolean
    open var canvas: Boolean
    open var chrome: Boolean
    open var chromeOS: Boolean
    open var chromeVersion: Number
    open var cocoonJS: Boolean
    open var cocoonJSApp: Boolean
    open var cordova: Boolean
    open var crosswalk: Boolean
    open var css3D: Boolean
    open var desktop: Boolean
    open var deviceReadyAt: Number
    open var electron: Boolean
    open var ejecta: Boolean
    open var epiphany: Boolean
    open var file: Boolean
    open var fileSystem: Boolean
    open var firefox: Boolean
    open var firefoxVersion: Number
    open var fullScreen: Boolean
    open var fullScreenKeyboard: Boolean
    open var getUserMedia: Boolean
    open var game: Phaser.Game
    open var h264Video: Boolean
    open var hlsVideo: Boolean
    open var ie: Boolean
    open var ieVersion: Number
    open var iOS: Boolean
    open var iOSVersion: Number
    open var initialized: Boolean
    open var iPad: Boolean
    open var iPhone: Boolean
    open var iPhone4: Boolean
    open var kindle: Boolean
    open var linux: Boolean
    open var littleEndian: Boolean
    open var localStorage: Boolean
    open var m4a: Boolean
    open var macOS: Boolean
    open var midori: Boolean
    open var mobileSafari: Boolean
    open var mp3: Boolean
    open var mp4Video: Boolean
    open var mspointer: Boolean
    open var node: Boolean
    open var nodeWebkit: Boolean
    open var ogg: Boolean
    open var oggVideo: Number
    open var opera: Boolean
    open var opus: Boolean
    open var pixelRatio: Number
    open var pointerLock: Boolean
    open var quirksMode: Boolean
    open var requestFullScreen: String
    open var safari: Boolean
    open var silk: Boolean
    open var support32bit: Boolean
    open var touch: Boolean
    open var trident: Boolean
    open var tridentVersion: Number
    open var typedArray: Boolean
    open var vibration: Boolean
    open var vita: Boolean
    open var wav: Boolean
    open var webApp: Boolean
    open var webAudio: Boolean
    open var webGL: Boolean
    open var webm: Boolean
    open var webmVideo: Boolean
    open var windows: Boolean
    open var windowsPhone: Boolean
    open var wheelEvent: String
    open var worker: Boolean
    open var wp9Video: Boolean

    companion object {
        var LITTLE_ENDIAN: Boolean
        var onInitialized: Phaser.Signal
        fun checkFullScreenSupport(): Unit
        fun canPlayAudio(type: String): Boolean
        fun canPlayVideo(type: String): Boolean
        fun isConsoleOpen(): Boolean
        fun isAndroidStockBrowser(): String
        var whenReady: (callback: Function<Any>, context: Any?) -> Unit
    }
}


external open class DeviceButton {
    constructor(parent: Phaser.Pointer, butonCode: Number)
    constructor(parent: Phaser.SinglePad, butonCode: Number)

    open var buttonCode: Number
    open var game: Phaser.Game
    open var isDown: Boolean
    open var isUp: Boolean
    open var onDown: Phaser.Signal2<DeviceButton, Double>
    open var onFloat: Phaser.Signal2<DeviceButton, Double>
    open var onUp: Phaser.Signal2<DeviceButton, Double>
    open var pad: Phaser.Gamepad
    open var repeats: Number
    open var timeDown: Number
    open var timeUp: Number
    open var value: Number
    open fun destroy(): Unit
    open fun justPressed(duration: Number? = definedExternally): Boolean
    open fun justReleased(duration: Number? = definedExternally): Boolean
    open fun processButtonDown(value: Number): Unit
    open fun processButtonFloat(value: Number): Unit
    open fun processButtonUp(value: Number): Unit
    open fun reset(): Unit
}


external open class Easing {
    //companion object {
    /*var Default: Function
    var Power0: Function
    var Power1: Function
    var power2: Function
    var power3: Function
    var power4: Function*/
    object Back {
        //companion object {
        fun In(k: Number): Number = definedExternally

        fun Out(k: Number): Number = definedExternally
        fun InOut(k: Number): Number = definedExternally
        //}
    }

    object Bounce {
        //companion object {
        fun In(k: Number): Number = definedExternally

        fun Out(k: Number): Number = definedExternally
        fun InOut(k: Number): Number = definedExternally
        //}
    }

    object Circular {
        //companion object {
        fun In(k: Number): Number = definedExternally

        fun Out(k: Number): Number = definedExternally
        fun InOut(k: Number): Number = definedExternally
        //}
    }

    object Cubic {
        //companion object {
        fun In(k: Number): Number = definedExternally

        fun Out(k: Number): Number = definedExternally
        fun InOut(k: Number): Number = definedExternally
        //}
    }

    object Elastic {
        //companion object {
        fun In(k: Number): Number = definedExternally

        fun Out(k: Number): Number = definedExternally
        fun InOut(k: Number): Number = definedExternally
        //}
    }

    object Exponential {
        //companion object {
        fun In(k: Number): Number = definedExternally

        fun Out(k: Number): Number = definedExternally
        fun InOut(k: Number): Number = definedExternally
        //}
    }

    object Linear {
        //companion object {
        fun None(k: Number): Number = definedExternally
        //}
    }

    object Quadratic {
        //companion object {
        fun In(k: Number): Number = definedExternally

        fun Out(k: Number): Number = definedExternally
        fun InOut(k: Number): Number = definedExternally
        //}
    }

    object Quartic {
        //companion object {
        fun In(k: Number): Number = definedExternally

        fun Out(k: Number): Number = definedExternally
        fun InOut(k: Number): Number = definedExternally
        //}
    }

    object Quintic {
        //companion object {
        fun In(k: Number): Number = definedExternally

        fun Out(k: Number): Number = definedExternally
        fun InOut(k: Number): Number = definedExternally
        //}
    }

    object Sinusoidal {
        //companion object {
        fun In(k: Number): Number = definedExternally

        fun Out(k: Number): Number = definedExternally
        fun InOut(k: Number): Number = definedExternally
        //}
    }
}


external open class Ellipse(x: Number? = definedExternally, y: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally) {
    open var bottom: Number
    open var empty: Boolean
    open var height: Number
    open var left: Number
    open var right: Number
    open var top: Number
    open var type: Number
    open var width: Number
    open var x: Number
    open var y: Number
    open fun clone(output: Phaser.Ellipse): Phaser.Ellipse
    open fun contains(x: Number, y: Number): Boolean
    open fun copyFrom(source: Any): Phaser.Ellipse
    open fun copyTo(dest: Any): Any
    open fun getBounds(): Phaser.Rectangle
    open fun random(out: Phaser.Point? = definedExternally): Phaser.Point
    open fun setTo(x: Number, y: Number, width: Number, height: Number): Phaser.Ellipse
    override fun toString(): String

    companion object {
        fun constains(a: Phaser.Ellipse, x: Number, y: Number): Boolean
    }
}


external open class Events(sprite: Phaser.Sprite) {
    open var parent: Phaser.Signal1<Sprite>
    open var onAddedToGroup: Phaser.Signal1<Sprite>
    open var onRemovedFromGroup: Phaser.Signal1<Sprite>
    open var onRemovedFromWorld: Phaser.Signal1<Sprite>
    open var onKilled: Phaser.Signal1<Sprite>
    open var onRevived: Phaser.Signal1<Sprite>
    open var onOutOfBounds: Phaser.Signal1<Sprite>
    open var onEnterBounds: Phaser.Signal1<Sprite>
    open var onInputOver: Phaser.Signal2<Sprite, Pointer>
    open var onInputOut: Phaser.Signal2<Sprite, Pointer>
    open var onInputDown: Phaser.Signal2<Sprite, Pointer>
    open var onInputUp: Phaser.Signal2<Sprite, Pointer>
    open var onDestroy: Phaser.Signal1<Sprite>
    open var onDragStart: Phaser.Signal2<Sprite, Pointer>
    open var onDragStop: Phaser.Signal2<Sprite, Pointer>
    //open var onDragStop: Phaser.SignalT
    open var onDragUpdate: Phaser.Signal5<Sprite, Pointer, Double, Double, Point>
    open var onAnimationStart: Phaser.Signal1<Sprite>
    open var onAnimationComplete: Phaser.Signal1<Sprite>
    open var onAnimationLoop: Phaser.Signal1<Sprite>
    open fun destroy(): Unit
}


external open class Filter() : PIXI.AbstractFilter {
    constructor(game: Phaser.Game, uniforms: Any?, fragmentSrc: String) 
    constructor(game: Phaser.Game, uniforms: Any?, fragmentSrc: Array<String>) 

    override var dirty: Boolean
    open var game: Phaser.Game
    open var height: Number
    override var fragmentSrc: dynamic /* String | Array<String> */
    override var padding: Number
    open var prevPoint: Phaser.Point
    open var type: Number
    override var uniforms: Any
    open var width: Number
    open fun addToWorld(x: Number? = definedExternally, y: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally, anchorX: Number? = definedExternally, anchorY: Number? = definedExternally): Phaser.Image
    override fun apply(frameBuffer: WebGLFramebuffer): Unit
    open fun destroy(): Unit
    open fun init(vararg args: Any): Unit
    open fun setResolution(width: Number, height: Number): Unit
    override fun syncUniforms(): Unit
    open fun update(pointer: Phaser.Pointer? = definedExternally): Unit
    //companion object {
    open class BinarySerpents(game: Phaser.Game, width: Number, height: Number, march: Number? = definedExternally, maxDistance: Number? = definedExternally) : Phaser.Filter {
        open var fog: Number
    }

    open class BlurX : Phaser.Filter {
        open var blur: Number
    }

    open class BlurY : Phaser.Filter {
        open var blur: Number
    }

    open class CausticLight(game: Phaser.Game, width: Number, height: Number, divisor: Number? = definedExternally) : Phaser.Filter {
        open fun init(width: Number, height: Number, divisor: Number? = definedExternally): Unit
    }

    open class CheckerWave(game: Phaser.Game, width: Number, height: Number) : Phaser.Filter {
        open var alpha: Number
        open var cameraX: Number
        open var cameraY: Number
        open var cameraZ: Number
        open fun init(width: Number, height: Number): Unit
        open fun setColor1(red: Number, green: Number, blue: Number): Unit
        open fun setColor2(red: Number, green: Number, blue: Number): Unit
    }

    open class ColorBars(game: Phaser.Game, width: Number, height: Number) : Phaser.Filter {
        open var alpha: Number
        open fun init(width: Number, height: Number): Unit
    }

    open class Fire(width: Number, height: Number, alpha: Number? = definedExternally, shift: Number? = definedExternally) : Phaser.Filter {
        open var alpha: Number
        open var shift: Number
        open var speed: Number
        open fun init(width: Number, height: Number, alpha: Number? = definedExternally, shift: Number? = definedExternally): Unit
    }

    open class Gray : Phaser.Filter {
        open var gray: Number
    }

    open class HueRotate(game: Phaser.Game, width: Number, height: Number, texture: Any) : Phaser.Filter {
        open var alpha: Number
        open fun init(width: Number, height: Number, texture: Any): Unit
    }

    open class LazerBeam : Phaser.Filter {
        open fun init(width: Number, height: Number, divisor: Number? = definedExternally): Unit
    }

    open class LightBeam(game: Phaser.Game, width: Number, height: Number) : Phaser.Filter {
        open var alpha: Number
        open var blue: Number
        open var green: Number
        open var red: Number
        open var thickness: Number
        open var speed: Number
        open fun init(width: Number, height: Number): Unit
    }

    open class Marble(game: Phaser.Game, width: Number, height: Number, speed: Number? = definedExternally, intensity: Number? = definedExternally) : Phaser.Filter {
        open var alpha: Number
        open var intensity: Number
        open var speed: Number
        open fun init(width: Number, height: Number, speed: Number? = definedExternally, intensity: Number? = definedExternally): Unit
    }

    open class Pixelate : Phaser.Filter {
        open var size: Number
        open var sizeX: Number
        open var sizeY: Number
    }

    open class Plasma(game: Phaser.Game, width: Number, height: Number, alpha: Number? = definedExternally, size: Number? = definedExternally) : Phaser.Filter {
        open var alpha: Number
        open var blueShift: Number
        open var greenShift: Number
        open var redShift: Number
        open var size: Number
        open fun init(width: Number, height: Number, alpha: Number? = definedExternally, size: Number? = definedExternally): Unit
    }

    open class SampleFilter(game: Phaser.Game, width: Number, height: Number, divisor: Number? = definedExternally) : Phaser.Filter {
        open fun init(width: Number, height: Number, divisor: Number? = definedExternally): Unit
    }

    open class Tunnel(game: Phaser.Game, width: Number, height: Number, texture: Any) : Phaser.Filter {
        open var alpha: Number
        open var origin: Number
        open fun init(width: Number, height: Number, texture: Any): Unit
    }
    //}
}


external open class FlexGrid(manager: Phaser.ScaleManager, width: Number, height: Number) {
    open var game: Phaser.Game
    open var manager: Phaser.ScaleManager
    open var width: Number
    open var height: Number
    open var boundsCustom: Phaser.Rectangle
    open var boundsFluid: Phaser.Rectangle
    open var boundsFull: Phaser.Rectangle
    open var boundsNone: Phaser.Rectangle
    open var customWidth: Number
    open var customHeight: Number
    open var customOffsetX: Number
    open var customOffsetY: Number
    open var positionCustom: Phaser.Point
    open var positionFluid: Phaser.Point
    open var positionFull: Phaser.Point
    open var positionNone: Phaser.Point
    open var scaleCustom: Phaser.Point
    open var scaleFluid: Phaser.Point
    open var scaleFluidInversed: Phaser.Point
    open var scaleFull: Phaser.Point
    open var scaleNone: Phaser.Point
    open var ratioH: Number
    open var ratioV: Number
    open var multiplier: Number
    //open fun createCustomLayer(width: Number, height: Number, children: Array<PIXI.DisplayObject>? = definedExternally, addToWorld: Boolean? = definedExternally): Phaser.FlexLayer
    //open fun createFluidLayer(children: Array<PIXI.DisplayObject>): Phaser.FlexLayer
    //open fun createFullLayer(children: Array<PIXI.DisplayObject>): Phaser.FlexLayer
    //open fun createFixedLayer(children: Array<PIXI.DisplayObject>): Phaser.FlexLayer
    open fun debug(): Unit

    open fun fitSprite(sprite: Phaser.Sprite): Unit
    open fun onResize(width: Number, height: Number): Unit
    open fun refresh(): Unit
    open fun reset(): Unit
    open fun setSize(width: Number, height: Number): Unit
}

/*
external open class FlexLayer(manager: Phaser.ScaleManager, position: Phaser.Point, bounds: Phaser.Rectangle, scale: Phaser.Point)
: Phaser.Group {
    open var grid: Phaser.FlexGrid
    open var manager: Phaser.ScaleManager
    open var bottomLeft: Phaser.Point
    open var bottomMiddle: Phaser.Point
    open var bottomRight: Phaser.Point
    open var bounds: Phaser.Rectangle
    open var persist: Boolean
    override var position: Phaser.Point
    override var scale: Phaser.Point
    open var topLeft: Phaser.Point
    open var topMiddle: Phaser.Point
    open var topRight: Phaser.Point
    open fun debug(): Unit
    open fun resize(): Unit
}*/

external open class Frame(index: Number, x: Number, y: Number, width: Number, height: Number, name: String) {
    open var bottom: Number
    open var centerX: Number
    open var centerY: Number
    open var distance: Number
    open var height: Number
    open var index: Number
    open var name: String
    open var right: Number
    open var rotated: Boolean
    open var sourceSizeH: Number
    open var sourceSizeW: Number
    open var spriteSourceSizeH: Number
    open var spriteSourceSizeW: Number
    open var spriteSourceSizeX: Number
    open var spriteSourceSizeY: Number
    open var trimmed: Boolean
    open var uuid: String
    open var width: Number
    open var x: Number
    open var y: Number
    open fun clone(): Phaser.Frame
    open fun getRect(out: Phaser.Rectangle? = definedExternally): Phaser.Rectangle
    open fun setTrim(trimmed: Boolean, actualWidth: Number, actualHeight: Number, destX: Number, destY: Number, destWidth: Number, destHeight: Number): Unit
    open fun resize(width: Number, height: Number): Unit
}


external open class FrameData {
    open var total: Number
    open fun addFrame(frame: Frame): Phaser.Frame
    open fun checkFrameName(name: String): Boolean
    open fun clone(): Phaser.FrameData
    open fun getFrame(index: Number): Phaser.Frame
    open fun getFrameByName(name: String): Phaser.Frame
    open fun getFrameIndexes(frames: Array<Number>? = definedExternally, useNumericIndex: Boolean? = definedExternally, output: Array<Number>? = definedExternally): Array<Number>
    open fun getFrameRange(start: Number, end: Number, output: Array<Phaser.Frame>): Array<Phaser.Frame>
    open fun getFrames(frames: Array<Number>? = definedExternally, useNumericIndex: Boolean? = definedExternally, output: Array<Phaser.Frame>? = definedExternally): Array<Phaser.Frame>
}


external open class Game {
    constructor(width: Number? = definedExternally, height: Number? = definedExternally, renderer: Number? = definedExternally, parent: Any? = definedExternally, state: Any? = definedExternally, transparent: Boolean? = definedExternally, antialias: Boolean? = definedExternally, physicsConfig: Any? = definedExternally)
    constructor(width: Number? = definedExternally, height: String? = definedExternally, renderer: Number? = definedExternally, parent: Any? = definedExternally, state: Any? = definedExternally, transparent: Boolean? = definedExternally, antialias: Boolean? = definedExternally, physicsConfig: Any? = definedExternally)
    constructor(width: String? = definedExternally, height: Number? = definedExternally, renderer: Number? = definedExternally, parent: Any? = definedExternally, state: Any? = definedExternally, transparent: Boolean? = definedExternally, antialias: Boolean? = definedExternally, physicsConfig: Any? = definedExternally)
    constructor(width: String? = definedExternally, height: String? = definedExternally, renderer: Number? = definedExternally, parent: Any? = definedExternally, state: Any? = definedExternally, transparent: Boolean? = definedExternally, antialias: Boolean? = definedExternally, physicsConfig: Any? = definedExternally)

    //constructor(config: IGameConfig)
    open var add: Phaser.GameObjectFactory
    open var antialias: Boolean
    open var cache: Phaser.Cache
    open var camera: Phaser.Camera
    open var canvas: HTMLCanvasElement
    open var clearBeforeRender: Boolean
    open var config: IGameConfig
    open var context: CanvasRenderingContext2D
    open var count: Number
    open var create: Phaser.Create
    open var debug: Phaser.Utils.Debug
    open var device: Phaser.Device
    open var forceSingleUpdate: Boolean
    open var fpsProblemNotifier: Phaser.Signal
    open var height: Double
    open var id: Number
    open var input: Phaser.Input
    open var isBooted: Boolean
    open var isRunning: Boolean
    open var load: Phaser.Loader
    open var lockRender: Boolean
    open var make: Phaser.GameObjectCreator
    open var math: Phaser.Math
    open var net: Phaser.Net
    open var onBlur: Phaser.Signal
    open var onFocus: Phaser.Signal
    open var onPause: Phaser.Signal
    open var onResume: Phaser.Signal
    open var parent: HTMLElement
    open var particles: Phaser.Particles
    open var paused: Boolean
    open var pendingStep: Boolean
    open var physics: Phaser.Physics
    open var physicsConfig: Any
    open var plugins: PluginManager
    open var preserveDrawingBuffer: Boolean
    open var raf: Phaser.RequestAnimationFrame
    open var renderer: dynamic /* PIXI.CanvasRenderer | PIXI.WebGLRenderer */
    open var renderType: Number
    open var resolution: Number
    open var rnd: Phaser.RandomDataGenerator
    open var scale: Phaser.ScaleManager
    open var scratch: Phaser.BitmapData
    open var sound: Phaser.SoundManager
    open var stage: Phaser.Stage
    open var state: Phaser.StateManager
    open var stepCount: Number
    open var stepping: Boolean
    open var time: Phaser.Time
    open var transparent: Boolean
    open var tweens: Phaser.TweenManager
    open var currentUpdateID: Number
    open var updatesThisFrame: Number
    open var width: Double
    open var world: Phaser.World
    open fun boot(): Unit
    open fun destroy(): Unit
    open fun disableStep(): Unit
    open fun enableStep(): Unit
    open fun focusGain(event: Any): Unit
    open fun focusLoss(event: Any): Unit
    open fun gamePaused(event: Any): Unit
    open fun gameResumed(event: Any): Unit
    open fun parseConfig(config: Any): Unit
    open fun removeFromDOM(canvas: HTMLCanvasElement): Unit
    open fun setUpRenderer(): Unit
    open fun showDebugHeader(): Unit
    open fun step(): Unit
    open fun update(time: Number): Unit
    open fun updateLogic(timeStep: Number): Unit
    open fun updateRender(timeStep: Number): Unit
}


external open class GameObjectCreator(game: Phaser.Game) {
    open var game: Phaser.Game
    open var world: Phaser.World
    open fun audio(key: String, volume: Number? = definedExternally, loop: Boolean? = definedExternally, connect: Boolean? = definedExternally): Phaser.Sound
    open fun audioSprite(key: String): Phaser.AudioSprite
    open fun bitmapData(width: Number? = definedExternally, height: Number? = definedExternally, key: String? = definedExternally, addToCache: Boolean? = definedExternally): Phaser.BitmapData
    open fun bitmapText(x: Number, y: Number, font: String, text: String? = definedExternally, size: Number? = definedExternally, align: String? = definedExternally): Phaser.BitmapText
    open fun button(x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, callback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally, overFrame: Any? = definedExternally, outFrame: Any? = definedExternally, downFrame: Any? = definedExternally, upFrame: Any? = definedExternally): Phaser.Button
    open fun emitter(x: Number? = definedExternally, y: Number? = definedExternally, maxParticles: Number? = definedExternally): Phaser.Particles.Arcade.Emitter
    //open fun filter(filter: Any, vararg args: Any): Phaser.Filter
    open fun graphics(x: Number? = definedExternally, y: Number? = definedExternally): Phaser.Graphics

    open fun group(parent: Any? = definedExternally, name: String? = definedExternally, addToStage: Boolean? = definedExternally, enableBody: Boolean? = definedExternally, physicsBodyType: Number? = definedExternally): Phaser.Group
    open fun image(x: Number, y: Number, key: Any? = definedExternally, frame: Any? = definedExternally): Phaser.Image
    open fun renderTexture(width: Number? = definedExternally, height: Number? = definedExternally, key: Any? = definedExternally, addToCache: Boolean? = definedExternally): Phaser.RenderTexture
    open fun retroFont(font: String, characterWidth: Number, characterHeight: Number, chars: String, charsPerRow: Number, xSpacing: Number? = definedExternally, ySpacing: Number? = definedExternally, xOffset: Number? = definedExternally, yOffset: Number? = definedExternally): Phaser.RetroFont
    open fun rope(x: Number, y: Number, key: Any, frame: Any? = definedExternally, points: Array<Phaser.Point>? = definedExternally): Phaser.Rope
    open fun sound(key: String, volume: Number? = definedExternally, loop: Boolean? = definedExternally, connect: Boolean? = definedExternally): Phaser.Sound
    open fun sprite(x: Number, y: Number, key: Any? = definedExternally, frame: Any? = definedExternally): Phaser.Sprite
    open fun spriteBatch(parent: Any, name: String? = definedExternally, addToStage: Boolean? = definedExternally): Phaser.SpriteBatch
    open fun text(x: Number, y: Number, text: String? = definedExternally, style: Any? = definedExternally): Phaser.Text
    open fun tilemap(key: String, tileWidth: Number? = definedExternally, tileHeight: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally): Phaser.Tilemap
    open fun tileSprite(x: Number, y: Number, width: Number, height: Number, key: Any, frame: Any): Phaser.TileSprite
    open fun tween(obj: Any): Phaser.Tween
}


external open class GameObjectFactory(game: Phaser.Game) {
    open var game: Phaser.Game
    open var world: Phaser.World
    open fun audio(key: String, volume: Number? = definedExternally, loop: Boolean? = definedExternally, connect: Boolean? = definedExternally): Phaser.Sound
    open fun audioSprite(key: String): Phaser.AudioSprite
    open fun bitmapData(width: Number? = definedExternally, height: Number? = definedExternally, key: String? = definedExternally, addToCache: Boolean? = definedExternally): Phaser.BitmapData
    open fun bitmapText(x: Number, y: Number, font: String, text: String? = definedExternally, size: Number? = definedExternally, group: Phaser.Group? = definedExternally): Phaser.BitmapText
    open fun button(x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, callback: () -> Unit?, callbackContext: Any? = definedExternally, overFrame: Any? = definedExternally, outFrame: Any? = definedExternally, downFrame: Any? = definedExternally, upFrame: Any? = definedExternally, group: Phaser.Group? = definedExternally): Phaser.Button
    open fun button(x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, callback: (Button) -> Unit?, callbackContext: Any? = definedExternally, overFrame: Any? = definedExternally, outFrame: Any? = definedExternally, downFrame: Any? = definedExternally, upFrame: Any? = definedExternally, group: Phaser.Group? = definedExternally): Phaser.Button
    open fun button(x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, callback: (Button, Pointer) -> Unit?, callbackContext: Any? = definedExternally, overFrame: Any? = definedExternally, outFrame: Any? = definedExternally, downFrame: Any? = definedExternally, upFrame: Any? = definedExternally, group: Phaser.Group? = definedExternally): Phaser.Button
    open fun button(x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, callback: (Button, Pointer, Boolean) -> Unit?, callbackContext: Any? = definedExternally, overFrame: Any? = definedExternally, outFrame: Any? = definedExternally, downFrame: Any? = definedExternally, upFrame: Any? = definedExternally, group: Phaser.Group? = definedExternally): Phaser.Button
    open fun emitter(x: Number? = definedExternally, y: Number? = definedExternally, maxParticles: Number? = definedExternally): Phaser.Particles.Arcade.Emitter
    open fun existing(`object`: Any): Any
    //open fun filter(filter: String, vararg args: Any?): Phaser.Filter
    open fun <T> filter(filter: String, vararg args: Any?): T //Phaser.Filter

    open fun graphics(): Phaser.Graphics
    open fun graphics(x: Number, y: Number): Phaser.Graphics
    open fun graphics(x: Number, y: Number, group: Phaser.Group? = definedExternally): Phaser.Graphics
    open fun group(parent: Any? = definedExternally, name: String? = definedExternally, addToStage: Boolean? = definedExternally, enableBody: Boolean? = definedExternally, physicsBodyType: Number? = definedExternally): Phaser.Group
    open fun image(x: Number, y: Number, key: Any? = definedExternally, frame: Any? = definedExternally, group: Phaser.Group? = definedExternally): Phaser.Image
    open fun physicsGroup(physicsBodyType: Number? = definedExternally, parent: Any? = definedExternally, name: String? = definedExternally, addToStage: Boolean? = definedExternally): Phaser.Group
    open fun plugin(plugin: Phaser.Plugin, vararg parameter: Any): Phaser.Plugin
    open fun renderTexture(width: Number? = definedExternally, height: Number? = definedExternally, key: String? = definedExternally, addToCache: Boolean? = definedExternally): Phaser.RenderTexture
    open fun retroFont(font: String, characterWidth: Number, characterHeight: Number, chars: String, charsPerRow: Number, xSpacing: Number? = definedExternally, ySpacing: Number? = definedExternally, xOffset: Number? = definedExternally, yOffset: Number? = definedExternally): Phaser.RetroFont
    open fun rope(x: Number, y: Number, key: Any, frame: Any? = definedExternally, points: Array<Phaser.Point>? = definedExternally): Phaser.Rope
    open fun sound(key: String, volume: Number? = definedExternally, loop: Boolean? = definedExternally, connect: Boolean? = definedExternally): Phaser.Sound
    open fun sprite(): Phaser.Sprite
    open fun sprite(x: Number): Phaser.Sprite
    open fun sprite(x: Number, y: Number, key: Any? = definedExternally, frame: Any? = definedExternally): Phaser.Sprite
    open fun sprite(x: Number, y: Number, key: Any? = definedExternally, frame: Any? = definedExternally, group: Phaser.Group? = definedExternally): Phaser.Sprite
    open fun spriteBatch(parent: Any, name: String? = definedExternally, addToStage: Boolean? = definedExternally): Phaser.Group
    open fun text(x: Number, y: Number, text: String): Phaser.Text
    open fun text(x: Number, y: Number, text: String, style: Any, group: Phaser.Group? = definedExternally): Phaser.Text
    open fun tilemap(key: String? = definedExternally, tileWidth: Number? = definedExternally, tileHeight: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally): Phaser.Tilemap
    open fun tileSprite(x: Number, y: Number, width: Number, height: Number, key: Any? = definedExternally, frame: Any? = definedExternally, group: Phaser.Group? = definedExternally): Phaser.TileSprite
    open fun tween(obj: Any): Phaser.Tween
    open fun weapon(quantity: Number? = definedExternally, key: Any? = definedExternally, frame: Any? = definedExternally, group: Phaser.Group? = definedExternally): Phaser.Weapon
    open fun video(key: String? = definedExternally, url: String? = definedExternally): Phaser.Video
}


external open class Gamepad(game: Phaser.Game) {
    open var active: Boolean
    open var callbackContext: Any
    open var enabled: Boolean
    open var game: Phaser.Game
    open var onAxisCallBack: Function<Any>
    open var onConnectCallback: Function<Any>
    open var onDisconnectCallback: Function<Any>
    open var onDownCallback: Function<Any>
    open var onFloatCallback: Function<Any>
    open var onUpCallback: Function<Any>
    open var pad1: Phaser.SinglePad
    open var pad2: Phaser.SinglePad
    open var pad3: Phaser.SinglePad
    open var pad4: Phaser.SinglePad
    open var padsConnected: Number
    open var supported: Boolean
    open fun addCallbacks(context: Any, callbacks: Any): Unit
    open fun isDown(buttonCode: Number): Boolean
    open fun justPressed(buttonCode: Number, duration: Number? = definedExternally): Boolean
    open fun justReleased(buttonCode: Number, duration: Number? = definedExternally): Boolean
    open fun reset(): Unit
    open fun setDeadZones(value: Any): Unit
    open fun start(): Unit
    open fun stop(): Unit
    open fun update(): Unit

    companion object {
        var BUTTON_0: Number
        var BUTTON_1: Number
        var BUTTON_2: Number
        var BUTTON_3: Number
        var BUTTON_4: Number
        var BUTTON_5: Number
        var BUTTON_6: Number
        var BUTTON_7: Number
        var BUTTON_8: Number
        var BUTTON_9: Number
        var BUTTON_10: Number
        var BUTTON_11: Number
        var BUTTON_12: Number
        var BUTTON_13: Number
        var BUTTON_14: Number
        var BUTTON_15: Number
        var AXIS_0: Number
        var AXIS_1: Number
        var AXIS_2: Number
        var AXIS_3: Number
        var AXIS_4: Number
        var AXIS_5: Number
        var AXIS_6: Number
        var AXIS_7: Number
        var AXIS_8: Number
        var AXIS_9: Number
        var XBOX360_A: Number
        var XBOX360_B: Number
        var XBOX360_X: Number
        var XBOX360_Y: Number
        var XBOX360_LEFT_BUMPER: Number
        var XBOX360_RIGHT_BUMPER: Number
        var XBOX360_LEFT_TRIGGER: Number
        var XBOX360_RIGHT_TRIGGER: Number
        var XBOX360_BACK: Number
        var XBOX360_START: Number
        var XBOX360_STICK_LEFT_BUTTON: Number
        var XBOX360_STICK_RIGHT_BUTTON: Number
        var XBOX360_DPAD_LEFT: Number
        var XBOX360_DPAD_RIGHT: Number
        var XBOX360_DPAD_UP: Number
        var XBOX360_DPAD_DOWN: Number
        var XBOX360_STICK_LEFT_X: Number
        var XBOX360_STICK_LEFT_Y: Number
        var XBOX360_STICK_RIGHT_X: Number
        var XBOX360_STICK_RIGHT_Y: Number
        var PS3XC_X: Number
        var PS3XC_CIRCLE: Number
        var PS3XC_SQUARE: Number
        var PS3XC_TRIANGLE: Number
        var PS3XC_L1: Number
        var PS3XC_R1: Number
        var PS3XC_L2: Number
        var PS3XC_R2: Number
        var PS3XC_SELECT: Number
        var PS3XC_START: Number
        var PS3XC_STICK_LEFT_BUTTON: Number
        var PS3XC_STICK_RIGHT_BUTTON: Number
        var PS3XC_DPAD_UP: Number
        var PS3XC_DPAD_DOWN: Number
        var PS3XC_DPAD_LEFT: Number
        var PS3XC_DPAD_RIGHT: Number
        var PS3XC_STICK_LEFT_X: Number
        var PS3XC_STICK_LEFT_Y: Number
        var PS3XC_STICK_RIGHT_X: Number
        var PS3XC_STICK_RIGHT_Y: Number
    }
}


external open class Graphics(game: Phaser.Game, x: Number? = definedExternally, y: Number? = definedExternally) : PIXI.Graphics {
    open var angle: Number
    open var alive: Boolean
    open var animations: Phaser.AnimationManager
    open var autoCull: Boolean
    open var body: dynamic /* Phaser.Physics.Arcade.Body | Phaser.Physics.P2.Body | Phaser.Physics.Ninja.Body | Any */
    open var bottom: Number
    open var cameraOffset: Phaser.Point
    open var checkWorldBounds: Boolean
    open var components: Any
    open var data: Any
    open var debug: Boolean
    open var destroyPhase: Boolean
    open var exists: Boolean
    open var events: Phaser.Events
    open var fixedToCamera: Boolean
    open var key: dynamic /* String | Phaser.RenderTexture | Phaser.BitmapData | Phaser.Video | PIXI.Texture */
    open var fresh: Boolean
    open var game: Phaser.Game
    override var height: Double
    open var input: Phaser.InputHandler
    open var inputEnabled: Boolean
    open var inCamera: Boolean
    open var inWorld: Boolean
    open var left: Number
    open var name: String
    open var lifespan: Number
    open var offsetX: Number
    open var offsetY: Number
    open var outOfBoundsKill: Boolean
    open var pendingDestroy: Boolean
    open var physicsType: Number
    override open var position: Phaser.Point
    open var previousPosition: Phaser.Point
    open var previousRotation: Number
    open var renderOrderID: Number
    open var right: Number
    open var top: Number
    open var type: Number
    open var world: Phaser.Point
    override var width: Double
    //open var z: Number
    open fun alignIn(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any

    open fun alignIn(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun destroy(destroyChildren: Boolean? = definedExternally): Unit
    open fun drawTriangle(points: Array<Phaser.Point>, cull: Boolean? = definedExternally): Unit
    open fun drawTriangles(vertices: Array<Phaser.Point>, indices: Array<Number>? = definedExternally, cull: Boolean? = definedExternally): Unit
    open fun drawTriangles(vertices: Array<Number>, indices: Array<Number>? = definedExternally, cull: Boolean? = definedExternally): Unit
    open fun kill(): Phaser.Graphics
    open fun postUpdate(): Unit
    open fun preUpdate(): Unit
    open fun reset(x: Number, y: Number, health: Number? = definedExternally): Phaser.Graphics
    open fun revive(health: Number? = definedExternally): Phaser.Graphics
    open fun update(): Unit
}


external open class Group(game: Phaser.Game, parent: PIXI.DisplayObjectContainer? = definedExternally, name: String? = definedExternally, addToStage: Boolean? = definedExternally, enableBody: Boolean? = definedExternally, physicsBodyType: Number? = definedExternally) : PIXI.DisplayObjectContainer {
    override var alpha: Double
    open var angle: Number
    open var alive: Boolean
    open var bottom: Number
    open var cameraOffset: Phaser.Point
    open var centerX: Double
    open var centerY: Double
    open var classType: Any
    open var cursor: PIXI.DisplayObject
    open var cursorIndex: Number
    open var enableBody: Boolean
    open var enableBodyDebug: Boolean
    open var exists: Boolean
    open var fixedToCamera: Boolean
    open var game: Phaser.Game
    open var hash: Array<PIXI.DisplayObject>
    open var ignoreDestroy: Boolean
    open var inputEnableChildren: Boolean
    open var left: Number
    open var length: Number
    open var name: String
    open var onChildInputDown: Phaser.Signal2<Sprite, Pointer>
    open var onChildInputUp: Phaser.Signal2<Sprite, Pointer>
    open var onChildInputOver: Phaser.Signal2<Sprite, Pointer>
    open var onChildInputOut: Phaser.Signal2<Sprite, Pointer>
    open var onDestroy: Phaser.Signal
    open var pendingDestroy: Boolean
    open var physicsBodyType: Number
    open var physicsType: Number
    open var physicsSortDirection: Number
    override open var position: Phaser.Point
    open var right: Number
    override var rotation: Double
    override open var scale: Phaser.Point
    open var top: Number
    open var total: Int
    open var type: Number
    override var visible: Boolean
    //open var z: Number
    open fun add(child: Any, silent: Boolean? = definedExternally, index: Number? = definedExternally): Any

    open fun addAll(property: String, amount: Number): Unit
    open fun addAll(property: String, amount: Number, checkAlive: Boolean, checkVisible: Boolean): Unit
    open fun addAt(child: Any, index: Number, silent: Boolean? = definedExternally): Any
    open fun addMultiple(children: Array<Any>, silent: Boolean? = definedExternally): Array<Any>
    open fun addToHash(child: PIXI.DisplayObject): Boolean
    open fun align(width: Number, height: Number, cellWidth: Number, cellHeight: Number, position: Number? = definedExternally, offset: Number? = definedExternally): Boolean
    open fun alignIn(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignIn(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignIn(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignIn(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignIn(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignIn(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignIn(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignIn(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignTo(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignTo(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignTo(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignTo(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignTo(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignTo(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignTo(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun alignTo(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Group
    open fun bringToTop(child: PIXI.DisplayObject): Any
    //open var bringToTop: Boolean
    open fun callAll(method: String): Unit

    open fun callAll(method: String, context: Any?, vararg parameters: Any): Unit
    open fun callAllExists(callback: String, existsValue: Boolean, vararg parameters: Any): Unit
    open fun callbackFromArray(child: Any, callback: Function<Any>, length: Number): Unit
    open fun checkAll(key: Array<String>, value: Any, checkAlive: Boolean? = definedExternally, checkVisible: Boolean? = definedExternally, force: Boolean? = definedExternally): Boolean
    open fun checkProperty(child: Any, key: Array<String>, value: Any, force: Boolean? = definedExternally): Boolean
    open fun countDead(): Int
    open fun countLiving(): Int
    //open fun create(x: Number, y: Number, key: String? = definedExternally, frame: String? = definedExternally, exists: Boolean? = definedExternally, index: Number? = definedExternally): DisplayObject
    open fun create(x: Number, y: Number, key: String?): Sprite

    open fun create(x: Number, y: Number, key: String? = definedExternally, frame: Number? = definedExternally, exists: Boolean? = definedExternally, index: Number? = definedExternally): Sprite
    open fun <T> create(x: Number, y: Number, key: String?): T
    open fun <T> create(x: Number, y: Number, key: String? = definedExternally, frame: Number? = definedExternally, exists: Boolean? = definedExternally, index: Number? = definedExternally): T
    open fun <T> create(x: Number, y: Number, key: String? = definedExternally, frame: String? = definedExternally, exists: Boolean? = definedExternally, index: Number? = definedExternally): T
    open fun <T> create(x: Number, y: Number, key: Phaser.RenderTexture? = definedExternally, frame: String? = definedExternally, exists: Boolean? = definedExternally, index: Number? = definedExternally): T
    open fun <T> create(x: Number, y: Number, key: Phaser.RenderTexture? = definedExternally, frame: Number? = definedExternally, exists: Boolean? = definedExternally, index: Number? = definedExternally): T
    open fun <T> create(x: Number, y: Number, key: Phaser.BitmapData? = definedExternally, frame: String? = definedExternally, exists: Boolean? = definedExternally, index: Number? = definedExternally): T
    open fun <T> create(x: Number, y: Number, key: Phaser.BitmapData? = definedExternally, frame: Number? = definedExternally, exists: Boolean? = definedExternally, index: Number? = definedExternally): T
    open fun <T> create(x: Number, y: Number, key: Phaser.Video? = definedExternally): T
    open fun <T> create(x: Number, y: Number, key: Phaser.Video? = definedExternally, frame: Number? = definedExternally, exists: Boolean? = definedExternally, index: Number? = definedExternally): T
    open fun <T> create(x: Number, y: Number, key: PIXI.Texture? = definedExternally, frame: String? = definedExternally, exists: Boolean? = definedExternally, index: Number? = definedExternally): T
    open fun <T> create(x: Number, y: Number, key: PIXI.Texture? = definedExternally, frame: Number? = definedExternally, exists: Boolean? = definedExternally, index: Number? = definedExternally): T
    open fun createMultiple(quantity: Number, key: String): Array<Any>
    open fun createMultiple(quantity: Number, key: String, frame: Any? = definedExternally, exists: Boolean? = definedExternally): Array<Any>
    open fun createMultiple(quantity: Number, key: String, frame: Array<Any>? = definedExternally, exists: Boolean? = definedExternally): Array<Any>
    open fun createMultiple(quantity: Number, key: Array<String>, frame: Any? = definedExternally, exists: Boolean? = definedExternally): Array<Any>
    open fun createMultiple(quantity: Number, key: Array<String>, frame: Array<Any>? = definedExternally, exists: Boolean? = definedExternally): Array<Any>
    open fun customSort(sortHandler: (Particle, Particle) -> Int, context: Any? = definedExternally): Unit
    open fun destroy(destroyChildren: Boolean? = definedExternally, soft: Boolean? = definedExternally): Unit
    open fun divideAll(property: String, amount: Number, checkAlive: Boolean? = definedExternally, checkVisible: Boolean? = definedExternally): Unit
    open fun forEach(callback: Function<Any>): Unit
    open fun forEach(callback: Function<Any>, callbackContext: Any, checkExists: Boolean? = definedExternally, vararg args: Any): Unit
    open fun forEachAlive(callback: (Sprite) -> Unit, callbackContext: Any? = definedExternally, vararg args: Any): Unit
    open fun forEachDead(callback: Function<Any>, callbackContext: Any? = definedExternally, vararg args: Any): Unit
    open fun forEachExists(callback: Function<Any>, callbackContext: Any? = definedExternally): Unit
    open fun filter(predicate: Function<Any>, checkExists: Boolean? = definedExternally): ArraySet
    open fun getAt(index: Number): dynamic /* PIXI.DisplayObject | Number */
    open fun getBottom(): Any
    open fun getByName(name: String): Any
    open fun getClosestTo(`object`: Any, callback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally): Any
    open fun <T : PIXI.DisplayObject> getFirstAlive(): T?
    open fun getFirstAlive(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstAlive(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFirstAlive(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.RenderTexture? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstAlive(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.RenderTexture? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFirstAlive(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.BitmapData? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstAlive(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.BitmapData? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFirstAlive(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.Video? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstAlive(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.Video? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFirstAlive(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: PIXI.Texture? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstAlive(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: PIXI.Texture? = definedExternally, frame: Number? = definedExternally): Any
    open fun <T : PIXI.DisplayObject> getFirstDead(): T?
    open fun <T : PIXI.DisplayObject> getFirstDead(createIfNull: Boolean?, x: Number?, y: Number?, key: String?): T
    open fun <T : PIXI.DisplayObject> getFirstDead(createIfNull: Boolean?, x: Number?, y: Number?, key: String?, frame: String?): T
    open fun <T : PIXI.DisplayObject> getFirstDead(createIfNull: Boolean?, x: Number?, y: Number?, key: String?, frame: Number?): T
    open fun getFirstDead(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.RenderTexture? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstDead(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.RenderTexture? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFirstDead(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.BitmapData? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstDead(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.BitmapData? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFirstDead(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.Video? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstDead(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.Video? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFirstDead(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: PIXI.Texture? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstDead(createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: PIXI.Texture? = definedExternally, frame: Number? = definedExternally): Any
    open fun <T> getFirstExists(exists: Boolean): T?
    open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.RenderTexture? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.RenderTexture? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.BitmapData? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.BitmapData? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.Video? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.Video? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: PIXI.Texture? = definedExternally, frame: String? = definedExternally): Any
    open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, key: PIXI.Texture? = definedExternally, frame: Number? = definedExternally): Any
    open fun getFurthestFrom(`object`: Any, callback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally): Any
    open fun getIndex(child: Any): Number
    open fun getRandom(startIndex: Number? = definedExternally, length: Number? = definedExternally): Any
    open fun getTop(): Any
    open fun hasProperty(child: Any, key: Array<String>): Boolean
    open fun iterate(key: String, value: Any, returnType: Number, callback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally, vararg args: Any): Sprite
    open fun moveAll(group: Phaser.Group, silent: Boolean? = definedExternally): Phaser.Group
    open fun moveDown(child: Any): Any
    open fun moveUp(child: Any): Any
    open fun multiplyAll(property: String, amount: Number, checkAlive: Boolean, checkVisible: Boolean): Unit
    open fun next(): Any
    open fun postUpdate(): Unit
    open fun preUpdate(): Unit
    open fun previous(): Unit
    open fun remove(child: Any, destroy: Boolean? = definedExternally, silent: Boolean? = definedExternally): Boolean
    open fun removeAll(destroy: Boolean? = definedExternally, silent: Boolean? = definedExternally, destroyTexture: Boolean? = definedExternally): Unit
    open fun removeBetween(startIndex: Number, endIndex: Number? = definedExternally, destroy: Boolean? = definedExternally, silent: Boolean? = definedExternally): Unit
    open fun removeFromHash(child: PIXI.DisplayObject): Boolean
    open fun replace(oldChild: Any, newChild: Any): Any
    open fun resetChild(child: Any, x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, frame: String? = definedExternally): Any
    open fun resetChild(child: Any, x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, frame: Number? = definedExternally): Any
    open fun resetChild(child: Any, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.RenderTexture? = definedExternally, frame: String? = definedExternally): Any
    open fun resetChild(child: Any, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.RenderTexture? = definedExternally, frame: Number? = definedExternally): Any
    open fun resetChild(child: Any, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.BitmapData? = definedExternally, frame: String? = definedExternally): Any
    open fun resetChild(child: Any, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.BitmapData? = definedExternally, frame: Number? = definedExternally): Any
    open fun resetChild(child: Any, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.Video? = definedExternally, frame: String? = definedExternally): Any
    open fun resetChild(child: Any, x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.Video? = definedExternally, frame: Number? = definedExternally): Any
    open fun resetChild(child: Any, x: Number? = definedExternally, y: Number? = definedExternally, key: PIXI.Texture? = definedExternally, frame: String? = definedExternally): Any
    open fun resetChild(child: Any, x: Number? = definedExternally, y: Number? = definedExternally, key: PIXI.Texture? = definedExternally, frame: Number? = definedExternally): Any
    open fun resetCursor(index: Number? = definedExternally): Any
    open fun reverse(): Unit
    open fun sendToBack(child: Any): Any
    open fun set(child: Any, key: Array<String>, value: Any, operation: Number? = definedExternally, force: Boolean? = definedExternally): Boolean
    open fun setAll(key: String, value: Any, checkAlive: Boolean? = definedExternally, checkVisible: Boolean? = definedExternally, operation: Number? = definedExternally, force: Boolean? = definedExternally): Unit
    open fun setAllChildren(key: String, value: Any, checkAlive: Boolean? = definedExternally, checkVisible: Boolean? = definedExternally, operation: Number? = definedExternally, force: Boolean? = definedExternally): Unit
    open fun setProperty(child: Any, key: Array<String>, value: Any, operation: Number? = definedExternally, force: Boolean? = definedExternally): Boolean
    open fun sort(key: String? = definedExternally, order: Number? = definedExternally): Unit
    open fun subAll(property: String, amount: Number, checkAlive: Boolean, checkVisible: Boolean): Unit
    open fun swap(child1: Any, child2: Any): Boolean
    open fun update(): Unit
    open fun updateZ(): Unit
    open fun xy(index: Number, x: Number, y: Number): Unit

    companion object {
        var RETURN_CHILD: Number
        var RETURN_NONE: Number
        var RETURN_TOTAL: Number
        var RETURN_ALL: Number
        var SORT_ASCENDING: Number
        var SORT_DESCENDING: Number
    }
}


external open class Image(game: Phaser.Game, x: Number, y: Number, key: Any, frame: Any? = definedExternally) : PIXI.Sprite {
    /*constructor(game: Phaser.Game, x: Number, y: Number, key: String, frame: String? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: String, frame: Number? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture, frame: String? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture, frame: Number? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData, frame: String? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData, frame: Number? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture, frame: String? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture, frame: Number? = definedExternally)*/
    open var alive: Boolean
    open var angle: Double
    open var anchor: Phaser.Point
    //open var anchor: Phaser.Point
    open var animations: Phaser.AnimationManager
    open var autoCull: Boolean
    open var bottom: Number
    open var cameraOffset: Phaser.Point
    open var centerX: Number
    open var centerY: Number
    open var components: Any
    open var cropRect: Phaser.Rectangle
    open var customRender: Boolean
    open var data: Any
    open var debug: Boolean
    open var deltaX: Number
    open var deltaY: Number
    open var deltaZ: Number
    open var destroyPhase: Boolean
    open var events: Phaser.Events
    override var exists: Boolean
    //open var exists: Boolean
    open var fixedToCamera: Boolean
    open var frame: dynamic /* String | Number */
    open var frameName: String
    open var fresh: Boolean
    open var game: Phaser.Game
    open var inCamera: Boolean
    open var input: Phaser.InputHandler
    open var inputEnabled: Boolean
    open var inWorld: Boolean
    open var key: dynamic /* String | Phaser.RenderTexture | Phaser.BitmapData | Phaser.Video | PIXI.Texture */
    open var lifespan: Number
    open var left: Number
    open var name: String
    open var offsetX: Number
    open var offsetY: Number
    open var pendingDestroy: Boolean
    override open var position: Phaser.Point
    open var previousPosition: Phaser.Point
    open var previousRotation: Number
    open var renderOrderID: Number
    open var right: Number
    override open var scale: Phaser.Point
    open var smoothed: Boolean
    open var top: Number
    open var type: Number
    open var world: Phaser.Point
    //open var z: Number
    open fun alignIn(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any

    open fun alignIn(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun bringToTop(): Phaser.Image
    open fun crop(rect: Phaser.Rectangle, copy: Boolean? = definedExternally): Unit
    open fun destroy(destroyChildren: Boolean? = definedExternally): Unit
    open fun kill(): Phaser.Image
    open fun loadTexture(key: String, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: String, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.RenderTexture, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.RenderTexture, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.BitmapData, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.BitmapData, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.Video, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.Video, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: PIXI.Texture, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: PIXI.Texture, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
    open fun moveDown(): Phaser.Image
    open fun moveUp(): Phaser.Image
    open fun overlap(displayObject: Phaser.Sprite): Boolean
    open fun overlap(displayObject: Phaser.Image): Boolean
    open fun overlap(displayObject: Phaser.TileSprite): Boolean
    open fun overlap(displayObject: Phaser.Button): Boolean
    open fun overlap(displayObject: PIXI.DisplayObject): Boolean
    open fun play(name: String, frameRate: Number? = definedExternally, loop: Boolean? = definedExternally, killOnComplete: Boolean? = definedExternally): Phaser.Animation
    open fun postUpdate(): Unit
    open fun preUpdate(): Unit
    open fun reset(x: Number, y: Number, health: Number? = definedExternally): Phaser.Image
    open fun resetFrame(): Unit
    open fun revive(health: Number? = definedExternally): Phaser.Image
    open fun sendToBack(): Phaser.Image
    open fun setFrame(frame: Phaser.Frame): Unit
    open fun update(): Unit
    open fun updateCrop(): Unit
}


external open class ImageCollection(name: String, firstgid: Number, width: Number? = definedExternally, height: Number? = definedExternally, margin: Number? = definedExternally, spacing: Number? = definedExternally, properties: Any? = definedExternally) {
    open var name: String
    open var firstgid: Number
    open var imageWidth: Number
    open var imageHeight: Number
    open var imageMargin: Number
    open var imageSpacing: Number
    open var properties: Any
    open var images: Array<Any>
    open var total: Number
    open fun addImage(gid: Number, image: String): Unit
    open fun containsImageIndex(imageIndex: Number): Boolean
}


external open class Input(game: Phaser.Game) {
    open var activePointer: Phaser.Pointer
    open var circle: Phaser.Circle
    open var enabled: Boolean
    open var doubleTapRate: Number
    open var game: Phaser.Game
    open var gamepad: Phaser.Gamepad
    open var hitCanvas: HTMLCanvasElement
    open var hitContext: CanvasRenderingContext2D
    open var holdRate: Number
    open var interactiveItems: Phaser.ArraySet
    open var justPressedRate: Number
    open var justReleasedRate: Number
    open var keyboard: Phaser.Keyboard
    open var maxPointers: Number
    open var minPriorityID: Number
    open var mouse: Phaser.Mouse
    open var mousePointer: Phaser.Pointer
    open var moveCallbacks: (pointer: Phaser.Pointer, x: Number, y: Number) -> Array<Unit>
    //open var mspointer: Phaser.MSPointer
    open var multiInputOverride: Number
    open var onDown: Phaser.Signal1<Pointer>
    open var onHold: Phaser.Signal1<Pointer>
    open var onTap: Phaser.Signal2<Pointer, Boolean>
    open var onUp: Phaser.Signal1<Pointer>
    open var pointer1: Phaser.Pointer
    open var pointer2: Phaser.Pointer
    open var pointer3: Phaser.Pointer
    open var pointer4: Phaser.Pointer
    open var pointer5: Phaser.Pointer
    open var pointer6: Phaser.Pointer
    open var pointer7: Phaser.Pointer
    open var pointer8: Phaser.Pointer
    open var pointer9: Phaser.Pointer
    open var pointer10: Phaser.Pointer
    open var pollLocked: Boolean
    open var pollRate: Number
    open var position: Phaser.Point
    open var pointer: Array<Phaser.Pointer>
    open var recordLimit: Number
    open var recordPointerHistory: Boolean
    open var recordRate: Number
    open var resetLocked: Boolean
    open var scale: Phaser.Point
    open var speed: Phaser.Point
    open var tapRate: Number
    open var totalActivePointers: Number
    open var totalInactivePointers: Number
    open var touch: Phaser.Touch
    open var worldX: Number
    open var worldY: Number
    open var x: Double
    open var y: Double
    open fun addPointer(): Phaser.Pointer
    open fun addMoveCallback(callback: () -> Unit, context: Any): Number
    open fun addMoveCallback(callback: (Pointer) -> Unit, context: Any): Number
    open fun addMoveCallback(callback: (Pointer, Double) -> Unit, context: Any): Number
    open fun addMoveCallback(callback: (Pointer, Double, Double) -> Unit, context: Any): Number
    open fun boot(): Unit
    open fun countActivePointers(limit: Number? = definedExternally): Number
    open fun deleteMoveCallback(callback: Function<Any>, context: Any? = definedExternally): Unit
    open fun destroy(): Unit
    open fun getLocalPosition(displayObject: Any, pointer: Phaser.Pointer): Phaser.Point
    open fun getPointer(isActive: Boolean? = definedExternally): Phaser.Pointer
    open fun getPointerFromId(pointerID: Number): Phaser.Pointer
    open fun getPointerFromIdentifier(identifier: Number): Phaser.Pointer
    open fun hitTest(displayObject: PIXI.DisplayObject, pointer: Phaser.Pointer, localPoint: Phaser.Point): Unit
    open fun reset(hard: Boolean? = definedExternally): Unit
    open fun resetSpeed(x: Number, y: Number): Unit
    open fun setInteractiveCandidateHandler(callback: Function<Any>, context: Any? = definedExternally): Unit
    open fun startPointer(event: Any): Phaser.Pointer
    open fun stopPointer(event: Any): Phaser.Pointer
    open fun update(): Unit
    open fun updatePointer(event: Any): Phaser.Pointer

    companion object {
        var MAX_POINTERS: Number
        var MOUSE_OVERRIDES_TOUCH: Number
        var MOUSE_TOUCH_COMBINE: Number
        var TOUCH_OVERRIDES_MOUSE: Number
    }
}


external open class InputHandler(sprite: Phaser.Sprite) {
    open var allowHorizontalDrag: Boolean
    open var allowVerticalDrag: Boolean
    open var boundsRect: Phaser.Rectangle
    open var boundsSprite: Phaser.Sprite
    open var bringToTop: Boolean
    open var downPoint: Phaser.Point
    open var dragDistanceThreshold: Number
    open var dragOffset: Phaser.Point
    open var dragFromCenter: Boolean
    open var draggable: Boolean
    open var dragStartPoint: Phaser.Point
    open var dragStopBlocksInputUp: Boolean
    open var dragTimeThreshold: Number
    open var enabled: Boolean
    open var game: Phaser.Game
    open fun globalToLocalX(x: Number): Number
    open fun globalToLocalY(y: Number): Number
    open var isDragged: Boolean
    open var pixelPerfectAlpha: Number
    open var pixelPerfectClick: Boolean
    open var pixelPerfectOver: Boolean
    open var priorityID: Number
    open var scaleLayer: Boolean
    open var snapOffset: Phaser.Point
    open var snapOffsetX: Number
    open var snapOffsetY: Number
    open var snapOnDrag: Boolean
    open var snapOnRelease: Boolean
    open var snapPoint: Phaser.Point
    open var snapX: Number
    open var snapY: Number
    open var sprite: Phaser.Sprite
    open var useHandCursor: Boolean
    open fun checkBoundsRect(): Unit
    open fun checkBoundsSprite(): Unit
    open fun checkPixel(x: Number, y: Number, pointer: Phaser.Pointer? = definedExternally): Boolean
    open fun checkPointerDown(pointer: Phaser.Pointer, fastTest: Boolean? = definedExternally): Boolean
    open fun checkPointerOver(pointer: Phaser.Pointer, fastTest: Boolean? = definedExternally): Boolean
    open fun destroy(): Unit
    open fun disableDrag(): Unit
    open fun disableSnap(): Unit
    open fun downDuration(pointerId: Number? = definedExternally): Number
    open fun enableDrag(lockCenter: Boolean? = definedExternally, bringToTop: Boolean? = definedExternally, pixelPerfect: Boolean? = definedExternally, alphaThreshold: Number? = definedExternally, boundsRect: Phaser.Rectangle? = definedExternally, boundsSprite: Phaser.Sprite? = definedExternally): Unit
    open fun enableSnap(snapX: Number, snapY: Number, onDrag: Boolean? = definedExternally, onRelease: Boolean? = definedExternally, snapOffsetX: Number? = definedExternally, snapOffsetY: Number? = definedExternally): Unit
    open fun isPixelPerfect(): Boolean
    open fun justOut(pointerId: Number? = definedExternally, delay: Number? = definedExternally): Boolean
    open fun justOver(pointerId: Number? = definedExternally, delay: Number? = definedExternally): Boolean
    open fun justPressed(pointerId: Number? = definedExternally, delay: Number? = definedExternally): Boolean
    open fun justReleased(pointerId: Number? = definedExternally, delay: Number? = definedExternally): Boolean
    open fun overDuration(pointerId: Number? = definedExternally): Number
    open fun pointerDown(pointerId: Number? = definedExternally): Boolean
    open fun pointerDragged(pointerId: Number? = definedExternally): Boolean
    open fun pointerOut(pointerId: Number? = definedExternally): Boolean
    open fun pointerOver(pointerId: Number? = definedExternally): Boolean
    open fun pointerTimeDown(pointerId: Number? = definedExternally): Number
    open fun pointerTimeOut(pointerId: Number? = definedExternally): Number
    open fun pointerTimeOver(pointerId: Number? = definedExternally): Number
    open fun pointerTimeUp(pointerId: Number? = definedExternally): Number
    open fun pointerUp(pointerId: Number? = definedExternally): Boolean
    open fun pointerX(pointerId: Number? = definedExternally): Number
    open fun pointerY(pointerId: Number? = definedExternally): Number
    open fun reset(): Unit
    open fun setDragLock(allowHorizontal: Boolean? = definedExternally, allowVertical: Boolean? = definedExternally): Unit
    open fun start(priority: Number, useHandCursor: Boolean): Phaser.Sprite
    open fun startDrag(pointer: Phaser.Pointer): Unit
    open fun stop(): Unit
    open fun stopDrag(pointer: Phaser.Pointer): Unit
    open fun update(pointer: Phaser.Pointer): Unit
    open fun updateDrag(pointer: Phaser.Pointer): Boolean
    open fun validForInput(highestID: Number, highestRenderID: Number, includePixelPerfect: Boolean? = definedExternally): Boolean
}


external open class Key(game: Phaser.Game, keycode: Number) {
    open var altKey: Boolean
    open var ctrlKey: Boolean
    open var duration: Number
    open var enabled: Boolean
    open var event: Any
    open var game: Phaser.Game
    open var isDown: Boolean
    open var isUp: Boolean
    open var _justDown: Boolean
    open var justDown: Boolean
    open var _justUp: Boolean
    open var justUp: Boolean
    open var keyCode: Number
    open var onDown: Phaser.Signal
    open var onHoldCallback: Function<Any>
    open var onHoldContext: Any
    open var onUp: Phaser.Signal
    open var repeats: Number
    open var shiftKey: Boolean
    open var timeDown: Number
    open var timeUp: Number
    open fun downDuration(duration: Number? = definedExternally): Boolean
    open fun processKeyDown(event: KeyboardEvent): Unit
    open fun processKeyUp(event: KeyboardEvent): Unit
    open fun reset(hard: Boolean? = definedExternally): Unit
    open fun update(): Unit
    open fun upDuration(duration: Number? = definedExternally): Boolean
}


external open class Keyboard(game: Phaser.Game) {
    open var callbackContext: Any
    open var enabled: Boolean
    open var event: Any
    open var game: Phaser.Game
    open var lastChar: String
    open var lastKey: Phaser.Key
    open var onDownCallback: Function<Any>
    open var onPressCallback: Function<Any>
    open var onUpCallback: Function<Any>
    open var pressEvent: Any
    open fun addCallbacks(context: Any, onDown: (Char) -> Unit, onUp: (Char) -> Unit, onPress: (Char) -> Unit): Unit
    open fun addKey(keycode: Number): Phaser.Key
    open fun addKeys(keys: dynamic): dynamic
    open fun addKeyCapture(keycode: Any): Unit
    open fun createCursorKeys(): Phaser.CursorKeys
    open fun clearCaptures(): Unit
    open fun destroy(): Unit
    open fun downDuration(keycode: Number, duration: Number? = definedExternally): Boolean
    open fun isDown(keycode: Number): Boolean
    open fun processKeyDown(event: KeyboardEvent): Unit
    open fun processKeyPress(event: KeyboardEvent): Unit
    open fun processKeyUp(event: KeyboardEvent): Unit
    open fun removeKey(keycode: Number): Unit
    open fun removeKeyCapture(keycode: Number): Unit
    open fun reset(hard: Boolean? = definedExternally): Unit
    open fun start(): Unit
    open fun stop(): Unit
    open fun update(): Unit
    open fun upDuration(keycode: Number, duration: Number? = definedExternally): Boolean

    companion object {
        var A: Number
        var B: Number
        var C: Number
        var D: Number
        var E: Number
        var F: Number
        var G: Number
        var H: Number
        var I: Number
        var J: Number
        var K: Number
        var L: Number
        var M: Number
        var N: Number
        var O: Number
        var P: Number
        var Q: Number
        var R: Number
        var S: Number
        var T: Number
        var U: Number
        var V: Number
        var W: Number
        var X: Number
        var Y: Number
        var Z: Number
        var ZERO: Number
        var ONE: Number
        var TWO: Number
        var THREE: Number
        var FOUR: Number
        var FIVE: Number
        var SIX: Number
        var SEVEN: Number
        var EIGHT: Number
        var NINE: Number
        var NUMPAD_0: Number
        var NUMPAD_1: Number
        var NUMPAD_2: Number
        var NUMPAD_3: Number
        var NUMPAD_4: Number
        var NUMPAD_5: Number
        var NUMPAD_6: Number
        var NUMPAD_7: Number
        var NUMPAD_8: Number
        var NUMPAD_9: Number
        var NUMPAD_MULTIPLY: Number
        var NUMPAD_ADD: Number
        var NUMPAD_ENTER: Number
        var NUMPAD_SUBTRACT: Number
        var NUMPAD_DECIMAL: Number
        var NUMPAD_DIVIDE: Number
        var F1: Number
        var F2: Number
        var F3: Number
        var F4: Number
        var F5: Number
        var F6: Number
        var F7: Number
        var F8: Number
        var F9: Number
        var F10: Number
        var F11: Number
        var F12: Number
        var F13: Number
        var F14: Number
        var F15: Number
        var COLON: Number
        var EQUALS: Number
        var COMMA: Number
        var UNDERSCORE: Number
        var PERIOD: Number
        var QUESTION_MARK: Number
        var TILDE: Number
        var OPEN_BRACKET: Number
        var BACKWARD_SLASH: Number
        var CLOSED_BRACKET: Number
        var QUOTES: Number
        var BACKSPACE: Number
        var TAB: Number
        var CLEAR: Number
        var ENTER: Number
        var SHIFT: Number
        var CONTROL: Number
        var ALT: Number
        var CAPS_LOCK: Number
        var ESC: Number
        var SPACEBAR: Number
        var PAGE_UP: Number
        var PAGE_DOWN: Number
        var END: Number
        var HOME: Number
        var LEFT: Number
        var UP: Number
        var RIGHT: Number
        var DOWN: Number
        var INSERT: Number
        var DELETE: Number
        var HELP: Number
        var NUM_LOCK: Number
        var PLUS: Number
        var MINUS: Number
    }
}


external open class KeyCode {
    companion object {
        var A: Number
        var B: Number
        var C: Number
        var D: Number
        var E: Number
        var F: Number
        var G: Number
        var H: Number
        var I: Number
        var J: Number
        var K: Number
        var L: Number
        var M: Number
        var N: Number
        var O: Number
        var P: Number
        var Q: Number
        var R: Number
        var S: Number
        var T: Number
        var U: Number
        var V: Number
        var W: Number
        var X: Number
        var Y: Number
        var Z: Number
        var ZERO: Number
        var ONE: Number
        var TWO: Number
        var THREE: Number
        var FOUR: Number
        var FIVE: Number
        var SIX: Number
        var SEVEN: Number
        var EIGHT: Number
        var NINE: Number
        var NUMPAD_0: Number
        var NUMPAD_1: Number
        var NUMPAD_2: Number
        var NUMPAD_3: Number
        var NUMPAD_4: Number
        var NUMPAD_5: Number
        var NUMPAD_6: Number
        var NUMPAD_7: Number
        var NUMPAD_8: Number
        var NUMPAD_9: Number
        var NUMPAD_MULTIPLY: Number
        var NUMPAD_ADD: Number
        var NUMPAD_ENTER: Number
        var NUMPAD_SUBTRACT: Number
        var NUMPAD_DECIMAL: Number
        var NUMPAD_DIVIDE: Number
        var F1: Number
        var F2: Number
        var F3: Number
        var F4: Number
        var F5: Number
        var F6: Number
        var F7: Number
        var F8: Number
        var F9: Number
        var F10: Number
        var F11: Number
        var F12: Number
        var F13: Number
        var F14: Number
        var F15: Number
        var COLON: Number
        var EQUALS: Number
        var COMMA: Number
        var UNDERSCORE: Number
        var PERIOD: Number
        var QUESTION_MARK: Number
        var TILDE: Number
        var OPEN_BRACKET: Number
        var BACKWARD_SLASH: Number
        var CLOSED_BRACKET: Number
        var QUOTES: Number
        var BACKSPACE: Number
        var TAB: Number
        var CLEAR: Number
        var ENTER: Number
        var SHIFT: Number
        var CONTROL: Number
        var ALT: Number
        var CAPS_LOCK: Number
        var ESC: Number
        var SPACEBAR: Number
        var PAGE_UP: Number
        var PAGE_DOWN: Number
        var END: Number
        var HOME: Number
        var LEFT: Number
        var UP: Number
        var RIGHT: Number
        var DOWN: Number
        var INSERT: Number
        var DELETE: Number
        var HELP: Number
        var NUM_LOCK: Number
        var PLUS: Number
        var MINUS: Number
    }
}


external open class Line(x1: Number? = definedExternally, y1: Number? = definedExternally, x2: Number? = definedExternally, y2: Number? = definedExternally) {
    open var angle: Double
    open var end: Phaser.Point
    open var height: Double
    open var left: Double
    open var length: Double
    open var normalAngle: Double
    open var normalX: Double
    open var normalY: Double
    open var perpSlope: Double
    open var right: Double
    open var slope: Double
    open var start: Phaser.Point
    open var top: Double
    open var type: Double
    open var width: Double
    open var x: Double
    open var y: Double
    open fun centerOn(x: Number, y: Number): Phaser.Line
    open fun clone(output: Phaser.Line): Phaser.Line
    open fun coordinatesOnLine(stepRate: Number, results: Array<Any>): Array<Any>
    open fun fromAngle(x: Number, y: Number, angle: Number, length: Number): Phaser.Line
    open fun fromSprite(startSprite: Phaser.Sprite, endSprite: Phaser.Sprite, useCenter: Boolean? = definedExternally): Phaser.Line
    open fun intersects(line: Phaser.Line, asSegment: Boolean? = definedExternally, result: Phaser.Point? = definedExternally): Phaser.Point?
    open fun midPoint(out: Phaser.Point? = definedExternally): Phaser.Point
    open fun pointOnLine(x: Number, y: Number): Boolean
    open fun pointOnSegment(x: Number, y: Number): Boolean
    open fun random(out: Phaser.Point? = definedExternally): Phaser.Point
    open fun reflect(line: Phaser.Line): Number
    open fun rotate(angle: Number, asDegrees: Boolean? = definedExternally): Phaser.Line
    open fun rotateAround(x: Number, y: Number, angle: Number, asDegrees: Boolean? = definedExternally): Phaser.Line
    open fun setTo(x1: Number? = definedExternally, y1: Number? = definedExternally, x2: Number? = definedExternally, y2: Number? = definedExternally): Phaser.Line

    companion object {
        fun intersectsPoints(a: Phaser.Point, b: Phaser.Point, e: Phaser.Point, f: Phaser.Point, asSegment: Boolean? = definedExternally, result: Phaser.Point? = definedExternally): Phaser.Point
        fun intersects(a: Phaser.Line, b: Phaser.Line, asSegment: Boolean? = definedExternally, result: Phaser.Point? = definedExternally): Phaser.Point
        fun intersectsRectangle(line: Phaser.Line, rect: Phaser.Rectangle): Boolean
        fun reflect(a: Phaser.Line, b: Phaser.Line): Number
    }
}


external open class LinkedList {
    open var first: Any
    open var last: Any
    open var next: Any
    open var prev: Any
    open var total: Number
    open fun add(item: Any): Any
    open fun callAll(callback: Function<Any>): Unit
    open fun remove(item: Any): Unit
    open fun reset(): Unit
}


external open class Loader(game: Phaser.Game) {
    open var baseURL: String
    open var cache: Phaser.Cache
    open var crossOrigin: dynamic /* Boolean | String */
    open var enableParallel: Boolean
    open var game: Phaser.Game
    open var hasLoaded: Boolean
    open var headers: Any
    open var isLoading: Boolean
    open var maxParallelDownloads: Number
    open var onFileStart: Phaser.Signal
    open var onFileComplete: Phaser.Signal5<Int, String, Boolean, Int, Int>
    open var onFileError: Phaser.Signal
    open var onLoadComplete: Phaser.Signal
    open var onLoadStart: Phaser.Signal
    open var onPackComplete: Phaser.Signal
    open var path: String
    open var preloadSprite: Any
    open var progress: Number
    open var progressFloat: Number
    open var resetLocked: Boolean
    open var useXDomainRequest: Boolean
    open fun asyncComplete(file: Any, errorMessage: String? = definedExternally): Unit
    open fun addSyncPoint(type: String, key: String): Phaser.Loader
    open fun addToFileList(type: String, key: String, url: String? = definedExternally, properties: Any? = definedExternally, overwrite: Boolean? = definedExternally, extension: String? = definedExternally): Phaser.Loader
    open fun atlas(key: String, textureURL: String? = definedExternally, atlasURL: String? = definedExternally, atlasData: Any? = definedExternally, format: Number? = definedExternally): Phaser.Loader
    open fun atlasJSONArray(key: String, textureURL: String? = definedExternally, atlasURL: String? = definedExternally, atlasData: Any? = definedExternally): Phaser.Loader
    open fun atlasJSONHash(key: String, textureURL: String? = definedExternally, atlasURL: String? = definedExternally, atlasData: Any? = definedExternally): Phaser.Loader
    open fun atlasXML(key: String, textureURL: String? = definedExternally, atlasURL: String? = definedExternally, atlasData: Any? = definedExternally): Phaser.Loader
    open fun audio(key: String, urls: String, autoDecode: Boolean? = definedExternally): Phaser.Loader
    open fun audio(key: String, urls: Array<String>, autoDecode: Boolean? = definedExternally): Phaser.Loader
    open fun audio(key: String, urls: Any, autoDecode: Boolean? = definedExternally): Phaser.Loader
    open fun audiosprite(key: String, url: String, jsonURL: String? = definedExternally, jsonData: String? = definedExternally, autoDecode: Boolean? = definedExternally): Phaser.Loader
    open fun audiosprite(key: String, urls: Array<String>, jsonURL: String? = definedExternally, jsonData: String? = definedExternally, autoDecode: Boolean? = definedExternally): Phaser.Loader
    open fun audiosprite(key: String, urls: Array<String>, jsonURL: String? = definedExternally, jsonData: Any? = definedExternally, autoDecode: Boolean? = definedExternally): Phaser.Loader
    open fun binary(key: String, url: String? = definedExternally, callback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally): Phaser.Loader
    open fun bitmapFont(key: String, textureURL: String? = definedExternally, atlasURL: String? = definedExternally, atlasData: Any? = definedExternally, xSpacing: Number? = definedExternally, ySpacing: Number? = definedExternally): Phaser.Loader
    open fun checkKeyExists(type: String, key: String): Boolean
    open fun csvLoadComplete(file: Any, xhr: XMLHttpRequest): Unit
    open fun fileComplete(file: Any, xhr: XMLHttpRequest): Unit
    open fun fileError(file: Any, xhr: XMLHttpRequest, reason: String): Unit
    open fun finishedLoading(abnormal: Boolean? = definedExternally): Unit
    open fun getAsset(type: String, key: String): Any
    open fun getAssetIndex(type: String, key: String): Number
    open fun getAudioURL(urls: Array<Any>): Unit
    open fun image(key: String): Phaser.Loader
    open fun image(key: String, url: String? = definedExternally, overwrite: Boolean? = definedExternally): Phaser.Loader
    open fun image(key: String, url: Any? = definedExternally, overwrite: Boolean? = definedExternally): Phaser.Loader
    open fun image(key: String, url: Any? = definedExternally, w: Int, h: Int): Phaser.Loader
    open fun images(keys: Array<String>, urls: Array<String>? = definedExternally): Phaser.Loader
    open fun json(key: String, url: String? = definedExternally, overwrite: Boolean? = definedExternally): Phaser.Loader
    open fun jsonLoadComplete(file: Any, xhr: XMLHttpRequest): Unit
    open fun loadAudioTag(file: Any): Unit
    open fun loadFile(file: Any): Unit
    open fun loadImageTag(file: Any): Unit
    open fun pack(key: String, url: String? = definedExternally, data: Any? = definedExternally, callbackContext: Any? = definedExternally): Phaser.Loader
    open fun parseXml(data: String): XMLDocument
    open fun physics(key: String, url: String? = definedExternally, data: Any? = definedExternally, format: String? = definedExternally): Phaser.Loader
    open fun processLoadQueue(): Unit
    open fun processPack(pack: Any): Unit
    open fun removeAll(): Unit
    open fun removeFile(type: String, key: String): Unit
    open fun replaceInFileList(type: String, key: String, url: String, properties: Any): Unit
    open fun reset(hard: Boolean? = definedExternally, clearEvents: Boolean? = definedExternally): Unit
    open fun resize(): Unit
    open fun script(key: String, url: String? = definedExternally, callback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally): Phaser.Loader
    open fun shader(key: String, url: String? = definedExternally, overwrite: Boolean? = definedExternally): Phaser.Loader
    open fun setPreloadSprite(sprite: Phaser.Sprite, direction: Number? = definedExternally): Unit
    open fun setPreloadSprite(sprite: Phaser.Image, direction: Number? = definedExternally): Unit
    open fun spritesheet(key: String, url: String, frameWidth: Number, frameHeight: Number, frameMax: Number? = definedExternally, margin: Number? = definedExternally, spacing: Number? = definedExternally, skipFrames: Number? = definedExternally): Phaser.Loader
    open fun start(): Unit
    open fun text(key: String, url: String? = definedExternally, overwrite: Boolean? = definedExternally): Phaser.Loader
    open fun texture(key: String, `object`: Any, overwrite: Boolean? = definedExternally): Phaser.Loader
    open fun tilemap(key: String, url: String? = definedExternally, data: Any? = definedExternally, format: Number? = definedExternally): Phaser.Loader
    open fun totalLoadedFiles(): Number
    open fun totalLoadedPacks(): Number
    open fun totalQueuedFiles(): Number
    open fun totalQueuedPacks(): Number
    open fun transformUrl(url: String, file: Any? = definedExternally): String
    open fun updateProgress(): Unit
    open fun video(key: String, urls: String, loadEvent: String? = definedExternally, asBlob: Boolean? = definedExternally): Phaser.Loader
    open fun video(key: String, urls: Array<String>, loadEvent: String? = definedExternally, asBlob: Boolean? = definedExternally): Phaser.Loader
    open fun video(key: String, urls: Any, loadEvent: String? = definedExternally, asBlob: Boolean? = definedExternally): Phaser.Loader
    open fun withSyncPoint(callback: Function<Any>, callbackContext: Any? = definedExternally): Phaser.Loader
    open fun xml(key: String, url: String? = definedExternally, overwrite: Boolean? = definedExternally): Phaser.Loader
    open fun xhrLoad(file: Any, url: String, type: String, onload: Function<Any>, onerror: Function<Any>? = definedExternally): Unit
    open fun xhrLoadWithXDR(file: Any, url: String, type: String, onload: Function<Any>, onerror: Function<Any>? = definedExternally): Unit
    open fun xmlLoadComplete(file: Any, xhr: XMLHttpRequest): Unit

    companion object {
        var PHYSICS_LIME_CORONA_JSON: Number
        var PHYSICS_PHASER_JSON: Number
        var TEXTURE_ATLAS_JSON_ARRAY: Number
        var TEXTURE_ATLAS_JSON_HASH: Number
        var TEXTURE_ATLAS_XML_STARLING: Number
        var TEXTURE_ATLAS_JSON_PYXEL: Number
    }
}


external open class LoaderParser {
    companion object {
        fun bitmapFont(xml: Any, baseTexture: PIXI.BaseTexture, xSpacing: Number? = definedExternally, ySpacing: Number? = definedExternally): Any
        fun xmlBitmapFont(xml: Any, baseTexture: PIXI.BaseTexture, xSpacing: Number? = definedExternally, ySpacing: Number? = definedExternally, frame: Phaser.Frame? = definedExternally): Any
        fun jsonBitmapFont(json: Any, baseTexture: PIXI.BaseTexture, xSpacing: Number? = definedExternally, ySpacing: Number? = definedExternally, frame: Phaser.Frame? = definedExternally): Any
    }
}

/*
external open class Matrix(a: Number? = definedExternally, b: Number? = definedExternally, c: Number? = definedExternally, d: Number? = definedExternally, tx: Number? = definedExternally, ty: Number? = definedExternally) : PIXI.Matrix {
    override var a: Number
    override var b: Number
    override var c: Number
    override var d: Number
    override var tx: Number
    override var ty: Number
    open var type: Number
    open fun apply(pos: Phaser.Point, newPos: Phaser.Point? = definedExternally): Phaser.Point
    open fun applyInverse(pos: Phaser.Point, newPos: Phaser.Point? = definedExternally): Phaser.Point
    open fun clone(output: Phaser.Matrix? = definedExternally): Phaser.Matrix
    open fun copyFrom(matrix: Phaser.Matrix): Phaser.Matrix
    open fun copyTo(matrix: Phaser.Matrix): Phaser.Matrix
    override fun fromArray(array: Array<Number>): Phaser.Matrix
    open fun setTo(a: Number, b: Number, c: Number, d: Number, tx: Number, ty: Number): Phaser.Matrix
    open fun toArray(transpose: Boolean? = definedExternally, array: Array<Number>? = definedExternally): Array<Number>
    override fun translate(x: Number, y: Number): Phaser.Matrix
    override fun scale(x: Number, y: Number): Phaser.Matrix
    override fun rotate(angle: Number): Phaser.Matrix
    open fun append(matrix: Phaser.Matrix): Phaser.Matrix
    override fun identity(): Phaser.Matrix
}*/
external interface SinCosGenerator {
    var sin: Array<Number>
    var cos: Array<Number>
}


external open class Math {
    companion object {
        //fun abs(n:Number):Double
        fun angleBetween(x1: Number, y1: Number, x2: Number, y2: Number): Double

        fun angleBetweenPoints(point1: Phaser.Point, point2: Phaser.Point): Double
        fun angleBetweenY(x1: Number, y1: Number, x2: Number, y2: Number): Double
        fun angleBetweenPointsY(point1: Phaser.Point, point2: Phaser.Point): Double
        fun average(vararg numbers: Number): Double
        fun bernstein(n: Number, i: Number): Double
        //fun random(min: Number, max: Number): Double
        fun between(min: Number, max: Number): Double

        fun bezierInterpolation(v: Array<Number>, k: Number): Double
        fun catmullRom(p0: Number, p1: Number, p2: Number, p3: Number, t: Number): Double
        fun catmullRomInterpolation(v: Array<Number>, k: Number): Double
        fun ceilTo(value: Number, place: Number? = definedExternally, base: Number? = definedExternally): Double
        fun clamp(x: Number, a: Number, b: Number): Double
        fun clampBottom(x: Number, a: Number): Double
        fun degToRad(degrees: Number): Double
        fun difference(a: Number, b: Number): Double
        fun distance(x1: Number, y1: Number, x2: Number, y2: Number): Double
        fun distanceSq(x1: Number, y1: Number, x2: Number, y2: Number): Double
        fun distancePow(xy: Number, y1: Number, x2: Number, y2: Number, pow: Number? = definedExternally): Double
        fun factorial(value: Number): Double

        fun floorTo(value: Number, place: Number?, base: Number?): Double
        fun fuzzyCeil(`val`: Number, epsilon: Number? = definedExternally): Boolean
        fun fuzzyEqual(a: Number, b: Number, epsilon: Number? = definedExternally): Boolean
        //fun fuzzyLessThan(a: Number, b: Number, epsilon: Number? = definedExternally): Boolean
        fun fuzzyFloor(`val`: Number, epsilon: Number? = definedExternally): Boolean

        fun fuzzyGreaterThan(a: Number, b: Number, epsilon: Number? = definedExternally): Boolean
        fun fuzzyLessThan(a: Number, b: Number, epsilon: Number? = definedExternally): Boolean
        fun getShortestAngle(angle1: Number, angle2: Number): Double
        fun getNextPowerOfTwo(value: Number): Double
        fun isEven(n: Number): Boolean
        fun isOdd(n: Number): Boolean
        fun isPowerOfTwo(width: Number, height: Number): Boolean
        fun linear(p0: Number, p1: Number, t: Number): Double
        fun linearInterpolation(v: Array<Number>, k: Number): Double
        fun mapLinear(x: Number, a1: Number, a2: Number, b1: Number, b2: Number): Double
        fun max(vararg numbers: Number): Double
        fun maxAdd(value: Number, amount: Number, max: Number): Double
        fun maxProperty(vararg numbers: Number): Double
        fun min(vararg numbers: Number): Double
        fun minProperty(vararg numbers: Number): Double
        fun minSub(value: Number, amount: Number, min: Number): Double
        fun normalizeAngle(angle: Number, radians: Boolean? = definedExternally): Double
        fun percent(a: Number, b: Number, base: Number? = definedExternally): Double
        fun p2px(v: Number): Double
        fun radToDeg(radians: Number): Double
        fun reverseAngle(angleRed: Number): Double
        fun rotateToAngle(currentAngle: Number, targetAngle: Number, lerp: Number? = definedExternally): Double
        fun roundAwayFromZero(value: Number): Double
        //fun round(value: Number): Double
        fun roundTo(value: Number, place: Number? = definedExternally, base: Number? = definedExternally): Double

        fun shear(n: Number): Double
        fun sign(x: Number): Double
        //fun sin(x: Number): Double
        //fun cos(x: Number): Double
        fun sinCosGenerator(length: Number, sinAmplitude: Number? = definedExternally, cosAmplitude: Number? = definedExternally, frequency: Number? = definedExternally): SinCosGenerator

        fun smootherstep(x: Number, min: Number, max: Number): Double
        fun smoothstep(x: Number, min: Number, max: Number): Double
        fun snapTo(input: Number, gap: Number, start: Number? = definedExternally): Double
        fun snapToCeil(input: Number, gap: Number, start: Number? = definedExternally): Double
        fun snapToFloor(input: Number, gap: Number, start: Number? = definedExternally): Double
        fun within(a: Number, b: Number, tolerance: Number): Boolean
        fun wrap(value: Number, min: Number, max: Number): Double
        fun wrapAngle(angle: Number, radians: Boolean? = definedExternally): Double
        fun wrapValue(value: Number, amount: Number, max: Number): Int
    }
}

external interface WheelEventProxy {
    fun bindEvent(event: Any): WheelEventProxy
    var type: String
    var deltaMode: Number
    var deltaX: Number
    var deltaY: Number
    var deltaZ: Number
}


external open class Mouse(game: Phaser.Game) {
    open var button: Number
    open var callbackContext: Any
    open var capture: Boolean
    open var enabled: Boolean
    open var event: MouseEvent
    open var game: Phaser.Game
    open var input: Phaser.Input
    open var locked: Boolean
    open var mouseDownCallback: (event: MouseEvent) -> Unit
    open var mouseOutCallback: (event: MouseEvent) -> Unit
    open var mouseOverCallback: (event: MouseEvent) -> Unit
    open var mouseUpCallback: (event: MouseEvent) -> Unit
    open var mouseWheelCallback: (event: MouseEvent) -> Unit
    open var _onMouseDown: (event: MouseEvent) -> Unit
    open var _onMouseMove: (event: MouseEvent) -> Unit
    open var _onMouseUp: (event: MouseEvent) -> Unit
    open var _onMouseOut: (event: MouseEvent) -> Unit
    open var _onMouseOver: (event: MouseEvent) -> Unit
    open var _onMouseWheel: (event: MouseEvent) -> Unit
    open var _wheelEvent: WheelEventProxy
    open var pointerLock: Phaser.Signal
    open var stopOnGameOut: Boolean
    open var wheelDelta: Number
    open fun onMouseDown(event: MouseEvent): Unit
    open fun onMouseMove(event: MouseEvent): Unit
    open fun onMouseOut(event: MouseEvent): Unit
    open fun onMouseOver(event: MouseEvent): Unit
    open fun onMouseUp(event: MouseEvent): Unit
    open fun onMouseUpGlobal(event: MouseEvent): Unit
    open fun onMouseWheel(event: MouseEvent): Unit
    open fun pointerLockChange(event: MouseEvent): Unit
    open fun releasePointerLock(): Unit
    open fun requestPointerLock(): Unit
    open fun start(): Unit
    open fun stop(): Unit

    companion object {
        var NO_BUTTON: Number
        var LEFT_BUTTON: Number
        var MIDDLE_BUTTON: Number
        var RIGHT_BUTTON: Number
        var BACK_BUTTON: Number
        var FORWARD_BUTTON: Number
        var WHEEL_DOWN: Number
        var WHEEL_UP: Number
    }
}

/*
external open class MSPointer(game: Phaser.Game) {
    open var button: Number
    open var capture: Boolean
    open var callbackContext: Any
    open var event: MSPointerEvent
    open var game: Phaser.Game
    open var input: Phaser.Input
    open var onPointerDown: (event: MSPointerEvent) -> Unit
    open var onPointerMove: (event: MSPointerEvent) -> Unit
    open var onPointerUp: (event: MSPointerEvent) -> Unit
    open var mouseDownCallback: (event: MSPointerEvent) -> Unit
    open var mouseMoveCallback: (event: MSPointerEvent) -> Unit
    open var mouseUpCallback: (event: MSPointerEvent) -> Unit
    open var pointerDownCallback: (event: MSPointerEvent) -> Unit
    open var pointerMoveCallback: (event: MSPointerEvent) -> Unit
    open var pointerUpCallback: (event: MSPointerEvent) -> Unit
    open fun start(): Unit
    open fun stop(): Unit
}*/

external open class Net(game: Phaser.Game) {
    open var game: Phaser.Game
    open fun checkDomainName(domain: String): Boolean
    open fun decodeURI(value: String): String
    open fun getHostName(): String
    open fun getQueryString(parameter: String? = definedExternally): String
    open fun updateQueryString(key: String, value: Any, redirect: Boolean? = definedExternally, url: String? = definedExternally): String
}


external open class Particle(game: Phaser.Game, x: Number, y: Number, key: Any? = definedExternally, frame: Any? = definedExternally) : Phaser.Sprite {
    override var fresh: Boolean
    open fun onEmit(): Unit
    //override fun reset(x: Number, y: Number, health: Number?): Phaser.Particle
    open fun setAlphaData(data: Array<Any>): Unit

    open fun setScaleData(data: Array<Any>): Unit
    override fun update(): Unit
}


external open class Particles(game: Phaser.Game) {
    open var emitters: Any
    open var game: Phaser.Game
    open var ID: Number
    open fun add(emitter: Phaser.Particles.Arcade.Emitter): Phaser.Particles.Arcade.Emitter
    open fun remove(emitter: Phaser.Particles.Arcade.Emitter): Unit
    open fun update(): Unit

    object Arcade {
        open class Emitter(game: Phaser.Game, x: Number? = definedExternally, y: Number? = definedExternally, maxParticles: Number? = definedExternally) : Phaser.Group {
            open var alphaData: Array<Any>
            open var autoAlpha: Boolean
            open var autoScale: Boolean
            override var angle: Number
            open var angularDrag: Number
            override var bottom: Number
            open var bounce: Phaser.Point
            open var emitX: Number
            open var emitY: Number
            override var exists: Boolean
            open var frequency: Number
            open var gravity: Number
            open var group: Phaser.Group
            override var height: Double
            override var left: Number
            open var lifespan: Number
            open var maxParticles: Number
            open var maxParticleScale: Number
            open var maxParticleSpeed: Phaser.Point
            open var maxRotation: Number
            open var minParticleScale: Number
            open var minParticleSpeed: Phaser.Point
            open var minRotation: Number
            override var name: String
            open var on: Boolean
            open var particleAnchor: Phaser.Point
            open var particleBringToTop: Boolean
            open var particleSendToBack: Boolean
            open var particleClass: Any
            open var particleDrag: Phaser.Point
            override var physicsType: Number
            override var position: Phaser.Point
            override var right: Number
            open var scaleData: Array<Any>
            override var top: Number
            override var type: Number
            override var width: Double
            override var x: Double
            override var y: Double
            open fun at(`object`: Any): Phaser.Particles.Arcade.Emitter
            open fun emitParticle(x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, frame: String? = definedExternally): Boolean
            open fun emitParticle(x: Number? = definedExternally, y: Number? = definedExternally, key: String? = definedExternally, frame: Number? = definedExternally): Boolean
            open fun emitParticle(x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.RenderTexture? = definedExternally, frame: String? = definedExternally): Boolean
            open fun emitParticle(x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.RenderTexture? = definedExternally, frame: Number? = definedExternally): Boolean
            open fun emitParticle(x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.BitmapData? = definedExternally, frame: String? = definedExternally): Boolean
            open fun emitParticle(x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.BitmapData? = definedExternally, frame: Number? = definedExternally): Boolean
            open fun emitParticle(x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.Video? = definedExternally, frame: String? = definedExternally): Boolean
            open fun emitParticle(x: Number? = definedExternally, y: Number? = definedExternally, key: Phaser.Video? = definedExternally, frame: Number? = definedExternally): Boolean
            open fun emitParticle(x: Number? = definedExternally, y: Number? = definedExternally, key: PIXI.Texture? = definedExternally, frame: String? = definedExternally): Boolean
            open fun emitParticle(x: Number? = definedExternally, y: Number? = definedExternally, key: PIXI.Texture? = definedExternally, frame: Number? = definedExternally): Boolean
            open fun explode(lifespan: Number? = definedExternally, quantity: Number? = definedExternally): Phaser.Particles.Arcade.Emitter
            open fun flow(lifespan: Number? = definedExternally, frequency: Number? = definedExternally, quantity: Number? = definedExternally, total: Number? = definedExternally, immediate: Boolean? = definedExternally): Phaser.Particles.Arcade.Emitter
            open fun kill(): Phaser.Particles.Arcade.Emitter
            open fun makeParticles(keys: Any, frames: Any? = definedExternally, quantity: Number? = definedExternally, collide: Boolean? = definedExternally, collideWorldBounds: Boolean? = definedExternally): Phaser.Particles.Arcade.Emitter
            open fun reset(x: Number, y: Number, health: Number? = definedExternally): Phaser.Particles
            open fun setAlpha(min: Number? = definedExternally, max: Number? = definedExternally, rate: Number? = definedExternally, ease: ((k: Number) -> Number)? = definedExternally, yoyo: Boolean? = definedExternally): Phaser.Particles.Arcade.Emitter
            open fun setRotation(min: Number? = definedExternally, max: Number? = definedExternally): Phaser.Particles.Arcade.Emitter
            open fun setScale(minX: Number? = definedExternally, maxX: Number? = definedExternally, minY: Number? = definedExternally, maxY: Number? = definedExternally, rate: Number? = definedExternally, ease: ((k: Number) -> Number)? = definedExternally, yoyo: Boolean? = definedExternally): Phaser.Particles.Arcade.Emitter
            open fun setSize(width: Number, height: Number): Phaser.Particles.Arcade.Emitter
            open fun setXSpeed(min: Number, max: Number): Phaser.Particles.Arcade.Emitter
            open fun setYSpeed(min: Number, max: Number): Phaser.Particles.Arcade.Emitter
            open fun start(explode: Boolean? = definedExternally, lifespan: Number? = definedExternally, frequency: Number? = definedExternally, quantity: Number? = definedExternally, forceQuantity: Boolean? = definedExternally): Phaser.Particles.Arcade.Emitter
            override fun update(): Unit
            open fun revive(): Phaser.Particles.Arcade.Emitter
        }
    }

}


external open class Physics(game: Phaser.Game, config: Any? = definedExternally) {
    open var arcade: Phaser.Physics.Arcade
    open var config: Any
    open var game: Phaser.Game
    //open var ninja: Phaser.Physics.Ninja
    open var p2: Physics.P2
    open var box2d: Any
    open fun clear(): Unit
    open fun destroy(): Unit
    //
    //@JsName("enable")
    //open fun enableJs(obj: Any, system: Number?, debug: Boolean?): Unit
    open fun enable(spr: Sprite, system: Number? = definedExternally, debug: Boolean? = definedExternally): Unit

    open fun enable(spr: TileSprite, system: Number? = definedExternally, debug: Boolean? = definedExternally): Unit
    open fun enable(spr: PIXI.Sprite, system: Number? = definedExternally, debug: Boolean? = definedExternally): Unit
    open fun enable(array: Array<TileSprite>, system: Number? = definedExternally, debug: Boolean? = definedExternally): Unit
    open fun enable(array: Array<PIXI.Sprite>, system: Number? = definedExternally, debug: Boolean? = definedExternally): Unit
    open fun enable(array: Array<Sprite>, system: Number? = definedExternally, debug: Boolean? = definedExternally): Unit
    //open fun enable(array: Array<Sprite>, system: Number? = definedExternally, debug: Boolean? = definedExternally): Unit
    open fun parseConfig(): Unit

    open fun preUpdate(): Unit
    open fun reset(): Unit
    open fun setBoundsToWorld(): Unit
    open fun startSystem(system: Number): Unit
    open fun update(): Unit

    companion object {
        var ARCADE: Number
        var P2JS: Number
        var NINJA: Number
        var BOX2D: Number
        var CHIPMUNK: Number
        var MATTERJS: Number
    }

    interface `T$4` {
        var up: Boolean? //
        var down: Boolean? //
        var left: Boolean? //
        var right: Boolean? //
    }

    //
    open class Arcade(game: Phaser.Game) {
        open var isPaused: Boolean
        open var bounds: Phaser.Rectangle
        open var checkCollision: `T$4`
        open var forceX: Boolean
        open var game: Phaser.Game
        open var gravity: Phaser.Point
        open var quadTree: Phaser.QuadTree
        open var maxObjects: Number
        open var maxLevels: Number
        open var skipQuadTree: Boolean
        open var sortDirection: Number
        open fun accelerationFromRotation(rotation: Number, speed: Number? = definedExternally, point: Phaser.Point? = definedExternally): Phaser.Point
        open fun accelerateToObject(displayObject: Any, destination: Any, speed: Number? = definedExternally, xSpeedMax: Number? = definedExternally, ySpeedMax: Number? = definedExternally): Number
        open fun accelerateToPointer(displayObject: Any, pointer: Phaser.Pointer? = definedExternally, speed: Number? = definedExternally, xSpeedMax: Number? = definedExternally, ySpeedMax: Number? = definedExternally): Number
        open fun accelerateToXY(displayObject: Any, x: Number, y: Number, speed: Number? = definedExternally, xSpeedMax: Number? = definedExternally, ySpeedMax: Number? = definedExternally): Number
        open fun angleBetween(source: Any, target: Any, world: Boolean? = definedExternally): Double
        open fun angleToPointer(displayObject: Any, pointer: Phaser.Pointer? = definedExternally, world: Boolean? = definedExternally): Double
        open fun angleToXY(displayObject: Any, x: Number, y: Number, world: Boolean? = definedExternally): Double
        open fun collide(object1: Any, object2: Any? = definedExternally): Boolean
        open fun collide(object1: Any, object2: Any? = definedExternally, collideCallback: (Sprite, Sprite) -> Unit?, processCallback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally): Boolean
        open fun computeVelocity(axis: Number, body: Phaser.Physics.Arcade.Body, velocity: Number, acceleration: Number, drag: Number, max: Number? = definedExternally): Number
        open fun distanceBetween(source: Any, target: Any, world: Boolean? = definedExternally): Double
        open fun distanceToPointer(displayObject: Any, pointer: Phaser.Pointer? = definedExternally, world: Boolean? = definedExternally): Double
        open fun distanceToXY(displayObject: Any, x: Number, y: Number, world: Boolean? = definedExternally): Double
        //
        //open fun enableJs(`object`: Any): Unit

        //open fun enableJs(`object`: Any, children: Boolean?): Unit
        @JsName("enable")
        open fun enableJs(`object`: Any, children: Boolean?): Unit

        open fun enableBody(`object`: Any): Unit

        open fun getObjectsAtLocation(x: Number, y: Number, group: Phaser.Group, callback: ((callbackArg: Any, `object`: Any) -> Unit)? = definedExternally, callbackContext: Any? = definedExternally, callbackArg: Any? = definedExternally): Array<Sprite>
        open fun getOverlapX(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body): Number
        open fun getOverlapY(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body): Number
        open fun intersects(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body): Boolean
        open fun moveToObject(displayObject: Any, destination: Any, speed: Number? = definedExternally, maxTime: Number? = definedExternally): Double
        open fun moveToPointer(displayObject: Any, speed: Number? = definedExternally, pointer: Phaser.Pointer? = definedExternally, maxTime: Number? = definedExternally): Double
        open fun moveToXY(displayObject: Any, x: Number, y: Number, speed: Number? = definedExternally, maxTime: Number? = definedExternally): Double
        open fun overlap(object1: Any, object2: Any, overlapCallback: (Sprite, Sprite) -> Unit, processCallback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally): Boolean
        open fun processTileSeparationX(body: Phaser.Physics.Arcade.Body, x: Number): Boolean
        open fun processTileSeparationY(body: Phaser.Physics.Arcade.Body, y: Number): Unit
        open fun setBounds(x: Number, y: Number, width: Number, height: Number): Unit
        open fun setBoundsToWorld(): Unit
        open fun separate(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body, processCallback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally, overlapOnly: Boolean? = definedExternally): Boolean
        open fun separateX(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body, overlapOnly: Boolean): Boolean
        open fun separateY(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body, overlapOnly: Boolean): Boolean
        open fun separateTile(i: Number, body: Phaser.Physics.Arcade.Body, tile: Phaser.Tile): Boolean
        open fun sort(group: Phaser.Group): Unit
        open fun tileCheckX(body: Phaser.Physics.Arcade.Body, tile: Phaser.Tile): Number
        open fun tileCheckY(body: Phaser.Physics.Arcade.Body, tile: Phaser.Tile): Number
        open fun updateMotion(body: Phaser.Physics.Arcade.Body): Unit
        open fun velocityFromAngle(angle: Number, speed: Number? = definedExternally, point: Phaser.Point? = definedExternally): Phaser.Point
        open fun velocityFromRotation(rotation: Number, speed: Number? = definedExternally, point: Phaser.Point? = definedExternally): Phaser.Point

        companion object {
            var SORT_NONE: Number
            var LEFT_RIGHT: Number
            var RIGHT_LEFT: Number
            var TOP_BOTTOM: Number
            var BOTTOM_TOP: Number
            var OVERLAP_BIAS: Number
            var TILE_BIAS: Number
        }

        open class Body(sprite: Phaser.Sprite) {
            open var acceleration: Phaser.Point
            open var allowGravity: Boolean
            open var allowRotation: Boolean
            open var angle: Number
            open var angularAcceleration: Number
            open var angularDrag: Number
            open var angularVelocity: Number
            open var blocked: FaceChoices
            open var bottom: Number
            open var bounce: Phaser.Point
            open var center: Phaser.Point
            open var checkCollision: FaceChoices
            open var collideWorldBounds: Boolean
            open var customSeparateX: Boolean
            open var customSeparateY: Boolean
            open var deltaMax: Phaser.Point
            open var dirty: Boolean
            open var drag: Phaser.Point
            open var embedded: Boolean
            open var enable: Boolean
            open var facing: Number
            open var friction: Phaser.Point
            open var game: Phaser.Game
            open var gravity: Phaser.Point
            open var halfWidth: Number
            open var halfHeight: Number
            open var height: Number
            open var immovable: Boolean
            open var isCircle: Boolean
            open var isMoving: Boolean
            open var mass: Number
            open var maxAngular: Number
            open var maxVelocity: Phaser.Point
            open var moves: Boolean
            open var movementCallback: Any
            open var movementCallbackContext: Any
            open var newVelocity: Phaser.Point
            open var offset: Phaser.Point
            open var onCollide: Phaser.Signal
            open var onMoveComplete: Phaser.Signal
            open var onOverlap: Phaser.Signal
            open var onWorldBounds: Phaser.Signal
            open var overlapX: Number
            open var overlapY: Number
            open var phase: Number
            open var position: Phaser.Point
            open var preRotation: Number
            open var prev: Phaser.Point
            open var radius: Number
            open var right: Number
            open var rotation: Number
            open var skipQuadTree: Boolean
            open var sourceWidth: Number
            open var sourceHeight: Number
            open var speed: Number
            open var sprite: Phaser.Sprite
            open var stopVelocityOnCollide: Boolean
            open var syncBounds: Boolean
            open var tilePadding: Phaser.Point
            open var touching: FaceChoices
            open var type: Number
            open var wasTouching: FaceChoices
            open var width: Number
            open var worldBounce: Phaser.Point
            open var velocity: Phaser.Point
            open var x: Double
            open var y: Double
            open fun checkWorldBounds(): Unit
            open fun deltaX(): Number
            open fun deltaY(): Number
            open fun deltaZ(): Number
            open fun deltaAbsX(): Number
            open fun deltaAbsY(): Number
            open fun destroy(): Unit
            open fun getBounds(obj: Any): Any
            open fun hitTest(x: Number, y: Number): Boolean
            open fun moveFrom(duration: Number, speed: Number? = definedExternally, direction: Number? = definedExternally): Boolean
            open fun moveTo(duration: Number, distance: Number, direction: Number? = definedExternally): Boolean
            open fun onFloor(): Boolean
            open fun onWall(): Boolean
            open fun preUpdate(): Unit
            open fun postUpdate(): Unit
            open fun render(context: Any, body: Phaser.Physics.Arcade.Body, color: String? = definedExternally, filled: Boolean? = definedExternally): Unit
            open fun renderBodyInfo(debug: Phaser.Utils.Debug, body: Phaser.Physics.Arcade.Body): Unit
            open fun reset(x: Number, y: Number): Unit
            open fun setCircle(radius: Number, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Unit
            open fun setSize(width: Number, height: Number, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Unit
            open fun updateBounds(): Boolean
        }

        open class FaceChoices {
            open var none: Boolean
            open var any: Boolean
            open var up: Boolean
            open var down: Boolean
            open var left: Boolean
            open var right: Boolean
        }
        //    }
    }

    /*open class Ninja(game: Phaser.Game) {
        open var game: Phaser.Game
        open var gravity: Number
        open var bounds: Phaser.Rectangle
        open var maxObjects: Number
        open var maxLevels: Number
        open var quadTree: Phaser.QuadTree
        open var time: Phaser.Time
        open fun clearTilemapLayerBodies(map: Phaser.Tilemap, layer: Any): Unit
        open fun collide(object1: Any, object2: Any, collideCallback: Function<Any>? = definedExternally, processCallback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally): Boolean
        open fun convertTilemap(map: Phaser.Tilemap, layer: Any, slopeMap: Any): Array<Phaser.Physics.Ninja.Tile>
        open fun enableAABB(`object`: Any, children: Boolean? = definedExternally): Unit
        open fun enableCircle(`object`: Any, radius: Number, children: Boolean? = definedExternally): Unit
        open fun enableTile(`object`: Any, id: Number, children: Boolean? = definedExternally): Unit
        open fun enable(`object`: Any, type: Number? = definedExternally, id: Number? = definedExternally, radius: Number? = definedExternally, children: Boolean? = definedExternally): Unit
        open fun enableBody(`object`: Any, type: Number? = definedExternally, id: Number? = definedExternally, radius: Number? = definedExternally): Unit
        open fun overlap(object1: Any, object2: Any, overlapCallback: Function<Any>? = definedExternally, processCallback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally): Boolean
        open fun separate(body1: Phaser.Physics.Ninja.Body, body2: Phaser.Physics.Ninja.Body, processCallback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally, overlapOnly: Boolean? = definedExternally): Boolean
        open fun setBounds(x: Number, y: Number, width: Number, height: Number): Unit
        open fun setBoundsToWorld(): Unit
        //companion object {
        open class Body(system: Phaser.Physics.Ninja, sprite: Phaser.Sprite, type: Number? = definedExternally, id: Number? = definedExternally, radius: Number? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally) {
            open var aabb: Phaser.Physics.Ninja.AABB
            open var angle: Number
            open var bottom: Number
            open var bounce: Number
            open var checkCollision: Phaser.Physics.Arcade.FaceChoices
            open var circle: Phaser.Physics.Ninja.Circle
            open var collideWorldBounds: Boolean
            open var drag: Number
            open var facing: Number
            open var friction: Number
            open var game: Phaser.Game
            open var gravityScale: Number
            open var height: Number
            open var immovable: Boolean
            open var maxSpeed: Number
            open var right: Number
            open var sprite: Phaser.Sprite
            open var system: Phaser.Physics.Ninja
            open var tile: Phaser.Physics.Ninja.Tile
            open var touching: Phaser.Physics.Arcade.FaceChoices
            open var type: Number
            open var shape: Any
            open var speed: Number
            open var velocity: Phaser.Point
            open var wasTouching: Phaser.Physics.Arcade.FaceChoices
            open var width: Number
            open var x: Number
            open var y: Number
            open fun deltaAbsX(): Number
            open fun deltaAbsY(): Number
            open fun deltaX(): Number
            open fun deltaY(): Number
            open fun destroy(): Unit
            open fun setZeroVelocity(): Unit
            open fun moveTo(speed: Number, angle: Number): Unit
            open fun moveFrom(speed: Number, angle: Number): Unit
            open fun moveLeft(speed: Number): Unit
            open fun moveRight(speed: Number): Unit
            open fun moveUp(speed: Number): Unit
            open fun moveDown(speed: Number): Unit
            open fun poseUpdate(): Unit
            open fun preUpdate(): Unit
            open fun render(context: Any, body: Phaser.Physics.Ninja.Body, color: String? = definedExternally, filled: Boolean? = definedExternally): Unit
            open fun reset(): Unit
        }

        open class AABB(body: Phaser.Physics.Ninja.Body, x: Number, y: Number, width: Number, height: Number) {
            open var aabbTileProjections: Any
            open var body: Phaser.Physics.Ninja.Body
            open var height: Number
            open var oldPos: Phaser.Point
            open var pos: Phaser.Point
            open var system: Phaser.Physics.Ninja
            open var width: Number
            open var velocity: Phaser.Point
            open var xw: Number
            open var yw: Number
            open fun collideWorldBounds(): Unit
            open fun collideAABBVsAABB(aabb: Phaser.Physics.Ninja.AABB): Boolean
            open fun collideAABBVsTile(tile: Phaser.Physics.Ninja.Tile): Boolean
            open fun destroy(): Unit
            open fun integrate(): Unit
            open fun render(context: Any, xOffset: Number, yOffset: Number, color: String, filled: Boolean): Unit
            open fun reportCollision(px: Number, py: Number, dx: Number, dy: Number): Unit
            open fun reportCollisionVsWorld(px: Number, py: Number, dx: Number, dy: Number, obj: Any): Unit
            open fun reportCollisionVsBody(px: Number, py: Number, dx: Number, dy: Number, obj: Any): Unit
            open fun resolveTile(x: Number, y: Number, body: Phaser.Physics.Ninja.AABB, tile: Phaser.Physics.Ninja.Tile): Boolean
            open fun reverse(): Unit

            companion object {
                var COL_NONE: Number
                var COL_AXIS: Number
                var COL_OTHER: Number
            }
        }

        /*external interface `T$5` {
                @nativeGetter
                fun get(index: Number): (x: Number, y: Number, oH: Number, oV: Number, obj: Phaser.Physics.Ninja.Circle, t: Phaser.Physics.Ninja.Tile) -> Number?
                @nativeSetter
                fun set(index: Number, value: (x: Number, y: Number, oH: Number, oV: Number, obj: Phaser.Physics.Ninja.Circle, t: Phaser.Physics.Ninja.Tile) -> Number)
            }*/
        open class Circle(body: Phaser.Physics.Ninja.Body, x: Number, y: Number, radius: Number) {
            open var COL_NONE: Number
            open var COL_AXIS: Number
            open var COL_OTHER: Number
            open var body: Phaser.Physics.Ninja.Body
            //open var circleTileProjections: `T$5`
            open var oldPos: Phaser.Point
            open var height: Number
            open var pos: Phaser.Point
            open var radius: Number
            open var system: Phaser.Physics.Ninja
            open var type: Number
            open var velocity: Phaser.Point
            open var width: Number
            open var xw: Number
            open var yw: Number
            open fun collideCircleVsTile(tile: Phaser.Physics.Ninja.Tile): Boolean
            open fun collideWorldBounds(): Unit
            open fun destroy(): Unit
            open fun distance(dest: Number, round: Boolean? = definedExternally): Number
            open fun integrate(): Unit
            open fun render(context: Any, xOffset: Number, yOffset: Number, color: String, filled: Boolean): Unit
            open fun reportCollisionVsWorld(px: Number, py: Number, dx: Number, dy: Number, obj: Any): Unit
            open fun reportCollisionVsBody(px: Number, py: Number, dx: Number, dy: Number, obj: Any): Unit
            open fun resolveCircleTile(x: Number, y: Number, oH: Number, oV: Number, obj: Phaser.Physics.Ninja.Circle, t: Phaser.Physics.Ninja.Tile): Boolean
        }

        enum class TileType {
            TYPE_EMPTY,
            TYPE_FULL,
            TYPE_45DEG,
            TYPE_CONCAVE,
            TYPE_CONVEX,
            TYPE_22DEGs,
            TYPE_22DEGb,
            TYPE_67DEGs,
            TYPE_67DEGb,
            TYPE_HALF
        }

        open class Tile(body: Phaser.Physics.Ninja.Body, x: Number, y: Number, width: Number, height: Number, type: Number? = definedExternally) {
            open var body: Phaser.Physics.Ninja.Body
            open var bottom: Number
            open var flipped: Boolean
            open var height: Number
            open var id: Number
            open var oldpos: Phaser.Point
            open var pos: Phaser.Point
            open var right: Number
            open var rotation: Number
            open var system: Phaser.Physics.Ninja
            open var type: Phaser.Physics.Ninja.TileType
            open var velocity: Phaser.Point
            open var width: Number
            open var xw: Number
            open var yw: Number
            open var x: Number
            open var y: Number
            open fun clear(): Unit
            open fun collideWorldBounds(): Unit
            open fun destroy(): Unit
            open fun integrate(): Unit
            open fun reportCollisionVsWorld(px: Number, py: Number, dx: Number, dy: Number, obj: Any): Unit
            open fun setType(id: Number): Number
        }
        //}
    }
    */
    interface `T$6` {
        var left: Phaser.Physics.P2.Body?
        var right: Phaser.Physics.P2.Body?
        var top: Phaser.Physics.P2.Body?
        var bottom: Phaser.Physics.P2.Body?
    }


    open class P2(game: Phaser.Game, config: Any? = definedExternally) {
        open var applyDamping: Boolean
        open var applyGravity: Boolean
        open var applySpringForces: Boolean
        open var boundsCollidesWith: Array<Phaser.Physics.P2.Body>
        open var boundsCollisionGroup: Phaser.Physics.P2.CollisionGroup
        open var config: Any
        open var callbackContext: Any
        open var collisionGroups: Array<Phaser.Physics.P2.CollisionGroup>
        open var contactMaterial: Phaser.Physics.P2.ContactMaterial
        open var emitImpactEvent: Boolean
        open var everythingCollisionGroup: Phaser.Physics.P2.CollisionGroup
        open var frameRate: Number
        open var friction: Number
        open var game: Phaser.Game
        open var gravity: Phaser.Physics.P2.InversePointProxy
        open var materials: Array<Phaser.Physics.P2.Material>
        open var nothingCollisionGroup: Phaser.Physics.P2.CollisionGroup
        open var onBodyAdded: Phaser.Signal
        open var onBodyRemoved: Phaser.Signal
        open var onBeginContact: Phaser.Signal
        open var onConstraintAdded: Phaser.Signal
        open var onConstraintRemoved: Phaser.Signal
        open var onContactMaterialAdded: Phaser.Signal
        open var onContactMaterialRemoved: Phaser.Signal
        open var onEndContact: Phaser.Signal
        open var onSpringAdded: Phaser.Signal
        open var onSpringRemoved: Phaser.Signal
        open var paused: Boolean
        open var postBroaddphaseCallback: Function<Any>
        open var restitution: Double
        open var solveConstraints: Boolean
        open var time: Any
        open var total: Number
        open var useElapsedTime: Boolean
        open var walls: `T$6`
        open var world: p2.World
        open fun addBody(body: Phaser.Physics.P2.Body): Boolean
        open fun addContactMaterial(material: Phaser.Physics.P2.ContactMaterial): Phaser.Physics.P2.ContactMaterial
        open fun <T> addConstraint(constraint: T): T
        open fun addSpring(spring: Phaser.Physics.P2.Spring): Phaser.Physics.P2.Spring
        open fun beginContactHandler(event: Any): Unit
        open fun clear(): Unit
        open fun clearTilemapLayerBodies(map: Phaser.Tilemap, layer: Any? = definedExternally): Unit
        open fun convertCollisionObjects(map: Phaser.Tilemap, layer: Any? = definedExternally, addToWorld: Boolean? = definedExternally): Array<Phaser.Physics.P2.Body>
        open fun convertTilemap(map: Phaser.Tilemap, layer: Any? = definedExternally, addToWorld: Boolean? = definedExternally, optimize: Boolean? = definedExternally): Array<Phaser.Physics.P2.Body>
        open fun createBody(x: Number, y: Number, mass: Number, addToWorld: Boolean? = definedExternally, options: p2.BodyOptions? = definedExternally, data: Array<Array<Number>>? = definedExternally): Phaser.Physics.P2.Body
        open fun createBody(x: Number, y: Number, mass: Number, addToWorld: Boolean? = definedExternally, options: p2.BodyOptions? = definedExternally, data: Array<Number>? = definedExternally): Phaser.Physics.P2.Body
        open fun createCollisionGroup(): Phaser.Physics.P2.CollisionGroup
        open fun createCollisionGroup(group: Phaser.Group?): Phaser.Physics.P2.CollisionGroup
        open fun createCollisionGroup(group: Phaser.Sprite?): Phaser.Physics.P2.CollisionGroup
        open fun createContactMaterial(materialA: Phaser.Physics.P2.Material, materialB: Phaser.Physics.P2.Material): Phaser.Physics.P2.ContactMaterial
        open fun createContactMaterial(materialA: Phaser.Physics.P2.Material, materialB: Phaser.Physics.P2.Material, options: IContactMaterialOptions? = definedExternally): Phaser.Physics.P2.ContactMaterial
        open fun createDistanceConstraint(bodyA: Any, bodyB: Any, distance: Number, localAnchorA: Array<Number>? = definedExternally, localAnchorB: Array<Number>? = definedExternally, maxForce: Number? = definedExternally): p2.DistanceConstraint
        open fun createGearConstraint(bodyA: Any, bodyB: Any, angle: Number? = definedExternally, ratio: Number? = definedExternally): Phaser.Physics.P2.GearConstraint
        open fun createLockConstraint(bodyA: Any, bodyB: Any, offset: Array<Number>? = definedExternally, angle: Number? = definedExternally, maxForce: Number? = definedExternally): Phaser.Physics.P2.LockConstraint
        open fun createMaterial(name: String? = definedExternally, body: Phaser.Physics.P2.Body? = definedExternally): Phaser.Physics.P2.Material
        open fun createParticle(x: Number, y: Number, mass: Number, addToWorld: Boolean? = definedExternally, options: p2.BodyOptions? = definedExternally, data: Array<Array<Number>>? = definedExternally): Phaser.Physics.P2.Body
        open fun createParticle(x: Number, y: Number, mass: Number, addToWorld: Boolean? = definedExternally, options: p2.BodyOptions? = definedExternally, data: Array<Number>? = definedExternally): Phaser.Physics.P2.Body
        open fun createPrismaticConstraint(body: Any, bodyB: Any, lockRotation: Boolean? = definedExternally, anchorA: Array<Number>? = definedExternally, anchorB: Array<Number>? = definedExternally, axis: Float32Array? = definedExternally, maxForce: Number? = definedExternally): Phaser.Physics.P2.PrismaticConstraint
        open fun createRevoluteConstraint(bodyA: Any, pivotA: Array<Number>, bodyB: Any, pivotB: Array<Double>, maxForce: Number? = definedExternally, worldPivot: Array<Number>? = definedExternally): Phaser.Physics.P2.RevoluteConstraint
        open fun createRotationalSpring(bodyA: Any, bodyB: Any, restAngle: Number? = definedExternally, stiffness: Number? = definedExternally, damping: Number? = definedExternally): p2.RotationalSpring
        open fun createSpring(bodyA: Any, bodyB: Any, restLength: Number? = definedExternally, stiffness: Number? = definedExternally, damping: Number? = definedExternally, worldA: Array<Number>? = definedExternally, worldB: Array<Number>? = definedExternally, localA: Array<Number>? = definedExternally, localB: Array<Number>? = definedExternally): Phaser.Physics.P2.Spring
        open fun destroy(): Unit
        open fun enable(`object`: Any, debug: Boolean? = definedExternally, children: Boolean? = definedExternally): Unit
        open fun enableBody(`object`: Any, debug: Boolean): Unit
        open fun endContactHandler(event: Any): Unit
        open fun getBodies(): Array<Phaser.Physics.P2.Body>
        open fun getBody(`object`: Any): Phaser.Physics.P2.Body
        open fun getConstraints(): Array<p2.Constraint>
        open fun getSprings(): Array<Phaser.Physics.P2.Spring>
        open fun getContactMaterial(materialA: Phaser.Physics.P2.Material, materialB: Phaser.Physics.P2.Material): Phaser.Physics.P2.ContactMaterial
        open fun hitTest(worldPoint: Phaser.Point, bodies: Array<Any>? = definedExternally, precision: Number? = definedExternally, filterStatic: Boolean? = definedExternally): Array<Phaser.Physics.P2.Body>
        open fun mpx(v: Double): Double
        open fun mpxi(v: Double): Double
        open fun pause(): Unit
        open fun preUpdate(): Unit
        open fun pxm(v: Number): Double
        open fun pxmi(v: Number): Double
        open fun removeBody(body: Phaser.Physics.P2.Body): Phaser.Physics.P2.Body
        open fun removeBodyNextStep(body: Phaser.Physics.P2.Body): Unit
        open fun <T> removeConstraint(constraint: T): T
        open fun removeContactMaterial(material: Phaser.Physics.P2.ContactMaterial): Phaser.Physics.P2.ContactMaterial
        open fun removeSpring(spring: Phaser.Physics.P2.Spring): Phaser.Physics.P2.Spring
        open fun reset(): Unit
        open fun resume(): Unit
        open fun setBounds(x: Number, y: Number, width: Number, height: Number, left: Boolean? = definedExternally, right: Boolean? = definedExternally, top: Boolean? = definedExternally, bottom: Boolean? = definedExternally, setCollisionGroup: Boolean? = definedExternally): Unit
        open fun setBoundsToWorld(left: Boolean? = definedExternally, right: Boolean? = definedExternally, top: Boolean? = definedExternally, bottom: Boolean? = definedExternally, setCollisionGroup: Boolean? = definedExternally): Unit
        open fun setCollisionGroup(`object`: Any, group: Phaser.Physics.P2.CollisionGroup): Unit
        open fun setImpactEvents(state: Boolean): Unit
        open fun setMaterial(material: Phaser.Physics.P2.Material, bodies: Array<Phaser.Physics.P2.Body>? = definedExternally): Unit
        open fun setPostBroadphaseCallback(callback: Function<Any>, context: Any): Unit
        open fun setWorldMaterial(material: Phaser.Physics.P2.Material, left: Boolean? = definedExternally, right: Boolean? = definedExternally, top: Boolean? = definedExternally, bottom: Boolean? = definedExternally): Unit
        open fun toJSON(): Any
        open fun update(): Unit
        open fun updateBoundsCollisionGroup(setCollisionGroup: Boolean? = definedExternally): Unit
        //companion object {
        interface `T$7` {
            var optimalDecomp: Boolean? //
            var skipSimpleCheck: Boolean?
            var removeCollinearPoints: Boolean? //
        }

        open class Body(game: Phaser.Game, sprite: Phaser.Sprite? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, mass: Number? = definedExternally) : p2.Body {
            open var parent: Body
            //open var allowSleep: Boolean
            //open var angle: Number
            //open var angularDamping: Number
            //open var angularForce: Number
            //open var angularVelocity: Number
            open var collidesWith: Array<Phaser.Physics.P2.CollisionGroup>
            open var collideWorldBounds: Boolean
            //open var damping: Number
            open var data: Phaser.Physics.P2.Body
            open var debug: Boolean
            open var debugBody: Phaser.Physics.P2.BodyDebug
            open var dynamic: Boolean
            //open var fixedRotation: Boolean
            //open var force: Phaser.Physics.P2.InversePointProxy
            open var kinematic: Boolean
            open var game: Phaser.Game
            open var gravity: Phaser.Point
            //open var id: Number
            //open var inertia: Number
            //open var mass: Number
            open var motionState: Number
            open var offset: Phaser.Point
            open var onBeginContact: Phaser.Signal
            open var onEndContact: Phaser.Signal
            open var rotation: Number
            open var removeNextStep: Boolean
            open var sprite: Phaser.Sprite
            //open var sleepSpeedLimit: Number
            open var static: Boolean
            //open var type: Number
            //open var velocity: Phaser.Physics.P2.InversePointProxy
            //open var world: Phaser.Physics.P2
            open var x: Number
            open var y: Number
            open fun addToWorld(): Unit
            open fun addCapsule(length: Number, radius: Number, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally, rotation: Number? = definedExternally): p2.Capsule
            open fun addCircle(radius: Number, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally, rotation: Number? = definedExternally): p2.Circle
            open fun addFixture(fixtureData: String): Array<p2.Shape>
            open fun addLine(length: Number, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally, rotation: Number? = definedExternally): p2.Line
            open fun addParticle(offsetX: Number? = definedExternally, offsetY: Number? = definedExternally, rotation: Number? = definedExternally): p2.Particle
            open fun addPolygon(options: `T$7`, points: Array<Array<Number>>): Boolean
            open fun addPhaserPolygon(key: String, `object`: String): Phaser.Physics.P2.FixtureList
            open fun addPlane(offsetX: Number? = definedExternally, offsetY: Number? = definedExternally, rotation: Number? = definedExternally): p2.Plane
            open fun addRectangle(width: Number, height: Number, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally, rotation: Number? = definedExternally): p2.Rectangle
            open fun addShape(shape: p2.Shape, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally, rotation: Number? = definedExternally): p2.Shape
            //open fun adjustCenterOfMass(): Unit
            //open fun applyDamping(dt: Number): Unit
            open fun applyForce(force: Array<Number>, worldX: Number, worldY: Number): Unit

            open fun applyImpulse(impulse: Array<Number>, worldX: Number, worldY: Number): Unit
            open fun applyImpulseLocal(impulse: Array<Number>, localX: Number, localY: Number): Unit
            open fun clearCollision(clearGroup: Boolean? = definedExternally, cleanMask: Boolean? = definedExternally, shape: p2.Shape? = definedExternally): Unit
            open fun clearShapes(): Unit
            open fun collides(group: Any, callback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally, shape: p2.Shape? = definedExternally): Unit
            open fun createBodyCallback(`object`: Any, callback: Function<Any>, callbackContext: Any): Unit
            open fun createGroupCallback(group: Phaser.Physics.P2.CollisionGroup, callback: Function<Any>, callbackContext: Any): Unit
            open fun destroy(): Unit
            open fun getCollisionMask(): Number
            open fun getVelocityAtPoint(result: Array<Number>, relativePoint: Array<Number>): Array<Number>
            open fun loadPolygon(key: String, `object`: String): Boolean
            open fun moveBackward(speed: Number): Unit
            open fun moveDown(speed: Number): Unit
            open fun moveForward(speed: Number): Unit
            open fun moveLeft(speed: Number): Unit
            open fun moveRight(speed: Number): Unit
            open fun moveUp(speed: Number): Unit
            open fun preUpdate(): Unit
            open fun postUpdate(): Unit
            open fun removeCollisionGroup(group: Any, clearCallback: Boolean? = definedExternally, shape: p2.Shape? = definedExternally): Unit
            open fun removeFromWorld(): Unit
            //open fun removeShape(shape: p2.Shape): Boolean
            open fun reverse(speed: Number): Unit

            open fun rotateLeft(speed: Number): Unit
            open fun rotateRight(speed: Number): Unit
            open fun reset(x: Number, y: Number, resetDamping: Boolean? = definedExternally, resetMass: Boolean? = definedExternally): Unit
            open fun shapeChanged(): Unit
            open fun setCircle(radius: Number, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally, rotation: Number? = definedExternally): p2.Circle
            open fun setCollisionGroup(group: Phaser.Physics.P2.CollisionGroup, shape: p2.Shape? = definedExternally): Unit
            open fun setRectangle(width: Number? = definedExternally, height: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally, rotation: Number? = definedExternally): p2.Rectangle
            open fun setRectangleFromSprite(sprite: Any): p2.Rectangle
            open fun setMaterial(material: Phaser.Physics.P2.Material, shape: p2.Shape? = definedExternally): Unit
            open fun setZeroDamping(): Unit
            //open fun setZeroForce(): Unit
            open fun setZeroRotation(): Unit

            open fun setZeroVelocity(): Unit
            open fun toLocalFrame(out: Array<Double>, worldPoint: Array<Double>): Unit
            open fun thrust(speed: Number): Unit
            open fun thrustLeft(speed: Number): Unit
            open fun thrustRight(speed: Number): Unit
            //open fun toWorldFrame(out: Array<Number>, localPoint: Array<Number>): Unit
            open fun updateCollisionMask(shape: p2.Shape? = definedExternally): Unit

            companion object {
                var DYNAMIC: Number
                var STATIC: Number
                var KINEMATIC: Number
            }
        }

        interface `T$8` {
            var pixelsPerLengthUnit: Number?//
            var debugPolygons: Boolean?//
            var lineWidth: Number? //
            var alpha: Number? //
        }

        open class BodyDebug(game: Phaser.Game, body: Phaser.Physics.P2.Body, settings: `T$8`) : Phaser.Group {
            open var body: Phaser.Physics.P2.Body
            open var canvas: Phaser.Graphics
            open var ppu: Number
            open fun updateSpriteTransform(): Unit
            open fun draw(): Unit
        }

        open class CollisionGroup(bitmask: Number) {
            open var mask: Number
        }

        open class ContactMaterial : p2.ContactMaterial
        open class DistanceConstraint(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body, bodyB: Phaser.Physics.P2.Body, distance: Number, maxForce: Number)/* : p2.DistanceConstraint*/ {
            open var game: Phaser.Game
            open var world: Phaser.Physics.P2
        }

        open class FixtureList(list: Array<Any>) {
            open fun flatten(array: Array<Any>): Array<Any>
            open fun getFixtures(keys: String): Array<Any>
            open fun getFixtureByKey(key: String): Array<Any>
            open fun getGroup(groupID: Number): Array<Any>
            open fun init(): Unit
            open fun parse(): Unit
            open fun setCategory(bit: Number, fictureKey: String): Unit
            open fun setMask(bit: Number, fixtureKey: String): Unit
            open fun setMaterial(material: Any, fixtureKey: String): Unit
            open fun setSensor(value: Boolean, fixtureKey: String): Unit
        }

        open class GearConstraint(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body, bodyB: Phaser.Physics.P2.Body, angle: Number? = definedExternally, ratio: Number? = definedExternally)/* : p2.GearConstraint*/ {
            open var game: Phaser.Game
            open var world: Phaser.Physics.P2
        }

        open class InversePointProxy(world: Phaser.Physics.P2, destination: Any) {
            open var x: Number
            open var y: Number
            open var mx: Number
            open var my: Number
        }

        open class LockConstraint(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body, bodyB: Phaser.Physics.P2.Body, offset: Array<Number>? = definedExternally, angle: Number? = definedExternally, maxForce: Number? = definedExternally) /*: p2.LockConstraint*/ {
            open var game: Phaser.Game
            open var world: Phaser.Physics.P2
        }

        open class Material(name: String) : p2.Material {
            open var name: String
        }

        open class PointProxy(world: Phaser.Physics.P2, destination: Any) {
            open var x: Number
            open var y: Number
            open var mx: Number
            open var my: Number
        }

        open class PrismaticConstraint(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body? = definedExternally, bodyB: Phaser.Physics.P2.Body? = definedExternally, lockRotation: Boolean? = definedExternally, anchorA: Array<Number>? = definedExternally, anchorB: Array<Number>? = definedExternally, axis: Array<Number>? = definedExternally, maxForce: Number? = definedExternally)/* : p2.PrismaticConstraint*/ {
            open var game: Phaser.Game
            open var world: Phaser.Physics.P2
        }

        open class RevoluteConstraint(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body, pivotA: Array<Number>, bodyB: Phaser.Physics.P2.Body, pivotB: Array<Number>, maxForce: Number? = definedExternally) /*: p2.RevoluteConstraint*/ {
            open var game: Phaser.Game
            open var world: Phaser.Physics.P2
        }

        open class Spring(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body, bodyB: Phaser.Physics.P2.Body, restLength: Number? = definedExternally, stiffness: Number? = definedExternally, damping: Number? = definedExternally, worldA: Array<Number>? = definedExternally, worldB: Array<Number>? = definedExternally, localA: Array<Number>? = definedExternally, localB: Array<Number>? = definedExternally) {
            open var data: p2.LinearSpring
            open var game: Phaser.Game
            open var world: Phaser.Physics.P2
        }
    }
}

//}
//}
//}

external open class Video(game: Phaser.Game, key: String? = definedExternally, url: String? = definedExternally) {
    open var game: Phaser.Game
    open var key: String
    open var video: HTMLVideoElement
    open var baseTexture: PIXI.BaseTexture
    open var texture: PIXI.Texture
    open var textureFrame: Phaser.Frame
    open var type: Number
    open var disableTextureUpload: Boolean
    open var dirty: Boolean
    open var currentTime: Double
    open var duration: Double
    open var progress: Double
    open var mute: Boolean
    open var paused: Boolean
    open var volume: Boolean
    open var playbackRate: Boolean
    open var playing: Boolean
    open var loop: Boolean
    open var width: Number
    open var height: Number
    open var videoStream: Any
    open var isStreaming: Boolean
    open var snapshot: Phaser.BitmapData
    open var timeout: Number
    open var retryLimit: Number
    open var retry: Number
    open var retryInterval: Number
    open var onAccess: Phaser.Signal1<Video>
    open var onError: Phaser.Signal2<Video, Any>
    open var onPlay: Phaser.Signal
    open var onComplete: Phaser.Signal
    open var onUpdate: Phaser.Signal
    open var onTimeout: Phaser.Signal
    open var touchLocked: Boolean
    open var complete: () -> Unit
    open fun add(`object`: Phaser.Sprite): Phaser.Video
    open fun add(`object`: Array<Phaser.Sprite>): Phaser.Video
    open fun add(`object`: Phaser.Image): Phaser.Video
    open fun add(`object`: Array<Phaser.Image>): Phaser.Video
    open fun addToWorld(x: Number? = definedExternally, y: Number? = definedExternally, anchorX: Number? = definedExternally, anchorY: Number? = definedExternally, scaleX: Number? = definedExternally, scaleY: Number? = definedExternally): Phaser.Image
    open fun createVideoFromBlob(blob: Blob): Phaser.Video
    open fun startMediaStream(captureAudio: Boolean? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally): Phaser.Video
    open fun createVideoFromURL(url: String, autoplay: Boolean? = definedExternally): Phaser.Video
    open fun changeSource(src: String, autoplay: Boolean? = definedExternally): Phaser.Video
    open fun connectToMediaStram(video: Any, stream: Any): Phaser.Video
    open fun destroy(): Unit
    open fun play(loop: Boolean? = definedExternally, playbackRate: Number? = definedExternally): Phaser.Video
    open fun playHandler(): Unit
    open fun render(): Unit
    open fun removeVideoElement(): Unit
    open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
    open fun setTouchLock(): Unit
    open fun grab(clear: Boolean? = definedExternally, alpha: Number? = definedExternally): Phaser.BitmapData
    open fun grab(clear: Boolean? = definedExternally, alpha: Number? = definedExternally, blendMode: String? = definedExternally): Phaser.BitmapData
    open fun stop(): Unit
    open fun unlock(): Boolean
    open fun updateTexture(event: Any? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally): Unit
}


external open class Plugin() : IStateCycle {
    constructor(game: Phaser.Game, parent: Phaser.PluginManager) 

    open var active: Boolean
    open var game: Phaser.Game
    open var hasPostRender: Boolean
    open var hasPostUpdate: Boolean
    open var hasPreUpdate: Boolean
    open var hasRender: Boolean
    open var hasUpdate: Boolean
    open var parent: PIXI.DisplayObject
    open var visible: Boolean
    override fun destroy(): Unit
    override fun postRender(): Unit
    override fun preUpdate(): Unit
    override fun render(): Unit
    override fun update(): Unit
    //companion object {
    open class SaveCPU : Phaser.Plugin {
        open var renderOnFPS: Number
        open var renderOnPointerChange: Boolean
        open fun forceRender(): Unit
    }

    open class AStar(parent: PIXI.DisplayObject) : Phaser.Plugin {
        override var parent: PIXI.DisplayObject
        open var version: String
        open fun findPath(startPoint: Phaser.Point, goalPoint: Phaser.Point): Phaser.Plugin.AStar.AStarPath
        open fun isWalkable(x: Number, y: Number): Boolean
        open fun setAStarMap(map: Phaser.Tilemap, layerName: String, tilesetName: String): Phaser.Plugin.AStar
        //companion object {
        var VERSION: String
        var COST_ORTHAGONAL: Number
        var COST_DIAGAONAL: Number
        var DISTANCE_MANHATTEN: String
        var DISTANCE_EUCLIDIAN: String

        open class AStarNode(x: Number, y: Number, isWalkable: Boolean) {
            open var x: Number
            open var y: Number
            open var g: Number
            open var h: Number
            open var f: Number
            open var parent: Phaser.Plugin.AStar.AStarNode
            open var travelCost: Number
            open var walkable: Boolean
        }

        open class AStarPath(nodes: Array<Phaser.Plugin.AStar.AStarNode>, start: Phaser.Plugin.AStar.AStarNode, goal: Phaser.Plugin.AStar.AStarNode) {
            open var nodes: Array<Phaser.Plugin.AStar.AStarNode>
            open var start: Phaser.Plugin.AStar.AStarNode
            open var goal: Phaser.Plugin.AStar.AStarNode
            open var visited: Array<Phaser.Plugin.AStar.AStarNode>
        }
        //}
    }

    open class ColorHarmony : Phaser.Plugin {
        open fun getAnalogousHarmony(color: Number, threshold: Number? = definedExternally): Any
        open fun getComplementHarmony(color: Number): Number
        open fun getSplitComplementHarmony(color: Number, threshold: Number): Any
        open fun getTriadicHarmony(color: Number): Any
    }

    open class CSS3Filters(parent: PIXI.DisplayObject) : Phaser.Plugin {
        open var blur: Number
        open var brightness: Number
        open var contrast: Number
        open var grayscale: Number
        open var hueRotate: Number
        open var invert: Number
        open var opacity: Number
        open var saturate: Number
        open var sepia: Number
    }

    open class TilemapWalker(game: Phaser.Game, map: Phaser.Tilemap, layer: Any? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally) : Phaser.Plugin {
        open var collides: Boolean
        override var game: Phaser.Game
        open var history: Boolean
        open var facing: Number
        open var map: Phaser.Tilemap
        open var location: Phaser.Point
        open var locationLayer: Number
        open fun checkTile(x: Number, y: Number): Boolean
        open fun getTileFromLocation(x: Number, y: Number): Phaser.Tile
        open fun getTiles(width: Number, height: Number, center: Boolean? = definedExternally): Array<Any>
        open fun getTileBehind(distance: Number? = definedExternally): Phaser.Tile
        open fun getTileBehindLeft(distance: Number? = definedExternally): Phaser.Tile
        open fun getTileBehindRight(distance: Number? = definedExternally): Phaser.Tile
        open fun getTileAhead(distance: Number? = definedExternally): Phaser.Tile
        open fun getTileAheadLeft(distance: Number? = definedExternally): Phaser.Tile
        open fun getTileAheadRight(distance: Number? = definedExternally): Phaser.Tile
        open fun getTileLeft(distance: Number): Phaser.Tile
        open fun getTileRight(distance: Number): Phaser.Tile
        open fun moveForward(): Boolean
        open fun moveBackward(): Boolean
        open fun moveLeft(): Boolean
        open fun moveRight(): Boolean
        open fun putTile(index: Number): Unit
        open fun setLocation(x: Number, y: Number, layer: Any? = definedExternally): Boolean
        open fun turnLeft(): Unit
        open fun turnRight(): Unit
        open fun updateLocation(x: Number, y: Number): Boolean
    }

    open class SamplePlugin(game: Phaser.Game, parent: PIXI.DisplayObject) : Phaser.Plugin {
        open fun addSprite(sprite: Phaser.Sprite): Unit
        override fun update(): Unit
    }

    open class VirtualJoystick(game: Phaser.Game, parent: Any?) : Phaser.Plugin {
        open var angle: Number
        open var base: Phaser.Sprite
        open var baseBMD: Phaser.BitmapData
        open var baseCircle: Phaser.Circle
        open var deltaX: Number
        open var deltaY: Number
        open var distance: Number
        open var force: Number
        open var isDragging: Boolean
        open var limit: Number
        open var limitPoint: Phaser.Point
        open var location: Phaser.Point
        open var nub: Phaser.Sprite
        open var nubBMD: Phaser.BitmapData
        open var speed: Number
        open var x: Number
        open var y: Number
        open fun init(x: Number, y: Number, diameter: Number? = definedExternally, limit: Number? = definedExternally): Unit
        open fun move(pointer: Phaser.Pointer, x: Number, y: Number): Unit
        override fun render(): Unit
        open fun setVelocity(sprite: Phaser.Sprite, minSpeed: Number? = definedExternally, maxSpeed: Number? = definedExternally): Phaser.Sprite
        open fun startDrag(): Unit
        open fun stopDrag(nub: Phaser.Sprite, pointer: Phaser.Pointer): Unit
        override fun update(): Unit
    }

    open class Webcam(game: Phaser.Game, parent: PIXI.DisplayObject) : Phaser.Plugin {
        override var active: Boolean
        open var context: Any
        open var stream: Any
        open var video: HTMLVideoElement
        open var connectCallback: (stream: Any) -> Unit
        open var errorCallback: (e: Any) -> Unit
        open var grab: (context: Any, x: Number, y: Number) -> Unit
        open fun start(width: Number, height: Number, context: Any): Unit
        open fun stop(): Unit
        override fun update(): Unit
    }

    open class Juicy(game: Phaser.Game) : Phaser.Plugin {
        open fun createScreenFlash(color: String? = definedExternally): Phaser.Plugin.Juicy.ScreenFlash
        open fun createTrail(length: Number? = definedExternally, color: Number? = definedExternally): Phaser.Plugin.Juicy.Trail
        open fun overScale(`object`: Phaser.Sprite, scale: Number? = definedExternally, initialScale: Phaser.Point? = definedExternally): Unit
        open fun jelly(`object`: Phaser.Sprite, strength: Number? = definedExternally, delay: Number? = definedExternally, initialScale: Phaser.Point? = definedExternally): Unit
        open fun mouseStretch(`object`: Phaser.Sprite, strength: Number? = definedExternally, initialScale: Phaser.Point? = definedExternally): Unit
        override fun update(): Unit
        open fun shake(duration: Number? = definedExternally, strength: Number? = definedExternally): Unit
        //companion object {
        open class Trail(game: Phaser.Game, trailLength: Number? = definedExternally, color: Number? = definedExternally) {
            open var target: Phaser.Sprite
            open var trailLength: Number
            open var trailWidth: Number
            open var trailScaling: Boolean
            open var trailColor: Number
            open fun update(): Unit
            open fun addSegment(x: Number, y: Number): Unit
            open fun redrawSegments(offsetX: Number, offsetY: Number): Unit
        }

        open class ScreenFlash(game: Phaser.Game, color: String? = definedExternally) {
            open fun flash(maxAlpha: Number? = definedExternally, duration: Number? = definedExternally): Unit
        }
        //}
    }
    //}
}

external interface PluginConstructorOf<T> {

    fun invoke(vararg parameters: Any): T
}


external open class PluginManager(game: Phaser.Game) : IStateCycle {
    open var game: Phaser.Game
    open var plugins: Array<Phaser.Plugin>
    open fun <T : Phaser.Plugin> add(plugin: PluginConstructorOf<T>, vararg parameters: Any): T
    override fun destroy(): Unit
    override fun postRender(): Unit
    open fun postUpdate(): Unit
    override fun preUpdate(): Unit
    open fun remove(plugin: Phaser.Plugin, destroy: Boolean? = definedExternally): Unit
    open fun removeAll(): Unit
    override fun render(): Unit
    override fun update(): Unit
}


external open class Point(x: Number? = definedExternally, y: Number? = definedExternally) {
    open var x: Double
    open var y: Double
    open var type: Number
    open fun add(x: Number, y: Number): Phaser.Point
    open fun angle(a: Phaser.Point, asDegrees: Boolean? = definedExternally): Number
    open fun angleSq(a: Phaser.Point): Number
    open fun clamp(min: Number, max: Number): Phaser.Point
    open fun clampX(min: Number, max: Number): Phaser.Point
    open fun clampY(min: Number, max: Number): Phaser.Point
    open fun clone(output: Phaser.Point? = definedExternally): Phaser.Point
    open fun copyFrom(source: Phaser.Point): Phaser.Point
    open fun <T> copyTo(dest: T): T
    open fun ceil(): Phaser.Point
    open fun cross(a: Phaser.Point): Number
    open fun divide(x: Number, y: Number): Phaser.Point
    open fun distance(dest: Phaser.Point, round: Boolean? = definedExternally): Number
    open fun dot(a: Phaser.Point): Number
    open fun equals(a: Phaser.Point): Boolean
    open fun floor(): Phaser.Point
    open fun getMagnitude(): Number
    open fun getMagnitudeSq(): Number
    open fun invert(): Phaser.Point
    open fun isZero(): Boolean
    open fun multiply(x: Number, y: Number): Phaser.Point
    open fun normalize(): Phaser.Point
    open fun normalRightHand(): Phaser.Point
    open fun perp(): Phaser.Point
    open fun rperp(): Phaser.Point
    open fun rotate(x: Number, y: Number, angle: Number, asDegrees: Boolean? = definedExternally, distance: Number? = definedExternally): Phaser.Point
    open fun set(x: Number, y: Number): Phaser.Point
    open fun set(x: Number): Phaser.Point
    open fun setMagnitude(magnitude: Number): Phaser.Point
    open fun setTo(x: Number): Phaser.Point
    open fun setTo(x: Number, y: Number): Phaser.Point
    open fun subtract(x: Number, y: Number): Phaser.Point
    override fun toString(): String

    companion object {
        fun add(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = definedExternally): Phaser.Point
        fun subtract(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = definedExternally): Phaser.Point
        fun multiply(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = definedExternally): Phaser.Point
        fun divide(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = definedExternally): Phaser.Point
        fun equals(a: Phaser.Point, b: Phaser.Point): Boolean
        fun angle(a: Phaser.Point, b: Phaser.Point): Number
        fun angleSq(a: Phaser.Point, b: Phaser.Point): Number
        fun negative(a: Phaser.Point, out: Phaser.Point? = definedExternally): Phaser.Point
        fun multiplyAdd(a: Phaser.Point, b: Phaser.Point, scale: Number, out: Phaser.Point? = definedExternally): Phaser.Point
        fun interpolate(a: Phaser.Point, b: Phaser.Point, alpha: Number, out: Phaser.Point? = definedExternally): Phaser.Point
        fun parse(obj: Any, xProp: String? = definedExternally, yProp: String? = definedExternally): Phaser.Point
        fun perp(a: Phaser.Point, out: Phaser.Point? = definedExternally): Phaser.Point
        fun rperp(a: Phaser.Point, out: Phaser.Point? = definedExternally): Phaser.Point
        fun distance(a: Any, b: Any, round: Boolean? = definedExternally): Number
        fun project(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = definedExternally): Phaser.Point
        fun projectUnit(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = definedExternally): Phaser.Point
        fun normalRightHand(a: Phaser.Point, out: Phaser.Point? = definedExternally): Phaser.Point
        fun normalize(a: Phaser.Point, out: Phaser.Point? = definedExternally): Phaser.Point
        fun rotate(a: Phaser.Point, x: Number, y: Number, angle: Number, asDegrees: Boolean? = definedExternally, distance: Number? = definedExternally): Phaser.Point
        fun centroid(points: Array<Phaser.Point>, out: Phaser.Point? = definedExternally): Phaser.Point
    }
}


external open class Pointer(game: Phaser.Game, id: Number, pointerMode: Number? = definedExternally) {
    open var active: Boolean
    open var backButton: Phaser.DeviceButton
    open var button: Any
    open var circle: Phaser.Circle
    open var clientX: Number
    open var clientY: Number
    open var dirty: Boolean
    open var duration: Double
    open var eraserButton: Phaser.DeviceButton
    open var exists: Boolean
    open var forceOut: Boolean
    open var forwardButton: Phaser.DeviceButton
    open var game: Phaser.Game
    open var justReleasePreventsOver: dynamic /* Boolean | Number */
    open var id: Number
    open var identifier: Number
    open var interactiveCandidates: Array<Phaser.InputHandler>
    open var isDown: Boolean
    open var isMouse: Boolean
    open var isUp: Boolean
    open var leftButton: Phaser.DeviceButton
    open var middleButton: Phaser.DeviceButton
    open var movementX: Number
    open var movementY: Number
    open var msSinceLastClick: Number
    open var pageX: Number
    open var pageY: Number
    open var pointerId: Number
    open var pointerMode: Number
    open var position: Phaser.Point
    open var positionDown: Phaser.Point
    open var positionUp: Phaser.Point
    open var previousTapTime: Number
    open var rawMovementX: Number
    open var rawMovementY: Number
    open var rightButton: Phaser.DeviceButton
    open var screenX: Number
    open var screenY: Number
    open var target: Any
    open var targetObject: Any
    open var timeDown: Number
    open var timeUp: Number
    open var totalTouches: Number
    open var type: Number
    open var withinGame: Boolean
    open var worldX: Double
    open var worldY: Double
    open var x: Double
    open var y: Double
    open fun addClickTrampoline(name: String, callback: Function<Any>, callbackContext: Any, vararg callbackArgs: Any): Unit
    open fun justPressed(duration: Number? = definedExternally): Boolean
    open fun justReleased(duration: Number? = definedExternally): Boolean
    open fun leave(event: Any): Unit
    open fun move(event: Any, fromClick: Boolean? = definedExternally): Unit
    open fun reset(): Unit
    open fun resetButtons(): Unit
    open fun resetMovement(): Unit
    open fun start(event: Any): Unit
    open fun stop(event: Any): Unit
    open fun swapTarget(newTarget: Phaser.InputHandler, silent: Boolean? = definedExternally): Unit
    open fun update(): Unit
    open fun updateButtons(event: MouseEvent): Unit

    companion object {
        var NO_BUTTON: Number
        var LEFT_BUTTON: Number
        var RIGHT_BUTTON: Number
        var MIDDLE_BUTTON: Number
        var BACK_BUTTON: Number
        var FORWARD_BUTTON: Number
        var ERASER_BUTTON: Number
    }
}


external open class Polygon() {
    constructor(points: Array<Phaser.Point>) 
    constructor(points: Array<Number>) 
    constructor(vararg points: Phaser.Point) 
    constructor(vararg points: Number) 

    open var area: Number
    open var flattened: Boolean
    open var points: dynamic /* Array<Number> | Array<Phaser.Point> */
    open var type: Number
    open fun clone(output: Phaser.Polygon): Phaser.Polygon
    open fun contains(x: Number, y: Number): Boolean
    open fun flatten(): Phaser.Polygon
    open fun setTo(points: Array<Phaser.Point>): Unit
    open fun setTo(points: Array<Number>): Unit
    open fun setTo(vararg points: Phaser.Point): Unit
    open fun setTo(vararg points: Number): Unit
    open fun toNumberArray(output: Array<Number>? = definedExternally): Array<Number>
}

external interface `T$9` {
    var x: Number
    var y: Number
    var width: Number
    var height: Number
    var subWidth: Number
    var subHeight: Number
    var right: Number
    var bottom: Number
}


external open class QuadTree(x: Number, y: Number, width: Number, height: Number, maxObject: Number? = definedExternally, maxLevels: Number? = definedExternally, level: Number? = definedExternally) {
    open var bounds: `T$9`
    open var level: Number
    open var maxObjects: Number
    open var maxLevels: Number
    open var objects: Array<Any>
    open var nodes: Array<Any>
    open fun clear(): Unit
    open fun getIndex(rect: Any): Number
    open fun insert(body: Any): Unit
    open fun populate(group: Phaser.Group): Unit
    open fun populateHandler(sprite: Phaser.Sprite): Unit
    open fun reset(x: Number, y: Number, width: Number, height: Number, maxObject: Number? = definedExternally, maxLevels: Number? = definedExternally, level: Number? = definedExternally): Unit
    open fun <T> retrieve(source: T): Array<T>
    open fun split(): Unit
}


external open class RandomDataGenerator {
    constructor(seeds: Array<Any>? = definedExternally)
    constructor(seeds: String? = definedExternally)

    open fun angle(): Double
    open fun between(min: Number, max: Number): Int
    open fun frac(): Double
    open fun integer(): Int
    open fun integerInRange(min: Number, max: Number): Int
    open fun normal(): Number
    open fun <T> pick(ary: Array<T>): T
    open fun real(): Number
    open fun realInRange(min: Number, max: Number): Number
    open fun sign(): Number
    open fun sow(seeds: Array<Any>): Unit
    open fun state(state: String? = definedExternally): String
    open fun timestamp(min: Number, max: Number): Number
    open fun uuid(): String
    open fun <T> weightedPick(ary: Array<T>): T
}


external open class Rectangle(x: Number = definedExternally, y: Number = definedExternally, width: Number = definedExternally, height: Number = definedExternally) : PIXI.DisplayObject {
    open var bottom: Double
    open var bottomRight: Phaser.Point
    open var bottomLeft: Phaser.Point
    open var centerX: Double
    open var centerY: Double
    open var empty: Boolean
    open var halfHeight: Double
    open var halfWidth: Double
    open var height: Double
    open var left: Double
    open var perimeter: Number
    open var randomX: Number
    open var randomY: Number
    open var right: Double
    open var top: Double
    open var topLeft: Phaser.Point
    open var topRight: Phaser.Point
    open var type: Number
    open var volume: Number
    open var width: Double
    override var x: Double
    override var y: Double
    open fun ceil(): Unit
    open fun ceilAll(): Unit
    open fun centerOn(x: Number, y: Number): Phaser.Rectangle
    open fun clone(output: Phaser.Rectangle): Phaser.Rectangle
    open fun contains(x: Number, y: Number): Boolean
    open fun containsRect(b: Phaser.Rectangle): Boolean
    open fun copyFrom(source: Any): Phaser.Rectangle
    open fun copyTo(dest: Any): Any
    open fun equals(b: Phaser.Rectangle): Boolean
    open fun floor(): Unit
    open fun floorAll(): Unit
    open fun getPoint(position: Number): Phaser.Point
    open fun getPoint(position: Number, out: Phaser.Point): Phaser.Point
    open fun inflate(dx: Number, dy: Number): Phaser.Rectangle
    open fun intersection(b: Phaser.Rectangle, out: Phaser.Rectangle): Phaser.Rectangle
    open fun intersects(b: Phaser.Rectangle): Boolean
    open fun intersects(b: Phaser.Rectangle, tolerance: Number): Boolean
    open fun intersectsRaw(left: Number, right: Number, top: Number, bottom: Number, tolerance: Number): Boolean
    open fun offset(dx: Number, dy: Number): Phaser.Rectangle
    open fun offsetPoint(point: Phaser.Point): Phaser.Rectangle
    open fun random(out: Phaser.Point? = definedExternally): Phaser.Point
    open fun resize(width: Number, height: Number): Phaser.Rectangle
    open fun setTo(x: Number, y: Number, width: Number, height: Number): Phaser.Rectangle
    open fun scale(x: Number, y: Number? = definedExternally): Phaser.Rectangle
    open fun size(output: Phaser.Point? = definedExternally): Phaser.Point
    override fun toString(): String
    open fun union(b: Phaser.Rectangle, out: Phaser.Rectangle? = definedExternally): Phaser.Rectangle

    companion object {
        fun aabb(points: Array<Phaser.Point>, out: Phaser.Rectangle? = definedExternally): Phaser.Rectangle
        fun clone(a: Phaser.Rectangle, output: Phaser.Rectangle? = definedExternally): Phaser.Rectangle
        //fun contains(a: Phaser.Physics.P2.Body, x: Number, y: Number): Boolean
        //fun contains(a: Phaser.Physics.Ninja.Body, x: Number, y: Number): Boolean
        //fun contains(a: Phaser.Physics.Arcade.Body, x: Number, y: Number): Boolean
        //fun contains(a: dynamic, x: Number, y: Number): Boolean
        fun contains(a: Phaser.Rectangle, x: Number, y: Number): Boolean

        fun containsPoint(a: Phaser.Rectangle, point: Phaser.Point): Boolean
        fun containsRaw(rx: Number, ry: Number, rw: Number, rh: Number, x: Number, y: Number): Boolean
        fun containsRect(a: Phaser.Rectangle, b: Phaser.Rectangle): Boolean
        fun equals(a: Phaser.Rectangle, b: Phaser.Rectangle): Boolean
        fun inflate(a: Phaser.Rectangle, dx: Number, dy: Number): Phaser.Rectangle
        fun inflatePoint(a: Phaser.Rectangle, point: Phaser.Point): Phaser.Rectangle
        fun intersection(a: Phaser.Rectangle, b: Phaser.Rectangle, out: Phaser.Rectangle? = definedExternally): Phaser.Rectangle
        fun intersects(a: Phaser.Rectangle, b: Phaser.Rectangle): Boolean
        fun intersectsRaw(left: Number, right: Number, top: Number, bottom: Number, tolerance: Number): Boolean
        fun size(a: Phaser.Rectangle, output: Phaser.Point? = definedExternally): Phaser.Point
        fun union(a: Phaser.Rectangle, b: Phaser.Rectangle, out: Phaser.Rectangle? = definedExternally): Phaser.Rectangle
    }
}


external open class RenderTexture(game: Phaser.Game, width: Number? = definedExternally, height: Number? = definedExternally, key: String? = definedExternally, scaleMode: Number? = definedExternally, resolution: Number? = definedExternally) {
    open var crop: PIXI.Rectangle
    open var game: Phaser.Game
    open var key: String
    open var type: Number
    //open fun render(displayObject: PIXI.DisplayObject, matrix: Phaser.Matrix? = definedExternally, clear: Boolean? = definedExternally): Unit
    open fun renderXY(displayObject: PIXI.DisplayObject): Unit

    open fun renderXY(displayObject: PIXI.DisplayObject, x: Number, y: Number, clear: Boolean? = definedExternally): Unit
    open fun renderRawXY(displayObject: PIXI.DisplayObject, x: Number, y: Number, clear: Boolean? = definedExternally): Unit
    //From PIXI.RenderTexture
    //override var frame: Rectangle = definedExternally
    open var baseTexture: PIXI.BaseTexture = definedExternally
    //open var renderer: PixiRenderer = definedExternally
    open var resolution: Number = definedExternally

    //override var valid: Boolean = definedExternally
    open fun clear(): Unit = definedExternally

    open fun getBase64(): String = definedExternally
    open fun getCanvas(): HTMLCanvasElement = definedExternally
    open fun getImage(): HTMLImageElement = definedExternally
    open fun resize(width: Number, height: Number, updateBase: Boolean): Unit = definedExternally
    open fun render(displayObject: PIXI.DisplayObject): Unit = definedExternally
    open fun render(displayObject: PIXI.DisplayObject, matrix: PIXI.Matrix?, clear: Boolean?): Unit = definedExternally

}


external open class RequestAnimationFrame(game: Phaser.Game, forceSetTimeOut: Boolean? = definedExternally) {
    open var forceSetTimeOut: Boolean
    open var game: Phaser.Game
    open var isRunning: Boolean
    open fun isRAF(): Boolean
    open fun isSetTimeOut(): Boolean
    open fun start(): Boolean
    open fun stop(): Unit
    open fun updateRAF(rafTime: Number): Unit
    open fun updateSetTimeout(time: Number): Unit
}


external open class RetroFont(game: Phaser.Game, key: String, characterWidth: Number, characterHeight: Number, chars: String, charsPerRow: Number? = definedExternally, xSpacing: Number? = definedExternally, ySpacing: Number? = definedExternally, xOffset: Number? = definedExternally, yOffset: Number? = definedExternally) : Phaser.RenderTexture {
    open var align: String
    open var autoUpperCase: Boolean
    open var characterHeight: Number
    open var characterPerRow: Number
    open var characterSpacingX: Number
    open var characterSpacingY: Number
    open var characterWidth: Number
    open var customSpacingX: Number
    open var customSpacingY: Number
    open var fixedWidth: Number
    open var fontSet: Image
    open var frameData: Phaser.FrameData
    open var multiLine: Boolean
    open var offsetX: Number
    open var offsetY: Number
    open var smoothed: Boolean
    open var stamp: Phaser.Image
    open var text: String
    open fun buildRetroFontText(): Unit
    open fun getLongestLine(): Number
    open fun pasteLine(line: String, x: Number, y: Number, customSpacingX: Number): Unit
    open fun removeUnsupportedCharacters(stripCR: Boolean? = definedExternally): String
    open fun setFixedWidth(width: Number, lineAlignment: String? = definedExternally): Unit
    open fun setText(content: String, multiLine: Boolean? = definedExternally, characterSpacing: Number? = definedExternally, lineSpacing: Number? = definedExternally, lineAlignment: String? = definedExternally, allowLowerCase: Boolean? = definedExternally): Unit
    open fun updateOffset(x: Number? = definedExternally, y: Number? = definedExternally): Unit

    companion object {
        var ALIGN_CENTER: String
        var ALIGN_LEFT: String
        var ALIGN_RIGHT: String
        var TEXT_SET1: String
        var TEXT_SET2: String
        var TEXT_SET3: String
        var TEXT_SET4: String
        var TEXT_SET5: String
        var TEXT_SET6: String
        var TEXT_SET7: String
        var TEXT_SET8: String
        var TEXT_SET9: String
        var TEXT_SET10: String
        var TEXT_SET11: String
    }
}


external open class Rope() : PIXI.Rope {
    constructor(game: Phaser.Game, x: Number, y: Number, key: String, frame: String? = definedExternally, points: Array<Phaser.Point>? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, key: String, frame: Number? = definedExternally, points: Array<Phaser.Point>? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture, frame: String? = definedExternally, points: Array<Phaser.Point>? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture, frame: Number? = definedExternally, points: Array<Phaser.Point>? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData, frame: String? = definedExternally, points: Array<Phaser.Point>? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData, frame: Number? = definedExternally, points: Array<Phaser.Point>? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture, frame: String? = definedExternally, points: Array<Phaser.Point>? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture, frame: Number? = definedExternally, points: Array<Phaser.Point>? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.Video, frame: String? = definedExternally, points: Array<Phaser.Point>? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.Video, frame: Number? = definedExternally, points: Array<Phaser.Point>? = definedExternally) 

    open var angle: Number
    open var animations: Phaser.AnimationManager
    open var alive: Boolean
    open var autoCull: Boolean
    open var body: dynamic /* Phaser.Physics.Arcade.Body | Phaser.Physics.P2.Body | Phaser.Physics.Ninja.Body | Any */
    open var bottom: Number
    open var cameraOffset: Phaser.Point
    open var checkWorldBounds: Boolean
    open var cropRect: Phaser.Rectangle
    open var components: Any
    open var customRender: Boolean
    open var debug: Boolean
    open var deltaX: Number
    open var deltaY: Number
    open var deltaZ: Number
    open var destroyPhase: Boolean
    open var exists: Boolean
    open var events: Phaser.Events
    open var fixedToCamera: Boolean
    open var frame: dynamic /* String | Number */
    open var frameName: String
    open var fresh: Boolean
    open var game: Phaser.Game
    open var inCamera: Boolean
    open var input: Phaser.InputHandler
    open var inputEnabled: Boolean
    open var inWorld: Boolean
    open var left: Number
    open var lifespan: Number
    open var key: dynamic /* String | Phaser.RenderTexture | Phaser.BitmapData | PIXI.Texture | Phaser.Video */
    open var name: String
    open var offsetX: Number
    open var offsetY: Number
    open var outOfBoundsKill: Boolean
    open fun overlap(displayObject: Phaser.Sprite): Boolean
    open fun overlap(displayObject: Phaser.Image): Boolean
    open fun overlap(displayObject: Phaser.TileSprite): Boolean
    open fun overlap(displayObject: Phaser.Button): Boolean
    open fun overlap(displayObject: PIXI.DisplayObject): Boolean
    open var pendingDestroy: Boolean
    open var points: Array<Phaser.Point>
    override var position: Phaser.Point
    override var scale: Phaser.Point
    open var previousPosition: Phaser.Point
    open var previousRotation: Number
    open var right: Number
    open var renderOrderID: Number
    open var segments: Array<Phaser.Rectangle>
    open var smoothed: Boolean
    open var top: Number
    open var type: Number
    open var transformCallback: Function<Any>
    open var transformCallbackContext: Any
    open var scaleMin: Phaser.Point
    open var scaleMax: Phaser.Point
    open var updateAnimation: Function<Any>
    open var world: Phaser.Point
    override var x: Double
    override var y: Double
    //open var z: Number
    open fun bringToTop(): Phaser.Rope

    //open fun checkTransform(wt: PIXI.Matrix): Unit
    open fun crop(rect: Phaser.Rectangle, copy: Boolean? = definedExternally): Unit

    open fun destroy(destroyChildren: Boolean? = definedExternally): Unit
    open fun kill(): Phaser.Rope
    open fun loadTexture(key: String, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: String, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.RenderTexture, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.RenderTexture, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.BitmapData, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.BitmapData, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.Video, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.Video, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: PIXI.Texture, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: PIXI.Texture, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun moveUp(): Phaser.Rope
    open fun moveDown(): Phaser.Rope
    open fun play(name: String, frameRate: Number? = definedExternally, loop: Boolean? = definedExternally, killOnComplete: Boolean? = definedExternally): Phaser.Animation
    open fun preUpdate(): Unit
    open fun postUpdate(): Unit
    open fun reset(x: Number, y: Number, health: Number? = definedExternally): Phaser.Rope
    open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
    open fun resetFrame(): Unit
    open fun revive(health: Number? = definedExternally): Phaser.Rope
    open fun sendToBack(): Phaser.Rope
    open fun setFrame(frame: Phaser.Frame): Unit
    open fun setScaleMinMax(minX: Number? = definedExternally, minY: Number? = definedExternally, maxX: Number? = definedExternally, maxY: Number? = definedExternally): Unit
    open fun updateCrop(): Unit
    open fun update(): Unit
}


external open class RoundedRectangle : PIXI.RoundedRectangle {
    override var x: Number
    override var y: Number
    override var width: Number
    override var height: Number
    override var radius: Number
    open var type: Number
    override fun clone(): RoundedRectangle
    override fun contains(x: Number, y: Number): Boolean
}


external open class SignalBase {
    open var active: Boolean
    open var boundDispatch: Function<Any>
    open var memorize: Boolean
    //open fun add(listener: () -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
    open fun addOnce(listener: Function<Any>, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding

    open fun dispatch(vararg params: Any): Unit
    open fun dispose(): Unit
    open fun forget(): Unit
    open fun getNumListeners(): Number
    open fun halt(): Unit
    open fun has(listener: Function<Any>, context: Any? = definedExternally): Boolean
    open fun remove(listener: Function<Any>, context: Any? = definedExternally): Function<Any>
    open fun removeAll(context: Any? = definedExternally): Unit
    override fun toString(): String
    open fun validateListener(listener: Function<Any>, fnName: String): Unit
}

external open class Signal() : SignalBase {
    open fun add(listener: () -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
}

external open class SignalT : SignalBase {
    open fun <T> add(listener: (T) -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
    open fun <T, S> add(listener: (T, S) -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
}

external open class Signal1<T> : SignalBase {
    open fun add(listener: () -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
    open fun add(listener: (T) -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
}

external open class Signal2<T, S> : SignalBase {
    open fun add(listener: () -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
    open fun add(listener: (T) -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
    open fun add(listener: (T, S) -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
}

external open class Signal3<T, S, Q> : SignalBase {
    open fun add(listener: (T, S, Q) -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
}

external open class Signal4<T, S, Q, W> : SignalBase {
    open fun add(listener: (T, S, Q, W) -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
}

external open class Signal5<T, S, Q, W, E> : SignalBase {
    open fun add(listener: (T, S, Q, W, E) -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
}

external open class SignalSound : SignalBase {
    open fun add(listener: (Sound) -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
}

external open class SignalAnimationFrame : SignalBase {
    open fun add(listener: (Animation, Frame) -> Unit, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any): Phaser.SignalBinding
}


external open class SignalBinding(signal: Phaser.Signal, listener: Function<Any>, isOnce: Boolean, listenerContext: Any? = definedExternally, priority: Number? = definedExternally, vararg args: Any) {
    open var active: Boolean
    open var callCount: Number
    open var context: Any
    open var params: Array<Any>
    open fun execute(paramsArr: Array<Any>? = definedExternally): Unit
    open fun detach(): Function<Any>
    open fun isBound(): Boolean
    open fun isOnce(): Boolean
    open fun getListener(): Function<Any>
    open fun getSignal(): Phaser.Signal
    override fun toString(): String
}


external open class SinglePad(game: Phaser.Game, padParent: Any) {
    open var callbackContext: Any
    open var connected: Boolean
    open var deadZone: Number
    open var game: Phaser.Game
    open var index: Number
    open var onAxisCallback: Function<Any>
    open var onConnectCallback: Function<Any>
    open var onDisconnectCallback: Function<Any>
    open var onDownCallback: Function<Any>
    open var onFloatCallback: Function<Any>
    open var onUpCallback: Function<Any>
    open fun axis(axisCode: Number): Double
    open fun addCallbacks(context: Any, callbacks: Any): Unit
    open fun buttonValue(buttonCode: Number): Number
    open fun connect(rawPad: Any): Unit
    open fun destroy(): Unit
    open fun disconnect(): Unit
    open fun getButton(buttonCode: Number): Phaser.DeviceButton
    open fun isDown(buttonCode: Number): Boolean
    open fun isUp(buttonCode: Number): Boolean
    open fun justPressed(buttonCode: Number, duration: Number? = definedExternally): Boolean
    open fun justReleased(buttonCode: Number, duration: Number? = definedExternally): Boolean
    open fun pollStatus(): Unit
    open fun processAxisChange(axisState: Any): Unit
    open fun processButtonDown(buttonCode: Number, value: Any): Unit
    open fun processButtonFloat(buttonCode: Number, value: Any): Unit
    open fun processButtonUp(buttonCode: Number, value: Any): Unit
    open fun reset(): Unit
}


external open class Sound(game: Phaser.Game, key: String, volume: Number? = definedExternally, loop: Boolean? = definedExternally, connect: Boolean? = definedExternally) {
    open var autoplay: Boolean
    open var allowMultiple: Boolean
    open var context: Any
    open var currentMarker: String
    open var currentTime: Number
    open fun destroy(remove: Boolean? = definedExternally): Unit
    open var duration: Number
    open var durationMS: Number
    open var externalNode: Any
    open var fadeTween: Phaser.Tween
    open var game: Phaser.Game
    open var gainNode: Any
    open var isDecoded: Boolean
    open var isDecoding: Boolean
    open var isPlaying: Boolean
    open var key: String
    open var loop: Boolean
    open var markers: Any
    open var masterGainNode: Any
    open var mute: Boolean
    open var name: String
    open var onDecoded: Phaser.Signal
    open var onEndedHandler: () -> Unit
    open var onFadeComplete: Phaser.Signal1<Sound>
    open var onLoop: Phaser.Signal1<Sound>
    open var onMarkerComplete: Phaser.Signal1<Sound>
    open var onMute: Phaser.Signal1<Sound>
    open var onPause: Phaser.Signal1<Sound>
    open var onPlay: Phaser.Signal1<Sound>
    open var onResume: Phaser.Signal1<Sound>
    open var onStop: Phaser.Signal1<Sound>
    open var override: Boolean
    open var paused: Boolean
    open var pausedPosition: Number
    open var pausedTime: Number
    open var pendingPlayback: Boolean
    open var position: Double
    open var startTime: Number
    open var stopTime: Number
    open var totalDuration: Number
    open var usingAudioTag: Boolean
    open var usingWebAudio: Boolean
    open var volume: Double
    open fun addMarker(name: String, start: Number, duration: Number, volume: Number? = definedExternally, loop: Boolean? = definedExternally): Unit
    open fun destroy(): Unit
    open fun fadeIn(duration: Number? = definedExternally, loop: Boolean? = definedExternally, marker: String? = definedExternally): Unit
    open fun fadeOut(duration: Number? = definedExternally): Unit
    open fun fadeTo(duration: Number? = definedExternally, volume: Number? = definedExternally): Unit
    open fun loopFull(volume: Number? = definedExternally): Phaser.Sound
    open fun pause(): Unit
    open fun play(marker: String? = definedExternally, position: Number? = definedExternally, volume: Number? = definedExternally, loop: Boolean? = definedExternally, forceRestart: Boolean? = definedExternally): Phaser.Sound
    open fun removeMarker(name: String): Unit
    open fun restart(): Unit
    open fun restart(marker: String, position: Number, volume: Number? = definedExternally, loop: Boolean? = definedExternally): Unit
    open fun resume(): Unit
    open fun soundHasUnlocked(key: String): Unit
    open fun stop(): Unit
    open fun update(): Unit
}


external open class SoundManager(game: Phaser.Game) {
    open var channels: Number
    open var connectToMaster: Boolean
    open var context: Any
    open var game: Phaser.Game
    open var mute: Boolean
    open var muteOnPause: Boolean
    open var noAudio: Boolean
    open var onSoundDecode: Phaser.Signal
    open var onVolumeChange: Phaser.Signal
    open var onMute: Phaser.Signal
    open var onUnMute: Phaser.Signal
    open var touchLocked: Boolean
    open var usingAudioTag: Boolean
    open var usingWebAudio: Boolean
    open var volume: Number
    open fun add(key: String, volume: Number? = definedExternally, loop: Boolean? = definedExternally, connect: Boolean? = definedExternally): Phaser.Sound
    open fun addSprite(key: String): Phaser.AudioSprite
    open fun boot(): Unit
    open fun decode(key: String, sound: Phaser.Sound? = definedExternally): Unit
    open fun destroy(): Unit
    open fun pauseAll(): Unit
    open fun play(key: String, volume: Number? = definedExternally, loop: Boolean? = definedExternally): Phaser.Sound
    open fun remove(sound: Phaser.Sound): Boolean
    open fun removeByKey(key: String): Number
    open fun resumeAll(): Unit
    open fun setDecodedCallback(files: Array<String>, callback: Function<Any>, callbackContext: Any): Unit
    open fun setDecodedCallback(files: Array<Phaser.Sound>, callback: Function<Any>, callbackContext: Any): Unit
    open fun setTouchLock(): Unit
    open fun stopAll(): Unit
    open fun unlock(): Boolean
    open fun update(): Unit
}


external open class Sprite(game: Phaser.Game, x: Number, y: Number, key: Any? = definedExternally, frame: Any? = definedExternally) : PIXI.Sprite {
    /*constructor(game: Phaser.Game, x: Number, y: Number, key: String? = definedExternally, frame: String? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: String? = definedExternally, frame: Number? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture? = definedExternally, frame: String? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture? = definedExternally, frame: Number? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData? = definedExternally, frame: String? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData? = definedExternally, frame: Number? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture? = definedExternally, frame: String? = definedExternally)
    constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture? = definedExternally, frame: Number? = definedExternally)*/
    open var alive: Boolean
    open var anchor: Phaser.Point
    open var angle: Double
    open var animations: Phaser.AnimationManager
    open var autoCull: Boolean
    //open var body:Phaser.Physics.Arcade.Body /*Phaser.Physics.Arcade.Body | Phaser.Physics.P2.Body | Phaser.Physics.Ninja.Body | Any*/
    open var body: dynamic /*Phaser.Physics.Arcade.Body | Phaser.Physics.P2.Body | Phaser.Physics.Ninja.Body | Any*/
    open var bottom: Number
    open var cameraOffset: Phaser.Point
    open var centerX: Number
    open var centerY: Number
    open var checkWorldBounds: Boolean
    open var components: Any
    open var cropRect: Phaser.Rectangle
    open var customRender: Boolean
    open var data: dynamic
    open var debug: Boolean
    open var deltaX: Number
    open var deltaY: Number
    open var deltaZ: Number
    open var destroyPhase: Boolean
    open var events: Phaser.Events
    override var exists: Boolean
    open var fixedToCamera: Boolean
    open var frame: dynamic /* String | Number */
    //open var frame: Int /* String | Number */
    open var frameName: String
    open var fresh: Boolean
    open var game: Phaser.Game
    open var health: Number
    open var inCamera: Boolean
    open var input: Phaser.InputHandler
    open var inputEnabled: Boolean
    open var inWorld: Boolean
    open var key: dynamic /* String | Phaser.RenderTexture | Phaser.BitmapData | Phaser.Video | PIXI.Texture */
    open var left: Number
    open var lifespan: Number
    open var maxHealth: Number
    open var name: String
    open var offsetX: Number
    open var offsetY: Number
    open var outOfBoundsKill: Boolean
    open var pendingDestroy: Boolean
    open var previousPosition: Phaser.Point
    open var previousRotation: Number
    override var position: Phaser.Point
    open var physicsEnabled: Boolean
    open var physicsType: Number
    open var renderOrderID: Number
    open var right: Number
    override var scale: Phaser.Point
    open var scaleMin: Phaser.Point
    open var scaleMax: Phaser.Point
    open var smoothed: Boolean
    open var top: Number
    open var type: Number
    open var tintedTexture: HTMLCanvasElement
    open var transformCallback: Function<Any>
    open var transformCallbackContext: Any
    open var world: Phaser.Point
    override var x: Double
    override var y: Double
    //open var z: Number
    //open fun alignIn(container: Phaser.Rectangle): Any
    //open fun alignIn(container: Phaser.Rectangle, position: Number): Any
    //open fun alignIn(container: Phaser.Rectangle, position: Number?, offsetX: Number?, offsetY: Number?): Any

    //open fun alignIn(container: Phaser.Sprite, position: Number): Any
    //open fun alignIn(container: Phaser.Sprite, position: Number, offsetX: Number): Any
    fun alignIn(container: PIXI.DisplayObject, position: Number?): Any

    fun alignIn(container: PIXI.DisplayObject, position: Number?, offsetX: Number?): Any
    fun alignIn(container: PIXI.DisplayObject, position: Number?, offsetX: Number?, offsetY: Number?): Any

    /*open fun alignIn(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    */
    //open fun alignTo(container: Phaser.Rectangle, position: Number?): Any
    //open fun alignTo(container: Phaser.Rectangle, position: Number?, offsetX: Number?): Any
    //open fun alignTo(container: Phaser.Rectangle, position: Number?, offsetX: Number?, offsetY: Number?): Any
    //open fun alignTo(container: PIXI.DisplayObject, position: Number?): Sprite
    //open fun alignTo(container: PIXI.DisplayObject, position: Number?, offsetX: Number?): Sprite
    //open fun alignTo(container: PIXI.DisplayObject, position: Number?, offsetX: Number?, offsetY: Number?): Sprite

    /*open fun alignTo(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    */
    open fun bringToTop(): Phaser.Sprite

    @JsName("crop")
    //open fun crop(rect: Phaser.Rectangle)
    open fun cropJs(rect: Phaser.Rectangle, copy: Boolean?)

    //open fun checkTransform(wt: PIXI.Matrix): Unit
    open fun damage(amount: Number): Phaser.Sprite

    @JsName("destroy")
    //open fun destroy()
    //open fun destroy(destroyChildren: Boolean?)
    open fun destroyJs(destroyChildren: Boolean?, unknown: Boolean?)

    open fun drawPolygon(): Unit
    open fun heal(amount: Number): Phaser.Sprite
    open fun kill(): Phaser.Sprite
    fun loadTexture(key: String): Unit
    fun loadTexture(key: String, frame: Number): Unit
    fun loadTexture(key: String, frame: Number, stopAnimation: Boolean?): Unit
    /*open fun loadTexture(key: String, frame: String?, stopAnimation: Boolean?): Unit
    open fun loadTexture(key: String, frame: Number?, stopAnimation: Boolean?): Unit
    open fun loadTexture(key: Phaser.RenderTexture, frame: String?, stopAnimation: Boolean?): Unit
    open fun loadTexture(key: Phaser.RenderTexture, frame: Number?, stopAnimation: Boolean?): Unit
    open fun loadTexture(key: Phaser.BitmapData, frame: String?, stopAnimation: Boolean?): Unit
    open fun loadTexture(key: Phaser.BitmapData, frame: Number?, stopAnimation: Boolean?): Unit
    open fun loadTexture(key: Phaser.Video, frame: String?, stopAnimation: Boolean?): Unit
    open fun loadTexture(key: Phaser.Video, frame: Number?, stopAnimation: Boolean?): Unit
    open fun loadTexture(key: PIXI.Texture, frame: String?, stopAnimation: Boolean?): Unit
    open fun loadTexture(key: PIXI.Texture, frame: Number?, stopAnimation: Boolean?): Unit
    */
    open fun moveUp(): Phaser.Sprite

    open fun moveDown(): Phaser.Sprite
    open fun overlap(displayObject: PIXI.DisplayObject): Boolean
    /*open fun overlap(displayObject: Phaser.Sprite): Boolean
    open fun overlap(displayObject: Phaser.Image): Boolean
    open fun overlap(displayObject: Phaser.TileSprite): Boolean
    open fun overlap(displayObject: Phaser.Button): Boolean
    open fun overlap(displayObject: PIXI.DisplayObject): Boolean*/
    fun play(name: String): Phaser.Animation

    fun play(name: String, frameRate: Number?): Phaser.Animation
    fun play(name: String, frameRate: Number?, loop: Boolean?): Phaser.Animation
    fun play(name: String, frameRate: Number?, loop: Boolean?, killOnComplete: Boolean?): Phaser.Animation
    open fun postUpdate(): Unit
    open fun preUpdate(): Unit
    //open fun reset(x: Number, y: Number): Phaser.Sprite
    @JsName("reset")
    open fun resetJs(x: Number?, y: Number?, health: Number?): Phaser.Sprite

    open fun resetFrame(): Unit
    open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
    @JsName("revive")
    open fun reviveJs(health: Number?): Phaser.Sprite

    open fun sendToBack(): Phaser.Sprite
    open fun setFrame(frame: Phaser.Frame): Unit
    //open fun setScaleMinMax(minX: Number?, minY: Number?): Unit
    @JsName("setScaleMinMax")
    open fun setScaleMinMaxJs(minX: Number?, minY: Number?, maxX: Number?, maxY: Number?): Unit

    open fun update(): Unit
    open fun updateCrop(): Unit
}


external open class SpriteBatch(game: Phaser.Game, parent: PIXI.DisplayObjectContainer, name: String? = definedExternally, addedToStage: Boolean? = definedExternally) : Phaser.Group {
    override var type: Number
}


external open class Stage(game: Phaser.Game) : PIXI.DisplayObjectContainer {
    open var game: Phaser.Game
    open var name: String
    open var disableVisibilityChange: Boolean
    open var exists: Boolean
    open var currentRenderOrderID: Number
    open var backgroundColor: Any
    open var smoothed: Boolean
    open fun parseConfig(config: Any): Unit
    open fun preUpdate(): Unit
    open fun update(): Unit
    open fun postUpdate(): Unit
    open fun updateTransform(): Unit
    open fun checkVisibility(): Unit
    open fun visibilityChange(event: Event): Unit
    open fun setBackgroundColor(backgroundColor: Number): Unit
    open fun setBackgroundColor(backgroundColor: String): Unit
    open fun destroy(): Unit
}

external interface ResizeCallback {
    //@nativeInvoke
    fun invoke(scale: ScaleManager, parentBounds: Rectangle): Any
}

external interface `T$10` {
    var canExpandParent: Boolean
    var clickTrampoline: String
    var forceMinimumDocumentHeight: Boolean
    var noMargins: Boolean
    var orientationFallback: Boolean
    var scrollTo: Point
    var supportsFullScreen: Boolean
}

external interface `T$11` {
    var left: Number
    var top: Number
    var right: Number
    var bottom: Number
    var x: Number
    var y: Number
}

external interface `T$12` {
    var bottom: String
    var right: String
}


external open class ScaleManager {
    constructor(game: Phaser.Game, width: Number, height: Number)
    constructor(game: Phaser.Game, width: Number, height: String)
    constructor(game: Phaser.Game, width: String, height: Number)
    constructor(game: Phaser.Game, width: String, height: String)

    open var aspectRatio: Number
    open var bounds: Rectangle
    open var boundingParent: HTMLElement
    open var compatibility: `T$10`
    open var currentScaleMode: Number
    open var dom: Phaser.DOM
    open var enterIncorrectOrientation: Signal
    open var event: Any
    open var forceLandscape: Boolean
    open var forcePortrait: Boolean
    open var fullScreenScaleMode: Number
    open var fullScreenTarget: HTMLElement
    open var game: Phaser.Game
    open var grid: Phaser.FlexGrid
    open var hasPhaserSetFullScreen: Boolean
    open var height: Number
    open var incorrectOrientation: Boolean
    open var isFullScreen: Boolean
    open var isGameLandscape: Boolean
    open var isGamePortrait: Boolean
    open var isPortrait: Boolean
    open var isLandscape: Boolean
    open var leaveIncorrectOrientation: Signal
    open var margin: `T$11`
    open var maxHeight: Number
    open var maxWidth: Number
    open var minHeight: Number
    open var minWidth: Number
    open var offset: Point
    open var onFullScreenInit: Phaser.Signal
    open var onFullScreenChange: Phaser.Signal1<ScaleManager>
    open var onFullScreenError: Phaser.Signal
    open var onOrientationChange: Phaser.Signal
    open var onSizeChange: Signal
    open var pageAlignHorizontally: Boolean
    open var pageAlignVertically: Boolean
    open var parentNode: HTMLElement
    open var parentIsWindow: Boolean
    open var parentScaleFactor: Point
    open var scaleFactor: Point
    open var scaleFactorInversed: Point
    open var scaleMode: Number
    open var screenOrientation: String
    open var sourceAspectRatio: Number
    open var trackParentInterval: Number
    open var width: Number
    open var windowConstraints: `T$12`
    open fun boot(): Unit
    open fun createFullScreenTarget(): HTMLDivElement
    open fun destroy(): Unit
    open fun forceOrientation(forceLandscape: Boolean, forcePortrait: Boolean? = definedExternally): Unit
    open fun getParentBounds(target: Rectangle? = definedExternally): Rectangle
    open fun parseConfig(config: Any): Unit
    open fun preUpdate(): Unit
    open fun pauseUpdate(): Unit
    open fun refresh(): Unit
    open fun setGameSize(width: Number, height: Number): Unit
    open fun setResizeCallback(callback: ResizeCallback, context: Any): Unit
    open fun setUserScale(hScale: Number, vScale: Number, hTrim: Number? = definedExternally, vTrim: Number? = definedExternally): Unit
    open fun setMinMax(minWidth: Number, minHeight: Number, maxWidth: Number? = definedExternally, maxHeight: Number? = definedExternally): Unit
    open fun setupScale(width: Number, height: Number): Unit
    open fun setupScale(width: String, height: String): Unit
    open fun scaleSprite(sprite: Sprite, width: Number? = definedExternally, height: Number? = definedExternally, letterBox: Boolean? = definedExternally): Sprite
    open fun scaleSprite(sprite: Image, width: Number? = definedExternally, height: Number? = definedExternally, letterBox: Boolean? = definedExternally): Sprite
    open fun startFullScreen(antialias: Boolean? = definedExternally, allowTrampoline: Boolean? = definedExternally): Boolean
    open fun stopFullScreen(): Boolean

    companion object {
        var EXACT_FIT: Number
        var NO_SCALE: Number
        var SHOW_ALL: Number
        var RESIZE: Number
        var USER_SCALE: Number
    }
}


external open class DOM {
    companion object {
        var visualBounds: Phaser.Rectangle
        var layoutBounds: Phaser.Rectangle
        var documentBounds: Phaser.Rectangle
        fun calibrate(coords: Any, cushion: Number? = definedExternally): Any
        fun getAspectRatio(`object`: Any): Number
        fun getScreenOrientation(primaryFallback: String? = definedExternally): String
        fun getBounds(element: Any, cushion: Number? = definedExternally): Any
        fun getOffset(element: Any, point: Point? = definedExternally): Point
        fun inLayoutViewport(element: Any, cushion: Number? = definedExternally): Boolean
    }
}


external open class State {
    open var add: Phaser.GameObjectFactory
    open var cache: Phaser.Cache
    open var camera: Phaser.Camera
    open var game: Phaser.Game
    open var input: Phaser.Input
    open var key: String
    open var load: Phaser.Loader
    open var make: Phaser.GameObjectCreator
    open var particles: Phaser.Particles
    open var physics: Phaser.Physics
    open var rnd: Phaser.RandomDataGenerator
    open var scale: Phaser.ScaleManager
    open var sound: Phaser.SoundManager
    open var stage: Phaser.Stage
    open var state: Phaser.StateManager
    open var time: Phaser.Time
    open var tweens: Phaser.TweenManager
    open var world: Phaser.World
    open fun create(): Unit
    open fun init(vararg args: Any): Unit
    open fun loadRender(): Unit
    open fun loadUpdate(): Unit
    open fun paused(): Unit
    open fun pauseUpdate(): Unit
    open fun preload(): Unit
    open fun preRender(): Unit
    open fun render(): Unit
    open fun resize(): Unit
    open fun resumed(): Unit
    open fun shutdown(): Unit
    open fun update(): Unit
}

//
external interface IStateCycle {
    fun preUpdate()
    fun update()
    fun render()
    fun postRender()
    fun destroy()
}


external open class StateManager(game: Phaser.Game, pendingState: Phaser.State? = definedExternally) {
    open var created: Boolean
    open var current: String
    open var game: Phaser.Game
    open var onCreateCallback: Function<Any>
    open var onInitCallback: Function<Any>
    open var onLoadRenderCallback: Function<Any>
    open var onLoadUpdateCallback: Function<Any>
    open var onPausedCallback: Function<Any>
    open var onPauseUpdateCallback: Function<Any>
    open var onPreloadCallback: Function<Any>
    open var onPreRenderCallback: Function<Any>
    open var onRenderCallback: Function<Any>
    open var onResumedCallback: Function<Any>
    open var onResizeCallback: Function<Any>
    open var onShutDownCallback: Function<Any>
    open var onUpdateCallback: Function<Any>
    open var states: Any
    open var onStateChange: Phaser.Signal
    open fun add(key: String, state: Any, autoStart: Boolean? = definedExternally): Unit
    open fun checkState(key: String): Boolean
    open fun clearCurrentState(): Unit
    open fun destroy(): Unit
    open fun getCurrentState(): Phaser.State
    open fun link(key: String): Unit
    open fun loadComplete(): Unit
    open fun preRender(elapsedTime: Number): Unit
    open fun preUpdate(): Unit
    open fun render(): Unit
    open fun remove(key: String): Unit
    open fun resume(): Unit
    open fun restart(clearWorld: Boolean? = definedExternally, clearCache: Boolean? = definedExternally, vararg args: Any): Unit
    open fun resize(width: Number, height: Number): Unit
    open fun start(key: String, clearWorld: Boolean? = definedExternally, clearCache: Boolean? = definedExternally, vararg args: Any): Unit
    open fun update(): Unit
    open fun unlink(key: String): Unit
}

external interface PhaserTextStyle {
    var font: String?
    var fill: Any?
    var align: String?
    var stroke: String?
    var strokeThickness: Number?
    var wordWrap: Boolean?
    var wordWrapWidth: Number?
    var maxLines: Number?
    var shadowOffsetX: Number?
    var shadowOffsetY: Number?
    var shadowColor: String?
    var shadowBlur: Number?
    var valign: String?
    var tab: Number?
    var tabs: Number?
    var fontSize: Number?
    var fontStyle: String?
    var fontVariant: String?
    var fontWeight: dynamic /* String | Number */
    var backgroundColor: String?
    var boundsAlignH: String?
    var boundsAlignV: String?
}


external open class Text(game: Phaser.Game, x: Number, y: Number, text: String, style: PhaserTextStyle? = definedExternally) : Phaser.Sprite {
    open var align: String
    override var angle: Double
    open var autoRound: Boolean
    open var boundsAlignH: String
    open var boundsAlignV: String
    override var cameraOffset: Phaser.Point
    open var canvas: HTMLCanvasElement
    open var colors: Array<String>
    open var context: CanvasRenderingContext2D
    open var cssFont: String
    override var destroyPhase: Boolean
    override var events: Phaser.Events
    override var exists: Boolean
    open var fill: Any
    override var fixedToCamera: Boolean
    open var font: String
    open var fontSize: dynamic /* Number | String */
    open var fontStyle: String
    open var fontStyles: Array<String>
    open var fontVariant: String
    open var fontWeight: dynamic /* String | Number */
    open var fontWeights: Array<dynamic /* String | Number */>
    override var game: Phaser.Game
    override var input: Phaser.InputHandler
    override var inputEnabled: Boolean
    open var lineSpacing: Number
    override var name: String
    open var padding: Phaser.Point
    override var pendingDestroy: Boolean
    override var physicsType: Number
    override var position: Phaser.Point
    override var previousPosition: Phaser.Point
    override var previousRotation: Number
    override var renderOrderID: Number
    open var resolution: Number
    open var shadowBlur: Number
    open var shadowColor: String
    open var shadowFill: Boolean
    open var shadowOffsetX: Number
    open var shadowOffsetY: Number
    open var shadowStroke: Boolean
    open var splitRegExp: Any
    open var stroke: String
    open var strokeColors: Array<String>
    open var strokeThickness: Number
    override var scale: Phaser.Point
    open var tab: Number
    open var tabs: dynamic /* Number | Array<Number> */
    open var style: TextStyle /* Number | Array<Number> */
    open var text: String
    open var textBounds: Phaser.Rectangle
    override var type: Number
    open var useAdvancedWrap: Boolean
    override var world: Phaser.Point
    open var wordWrap: Boolean
    open var wordWrapWidth: Number
    //override var z: Number
    open fun addColor(color: String, position: Number): Phaser.Text

    open fun addFontStyle(style: String, position: Number): Phaser.Text
    open fun addFontWeight(weight: String, position: Number): Phaser.Text
    open fun addStrokeColor(color: String, position: Number): Phaser.Text
    //override fun alignIn(container: Phaser.Rectangle, position: Number?, offsetX: Number?, offsetY: Number?): Any
    /*override fun alignIn(container: Phaser.Rectangle, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignIn(container: Phaser.Sprite, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignIn(container: Phaser.Image, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignIn(container: Phaser.Text, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignIn(container: Phaser.BitmapText, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignIn(container: Phaser.Button, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignIn(container: Phaser.Graphics, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignIn(container: Phaser.TileSprite, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignTo(container: Phaser.Rectangle, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignTo(container: Phaser.Sprite, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignTo(container: Phaser.Image, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignTo(container: Phaser.Text, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignTo(container: Phaser.BitmapText, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignTo(container: Phaser.Button, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignTo(container: Phaser.Graphics, position: Number?, offsetX: Number?, offsetY: Number?): Any
    override fun alignTo(container: Phaser.TileSprite, position: Number?, offsetX: Number?, offsetY: Number?): Any
    */open fun clearColors(): Phaser.Text

    open fun clearFontValues(): Phaser.Text
    open fun componentsToFont(components: Any): String
    //override fun destroy(destroyChildren: Boolean?): Unit
    open fun fontToComponents(font: String): Any

    override fun postUpdate(): Unit
    open fun parseList(list: Array<String>): Phaser.Text
    open fun parseList(list: Array<Array<String>>): Phaser.Text
    open fun precalculateWordWrap(text: String): Array<String>
    override fun preUpdate(): Unit
    open fun renderTabLine(line: String, x: Number, y: Number, fill: Boolean? = definedExternally): Unit
    open fun setShadow(x: Number? = definedExternally, y: Number? = definedExternally, color: Any? = definedExternally, blur: Number? = definedExternally, shadowStroke: Boolean? = definedExternally, shadowFill: Boolean? = definedExternally): Phaser.Text
    open fun setStyle(style: PhaserTextStyle? = definedExternally, update: Boolean? = definedExternally): Phaser.Text
    open fun setText(text: String, immediate: Boolean? = definedExternally): Phaser.Text
    open fun setTextBounds(x: Number? = definedExternally, y: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally): Phaser.Text
    override fun update(): Unit
    open fun updateFont(components: Any): Unit
    open fun updateLine(text: String, x: Number? = definedExternally, y: Number? = definedExternally): Unit
    open fun updateShadow(state: Boolean? = definedExternally): Unit
    open fun updateTexture(): Unit

    companion object {
        var fontPropertiesCanvas: Any
        var fontPropertiesContext: Any
        var fontPropertiesCache: Any
    }
}


external open class Tile(layer: Any, index: Number, x: Number, y: Number, width: Number, height: Number) {
    open var debug: Boolean
    open var alpha: Double
    open var bottom: Double
    open var callback: Function<Any>
    open var callbackContext: Any
    open var centerX: Double
    open var centerY: Double
    open var canCollide: Boolean
    open var collideDown: Boolean
    open var collideLeft: Boolean
    open var collideNone: Boolean
    open var collideRight: Boolean
    open var collisionCallback: Function<Any>
    open var collisionCallbackContext: Any
    open var collides: Boolean
    open var collideUp: Boolean
    open var faceBottom: Boolean
    open var faceLeft: Boolean
    open var faceRight: Boolean
    open var faceTop: Boolean
    open var game: Phaser.Game
    open var height: Double
    open var index: Int
    open var layer: Double
    open var left: Double
    open var properties: dynamic
    open var right: Double
    open var scanned: Boolean
    open var top: Double
    open var width: Double
    open var worldX: Double
    open var worldY: Double
    open var x: Double
    open var y: Double
    open fun copy(tile: Phaser.Tile): Phaser.Tile
    open fun containsPoint(x: Number, y: Number): Boolean
    open fun destroy(): Unit
    open fun intersects(x: Number, y: Number, right: Number, bottom: Number): Boolean
    open fun isInterested(collides: Boolean, faces: Boolean): Boolean
    open fun resetCollision(): Unit
    open fun setCollision(left: Boolean, right: Boolean, up: Boolean, down: Boolean): Unit
    open fun setCollisionCallback(callback: Function<Any>, context: Any): Unit
}


external open class Tilemap(game: Phaser.Game, key: String? = definedExternally, tileWidth: Number? = definedExternally, tileHeight: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally) {
    open var collision: Array<Any>
    open var collideIndexes: Array<Any>
    open var currentLayer: Number
    open var debugMap: Array<Any>
    open var enableDebug: Boolean
    open var format: Number
    open var game: Phaser.Game
    open var height: Number
    open var heightInPixels: Number
    open var images: Array<Any>
    open var imagecollections: Array<ImageCollection>
    open var key: String
    open var layer: Array<Phaser.TilemapLayer>
    open var layers: Array<Any>
    open var objects: Array<Any>
    open var orientation: String
    open var properties: Any
    open var rayStepRate: Number
    open var tileHeight: Number
    open var tiles: Array<Phaser.Tile>
    open var tilesets: Array<Phaser.Tileset>
    open var tileWidth: Number
    open var version: Number
    open var width: Number
    open var widthInPixels: Number
    open fun addTilesetImage(tileset: String): Phaser.Tileset
    open fun addTilesetImage(tileset: String, key: String?, tileWidth: Number? = definedExternally, tileHeight: Number? = definedExternally, tileMargin: Number? = definedExternally, tileSpacing: Number? = definedExternally, gid: Number? = definedExternally): Phaser.Tileset
    open fun addTilesetImage(tileset: String, key: Phaser.BitmapData?, tileWidth: Number? = definedExternally, tileHeight: Number? = definedExternally, tileMargin: Number? = definedExternally, tileSpacing: Number? = definedExternally, gid: Number? = definedExternally): Phaser.Tileset
    open fun calculateFaces(layer: Number): Unit
    open fun copy(x: Number, y: Number, width: Number, height: Number, layer: Any? = definedExternally): Array<Phaser.Tile>
    open fun create(name: String, width: Number, height: Number, tileWidth: Number, tileHeight: Number, group: Phaser.Group? = definedExternally): Phaser.TilemapLayer
    open fun createBlankLayer(name: String, width: Number, height: Number, tileWidth: Number, tileHeight: Number, group: Phaser.Group? = definedExternally): Phaser.TilemapLayer
    open fun createFromObjects(name: String, gid: Number, key: String, frame: Any? = definedExternally, exists: Boolean? = definedExternally, autoCull: Boolean? = definedExternally, group: Phaser.Group? = definedExternally, CustomClass: Any? = definedExternally, adjustY: Boolean? = definedExternally): Unit
    open fun createFromTiles(tiles: Any, replacements: Any, key: String, layer: Any? = definedExternally, group: Phaser.Group? = definedExternally, properties: Any? = definedExternally): Number
    open fun createLayer(layer: Any, width: Number? = definedExternally, height: Number? = definedExternally, group: Phaser.Group? = definedExternally): Phaser.TilemapLayer
    open fun destroy(): Unit
    open fun dump(): Unit
    open fun fill(index: Number, x: Number, y: Number, width: Number, height: Number, layer: Any? = definedExternally): Unit
    open fun forEach(callback: Function<Any>, context: Any, x: Number, y: Number, width: Number, height: Number, layer: Any? = definedExternally): Unit
    open fun getImageIndex(name: String): Number
    open fun getIndex(location: Array<Any>, name: String): Number
    open fun getLayer(layer: Any): Number
    open fun getLayerIndex(name: String): Number
    open fun getObjectIndex(name: String): Number
    open fun getTile(x: Number, y: Number, layer: Any? = definedExternally, nonNull: Boolean? = definedExternally): Phaser.Tile?
    open fun getTileAbove(layer: Number, x: Number, y: Number): Phaser.Tile
    open fun getTileBelow(layer: Number, x: Number, y: Number): Phaser.Tile
    open fun getTileLeft(layer: Number, x: Number, y: Number): Phaser.Tile
    open fun getTileRight(layer: Number, x: Number, y: Number): Phaser.Tile
    open fun getTilesetIndex(name: String): Number
    open fun getTileWorldXY(x: Number, y: Number, tileWidth: Number? = definedExternally, tileHeight: Number? = definedExternally, layer: Number? = definedExternally, nonNull: Boolean? = definedExternally): Phaser.Tile
    open fun getTileWorldXY(x: Number, y: Number, tileWidth: Number? = definedExternally, tileHeight: Number? = definedExternally, layer: String? = definedExternally, nonNull: Boolean? = definedExternally): Phaser.Tile
    open fun getTileWorldXY(x: Number, y: Number, tileWidth: Number? = definedExternally, tileHeight: Number? = definedExternally, layer: Phaser.TilemapLayer? = definedExternally, nonNull: Boolean? = definedExternally): Phaser.Tile
    open fun hasTile(x: Number, y: Number, layer: Phaser.TilemapLayer): Boolean
    open fun paste(x: Number, y: Number, tileblock: Array<Phaser.Tile>, layer: Any? = definedExternally): Unit
    open fun putTile(tile: Any, x: Number, y: Number, layer: Any? = definedExternally): Phaser.Tile
    open fun putTileWorldXY(tile: Any, x: Number, y: Number, tileWidth: Number, tileHeight: Number, layer: Any? = definedExternally): Unit
    open fun random(x: Number, y: Number, width: Number, height: Number, layer: Any? = definedExternally): Unit
    open fun removeAllLayers(): Unit
    open fun removeTile(x: Number, y: Number, layer: Any? = definedExternally): Phaser.Tile
    open fun removeTileWorldXY(x: Number, y: Number, tileWidth: Number, tileHeight: Number, layer: Any? = definedExternally): Phaser.Tile
    open fun replace(source: Number, dest: Number): Unit
    open fun replace(source: Number, dest: Number, x: Number, y: Number, width: Number, height: Number, layer: Any? = definedExternally): Unit
    open fun searchTileIndex(index: Number, skip: Number? = definedExternally, reverse: Boolean? = definedExternally, layer: Any? = definedExternally): Phaser.Tile
    open fun setCollision(indexes: Any, collides: Boolean? = definedExternally, layer: Any? = definedExternally, recalculate: Boolean? = definedExternally): Unit
    open fun setCollisionBetween(start: Number, stop: Number, collides: Boolean? = definedExternally, layer: Any? = definedExternally, recalculate: Boolean? = definedExternally): Unit
    open fun setCollisionByExclusion(indexes: Array<Any>, collides: Boolean? = definedExternally, layer: Any? = definedExternally, recalculate: Boolean? = definedExternally): Unit
    open fun setCollisionByIndex(index: Number, collides: Boolean? = definedExternally, layer: Number? = definedExternally, recalculate: Boolean? = definedExternally): Unit
    open fun setLayer(layer: Any): Unit
    open fun setPreventRecalculate(value: Boolean): Unit
    open fun setTileIndexCallback(indexes: Any, callback: Function<Any>, callbackContext: Any, layer: Any? = definedExternally): Unit
    open fun setTileLocationCallback(x: Number, y: Number, width: Number, height: Number, callback: Function<Any>, callbackContext: Any, layer: Any? = definedExternally): Unit
    open fun setTileSize(tileWidth: Number, tileHeight: Number): Unit
    open fun shuffle(x: Number, y: Number, width: Number, height: Number): Unit
    open fun shuffle(x: Number, y: Number, width: Number, height: Number, layer: Any): Unit
    open fun swap(tileA: Number, tileB: Number): Unit
    open fun swap(tileA: Number, tileB: Number, x: Number, y: Number, width: Number, height: Number, layer: Any? = definedExternally): Unit

    companion object {
        var CSV: Number
        var TILED_JSON: Number
        var NORTH: Number
        var EAST: Number
        var SOUTH: Number
        var WEST: Number
    }
}

external interface `T$13` {
    var missingImageFill: String
    var debuggedTileOverfill: String
    var forceFullRedraw: Boolean
    var debugAlpha: Number
    var facingEdgeStroke: String
    var collidingTileOverfill: String
}

external interface `T$14` {
    var enableScrollDelta: Boolean
    var overdrawRatio: Number
    var copyCanvas: Any
}


external open class TilemapLayer(game: Phaser.Game, tilemap: Phaser.Tilemap, index: Number, width: Number? = definedExternally, height: Number? = definedExternally) : Phaser.Sprite {
    override var cameraOffset: Phaser.Point
    open var canvas: HTMLCanvasElement
    open var collisionHeight: Number
    open var collisionWidth: Number
    open var context: CanvasRenderingContext2D
    override var data: Any
    override var debug: Boolean
    open var debugAlpha: Number
    open var debugCallbackColor: String
    open var debugColor: String
    open var debugSettings: `T$13`
    open var dirty: Boolean
    override var exists: Boolean
    override var fixedToCamera: Boolean
    override var game: Phaser.Game
    open var index: Number
    open var layer: Phaser.TilemapLayer
    open var map: Phaser.Tilemap
    override var name: String
    override var physicsType: Number
    open var renderSettings: `T$14`
    open var scrollFactorX: Number
    open var scrollFactorY: Number
    open var scrollX: Number
    open var scrollY: Number
    override var type: Number
    open var wrap: Boolean
    //override open fun destroy()
    open fun getRayCastTiles(line: Phaser.Line, stepRate: Number? = definedExternally, collides: Boolean? = definedExternally, interestingFace: Boolean?): Array<Phaser.Tile>

    open fun getRayCastTiles(layer: Phaser.TilemapLayer, line: Phaser.Line, stepRate: Number? = definedExternally, collides: Boolean? = definedExternally, interestingFace: Boolean?): Array<Phaser.Tile>
    open fun getRayCastTiles(layer: Phaser.TilemapLayerGL, line: Phaser.Line, stepRate: Number? = definedExternally, collides: Boolean? = definedExternally, interestingFace: Boolean?): Array<Phaser.Tile>
    open fun getTiles(layer: Phaser.TilemapLayer, x: Number, y: Number, width: Number, height: Number, collides: Boolean? = definedExternally, interestingFace: Boolean? = definedExternally): Array<Phaser.Tile>
    open fun getTiles(layer: Phaser.TilemapLayerGL, x: Number, y: Number, width: Number, height: Number, collides: Boolean? = definedExternally, interestingFace: Boolean? = definedExternally): Array<Phaser.Tile>
    open fun getTileX(layer: Phaser.TilemapLayer, x: Number): Double
    open fun getTileX(layer: Phaser.TilemapLayerGL, x: Number): Double
    open fun getTileX(x: Number): Double
    open fun getTileXY(layer: Phaser.TilemapLayer, x: Number, y: Number, point: Phaser.Point): Phaser.Point
    open fun getTileXY(layer: Phaser.TilemapLayerGL, x: Number, y: Number, point: Phaser.Point): Phaser.Point
    open fun getTileY(y: Number): Double
    open fun getTileY(layer: Phaser.TilemapLayer, y: Number): Double
    open fun getTileY(layer: Phaser.TilemapLayerGL, y: Number): Double
    override fun postUpdate(): Unit
    open fun render(): Unit
    open fun resize(width: Number, height: Number): Unit
    open fun resizeWorld(): Unit
    open fun resetTilesetCache(): Unit
    open fun setScale(xScale: Number? = definedExternally, yScale: Number? = definedExternally): Unit
    open fun updateMax(): Unit
}


external open class TilemapLayerGL(game: Phaser.Game, tilemap: Phaser.Tilemap, index: Number, width: Number? = definedExternally, height: Number? = definedExternally, tileset: Phaser.Tileset? = definedExternally) {
    open var collisionHeight: Number
    open var collisionWidth: Number
    open var data: Any
    open var dirty: Boolean
    open var exists: Boolean
    open var fixedToCamera: Boolean
    open var game: Phaser.Game
    open var index: Number
    open var layer: Phaser.TilemapLayer
    open var map: Phaser.Tilemap
    open var name: String
    open var physicsType: Number
    open var scrollFactorX: Number
    open var scrollFactorY: Number
    open var scrollX: Number
    open var scrollY: Number
    open var type: Number
    open var wrap: Boolean
    open var x: Number
    open var y: Number
    open var width: Number
    open var height: Number
    open fun destroy(): Unit
    open fun postUpdate(): Unit
    open fun render(): Unit
    open fun resize(width: Number, height: Number): Unit
    open fun resizeWorld(): Unit
    open fun resetTilesetCache(): Unit
    open fun setScale(xScale: Number? = definedExternally, yScale: Number? = definedExternally): Unit
    open fun updateMax(): Unit
}


external open class TilemapParser {
    companion object {
        var INSERT_NULL: Boolean
        fun getEmptyData(tileWidth: Number? = definedExternally, tileHeight: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally): Any
        fun parse(game: Phaser.Game, key: String, tileWidth: Number? = definedExternally, tileHeight: Number? = definedExternally, width: Number? = definedExternally, height: Number? = definedExternally): Any
        fun parseCSV(key: String, data: String, tileWidth: Number? = definedExternally, tileHeight: Number? = definedExternally): Any
        fun parseJSON(json: Any): Any
    }
}


external open class Tileset(name: String, firstgid: Number, width: Number? = definedExternally, height: Number? = definedExternally, margin: Number? = definedExternally, spacing: Number? = definedExternally, properties: Any? = definedExternally) {
    open var columns: Number
    open var firstgid: Number
    open var image: Any
    open var lastgid: Number
    open var name: String
    open var properties: Any
    open var rows: Number
    open var tileHeight: Number
    open var tileMargin: Number
    open var tileSpacing: Number
    open var tileWidth: Number
    open var total: Number
    open fun containsTileIndex(tileIndex: Number): Boolean
    open fun draw(context: CanvasRenderingContext2D, x: Number, y: Number, index: Number): Unit
    open fun drawGl(glBatch: Array<Any>, x: Number, y: Number, index: Number, alpha: Number, flippedVal: Number): Unit
    open fun setImage(image: Any): Unit
    open fun setSpacing(margin: Number? = definedExternally, spacing: Number? = definedExternally): Unit
}


external open class TileSprite() : PIXI.TilingSprite {
    constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: String? = definedExternally, frame: String? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: String? = definedExternally, frame: Number? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: Phaser.RenderTexture? = definedExternally, frame: String? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: Phaser.RenderTexture? = definedExternally, frame: Number? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: Phaser.BitmapData? = definedExternally, frame: String? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: Phaser.BitmapData? = definedExternally, frame: Number? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: PIXI.Texture? = definedExternally, frame: String? = definedExternally) 
    constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: PIXI.Texture? = definedExternally, frame: Number? = definedExternally) 

    open var alive: Boolean
    open var angle: Number
    open var animations: Phaser.AnimationManager
    open var autoCull: Boolean
    open var body: dynamic  /*Phaser.Physics.Arcade.Body  | Phaser.Physics.P2.Body | Phaser.Physics.Ninja.Body | Any */
    open var bottom: Number
    open var cameraOffset: Phaser.Point
    open var checkWorldBounds: Boolean
    open var components: Any
    open var customRender: Boolean
    open var data: Any
    open var debug: Boolean
    open var destroyPhase: Boolean
    open var events: Phaser.Events
    override var exists: Boolean
    open var fixedToCamera: Boolean
    open var frame: dynamic /* String | Number */
    open var frameName: String
    open var fresh: Boolean
    open var game: Phaser.Game
    open var inCamera: Boolean
    open var input: Phaser.InputHandler
    open var inputEnabled: Boolean
    open var inWorld: Boolean
    open var key: dynamic /* String | Phaser.RenderTexture | Phaser.BitmapData | Phaser.Video | PIXI.Texture */
    open var left: Number
    open var name: String
    open var offsetX: Number
    open var offsetY: Number
    open var outOfBoundsKill: Boolean
    open var pendingDestroy: Boolean
    open var physicsType: Number
    override var position: Phaser.Point
    open var smoothed: Boolean
    open var previousPosition: Phaser.Point
    open var previousRoation: Number
    open var right: Number
    open var top: Number
    open var renderOrderID: Number
    open var type: Number
    open var world: Phaser.Point
    //open var z: Number
    open fun alignIn(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any

    open fun alignIn(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignIn(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Rectangle, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Sprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Image, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Text, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.BitmapText, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Button, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.Graphics, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun alignTo(container: Phaser.TileSprite, position: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Any
    open fun autoScroll(x: Number, y: Number): Unit
    open fun destroy(destroyChildren: Boolean? = definedExternally): Unit
    open fun loadTexture(key: String, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: String, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.RenderTexture, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.RenderTexture, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.BitmapData, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.BitmapData, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.Video, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: Phaser.Video, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: PIXI.Texture, frame: String? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun loadTexture(key: PIXI.Texture, frame: Number? = definedExternally, stopAnimation: Boolean? = definedExternally): Unit
    open fun play(name: String, frameRate: Number? = definedExternally, loop: Boolean? = definedExternally, killOnComplete: Boolean? = definedExternally): Phaser.Animation
    open fun postUpdate(): Unit
    open fun preUpdate(): Unit
    open fun overlap(displayObject: Phaser.Sprite): Boolean
    open fun overlap(displayObject: Phaser.Image): Boolean
    open fun overlap(displayObject: Phaser.TileSprite): Boolean
    open fun overlap(displayObject: Phaser.Button): Boolean
    open fun overlap(displayObject: PIXI.DisplayObject): Boolean
    open fun reset(x: Number, y: Number, health: Number? = definedExternally): Phaser.TileSprite
    open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
    open fun resetFrame(): Unit
    open fun setFrame(frame: Phaser.Frame): Unit
    open fun stopScroll(): Unit
    open fun update(): Unit
}


external open class Time(game: Phaser.Game) {
    open var advancedTiming: Boolean
    open var desiredFps: Double
    open var desiredFpsMult: Double
    open var elapsed: Number
    open var events: Phaser.Timer
    open var elapsedMS: Number
    open var fps: Double
    open var fpsMax: Double
    open var fpsMin: Double
    open var frames: Double
    open var game: Phaser.Game
    open var lastTime: Double
    open var msMax: Double
    open var msMin: Double
    open var now: Double
    open var pausedTime: Double
    open var pauseDuration: Double
    open var physicsElapsed: Double
    open var physicsElapsedMS: Double
    open var prevTime: Double
    open var slowMotion: Double
    open var suggestedFps: Double
    open var time: Double
    open var timeExpected: Double
    open var timeToCall: Double
    open fun add(timer: Phaser.Timer): Phaser.Timer
    open fun boot(): Unit
    open fun create(autoDestroy: Boolean? = definedExternally): Phaser.Timer
    open fun elapsedSecondsSince(since: Number): Double
    open fun elapsedSince(since: Number): Double
    open fun removeAll(): Unit
    open fun reset(): Unit
    open fun totalElapsedSeconds(): Double
    open fun update(time: Number): Unit
}


external open class Timer(game: Phaser.Game, autoDestroy: Boolean? = definedExternally) {
    open var autoDestroy: Boolean
    open var duration: Number
    open var events: Array<Phaser.TimerEvent>
    open var expired: Boolean
    open var game: Phaser.Game
    open var length: Number
    open var ms: Number
    open var next: Number
    open var nextTick: Number
    open var onComplete: Phaser.Signal
    open var running: Boolean
    open var paused: Boolean
    open var seconds: Number
    open fun add(delay: Number, callback: Function<Any>, callbackContext: Any? = definedExternally, vararg args: Any): Phaser.TimerEvent
    open fun clearPendingEvents(): Unit
    open fun destroy(): Unit
    open fun loop(delay: Number, callback: Function<Any>, callbackContext: Any? = definedExternally, vararg args: Any): Phaser.TimerEvent
    open fun order(): Unit
    open fun pause(): Unit
    open fun remove(event: Phaser.TimerEvent): Boolean
    open fun removeAll(): Unit
    open fun repeat(delay: Number, repeatCount: Number, callback: Function<Any>, callbackContext: Any? = definedExternally, vararg args: Any): Phaser.TimerEvent
    open fun resume(): Unit
    open fun sortHandler(a: Any, b: Any): Number
    open fun start(startDelay: Number? = definedExternally): Unit
    open fun stop(clearEvents: Boolean? = definedExternally): Unit
    open fun update(time: Number): Boolean

    companion object {
        var HALF: Double
        var MINUTE: Double
        var QUARTER: Double
        var SECOND: Double
    }
}


external open class TimerEvent(timer: Phaser.Timer, delay: Number, tick: Number, repeatCount: Number, loop: Boolean, callback: Function<Any>, callbackContext: Any, vararg args: Any) {
    open var args: Array<Any>
    open var callback: Function<Any>
    open var callbackContext: Any
    open var delay: Number
    open var loop: Boolean
    open var pendingDelete: Boolean
    open var repeatCount: Number
    open var tick: Number
    open var timer: Phaser.Timer
}


external open class Touch(game: Phaser.Game) {
    open var callbackContext: Any
    open var enabled: Boolean
    open var event: Any
    open var game: Phaser.Game
    open var preventDefault: Boolean
    open var touchCancelCallback: Function<Any>
    open var touchEndCallback: Function<Any>
    open var touchEnterCallback: Function<Any>
    open var touchLeaveCallback: Function<Any>
    open var touchMoveCallback: Function<Any>
    open var touchStartCallback: Function<Any>
    open var touchLockCallbacks: Array<Function<Any>>
    open fun addTouchLockCallback(callback: Function<Any>, context: Any? = definedExternally, onEnd: Function<Any>? = definedExternally): Unit
    open fun removeTouchLockCallback(callback: Function<Any>, context: Any? = definedExternally): Boolean
    open fun consumeTouchMove(): Unit
    open fun onTouchCancel(event: Any): Unit
    open fun onTouchEnd(event: Any): Unit
    open fun onTouchEnter(event: Any): Unit
    open fun onTouchLeave(event: Any): Unit
    open fun onTouchMove(event: Any): Unit
    open fun onTouchStart(event: Any): Unit
    open fun start(): Unit
    open fun stop(): Unit
}


external open class Tween(target: Any, game: Phaser.Game, manager: Phaser.TweenManager) {
    open var chainedTween: Phaser.Tween
    open var current: Number
    open var frameBased: Boolean
    open var game: Phaser.Game
    open var isRunning: Boolean
    open var isPaused: Boolean
    open var manager: Phaser.TweenManager
    open var onChildComplete: Phaser.Signal
    open var onComplete: Phaser.Signal
    open var onLoop: Phaser.Signal
    open var onRepeat: Phaser.Signal
    open var onStart: Phaser.Signal
    open var pendingDelete: Boolean
    open var properties: Any
    open var repeatCounter: Number
    open var reverse: Boolean
    open var target: Any
    open var timeline: Array<Phaser.TweenData>
    open var timeScale: Number
    open var totalDuration: Number
    open fun chain(vararg args: Any): Phaser.Tween
    open fun delay(duration: Number, index: Number? = definedExternally): Phaser.Tween
    open fun easing(ease: Function<Any>, index: Number? = definedExternally): Phaser.Tween
    open fun easing(ease: String, index: Number? = definedExternally): Phaser.Tween
    open fun from(properties: Any, duration: Number? = definedExternally, ease: Function<Any>? = definedExternally, autoStart: Boolean? = definedExternally, delay: Number? = definedExternally, repeat: Number? = definedExternally, yoyo: Boolean? = definedExternally): Phaser.Tween
    open fun from(properties: Any, duration: Number? = definedExternally, ease: String? = definedExternally, autoStart: Boolean? = definedExternally, delay: Number? = definedExternally, repeat: Number? = definedExternally, yoyo: Boolean? = definedExternally): Phaser.Tween
    open fun generateData(frameRate: Number? = definedExternally, data: Any? = definedExternally): Array<Any>
    open fun interpolation(interpolation: Function<Any>, context: Any? = definedExternally, index: Number? = definedExternally): Phaser.Tween
    open fun loop(value: Boolean? = definedExternally): Phaser.Tween
    open fun onUpdateCallback(callback: Function<Any>, callbackContext: Any? = definedExternally): Phaser.Tween
    open fun pause(): Unit
    open fun repeat(total: Number, repeatDelay: Number? = definedExternally, index: Number? = definedExternally): Phaser.Tween
    open fun repeatDelay(duration: Number, index: Number? = definedExternally): Phaser.Tween
    open fun repeatAll(total: Number? = definedExternally): Phaser.Tween
    open fun resume(): Unit
    open fun start(index: Number? = definedExternally): Phaser.Tween
    open fun stop(complete: Boolean? = definedExternally): Phaser.Tween
    open fun to(properties: Any, duration: Number? = definedExternally, ease: Function<Number>? = definedExternally, autoStart: Boolean? = definedExternally, delay: Number? = definedExternally, repeat: Number? = definedExternally, yoyo: Boolean? = definedExternally): Phaser.Tween
    open fun to(properties: Any, duration: Number? = definedExternally, ease: String?, autoStart: Boolean? = definedExternally, delay: Number? = definedExternally, repeat: Number? = definedExternally, yoyo: Boolean? = definedExternally): Phaser.Tween
    open fun update(time: Number): Boolean
    open fun updateTweenData(property: String, value: Number, index: Number? = definedExternally): Phaser.Tween
    open fun updateTweenData(property: String, value: Function<Any>, index: Number? = definedExternally): Phaser.Tween
    open fun yoyo(enable: Boolean, yoyoDelay: Number? = definedExternally, index: Number? = definedExternally): Phaser.Tween
    open fun yoyoDelay(duration: Number, index: Number? = definedExternally): Phaser.Tween
}


external open class TweenData(parent: Phaser.Tween) {
    open var delay: Number
    open var dt: Number
    open var duration: Number
    open var easingFunction: Function<Any>
    open var game: Phaser.Game
    open var inReverse: Boolean
    open var interpolate: Boolean
    open var interpolateFunctionContext: Phaser.Math
    open var interpolationContext: Phaser.Math
    open var interpolationFunction: Function<Any>
    open var isRunning: Boolean
    open var isFrom: Boolean
    open var parent: Phaser.Tween
    open var percent: Number
    open var repeatCounter: Number
    open var startTime: Number
    open var value: Number
    open var yoyo: Boolean
    open var yoyoDelay: Number
    open fun from(properties: Any, duration: Number? = definedExternally, ease: Function<Any>? = definedExternally, delay: Number? = definedExternally, repeat: Number? = definedExternally, yoyo: Boolean? = definedExternally): Phaser.TweenData
    open fun generateData(frameRate: Number? = definedExternally): Array<Any>
    open fun repeat(): Number
    open fun start(): Phaser.TweenData
    open fun to(properties: Any, duration: Number? = definedExternally, ease: Function<Any>? = definedExternally, delay: Number? = definedExternally, repeat: Number? = definedExternally, yoyo: Boolean? = definedExternally): Phaser.TweenData
    open fun update(time: Number): Number

    companion object {
        var COMPLETE: Number
        var LOOPED: Number
        var PENDING: Number
        var RUNNING: Number
    }
}


external open class TweenManager(game: Phaser.Game) {
    open var frameBased: Boolean
    open var game: Phaser.Game
    open fun add(tween: Phaser.Tween): Phaser.Tween
    open fun create(`object`: Any): Phaser.Tween
    open fun getAll(): Array<Phaser.Tween>
    open fun isTweening(`object`: Any): Boolean
    open fun remove(tween: Phaser.Tween): Phaser.Tween
    open fun removeAll(): Unit
    open fun removeFrom(obj: Any, children: Boolean? = definedExternally): Unit
    open fun resumeAll(): Unit
    open fun update(): Boolean
    open fun pauseAll(): Unit
}


external open class Utils {
    companion object {
        fun getProperty(obj: Any, prop: String): Any
        fun setProperty(obj: Any, prop: String, value: Any): Any
        fun chanceRoll(chance: Number): Boolean
        fun randomChoice(choice1: String, choice2: Any): Any
        fun randomChoice(choice1: Number, choice2: Any): Any
        fun reverseString(string: String): String
        fun parseDimension(size: Any, dimension: Number): Number
        fun pad(str: String, len: Number? = definedExternally, pad: String? = definedExternally, dir: Number? = definedExternally): String
        fun isPlainObject(`object`: Any): Boolean
        fun extend(deep: Boolean, target: Any, vararg args: Any): Any
        fun mixinPrototype(target: Any, mixin: Any, replace: Boolean? = definedExternally): Unit
        fun <T> mixin(from: T, to: Any): T
    }

    open class Debug(game: Phaser.Game) {
        open var bmd: Phaser.BitmapData
        open var canvas: HTMLCanvasElement
        open var columnWidth: Number
        open var context: CanvasRenderingContext2D
        open var currentAlpha: Number
        open var currentX: Number
        open var currentY: Number
        open var dirty: Boolean
        open var font: String
        open var game: Phaser.Game
        open var lineHeight: Number
        open var renderShadow: Boolean
        open var sprite: Phaser.Image
        open var style: String
        //open fun AStar(astar: Phaser.Plugin.AStar, x: Number, y: Number, showVisited: Boolean): Unit
        open fun boot(): Unit

        open fun body(sprite: Phaser.Sprite, color: String? = definedExternally, filled: Boolean? = definedExternally): Unit
        open fun bodyInfo(sprite: Phaser.Sprite, x: Number, y: Number, color: String? = definedExternally): Unit
        open fun box2dBody(body: Phaser.Sprite, color: String? = definedExternally): Unit
        open fun box2dWorld(): Unit
        open fun cameraInfo(camera: Phaser.Camera, x: Number, y: Number, color: String? = definedExternally): Unit
        open fun destroy(): Unit
        open fun geom(`object`: Any, color: String? = definedExternally, fiiled: Boolean? = definedExternally, forceType: Number? = definedExternally): Unit
        open fun inputInfo(x: Number, y: Number, color: String? = definedExternally): Unit
        open fun lineInfo(line: Phaser.Line, x: Number, y: Number, color: String? = definedExternally): Unit
        open fun key(key: Phaser.Key, x: Number? = definedExternally, y: Number? = definedExternally, color: String? = definedExternally): Unit
        open fun line(vararg args: String): Unit
        open fun preUpdate(): Unit
        open fun pixel(x: Number, y: Number, color: String? = definedExternally, size: Number? = definedExternally): Unit
        open fun pointer(pointer: Phaser.Pointer, hideIfUp: Boolean? = definedExternally, downColor: String? = definedExternally, upColor: String? = definedExternally, color: String? = definedExternally): Unit
        open fun quadTree(quadtree: Phaser.QuadTree, color: String? = definedExternally): Unit
        open fun rectangle(obj: dynamic, color: String? = definedExternally, filled: Boolean? = definedExternally): Unit
        open fun rectangle(`object`: Phaser.Rectangle, color: String? = definedExternally, filled: Boolean? = definedExternally): Unit
        open fun reset(): Unit
        open fun ropeSegments(rope: Phaser.Rope, color: Number? = definedExternally, filled: Boolean? = definedExternally): Unit
        open fun soundInfo(sound: Phaser.Sound, x: Number, y: Number, color: String? = definedExternally): Unit
        open fun spriteBounds(sprite: Any, color: String? = definedExternally, filled: Boolean? = definedExternally): Unit
        open fun spriteCoords(sprite: Any, x: Number, y: Number, color: String? = definedExternally): Unit
        open fun spriteInfo(sprite: Phaser.Sprite, x: Number, y: Number, color: String? = definedExternally): Unit
        open fun spriteInputInfo(sprite: Phaser.Sprite, x: Number, y: Number, color: String? = definedExternally): Unit
        open fun start(x: Number? = definedExternally, y: Number? = definedExternally, color: String? = definedExternally, columnWidth: Number? = definedExternally): Unit
        open fun stop(): Unit
        open fun text(text: Any): Unit
        open fun text(text: Any, x: Number, y: Number, color: String? = definedExternally, font: String? = definedExternally): Unit
        open fun timer(timer: Phaser.Timer, x: Number, y: Number, color: String? = definedExternally): Unit
    }
}


external open class Weapon(game: Phaser.Game, parent: Phaser.PluginManager) : Phaser.Plugin {
    open var autoExpandBulletsGroup: Boolean
    open var autofire: Boolean
    open var bounds: Phaser.Rectangle
    open var bulletAngleOffset: Number
    open var bulletAngleVariance: Number
    open var bulletAnimation: String
    open var bulletClass: Any
    open var bulletCollideWorldBounds: Boolean
    open var bulletFrame: String
    open var bulletFrameCycle: Boolean
    open var bulletFrameRandom: Boolean
    open var bulletFrames: Array<Any>
    open var bulletGravity: Phaser.Point
    open var bulletInheritSpriteSpeed: Boolean
    open var bulletKey: String
    open var bulletKillDistance: Number
    open var bulletKillType: Number
    open var bulletLifespan: Number
    open var bulletRotateToVelocity: Boolean
    open var bullets: Phaser.Group
    open var bulletSpeed: Number
    open var bulletSpeedVariance: Number
    open var bulletWorldWrap: Boolean
    open var bulletWorldWrapPadding: Number
    open var fireAngle: Number
    open var fireFrom: Phaser.Rectangle
    open var fireLimit: Number
    open var fireRate: Number
    open var fireRateVariance: Number
    open var multiFire: Boolean
    open var onFire: Phaser.Signal
    open var onFireLimit: Phaser.Signal
    open var onKill: Phaser.Signal
    open var shots: Number
    open var trackedPointer: Phaser.Pointer
    open var trackedSprite: Any
    open var trackOffset: Phaser.Point
    open var trackRotation: Boolean
    open var x: Number
    open var y: Number
    open fun addBulletAnimation(name: String, frames: Array<Number>? = definedExternally, frameRate: Number? = definedExternally, loop: Boolean? = definedExternally, useNumericIndex: Boolean? = definedExternally): Phaser.Weapon
    open fun addBulletAnimation(name: String, frames: Array<String>? = definedExternally, frameRate: Number? = definedExternally, loop: Boolean? = definedExternally, useNumericIndex: Boolean? = definedExternally): Phaser.Weapon
    open fun createBullets(quantity: Number? = definedExternally, key: Any? = definedExternally, frame: Any? = definedExternally, group: Phaser.Group? = definedExternally): Phaser.Weapon
    open fun debug(x: Number? = definedExternally, y: Number? = definedExternally, debugBodies: Boolean? = definedExternally): Unit
    override fun destroy(): Unit
    open fun fire(from: Any? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Bullet
    open fun fireAtPointer(pointer: Phaser.Pointer): Phaser.Bullet
    open fun fireAtSprite(sprite: Phaser.Sprite): Phaser.Bullet
    open fun fireAtXY(x: Number, y: Number): Phaser.Bullet
    open fun fireMany(positions: Array<Any>, from: Any? = definedExternally): Array<Phaser.Bullet>
    open fun fireOffset(offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Bullet
    open fun forEach(callback: Any, callbackContext: Any): Phaser.Weapon
    open fun killAll(): Phaser.Weapon
    open fun pauseAll(): Phaser.Weapon
    open fun resetShots(newLimit: Number? = definedExternally): Phaser.Weapon
    open fun resumeAll(): Phaser.Weapon
    open fun setBulletBodyOffset(width: Number, height: Number, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Weapon
    open fun setBulletFrames(min: Number, max: Number, cycle: Boolean? = definedExternally, random: Boolean? = definedExternally): Phaser.Weapon
    open fun trackPointer(pointer: Phaser.Pointer, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally): Phaser.Weapon
    open fun trackSprite(sprite: Phaser.Sprite, offsetX: Number? = definedExternally, offsetY: Number? = definedExternally, trackRotation: Boolean? = definedExternally): Phaser.Weapon

    companion object {
        var KILL_NEVER: Number
        var KILL_LIFESPAN: Number
        var KILL_DISTANCE: Number
        var KILL_WEAPON_BOUNDS: Number
        var KILL_CAMERA_BOUNDS: Number
        var KILL_WORLD_BOUNDS: Number
        var KILL_STATIC_BOUNDS: Number
    }
}

external interface `T$15` {
    var skipped: Number
    var ignored: Number
    var checked: Number
}


external open class World(game: Phaser.Game) : Phaser.Group {
    open var bounds: Phaser.Rectangle
    open var camera: Phaser.Camera
    override var centerX: Double
    override var centerY: Double
    override var game: Phaser.Game
    override var height: Double
    open var isPaused: Boolean
    open var randomX: Double
    open var randomY: Double
    open var stats: `T$15`
    override var width: Double
    open fun boot(): Unit
    open fun getObjectsUnderPointer(pointer: Phaser.Pointer, group: Phaser.Group, callback: Function<Any>? = definedExternally, callbackContext: Any? = definedExternally): Phaser.Sprite
    open fun resize(width: Number, height: Number): Unit
    open fun setBounds(x: Number, y: Number, width: Number, height: Number): Unit
    open fun sortLeftRight(a: Phaser.Sprite, b: Phaser.Sprite): Number
    open fun sortRightLeft(a: Phaser.Sprite, b: Phaser.Sprite): Number
    open fun sortTopBottom(a: Phaser.Sprite, b: Phaser.Sprite): Number
    open fun sortBottomTop(a: Phaser.Sprite, b: Phaser.Sprite): Number
    open fun sort(group: Phaser.Group, sortDirection: Number? = definedExternally): Unit
    override fun sort(key: String?, order: Number?): Unit
    open fun shutdown(): Unit
    open fun wrap(sprite: Any, padding: Number? = definedExternally, useBounds: Boolean? = definedExternally, horizontal: Boolean? = definedExternally, vertical: Boolean? = definedExternally): Unit
}
