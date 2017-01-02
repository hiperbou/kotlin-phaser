package Phaser

import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Uint32Array
import org.khronos.webgl.Uint8Array
import org.khronos.webgl.WebGLFramebuffer
import org.w3c.dom.*
import org.w3c.dom.events.Event
import org.w3c.dom.events.KeyboardEvent
import org.w3c.dom.events.MouseEvent
import org.w3c.files.Blob
import org.w3c.xhr.XMLHttpRequest

/*@JsModule("phaser")
@JsNonModule
@JsName("$")*/
/*external open class Phaser {
    companion object {*/
        /*var VERSION: String
        var DEV_VERSION: String
        var GAMES: Array<Phaser.Game>
        var AUTO: Number
        var CANVAS: Number
        var WEBGL: Number
        var HEADLESS: Number
        var WEBGL_MULTI: Number
        var BITMAPDATA: Number
        var BITMAPTEXT: Number
        var BUTTON: Number
        var CANVAS_FILTER: Number
        var CIRCLE: Number
        var ELLIPSE: Number
        var EMITTER: Number
        var GRAPHICS: Number
        var GROUP: Number
        var IMAGE: Number
        var LINE: Number
        var MATRIX: Number
        var POINT: Number
        var POINTER: Number
        var POLYGON: Number
        var RECTANGLE: Number
        var ROUNDEDRECTANGLE: Number
        var RENDERTEXTURE: Number
        var RETROFONT: Number
        var SPRITE: Number
        var SPRITEBATCH: Number
        var TEXT: Number
        var TILEMAP: Number
        var TILEMAPLAYER: Number
        var TILESPRITE: Number
        var WEBGL_FILTER: Number
        var ROPE: Number
        var CREATURE: Number
        var VIDEO: Number
        var NONE: Number
        var LEFT: Number
        var RIGHT: Number
        var UP: Number
        var DOWN: Number
        var HORIZONTAL: Number
        var VERTICAL: Number
        var LANDSCAPE: Number
        var PORTRAIT: Number
        var ANGLE_UP: Number
        var ANGLE_DOWN: Number
        var ANGLE_LEFT: Number
        var ANGLE_RIGHT: Number
        var ANGLE_NORTH_EAST: Number
        var ANGLE_NORTH_WEST: Number
        var ANGLE_SOUTH_EAST: Number
        var ANGLE_SOUTH_WEST: Number
        var TOP_LEFT: Number
        var TOP_CENTER: Number
        var TOP_RIGHT: Number
        var LEFT_TOP: Number
        var LEFT_CENTER: Number
        var LEFT_BOTTOM: Number
        var CENTER: Number
        var RIGHT_TOP: Number
        var RIGHT_CENTER: Number
        var RIGHT_BOTTOM: Number
        var BOTTOM_LEFT: Number
        var BOTTOM_CENTER: Number
        var BOTTOM_RIGHT: Number*/
@JsName("Phaser.Animation")
		external open class Animation {
            constructor(game: Phaser.Game, parent: Phaser.Sprite, name: String, frameData: Phaser.FrameData, frames: Array<Number>, frameRate: Number? = null, loop: Boolean? = null)
            constructor(game: Phaser.Game, parent: Phaser.Sprite, name: String, frameData: Phaser.FrameData, frames: Array<String>, frameRate: Number? = null, loop: Boolean? = null)
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
            open var onStart: Phaser.Signal
            open var onUpdate: Phaser.SignalAnimationFrame
            open var paused: Boolean
            open var reversed: Boolean
            open var speed: Number
            open fun complete(): Unit
            open fun destroy(): Unit
            open fun next(quantity: Number? = null): Unit
            open fun onPause(): Unit
            open fun onResume(): Unit
            open fun play(frameRate: Number? = null, loop: Boolean? = null, killOnComplete: Boolean? = null): Phaser.Animation
            open fun previous(quantity: Number? = null): Unit
            open fun restart(): Unit
            open fun reverse(): Animation
            open fun reverseOnce(): Animation
            open fun setFrame(frameId: String? = null, useLocalFrameIndex: Boolean? = null): Unit
            open fun setFrame(frameId: Number? = null, useLocalFrameIndex: Boolean? = null): Unit
            open fun stop(resetFrame: Boolean? = null, dispatchComplete: Boolean? = null): Unit
            open fun update(): Boolean
            open fun updateCurrentFrame(signalUpdate: Boolean, fromPlay: Boolean? = null): Boolean
            open fun updateFrameData(frameData: FrameData): Unit
            companion object {
                fun generateFrameNames(prefix: String, start: Number, stop: Number, suffix: String? = null, zeroPad: Number? = null): Array<String>
            }
        }
@JsName("Phaser.AnimationManager")
        external open class AnimationManager(sprite: Phaser.Sprite) {
            open var currentAnim: Phaser.Animation
            open var currentFrame: Phaser.Frame
            open var frame: Number
            open var frameData: Phaser.FrameData
            open var frameName: String
            open var frameTotal: Number
            open var game: Phaser.Game
            open var isLoaded: Boolean
            open var name: String
            open var paused: Boolean
            open var sprite: Phaser.Sprite
            open var updateIfVisible: Boolean
            //open fun add(name: String, frames: Array<Number>? = null, frameRate: Number? = null, loop: Boolean? = null, useNumericIndex: Boolean? = null): Phaser.Animation
            //open fun add(name: String, frames: Array<String>? = null, frameRate: Number? = null, loop: Boolean? = null, useNumericIndex: Boolean? = null): Phaser.Animation
            open fun add(name: String): Phaser.Animation
            open fun add(name: String, frames: Array<Int>): Phaser.Animation
            open fun add(name: String, frames: Array<Int>? = null, frameRate: Number? = null, loop: Boolean? = null, useNumericIndex: Boolean? = null): Phaser.Animation
            open fun add(name: String, frames: Array<String>? = null, frameRate: Number? = null, loop: Boolean? = null, useNumericIndex: Boolean? = null): Phaser.Animation
            open fun copyFrameData(frameData: Phaser.FrameData, frame: String): Boolean
            open fun copyFrameData(frameData: Phaser.FrameData, frame: Number): Boolean
            open fun destroy(): Unit
            open fun getAnimation(name: String): Phaser.Animation
            open fun next(quantity: Number? = null): Unit
            open fun play(name: String, frameRate: Number? = null, loop: Boolean? = null, killOnComplete: Boolean? = null): Phaser.Animation
            open fun previous(quantity: Number? = null): Unit
            open fun stop(name: String? = null, resetFrame: Boolean? = null): Unit
            open fun update(): Boolean
            open fun validateFrames(frames: Array<Phaser.Frame>, useNumericIndex: Boolean? = null): Boolean
        }
@JsName("Phaser.AnimationParser")
        external open class AnimationParser {
            companion object {
                fun JSONData(game: Phaser.Game, json: Any): Phaser.FrameData
                fun JSONDataHash(game: Phaser.Game, json: Any): Phaser.FrameData
                fun JSONDataPyxel(game: Phaser.Game, json: Any): Phaser.FrameData
                fun spriteSheet(game: Phaser.Game, key: String, frameWidth: Number, frameHeight: Number, frameMax: Number? = null, margin: Number? = null, spacing: Number? = null, skipFrames: Number? = null): Phaser.FrameData
                fun XMLData(game: Phaser.Game, xml: Any): Phaser.FrameData
            }
        }
@JsName("Phaser.AudioSprite")
        external open class AudioSprite(game: Phaser.Game, key: String) {
            open var game: Phaser.Game
            open var key: String
            open var config: Any
            open var autoplayKey: String
            open var autoplay: Boolean
            open var sounds: Any
            open fun get(marker: String): Phaser.Sound
            open fun play(marker: String, volume: Number? = null): Phaser.Sound
            open fun stop(marker: String): Phaser.Sound
            open var allowMultiple:Boolean
        }
@JsName("Phaser.ArraySet")
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
            open fun removeAll(destoy: Boolean? = null): Unit
            open fun setAll(key: Any, value: Any): Unit
            open fun callAll(key: String, vararg parameter: Any): Unit
        }
@JsName("Phaser.ArrayUtils")
        external open class ArrayUtils {
            companion object {
                fun <T> getRandomItem(objects: Array<T>, startIndex: Number? = null, length: Number? = null): T
                fun <T> removeRandomItem(objects: Array<T>, startIndex: Number? = null, length: Number? = null): T
                fun <T> shuffle(array: Array<T>): Array<T>
                fun <T> transposeMatrix(array: Array<T>): T
                fun rotateMatrix(matrix: Any, direction: Number): Any
                fun rotateMatrix(matrix: Any, direction: String): Any
                fun findClosest(value: Number, arr: Array<Number>): Number
                fun rotate(array: Array<Any>): Any
                fun rotateLeft(array: Array<Any>): Any
                fun rotateRight(array: Array<Any>): Any
                fun numberArray(start: Number, end: Number): Array<Number>
                fun numberArrayStep(start: Number, end: Number? = null, step: Number? = null): Array<Number>
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
@JsName("Phaser.BitmapData")
        external open class BitmapData(game: Phaser.Game, key: String, width: Number? = null, height: Number? = null, skipPool: Boolean? = null) {
            open var baseTexture: PIXI.BaseTexture
            open var buffer: ArrayBuffer
            open var canvas: HTMLCanvasElement
            open var context: CanvasRenderingContext2D
            open var ctx: CanvasRenderingContext2D
            open var data: Uint8Array
            open var dirty: Boolean
            open var disableTextureUpload: Boolean
            open var game: Phaser.Game
            open var height: Number
            open var imageData: ImageData
            open var key: String
            open var op: String
            open var pixels: Uint32Array
            open var smoothed: Boolean
            open var smoothProperty: String
            open var texture: PIXI.Texture
            open var textureFrame: Phaser.Frame
            open var type: Number
            open var width: Number
            open fun add(`object`: Any): Phaser.BitmapData
            open fun addToWorld(x: Number? = null, y: Number? = null, anchorX: Number? = null, anchorY: Number? = null, scaleX: Number? = null, scaleY: Number? = null): Phaser.Image
            open fun alphaMask(source: Any, mask: Any? = null, sourceRect: Phaser.Rectangle? = null, maskRect: Phaser.Rectangle? = null): Phaser.BitmapData
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
            open fun circle(x: Number, y: Number, radius: Number, fillStyle: String? = null): Phaser.BitmapData
            open fun clear(x: Number? = null, y: Number? = null, width: Number? = null, height: Number? = null): Phaser.BitmapData
            open fun cls(): Phaser.BitmapData
            open fun copy(source: Any? = null, x: Number? = null, y: Number? = null, width: Number? = null, height: Number? = null, tx: Number? = null, ty: Number? = null, newWidth: Number? = null, newHeight: Number? = null, rotate: Number? = null, anchorX: Number? = null, anchorY: Number? = null, scaleX: Number? = null, scaleY: Number? = null, alpha: Number? = null, blendMode: String? = null, roundPx: Boolean? = null): Phaser.BitmapData
            open fun copyPixels(source: Any, area: Phaser.Rectangle, x: Number, y: Number, alpha: Number? = null): Unit
            open fun copyRect(source: Any, area: Phaser.Rectangle, x: Number? = null, y: Number? = null, alpha: Number? = null, blendMode: String? = null, roundPx: Boolean? = null): Phaser.BitmapData
            open fun copyTransform(source: Any, blendMode: String? = null, roundPx: Boolean? = null): Phaser.BitmapData
            open fun destroy(): Unit
            open fun draw(source: Any, x: Number? = null, y: Number? = null, width: Number? = null, height: Number? = null, blendMode: String? = null, roundPx: Boolean? = null): Phaser.BitmapData
            open fun drawFull(parent: Any, blendMode: String? = null, roundPx: Boolean? = null): Phaser.BitmapData
            open fun drawGroup(group: Phaser.Group, blendMode: String? = null, roundPx: Boolean? = null): Phaser.BitmapData
            open fun extract(destination: Phaser.BitmapData, r: Number, g: Number, b: Number, a: Number? = null, resize: Boolean? = null, r2: Number? = null, g2: Number? = null, b2: Number? = null): Phaser.BitmapData
            open fun fill(r: Number, g: Number, b: Number, a: Number? = null): Phaser.BitmapData
            open fun generateTexture(key: String): PIXI.Texture
            open fun getBounds(rect: Phaser.Rectangle? = null): Phaser.Rectangle
            open fun getFirstPixel(direction: Number): `T$0`
            open fun getPixel(x: Number, y: Number, out: Any? = null): Any
            open fun getPixelRGB(x: Number, y: Number, out: Any? = null, hsl: Boolean? = null, hsv: Boolean? = null): Any
            open fun getPixel32(x: Number, y: Number): Number
            open fun getPixels(rect: Phaser.Rectangle): ImageData
            open fun getTransform(translateX: Number, translateY: Number, scaleX: Number, scaleY: Number, skewX: Number, skewY: Number): Any
            open fun line(x1: Number, y1: Number, x2: Number, y2: Number, color: String? = null, width: Number? = null): Phaser.BitmapData
            open fun load(source: Any): Phaser.BitmapData
            open fun move(x: Number, y: Number, wrap: Boolean? = null): Phaser.BitmapData
            open fun moveH(distance: Number, wrap: Boolean? = null): Phaser.BitmapData
            open fun moveV(distance: Number, wrap: Boolean? = null): Phaser.BitmapData
            open fun processPixel(callback: (color: Number, x: Number, y: Number) -> Unit, callbackContext: Any, x: Number? = null, y: Number? = null, width: Number? = null, height: Number? = null): Phaser.BitmapData
            open fun processPixelRGB(callback: (color: ColorComponents, x: Number, y: Number) -> Unit, callbackContext: Any, x: Number? = null, y: Number? = null, width: Number? = null, height: Number? = null): Phaser.BitmapData
            open fun rect(x: Number, y: Number, width: Number, height: Number, fillStyle: String? = null): Phaser.BitmapData
            open fun render(): Phaser.BitmapData
            open fun replaceRGB(r1: Number, g1: Number, b1: Number, a1: Number, r2: Number, g2: Number, b2: Number, a2: Number, region: Phaser.Rectangle? = null): Phaser.BitmapData
            open fun resize(width: Number, height: Number): Phaser.BitmapData
            open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
            open fun setHSL(h: Number? = null, s: Number? = null, l: Number? = null, region: Phaser.Rectangle? = null): Phaser.BitmapData
            open fun setPixel(x: Number, y: Number, red: Number, green: Number, blue: Number, immediate: Boolean? = null): Phaser.BitmapData
            open fun setPixel32(x: Number, y: Number, red: Number, green: Number, blue: Number, alpha: Number, immediate: Boolean? = null): Phaser.BitmapData
            open fun shadow(color: String, blur: Number? = null, x: Number? = null, y: Number? = null): Phaser.BitmapData
            open fun shiftHSL(h: Number? = null, s: Number? = null, l: Number? = null, region: Phaser.Rectangle? = null): Phaser.BitmapData
            open fun text(text: String, x: Number? = null, y: Number? = null, font: String? = null, color: String? = null, shadow: Boolean? = null): Phaser.BitmapData
            open fun textureLine(line: Phaser.Line, key: String, repeat: String? = null): Phaser.BitmapData
            open fun update(x: Number? = null, y: Number? = null, width: Number? = null, height: Number? = null): Phaser.BitmapData
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
@JsName("Phaser.BitmapText")
        external open class BitmapText(game: Phaser.Game, x: Number, y: Number, font: String, text: String? = null, size: Number? = null, align: String? = null) : PIXI.DisplayObjectContainer() {
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
            open var fontSize: Number
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
            open var position: Phaser.Point
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
            open var z: Double
            open fun alignIn(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun destroy(destroyChildren: Boolean? = null): Unit
            open fun kill(): Unit
            open fun postUpdate(): Unit
            open fun preUpdate(): Unit
            open fun purgeGlyphs(): Number
            open fun reset(x: Number, y: Number, health: Number? = null): Phaser.BitmapText
            open fun revive(health: Number? = null): Phaser.BitmapText
            open fun scanLine(data: Any, scale: Number, text: String): `T$1`
            open fun setText(text: String): Unit
            open fun update(): Unit
            open fun updateText(): Unit
            open fun updateTransform(): Unit
        }
@JsName("Phaser.Bullet")
        external open class Bullet(game: Phaser.Game, x: Number, y: Number, key: Any? = null, frame: Any? = null) : Phaser.Sprite(game, x, y, key, frame) {
            override fun kill(): Phaser.Bullet
            override fun update(): Unit
        }
@JsName("Phaser.Button")
        external open class Button(game: Phaser.Game, x: Number, y: Number , key: String, callback: Function<Any>? = null, callbackContext: Any? = null, overFrame: String? = null, outFrame: String? = null, downFrame: String? = null, upFrame: String? = null)
    : Phaser.Image(game, x, y, key) {
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
            open fun setDownSound(sound: Phaser.Sound, marker: String? = null): Unit
            open fun setDownSound(sound: Phaser.AudioSprite, marker: String? = null): Unit
            open fun setFrames(overFrame: String? = null, outFrame: String? = null, downFrame: String? = null, upFrame: String? = null): Unit
            open fun setFrames(overFrame: String? = null, outFrame: String? = null, downFrame: String? = null, upFrame: Number? = null): Unit
            open fun setFrames(overFrame: String? = null, outFrame: String? = null, downFrame: Number? = null, upFrame: String? = null): Unit
            open fun setFrames(overFrame: String? = null, outFrame: String? = null, downFrame: Number? = null, upFrame: Number? = null): Unit
            open fun setFrames(overFrame: String? = null, outFrame: Number? = null, downFrame: String? = null, upFrame: String? = null): Unit
            open fun setFrames(overFrame: String? = null, outFrame: Number? = null, downFrame: String? = null, upFrame: Number? = null): Unit
            open fun setFrames(overFrame: String? = null, outFrame: Number? = null, downFrame: Number? = null, upFrame: String? = null): Unit
            open fun setFrames(overFrame: String? = null, outFrame: Number? = null, downFrame: Number? = null, upFrame: Number? = null): Unit
            open fun setFrames(overFrame: Number? = null, outFrame: String? = null, downFrame: String? = null, upFrame: String? = null): Unit
            open fun setFrames(overFrame: Number? = null, outFrame: String? = null, downFrame: String? = null, upFrame: Number? = null): Unit
            open fun setFrames(overFrame: Number? = null, outFrame: String? = null, downFrame: Number? = null, upFrame: String? = null): Unit
            open fun setFrames(overFrame: Number? = null, outFrame: String? = null, downFrame: Number? = null, upFrame: Number? = null): Unit
            open fun setFrames(overFrame: Number? = null, outFrame: Number? = null, downFrame: String? = null, upFrame: String? = null): Unit
            open fun setFrames(overFrame: Number? = null, outFrame: Number? = null, downFrame: String? = null, upFrame: Number? = null): Unit
            open fun setFrames(overFrame: Number? = null, outFrame: Number? = null, downFrame: Number? = null, upFrame: String? = null): Unit
            open fun setFrames(overFrame: Number? = null, outFrame: Number? = null, downFrame: Number? = null, upFrame: Number? = null): Unit
            open fun onInputOverHandler(sprite: Phaser.Button, pointer: Phaser.Pointer): Unit
            open fun onInputOutHandler(sprite: Phaser.Button, pointer: Phaser.Pointer): Unit
            open fun onInputDownHandler(sprite: Phaser.Button, pointer: Phaser.Pointer): Unit
            open fun onInputUpHandler(sprite: Phaser.Button, pointer: Phaser.Pointer, isOver: Boolean): Unit
            open fun removedFromWorld(): Unit
            open fun setOutSound(sound: Phaser.Sound, marker: String? = null): Unit
            open fun setOutSound(sound: Phaser.AudioSprite, marker: String? = null): Unit
            open fun setOverSound(sound: Phaser.Sound, marker: String? = null): Unit
            open fun setOverSound(sound: Phaser.AudioSprite, marker: String? = null): Unit
            open fun setSounds(overSound: Phaser.Sound? = null, overMarker: String? = null, downSound: Phaser.Sound? = null, downMarker: String? = null, outSound: Phaser.Sound? = null, outMarker: String? = null, upSound: Phaser.Sound? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.Sound? = null, overMarker: String? = null, downSound: Phaser.Sound? = null, downMarker: String? = null, outSound: Phaser.Sound? = null, outMarker: String? = null, upSound: Phaser.AudioSprite? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.Sound? = null, overMarker: String? = null, downSound: Phaser.Sound? = null, downMarker: String? = null, outSound: Phaser.AudioSprite? = null, outMarker: String? = null, upSound: Phaser.Sound? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.Sound? = null, overMarker: String? = null, downSound: Phaser.Sound? = null, downMarker: String? = null, outSound: Phaser.AudioSprite? = null, outMarker: String? = null, upSound: Phaser.AudioSprite? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.Sound? = null, overMarker: String? = null, downSound: Phaser.AudioSprite? = null, downMarker: String? = null, outSound: Phaser.Sound? = null, outMarker: String? = null, upSound: Phaser.Sound? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.Sound? = null, overMarker: String? = null, downSound: Phaser.AudioSprite? = null, downMarker: String? = null, outSound: Phaser.Sound? = null, outMarker: String? = null, upSound: Phaser.AudioSprite? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.Sound? = null, overMarker: String? = null, downSound: Phaser.AudioSprite? = null, downMarker: String? = null, outSound: Phaser.AudioSprite? = null, outMarker: String? = null, upSound: Phaser.Sound? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.Sound? = null, overMarker: String? = null, downSound: Phaser.AudioSprite? = null, downMarker: String? = null, outSound: Phaser.AudioSprite? = null, outMarker: String? = null, upSound: Phaser.AudioSprite? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.AudioSprite? = null, overMarker: String? = null, downSound: Phaser.Sound? = null, downMarker: String? = null, outSound: Phaser.Sound? = null, outMarker: String? = null, upSound: Phaser.Sound? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.AudioSprite? = null, overMarker: String? = null, downSound: Phaser.Sound? = null, downMarker: String? = null, outSound: Phaser.Sound? = null, outMarker: String? = null, upSound: Phaser.AudioSprite? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.AudioSprite? = null, overMarker: String? = null, downSound: Phaser.Sound? = null, downMarker: String? = null, outSound: Phaser.AudioSprite? = null, outMarker: String? = null, upSound: Phaser.Sound? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.AudioSprite? = null, overMarker: String? = null, downSound: Phaser.Sound? = null, downMarker: String? = null, outSound: Phaser.AudioSprite? = null, outMarker: String? = null, upSound: Phaser.AudioSprite? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.AudioSprite? = null, overMarker: String? = null, downSound: Phaser.AudioSprite? = null, downMarker: String? = null, outSound: Phaser.Sound? = null, outMarker: String? = null, upSound: Phaser.Sound? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.AudioSprite? = null, overMarker: String? = null, downSound: Phaser.AudioSprite? = null, downMarker: String? = null, outSound: Phaser.Sound? = null, outMarker: String? = null, upSound: Phaser.AudioSprite? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.AudioSprite? = null, overMarker: String? = null, downSound: Phaser.AudioSprite? = null, downMarker: String? = null, outSound: Phaser.AudioSprite? = null, outMarker: String? = null, upSound: Phaser.Sound? = null, upMarker: String? = null): Unit
            open fun setSounds(overSound: Phaser.AudioSprite? = null, overMarker: String? = null, downSound: Phaser.AudioSprite? = null, downMarker: String? = null, outSound: Phaser.AudioSprite? = null, outMarker: String? = null, upSound: Phaser.AudioSprite? = null, upMarker: String? = null): Unit
            open fun setState(newState: Number): Unit
            open fun setUpSound(sound: Phaser.Sound, marker: String? = null): Unit
            open fun setUpSound(sound: Phaser.AudioSprite, marker: String? = null): Unit
        }
@JsName("Phaser.PointerMode")
        external open class PointerMode {
            companion object {
                var CURSOR: Number
                var CONTACT: Number
            }
        }
@JsName("Phaser.Cache")
        external open class Cache(game: Phaser.Game) {
            open var autoResolveURL: Boolean
            open var game: Phaser.Game
            open var onSoundUnlock: Phaser.Signal
            open fun addBinary(key: String, binaryData: Any): Unit
            open fun addBitmapData(key: String, bitmapData: Phaser.BitmapData, frameData: Phaser.FrameData? = null): Phaser.BitmapData
            open fun addBitmapFont(key: String, url: String, data: Any, atlasData: Any, atlasType: String, xSpacing: Number? = null, ySpacing: Number? = null): Unit
            open fun addBitmapFontFromAtlas(key: String, atlasKey: String, atlasFrame: String, dataKey: String, dataType: String? = null, xSpacing: Number? = null, ySpacing: Number? = null): Unit
            open fun addCanvas(key: String, canvas: HTMLCanvasElement, context: CanvasRenderingContext2D? = null): Unit
            open fun addDefaultImage(): Unit
            open fun addImage(key: String, url: String, data: Any): HTMLImageElement
            open fun addJSON(key: String, urL: String, data: Any): Unit
            open fun addMissingImage(): Unit
            open fun addPhysicsData(key: String, url: String, JSONData: Any, format: Number): Unit
            open fun addRenderTexture(key: String, texture: RenderTexture): Unit
            open fun addShader(key: String, url: String, data: Any): Unit
            open fun addSound(key: String, url: String, data: Any, webAudio: Boolean, audioTag: Boolean): Unit
            open fun addSpriteSheet(key: String, url: String, data: Any, frameWidth: Number, frameHeight: Number, frameMax: Number? = null, margin: Number? = null, spacing: Number? = null, skipFrames: Number? = null): Unit
            open fun addText(key: String, url: String, data: Any): Unit
            open fun addTextureAtlas(key: String, url: String, data: Any, atlasData: Any, format: Number): Unit
            open fun addTilemap(key: String, url: String, mapData: Any, format: Number): Unit
            open fun addVideo(key: String, url: String, data: Any, isBlob: Boolean? = null): Unit
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
            open fun getBaseTexture(key: String, cache: Number? = null): PIXI.BaseTexture
            open fun getBinary(key: String): Any
            open fun getBitmapData(key: String): Phaser.BitmapData
            open fun getBitmapFont(key: String): Phaser.BitmapFont
            open fun getCanvas(key: String): HTMLCanvasElement
            open fun getFrame(key: String, cache: Number? = null): Phaser.Frame
            open fun getFrameByIndex(key: String, index: Number, cache: Number? = null): Phaser.Frame
            open fun getFrameByName(key: String, name: String, cache: Number? = null): Phaser.Frame
            open fun getFrameCount(key: String, cache: Number? = null): Number
            open fun getFrameData(key: String, cache: Number? = null): Phaser.FrameData
            open fun getImage(key: String, full: Boolean? = null): HTMLImageElement
            open fun getItem(key: String, cache: Number, method: String? = null, property: String? = null): Any
            open fun getJSON(key: String, clone: Boolean? = null): Any
            open fun getKeys(cache: Number): Array<String>
            open fun getPhysicsData(key: String, `object`: String? = null, fixtureKey: String? = null): Array<Any>
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
            open fun hasFrameData(key: String, cache: Number? = null): Boolean
            open fun isSoundDecoded(key: String): Boolean
            open fun isSoundReady(key: String): Boolean
            open fun isSpriteSheet(key: String): Boolean
            open fun reloadSound(key: String): Unit
            open fun reloadSoundComplete(key: String): Unit
            open fun removeBinary(key: String): Unit
            open fun removeBitmapData(key: String): Unit
            open fun removeBitmapFont(key: String): Unit
            open fun removeCanvas(key: String): Unit
            open fun removeImage(key: String, removeFromPixi: Boolean? = null): Unit
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
            open fun updateFrameData(key: String, frameData: Any, cache: Number? = null): Unit
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
        interface `T$2` {
            var x: Boolean
            var y: Boolean
        }
@JsName("Phaser.Camera")
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
            open var x: Number
            open var y: Number
            open fun checkBounds(): Unit
            open fun fade(color: Number? = null, duration: Number? = null, force: Boolean? = null, alpha: Number? = null): Boolean
            open fun flash(color: Number? = null, duration: Number? = null, force: Boolean? = null, alpha: Number? = null): Boolean
            open fun focusOn(displayObject: PIXI.DisplayObject): Unit
            open fun focusOnXY(x: Number, y: Number): Unit
            open fun follow(target: Phaser.Sprite, style: Number? = null, lerpX: Number? = null, lerpY: Number? = null): Unit
            open fun reset(): Unit
            open fun resetFX(): Unit
            open fun setBoundsToWorld(): Unit
            open fun setPosition(x: Number, y: Number): Unit
            open fun setSize(width: Number, height: Number): Unit
            open fun shake(intensity: Number? = null, duration: Number? = null, force: Boolean? = null, direction: Number? = null, shakeBounds: Boolean? = null): Boolean
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
@JsName("Phaser.Canvas")
        external open class Canvas {
            companion object {
                fun addToDOM(canvas: HTMLCanvasElement, parent: HTMLElement, overflowHidden: Boolean? = null): HTMLCanvasElement
                fun create(parent: HTMLDivElement, width: Number? = null, height: Number? = null, id: String? = null, skipPool: Boolean? = null): HTMLCanvasElement
                fun getSmoothingEnabled(context: CanvasRenderingContext2D): Boolean
                fun getSmoothingPrefix(context: CanvasRenderingContext2D): String
                fun removeFromDOM(canvas: HTMLCanvasElement): Unit
                fun setBackgroundColor(canvas: HTMLCanvasElement, color: String): HTMLCanvasElement
                fun setImageRenderingBicubic(canvas: HTMLCanvasElement): HTMLCanvasElement
                fun setImageRenderingCrisp(canvas: HTMLCanvasElement): HTMLCanvasElement
                fun setSmoothingEnabled(context: CanvasRenderingContext2D, value: Boolean): CanvasRenderingContext2D
                fun setTouchAction(canvas: HTMLCanvasElement, value: String): HTMLCanvasElement
                fun setTransform(context: CanvasRenderingContext2D, translateX: Number, translateY: Number, scaleX: Number, scaleY: Number, skewX: Number, skewY: Number): CanvasRenderingContext2D
                fun setUserSelect(canvas: HTMLCanvasElement, value: String? = null): HTMLCanvasElement
            }
        }
@JsName("Phaser.Circle")
        external open class Circle(x: Number? = null, y: Number? = null, diameter: Number? = null) {
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
            open fun circumferencePoint(angle: Number, asDegrees: Boolean? = null, out: Phaser.Point? = null): Phaser.Point
            open fun clone(output: Phaser.Circle): Phaser.Circle
            open fun contains(x: Number, y: Number): Boolean
            open fun copyFrom(source: Any): Circle
            open fun copyTo(dest: Any): Any
            open fun distance(dest: Any, round: Boolean? = null): Number
            open fun getBounds(): Phaser.Rectangle
            open fun offset(dx: Number, dy: Number): Phaser.Circle
            open fun offsetPoint(point: Phaser.Point): Phaser.Circle
            open fun random(out: Phaser.Point? = null): Phaser.Point
            open fun scale(x: Number, y: Number? = null): Phaser.Rectangle
            open fun setTo(x: Number, y: Number, diameter: Number): Circle
            override fun toString(): String
            companion object {
                fun circumferencePoint(a: Phaser.Circle, angle: Number, asDegrees: Boolean, out: Phaser.Point? = null): Phaser.Point
                fun contains(a: Phaser.Circle, x: Number, y: Number): Boolean
                fun equals(a: Phaser.Circle, b: Phaser.Circle): Boolean
                fun intersects(a: Phaser.Circle, b: Phaser.Circle): Boolean
                fun intersectsRectangle(c: Phaser.Circle, r: Phaser.Rectangle): Boolean
            }
        }
@JsName("Phaser.Color")
        external open class Color {
            companion object {
                fun componentToHex(color: Number): String
                fun createColor(r: Number? = null, g: Number? = null, b: Number? = null, a: Number? = null, h: Number? = null, s: Number? = null, l: Number? = null, v: Number? = null): ColorComponents
                fun fromRGBA(rgba: Number, out: ColorComponents? = null): ColorComponents
                fun getAlpha(color: Number): Number
                fun getAlphaFloat(color: Number): Number
                fun getBlue(color: Number): Number
                fun getColor(red: Number, green: Number, blue: Number): Number
                fun getColor32(alpha: Number, red: Number, green: Number, blue: Number): Number
                fun getGreen(color: Number): Number
                fun getRandomColor(min: Number? = null, max: Number? = null, alpha: Number? = null): Number
                fun getRed(color: Number): Number
                fun getRGB(color: Number): RGBColor
                fun getWebRGB(color: Number): String
                fun getWebRGB(color: RGBColor): String
                fun hexToRGBArray(color: Number): Array<Number>
                fun hexToRGB(h: String): Number
                fun hexToColor(hex: String, out: ColorComponents? = null): ColorComponents
                fun HSLtoRGB(h: Number, s: Number, l: Number, out: ColorComponents? = null): ColorComponents
                fun HSLColorWheel(s: Number? = null, l: Number? = null): Array<ColorComponents>
                fun HSVtoRGB(h: Number, s: Number, v: Number, out: ColorComponents? = null): ColorComponents
                fun HSVColorWheel(s: Number? = null, v: Number? = null): Array<ColorComponents>
                fun hueToColor(p: Number, q: Number, t: Number): Number
                fun interpolateColor(color1: Number, color2: Number, steps: Number, currentStep: Number, alpha: Number? = null): Number
                fun interpolateColorWithRGB(color: Number, r: Number, g: Number, b: Number, steps: Number, currentStep: Number): Number
                fun interpolateRGB(r1: Number, g1: Number, b1: Number, r2: Number, g2: Number, b2: Number, steps: Number, currentStep: Number): Number
                fun packPixel(r: Number, g: Number, b: Number, a: Number): Number
                fun RGBArrayToHex(rgb: Array<Number>): Number
                fun RGBtoHSL(r: Number, g: Number, b: Number, out: ColorComponents? = null): ColorComponents
                fun RGBtoHSV(r: Number, g: Number, b: Number, out: ColorComponents? = null): ColorComponents
                fun RGBtoString(r: Number, g: Number, b: Number, a: Number? = null, prefix: String? = null): String
                fun toRGBA(r: Number, g: Number, b: Number, a: Number): Number
                fun toABGR(r: Number, g: Number, b: Number, a: Number): Number
                fun unpackPixel(rgba: Number, out: ColorComponents? = null, hsl: Boolean? = null, hsv: Boolean? = null): ColorComponents
                fun updateColor(out: ColorComponents): ColorComponents
                fun valueToColor(value: String, out: ColorComponents? = null): ColorComponents
                fun webToColor(web: String, out: ColorComponents? = null): ColorComponents
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
        interface RGBColor {
            var r: Number
            var g: Number
            var b: Number
            var a: Number
        }
        interface ColorComponents : RGBColor {
            var h: Number
            var s: Number
            var v: Number
            var l: Number
            var color: Number
            var color32: Number
            var rgba: String
        }
@JsName("Phaser.Create")
        external open class Create(game: Phaser.Game) {
            open var bmd: Phaser.BitmapData
            open var canvas: HTMLCanvasElement
            open var ctx: CanvasRenderingContext2D
            open var game: Phaser.Game
            open var palettes: Any
            open fun grid(key: String, width: Number, height: Number, cellWidth: Number, cellHeight: Number, color: String): PIXI.Texture
            open fun texture(key: String, data: Any, pixelWidth: Number? = null, pixelHeight: Number? = null, palette: Number? = null): PIXI.Texture
            companion object {
                var PALETTE_ARNE: Number
                var PALETTE_JMP: Number
                var PALETTE_CGA: Number
                var PALETTE_C64: Number
                var PALETTE_JAPANESE_MACHINE: Number
            }
        }
        interface CursorKeys {
            var up: Phaser.Key
            var down: Phaser.Key
            var left: Phaser.Key
            var right: Phaser.Key
        }
@JsName("Phaser.Device")
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
@JsName("Phaser.DeviceButton")
        external open class DeviceButton {
            constructor(parent: Phaser.Pointer, butonCode: Number)
            constructor(parent: Phaser.SinglePad, butonCode: Number)
            open var buttonCode: Number
            open var game: Phaser.Game
            open var isDown: Boolean
            open var isUp: Boolean
            open var onDown: Phaser.Signal
            open var onFloat: Phaser.Signal
            open var onUp: Phaser.Signal
            open var pad: Phaser.Gamepad
            open var repeats: Number
            open var timeDown: Number
            open var timeUp: Number
            open var value: Number
            open fun destroy(): Unit
            open fun justPressed(duration: Number? = null): Boolean
            open fun justReleased(duration: Number? = null): Boolean
            open fun processButtonDown(value: Number): Unit
            open fun processButtonFloat(value: Number): Unit
            open fun processButtonUp(value: Number): Unit
            open fun reset(): Unit
        }

        @JsName("Phaser.Easing")
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
                    fun In(k: Number): Number = noImpl
                    fun Out(k: Number): Number = noImpl
                    fun InOut(k: Number): Number = noImpl
                //}
            }
            object Bounce {
                //companion object {
                    fun In(k: Number): Number = noImpl
                    fun Out(k: Number): Number = noImpl
                    fun InOut(k: Number): Number = noImpl
                //}
            }
            object Circular {
                //companion object {
                    fun In(k: Number): Number = noImpl
                    fun Out(k: Number): Number = noImpl
                    fun InOut(k: Number): Number = noImpl
                //}
            }
            object Cubic {
                //companion object {
                    fun In(k: Number): Number = noImpl
                    fun Out(k: Number): Number = noImpl
                    fun InOut(k: Number): Number = noImpl
                //}
            }
            object Elastic {
                //companion object {
                    fun In(k: Number): Number = noImpl
                    fun Out(k: Number): Number = noImpl
                    fun InOut(k: Number): Number = noImpl
                //}
            }
            object Exponential {
                //companion object {
                    fun In(k: Number): Number = noImpl
                    fun Out(k: Number): Number = noImpl
                    fun InOut(k: Number): Number = noImpl
                //}
            }
            object Linear {
                //companion object {
                    fun None(k: Number): Number = noImpl
                //}
            }
            object Quadratic {
                //companion object {
                    fun In(k: Number): Number = noImpl
                    fun Out(k: Number): Number = noImpl
                    fun InOut(k: Number): Number = noImpl
                //}
            }
            object Quartic {
                //companion object {
                    fun In(k: Number): Number = noImpl
                    fun Out(k: Number): Number = noImpl
                    fun InOut(k: Number): Number = noImpl
                //}
            }
            object Quintic {
                //companion object {
                    fun In(k: Number): Number = noImpl
                    fun Out(k: Number): Number = noImpl
                    fun InOut(k: Number): Number = noImpl
                //}
            }
            object Sinusoidal {
                //companion object {
                    fun In(k: Number): Number = noImpl
                    fun Out(k: Number): Number = noImpl
                    fun InOut(k: Number): Number = noImpl
                //}
            }
        }
		@JsName("Phaser.Ellipse")
        external open class Ellipse(x: Number? = null, y: Number? = null, width: Number? = null, height: Number? = null) {
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
            open fun random(out: Phaser.Point? = null): Phaser.Point
            open fun setTo(x: Number, y: Number, width: Number, height: Number): Phaser.Ellipse
            override fun toString(): String
            companion object {
                fun constains(a: Phaser.Ellipse, x: Number, y: Number): Boolean
            }
        }
@JsName("Phaser.Events")
        external open class Events(sprite: Phaser.Sprite) {
            open var parent: Phaser.Sprite
            open var onAddedToGroup: Phaser.Signal
            open var onRemovedFromGroup: Phaser.Signal
            open var onRemovedFromWorld: Phaser.Signal
            open var onKilled: Phaser.Signal
            open var onRevived: Phaser.Signal
            open var onOutOfBounds: Phaser.Signal
            open var onEnterBounds: Phaser.Signal
            open var onInputOver: Phaser.Signal
            open var onInputOut: Phaser.Signal
            open var onInputDown: Phaser.Signal
            open var onInputUp: Phaser.Signal
            open var onDestroy: Phaser.Signal
            open var onDragStart: Phaser.Signal
            open var onDragStop: Phaser.Signal
            open var onDragUpdate: Phaser.Signal
            open var onAnimationStart: Phaser.Signal
            open var onAnimationComplete: Phaser.Signal
            open var onAnimationLoop: Phaser.Signal
            open fun destroy(): Unit
        }
/*@JsName("Phaser.Filter")
        external open class Filter() : PIXI.AbstractFilter() {
            constructor(game: Phaser.Game, uniforms: Any, fragmentSrc: String):this()
            constructor(game: Phaser.Game, uniforms: Any, fragmentSrc: Array<String>):this()
            override var dirty: Boolean
            open var game: Phaser.Game
            open var height: Number
            override var fragmentSrc: dynamic /* String | Array<String> */
            override var padding: Number
            open var prevPoint: Phaser.Point
            open var type: Number
            override var uniforms: Any
            open var width: Number
            open fun addToWorld(x: Number? = null, y: Number? = null, width: Number? = null, height: Number? = null, anchorX: Number? = null, anchorY: Number? = null): Phaser.Image
            override fun apply(frameBuffer: WebGLFramebuffer): Unit
            open fun destroy(): Unit
            open fun init(vararg args: Any): Unit
            open fun setResolution(width: Number, height: Number): Unit
            override fun syncUniforms(): Unit
            open fun update(pointer: Phaser.Pointer? = null): Unit
            companion object {
                open class BinarySerpents(game: Phaser.Game, width: Number, height: Number, march: Number? = null, maxDistance: Number? = null) : Phaser.Filter() {
                    open var fog: Number
                }
                open class BlurX : Phaser.Filter() {
                    open var blur: Number
                }
                open class BlurY : Phaser.Filter() {
                    open var blur: Number
                }
                open class CausticLight(game: Phaser.Game, width: Number, height: Number, divisor: Number? = null) : Phaser.Filter() {
                    open fun init(width: Number, height: Number, divisor: Number? = null): Unit
                }
                open class CheckerWave(game: Phaser.Game, width: Number, height: Number) : Phaser.Filter() {
                    open var alpha: Number
                    open var cameraX: Number
                    open var cameraY: Number
                    open var cameraZ: Number
                    open fun init(width: Number, height: Number): Unit
                    open fun setColor1(red: Number, green: Number, blue: Number): Unit
                    open fun setColor2(red: Number, green: Number, blue: Number): Unit
                }
                open class ColorBars(game: Phaser.Game, width: Number, height: Number) : Phaser.Filter() {
                    open var alpha: Number
                    open fun init(width: Number, height: Number): Unit
                }
                open class Fire(width: Number, height: Number, alpha: Number? = null, shift: Number? = null) : Phaser.Filter() {
                    open var alpha: Number
                    open var shift: Number
                    open var speed: Number
                    open fun init(width: Number, height: Number, alpha: Number? = null, shift: Number? = null): Unit
                }
                open class Gray : Phaser.Filter() {
                    open var gray: Number
                }
                open class HueRotate(game: Phaser.Game, width: Number, height: Number, texture: Any) : Phaser.Filter() {
                    open var alpha: Number
                    open fun init(width: Number, height: Number, texture: Any): Unit
                }
                open class LazerBeam : Phaser.Filter() {
                    open fun init(width: Number, height: Number, divisor: Number? = null): Unit
                }
                open class LightBeam(game: Phaser.Game, width: Number, height: Number) : Phaser.Filter() {
                    open var alpha: Number
                    open var blue: Number
                    open var green: Number
                    open var red: Number
                    open var thickness: Number
                    open var speed: Number
                    open fun init(width: Number, height: Number): Unit
                }
                open class Marble(game: Phaser.Game, width: Number, height: Number, speed: Number? = null, intensity: Number? = null) : Phaser.Filter() {
                    open var alpha: Number
                    open var intensity: Number
                    open var speed: Number
                    open fun init(width: Number, height: Number, speed: Number? = null, intensity: Number? = null): Unit
                }
                open class Pixelate : Phaser.Filter() {
                    open var size: Number
                    open var sizeX: Number
                    open var sizeY: Number
                }
                open class Plasma(game: Phaser.Game, width: Number, height: Number, alpha: Number? = null, size: Number? = null) : Phaser.Filter() {
                    open var alpha: Number
                    open var blueShift: Number
                    open var greenShift: Number
                    open var redShift: Number
                    open var size: Number
                    open fun init(width: Number, height: Number, alpha: Number? = null, size: Number? = null): Unit
                }
                open class SampleFilter(game: Phaser.Game, width: Number, height: Number, divisor: Number? = null) : Phaser.Filter() {
                    open fun init(width: Number, height: Number, divisor: Number? = null): Unit
                }
                open class Tunnel(game: Phaser.Game, width: Number, height: Number, texture: Any) : Phaser.Filter() {
                    open var alpha: Number
                    open var origin: Number
                    open fun init(width: Number, height: Number, texture: Any): Unit
                }
            }
        }*/
@JsName("Phaser.FlexGrid")
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
            //open fun createCustomLayer(width: Number, height: Number, children: Array<PIXI.DisplayObject>? = null, addToWorld: Boolean? = null): Phaser.FlexLayer
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
/*@JsName("Phaser.FlexLayer")
        external open class FlexLayer(manager: Phaser.ScaleManager, position: Phaser.Point, bounds: Phaser.Rectangle, scale: Phaser.Point)
    : Phaser.Group() {
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
@JsName("Phaser.Frame")
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
            open fun getRect(out: Phaser.Rectangle? = null): Phaser.Rectangle
            open fun setTrim(trimmed: Boolean, actualWidth: Number, actualHeight: Number, destX: Number, destY: Number, destWidth: Number, destHeight: Number): Unit
            open fun resize(width: Number, height: Number): Unit
        }
@JsName("Phaser.FrameData")
        external open class FrameData {
            open var total: Number
            open fun addFrame(frame: Frame): Phaser.Frame
            open fun checkFrameName(name: String): Boolean
            open fun clone(): Phaser.FrameData
            open fun getFrame(index: Number): Phaser.Frame
            open fun getFrameByName(name: String): Phaser.Frame
            open fun getFrameIndexes(frames: Array<Number>? = null, useNumericIndex: Boolean? = null, output: Array<Number>? = null): Array<Number>
            open fun getFrameRange(start: Number, end: Number, output: Array<Phaser.Frame>): Array<Phaser.Frame>
            open fun getFrames(frames: Array<Number>? = null, useNumericIndex: Boolean? = null, output: Array<Phaser.Frame>? = null): Array<Phaser.Frame>
        }
        external interface IGameConfig {
            var enableDebug: Boolean? //
            var width: Number? //
            var height: Number? //
            var renderer: Number? //
            var parent: Any? //
            var transparent: Boolean? //
            var antialias: Boolean? //
            var resolution: Number? //
            var preserveDrawingBuffer: Boolean? //
            var physicsConfig: Any? //
            var seed: String? //
            var state: Phaser.State? //
            var forceSetTimeOut: Boolean? //
            var multiTextue: Boolean? //
        }
@JsName("Phaser.Game")
		external open class Game {
            constructor(width: Number? = null, height: Number? = null, renderer: Number? = null, parent: Any? = null, state: Any? = null, transparent: Boolean? = null, antialias: Boolean? = null, physicsConfig: Any? = null)
            constructor(width: Number? = null, height: String? = null, renderer: Number? = null, parent: Any? = null, state: Any? = null, transparent: Boolean? = null, antialias: Boolean? = null, physicsConfig: Any? = null)
            constructor(width: String? = null, height: Number? = null, renderer: Number? = null, parent: Any? = null, state: Any? = null, transparent: Boolean? = null, antialias: Boolean? = null, physicsConfig: Any? = null)
            constructor(width: String? = null, height: String? = null, renderer: Number? = null, parent: Any? = null, state: Any? = null, transparent: Boolean? = null, antialias: Boolean? = null, physicsConfig: Any? = null)
            constructor(config: IGameConfig)
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
            //open var plugins: PluginManager
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
@JsName("Phaser.GameObjectCreator")
        external open class GameObjectCreator(game: Phaser.Game) {
            open var game: Phaser.Game
            open var world: Phaser.World
            open fun audio(key: String, volume: Number? = null, loop: Boolean? = null, connect: Boolean? = null): Phaser.Sound
            open fun audioSprite(key: String): Phaser.AudioSprite
            open fun bitmapData(width: Number? = null, height: Number? = null, key: String? = null, addToCache: Boolean? = null): Phaser.BitmapData
            open fun bitmapText(x: Number, y: Number, font: String, text: String? = null, size: Number? = null, align: String? = null): Phaser.BitmapText
            open fun button(x: Number? = null, y: Number? = null, key: String? = null, callback: Function<Any>? = null, callbackContext: Any? = null, overFrame: Any? = null, outFrame: Any? = null, downFrame: Any? = null, upFrame: Any? = null): Phaser.Button
            open fun emitter(x: Number? = null, y: Number? = null, maxParticles: Number? = null): Phaser.Particles.Arcade.Emitter
            //open fun filter(filter: Any, vararg args: Any): Phaser.Filter
            open fun graphics(x: Number? = null, y: Number? = null): Phaser.Graphics
            open fun group(parent: Any? = null, name: String? = null, addToStage: Boolean? = null, enableBody: Boolean? = null, physicsBodyType: Number? = null): Phaser.Group
            open fun image(x: Number, y: Number, key: Any? = null, frame: Any? = null): Phaser.Image
            open fun renderTexture(width: Number? = null, height: Number? = null, key: Any? = null, addToCache: Boolean? = null): Phaser.RenderTexture
            open fun retroFont(font: String, characterWidth: Number, characterHeight: Number, chars: String, charsPerRow: Number, xSpacing: Number? = null, ySpacing: Number? = null, xOffset: Number? = null, yOffset: Number? = null): Phaser.RetroFont
            open fun rope(x: Number, y: Number, key: Any, frame: Any? = null, points: Array<Phaser.Point>? = null): Phaser.Rope
            open fun sound(key: String, volume: Number? = null, loop: Boolean? = null, connect: Boolean? = null): Phaser.Sound
            open fun sprite(x: Number, y: Number, key: Any? = null, frame: Any? = null): Phaser.Sprite
            open fun spriteBatch(parent: Any, name: String? = null, addToStage: Boolean? = null): Phaser.SpriteBatch
            open fun text(x: Number, y: Number, text: String? = null, style: Any? = null): Phaser.Text
            open fun tilemap(key: String, tileWidth: Number? = null, tileHeight: Number? = null, width: Number? = null, height: Number? = null): Phaser.Tilemap
            open fun tileSprite(x: Number, y: Number, width: Number, height: Number, key: Any, frame: Any): Phaser.TileSprite
            open fun tween(obj: Any): Phaser.Tween
        }
@JsName("Phaser.GameObjectFactory")
        external open class GameObjectFactory(game: Phaser.Game) {
            open var game: Phaser.Game
            open var world: Phaser.World
            open fun audio(key: String, volume: Number? = null, loop: Boolean? = null, connect: Boolean? = null): Phaser.Sound
            open fun audioSprite(key: String): Phaser.AudioSprite
            open fun bitmapData(width: Number? = null, height: Number? = null, key: String? = null, addToCache: Boolean? = null): Phaser.BitmapData
            open fun bitmapText(x: Number, y: Number, font: String, text: String? = null, size: Number? = null, group: Phaser.Group? = null): Phaser.BitmapText
            open fun button(x: Number? = null, y: Number? = null, key: String? = null, callback: (Button)->Unit? , callbackContext: Any? = null, overFrame: Any? = null, outFrame: Any? = null, downFrame: Any? = null, upFrame: Any? = null, group: Phaser.Group? = null): Phaser.Button
            open fun emitter(x: Number? = null, y: Number? = null, maxParticles: Number? = null): Phaser.Particles.Arcade.Emitter
            open fun existing(`object`: Any): Any
            //open fun filter(filter: String, vararg args: Any): Phaser.Filter
            open fun graphics(x: Number, y: Number, group: Phaser.Group? = null): Phaser.Graphics
            open fun group(parent: Any? = null, name: String? = null, addToStage: Boolean? = null, enableBody: Boolean? = null, physicsBodyType: Number? = null): Phaser.Group
            open fun image(x: Number, y: Number, key: Any? = null, frame: Any? = null, group: Phaser.Group? = null): Phaser.Image
            open fun physicsGroup(physicsBodyType: Number? = null, parent: Any? = null, name: String? = null, addToStage: Boolean? = null): Phaser.Group
            //open fun plugin(plugin: Phaser.Plugin, vararg parameter: Any): Phaser.Plugin
            open fun renderTexture(width: Number? = null, height: Number? = null, key: String? = null, addToCache: Boolean? = null): Phaser.RenderTexture
            open fun retroFont(font: String, characterWidth: Number, characterHeight: Number, chars: String, charsPerRow: Number, xSpacing: Number? = null, ySpacing: Number? = null, xOffset: Number? = null, yOffset: Number? = null): Phaser.RetroFont
            open fun rope(x: Number, y: Number, key: Any, frame: Any? = null, points: Array<Phaser.Point>? = null): Phaser.Rope
            open fun sound(key: String, volume: Number? = null, loop: Boolean? = null, connect: Boolean? = null): Phaser.Sound
            open fun sprite(x: Number, y: Number, key: Any? = null, frame: Any? = null, group: Phaser.Group? = null): Phaser.Sprite
            open fun spriteBatch(parent: Any, name: String? = null, addToStage: Boolean? = null): Phaser.Group
            open fun text(x: Number, y: Number, text: String, style: Any, group: Phaser.Group? = null): Phaser.Text
            open fun tilemap(key: String? = null, tileWidth: Number? = null, tileHeight: Number? = null, width: Number? = null, height: Number? = null): Phaser.Tilemap
            open fun tileSprite(x: Number, y: Number, width: Number, height: Number, key: Any? = null, frame: Any? = null, group: Phaser.Group? = null): Phaser.TileSprite
            open fun tween(obj: Any): Phaser.Tween
            //open fun weapon(quantity: Number? = null, key: Any? = null, frame: Any? = null, group: Phaser.Group? = null): Phaser.Weapon
            open fun video(key: String? = null, url: String? = null): Phaser.Video
        }
@JsName("Phaser.Gamepad")
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
            open fun justPressed(buttonCode: Number, duration: Number? = null): Boolean
            open fun justReleased(buttonCode: Number, duration: Number? = null): Boolean
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
@JsName("Phaser.Graphics")
        external open class Graphics(game: Phaser.Game, x: Number? = null, y: Number? = null) : PIXI.Graphics() {
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
            open var position: Phaser.Point
            open var previousPosition: Phaser.Point
            open var previousRotation: Number
            open var renderOrderID: Number
            open var right: Number
            open var top: Number
            open var type: Number
            open var world: Phaser.Point
            override var width: Double
            open var z: Number
            open fun alignIn(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun destroy(destroyChildren: Boolean? = null): Unit
            open fun drawTriangle(points: Array<Phaser.Point>, cull: Boolean? = null): Unit
            open fun drawTriangles(vertices: Array<Phaser.Point>, indices: Array<Number>? = null, cull: Boolean? = null): Unit
            open fun drawTriangles(vertices: Array<Number>, indices: Array<Number>? = null, cull: Boolean? = null): Unit
            open fun kill(): Phaser.Graphics
            open fun postUpdate(): Unit
            open fun preUpdate(): Unit
            open fun reset(x: Number, y: Number, health: Number? = null): Phaser.Graphics
            open fun revive(health: Number? = null): Phaser.Graphics
            open fun update(): Unit
        }
@JsName("Phaser.Group")
        external open class Group(game: Phaser.Game, parent: PIXI.DisplayObjectContainer? = null, name: String? = null, addToStage: Boolean? = null, enableBody: Boolean? = null, physicsBodyType: Number? = null) : PIXI.DisplayObjectContainer() {
            override var alpha: Number
            open var angle: Number
            open var alive: Boolean
            open var bottom: Number
            open var cameraOffset: Phaser.Point
            open var centerX: Double
            open var centerY: Double
            open var classType: Any
            open var cursor: Any
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
            open var onChildInputDown: Phaser.Signal
            open var onChildInputUp: Phaser.Signal
            open var onChildInputOver: Phaser.Signal
            open var onChildInputOut: Phaser.Signal
            open var onDestroy: Phaser.Signal
            open var pendingDestroy: Boolean
            open var physicsBodyType: Number
            open var physicsType: Number
            open var physicsSortDirection: Number
            open var position: Phaser.Point
            open var right: Number
            override var rotation: Double
            open var scale: Phaser.Point
            open var top: Number
            open var total: Number
            open var type: Number
            override var visible: Boolean
            open var z: Number
            open fun add(child: Any, silent: Boolean? = null, index: Number? = null): Any
            open fun addAll(property: String, amount: Number, checkAlive: Boolean, checkVisible: Boolean): Unit
            open fun addAt(child: Any, index: Number, silent: Boolean? = null): Any
            open fun addMultiple(children: Array<Any>, silent: Boolean? = null): Array<Any>
            open fun addToHash(child: PIXI.DisplayObject): Boolean
            open fun align(width: Number, height: Number, cellWidth: Number, cellHeight: Number, position: Number? = null, offset: Number? = null): Boolean
            open fun alignIn(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignIn(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignIn(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignIn(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignIn(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignIn(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignIn(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignIn(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignTo(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignTo(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignTo(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignTo(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignTo(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignTo(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignTo(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun alignTo(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Group
            open fun bringToTop(child: Any): Any
            open fun callAll(method: String, context: Any?, vararg parameters: Any): Unit
            open fun callAllExists(callback: String, existsValue: Boolean, vararg parameters: Any): Unit
            open fun callbackFromArray(child: Any, callback: Function<Any>, length: Number): Unit
            open fun checkAll(key: Array<String>, value: Any, checkAlive: Boolean? = null, checkVisible: Boolean? = null, force: Boolean? = null): Boolean
            open fun checkProperty(child: Any, key: Array<String>, value: Any, force: Boolean? = null): Boolean
            open fun countDead(): Number
            open fun countLiving(): Number
            //open fun create(x: Number, y: Number, key: String? = null, frame: String? = null, exists: Boolean? = null, index: Number? = null): DisplayObject
            open fun <T>create(x: Number, y: Number, key: String?): T
            open fun <T>create(x: Number, y: Number, key: String? = null, frame: Number? = null, exists: Boolean? = null, index: Number? = null): T
            open fun <T>create(x: Number, y: Number, key: String? = null, frame: String? = null, exists: Boolean? = null, index: Number? = null): T
            open fun <T>create(x: Number, y: Number, key: Phaser.RenderTexture? = null, frame: String? = null, exists: Boolean? = null, index: Number? = null): T
            open fun <T>create(x: Number, y: Number, key: Phaser.RenderTexture? = null, frame: Number? = null, exists: Boolean? = null, index: Number? = null): T
            open fun <T>create(x: Number, y: Number, key: Phaser.BitmapData? = null, frame: String? = null, exists: Boolean? = null, index: Number? = null): T
            open fun <T>create(x: Number, y: Number, key: Phaser.BitmapData? = null, frame: Number? = null, exists: Boolean? = null, index: Number? = null): T
            open fun <T>create(x: Number, y: Number, key: Phaser.Video? = null, frame: String? = null, exists: Boolean? = null, index: Number? = null): T
            open fun <T>create(x: Number, y: Number, key: Phaser.Video? = null, frame: Number? = null, exists: Boolean? = null, index: Number? = null): T
            open fun <T>create(x: Number, y: Number, key: PIXI.Texture? = null, frame: String? = null, exists: Boolean? = null, index: Number? = null): T
            open fun <T>create(x: Number, y: Number, key: PIXI.Texture? = null, frame: Number? = null, exists: Boolean? = null, index: Number? = null): T
            open fun createMultiple(quantity: Number, key: String, frame: Any? = null, exists: Boolean? = null): Array<Any>
            open fun createMultiple(quantity: Number, key: String, frame: Array<Any>? = null, exists: Boolean? = null): Array<Any>
            open fun createMultiple(quantity: Number, key: Array<String>, frame: Any? = null, exists: Boolean? = null): Array<Any>
            open fun createMultiple(quantity: Number, key: Array<String>, frame: Array<Any>? = null, exists: Boolean? = null): Array<Any>
            open fun customSort(sortHandler: Function<Any>, context: Any? = null): Unit
            open fun destroy(destroyChildren: Boolean? = null, soft: Boolean? = null): Unit
            open fun divideAll(property: String, amount: Number, checkAlive: Boolean? = null, checkVisible: Boolean? = null): Unit
            open fun forEach(callback: Function<Any>, callbackContext: Any, checkExists: Boolean? = null, vararg args: Any): Unit
            open fun forEachAlive(callback: Function<Any>, callbackContext: Any? = null, vararg args: Any): Unit
            open fun forEachDead(callback: Function<Any>, callbackContext: Any? = null, vararg args: Any): Unit
            open fun forEachExists(callback: Function<Any>, callbackContext: Any? = null): Unit
            open fun filter(predicate: Function<Any>, checkExists: Boolean? = null): ArraySet
            open fun getAt(index: Number): dynamic /* PIXI.DisplayObject | Number */
            open fun getBottom(): Any
            open fun getByName(name: String): Any
            open fun getClosestTo(`object`: Any, callback: Function<Any>? = null, callbackContext: Any? = null): Any
            open fun getFirstAlive(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: String? = null, frame: String? = null): Any
            open fun getFirstAlive(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: String? = null, frame: Number? = null): Any
            open fun getFirstAlive(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.RenderTexture? = null, frame: String? = null): Any
            open fun getFirstAlive(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.RenderTexture? = null, frame: Number? = null): Any
            open fun getFirstAlive(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.BitmapData? = null, frame: String? = null): Any
            open fun getFirstAlive(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.BitmapData? = null, frame: Number? = null): Any
            open fun getFirstAlive(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.Video? = null, frame: String? = null): Any
            open fun getFirstAlive(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.Video? = null, frame: Number? = null): Any
            open fun getFirstAlive(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: PIXI.Texture? = null, frame: String? = null): Any
            open fun getFirstAlive(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: PIXI.Texture? = null, frame: Number? = null): Any
            open fun getFirstDead(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: String? = null, frame: String? = null): Any
            open fun getFirstDead(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: String? = null, frame: Number? = null): Any
            open fun getFirstDead(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.RenderTexture? = null, frame: String? = null): Any
            open fun getFirstDead(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.RenderTexture? = null, frame: Number? = null): Any
            open fun getFirstDead(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.BitmapData? = null, frame: String? = null): Any
            open fun getFirstDead(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.BitmapData? = null, frame: Number? = null): Any
            open fun getFirstDead(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.Video? = null, frame: String? = null): Any
            open fun getFirstDead(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.Video? = null, frame: Number? = null): Any
            open fun getFirstDead(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: PIXI.Texture? = null, frame: String? = null): Any
            open fun getFirstDead(createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: PIXI.Texture? = null, frame: Number? = null): Any
            open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: String? = null, frame: String? = null): Any
            open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: String? = null, frame: Number? = null): Any
            open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.RenderTexture? = null, frame: String? = null): Any
            open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.RenderTexture? = null, frame: Number? = null): Any
            open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.BitmapData? = null, frame: String? = null): Any
            open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.BitmapData? = null, frame: Number? = null): Any
            open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.Video? = null, frame: String? = null): Any
            open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: Phaser.Video? = null, frame: Number? = null): Any
            open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: PIXI.Texture? = null, frame: String? = null): Any
            open fun getFirstExists(exists: Boolean, createIfNull: Boolean? = null, x: Number? = null, y: Number? = null, key: PIXI.Texture? = null, frame: Number? = null): Any
            open fun getFurthestFrom(`object`: Any, callback: Function<Any>? = null, callbackContext: Any? = null): Any
            open fun getIndex(child: Any): Number
            open fun getRandom(startIndex: Number? = null, length: Number? = null): Any
            open fun getTop(): Any
            open fun hasProperty(child: Any, key: Array<String>): Boolean
            open fun iterate(key: String, value: Any, returnType: Number, callback: Function<Any>? = null, callbackContext: Any? = null, vararg args: Any): Any
            open fun moveAll(group: Phaser.Group, silent: Boolean? = null): Phaser.Group
            open fun moveDown(child: Any): Any
            open fun moveUp(child: Any): Any
            open fun multiplyAll(property: String, amount: Number, checkAlive: Boolean, checkVisible: Boolean): Unit
            open fun next(): Any
            open fun postUpdate(): Unit
            open fun preUpdate(): Unit
            open fun previous(): Unit
            open fun remove(child: Any, destroy: Boolean? = null, silent: Boolean? = null): Boolean
            open fun removeAll(destroy: Boolean? = null, silent: Boolean? = null, destroyTexture: Boolean? = null): Unit
            open fun removeBetween(startIndex: Number, endIndex: Number? = null, destroy: Boolean? = null, silent: Boolean? = null): Unit
            open fun removeFromHash(child: PIXI.DisplayObject): Boolean
            open fun replace(oldChild: Any, newChild: Any): Any
            open fun resetChild(child: Any, x: Number? = null, y: Number? = null, key: String? = null, frame: String? = null): Any
            open fun resetChild(child: Any, x: Number? = null, y: Number? = null, key: String? = null, frame: Number? = null): Any
            open fun resetChild(child: Any, x: Number? = null, y: Number? = null, key: Phaser.RenderTexture? = null, frame: String? = null): Any
            open fun resetChild(child: Any, x: Number? = null, y: Number? = null, key: Phaser.RenderTexture? = null, frame: Number? = null): Any
            open fun resetChild(child: Any, x: Number? = null, y: Number? = null, key: Phaser.BitmapData? = null, frame: String? = null): Any
            open fun resetChild(child: Any, x: Number? = null, y: Number? = null, key: Phaser.BitmapData? = null, frame: Number? = null): Any
            open fun resetChild(child: Any, x: Number? = null, y: Number? = null, key: Phaser.Video? = null, frame: String? = null): Any
            open fun resetChild(child: Any, x: Number? = null, y: Number? = null, key: Phaser.Video? = null, frame: Number? = null): Any
            open fun resetChild(child: Any, x: Number? = null, y: Number? = null, key: PIXI.Texture? = null, frame: String? = null): Any
            open fun resetChild(child: Any, x: Number? = null, y: Number? = null, key: PIXI.Texture? = null, frame: Number? = null): Any
            open fun resetCursor(index: Number? = null): Any
            open fun reverse(): Unit
            open fun sendToBack(child: Any): Any
            open fun set(child: Any, key: Array<String>, value: Any, operation: Number? = null, force: Boolean? = null): Boolean
            open fun setAll(key: String, value: Any, checkAlive: Boolean? = null, checkVisible: Boolean? = null, operation: Number? = null, force: Boolean? = null): Unit
            open fun setAllChildren(key: String, value: Any, checkAlive: Boolean? = null, checkVisible: Boolean? = null, operation: Number? = null, force: Boolean? = null): Unit
            open fun setProperty(child: Any, key: Array<String>, value: Any, operation: Number? = null, force: Boolean? = null): Boolean
            open fun sort(key: String? = null, order: Number? = null): Unit
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
@JsName("Phaser.Image")
        external open class Image(game: Phaser.Game, x: Number, y: Number, key: Any, frame: Any? = null): PIXI.Sprite(null) {
            /*constructor(game: Phaser.Game, x: Number, y: Number, key: String, frame: String? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: String, frame: Number? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture, frame: String? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture, frame: Number? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData, frame: String? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData, frame: Number? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture, frame: String? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture, frame: Number? = null)*/
            open var alive: Boolean
            open var angle: Number
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
            open var position: Phaser.Point
            open var previousPosition: Phaser.Point
            open var previousRotation: Number
            open var renderOrderID: Number
            open var right: Number
            open var scale: Phaser.Point
            open var smoothed: Boolean
            open var top: Number
            open var type: Number
            open var world: Phaser.Point
            open var z: Number
            open fun alignIn(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun bringToTop(): Phaser.Image
            open fun crop(rect: Phaser.Rectangle, copy: Boolean? = null): Unit
            open fun destroy(destroyChildren: Boolean? = null): Unit
            open fun kill(): Phaser.Image
            open fun loadTexture(key: String, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: String, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.RenderTexture, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.RenderTexture, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.BitmapData, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.BitmapData, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.Video, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.Video, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: PIXI.Texture, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: PIXI.Texture, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
            open fun moveDown(): Phaser.Image
            open fun moveUp(): Phaser.Image
            open fun overlap(displayObject: Phaser.Sprite): Boolean
            open fun overlap(displayObject: Phaser.Image): Boolean
            open fun overlap(displayObject: Phaser.TileSprite): Boolean
            open fun overlap(displayObject: Phaser.Button): Boolean
            open fun overlap(displayObject: PIXI.DisplayObject): Boolean
            open fun play(name: String, frameRate: Number? = null, loop: Boolean? = null, killOnComplete: Boolean? = null): Phaser.Animation
            open fun postUpdate(): Unit
            open fun preUpdate(): Unit
            open fun reset(x: Number, y: Number, health: Number? = null): Phaser.Image
            open fun resetFrame(): Unit
            open fun revive(health: Number? = null): Phaser.Image
            open fun sendToBack(): Phaser.Image
            open fun setFrame(frame: Phaser.Frame): Unit
            open fun update(): Unit
            open fun updateCrop(): Unit
        }
@JsName("Phaser.ImageCollection")
        external open class ImageCollection(name: String, firstgid: Number, width: Number? = null, height: Number? = null, margin: Number? = null, spacing: Number? = null, properties: Any? = null) {
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
@JsName("Phaser.Input")
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
            open var onHold: Phaser.Signal
            open var onTap: Phaser.Signal
            open var onUp: Phaser.Signal
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
            open var x: Number
            open var y: Number
            open fun addPointer(): Phaser.Pointer
            open fun addMoveCallback(callback: Function<Any>, context: Any): Number
            open fun boot(): Unit
            open fun countActivePointers(limit: Number? = null): Number
            open fun deleteMoveCallback(callback: Function<Any>, context: Any? = null): Unit
            open fun destroy(): Unit
            open fun getLocalPosition(displayObject: Any, pointer: Phaser.Pointer): Phaser.Point
            open fun getPointer(isActive: Boolean? = null): Phaser.Pointer
            open fun getPointerFromId(pointerID: Number): Phaser.Pointer
            open fun getPointerFromIdentifier(identifier: Number): Phaser.Pointer
            open fun hitTest(displayObject: PIXI.DisplayObject, pointer: Phaser.Pointer, localPoint: Phaser.Point): Unit
            open fun reset(hard: Boolean? = null): Unit
            open fun resetSpeed(x: Number, y: Number): Unit
            open fun setInteractiveCandidateHandler(callback: Function<Any>, context: Any? = null): Unit
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
@JsName("Phaser.InputHandler")
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
            open fun checkPixel(x: Number, y: Number, pointer: Phaser.Pointer? = null): Boolean
            open fun checkPointerDown(pointer: Phaser.Pointer, fastTest: Boolean? = null): Boolean
            open fun checkPointerOver(pointer: Phaser.Pointer, fastTest: Boolean? = null): Boolean
            open fun destroy(): Unit
            open fun disableDrag(): Unit
            open fun disableSnap(): Unit
            open fun downDuration(pointerId: Number? = null): Number
            open fun enableDrag(lockCenter: Boolean? = null, bringToTop: Boolean? = null, pixelPerfect: Boolean? = null, alphaThreshold: Number? = null, boundsRect: Phaser.Rectangle? = null, boundsSprite: Phaser.Sprite? = null): Unit
            open fun enableSnap(snapX: Number, snapY: Number, onDrag: Boolean? = null, onRelease: Boolean? = null, snapOffsetX: Number? = null, snapOffsetY: Number? = null): Unit
            open fun isPixelPerfect(): Boolean
            open fun justOut(pointerId: Number? = null, delay: Number? = null): Boolean
            open fun justOver(pointerId: Number? = null, delay: Number? = null): Boolean
            open fun justPressed(pointerId: Number? = null, delay: Number? = null): Boolean
            open fun justReleased(pointerId: Number? = null, delay: Number? = null): Boolean
            open fun overDuration(pointerId: Number? = null): Number
            open fun pointerDown(pointerId: Number? = null): Boolean
            open fun pointerDragged(pointerId: Number? = null): Boolean
            open fun pointerOut(pointerId: Number? = null): Boolean
            open fun pointerOver(pointerId: Number? = null): Boolean
            open fun pointerTimeDown(pointerId: Number? = null): Number
            open fun pointerTimeOut(pointerId: Number? = null): Number
            open fun pointerTimeOver(pointerId: Number? = null): Number
            open fun pointerTimeUp(pointerId: Number? = null): Number
            open fun pointerUp(pointerId: Number? = null): Boolean
            open fun pointerX(pointerId: Number? = null): Number
            open fun pointerY(pointerId: Number? = null): Number
            open fun reset(): Unit
            open fun setDragLock(allowHorizontal: Boolean? = null, allowVertical: Boolean? = null): Unit
            open fun start(priority: Number, useHandCursor: Boolean): Phaser.Sprite
            open fun startDrag(pointer: Phaser.Pointer): Unit
            open fun stop(): Unit
            open fun stopDrag(pointer: Phaser.Pointer): Unit
            open fun update(pointer: Phaser.Pointer): Unit
            open fun updateDrag(pointer: Phaser.Pointer): Boolean
            open fun validForInput(highestID: Number, highestRenderID: Number, includePixelPerfect: Boolean? = null): Boolean
        }
@JsName("Phaser.Key")
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
            open fun downDuration(duration: Number? = null): Boolean
            open fun processKeyDown(event: KeyboardEvent): Unit
            open fun processKeyUp(event: KeyboardEvent): Unit
            open fun reset(hard: Boolean? = null): Unit
            open fun update(): Unit
            open fun upDuration(duration: Number? = null): Boolean
        }
@JsName("Phaser.Keyboard")
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
            open fun addCallbacks(context: Any, onDown: Function<Any>? = null, onUp: Function<Any>? = null, onPress: Function<Any>? = null): Unit
            open fun addKey(keycode: Number): Phaser.Key
            open fun addKeys(keys: Any): Any
            open fun addKeyCapture(keycode: Any): Unit
            open fun createCursorKeys(): Phaser.CursorKeys
            open fun clearCaptures(): Unit
            open fun destroy(): Unit
            open fun downDuration(keycode: Number, duration: Number? = null): Boolean
            open fun isDown(keycode: Number): Boolean
            open fun processKeyDown(event: KeyboardEvent): Unit
            open fun processKeyPress(event: KeyboardEvent): Unit
            open fun processKeyUp(event: KeyboardEvent): Unit
            open fun removeKey(keycode: Number): Unit
            open fun removeKeyCapture(keycode: Number): Unit
            open fun reset(hard: Boolean? = null): Unit
            open fun start(): Unit
            open fun stop(): Unit
            open fun update(): Unit
            open fun upDuration(keycode: Number, duration: Number? = null): Boolean
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
@JsName("Phaser.KeyCode")
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
@JsName("Phaser.Line")
        external open class Line(x1: Number? = null, y1: Number? = null, x2: Number? = null, y2: Number? = null) {
            open var angle: Number
            open var end: Phaser.Point
            open var height: Number
            open var left: Number
            open var length: Number
            open var normalAngle: Number
            open var normalX: Number
            open var normalY: Number
            open var perpSlope: Number
            open var right: Number
            open var slope: Number
            open var start: Phaser.Point
            open var top: Number
            open var type: Number
            open var width: Number
            open var x: Number
            open var y: Number
            open fun centerOn(x: Number, y: Number): Phaser.Line
            open fun clone(output: Phaser.Line): Phaser.Line
            open fun coordinatesOnLine(stepRate: Number, results: Array<Any>): Array<Any>
            open fun fromAngle(x: Number, y: Number, angle: Number, length: Number): Phaser.Line
            open fun fromSprite(startSprite: Phaser.Sprite, endSprite: Phaser.Sprite, useCenter: Boolean? = null): Phaser.Line
            open fun intersects(line: Phaser.Line, asSegment: Boolean? = null, result: Phaser.Point? = null): Phaser.Point
            open fun midPoint(out: Phaser.Point? = null): Phaser.Point
            open fun pointOnLine(x: Number, y: Number): Boolean
            open fun pointOnSegment(x: Number, y: Number): Boolean
            open fun random(out: Phaser.Point? = null): Phaser.Point
            open fun reflect(line: Phaser.Line): Number
            open fun rotate(angle: Number, asDegrees: Boolean? = null): Phaser.Line
            open fun rotateAround(x: Number, y: Number, angle: Number, asDegrees: Boolean? = null): Phaser.Line
            open fun setTo(x1: Number? = null, y1: Number? = null, x2: Number? = null, y2: Number? = null): Phaser.Line
            companion object {
                fun intersectsPoints(a: Phaser.Point, b: Phaser.Point, e: Phaser.Point, f: Phaser.Point, asSegment: Boolean? = null, result: Phaser.Point? = null): Phaser.Point
                fun intersects(a: Phaser.Line, b: Phaser.Line, asSegment: Boolean? = null, result: Phaser.Point? = null): Phaser.Point
                fun intersectsRectangle(line: Phaser.Line, rect: Phaser.Rectangle): Boolean
                fun reflect(a: Phaser.Line, b: Phaser.Line): Number
            }
        }
@JsName("Phaser.LinkedList")
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
@JsName("Phaser.Loader")
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
            open var onFileComplete: Phaser.Signal
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
            open fun asyncComplete(file: Any, errorMessage: String? = null): Unit
            open fun addSyncPoint(type: String, key: String): Phaser.Loader
            open fun addToFileList(type: String, key: String, url: String? = null, properties: Any? = null, overwrite: Boolean? = null, extension: String? = null): Phaser.Loader
            open fun atlas(key: String, textureURL: String? = null, atlasURL: String? = null, atlasData: Any? = null, format: Number? = null): Phaser.Loader
            open fun atlasJSONArray(key: String, textureURL: String? = null, atlasURL: String? = null, atlasData: Any? = null): Phaser.Loader
            open fun atlasJSONHash(key: String, textureURL: String? = null, atlasURL: String? = null, atlasData: Any? = null): Phaser.Loader
            open fun atlasXML(key: String, textureURL: String? = null, atlasURL: String? = null, atlasData: Any? = null): Phaser.Loader
            open fun audio(key: String, urls: String, autoDecode: Boolean? = null): Phaser.Loader
            open fun audio(key: String, urls: Array<String>, autoDecode: Boolean? = null): Phaser.Loader
            open fun audio(key: String, urls: Any, autoDecode: Boolean? = null): Phaser.Loader
            open fun audiosprite(key: String, url: String, jsonURL: String? = null, jsonData: String? = null, autoDecode: Boolean? = null): Phaser.Loader
            open fun audiosprite(key: String, urls: Array<String>, jsonURL: String? = null, jsonData: String? = null, autoDecode: Boolean? = null): Phaser.Loader
            open fun audiosprite(key: String, urls: Array<String>, jsonURL: String? = null, jsonData: Any? = null, autoDecode: Boolean? = null): Phaser.Loader
            open fun binary(key: String, url: String? = null, callback: Function<Any>? = null, callbackContext: Any? = null): Phaser.Loader
            open fun bitmapFont(key: String, textureURL: String? = null, atlasURL: String? = null, atlasData: Any? = null, xSpacing: Number? = null, ySpacing: Number? = null): Phaser.Loader
            open fun checkKeyExists(type: String, key: String): Boolean
            open fun csvLoadComplete(file: Any, xhr: XMLHttpRequest): Unit
            open fun fileComplete(file: Any, xhr: XMLHttpRequest): Unit
            open fun fileError(file: Any, xhr: XMLHttpRequest, reason: String): Unit
            open fun finishedLoading(abnormal: Boolean? = null): Unit
            open fun getAsset(type: String, key: String): Any
            open fun getAssetIndex(type: String, key: String): Number
            open fun getAudioURL(urls: Array<Any>): Unit
            open fun image(key: String, url: String? = null, overwrite: Boolean? = null): Phaser.Loader
            open fun image(key: String, url: Any? = null, overwrite: Boolean? = null): Phaser.Loader
            open fun images(keys: Array<String>, urls: Array<String>? = null): Phaser.Loader
            open fun json(key: String, url: String? = null, overwrite: Boolean? = null): Phaser.Loader
            open fun jsonLoadComplete(file: Any, xhr: XMLHttpRequest): Unit
            open fun loadAudioTag(file: Any): Unit
            open fun loadFile(file: Any): Unit
            open fun loadImageTag(file: Any): Unit
            open fun pack(key: String, url: String? = null, data: Any? = null, callbackContext: Any? = null): Phaser.Loader
            open fun parseXml(data: String): XMLDocument
            open fun physics(key: String, url: String? = null, data: Any? = null, format: String? = null): Phaser.Loader
            open fun processLoadQueue(): Unit
            open fun processPack(pack: Any): Unit
            open fun removeAll(): Unit
            open fun removeFile(type: String, key: String): Unit
            open fun replaceInFileList(type: String, key: String, url: String, properties: Any): Unit
            open fun reset(hard: Boolean? = null, clearEvents: Boolean? = null): Unit
            open fun resize(): Unit
            open fun script(key: String, url: String? = null, callback: Function<Any>? = null, callbackContext: Any? = null): Phaser.Loader
            open fun shader(key: String, url: String? = null, overwrite: Boolean? = null): Phaser.Loader
            open fun setPreloadSprite(sprite: Phaser.Sprite, direction: Number? = null): Unit
            open fun setPreloadSprite(sprite: Phaser.Image, direction: Number? = null): Unit
            open fun spritesheet(key: String, url: String, frameWidth: Number, frameHeight: Number, frameMax: Number? = null, margin: Number? = null, spacing: Number? = null, skipFrames: Number? = null): Phaser.Loader
            open fun start(): Unit
            open fun text(key: String, url: String? = null, overwrite: Boolean? = null): Phaser.Loader
            open fun texture(key: String, `object`: Any, overwrite: Boolean? = null): Phaser.Loader
            open fun tilemap(key: String, url: String? = null, data: Any? = null, format: Number? = null): Phaser.Loader
            open fun totalLoadedFiles(): Number
            open fun totalLoadedPacks(): Number
            open fun totalQueuedFiles(): Number
            open fun totalQueuedPacks(): Number
            open fun transformUrl(url: String, file: Any? = null): String
            open fun updateProgress(): Unit
            open fun video(key: String, urls: String, loadEvent: String? = null, asBlob: Boolean? = null): Phaser.Loader
            open fun video(key: String, urls: Array<String>, loadEvent: String? = null, asBlob: Boolean? = null): Phaser.Loader
            open fun video(key: String, urls: Any, loadEvent: String? = null, asBlob: Boolean? = null): Phaser.Loader
            open fun withSyncPoint(callback: Function<Any>, callbackContext: Any? = null): Phaser.Loader
            open fun xml(key: String, url: String? = null, overwrite: Boolean? = null): Phaser.Loader
            open fun xhrLoad(file: Any, url: String, type: String, onload: Function<Any>, onerror: Function<Any>? = null): Unit
            open fun xhrLoadWithXDR(file: Any, url: String, type: String, onload: Function<Any>, onerror: Function<Any>? = null): Unit
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
@JsName("Phaser.LoaderParser")
        external open class LoaderParser {
            companion object {
                fun bitmapFont(xml: Any, baseTexture: PIXI.BaseTexture, xSpacing: Number? = null, ySpacing: Number? = null): Any
                fun xmlBitmapFont(xml: Any, baseTexture: PIXI.BaseTexture, xSpacing: Number? = null, ySpacing: Number? = null, frame: Phaser.Frame? = null): Any
                fun jsonBitmapFont(json: Any, baseTexture: PIXI.BaseTexture, xSpacing: Number? = null, ySpacing: Number? = null, frame: Phaser.Frame? = null): Any
            }
        }
/*@JsName("Phaser.Matrix")
        external open class Matrix(a: Number? = null, b: Number? = null, c: Number? = null, d: Number? = null, tx: Number? = null, ty: Number? = null) : PIXI.Matrix() {
            override var a: Number
            override var b: Number
            override var c: Number
            override var d: Number
            override var tx: Number
            override var ty: Number
            open var type: Number
            open fun apply(pos: Phaser.Point, newPos: Phaser.Point? = null): Phaser.Point
            open fun applyInverse(pos: Phaser.Point, newPos: Phaser.Point? = null): Phaser.Point
            open fun clone(output: Phaser.Matrix? = null): Phaser.Matrix
            open fun copyFrom(matrix: Phaser.Matrix): Phaser.Matrix
            open fun copyTo(matrix: Phaser.Matrix): Phaser.Matrix
            override fun fromArray(array: Array<Number>): Phaser.Matrix
            open fun setTo(a: Number, b: Number, c: Number, d: Number, tx: Number, ty: Number): Phaser.Matrix
            open fun toArray(transpose: Boolean? = null, array: Array<Number>? = null): Array<Number>
            override fun translate(x: Number, y: Number): Phaser.Matrix
            override fun scale(x: Number, y: Number): Phaser.Matrix
            override fun rotate(angle: Number): Phaser.Matrix
            open fun append(matrix: Phaser.Matrix): Phaser.Matrix
            override fun identity(): Phaser.Matrix
        }*/
        interface `T$3` {
            var sin: Array<Number>
            var cos: Array<Number>
        }
@JsName("Phaser.Math")
        external open class Math {
            companion object {
                fun angleBetween(x1: Number, y1: Number, x2: Number, y2: Number): Number
                fun angleBetweenPoints(point1: Phaser.Point, point2: Phaser.Point): Number
                fun angleBetweenY(x1: Number, y1: Number, x2: Number, y2: Number): Number
                fun angleBetweenPointsY(point1: Phaser.Point, point2: Phaser.Point): Number
                fun average(vararg numbers: Number): Number
                fun bernstein(n: Number, i: Number): Number
                fun random(min: Number, max: Number): Number
                fun between(min: Number, max: Number): Number
                fun bezierInterpolation(v: Array<Number>, k: Number): Number
                fun catmullRom(p0: Number, p1: Number, p2: Number, p3: Number, t: Number): Number
                fun catmullRomInterpolation(v: Array<Number>, k: Number): Number
                fun ceilTo(value: Number, place: Number? = null, base: Number? = null): Number
                fun clamp(x: Number, a: Number, b: Number): Number
                fun clampBottom(x: Number, a: Number): Number
                fun degToRad(degrees: Number): Number
                fun difference(a: Number, b: Number): Number
                fun distance(x1: Number, y1: Number, x2: Number, y2: Number): Number
                fun distanceSq(x1: Number, y1: Number, x2: Number, y2: Number): Number
                fun distancePow(xy: Number, y1: Number, x2: Number, y2: Number, pow: Number? = null): Number
                fun factorial(value: Number): Number
                fun floorTo(value: Number, place: Number, base: Number): Number
                fun fuzzyCeil(`val`: Number, epsilon: Number? = null): Boolean
                fun fuzzyEqual(a: Number, b: Number, epsilon: Number? = null): Boolean
                //fun fuzzyLessThan(a: Number, b: Number, epsilon: Number? = null): Boolean
                fun fuzzyFloor(`val`: Number, epsilon: Number? = null): Boolean
                fun fuzzyGreaterThan(a: Number, b: Number, epsilon: Number? = null): Boolean
                fun fuzzyLessThan(a: Number, b: Number, epsilon: Number? = null): Boolean
                fun getShortestAngle(angle1: Number, angle2: Number): Number
                fun getNextPowerOfTwo(value: Number): Number
                fun isEven(n: Number): Boolean
                fun isOdd(n: Number): Boolean
                fun isPowerOfTwo(width: Number, height: Number): Boolean
                fun linear(p0: Number, p1: Number, t: Number): Number
                fun linearInterpolation(v: Array<Number>, k: Number): Number
                fun mapLinear(x: Number, a1: Number, a2: Number, b1: Number, b2: Number): Number
                fun max(vararg numbers: Number): Number
                fun maxAdd(value: Number, amount: Number, max: Number): Number
                fun maxProperty(vararg numbers: Number): Number
                fun min(vararg numbers: Number): Number
                fun minProperty(vararg numbers: Number): Number
                fun minSub(value: Number, amount: Number, min: Number): Number
                fun normalizeAngle(angle: Number, radians: Boolean? = null): Number
                fun percent(a: Number, b: Number, base: Number? = null): Number
                fun p2px(v: Number): Number
                var PI2: Number
                fun radToDeg(radians: Number): Number
                fun reverseAngle(angleRed: Number): Number
                fun rotateToAngle(currentAngle: Number, targetAngle: Number, lerp: Number? = null): Number
                fun roundAwayFromZero(value: Number): Number
                fun roundTo(value: Number, place: Number? = null, base: Number? = null): Number
                fun shear(n: Number): Number
                fun sign(x: Number): Number
                fun sinCosGenerator(length: Number, sinAmplitude: Number? = null, cosAmplitude: Number? = null, frequency: Number? = null): `T$3`
                fun smootherstep(x: Number, min: Number, max: Number): Number
                fun smoothstep(x: Number, min: Number, max: Number): Number
                fun snapTo(input: Number, gap: Number, start: Number? = null): Number
                fun snapToCeil(input: Number, gap: Number, start: Number? = null): Number
                fun snapToFloor(input: Number, gap: Number, start: Number? = null): Number
                fun within(a: Number, b: Number, tolerance: Number): Boolean
                fun wrap(value: Number, min: Number, max: Number): Number
                fun wrapAngle(angle: Number, radians: Boolean? = null): Number
                fun wrapValue(value: Number, amount: Number, max: Number): Number
            }
        }
        interface WheelEventProxy {
            fun bindEvent(event: Any): WheelEventProxy
            var type: String
            var deltaMode: Number
            var deltaX: Number
            var deltaY: Number
            var deltaZ: Number
        }
@JsName("Phaser.Mouse")
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
/*@JsName("Phaser.MSPointer")
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
@JsName("Phaser.Net")
        external open class Net(game: Phaser.Game) {
            open var game: Phaser.Game
            open fun checkDomainName(domain: String): Boolean
            open fun decodeURI(value: String): String
            open fun getHostName(): String
            open fun getQueryString(parameter: String? = null): String
            open fun updateQueryString(key: String, value: Any, redirect: Boolean? = null, url: String? = null): String
        }
@JsName("Phaser.Particle")
        external open class Particle(game: Phaser.Game, x: Number, y: Number, key: Any? = null, frame: Any? = null) : Phaser.Sprite(game, x, y, key, frame) {
            override var fresh: Boolean
            open fun onEmit(): Unit
            override fun reset(x: Number, y: Number, health: Number?): Phaser.Particle
            open fun setAlphaData(data: Array<Any>): Unit
            open fun setScaleData(data: Array<Any>): Unit
            override fun update(): Unit
        }
@JsName("Phaser.Particles")
        external open class Particles(game: Phaser.Game) {
            open var emitters: Any
            open var game: Phaser.Game
            open var ID: Number
            open fun add(emitter: Phaser.Particles.Arcade.Emitter): Phaser.Particles.Arcade.Emitter
            open fun remove(emitter: Phaser.Particles.Arcade.Emitter): Unit
            open fun update(): Unit

            object Arcade {
                open class Emitter(game: Phaser.Game, x: Number? = null, y: Number? = null, maxParticles: Number? = null) : Phaser.Group(game) {
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
                    open fun emitParticle(x: Number? = null, y: Number? = null, key: String? = null, frame: String? = null): Boolean
                    open fun emitParticle(x: Number? = null, y: Number? = null, key: String? = null, frame: Number? = null): Boolean
                    open fun emitParticle(x: Number? = null, y: Number? = null, key: Phaser.RenderTexture? = null, frame: String? = null): Boolean
                    open fun emitParticle(x: Number? = null, y: Number? = null, key: Phaser.RenderTexture? = null, frame: Number? = null): Boolean
                    open fun emitParticle(x: Number? = null, y: Number? = null, key: Phaser.BitmapData? = null, frame: String? = null): Boolean
                    open fun emitParticle(x: Number? = null, y: Number? = null, key: Phaser.BitmapData? = null, frame: Number? = null): Boolean
                    open fun emitParticle(x: Number? = null, y: Number? = null, key: Phaser.Video? = null, frame: String? = null): Boolean
                    open fun emitParticle(x: Number? = null, y: Number? = null, key: Phaser.Video? = null, frame: Number? = null): Boolean
                    open fun emitParticle(x: Number? = null, y: Number? = null, key: PIXI.Texture? = null, frame: String? = null): Boolean
                    open fun emitParticle(x: Number? = null, y: Number? = null, key: PIXI.Texture? = null, frame: Number? = null): Boolean
                    open fun explode(lifespan: Number? = null, quantity: Number? = null): Phaser.Particles.Arcade.Emitter
                    open fun flow(lifespan: Number? = null, frequency: Number? = null, quantity: Number? = null, total: Number? = null, immediate: Boolean? = null): Phaser.Particles.Arcade.Emitter
                    open fun kill(): Phaser.Particles.Arcade.Emitter
                    open fun makeParticles(keys: Any, frames: Any? = null, quantity: Number? = null, collide: Boolean? = null, collideWorldBounds: Boolean? = null): Phaser.Particles.Arcade.Emitter
                    open fun reset(x: Number, y: Number, health: Number? = null): Phaser.Particles
                    open fun setAlpha(min: Number? = null, max: Number? = null, rate: Number? = null, ease: ((k: Number) -> Number)? = null, yoyo: Boolean? = null): Phaser.Particles.Arcade.Emitter
                    open fun setRotation(min: Number? = null, max: Number? = null): Phaser.Particles.Arcade.Emitter
                    open fun setScale(minX: Number? = null, maxX: Number? = null, minY: Number? = null, maxY: Number? = null, rate: Number? = null, ease: ((k: Number) -> Number)? = null, yoyo: Boolean? = null): Phaser.Particles.Arcade.Emitter
                    open fun setSize(width: Number, height: Number): Phaser.Particles.Arcade.Emitter
                    open fun setXSpeed(min: Number, max: Number): Phaser.Particles.Arcade.Emitter
                    open fun setYSpeed(min: Number, max: Number): Phaser.Particles.Arcade.Emitter
                    open fun start(explode: Boolean? = null, lifespan: Number? = null, frequency: Number? = null, quantity: Number? = null, forceQuantity: Boolean? = null): Phaser.Particles.Arcade.Emitter
                    override fun update(): Unit
                    open fun revive(): Phaser.Particles.Arcade.Emitter
                }
            }

        }
@JsName("Phaser.Physics")
        external open class Physics(game: Phaser.Game, config: Any? = null) {
            open var arcade: Phaser.Physics.Arcade
            open var config: Any
            open var game: Phaser.Game
            open var ninja: Phaser.Physics.Ninja
            //open var p2: Phaser.Physics.P2
            open var box2d: Any
            open fun clear(): Unit
            open fun destroy(): Unit
            open fun enable(`object`: Any, system: Number? = null, debug: Boolean? = null): Unit
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

                open class Arcade(game: Phaser.Game) {
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
                    open fun accelerationFromRotation(rotation: Number, speed: Number? = null, point: Phaser.Point? = null): Phaser.Point
                    open fun accelerateToObject(displayObject: Any, destination: Any, speed: Number? = null, xSpeedMax: Number? = null, ySpeedMax: Number? = null): Number
                    open fun accelerateToPointer(displayObject: Any, pointer: Phaser.Pointer? = null, speed: Number? = null, xSpeedMax: Number? = null, ySpeedMax: Number? = null): Number
                    open fun accelerateToXY(displayObject: Any, x: Number, y: Number, speed: Number? = null, xSpeedMax: Number? = null, ySpeedMax: Number? = null): Number
                    open fun angleBetween(source: Any, target: Any, world: Boolean? = null): Number
                    open fun angleToPointer(displayObject: Any, pointer: Phaser.Pointer? = null, world: Boolean? = null): Number
                    open fun angleToXY(displayObject: Any, x: Number, y: Number, world: Boolean? = null): Number
                    open fun collide(object1: Any, object2: Any? = null, collideCallback: Function<Any>? = null, processCallback: Function<Any>? = null, callbackContext: Any? = null): Boolean
                    open fun computeVelocity(axis: Number, body: Phaser.Physics.Arcade.Body, velocity: Number, acceleration: Number, drag: Number, max: Number? = null): Number
                    open fun distanceBetween(source: Any, target: Any, world: Boolean? = null): Number
                    open fun distanceToPointer(displayObject: Any, pointer: Phaser.Pointer? = null, world: Boolean? = null): Double
                    open fun distanceToXY(displayObject: Any, x: Number, y: Number, world: Boolean? = null): Number
                    open fun enable(`object`: Any, children: Boolean? = null): Unit
                    open fun enableBody(`object`: Any): Unit
                    open fun getObjectsAtLocation(x: Number, y: Number, group: Phaser.Group, callback: ((callbackArg: Any, `object`: Any) -> Unit)? = null, callbackContext: Any? = null, callbackArg: Any? = null): Array<Sprite>
                    open fun getOverlapX(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body): Number
                    open fun getOverlapY(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body): Number
                    open fun intersects(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body): Boolean
                    open fun moveToObject(displayObject: Any, destination: Any, speed: Number? = null, maxTime: Number? = null): Number
                    open fun moveToPointer(displayObject: Any, speed: Number? = null, pointer: Phaser.Pointer? = null, maxTime: Number? = null): Number
                    open fun moveToXY(displayObject: Any, x: Number, y: Number, speed: Number? = null, maxTime: Number? = null): Number
                    open fun overlap(object1: Any, object2: Any, overlapCallback: Function<Any>? = null, processCallback: Function<Any>? = null, callbackContext: Any? = null): Boolean
                    open fun processTileSeparationX(body: Phaser.Physics.Arcade.Body, x: Number): Boolean
                    open fun processTileSeparationY(body: Phaser.Physics.Arcade.Body, y: Number): Unit
                    open fun setBounds(x: Number, y: Number, width: Number, height: Number): Unit
                    open fun setBoundsToWorld(): Unit
                    open fun separate(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body, processCallback: Function<Any>? = null, callbackContext: Any? = null, overlapOnly: Boolean? = null): Boolean
                    open fun separateX(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body, overlapOnly: Boolean): Boolean
                    open fun separateY(body1: Phaser.Physics.Arcade.Body, body2: Phaser.Physics.Arcade.Body, overlapOnly: Boolean): Boolean
                    open fun separateTile(i: Number, body: Phaser.Physics.Arcade.Body, tile: Phaser.Tile): Boolean
                    open fun sort(group: Phaser.Group): Unit
                    open fun tileCheckX(body: Phaser.Physics.Arcade.Body, tile: Phaser.Tile): Number
                    open fun tileCheckY(body: Phaser.Physics.Arcade.Body, tile: Phaser.Tile): Number
                    open fun updateMotion(body: Phaser.Physics.Arcade.Body): Unit
                    open fun velocityFromAngle(angle: Number, speed: Number? = null, point: Phaser.Point? = null): Phaser.Point
                    open fun velocityFromRotation(rotation: Number, speed: Number? = null, point: Phaser.Point? = null): Phaser.Point
                    //companion object {
                        var SORT_NONE: Number
                        var LEFT_RIGHT: Number
                        var RIGHT_LEFT: Number
                        var TOP_BOTTOM: Number
                        var BOTTOM_TOP: Number
                        var OVERLAP_BIAS: Number
                        var TILE_BIAS: Number
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
                            open var x: Number
                            open var y: Number
                            open fun checkWorldBounds(): Unit
                            open fun deltaX(): Number
                            open fun deltaY(): Number
                            open fun deltaZ(): Number
                            open fun deltaAbsX(): Number
                            open fun deltaAbsY(): Number
                            open fun destroy(): Unit
                            open fun getBounds(obj: Any): Any
                            open fun hitTest(x: Number, y: Number): Boolean
                            open fun moveFrom(duration: Number, speed: Number? = null, direction: Number? = null): Boolean
                            open fun moveTo(duration: Number, distance: Number, direction: Number? = null): Boolean
                            open fun onFloor(): Boolean
                            open fun onWall(): Boolean
                            open fun preUpdate(): Unit
                            open fun postUpdate(): Unit
                            open fun render(context: Any, body: Phaser.Physics.Arcade.Body, color: String? = null, filled: Boolean? = null): Unit
                            open fun renderBodyInfo(debug: Phaser.Utils.Debug, body: Phaser.Physics.Arcade.Body): Unit
                            open fun reset(x: Number, y: Number): Unit
                            open fun setCircle(radius: Number, offsetX: Number? = null, offsetY: Number? = null): Unit
                            open fun setSize(width: Number, height: Number, offsetX: Number? = null, offsetY: Number? = null): Unit
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
                    //}
                }

                open class Ninja(game: Phaser.Game) {
                    open var game: Phaser.Game
                    open var gravity: Number
                    open var bounds: Phaser.Rectangle
                    open var maxObjects: Number
                    open var maxLevels: Number
                    open var quadTree: Phaser.QuadTree
                    open var time: Phaser.Time
                    open fun clearTilemapLayerBodies(map: Phaser.Tilemap, layer: Any): Unit
                    open fun collide(object1: Any, object2: Any, collideCallback: Function<Any>? = null, processCallback: Function<Any>? = null, callbackContext: Any? = null): Boolean
                    open fun convertTilemap(map: Phaser.Tilemap, layer: Any, slopeMap: Any): Array<Phaser.Physics.Ninja.Tile>
                    open fun enableAABB(`object`: Any, children: Boolean? = null): Unit
                    open fun enableCircle(`object`: Any, radius: Number, children: Boolean? = null): Unit
                    open fun enableTile(`object`: Any, id: Number, children: Boolean? = null): Unit
                    open fun enable(`object`: Any, type: Number? = null, id: Number? = null, radius: Number? = null, children: Boolean? = null): Unit
                    open fun enableBody(`object`: Any, type: Number? = null, id: Number? = null, radius: Number? = null): Unit
                    open fun overlap(object1: Any, object2: Any, overlapCallback: Function<Any>? = null, processCallback: Function<Any>? = null, callbackContext: Any? = null): Boolean
                    open fun separate(body1: Phaser.Physics.Ninja.Body, body2: Phaser.Physics.Ninja.Body, processCallback: Function<Any>? = null, callbackContext: Any? = null, overlapOnly: Boolean? = null): Boolean
                    open fun setBounds(x: Number, y: Number, width: Number, height: Number): Unit
                    open fun setBoundsToWorld(): Unit
                    //companion object {
                        open class Body(system: Phaser.Physics.Ninja, sprite: Phaser.Sprite, type: Number? = null, id: Number? = null, radius: Number? = null, x: Number? = null, y: Number? = null, width: Number? = null, height: Number? = null) {
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
                            open fun render(context: Any, body: Phaser.Physics.Ninja.Body, color: String? = null, filled: Boolean? = null): Unit
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

                        /*interface `T$5` {
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
                            open fun distance(dest: Number, round: Boolean? = null): Number
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
                        open class Tile(body: Phaser.Physics.Ninja.Body, x: Number, y: Number, width: Number, height: Number, type: Number? = null) {
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
                /*interface `T$6` {
                    var left: Phaser.Physics.P2.Body?
                    var right: Phaser.Physics.P2.Body?
                    var top: Phaser.Physics.P2.Body?
                    var bottom: Phaser.Physics.P2.Body?
                }*/

                /*open class P2(game: Phaser.Game, config: Any? = null) {
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
                    open var postBroaddphaseCallback: Function
                    open var restitution: Number
                    open var solveConstraints: Boolean
                    open var time: Any
                    open var total: Number
                    open var useElapsedTime: Boolean
                    open var walls: `T$6`
                    open var world: Phaser.Physics.P2.World
                    open fun addBody(body: Phaser.Physics.P2.Body): Boolean
                    open fun addContactMaterial(material: Phaser.Physics.P2.ContactMaterial): Phaser.Physics.P2.ContactMaterial
                    open fun <T> addConstraint(constraint: T): T
                    open fun addSpring(spring: Phaser.Physics.P2.Spring): Phaser.Physics.P2.Spring
                    open fun beginContactHandler(event: Any): Unit
                    open fun clear(): Unit
                    open fun clearTilemapLayerBodies(map: Phaser.Tilemap, layer: Any? = null): Unit
                    open fun convertCollisionObjects(map: Phaser.Tilemap, layer: Any? = null, addToWorld: Boolean? = null): Array<Phaser.Physics.P2.Body>
                    open fun convertTilemap(map: Phaser.Tilemap, layer: Any? = null, addToWorld: Boolean? = null, optimize: Boolean? = null): Array<Phaser.Physics.P2.Body>
                    open fun createBody(x: Number, y: Number, mass: Number, addToWorld: Boolean? = null, options: Phaser.Physics.P2.BodyOptions? = null, data: Array<Array<Number>>? = null): Phaser.Physics.P2.Body
                    open fun createBody(x: Number, y: Number, mass: Number, addToWorld: Boolean? = null, options: Phaser.Physics.P2.BodyOptions? = null, data: Array<Number>? = null): Phaser.Physics.P2.Body
                    open fun createCollisionGroup(group: Phaser.Group? = null): Phaser.Physics.P2.CollisionGroup
                    open fun createCollisionGroup(group: Phaser.Sprite? = null): Phaser.Physics.P2.CollisionGroup
                    open fun createContactMaterial(materialA: Phaser.Physics.P2.Material, materialB: Phaser.Physics.P2.Material, options: Phaser.Physics.P2.ContactMaterialOptions? = null): Phaser.Physics.P2.ContactMaterial
                    open fun createDistanceConstraint(bodyA: Any, bodyB: Any, distance: Number, localAnchorA: Array<Number>? = null, localAnchorB: Array<Number>? = null, maxForce: Number? = null): Phaser.Physics.P2.DistanceConstraint
                    open fun createGearConstraint(bodyA: Any, bodyB: Any, angle: Number? = null, ratio: Number? = null): Phaser.Physics.P2.GearConstraint
                    open fun createLockConstraint(bodyA: Any, bodyB: Any, offset: Array<Number>? = null, angle: Number? = null, maxForce: Number? = null): Phaser.Physics.P2.LockConstraint
                    open fun createMaterial(name: String? = null, body: Phaser.Physics.P2.Body? = null): Phaser.Physics.P2.Material
                    open fun createParticle(x: Number, y: Number, mass: Number, addToWorld: Boolean? = null, options: Phaser.Physics.P2.BodyOptions? = null, data: Array<Array<Number>>? = null): Phaser.Physics.P2.Body
                    open fun createParticle(x: Number, y: Number, mass: Number, addToWorld: Boolean? = null, options: Phaser.Physics.P2.BodyOptions? = null, data: Array<Number>? = null): Phaser.Physics.P2.Body
                    open fun createPrismaticConstraint(body: Any, bodyB: Any, lockRotation: Boolean? = null, anchorA: Array<Number>? = null, anchorB: Array<Number>? = null, axis: Float32Array? = null, maxForce: Number? = null): Phaser.Physics.P2.PrismaticConstraint
                    open fun createRevoluteConstraint(bodyA: Any, pivotA: Array<Number>, bodyB: Any, pivotB: Array<Number>, maxForce: Number? = null, worldPivot: Array<Number>? = null): Phaser.Physics.P2.RevoluteConstraint
                    open fun createRotationalSpring(bodyA: Any, bodyB: Any, restAngle: Number? = null, stiffness: Number? = null, damping: Number? = null): Phaser.Physics.P2.RotationalSpring
                    open fun createSpring(bodyA: Any, bodyB: Any, restLength: Number? = null, stiffness: Number? = null, damping: Number? = null, worldA: Array<Number>? = null, worldB: Array<Number>? = null, localA: Array<Number>? = null, localB: Array<Number>? = null): Phaser.Physics.P2.Spring
                    open fun destroy(): Unit
                    open fun enable(`object`: Any, debug: Boolean? = null, children: Boolean? = null): Unit
                    open fun enableBody(`object`: Any, debug: Boolean): Unit
                    open fun endContactHandler(event: Any): Unit
                    open fun getBodies(): Array<Phaser.Physics.P2.Body>
                    open fun getBody(`object`: Any): Phaser.Physics.P2.Body
                    open fun getConstraints(): Array<Phaser.Physics.P2.Constraint>
                    open fun getSprings(): Array<Phaser.Physics.P2.Spring>
                    open fun getContactMaterial(materialA: Phaser.Physics.P2.Material, materialB: Phaser.Physics.P2.Material): Phaser.Physics.P2.ContactMaterial
                    open fun hitTest(worldPoint: Phaser.Point, bodies: Array<Any>? = null, precision: Number? = null, filterStatic: Boolean? = null): Array<Phaser.Physics.P2.Body>
                    open fun mpx(v: Number): Number
                    open fun mpxi(v: Number): Number
                    open fun pause(): Unit
                    open fun preUpdate(): Unit
                    open fun pxm(v: Number): Number
                    open fun pxmi(v: Number): Number
                    open fun removeBody(body: Phaser.Physics.P2.Body): Phaser.Physics.P2.Body
                    open fun removeBodyNextStep(body: Phaser.Physics.P2.Body): Unit
                    open fun <T> removeConstraint(constraint: T): T
                    open fun removeContactMaterial(material: Phaser.Physics.P2.ContactMaterial): Phaser.Physics.P2.ContactMaterial
                    open fun removeSpring(spring: Phaser.Physics.P2.Spring): Phaser.Physics.P2.Spring
                    open fun reset(): Unit
                    open fun resume(): Unit
                    open fun setBounds(x: Number, y: Number, width: Number, height: Number, left: Boolean? = null, right: Boolean? = null, top: Boolean? = null, bottom: Boolean? = null, setCollisionGroup: Boolean? = null): Unit
                    open fun setBoundsToWorld(left: Boolean? = null, right: Boolean? = null, top: Boolean? = null, bottom: Boolean? = null, setCollisionGroup: Boolean? = null): Unit
                    open fun setCollisionGroup(`object`: Any, group: Phaser.Physics.P2.CollisionGroup): Unit
                    open fun setImpactEvents(state: Boolean): Unit
                    open fun setMaterial(material: Phaser.Physics.P2.Material, bodies: Array<Phaser.Physics.P2.Body>? = null): Unit
                    open fun setPostBroadphaseCallback(callback: Function<Any>, context: Any): Unit
                    open fun setWorldMaterial(material: Phaser.Physics.P2.Material, left: Boolean? = null, right: Boolean? = null, top: Boolean? = null, bottom: Boolean? = null): Unit
                    open fun toJSON(): Any
                    open fun update(): Unit
                    open fun updateBoundsCollisionGroup(setCollisionGroup: Boolean? = null): Unit
                    //companion object {
                        interface `T$7` {
                            var optimalDecomp: Boolean? //
                            var skipSimpleCheck: Boolean?
                            var removeCollinearPoints: Boolean? //
                        }
                        open class Body(game: Phaser.Game, sprite: Phaser.Sprite? = null, x: Number? = null, y: Number? = null, mass: Number? = null) {
                            open var allowSleep: Boolean
                            open var angle: Number
                            open var angularDamping: Number
                            open var angularForce: Number
                            open var angularVelocity: Number
                            open var collidesWith: Array<Phaser.Physics.P2.CollisionGroup>
                            open var collideWorldBounds: Boolean
                            open var damping: Number
                            open var data: Phaser.Physics.P2.Body
                            open var debug: Boolean
                            open var debugBody: Phaser.Physics.P2.BodyDebug
                            open var dynamic: Boolean
                            open var fixedRotation: Boolean
                            open var force: Phaser.Physics.P2.InversePointProxy
                            open var kinematic: Boolean
                            open var game: Phaser.Game
                            open var gravity: Phaser.Point
                            open var id: Number
                            open var inertia: Number
                            open var mass: Number
                            open var motionState: Number
                            open var offset: Phaser.Point
                            open var onBeginContact: Phaser.Signal
                            open var onEndContact: Phaser.Signal
                            open var rotation: Number
                            open var removeNextStep: Boolean
                            open var sprite: Phaser.Sprite
                            open var sleepSpeedLimit: Number
                            open var static: Boolean
                            open var type: Number
                            open var velocity: Phaser.Physics.P2.InversePointProxy
                            open var world: Phaser.Physics.P2
                            open var x: Number
                            open var y: Number
                            open fun addToWorld(): Unit
                            open fun addCapsule(length: Number, radius: Number, offsetX: Number? = null, offsetY: Number? = null, rotation: Number? = null): Phaser.Physics.P2.Capsule
                            open fun addCircle(radius: Number, offsetX: Number? = null, offsetY: Number? = null, rotation: Number? = null): Phaser.Physics.P2.Circle
                            open fun addFixture(fixtureData: String): Array<Phaser.Physics.P2.Shape>
                            open fun addLine(length: Number, offsetX: Number? = null, offsetY: Number? = null, rotation: Number? = null): Phaser.Physics.P2.Line
                            open fun addParticle(offsetX: Number? = null, offsetY: Number? = null, rotation: Number? = null): Phaser.Physics.P2.Particle
                            open fun addPolygon(options: `T$7`, points: Array<Array<Number>>): Boolean
                            open fun addPhaserPolygon(key: String, `object`: String): Phaser.Physics.P2.FixtureList
                            open fun addPlane(offsetX: Number? = null, offsetY: Number? = null, rotation: Number? = null): Phaser.Physics.P2.Plane
                            open fun addRectangle(width: Number, height: Number, offsetX: Number? = null, offsetY: Number? = null, rotation: Number? = null): Phaser.Physics.P2.Rectangle
                            open fun addShape(shape: Phaser.Physics.P2.Shape, offsetX: Number? = null, offsetY: Number? = null, rotation: Number? = null): Phaser.Physics.P2.Shape
                            open fun adjustCenterOfMass(): Unit
                            open fun applyDamping(dt: Number): Unit
                            open fun applyForce(force: Array<Number>, worldX: Number, worldY: Number): Unit
                            open fun applyImpulse(impulse: Array<Number>, worldX: Number, worldY: Number): Unit
                            open fun applyImpulseLocal(impulse: Array<Number>, localX: Number, localY: Number): Unit
                            open fun clearCollision(clearGroup: Boolean? = null, cleanMask: Boolean? = null, shape: Phaser.Physics.P2.Shape? = null): Unit
                            open fun clearShapes(): Unit
                            open fun collides(group: Any, callback: Function<Any>? = null, callbackContext: Any? = null, shape: Phaser.Physics.P2.Shape? = null): Unit
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
                            open fun removeCollisionGroup(group: Any, clearCallback: Boolean? = null, shape: Phaser.Physics.P2.Shape? = null): Unit
                            open fun removeFromWorld(): Unit
                            open fun removeShape(shape: Phaser.Physics.P2.Shape): Boolean
                            open fun reverse(speed: Number): Unit
                            open fun rotateLeft(speed: Number): Unit
                            open fun rotateRight(speed: Number): Unit
                            open fun reset(x: Number, y: Number, resetDamping: Boolean? = null, resetMass: Boolean? = null): Unit
                            open fun shapeChanged(): Unit
                            open fun setCircle(radius: Number, offsetX: Number? = null, offsetY: Number? = null, rotation: Number? = null): Phaser.Physics.P2.Circle
                            open fun setCollisionGroup(group: Phaser.Physics.P2.CollisionGroup, shape: Phaser.Physics.P2.Shape? = null): Unit
                            open fun setRectangle(width: Number? = null, height: Number? = null, offsetX: Number? = null, offsetY: Number? = null, rotation: Number? = null): Phaser.Physics.P2.Rectangle
                            open fun setRectangleFromSprite(sprite: Any): Phaser.Physics.P2.Rectangle
                            open fun setMaterial(material: Phaser.Physics.P2.Material, shape: Phaser.Physics.P2.Shape? = null): Unit
                            open fun setZeroDamping(): Unit
                            open fun setZeroForce(): Unit
                            open fun setZeroRotation(): Unit
                            open fun setZeroVelocity(): Unit
                            open fun toLocalFrame(out: Array<Number>, worldPoint: Array<Number>): Unit
                            open fun thrust(speed: Number): Unit
                            open fun thrustLeft(speed: Number): Unit
                            open fun thrustRight(speed: Number): Unit
                            open fun toWorldFrame(out: Array<Number>, localPoint: Array<Number>): Unit
                            open fun updateCollisionMask(shape: Phaser.Physics.P2.Shape? = null): Unit
                            companion object {
                                var DYNAMIC: Number
                                var STATIC: Number
                                var KINEMATIC: Number
                            }
                        //}
                        interface `T$8` {
                            var pixelsPerLengthUnit: Number?//
                            var debugPolygons: Boolean?//
                            var lineWidth: Number? //
                            var alpha: Number? //
                        }
                        open class BodyDebug(game: Phaser.Game, body: Phaser.Physics.P2.Body, settings: `T$8`) : Phaser.Group() {
                            open var body: Phaser.Physics.P2.Body
                            open var canvas: Phaser.Graphics
                            open var ppu: Number
                            open fun updateSpriteTransform(): Unit
                            open fun draw(): Unit
                        }
                        open class CollisionGroup(bitmask: Number) {
                            open var mask: Number
                        }
                        open class ContactMaterial : Phaser.Physics.P2.ContactMaterial()
                        open class DistanceConstraint(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body, bodyB: Phaser.Physics.P2.Body, distance: Number, maxForce: Number) : Phaser.Physics.P2.DistanceConstraint() {
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
                        open class GearConstraint(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body, bodyB: Phaser.Physics.P2.Body, angle: Number? = null, ratio: Number? = null) : Phaser.Physics.P2.GearConstraint() {
                            open var game: Phaser.Game
                            open var world: Phaser.Physics.P2
                        }
                        open class InversePointProxy(world: Phaser.Physics.P2, destination: Any) {
                            open var x: Number
                            open var y: Number
                            open var mx: Number
                            open var my: Number
                        }
                        open class LockConstraint(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body, bodyB: Phaser.Physics.P2.Body, offset: Array<Number>? = null, angle: Number? = null, maxForce: Number? = null) : Phaser.Physics.P2.LockConstraint() {
                            open var game: Phaser.Game
                            open var world: Phaser.Physics.P2
                        }
                        open class Material(name: String) : Phaser.Physics.P2.Material() {
                            open var name: String
                        }
                        open class PointProxy(world: Phaser.Physics.P2, destination: Any) {
                            open var x: Number
                            open var y: Number
                            open var mx: Number
                            open var my: Number
                        }
                        open class PrismaticConstraint(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body? = null, bodyB: Phaser.Physics.P2.Body? = null, lockRotation: Boolean? = null, anchorA: Array<Number>? = null, anchorB: Array<Number>? = null, axis: Array<Number>? = null, maxForce: Number? = null) : Phaser.Physics.P2.PrismaticConstraint() {
                            open var game: Phaser.Game
                            open var world: Phaser.Physics.P2
                        }
                        open class RevoluteConstraint(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body, pivotA: Array<Number>, bodyB: Phaser.Physics.P2.Body, pivotB: Array<Number>, maxForce: Number? = null) : Phaser.Physics.P2.RevoluteConstraint() {
                            open var game: Phaser.Game
                            open var world: Phaser.Physics.P2
                        }
                        open class Spring(world: Phaser.Physics.P2, bodyA: Phaser.Physics.P2.Body, bodyB: Phaser.Physics.P2.Body, restLength: Number? = null, stiffness: Number? = null, damping: Number? = null, worldA: Array<Number>? = null, worldB: Array<Number>? = null, localA: Array<Number>? = null, localB: Array<Number>? = null) {
                            open var data: Phaser.Physics.P2.LinearSpring
                            open var game: Phaser.Game
                            open var world: Phaser.Physics.P2
                        }
                    }
                }
                */
            //}
        }
@JsName("Phaser.Video")
        external open class Video(game: Phaser.Game, key: String? = null, url: String? = null) {
            open var game: Phaser.Game
            open var key: String
            open var video: HTMLVideoElement
            open var baseTexture: PIXI.BaseTexture
            open var texture: PIXI.Texture
            open var textureFrame: Phaser.Frame
            open var type: Number
            open var disableTextureUpload: Boolean
            open var dirty: Boolean
            open var currentTime: Number
            open var duration: Number
            open var progress: Number
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
            open var onAccess: Phaser.Signal
            open var onError: Phaser.Signal
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
            open fun addToWorld(x: Number? = null, y: Number? = null, anchorX: Number? = null, anchorY: Number? = null, scaleX: Number? = null, scaleY: Number? = null): Phaser.Image
            open fun createVideoFromBlob(blob: Blob): Phaser.Video
            open fun startMediaStream(captureAudio: Boolean? = null, width: Number? = null, height: Number? = null): Phaser.Video
            open fun createVideoFromURL(url: String, autoplay: Boolean? = null): Phaser.Video
            open fun changeSource(src: String, autoplay: Boolean? = null): Phaser.Video
            open fun connectToMediaStram(video: Any, stream: Any): Phaser.Video
            open fun destroy(): Unit
            open fun play(loop: Boolean? = null, playbackRate: Number? = null): Phaser.Video
            open fun playHandler(): Unit
            open fun render(): Unit
            open fun removeVideoElement(): Unit
            open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
            open fun setTouchLock(): Unit
            open fun grab(clear: Boolean? = null, alpha: Number? = null, blendMode: String? = null): Phaser.BitmapData
            open fun stop(): Unit
            open fun unlock(): Boolean
            open fun updateTexture(event: Any? = null, width: Number? = null, height: Number? = null): Unit
        }
/*
@JsName("Phaser.Plugin")
        external open class Plugin(game: Phaser.Game, parent: Phaser.PluginManager) : IStateCycle {
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
            companion object {
                external open class SaveCPU : Phaser.Plugin() {
                    open var renderOnFPS: Number
                    open var renderOnPointerChange: Boolean
                    open fun forceRender(): Unit
                }
                @module
                external open class AStar(parent: PIXI.DisplayObject) : Phaser.Plugin() {
                    override var parent: PIXI.DisplayObject
                    open var version: String
                    open fun findPath(startPoint: Phaser.Point, goalPoint: Phaser.Point): Phaser.Plugin.AStar.AStarPath
                    open fun isWalkable(x: Number, y: Number): Boolean
                    open fun setAStarMap(map: Phaser.Tilemap, layerName: String, tilesetName: String): Phaser.Plugin.AStar
                    companion object {
                        var VERSION: String
                        var COST_ORTHAGONAL: Number
                        var COST_DIAGAONAL: Number
                        var DISTANCE_MANHATTEN: String
                        var DISTANCE_EUCLIDIAN: String
                        external open class AStarNode(x: Number, y: Number, isWalkable: Boolean) {
                            open var x: Number
                            open var y: Number
                            open var g: Number
                            open var h: Number
                            open var f: Number
                            open var parent: Phaser.Plugin.AStar.AStarNode
                            open var travelCost: Number
                            open var walkable: Boolean
                        }
                        external open class AStarPath(nodes: Array<Phaser.Plugin.AStar.AStarNode>, start: Phaser.Plugin.AStar.AStarNode, goal: Phaser.Plugin.AStar.AStarNode) {
                            open var nodes: Array<Phaser.Plugin.AStar.AStarNode>
                            open var start: Phaser.Plugin.AStar.AStarNode
                            open var goal: Phaser.Plugin.AStar.AStarNode
                            open var visited: Array<Phaser.Plugin.AStar.AStarNode>
                        }
                    }
                }
                external open class ColorHarmony : Phaser.Plugin() {
                    open fun getAnalogousHarmony(color: Number, threshold: Number? = null): Any
                    open fun getComplementHarmony(color: Number): Number
                    open fun getSplitComplementHarmony(color: Number, threshold: Number): Any
                    open fun getTriadicHarmony(color: Number): Any
                }
                external open class CSS3Filters(parent: PIXI.DisplayObject) : Phaser.Plugin() {
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
                external open class TilemapWalker(game: Phaser.Game, map: Phaser.Tilemap, layer: Any? = null, x: Number? = null, y: Number? = null) : Phaser.Plugin() {
                    open var collides: Boolean
                    override var game: Phaser.Game
                    open var history: Boolean
                    open var facing: Number
                    open var map: Phaser.Tilemap
                    open var location: Phaser.Point
                    open var locationLayer: Number
                    open fun checkTile(x: Number, y: Number): Boolean
                    open fun getTileFromLocation(x: Number, y: Number): Phaser.Tile
                    open fun getTiles(width: Number, height: Number, center: Boolean? = null): Array<Any>
                    open fun getTileBehind(distance: Number? = null): Phaser.Tile
                    open fun getTileBehindLeft(distance: Number? = null): Phaser.Tile
                    open fun getTileBehindRight(distance: Number? = null): Phaser.Tile
                    open fun getTileAhead(distance: Number? = null): Phaser.Tile
                    open fun getTileAheadLeft(distance: Number? = null): Phaser.Tile
                    open fun getTileAheadRight(distance: Number? = null): Phaser.Tile
                    open fun getTileLeft(distance: Number): Phaser.Tile
                    open fun getTileRight(distance: Number): Phaser.Tile
                    open fun moveForward(): Boolean
                    open fun moveBackward(): Boolean
                    open fun moveLeft(): Boolean
                    open fun moveRight(): Boolean
                    open fun putTile(index: Number): Unit
                    open fun setLocation(x: Number, y: Number, layer: Any? = null): Boolean
                    open fun turnLeft(): Unit
                    open fun turnRight(): Unit
                    open fun updateLocation(x: Number, y: Number): Boolean
                }
                external open class SamplePlugin(game: Phaser.Game, parent: PIXI.DisplayObject) : Phaser.Plugin() {
                    open fun addSprite(sprite: Phaser.Sprite): Unit
                    override fun update(): Unit
                }
                external open class VirtualJoystick(game: Phaser.Game, parent: Any) : Phaser.Plugin() {
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
                    open fun init(x: Number, y: Number, diameter: Number? = null, limit: Number? = null): Unit
                    open fun move(pointer: Phaser.Pointer, x: Number, y: Number): Unit
                    override fun render(): Unit
                    open fun setVelocity(sprite: Phaser.Sprite, minSpeed: Number? = null, maxSpeed: Number? = null): Phaser.Sprite
                    open fun startDrag(): Unit
                    open fun stopDrag(nub: Phaser.Sprite, pointer: Phaser.Pointer): Unit
                    override fun update(): Unit
                }
                external open class Webcam(game: Phaser.Game, parent: PIXI.DisplayObject) : Phaser.Plugin() {
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
                @module
                external open class Juicy(game: Phaser.Game) : Phaser.Plugin() {
                    open fun createScreenFlash(color: String? = null): Phaser.Plugin.Juicy.ScreenFlash
                    open fun createTrail(length: Number? = null, color: Number? = null): Phaser.Plugin.Juicy.Trail
                    open fun overScale(`object`: Phaser.Sprite, scale: Number? = null, initialScale: Phaser.Point? = null): Unit
                    open fun jelly(`object`: Phaser.Sprite, strength: Number? = null, delay: Number? = null, initialScale: Phaser.Point? = null): Unit
                    open fun mouseStretch(`object`: Phaser.Sprite, strength: Number? = null, initialScale: Phaser.Point? = null): Unit
                    override fun update(): Unit
                    open fun shake(duration: Number? = null, strength: Number? = null): Unit
                    companion object {
                        external open class Trail(game: Phaser.Game, trailLength: Number? = null, color: Number? = null) {
                            open var target: Phaser.Sprite
                            open var trailLength: Number
                            open var trailWidth: Number
                            open var trailScaling: Boolean
                            open var trailColor: Number
                            open fun update(): Unit
                            open fun addSegment(x: Number, y: Number): Unit
                            open fun redrawSegments(offsetX: Number, offsetY: Number): Unit
                        }
                        external open class ScreenFlash(game: Phaser.Game, color: String? = null) {
                            open fun flash(maxAlpha: Number? = null, duration: Number? = null): Unit
                        }
                    }
                }
            }
        }
        interface PluginConstructorOf<T> {
            @native("new")
            fun invoke(vararg parameters: Any): T
        }
@JsName("Phaser.PluginManager")
        external open class PluginManager(game: Phaser.Game) : IStateCycle {
            open var game: Phaser.Game
            open var plugins: Array<Phaser.Plugin>
            open fun <T : Phaser.Plugin> add(plugin: PluginConstructorOf<T>, vararg parameters: Any): T
            override fun destroy(): Unit
            override fun postRender(): Unit
            open fun postUpdate(): Unit
            override fun preUpdate(): Unit
            open fun remove(plugin: Phaser.Plugin, destroy: Boolean? = null): Unit
            open fun removeAll(): Unit
            override fun render(): Unit
            override fun update(): Unit
        }
*/
@JsName("Phaser.Point")
        external open class Point(x: Number? = null, y: Number? = null) : PIXI.Point(x,y) {
            override var x: Number
            override var y: Number
            open var type: Number
            open fun add(x: Number, y: Number): Phaser.Point
            open fun angle(a: Phaser.Point, asDegrees: Boolean? = null): Number
            open fun angleSq(a: Phaser.Point): Number
            open fun clamp(min: Number, max: Number): Phaser.Point
            open fun clampX(min: Number, max: Number): Phaser.Point
            open fun clampY(min: Number, max: Number): Phaser.Point
            open fun clone(output: Phaser.Point? = null): Phaser.Point
            open fun copyFrom(source: Phaser.Point): Phaser.Point
            open fun <T> copyTo(dest: T): T
            open fun ceil(): Phaser.Point
            open fun cross(a: Phaser.Point): Number
            open fun divide(x: Number, y: Number): Phaser.Point
            open fun distance(dest: Phaser.Point, round: Boolean? = null): Number
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
            open fun rotate(x: Number, y: Number, angle: Number, asDegrees: Boolean? = null, distance: Number? = null): Phaser.Point
            open fun set(x: Number, y: Number?): Phaser.Point
            open fun set(x: Number): Phaser.Point
            open fun setMagnitude(magnitude: Number): Phaser.Point
            open fun setTo(x: Number, y: Number? = null): Phaser.Point
            open fun subtract(x: Number, y: Number): Phaser.Point
            override fun toString(): String
            companion object {
                fun add(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = null): Phaser.Point
                fun subtract(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = null): Phaser.Point
                fun multiply(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = null): Phaser.Point
                fun divide(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = null): Phaser.Point
                fun equals(a: Phaser.Point, b: Phaser.Point): Boolean
                fun angle(a: Phaser.Point, b: Phaser.Point): Number
                fun angleSq(a: Phaser.Point, b: Phaser.Point): Number
                fun negative(a: Phaser.Point, out: Phaser.Point? = null): Phaser.Point
                fun multiplyAdd(a: Phaser.Point, b: Phaser.Point, scale: Number, out: Phaser.Point? = null): Phaser.Point
                fun interpolate(a: Phaser.Point, b: Phaser.Point, alpha: Number, out: Phaser.Point? = null): Phaser.Point
                fun parse(obj: Any, xProp: String? = null, yProp: String? = null): Phaser.Point
                fun perp(a: Phaser.Point, out: Phaser.Point? = null): Phaser.Point
                fun rperp(a: Phaser.Point, out: Phaser.Point? = null): Phaser.Point
                fun distance(a: Any, b: Any, round: Boolean? = null): Number
                fun project(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = null): Phaser.Point
                fun projectUnit(a: Phaser.Point, b: Phaser.Point, out: Phaser.Point? = null): Phaser.Point
                fun normalRightHand(a: Phaser.Point, out: Phaser.Point? = null): Phaser.Point
                fun normalize(a: Phaser.Point, out: Phaser.Point? = null): Phaser.Point
                fun rotate(a: Phaser.Point, x: Number, y: Number, angle: Number, asDegrees: Boolean? = null, distance: Number? = null): Phaser.Point
                fun centroid(points: Array<Phaser.Point>, out: Phaser.Point? = null): Phaser.Point
            }
        }
@JsName("Phaser.Pointer")
        external open class Pointer(game: Phaser.Game, id: Number, pointerMode: Number? = null) {
            open var active: Boolean
            open var backButton: Phaser.DeviceButton
            open var button: Any
            open var circle: Phaser.Circle
            open var clientX: Number
            open var clientY: Number
            open var dirty: Boolean
            open var duration: Number
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
            open fun justPressed(duration: Number? = null): Boolean
            open fun justReleased(duration: Number? = null): Boolean
            open fun leave(event: Any): Unit
            open fun move(event: Any, fromClick: Boolean? = null): Unit
            open fun reset(): Unit
            open fun resetButtons(): Unit
            open fun resetMovement(): Unit
            open fun start(event: Any): Unit
            open fun stop(event: Any): Unit
            open fun swapTarget(newTarget: Phaser.InputHandler, silent: Boolean? = null): Unit
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
@JsName("Phaser.Polygon")
        external open class Polygon {
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
            open fun toNumberArray(output: Array<Number>? = null): Array<Number>
        }
        interface `T$9` {
            var x: Number
            var y: Number
            var width: Number
            var height: Number
            var subWidth: Number
            var subHeight: Number
            var right: Number
            var bottom: Number
        }
@JsName("Phaser.QuadTree")
        external open class QuadTree(x: Number, y: Number, width: Number, height: Number, maxObject: Number? = null, maxLevels: Number? = null, level: Number? = null) {
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
            open fun reset(x: Number, y: Number, width: Number, height: Number, maxObject: Number? = null, maxLevels: Number? = null, level: Number? = null): Unit
            open fun retrieve(source: Any): Array<Any>
            open fun split(): Unit
        }
@JsName("Phaser.RandomDataGenerator")
        external open class RandomDataGenerator {
            constructor(seeds: Array<Any>? = null)
            constructor(seeds: String? = null)
            open fun angle(): Number
            open fun between(min: Number, max: Number): Number
            open fun frac(): Number
            open fun integer(): Number
            open fun integerInRange(min: Number, max: Number): Number
            open fun normal(): Number
            open fun <T> pick(ary: Array<T>): T
            open fun real(): Number
            open fun realInRange(min: Number, max: Number): Number
            open fun sign(): Number
            open fun sow(seeds: Array<Any>): Unit
            open fun state(state: String? = null): String
            open fun timestamp(min: Number, max: Number): Number
            open fun uuid(): String
            open fun <T> weightedPick(ary: Array<T>): T
        }
@JsName("Phaser.Rectangle")
        external open class Rectangle(x: Number, y: Number, width: Number, height: Number) {
            open var bottom: Number
            open var bottomRight: Phaser.Point
            open var bottomLeft: Phaser.Point
            open var centerX: Number
            open var centerY: Number
            open var empty: Boolean
            open var halfHeight: Number
            open var halfWidth: Number
            open var height: Number
            open var left: Number
            open var perimeter: Number
            open var randomX: Number
            open var randomY: Number
            open var right: Number
            open var top: Number
            open var topLeft: Phaser.Point
            open var topRight: Phaser.Point
            open var type: Number
            open var volume: Number
            open var width: Number
            open var x: Number
            open var y: Number
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
            open fun getPoint(position: Number, out: Phaser.Point): Phaser.Point
            open fun inflate(dx: Number, dy: Number): Phaser.Rectangle
            open fun intersection(b: Phaser.Rectangle, out: Phaser.Rectangle): Phaser.Rectangle
            open fun intersects(b: Phaser.Rectangle, tolerance: Number): Boolean
            open fun intersectsRaw(left: Number, right: Number, top: Number, bottom: Number, tolerance: Number): Boolean
            open fun offset(dx: Number, dy: Number): Phaser.Rectangle
            open fun offsetPoint(point: Phaser.Point): Phaser.Rectangle
            open fun random(out: Phaser.Point? = null): Phaser.Point
            open fun resize(width: Number, height: Number): Phaser.Rectangle
            open fun setTo(x: Number, y: Number, width: Number, height: Number): Phaser.Rectangle
            open fun scale(x: Number, y: Number? = null): Phaser.Rectangle
            open fun size(output: Phaser.Point? = null): Phaser.Point
            override fun toString(): String
            open fun union(b: Phaser.Rectangle, out: Phaser.Rectangle? = null): Phaser.Rectangle
            companion object {
                fun aabb(points: Array<Phaser.Point>, out: Phaser.Rectangle? = null): Phaser.Rectangle
                fun clone(a: Phaser.Rectangle, output: Phaser.Rectangle? = null): Phaser.Rectangle
                fun contains(a: Phaser.Rectangle, x: Number, y: Number): Boolean
                fun containsPoint(a: Phaser.Rectangle, point: Phaser.Point): Boolean
                fun containsRaw(rx: Number, ry: Number, rw: Number, rh: Number, x: Number, y: Number): Boolean
                fun containsRect(a: Phaser.Rectangle, b: Phaser.Rectangle): Boolean
                fun equals(a: Phaser.Rectangle, b: Phaser.Rectangle): Boolean
                fun inflate(a: Phaser.Rectangle, dx: Number, dy: Number): Phaser.Rectangle
                fun inflatePoint(a: Phaser.Rectangle, point: Phaser.Point): Phaser.Rectangle
                fun intersection(a: Phaser.Rectangle, b: Phaser.Rectangle, out: Phaser.Rectangle? = null): Phaser.Rectangle
                fun intersects(a: Phaser.Rectangle, b: Phaser.Rectangle): Boolean
                fun intersectsRaw(left: Number, right: Number, top: Number, bottom: Number, tolerance: Number): Boolean
                fun size(a: Phaser.Rectangle, output: Phaser.Point? = null): Phaser.Point
                fun union(a: Phaser.Rectangle, b: Phaser.Rectangle, out: Phaser.Rectangle? = null): Phaser.Rectangle
            }
        }
@JsName("Phaser.RenderTexture")
        external open class RenderTexture(game: Phaser.Game, width: Number? = null, height: Number? = null, key: String? = null, scaleMode: Number? = null, resolution: Number? = null) {
            open var crop: PIXI.Rectangle
            open var game: Phaser.Game
            open var key: String
            open var type: Number
            //open fun render(displayObject: PIXI.DisplayObject, matrix: Phaser.Matrix? = null, clear: Boolean? = null): Unit
            open fun renderXY(displayObject: PIXI.DisplayObject, x: Number, y: Number, clear: Boolean? = null): Unit
            open fun renderRawXY(displayObject: PIXI.DisplayObject, x: Number, y: Number, clear: Boolean? = null): Unit
        }
@JsName("Phaser.RequestAnimationFrame")
        external open class RequestAnimationFrame(game: Phaser.Game, forceSetTimeOut: Boolean? = null) {
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
@JsName("Phaser.RetroFont")
        external open class RetroFont(game: Phaser.Game, key: String, characterWidth: Number, characterHeight: Number, chars: String, charsPerRow: Number? = null, xSpacing: Number? = null, ySpacing: Number? = null, xOffset: Number? = null, yOffset: Number? = null) : Phaser.RenderTexture(game) {
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
            open fun removeUnsupportedCharacters(stripCR: Boolean? = null): String
            open fun setFixedWidth(width: Number, lineAlignment: String? = null): Unit
            open fun setText(content: String, multiLine: Boolean? = null, characterSpacing: Number? = null, lineSpacing: Number? = null, lineAlignment: String? = null, allowLowerCase: Boolean? = null): Unit
            open fun updateOffset(x: Number? = null, y: Number? = null): Unit
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
@JsName("Phaser.Rope")
        external open class Rope():PIXI.Rope(null,null) {
            constructor(game: Phaser.Game, x: Number, y: Number, key: String, frame: String? = null, points: Array<Phaser.Point>? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, key: String, frame: Number? = null, points: Array<Phaser.Point>? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture, frame: String? = null, points: Array<Phaser.Point>? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture, frame: Number? = null, points: Array<Phaser.Point>? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData, frame: String? = null, points: Array<Phaser.Point>? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData, frame: Number? = null, points: Array<Phaser.Point>? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture, frame: String? = null, points: Array<Phaser.Point>? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture, frame: Number? = null, points: Array<Phaser.Point>? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.Video, frame: String? = null, points: Array<Phaser.Point>? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.Video, frame: Number? = null, points: Array<Phaser.Point>? = null):this()

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
            open var position: Phaser.Point
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
            open var z: Number
            open fun bringToTop(): Phaser.Rope
            //open fun checkTransform(wt: PIXI.Matrix): Unit
            open fun crop(rect: Phaser.Rectangle, copy: Boolean? = null): Unit
            open fun destroy(destroyChildren: Boolean? = null): Unit
            open fun kill(): Phaser.Rope
            open fun loadTexture(key: String, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: String, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.RenderTexture, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.RenderTexture, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.BitmapData, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.BitmapData, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.Video, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.Video, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: PIXI.Texture, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: PIXI.Texture, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun moveUp(): Phaser.Rope
            open fun moveDown(): Phaser.Rope
            open fun play(name: String, frameRate: Number? = null, loop: Boolean? = null, killOnComplete: Boolean? = null): Phaser.Animation
            open fun preUpdate(): Unit
            open fun postUpdate(): Unit
            open fun reset(x: Number, y: Number, health: Number? = null): Phaser.Rope
            open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
            open fun resetFrame(): Unit
            open fun revive(health: Number? = null): Phaser.Rope
            open fun sendToBack(): Phaser.Rope
            open fun setFrame(frame: Phaser.Frame): Unit
            open fun setScaleMinMax(minX: Number? = null, minY: Number? = null, maxX: Number? = null, maxY: Number? = null): Unit
            open fun updateCrop(): Unit
            open fun update(): Unit
        }
@JsName("Phaser.RoundedRectangle")
        external open class RoundedRectangle : PIXI.RoundedRectangle(null,null,null,null,null) {
            override var x: Number
            override var y: Number
            override var width: Number
            override var height: Number
            override var radius: Number
            open var type: Number
            override fun clone(): RoundedRectangle
            override fun contains(x: Number, y: Number): Boolean
        }
@JsName("Phaser.Signal")
        external open class Signal {
            open var active: Boolean
            open var boundDispatch: Function<Any>
            open var memorize: Boolean
            open fun add(listener: ()->Unit, listenerContext: Any? = null, priority: Number? = null, vararg args: Any): Phaser.SignalBinding
            open fun addOnce(listener: Function<Any>, listenerContext: Any? = null, priority: Number? = null, vararg args: Any): Phaser.SignalBinding
            open fun dispatch(vararg params: Any): Unit
            open fun dispose(): Unit
            open fun forget(): Unit
            open fun getNumListeners(): Number
            open fun halt(): Unit
            open fun has(listener: Function<Any>, context: Any? = null): Boolean
            open fun remove(listener: Function<Any>, context: Any? = null): Function<Any>
            open fun removeAll(context: Any? = null): Unit
            override fun toString(): String
            open fun validateListener(listener: Function<Any>, fnName: String): Unit
        }
        external open class Signal1<T>:Signal() {
            open fun add(listener: (T)->Unit, listenerContext: Any? = null, priority: Number? = null, vararg args: Any): Phaser.SignalBinding
        }
        external open class SignalSound:Signal() {
            open fun add(listener: (Sound)->Unit, listenerContext: Any? = null, priority: Number? = null, vararg args: Any): Phaser.SignalBinding
        }
        external open class SignalAnimationFrame:Signal() {
            open fun add(listener: (Animation,Frame)->Unit, listenerContext: Any? = null, priority: Number? = null, vararg args: Any): Phaser.SignalBinding
        }
@JsName("Phaser.SignalBinding")
        external open class SignalBinding(signal: Phaser.Signal, listener: Function<Any>, isOnce: Boolean, listenerContext: Any? = null, priority: Number? = null, vararg args: Any) {
            open var active: Boolean
            open var callCount: Number
            open var context: Any
            open var params: Array<Any>
            open fun execute(paramsArr: Array<Any>? = null): Unit
            open fun detach(): Function<Any>
            open fun isBound(): Boolean
            open fun isOnce(): Boolean
            open fun getListener(): Function<Any>
            open fun getSignal(): Phaser.Signal
            override fun toString(): String
        }
@JsName("Phaser.SinglePad")
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
            open fun axis(axisCode: Number): Number
            open fun addCallbacks(context: Any, callbacks: Any): Unit
            open fun buttonValue(buttonCode: Number): Number
            open fun connect(rawPad: Any): Unit
            open fun destroy(): Unit
            open fun disconnect(): Unit
            open fun getButton(buttonCode: Number): Phaser.DeviceButton
            open fun isDown(buttonCode: Number): Boolean
            open fun isUp(buttonCode: Number): Boolean
            open fun justPressed(buttonCode: Number, duration: Number? = null): Boolean
            open fun justReleased(buttonCode: Number, duration: Number? = null): Boolean
            open fun pollStatus(): Unit
            open fun processAxisChange(axisState: Any): Unit
            open fun processButtonDown(buttonCode: Number, value: Any): Unit
            open fun processButtonFloat(buttonCode: Number, value: Any): Unit
            open fun processButtonUp(buttonCode: Number, value: Any): Unit
            open fun reset(): Unit
        }
@JsName("Phaser.Sound")
        external open class Sound(game: Phaser.Game, key: String, volume: Number? = null, loop: Boolean? = null, connect: Boolean? = null) {
            open var autoplay: Boolean
            open var allowMultiple: Boolean
            open var context: Any
            open var currentMarker: String
            open var currentTime: Number
            open fun destroy(remove: Boolean? = null): Unit
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
            open fun addMarker(name: String, start: Number, duration: Number, volume: Number? = null, loop: Boolean? = null): Unit
            open fun destroy(): Unit
            open fun fadeIn(duration: Number? = null, loop: Boolean? = null, marker: String? = null): Unit
            open fun fadeOut(duration: Number? = null): Unit
            open fun fadeTo(duration: Number? = null, volume: Number? = null): Unit
            open fun loopFull(volume: Number? = null): Phaser.Sound
            open fun pause(): Unit
            open fun play(marker: String? = null, position: Number? = null, volume: Number? = null, loop: Boolean? = null, forceRestart: Boolean? = null): Phaser.Sound
            open fun removeMarker(name: String): Unit
            open fun restart(): Unit
            open fun restart(marker: String, position: Number, volume: Number? = null, loop: Boolean? = null): Unit
            open fun resume(): Unit
            open fun soundHasUnlocked(key: String): Unit
            open fun stop(): Unit
            open fun update(): Unit
        }
@JsName("Phaser.SoundManager")
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
            open fun add(key: String, volume: Number? = null, loop: Boolean? = null, connect: Boolean? = null): Phaser.Sound
            open fun addSprite(key: String): Phaser.AudioSprite
            open fun boot(): Unit
            open fun decode(key: String, sound: Phaser.Sound? = null): Unit
            open fun destroy(): Unit
            open fun pauseAll(): Unit
            open fun play(key: String, volume: Number? = null, loop: Boolean? = null): Phaser.Sound
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
@JsName("Phaser.Sprite")
        external open class Sprite(game: Phaser.Game, x: Number, y: Number, key: Any? = null, frame: Any? = null) : PIXI.Sprite(null) {
            /*constructor(game: Phaser.Game, x: Number, y: Number, key: String? = null, frame: String? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: String? = null, frame: Number? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture? = null, frame: String? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.RenderTexture? = null, frame: Number? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData? = null, frame: String? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: Phaser.BitmapData? = null, frame: Number? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture? = null, frame: String? = null)
            constructor(game: Phaser.Game, x: Number, y: Number, key: PIXI.Texture? = null, frame: Number? = null)*/
            open var alive: Boolean
            open var anchor: Phaser.Point
            open var angle: Double
            open var animations: Phaser.AnimationManager
            open var autoCull: Boolean
            open var body: dynamic /* Phaser.Physics.Arcade.Body | Phaser.Physics.P2.Body | Phaser.Physics.Ninja.Body | Any */
            open var bottom: Number
            open var cameraOffset: Phaser.Point
            open var centerX: Number
            open var centerY: Number
            open var checkWorldBounds: Boolean
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
            open var fixedToCamera: Boolean
            open var frame: dynamic /* String | Number */
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
            open var position: Phaser.Point
            open var physicsEnabled: Boolean
            open var physicsType: Number
            open var renderOrderID: Number
            open var right: Number
            open var scale: Phaser.Point
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
            open var z: Number
            open fun alignIn(container: Phaser.Rectangle, position: Number?, offsetX: Number? , offsetY: Number?): Any
            /*open fun alignIn(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            */
            open fun bringToTop(): Phaser.Sprite
            open fun crop(rect: Phaser.Rectangle, copy: Boolean)
            //open fun checkTransform(wt: PIXI.Matrix): Unit
            open fun damage(amount: Number): Phaser.Sprite
            open fun destroy(destroyChildren: Boolean?)
            open fun drawPolygon(): Unit
            open fun heal(amount: Number): Phaser.Sprite
            open fun kill(): Phaser.Sprite
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
            open fun reset(x: Number, y: Number, health: Number?): Phaser.Sprite
            open fun resetFrame(): Unit
            open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
            open fun revive(health: Number?): Phaser.Sprite
            open fun sendToBack(): Phaser.Sprite
            open fun setFrame(frame: Phaser.Frame): Unit
            open fun setScaleMinMax(minX: Number?, minY: Number?, maxX: Number?, maxY: Number? ): Unit
            open fun update(): Unit
            open fun updateCrop(): Unit
        }
@JsName("Phaser.SpriteBatch")
        external open class SpriteBatch(game: Phaser.Game, parent: PIXI.DisplayObjectContainer, name: String? = null, addedToStage: Boolean? = null) : Phaser.Group(game, parent, name, addedToStage) {
            override var type: Number
        }
@JsName("Phaser.Stage")
        external open class Stage(game: Phaser.Game) : PIXI.DisplayObjectContainer() {
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
        interface `T$10` {
            var canExpandParent: Boolean
            var clickTrampoline: String
            var forceMinimumDocumentHeight: Boolean
            var noMargins: Boolean
            var orientationFallback: Boolean
            var scrollTo: Point
            var supportsFullScreen: Boolean
        }
        interface `T$11` {
            var left: Number
            var top: Number
            var right: Number
            var bottom: Number
            var x: Number
            var y: Number
        }
        interface `T$12` {
            var bottom: String
            var right: String
        }
@JsName("Phaser.ScaleManager")
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
            open var onFullScreenChange: Phaser.Signal
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
            open fun forceOrientation(forceLandscape: Boolean, forcePortrait: Boolean? = null): Unit
            open fun getParentBounds(target: Rectangle? = null): Rectangle
            open fun parseConfig(config: Any): Unit
            open fun preUpdate(): Unit
            open fun pauseUpdate(): Unit
            open fun refresh(): Unit
            open fun setGameSize(width: Number, height: Number): Unit
            open fun setResizeCallback(callback: ResizeCallback, context: Any): Unit
            open fun setUserScale(hScale: Number, vScale: Number, hTrim: Number? = null, vTrim: Number? = null): Unit
            open fun setMinMax(minWidth: Number, minHeight: Number, maxWidth: Number? = null, maxHeight: Number? = null): Unit
            open fun setupScale(width: Number, height: Number): Unit
            open fun setupScale(width: String, height: String): Unit
            open fun scaleSprite(sprite: Sprite, width: Number? = null, height: Number? = null, letterBox: Boolean? = null): Sprite
            open fun scaleSprite(sprite: Image, width: Number? = null, height: Number? = null, letterBox: Boolean? = null): Sprite
            open fun startFullScreen(antialias: Boolean? = null, allowTrampoline: Boolean? = null): Boolean
            open fun stopFullScreen(): Boolean
            companion object {
                var EXACT_FIT: Number
                var NO_SCALE: Number
                var SHOW_ALL: Number
                var RESIZE: Number
                var USER_SCALE: Number
            }
        }
@JsName("Phaser.DOM")
        external open class DOM {
            companion object {
                var visualBounds: Phaser.Rectangle
                var layoutBounds: Phaser.Rectangle
                var documentBounds: Phaser.Rectangle
                fun calibrate(coords: Any, cushion: Number? = null): Any
                fun getAspectRatio(`object`: Any): Number
                fun getScreenOrientation(primaryFallback: String? = null): String
                fun getBounds(element: Any, cushion: Number? = null): Any
                fun getOffset(element: Any, point: Point? = null): Point
                fun inLayoutViewport(element: Any, cushion: Number? = null): Boolean
            }
        }
@JsName("Phaser.State")
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
//@JsName("Phaser.IStateCycle")
        external interface IStateCycle {
            fun preUpdate()
            fun update()
            fun render()
            fun postRender()
            fun destroy()
        }
@JsName("Phaser.StateManager")
        external open class StateManager(game: Phaser.Game, pendingState: Phaser.State? = null) {
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
            open fun add(key: String, state: Any, autoStart: Boolean? = null): Unit
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
            open fun restart(clearWorld: Boolean? = null, clearCache: Boolean? = null, vararg args: Any): Unit
            open fun resize(width: Number, height: Number): Unit
            open fun start(key: String, clearWorld: Boolean? = null, clearCache: Boolean? = null, vararg args: Any): Unit
            open fun update(): Unit
            open fun unlink(key: String): Unit
        }
        interface PhaserTextStyle {
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
@JsName("Phaser.Text")
        external open class Text(game: Phaser.Game, x: Number, y: Number, text: String, style: PhaserTextStyle? = null) : Phaser.Sprite(game, x, y) {
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
            open var text: String
            open var textBounds: Phaser.Rectangle
            override var type: Number
            open var useAdvancedWrap: Boolean
            override var world: Phaser.Point
            open var wordWrap: Boolean
            open var wordWrapWidth: Number
            override var z: Number
            open fun addColor(color: String, position: Number): Phaser.Text
            open fun addFontStyle(style: String, position: Number): Phaser.Text
            open fun addFontWeight(weight: String, position: Number): Phaser.Text
            open fun addStrokeColor(color: String, position: Number): Phaser.Text
            override fun alignIn(container: Phaser.Rectangle, position: Number?, offsetX: Number?, offsetY: Number?): Any
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
            open fun parseList(list: Array<Any>): Phaser.Text
            open fun precalculateWordWrap(text: String): Array<String>
            override fun preUpdate(): Unit
            open fun renderTabLine(line: String, x: Number, y: Number, fill: Boolean? = null): Unit
            open fun setShadow(x: Number? = null, y: Number? = null, color: Any? = null, blur: Number? = null, shadowStroke: Boolean? = null, shadowFill: Boolean? = null): Phaser.Text
            open fun setStyle(style: PhaserTextStyle? = null, update: Boolean? = null): Phaser.Text
            open fun setText(text: String, immediate: Boolean? = null): Phaser.Text
            open fun setTextBounds(x: Number? = null, y: Number? = null, width: Number? = null, height: Number? = null): Phaser.Text
            override fun update(): Unit
            open fun updateFont(components: Any): Unit
            open fun updateLine(text: String, x: Number? = null, y: Number? = null): Unit
            open fun updateShadow(state: Boolean? = null): Unit
            open fun updateTexture(): Unit
            companion object {
                var fontPropertiesCanvas: Any
                var fontPropertiesContext: Any
                var fontPropertiesCache: Any
            }
        }
@JsName("Phaser.Tile")
        external open class Tile(layer: Any, index: Number, x: Number, y: Number, width: Number, height: Number) {
            open var alpha: Number
            open var bottom: Number
            open var callback: Function<Any>
            open var callbackContext: Any
            open var centerX: Number
            open var centerY: Number
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
            open var height: Number
            open var index: Number
            open var layer: Any
            open var left: Number
            open var properties: Any
            open var right: Number
            open var scanned: Boolean
            open var top: Number
            open var width: Number
            open var worldX: Number
            open var worldY: Number
            open var x: Number
            open var y: Number
            open fun copy(tile: Phaser.Tile): Phaser.Tile
            open fun containsPoint(x: Number, y: Number): Boolean
            open fun destroy(): Unit
            open fun intersects(x: Number, y: Number, right: Number, bottom: Number): Boolean
            open fun isInterested(collides: Boolean, faces: Boolean): Boolean
            open fun resetCollision(): Unit
            open fun setCollision(left: Boolean, right: Boolean, up: Boolean, down: Boolean): Unit
            open fun setCollisionCallback(callback: Function<Any>, context: Any): Unit
        }
@JsName("Phaser.Tilemap")
        external open class Tilemap(game: Phaser.Game, key: String? = null, tileWidth: Number? = null, tileHeight: Number? = null, width: Number? = null, height: Number? = null) {
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
            open fun addTilesetImage(tileset: String, key: String? = null, tileWidth: Number? = null, tileHeight: Number? = null, tileMargin: Number? = null, tileSpacing: Number? = null, gid: Number? = null): Phaser.Tileset
            open fun addTilesetImage(tileset: String, key: Phaser.BitmapData? = null, tileWidth: Number? = null, tileHeight: Number? = null, tileMargin: Number? = null, tileSpacing: Number? = null, gid: Number? = null): Phaser.Tileset
            open fun calculateFaces(layer: Number): Unit
            open fun copy(x: Number, y: Number, width: Number, height: Number, layer: Any? = null): Array<Phaser.Tile>
            open fun create(name: String, width: Number, height: Number, tileWidth: Number, tileHeight: Number, group: Phaser.Group? = null): Phaser.TilemapLayer
            open fun createBlankLayer(name: String, width: Number, height: Number, tileWidth: Number, tileHeight: Number, group: Phaser.Group? = null): Phaser.TilemapLayer
            open fun createFromObjects(name: String, gid: Number, key: String, frame: Any? = null, exists: Boolean? = null, autoCull: Boolean? = null, group: Phaser.Group? = null, CustomClass: Any? = null, adjustY: Boolean? = null): Unit
            open fun createFromTiles(tiles: Any, replacements: Any, key: String, layer: Any? = null, group: Phaser.Group? = null, properties: Any? = null): Number
            open fun createLayer(layer: Any, width: Number? = null, height: Number? = null, group: Phaser.Group? = null): Phaser.TilemapLayer
            open fun destroy(): Unit
            open fun dump(): Unit
            open fun fill(index: Number, x: Number, y: Number, width: Number, height: Number, layer: Any? = null): Unit
            open fun forEach(callback: Function<Any>, context: Any, x: Number, y: Number, width: Number, height: Number, layer: Any? = null): Unit
            open fun getImageIndex(name: String): Number
            open fun getIndex(location: Array<Any>, name: String): Number
            open fun getLayer(layer: Any): Number
            open fun getLayerIndex(name: String): Number
            open fun getObjectIndex(name: String): Number
            open fun getTile(x: Number, y: Number, layer: Any? = null, nonNull: Boolean? = null): Phaser.Tile
            open fun getTileAbove(layer: Number, x: Number, y: Number): Phaser.Tile
            open fun getTileBelow(layer: Number, x: Number, y: Number): Phaser.Tile
            open fun getTileLeft(layer: Number, x: Number, y: Number): Phaser.Tile
            open fun getTileRight(layer: Number, x: Number, y: Number): Phaser.Tile
            open fun getTilesetIndex(name: String): Number
            open fun getTileWorldXY(x: Number, y: Number, tileWidth: Number? = null, tileHeight: Number? = null, layer: Number? = null, nonNull: Boolean? = null): Phaser.Tile
            open fun getTileWorldXY(x: Number, y: Number, tileWidth: Number? = null, tileHeight: Number? = null, layer: String? = null, nonNull: Boolean? = null): Phaser.Tile
            open fun getTileWorldXY(x: Number, y: Number, tileWidth: Number? = null, tileHeight: Number? = null, layer: Phaser.TilemapLayer? = null, nonNull: Boolean? = null): Phaser.Tile
            open fun hasTile(x: Number, y: Number, layer: Phaser.TilemapLayer): Boolean
            open fun paste(x: Number, y: Number, tileblock: Array<Phaser.Tile>, layer: Any? = null): Unit
            open fun putTile(tile: Any, x: Number, y: Number, layer: Any? = null): Phaser.Tile
            open fun putTileWorldXY(tile: Any, x: Number, y: Number, tileWidth: Number, tileHeight: Number, layer: Any? = null): Unit
            open fun random(x: Number, y: Number, width: Number, height: Number, layer: Any? = null): Unit
            open fun removeAllLayers(): Unit
            open fun removeTile(x: Number, y: Number, layer: Any? = null): Phaser.Tile
            open fun removeTileWorldXY(x: Number, y: Number, tileWidth: Number, tileHeight: Number, layer: Any? = null): Phaser.Tile
            open fun replace(source: Number, dest: Number, x: Number, y: Number, width: Number, height: Number, layer: Any? = null): Unit
            open fun searchTileIndex(index: Number, skip: Number? = null, reverse: Boolean? = null, layer: Any? = null): Phaser.Tile
            open fun setCollision(indexes: Any, collides: Boolean? = null, layer: Any? = null, recalculate: Boolean? = null): Unit
            open fun setCollisionBetween(start: Number, stop: Number, collides: Boolean? = null, layer: Any? = null, recalculate: Boolean? = null): Unit
            open fun setCollisionByExclusion(indexes: Array<Any>, collides: Boolean? = null, layer: Any? = null, recalculate: Boolean? = null): Unit
            open fun setCollisionByIndex(index: Number, collides: Boolean? = null, layer: Number? = null, recalculate: Boolean? = null): Unit
            open fun setLayer(layer: Any): Unit
            open fun setPreventRecalculate(value: Boolean): Unit
            open fun setTileIndexCallback(indexes: Any, callback: Function<Any>, callbackContext: Any, layer: Any? = null): Unit
            open fun setTileLocationCallback(x: Number, y: Number, width: Number, height: Number, callback: Function<Any>, callbackContext: Any, layer: Any? = null): Unit
            open fun setTileSize(tileWidth: Number, tileHeight: Number): Unit
            open fun shuffle(x: Number, y: Number, width: Number, height: Number, layer: Any): Unit
            open fun swap(tileA: Number, tileB: Number, x: Number, y: Number, width: Number, height: Number, layer: Any? = null): Unit
            companion object {
                var CSV: Number
                var TILED_JSON: Number
                var NORTH: Number
                var EAST: Number
                var SOUTH: Number
                var WEST: Number
            }
        }
        interface `T$13` {
            var missingImageFill: String
            var debuggedTileOverfill: String
            var forceFullRedraw: Boolean
            var debugAlpha: Number
            var facingEdgeStroke: String
            var collidingTileOverfill: String
        }
        interface `T$14` {
            var enableScrollDelta: Boolean
            var overdrawRatio: Number
            var copyCanvas: Any
        }
@JsName("Phaser.TilemapLayer")
        external open class TilemapLayer(game: Phaser.Game, tilemap: Phaser.Tilemap, index: Number, width: Number? = null, height: Number? = null) : Phaser.Sprite(game,0,0) {
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
            open fun destroy()
            open fun getRayCastTiles(layer: Phaser.TilemapLayer, line: Phaser.Line, stepRate: Number? = null, collides: Boolean? = null, interestingFace: Boolean? = null): Array<Phaser.Tile>
            open fun getRayCastTiles(layer: Phaser.TilemapLayerGL, line: Phaser.Line, stepRate: Number? = null, collides: Boolean? = null, interestingFace: Boolean? = null): Array<Phaser.Tile>
            open fun getTiles(layer: Phaser.TilemapLayer, x: Number, y: Number, width: Number, height: Number, collides: Boolean? = null, interestingFace: Boolean? = null): Array<Phaser.Tile>
            open fun getTiles(layer: Phaser.TilemapLayerGL, x: Number, y: Number, width: Number, height: Number, collides: Boolean? = null, interestingFace: Boolean? = null): Array<Phaser.Tile>
            open fun getTileX(layer: Phaser.TilemapLayer, x: Number): Number
            open fun getTileX(layer: Phaser.TilemapLayerGL, x: Number): Number
            open fun getTileXY(layer: Phaser.TilemapLayer, x: Number, y: Number, point: Phaser.Point): Phaser.Point
            open fun getTileXY(layer: Phaser.TilemapLayerGL, x: Number, y: Number, point: Phaser.Point): Phaser.Point
            open fun getTileY(layer: Phaser.TilemapLayer, y: Number): Number
            open fun getTileY(layer: Phaser.TilemapLayerGL, y: Number): Number
            override fun postUpdate(): Unit
            open fun render(): Unit
            open fun resize(width: Number, height: Number): Unit
            open fun resizeWorld(): Unit
            open fun resetTilesetCache(): Unit
            open fun setScale(xScale: Number? = null, yScale: Number? = null): Unit
            open fun updateMax(): Unit
        }
@JsName("Phaser.TilemapLayerGL")
        external open class TilemapLayerGL(game: Phaser.Game, tilemap: Phaser.Tilemap, index: Number, width: Number? = null, height: Number? = null, tileset: Phaser.Tileset? = null) {
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
            open fun setScale(xScale: Number? = null, yScale: Number? = null): Unit
            open fun updateMax(): Unit
        }
@JsName("Phaser.TilemapParser")
        external open class TilemapParser {
            companion object {
                var INSERT_NULL: Boolean
                fun getEmptyData(tileWidth: Number? = null, tileHeight: Number? = null, width: Number? = null, height: Number? = null): Any
                fun parse(game: Phaser.Game, key: String, tileWidth: Number? = null, tileHeight: Number? = null, width: Number? = null, height: Number? = null): Any
                fun parseCSV(key: String, data: String, tileWidth: Number? = null, tileHeight: Number? = null): Any
                fun parseJSON(json: Any): Any
            }
        }
@JsName("Phaser.Tileset")
        external open class Tileset(name: String, firstgid: Number, width: Number? = null, height: Number? = null, margin: Number? = null, spacing: Number? = null, properties: Any? = null) {
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
            open fun setSpacing(margin: Number? = null, spacing: Number? = null): Unit
        }
@JsName("Phaser.TileSprite")
        external open class TileSprite() : PIXI.TilingSprite(null,null,null) {
            constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: String? = null, frame: String? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: String? = null, frame: Number? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: Phaser.RenderTexture? = null, frame: String? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: Phaser.RenderTexture? = null, frame: Number? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: Phaser.BitmapData? = null, frame: String? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: Phaser.BitmapData? = null, frame: Number? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: PIXI.Texture? = null, frame: String? = null):this()
            constructor(game: Phaser.Game, x: Number, y: Number, width: Number, height: Number, key: PIXI.Texture? = null, frame: Number? = null):this()
            open var alive: Boolean
            open var angle: Number
            open var animations: Phaser.AnimationManager
            open var autoCull: Boolean
            open var body: dynamic /* Phaser.Physics.Arcade.Body | Phaser.Physics.P2.Body | Phaser.Physics.Ninja.Body | Any */
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
            open var position: Phaser.Point
            open var smoothed: Boolean
            open var previousPosition: Phaser.Point
            open var previousRoation: Number
            open var right: Number
            open var top: Number
            open var renderOrderID: Number
            open var type: Number
            open var world: Phaser.Point
            open var z: Number
            open fun alignIn(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignIn(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Rectangle, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Sprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Image, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Text, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.BitmapText, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Button, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.Graphics, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun alignTo(container: Phaser.TileSprite, position: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Any
            open fun autoScroll(x: Number, y: Number): Unit
            open fun destroy(destroyChildren: Boolean? = null): Unit
            open fun loadTexture(key: String, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: String, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.RenderTexture, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.RenderTexture, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.BitmapData, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.BitmapData, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.Video, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: Phaser.Video, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: PIXI.Texture, frame: String? = null, stopAnimation: Boolean? = null): Unit
            open fun loadTexture(key: PIXI.Texture, frame: Number? = null, stopAnimation: Boolean? = null): Unit
            open fun play(name: String, frameRate: Number? = null, loop: Boolean? = null, killOnComplete: Boolean? = null): Phaser.Animation
            open fun postUpdate(): Unit
            open fun preUpdate(): Unit
            open fun overlap(displayObject: Phaser.Sprite): Boolean
            open fun overlap(displayObject: Phaser.Image): Boolean
            open fun overlap(displayObject: Phaser.TileSprite): Boolean
            open fun overlap(displayObject: Phaser.Button): Boolean
            open fun overlap(displayObject: PIXI.DisplayObject): Boolean
            open fun reset(x: Number, y: Number, health: Number? = null): Phaser.TileSprite
            open fun resizeFrame(parent: Any, width: Number, height: Number): Unit
            open fun resetFrame(): Unit
            open fun setFrame(frame: Phaser.Frame): Unit
            open fun stopScroll(): Unit
            open fun update(): Unit
        }
@JsName("Phaser.Time")
        external open class Time(game: Phaser.Game) {
            open var advancedTiming: Boolean
            open var desiredFps: Number
            open var desiredFpsMult: Number
            open var elapsed: Number
            open var events: Phaser.Timer
            open var elapsedMS: Number
            open var fps: Number
            open var fpsMax: Number
            open var fpsMin: Number
            open var frames: Number
            open var game: Phaser.Game
            open var lastTime: Number
            open var msMax: Number
            open var msMin: Number
            open var now: Number
            open var pausedTime: Number
            open var pauseDuration: Number
            open var physicsElapsed: Number
            open var physicsElapsedMS: Number
            open var prevTime: Number
            open var slowMotion: Number
            open var suggestedFps: Number
            open var time: Number
            open var timeExpected: Number
            open var timeToCall: Number
            open fun add(timer: Phaser.Timer): Phaser.Timer
            open fun boot(): Unit
            open fun create(autoDestroy: Boolean? = null): Phaser.Timer
            open fun elapsedSecondsSince(since: Number): Number
            open fun elapsedSince(since: Number): Number
            open fun removeAll(): Unit
            open fun reset(): Unit
            open fun totalElapsedSeconds(): Number
            open fun update(time: Number): Unit
        }
@JsName("Phaser.Timer")
        external open class Timer(game: Phaser.Game, autoDestroy: Boolean? = null) {
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
            open fun add(delay: Number, callback: Function<Any>, callbackContext: Any? = null, vararg args: Any): Phaser.TimerEvent
            open fun clearPendingEvents(): Unit
            open fun destroy(): Unit
            open fun loop(delay: Number, callback: Function<Any>, callbackContext: Any? = null, vararg args: Any): Phaser.TimerEvent
            open fun order(): Unit
            open fun pause(): Unit
            open fun remove(event: Phaser.TimerEvent): Boolean
            open fun removeAll(): Unit
            open fun repeat(delay: Number, repeatCount: Number, callback: Function<Any>, callbackContext: Any? = null, vararg args: Any): Phaser.TimerEvent
            open fun resume(): Unit
            open fun sortHandler(a: Any, b: Any): Number
            open fun start(startDelay: Number? = null): Unit
            open fun stop(clearEvents: Boolean? = null): Unit
            open fun update(time: Number): Boolean
            companion object {
                var HALF: Number
                var MINUTE: Number
                var QUARTER: Number
                var SECOND: Number
            }
        }
@JsName("Phaser.TimerEvent")
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
@JsName("Phaser.Touch")
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
            open fun addTouchLockCallback(callback: Function<Any>, context: Any? = null, onEnd: Function<Any>? = null): Unit
            open fun removeTouchLockCallback(callback: Function<Any>, context: Any? = null): Boolean
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
@JsName("Phaser.Tween")
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
            open fun delay(duration: Number, index: Number? = null): Phaser.Tween
            open fun easing(ease: Function<Any>, index: Number? = null): Phaser.Tween
            open fun easing(ease: String, index: Number? = null): Phaser.Tween
            open fun from(properties: Any, duration: Number? = null, ease: Function<Any>? = null, autoStart: Boolean? = null, delay: Number? = null, repeat: Number? = null, yoyo: Boolean? = null): Phaser.Tween
            open fun from(properties: Any, duration: Number? = null, ease: String? = null, autoStart: Boolean? = null, delay: Number? = null, repeat: Number? = null, yoyo: Boolean? = null): Phaser.Tween
            open fun generateData(frameRate: Number? = null, data: Any? = null): Array<Any>
            open fun interpolation(interpolation: Function<Any>, context: Any? = null, index: Number? = null): Phaser.Tween
            open fun loop(value: Boolean? = null): Phaser.Tween
            open fun onUpdateCallback(callback: Function<Any>, callbackContext: Any? = null): Phaser.Tween
            open fun pause(): Unit
            open fun repeat(total: Number, repeatDelay: Number? = null, index: Number? = null): Phaser.Tween
            open fun repeatDelay(duration: Number, index: Number? = null): Phaser.Tween
            open fun repeatAll(total: Number? = null): Phaser.Tween
            open fun resume(): Unit
            open fun start(index: Number? = null): Phaser.Tween
            open fun stop(complete: Boolean? = null): Phaser.Tween
            open fun to(properties: Any, duration: Number? = null, ease: Function<Number>? = null, autoStart: Boolean? = null, delay: Number? = null, repeat: Number? = null, yoyo: Boolean? = null): Phaser.Tween
            open fun to(properties: Any, duration: Number? = null, ease: String? = null, autoStart: Boolean? = null, delay: Number? = null, repeat: Number? = null, yoyo: Boolean? = null): Phaser.Tween
            open fun update(time: Number): Boolean
            open fun updateTweenData(property: String, value: Number, index: Number? = null): Phaser.Tween
            open fun updateTweenData(property: String, value: Function<Any>, index: Number? = null): Phaser.Tween
            open fun yoyo(enable: Boolean, yoyoDelay: Number? = null, index: Number? = null): Phaser.Tween
            open fun yoyoDelay(duration: Number, index: Number? = null): Phaser.Tween
        }
@JsName("Phaser.TweenData")
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
            open fun from(properties: Any, duration: Number? = null, ease: Function<Any>? = null, delay: Number? = null, repeat: Number? = null, yoyo: Boolean? = null): Phaser.TweenData
            open fun generateData(frameRate: Number? = null): Array<Any>
            open fun repeat(): Number
            open fun start(): Phaser.TweenData
            open fun to(properties: Any, duration: Number? = null, ease: Function<Any>? = null, delay: Number? = null, repeat: Number? = null, yoyo: Boolean? = null): Phaser.TweenData
            open fun update(time: Number): Number
            companion object {
                var COMPLETE: Number
                var LOOPED: Number
                var PENDING: Number
                var RUNNING: Number
            }
        }
@JsName("Phaser.TweenManager")
        external open class TweenManager(game: Phaser.Game) {
            open var frameBased: Boolean
            open var game: Phaser.Game
            open fun add(tween: Phaser.Tween): Phaser.Tween
            open fun create(`object`: Any): Phaser.Tween
            open fun getAll(): Array<Phaser.Tween>
            open fun isTweening(`object`: Any): Boolean
            open fun remove(tween: Phaser.Tween): Phaser.Tween
            open fun removeAll(): Unit
            open fun removeFrom(obj: Any, children: Boolean? = null): Unit
            open fun resumeAll(): Unit
            open fun update(): Boolean
            open fun pauseAll(): Unit
        }
@JsName("Phaser.Utils")
        external open class Utils {
            companion object {
                fun getProperty(obj: Any, prop: String): Any
                fun setProperty(obj: Any, prop: String, value: Any): Any
                fun chanceRoll(chance: Number): Boolean
                fun randomChoice(choice1: String, choice2: Any): Any
                fun randomChoice(choice1: Number, choice2: Any): Any
                fun reverseString(string: String): String
                fun parseDimension(size: Any, dimension: Number): Number
                fun pad(str: String, len: Number? = null, pad: String? = null, dir: Number? = null): String
                fun isPlainObject(`object`: Any): Boolean
                fun extend(deep: Boolean, target: Any, vararg args: Any): Any
                fun mixinPrototype(target: Any, mixin: Any, replace: Boolean? = null): Unit
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
                //open fun AStar(astar: Phaser.Plugin.AStar, x: Number, y: Number, showVisited: Boolean): Unit
                open fun boot(): Unit
                open fun body(sprite: Phaser.Sprite, color: String? = null, filled: Boolean? = null): Unit
                open fun bodyInfo(sprite: Phaser.Sprite, x: Number, y: Number, color: String? = null): Unit
                open fun box2dBody(body: Phaser.Sprite, color: String? = null): Unit
                open fun box2dWorld(): Unit
                open fun cameraInfo(camera: Phaser.Camera, x: Number, y: Number, color: String? = null): Unit
                open fun destroy(): Unit
                open fun geom(`object`: Any, color: String? = null, fiiled: Boolean? = null, forceType: Number? = null): Unit
                open fun inputInfo(x: Number, y: Number, color: String? = null): Unit
                open fun lineInfo(line: Phaser.Line, x: Number, y: Number, color: String? = null): Unit
                open fun key(key: Phaser.Key, x: Number? = null, y: Number? = null, color: String? = null): Unit
                open fun line(vararg args: String): Unit
                open fun preUpdate(): Unit
                open fun pixel(x: Number, y: Number, color: String? = null, size: Number? = null): Unit
                open fun pointer(pointer: Phaser.Pointer, hideIfUp: Boolean? = null, downColor: String? = null, upColor: String? = null, color: String? = null): Unit
                open fun quadTree(quadtree: Phaser.QuadTree, color: String? = null): Unit
                open fun rectangle(`object`: Phaser.Rectangle, color: String? = null, filled: Boolean? = null): Unit
                open fun reset(): Unit
                open fun ropeSegments(rope: Phaser.Rope, color: Number? = null, filled: Boolean? = null): Unit
                open fun soundInfo(sound: Phaser.Sound, x: Number, y: Number, color: String? = null): Unit
                open fun spriteBounds(sprite: Any, color: String? = null, filled: Boolean? = null): Unit
                open fun spriteCoords(sprite: Any, x: Number, y: Number, color: String? = null): Unit
                open fun spriteInfo(sprite: Phaser.Sprite, x: Number, y: Number, color: String? = null): Unit
                open fun spriteInputInfo(sprite: Phaser.Sprite, x: Number, y: Number, color: String? = null): Unit
                open fun start(x: Number? = null, y: Number? = null, color: String? = null, columnWidth: Number? = null): Unit
                open fun stop(): Unit
                open fun text(text: String, x: Number, y: Number, color: String? = null, font: String? = null): Unit
                open fun timer(timer: Phaser.Timer, x: Number, y: Number, color: String? = null): Unit
            }
        }
/*
@JsName("Phaser.Weapon")
        external open class Weapon(game: Phaser.Game, parent: Phaser.PluginManager) : Phaser.Plugin() {
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
            open fun addBulletAnimation(name: String, frames: Array<Number>? = null, frameRate: Number? = null, loop: Boolean? = null, useNumericIndex: Boolean? = null): Phaser.Weapon
            open fun addBulletAnimation(name: String, frames: Array<String>? = null, frameRate: Number? = null, loop: Boolean? = null, useNumericIndex: Boolean? = null): Phaser.Weapon
            open fun createBullets(quantity: Number? = null, key: Any? = null, frame: Any? = null, group: Phaser.Group? = null): Phaser.Weapon
            open fun debug(x: Number? = null, y: Number? = null, debugBodies: Boolean? = null): Unit
            override fun destroy(): Unit
            open fun fire(from: Any? = null, x: Number? = null, y: Number? = null, offsetX: Number? = null, offsetY: Number? = null): Phaser.Bullet
            open fun fireAtPointer(pointer: Phaser.Pointer): Phaser.Bullet
            open fun fireAtSprite(sprite: Phaser.Sprite): Phaser.Bullet
            open fun fireAtXY(x: Number, y: Number): Phaser.Bullet
            open fun fireMany(positions: Array<Any>, from: Any? = null): Array<Phaser.Bullet>
            open fun fireOffset(offsetX: Number? = null, offsetY: Number? = null): Phaser.Bullet
            open fun forEach(callback: Any, callbackContext: Any): Phaser.Weapon
            open fun killAll(): Phaser.Weapon
            open fun pauseAll(): Phaser.Weapon
            open fun resetShots(newLimit: Number? = null): Phaser.Weapon
            open fun resumeAll(): Phaser.Weapon
            open fun setBulletBodyOffset(width: Number, height: Number, offsetX: Number? = null, offsetY: Number? = null): Phaser.Weapon
            open fun setBulletFrames(min: Number, max: Number, cycle: Boolean? = null, random: Boolean? = null): Phaser.Weapon
            open fun trackPointer(pointer: Phaser.Pointer, offsetX: Number? = null, offsetY: Number? = null): Phaser.Weapon
            open fun trackSprite(sprite: Phaser.Sprite, offsetX: Number? = null, offsetY: Number? = null, trackRotation: Boolean? = null): Phaser.Weapon
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
        */
        interface `T$15` {
            var skipped: Number
            var ignored: Number
            var checked: Number
        }

@JsName("Phaser.World")
        external open class World(game: Phaser.Game) : Phaser.Group(game) {
            open var bounds: Phaser.Rectangle
            open var camera: Phaser.Camera
            override var centerX: Double
            override var centerY: Double
            override var game: Phaser.Game
            override var height: Double
            open var isPaused: Boolean
            open var randomX: Number
            open var randomY: Number
            open var stats: `T$15`
            override var width: Double
            open fun boot(): Unit
            open fun getObjectsUnderPointer(pointer: Phaser.Pointer, group: Phaser.Group, callback: Function<Any>? = null, callbackContext: Any? = null): Phaser.Sprite
            open fun resize(width: Number, height: Number): Unit
            open fun setBounds(x: Number, y: Number, width: Number, height: Number): Unit
            open fun sortLeftRight(a: Phaser.Sprite, b: Phaser.Sprite): Number
            open fun sortRightLeft(a: Phaser.Sprite, b: Phaser.Sprite): Number
            open fun sortTopBottom(a: Phaser.Sprite, b: Phaser.Sprite): Number
            open fun sortBottomTop(a: Phaser.Sprite, b: Phaser.Sprite): Number
            open fun sort(group: Phaser.Group, sortDirection: Number? = null): Unit
            override fun sort(key: String?, order: Number?): Unit
            open fun shutdown(): Unit
            open fun wrap(sprite: Any, padding: Number? = null, useBounds: Boolean? = null, horizontal: Boolean? = null, vertical: Boolean? = null): Unit
        }
/*    }
}*/
