//package PIXI

import Phaser.RenderTexture
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.xhr.XMLHttpRequest
import Phaser.Point

@JsModule("PIXI")
@JsNonModule
@JsName("PIXI")
external object PIXI {
    var game: Phaser.Game = noImpl
    var WEBGL_RENDERER: Number = noImpl
    var CANVAS_RENDERER: Number = noImpl
    var VERSION: String = noImpl
    enum class blendModes {
        NORMAL,
        ADD,
        MULTIPLY,
        SCREEN,
        OVERLAY,
        DARKEN,
        LIGHTEN,
        COLOR_DODGE,
        COLOR_BURN,
        HARD_LIGHT,
        SOFT_LIGHT,
        DIFFERENCE,
        EXCLUSION,
        HUE,
        SATURATION,
        COLOR,
        LUMINOSITY
    }
    enum class scaleModes {
        DEFAULT,
        LINEAR,
        NEAREST
    }
    var defaultRenderOptions: PixiRendererOptions = noImpl
    var INTERACTION_REQUENCY: Number = noImpl
    var AUTO_PREVENT_DEFAULT: Boolean = noImpl
    var PI_2: Number = noImpl
    var RAD_TO_DEG: Number = noImpl
    var DEG_TO_RAD: Number = noImpl
    var RETINA_PREFIX: String = noImpl
    var identityMatrix: Matrix = noImpl
    var glContexts: Array<WebGLRenderingContext> = noImpl
    var instances: Array<Any> = noImpl
    var TextureSilentFail: Boolean = noImpl
    interface `T$0` {
        var fonts: Any
    }
    var BitmapText: `T$0` = noImpl
    fun isPowerOfTwo(width: Number, height: Number): Boolean = noImpl
    fun rgb2hex(rgb: Array<Number>): String = noImpl
    fun hex2rgb(hex: String): Array<Number> = noImpl
    fun autoDetectRenderer(width: Number?, height: Number?, options: PixiRendererOptions?): PixiRenderer = noImpl
    fun autoDetectRecommendedRenderer(width: Number?, height: Number?, options: PixiRendererOptions?): PixiRenderer = noImpl
    fun canUseNewCanvasBlendModes(): Boolean = noImpl
    fun getNextPowerOfTwo(value: Number): Number = noImpl
    fun AjaxRequest(): XMLHttpRequest = noImpl
    fun CompileFragmentShader(gl: WebGLRenderingContext, shaderSrc: Array<String>): Any = noImpl
    fun CompileProgram(gl: WebGLRenderingContext, vertexSrc: Array<String>, fragmentSrc: Array<String>): Any = noImpl
    interface IEventCallback {
        fun invoke(e: IEvent?)
    }
    interface IEvent {
        var type: String
        var content: Any
    }
    interface HitArea {
        fun contains(x: Number, y: Number): Boolean
    }
    interface IInteractionDataCallback {
        fun invoke(interactionData: InteractionData)
    }
    interface PixiRenderer {
        var autoResize: Boolean
        var clearBeforeRender: Boolean
        var height: Number
        var resolution: Number
        var transparent: Boolean
        var type: Number
        var view: HTMLCanvasElement
        var width: Number
        fun destroy()
        fun render(stage: DisplayObjectContainer)
        fun resize(width: Number, height: Number)
    }
    interface PixiRendererOptions {
        var autoResize: Boolean? get() = noImpl; set(value){}
        var antialias: Boolean? get() = noImpl; set(value){}
        var clearBeforeRender: Boolean? get() = noImpl; set(value){}
        var preserveDrawingBuffer: Boolean? get() = noImpl; set(value){}
        var resolution: Number? get() = noImpl; set(value){}
        var transparent: Boolean? get() = noImpl; set(value){}
        var view: HTMLCanvasElement? get() = noImpl; set(value){}
    }
    interface BitmapTextStyle {
        var font: String? get() = noImpl; set(value){}
        var align: String? get() = noImpl; set(value){}
        var tint: String? get() = noImpl; set(value){}
    }
    interface TextStyle {
        var align: String? get() = noImpl; set(value){}
        var dropShadow: Boolean? get() = noImpl; set(value){}
        var dropShadowColor: String? get() = noImpl; set(value){}
        var dropShadowAngle: Number? get() = noImpl; set(value){}
        var dropShadowDistance: Number? get() = noImpl; set(value){}
        var fill: String? get() = noImpl; set(value){}
        var font: String? get() = noImpl; set(value){}
        var lineJoin: String? get() = noImpl; set(value){}
        var stroke: String? get() = noImpl; set(value){}
        var strokeThickness: Number? get() = noImpl; set(value){}
        var wordWrap: Boolean? get() = noImpl; set(value){}
        var wordWrapWidth: Number? get() = noImpl; set(value){}
    }
    interface Loader {
        fun load()
    }
    interface MaskData {
        var alpha: Number
        var worldTransform: Array<Number>
    }
    interface RenderSession {
        var context: CanvasRenderingContext2D
        var maskManager: CanvasMaskManager
        var scaleMode: scaleModes
        var smoothProperty: String
        var roundPixels: Boolean
    }
    interface ShaderAttribute
    interface FilterBlock {
        var visible: Boolean
        var renderable: Boolean
    }
    open class AbstractFilter() {
        constructor(fragmentSrc: String, uniforms: Any):this()
        constructor(fragmentSrc: Array<String>, uniforms: Any):this()
        open var dirty: Boolean = noImpl
        open var padding: Number = noImpl
        open var uniforms: Any = noImpl
        open var fragmentSrc: dynamic /* String | Array<String> */ = noImpl
        open fun apply(frameBuffer: WebGLFramebuffer): Unit = noImpl
        open fun syncUniforms(): Unit = noImpl
    }
    open class AlphaMaskFilter(texture: Texture) : AbstractFilter() {
        open var map: Texture = noImpl
        open fun onTextureLoaded(): Unit = noImpl
    }
    open class AsciiFilter : AbstractFilter() {
        open var size: Number = noImpl
    }
    interface `T$1` {
        fun get(key: String): Loader?
        fun set(key: String, value: Loader)
    }
    open class AssetLoader(assetURLs: Array<String>, crossorigin: Boolean) : Mixin {
        open var assetURLs: Array<String> = noImpl
        open var crossorigin: Boolean = noImpl
        open var loadersByType: `T$1` = noImpl
        override fun listeners(eventName: String): Array<Function<Any>> = noImpl
        override fun emit(eventName: String, data: Any?): Boolean = noImpl
        override fun dispatchEvent(eventName: String, data: Any?): Boolean = noImpl
        override fun on(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun once(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun off(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun removeAllEventListeners(eventName: String): Unit = noImpl
        open fun load(): Unit = noImpl
    }
    open class AtlasLoader(url: String, crossorigin: Boolean) : Mixin {
        open var url: String = noImpl
        open var baseUrl: String = noImpl
        open var crossorigin: Boolean = noImpl
        open var loaded: Boolean = noImpl
        override fun listeners(eventName: String): Array<Function<Any>> = noImpl
        override fun emit(eventName: String, data: Any?): Boolean = noImpl
        override fun dispatchEvent(eventName: String, data: Any?): Boolean = noImpl
        override fun on(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun once(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun off(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun removeAllEventListeners(eventName: String): Unit = noImpl
        open fun load(): Unit = noImpl
    }
    open class BaseTexture() : Mixin {
        constructor(source: HTMLImageElement, scaleMode: scaleModes):this()
        constructor(source: HTMLCanvasElement, scaleMode: scaleModes):this()
        open var height: Number = noImpl
        open var hasLoaded: Boolean = noImpl
        open var mipmap: Boolean = noImpl
        open var premultipliedAlpha: Boolean = noImpl
        open var resolution: Number = noImpl
        open var scaleMode: scaleModes = noImpl
        open var skipRender: Boolean = noImpl
        open var source: HTMLImageElement = noImpl
        open var textureIndex: Number = noImpl
        open var width: Number = noImpl
        override fun listeners(eventName: String): Array<Function<Any>> = noImpl
        override fun emit(eventName: String, data: Any?): Boolean = noImpl
        override fun dispatchEvent(eventName: String, data: Any?): Boolean = noImpl
        override fun on(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun once(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun off(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun removeAllEventListeners(eventName: String): Unit = noImpl
        open fun forceLoaded(width: Number, height: Number): Unit = noImpl
        open fun destroy(): Unit = noImpl
        open fun dirty(): Unit = noImpl
        open fun unloadFromGPU(): Unit = noImpl
        companion object {
            fun fromCanvas(canvas: HTMLCanvasElement, scaleMode: scaleModes?): BaseTexture = noImpl
        }
    }
    open class BitmapFontLoader(url: String, crossorigin: Boolean) : Mixin {
        open var baseUrl: String = noImpl
        open var crossorigin: Boolean = noImpl
        open var texture: Texture = noImpl
        open var url: String = noImpl
        override fun listeners(eventName: String): Array<Function<Any>> = noImpl
        override fun emit(eventName: String, data: Any?): Boolean = noImpl
        override fun dispatchEvent(eventName: String, data: Any?): Boolean = noImpl
        override fun on(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun once(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun off(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun removeAllEventListeners(eventName: String): Unit = noImpl
        open fun load(): Unit = noImpl
    }
    open class BlurFilter : AbstractFilter() {
        open var blur: Number = noImpl
        open var blurX: Number = noImpl
        open var blurY: Number = noImpl
    }
    open class BlurXFilter : AbstractFilter() {
        open var blur: Number = noImpl
    }
    open class BlurYFilter : AbstractFilter() {
        open var blur: Number = noImpl
    }
    open class CanvasBuffer(width: Number, height: Number) {
        open var canvas: HTMLCanvasElement = noImpl
        open var context: CanvasRenderingContext2D = noImpl
        open var height: Number = noImpl
        open var width: Number = noImpl
        open fun destroy(): Unit = noImpl
        open fun clear(): Unit = noImpl
        open fun resize(width: Number, height: Number): Unit = noImpl
    }
    open class CanvasPool {
        companion object {
            fun create(parent: HTMLElement, width: Number?, height: Number?): HTMLCanvasElement = noImpl
            fun getFirst(): HTMLCanvasElement = noImpl
            fun remove(parent: HTMLElement): Unit = noImpl
            fun removeByCanvas(canvas: HTMLCanvasElement): HTMLCanvasElement = noImpl
            fun getTotal(): Number = noImpl
            fun getFree(): Number = noImpl
        }
    }
    open class CanvasMaskManager {
        open fun pushMask(maskData: MaskData, renderSession: RenderSession): Unit = noImpl
        open fun popMask(renderSession: RenderSession): Unit = noImpl
    }
    open abstract class CanvasRenderer(game: Phaser.Game) : PixiRenderer {
        open var game: Phaser.Game = noImpl
        override var type: Number = noImpl
        override var resolution: Number = noImpl
        override var clearBeforeRender: Boolean = noImpl
        override var transparent: Boolean = noImpl
        override var autoResize: Boolean = noImpl
        override var width: Number = noImpl
        override var height: Number = noImpl
        override var view: HTMLCanvasElement = noImpl
        open var context: CanvasRenderingContext2D = noImpl
        open var refresh: Boolean = noImpl
        open var count: Number = noImpl
        open var maskManager: CanvasMaskManager = noImpl
        open var renderSession: RenderSession = noImpl
        override fun render(stage: DisplayObjectContainer): Unit = noImpl
        override fun resize(width: Number, height: Number): Unit = noImpl
        open fun destroy(removeView: Boolean?): Unit = noImpl
    }
    open class CanvasTinter {
        companion object {
            fun getTintedTexture(sprite: Sprite, color: Number): HTMLCanvasElement = noImpl
            fun tintWithMultiply(texture: Texture, color: Number, canvas: HTMLCanvasElement): Unit = noImpl
            fun tintWithOverlay(texture: Texture, color: Number, canvas: HTMLCanvasElement): Unit = noImpl
            fun tintWithPerPixel(texture: Texture, color: Number, canvas: HTMLCanvasElement): Unit = noImpl
            var canUseMultiply: Boolean = noImpl
            //var tintMethod: Any = noImpl
            fun tintMethod(texture: Texture, color: Number, canvas: HTMLCanvasElement): Unit = noImpl

        }
    }
    open class Circle(x: Number, y: Number, radius: Number) : HitArea {
        open var x: Number = noImpl
        open var y: Number = noImpl
        open var radius: Number = noImpl
        open fun clone(): Circle = noImpl
        override fun contains(x: Number, y: Number): Boolean = noImpl
        open fun getBounds(): Rectangle = noImpl
    }
    open class ColorMatrixFilter : AbstractFilter() {
        open var matrix: Array<Number> = noImpl
    }
    open class ColorStepFilter : AbstractFilter() {
        open var step: Number = noImpl
    }
    open class ConvolutionFilter(matrix: Array<Number>, width: Number, height: Number) : AbstractFilter() {
        open var matrix: Matrix = noImpl
        open var width: Number = noImpl
        open var height: Number = noImpl
    }
    open class CrossHatchFilter : AbstractFilter() {
        open var blur: Number = noImpl
    }
    open class DisplacementFilter(texture: Texture) : AbstractFilter() {
        open var map: Texture = noImpl
        open var offset: Point = noImpl
        open var scale: Point = noImpl
    }
    open class DotScreenFilter : AbstractFilter() {
        open var angle: Number = noImpl
        open var scale: Point = noImpl
    }
    abstract class DisplayObject {
        open var alpha: Double = noImpl
        open var buttonMode: Boolean = noImpl
        open var cacheAsBitmap: Boolean = noImpl
        open var defaultCursor: String = noImpl
        open var filterArea: Rectangle = noImpl
        open var filters: Array<AbstractFilter> = noImpl
        open var hitArea: HitArea = noImpl
        open var interactive: Boolean = noImpl
        open var mask: Graphics = noImpl
        open var parent: DisplayObjectContainer = noImpl
        open var pivot: Point = noImpl
        open var position: Phaser.Point = noImpl
        open var renderable: Boolean = noImpl
        open var rotation: Double = noImpl
        open var scale: Phaser.Point = noImpl
        open var stage: DisplayObjectContainer = noImpl
        open var visible: Boolean = noImpl
        open var worldAlpha: Number = noImpl
        open var worldPosition: Point = noImpl
        open var worldScale: Point = noImpl
        open var worldTransform: Matrix = noImpl
        open var worldRotation: Number = noImpl
        open var worldVisible: Boolean = noImpl
        open var x: Double = noImpl
        open var y: Double = noImpl
        open var z: Double = noImpl
        open fun click(e: InteractionData): Unit = noImpl
        open fun displayObjectUpdateTransform(parent: DisplayObjectContainer?): Unit = noImpl
        open fun generateTexture(resolution: Number? , scaleMode: Number? , renderer: Any?): RenderTexture = noImpl
        //open fun generateTexture(resolution: Number? , scaleMode: Number? , renderer: PixiRenderer?): RenderTexture = noImpl
        //open fun generateTexture(resolution: Number? , scaleMode: Number? , renderer: Number? ): RenderTexture = noImpl
        open fun mousedown(e: InteractionData): Unit = noImpl
        open fun mouseout(e: InteractionData): Unit = noImpl
        open fun mouseover(e: InteractionData): Unit = noImpl
        open fun mouseup(e: InteractionData): Unit = noImpl
        open fun mousemove(e: InteractionData): Unit = noImpl
        open fun mouseupoutside(e: InteractionData): Unit = noImpl
        open fun rightclick(e: InteractionData): Unit = noImpl
        open fun rightdown(e: InteractionData): Unit = noImpl
        open fun rightup(e: InteractionData): Unit = noImpl
        open fun rightupoutside(e: InteractionData): Unit = noImpl
        open fun setStageReference(stage: DisplayObjectContainer): Unit = noImpl
        open fun tap(e: InteractionData): Unit = noImpl
        open fun toGlobal(position: Point): Point = noImpl
        open fun toLocal(position: Point, from: DisplayObject): Point = noImpl
        open fun touchend(e: InteractionData): Unit = noImpl
        open fun touchendoutside(e: InteractionData): Unit = noImpl
        open fun touchstart(e: InteractionData): Unit = noImpl
        open fun touchmove(e: InteractionData): Unit = noImpl
        open fun updateTransform(parent: DisplayObjectContainer?): Unit = noImpl
        //open fun alignTo(container: DisplayObject, position: Number?): Sprite
        //open fun alignTo(container: DisplayObject, position: Number?, offsetX: Number?): Sprite
        //open fun alignTo(container: DisplayObject, position: Number?, offsetX: Number?, offsetY: Number?): Sprite
        @JsName("alignTo")
        open fun alignToJs(container: Any, position: Number?, offsetX: Number?, offsetY: Number?): Sprite
        open var userData:dynamic
        open var id:Int
    }

    open class DisplayObjectContainer : DisplayObject() {
        open var children: Array<DisplayObject> = noImpl
        open var height: Double = noImpl
        open var width: Double = noImpl
        open var ignoreChildInput: Boolean = noImpl
        open fun <T:DisplayObject>addChild(child: T): T = noImpl
        //open fun addChild(child: DisplayObject): DisplayObject = noImpl
        open fun addChildAt(child: DisplayObject, index: Number): DisplayObject = noImpl
        //open fun getBounds(): Rectangle
        //open fun getBounds(targetCoordinateSpace: DisplayObject): Rectangle
        //open fun getBounds(): Phaser.Rectangle
        //open fun getBounds(targetCoordinateSpace: Matrix): Phaser.Rectangle
        @JsName("getBounds")
        open fun getBoundsJs(targetCoordinateSpace: Any?): Phaser.Rectangle
        open fun getChildAt(index: Number): DisplayObject = noImpl
        open fun getChildIndex(child: DisplayObject): Number = noImpl
        open fun getLocalBounds(): Phaser.Rectangle = noImpl
        open fun removeChild(child: DisplayObject): DisplayObject = noImpl
        open fun removeChildAt(index: Number): DisplayObject = noImpl
        open fun removeChildren(beginIndex: Number?, endIndex: Number?): Array<DisplayObject> = noImpl
        open fun removeStageReference(): Unit = noImpl
        open fun setChildIndex(child: DisplayObject, index: Number): Unit = noImpl
        open fun swapChildren(child: DisplayObject, child2: DisplayObject): Unit = noImpl
        open fun contains(child: DisplayObject): Boolean = noImpl
    }
    open class Ellipse(x: Number, y: Number, width: Number, height: Number) : HitArea {
        open var x: Number = noImpl
        open var y: Number = noImpl
        open var width: Number = noImpl
        open var height: Number = noImpl
        open fun clone(): Ellipse = noImpl
        override fun contains(x: Number, y: Number): Boolean = noImpl
        open fun getBounds(): Rectangle = noImpl
    }
    open class Event(target: Any, name: String, data: Any) {
        open var target: Any = noImpl
        open var type: String = noImpl
        open var data: Any = noImpl
        open var timeStamp: Number = noImpl
        open fun stopPropagation(): Unit = noImpl
        open fun preventDefault(): Unit = noImpl
        open fun stopImmediatePropagation(): Unit = noImpl
    }
    open class EventTarget {
        companion object {
            fun mixin(obj: Any): Unit = noImpl
        }
    }
    open class FilterTexture(gl: WebGLRenderingContext, width: Number, height: Number, scaleMode: scaleModes) {
        open var fragmentSrc: Array<String> = noImpl
        open var frameBuffer: WebGLFramebuffer = noImpl
        open var gl: WebGLRenderingContext = noImpl
        open var program: WebGLProgram = noImpl
        open var scaleMode: Number = noImpl
        open var texture: WebGLTexture = noImpl
        open fun clear(): Unit = noImpl
        open fun resize(width: Number, height: Number): Unit = noImpl
        open fun destroy(): Unit = noImpl
    }
    open class GraphicsData(lineWidth: Number?, lineColor: Number?, lineAlpha: Number?, fillColor: Number?, fillAlpha: Number?, fill: Boolean?, shape: Any?) {
        open var lineWidth: Number = noImpl
        open var lineColor: Number = noImpl
        open var lineAlpha: Number = noImpl
        open var fillColor: Number = noImpl
        open var fillAlpha: Number = noImpl
        open var fill: Boolean = noImpl
        open var shape: Any = noImpl
        open var type: Number = noImpl
    }
    open class Graphics : DisplayObjectContainer() {
        open var blendMode: Number = noImpl
        open var boundsPadding: Number = noImpl
        open var fillAlpha: Number = noImpl
        open var isMask: Boolean = noImpl
        open var lineWidth: Number = noImpl
        open var lineColor: Number = noImpl
        open var tint: Number = noImpl
        override var worldAlpha: Number = noImpl
        open fun arc(cx: Number, cy: Number, radius: Number, startAngle: Number, endAngle: Number, anticlockwise: Boolean): Graphics = noImpl
        open fun arcTo(x1: Number, y1: Number, x2: Number, y2: Number, radius: Number): Graphics = noImpl
        open fun beginFill(color: Number?): Graphics = noImpl
        open fun beginFill(color: Number?, alpha: Number?): Graphics = noImpl
        open fun bezierCurveTo(cpX: Number, cpY: Number, cpX2: Number, cpY2: Number, toX: Number, toY: Number): Graphics = noImpl
        open fun clear(): Graphics = noImpl
        open fun destroyCachedSprite(): Unit = noImpl
        open fun drawCircle(x: Number, y: Number, diameter: Number): Graphics = noImpl
        open fun drawEllipse(x: Number, y: Number, width: Number, height: Number): Graphics = noImpl
        open fun drawPolygon(vararg path: Any): Graphics = noImpl
        open fun drawRect(x: Number, y: Number, width: Number, height: Number): Graphics = noImpl
        open fun drawRoundedRect(x: Number, y: Number, width: Number, height: Number, radius: Number): Graphics = noImpl
        open fun drawShape(shape: Circle): GraphicsData = noImpl
        open fun drawShape(shape: Rectangle): GraphicsData = noImpl
        open fun drawShape(shape: Ellipse): GraphicsData = noImpl
        open fun drawShape(shape: Polygon): GraphicsData = noImpl
        open fun endFill(): Graphics = noImpl
        open fun generateTexture(): RenderTexture = noImpl
        open fun generateTexture(resolution: Number?, scaleMode: Number?, padding: Number?): RenderTexture = noImpl
        open fun lineStyle(lineWidth: Number?): Graphics = noImpl
        open fun lineStyle(lineWidth: Number?, color: Number?): Graphics = noImpl
        open fun lineStyle(lineWidth: Number?, color: Number?, alpha: Number?): Graphics = noImpl
        open fun lineTo(x: Number, y: Number): Graphics = noImpl
        open fun moveTo(x: Number, y: Number): Graphics = noImpl
        open fun quadraticCurveTo(cpX: Number, cpY: Number, toX: Number, toY: Number): Graphics = noImpl
        companion object {
            var POLY: Number = noImpl
            var RECT: Number = noImpl
            var CIRC: Number = noImpl
            var ELIP: Number = noImpl
            var RREC: Number = noImpl
        }
    }
    open class GrayFilter : AbstractFilter() {
        open var gray: Number = noImpl
    }
    open class ImageLoader(url: String, crossorigin: Boolean?) : Mixin {
        open var texture: Texture = noImpl
        override fun listeners(eventName: String): Array<Function<Any>> = noImpl
        override fun emit(eventName: String, data: Any?): Boolean = noImpl
        override fun dispatchEvent(eventName: String, data: Any?): Boolean = noImpl
        override fun on(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun once(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun off(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun removeAllEventListeners(eventName: String): Unit = noImpl
        open fun load(): Unit = noImpl
        open fun loadFramedSpriteSheet(frameWidth: Number, frameHeight: Number, textureName: String): Unit = noImpl
    }
    open class InteractionData {
        open var global: Point = noImpl
        open var target: Sprite = noImpl
        open var originalEvent: Event = noImpl
        open fun getLocalPosition(displayObject: DisplayObject, point: Point?, globalPos: Point?): Point = noImpl
    }
    interface `T$2` {
        fun get(id: String): InteractionData?
        fun set(id: String, value: InteractionData)
    }
    open class InteractionManager(stage: DisplayObjectContainer) {
        open var currentCursorStyle: String = noImpl
        open var last: Number = noImpl
        open var mouse: InteractionData = noImpl
        open var mouseOut: Boolean = noImpl
        open var mouseoverEnabled: Boolean = noImpl
        open var onMouseMove: Function<Any> = noImpl
        open var onMouseDown: Function<Any> = noImpl
        open var onMouseOut: Function<Any> = noImpl
        open var onMouseUp: Function<Any> = noImpl
        open var onTouchStart: Function<Any> = noImpl
        open var onTouchEnd: Function<Any> = noImpl
        open var onTouchMove: Function<Any> = noImpl
        open var pool: Array<InteractionData> = noImpl
        open var resolution: Number = noImpl
        open var stage: DisplayObjectContainer = noImpl
        open var touches: `T$2` = noImpl
    }
    open class InvertFilter : AbstractFilter() {
        open var invert: Number = noImpl
    }
    open class JsonLoader(url: String, crossorigin: Boolean?) : Mixin {
        open var baseUrl: String = noImpl
        open var crossorigin: Boolean = noImpl
        open var loaded: Boolean = noImpl
        open var url: String = noImpl
        override fun listeners(eventName: String): Array<Function<Any>> = noImpl
        override fun emit(eventName: String, data: Any?): Boolean = noImpl
        override fun dispatchEvent(eventName: String, data: Any?): Boolean = noImpl
        override fun on(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun once(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun off(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun removeAllEventListeners(eventName: String): Unit = noImpl
        open fun load(): Unit = noImpl
    }
    open class Matrix {
        open var a: Number = noImpl
        open var b: Number = noImpl
        open var c: Number = noImpl
        open var d: Number = noImpl
        open var tx: Number = noImpl
        open var ty: Number = noImpl
        open fun append(matrix: Matrix): Matrix = noImpl
        open fun apply(pos: Point, newPos: Point): Point = noImpl
        open fun applyInverse(pos: Point, newPos: Point): Point = noImpl
        open fun determineMatrixArrayType(): Array<Number> = noImpl
        open fun identity(): Matrix = noImpl
        open fun rotate(angle: Number): Matrix = noImpl
        open fun fromArray(array: Array<Number>): Unit = noImpl
        open fun translate(x: Number, y: Number): Matrix = noImpl
        open fun toArray(transpose: Boolean): Array<Number> = noImpl
        open fun scale(x: Number, y: Number): Matrix = noImpl
    }
    interface Mixin {
        fun listeners(eventName: String): Array<Function<Any>>
        fun emit(eventName: String, data: Any?): Boolean
        fun dispatchEvent(eventName: String, data: Any?): Boolean
        fun on(eventName: String, fn: Function<Any>): Function<Any>
        fun addEventListener(eventName: String, fn: Function<Any>): Function<Any>
        fun once(eventName: String, fn: Function<Any>): Function<Any>
        fun off(eventName: String, fn: Function<Any>): Function<Any>
        fun removeAllEventListeners(eventName: String)
    }
    open class NoiseFilter : AbstractFilter() {
        open var noise: Number = noImpl
    }
    open class NormalMapFilter : AbstractFilter() {
        open var map: Texture = noImpl
        open var offset: Point = noImpl
        open var scale: Point = noImpl
    }
    open class PixelateFilter : AbstractFilter() {
        open var size: Number = noImpl
    }
    interface IPixiShader {
        var fragmentSrc: Array<String>
        var gl: WebGLRenderingContext
        var program: WebGLProgram
        var vertexSrc: Array<String>
        fun destroy()
        fun init()
    }
    open class PixiShader(gl: WebGLRenderingContext) : IPixiShader {
        open var attributes: Array<ShaderAttribute> = noImpl
        open var defaultVertexSrc: Array<String> = noImpl
        open var dirty: Boolean = noImpl
        open var firstRun: Boolean = noImpl
        open var textureCount: Number = noImpl
        override var fragmentSrc: Array<String> = noImpl
        override var gl: WebGLRenderingContext = noImpl
        override var program: WebGLProgram = noImpl
        override var vertexSrc: Array<String> = noImpl
        open fun initSampler2D(): Unit = noImpl
        open fun initUniforms(): Unit = noImpl
        open fun syncUniforms(): Unit = noImpl
        override fun destroy(): Unit = noImpl
        override fun init(): Unit = noImpl
    }
    open class PixiFastShader(gl: WebGLRenderingContext) : IPixiShader {
        open var textureCount: Number = noImpl
        override var fragmentSrc: Array<String> = noImpl
        override var gl: WebGLRenderingContext = noImpl
        override var program: WebGLProgram = noImpl
        override var vertexSrc: Array<String> = noImpl
        override fun destroy(): Unit = noImpl
        override fun init(): Unit = noImpl
    }
    open class PrimitiveShader(gl: WebGLRenderingContext) : IPixiShader {
        override var fragmentSrc: Array<String> = noImpl
        override var gl: WebGLRenderingContext = noImpl
        override var program: WebGLProgram = noImpl
        override var vertexSrc: Array<String> = noImpl
        override fun destroy(): Unit = noImpl
        override fun init(): Unit = noImpl
    }
    open class ComplexPrimitiveShader(gl: WebGLRenderingContext) : IPixiShader {
        override var fragmentSrc: Array<String> = noImpl
        override var gl: WebGLRenderingContext = noImpl
        override var program: WebGLProgram = noImpl
        override var vertexSrc: Array<String> = noImpl
        override fun destroy(): Unit = noImpl
        override fun init(): Unit = noImpl
    }
    open class StripShader(gl: WebGLRenderingContext) : IPixiShader {
        override var fragmentSrc: Array<String> = noImpl
        override var gl: WebGLRenderingContext = noImpl
        override var program: WebGLProgram = noImpl
        override var vertexSrc: Array<String> = noImpl
        override fun destroy(): Unit = noImpl
        override fun init(): Unit = noImpl
    }
    /*open class Point(x: Number?, y: Number?) {
        open var x: Double = noImpl
        open var y: Double = noImpl
        open fun clone(): Point = noImpl
        open fun set(x: Number, y: Number?): Unit = noImpl
    }*/
    open class Polygon : HitArea {
        constructor(points: Array<Point>)
        constructor(points: Array<Number>)
        constructor(vararg points: Point)
        constructor(vararg points: Number)
        open var points: Array<Any> = noImpl
        open fun clone(): Polygon = noImpl
        override fun contains(x: Number, y: Number): Boolean = noImpl
    }
    open class Rectangle(x: Number?, y: Number?, width: Number?, height: Number?) : HitArea {
        open var x: Number = noImpl
        open var y: Number = noImpl
        open var width: Number = noImpl
        open var height: Number = noImpl
        open fun clone(): Rectangle = noImpl
        override fun contains(x: Number, y: Number): Boolean = noImpl
    }
    open class RGBSplitFilter : AbstractFilter() {
        open var red: Point = noImpl
        open var green: Point = noImpl
        open var blue: Point = noImpl
    }
    open class Rope(texture: Texture?, points: Array<Phaser.Point>?) : Strip(texture) {
        //open var points: Array<Point> = noImpl
        override var vertices: Array<Number> = noImpl
        open fun refresh(): Unit = noImpl
        open fun setTexture(texture: Texture): Unit = noImpl
    }
    open class RoundedRectangle(x: Number?, y: Number?, width: Number?, height: Number?, radius: Number?) : HitArea {
        open var x: Number = noImpl
        open var y: Number = noImpl
        open var width: Number = noImpl
        open var height: Number = noImpl
        open var radius: Number = noImpl
        open fun clone(): RoundedRectangle = noImpl
        override fun contains(x: Number, y: Number): Boolean = noImpl
    }
    open class SepiaFilter : AbstractFilter() {
        open var sepia: Number = noImpl
    }
    open class SmartBlurFilter : AbstractFilter() {
        open var blur: Number = noImpl
    }
    open class SpineLoader(url: String, crossOrigin: Boolean) : Mixin {
        open var url: String = noImpl
        open var crossorigin: Boolean = noImpl
        open var loaded: Boolean = noImpl
        override fun listeners(eventName: String): Array<Function<Any>> = noImpl
        override fun emit(eventName: String, data: Any?): Boolean = noImpl
        override fun dispatchEvent(eventName: String, data: Any?): Boolean = noImpl
        override fun on(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun once(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun off(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun removeAllEventListeners(eventName: String): Unit = noImpl
        open fun load(): Unit = noImpl
    }
    open class SpineTextureLoader(basePath: String, crossorigin: Boolean) {
        open fun load(page: AtlasPage, file: String): Unit = noImpl
        open fun unload(texture: BaseTexture): Unit = noImpl
    }
    open class Sprite(texture: Texture?) : DisplayObjectContainer() {
        //open var anchor: Point = noImpl
        open var blendMode: blendModes
        open var exists: Boolean = noImpl
        open var shader: IPixiShader = noImpl
        open var texture: Texture = noImpl
        open var tint: Number = noImpl
        //open fun setTexture(texture: Any): Unit = noImpl
        @JsName("setTexture")
        fun setTextureJs(texture: Any, destroyBase: Boolean?): Unit = noImpl
        //open fun setTexture(texture: Texture, destroyBase: Boolean?): Unit = noImpl
        //open fun setTexture(texture: RenderTexture): Unit = noImpl
    }
    open class SpriteBatch(texture: Texture?) : DisplayObjectContainer() {
        open var ready: Boolean = noImpl
        open var textureThing: Texture = noImpl
        open fun initWebGL(gl: WebGLRenderingContext): Unit = noImpl
    }
    open class SpriteSheetLoader(url: String, crossorigin: Boolean?) : Mixin {
        open var baseUrl: String = noImpl
        open var crossorigin: Boolean = noImpl
        open var frames: Any = noImpl
        open var texture: Texture = noImpl
        open var url: String = noImpl
        override fun listeners(eventName: String): Array<Function<Any>> = noImpl
        override fun emit(eventName: String, data: Any?): Boolean = noImpl
        override fun dispatchEvent(eventName: String, data: Any?): Boolean = noImpl
        override fun on(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun once(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun off(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun removeAllEventListeners(eventName: String): Unit = noImpl
        open fun load(): Unit = noImpl
    }
    interface `T$3` {
        var TRIANGLE_STRIP: Number
        var TRIANGLES: Number
    }
    open class Strip(texture: Texture?) : DisplayObjectContainer() {
        open var blendMode: Number = noImpl
        open var colors: Array<Number> = noImpl
        open var dirty: Boolean = noImpl
        open var indices: Array<Number> = noImpl
        open var canvasPadding: Number = noImpl
        open var texture: Texture = noImpl
        open var uvs: Array<Number> = noImpl
        open var vertices: Array<Number> = noImpl
        //override fun getBounds(matrix: Matrix): Phaser.Rectangle
        companion object {
            var DrawModes: `T$3` = noImpl
        }
    }
    open class Texture(baseTexture: BaseTexture, frame: Rectangle?, crop: Rectangle?, trim: Rectangle?) : Mixin {
        open var baseTexture: BaseTexture = noImpl
        open var crop: Rectangle = noImpl
        open var frame: Rectangle = noImpl
        open var height: Number = noImpl
        open var noFrame: Boolean = noImpl
        open var requiresUpdate: Boolean = noImpl
        open var trim: Point = noImpl
        open var width: Number = noImpl
        open var scope: Any = noImpl
        open var valid: Boolean = noImpl
        open var rotated: Boolean = noImpl
        override fun listeners(eventName: String): Array<Function<Any>> = noImpl
        override fun emit(eventName: String, data: Any?): Boolean = noImpl
        override fun dispatchEvent(eventName: String, data: Any?): Boolean = noImpl
        override fun on(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun once(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun off(eventName: String, fn: Function<Any>): Function<Any> = noImpl
        override fun removeAllEventListeners(eventName: String): Unit = noImpl
        open fun destroy(destroyBase: Boolean): Unit = noImpl
        open fun setFrame(frame: Rectangle): Unit = noImpl
        companion object {
            var emptyTexture: Texture = noImpl
            fun fromCanvas(canvas: HTMLCanvasElement, scaleMode: scaleModes?): Texture = noImpl
        }
    }
    open class TilingSprite(texture: Texture?, width: Number?, height: Number?) : Sprite(texture) {
        open var canvasBuffer: PIXI.CanvasBuffer = noImpl
        //override var blendMode: Number
        open var refreshTexture: Boolean = noImpl
        override var texture: Texture = noImpl
        open var textureDebug: Boolean = noImpl
        override var tint: Number = noImpl
        open var tilePosition: Point = noImpl
        open var tilePattern: PIXI.Texture = noImpl
        open var tileScale: Point = noImpl
        open var tileScaleOffset: Point = noImpl
        open fun destroy(): Unit = noImpl
        open fun generateTilingTexture(forcePowerOfTwo: Boolean?): Unit = noImpl
        open fun setTexture(texture: Texture): Unit = noImpl
    }
    open class TiltShiftFilter : AbstractFilter() {
        open var blur: Number = noImpl
        open var gradientBlur: Number = noImpl
        open var start: Number = noImpl
        open var end: Number = noImpl
    }
    open class TiltShiftXFilter : AbstractFilter() {
        open var blur: Number = noImpl
        open var gradientBlur: Number = noImpl
        open var start: Number = noImpl
        open var end: Number = noImpl
        open fun updateDelta(): Unit = noImpl
    }
    open class TiltShiftYFilter : AbstractFilter() {
        open var blur: Number = noImpl
        open var gradientBlur: Number = noImpl
        open var start: Number = noImpl
        open var end: Number = noImpl
        open fun updateDelta(): Unit = noImpl
    }
    open class TwistFilter : AbstractFilter() {
        open var angle: Number = noImpl
        open var offset: Point = noImpl
        open var radius: Number = noImpl
    }
    open class VideoTexture() : BaseTexture() {
        open var controls: Boolean = noImpl
        open var autoUpdate: Boolean = noImpl
        open var type: String = noImpl
        open fun changeSource(src: String, type: String, loop: Boolean): Unit = noImpl
        open fun play(): Unit = noImpl
        open fun stop(): Unit = noImpl
        override fun destroy(): Unit = noImpl
        open fun updateBound(): Unit = noImpl
        open var onPlayStart: () -> Unit = noImpl
        open var onPlayStop: () -> Unit = noImpl
        open var onCanPlay: (event: Any) -> Unit = noImpl
        companion object {
            fun baseTextureFromVideo(video: HTMLVideoElement, scaleMode: Number): BaseTexture = noImpl
            fun textureFromVideo(video: HTMLVideoElement, scaleMode: Number): Texture = noImpl
            fun fromUrl(videoSrc: String, scaleMode: Number?, autoPlay: Boolean?, type: String?, loop: Boolean?): Texture = noImpl
        }
    }
    open class WebGLBlendModeManager {
        open var currentBlendMode: Number = noImpl
        open fun destroy(): Unit = noImpl
        open fun setBlendMode(blendMode: Number): Boolean = noImpl
        open fun setContext(gl: WebGLRenderingContext): Unit = noImpl
    }
    open class WebGLFastSpriteBatch(gl: CanvasRenderingContext2D) {
        open var currentBatchSize: Number = noImpl
        open var currentBaseTexture: BaseTexture = noImpl
        open var currentBlendMode: Number = noImpl
        open var renderSession: RenderSession = noImpl
        open var drawing: Boolean = noImpl
        open var indexBuffer: Any = noImpl
        open var indices: Array<Number> = noImpl
        open var lastIndexCount: Number = noImpl
        open var matrix: Matrix = noImpl
        open var maxSize: Number = noImpl
        open var shader: IPixiShader = noImpl
        open var size: Number = noImpl
        open var vertexBuffer: Any = noImpl
        open var vertices: Array<Number> = noImpl
        open var vertSize: Number = noImpl
        open fun end(): Unit = noImpl
        open fun begin(spriteBatch: SpriteBatch, renderSession: RenderSession): Unit = noImpl
        open fun destroy(removeView: Boolean?): Unit = noImpl
        open fun flush(): Unit = noImpl
        open fun render(spriteBatch: SpriteBatch): Unit = noImpl
        open fun renderSprite(sprite: Sprite): Unit = noImpl
        open fun setContext(gl: WebGLRenderingContext): Unit = noImpl
        open fun start(): Unit = noImpl
        open fun stop(): Unit = noImpl
    }
    open class WebGLFilterManager {
        open var filterStack: Array<AbstractFilter> = noImpl
        open var transparent: Boolean = noImpl
        open var offsetX: Number = noImpl
        open var offsetY: Number = noImpl
        open fun applyFilterPass(filter: AbstractFilter, filterArea: Texture, width: Number, height: Number): Unit = noImpl
        open fun begin(renderSession: RenderSession, buffer: ArrayBuffer): Unit = noImpl
        open fun destroy(): Unit = noImpl
        open fun initShaderBuffers(): Unit = noImpl
        open fun popFilter(): Unit = noImpl
        open fun pushFilter(filterBlock: FilterBlock): Unit = noImpl
        open fun setContext(gl: WebGLRenderingContext): Unit = noImpl
    }
    open class WebGLGraphics {
        open fun reset(): Unit = noImpl
        open fun upload(): Unit = noImpl
        companion object {
            var graphicsDataPool: Array<Any> = noImpl
            fun renderGraphics(graphics: Graphics, renderRession: RenderSession): Unit = noImpl
            fun updateGraphics(graphics: Graphics, gl: WebGLRenderingContext): Unit = noImpl
            fun switchMode(webGL: WebGLRenderingContext, type: Number): Any = noImpl
            fun buildRectangle(graphicsData: GraphicsData, webGLData: Any): Unit = noImpl
            fun buildRoundedRectangle(graphicsData: GraphicsData, webGLData: Any): Unit = noImpl
            fun quadraticBezierCurve(fromX: Number, fromY: Number, cpX: Number, cpY: Number, toX: Number, toY: Number): Array<Number> = noImpl
            fun buildCircle(graphicsData: GraphicsData, webGLData: Any): Unit = noImpl
            fun buildLine(graphicsData: GraphicsData, webGLData: Any): Unit = noImpl
            fun buildComplexPoly(graphicsData: GraphicsData, webGLData: Any): Unit = noImpl
            fun buildPoly(graphicsData: GraphicsData, webGLData: Any): Boolean = noImpl
        }
    }
    open class WebGLGraphicsData(gl: WebGLRenderingContext) {
        open var gl: WebGLRenderingContext = noImpl
        open var glPoints: Array<Any> = noImpl
        open var color: Array<Number> = noImpl
        open var points: Array<Any> = noImpl
        open var indices: Array<Any> = noImpl
        open var buffer: WebGLBuffer = noImpl
        open var indexBuffer: WebGLBuffer = noImpl
        open var mode: Number = noImpl
        open var alpha: Number = noImpl
        open var dirty: Boolean = noImpl
        open fun reset(): Unit = noImpl
        open fun upload(): Unit = noImpl
    }
    open class WebGLMaskManager {
        open fun destroy(): Unit = noImpl
        open fun popMask(renderSession: RenderSession): Unit = noImpl
        open fun pushMask(maskData: Array<Any>, renderSession: RenderSession): Unit = noImpl
        open fun setContext(gl: WebGLRenderingContext): Unit = noImpl
    }
    open class WebGLRenderer(game: Phaser.Game) : PixiRenderer {
        open var game: Phaser.Game = noImpl
        override var type: Number = noImpl
        override var resolution: Number = noImpl
        override var transparent: Boolean = noImpl
        override var autoResize: Boolean = noImpl
        open var preserveDrawingBuffer: Boolean = noImpl
        override var clearBeforeRender: Boolean = noImpl
        override var width: Number = noImpl
        override var height: Number = noImpl
        open var currentBatchedTextures: Array<String> = noImpl
        override var view: HTMLCanvasElement = noImpl
        open var projection: Point = noImpl
        open var offset: Point = noImpl
        open var shaderManager: WebGLShaderManager = noImpl
        open var spriteBatch: WebGLSpriteBatch = noImpl
        open var maskManager: WebGLMaskManager = noImpl
        open var filterManager: WebGLFilterManager = noImpl
        open var stencilManager: WebGLStencilManager = noImpl
        open var blendModeManager: WebGLBlendModeManager = noImpl
        open var renderSession: RenderSession = noImpl
        open fun initContext(): Unit = noImpl
        override fun render(stage: DisplayObjectContainer): Unit = noImpl
        open fun renderDisplayObject(displayObject: DisplayObject, projection: Point, buffer: WebGLBuffer): Unit = noImpl
        override fun resize(width: Number, height: Number): Unit = noImpl
        open fun updateTexture(texture: Texture): Unit = noImpl
        override fun destroy(): Unit = noImpl
        open fun mapBlendModes(): Unit = noImpl
        open fun setTexturePriority(textureNameCollection: Array<String>): Array<String> = noImpl
        companion object {
            fun createWebGLTexture(texture: Texture, gl: WebGLRenderingContext): Unit = noImpl
        }
    }
    open class WebGLShaderManager {
        open var maxAttibs: Number = noImpl
        open var attribState: Array<Any> = noImpl
        open var stack: Array<Any> = noImpl
        open var tempAttribState: Array<Any> = noImpl
        open fun destroy(): Unit = noImpl
        open fun setAttribs(attribs: Array<ShaderAttribute>): Unit = noImpl
        open fun setContext(gl: WebGLRenderingContext): Unit = noImpl
        open fun setShader(shader: IPixiShader): Boolean = noImpl
    }
    open class WebGLStencilManager {
        open var stencilStack: Array<Any> = noImpl
        open var reverse: Boolean = noImpl
        open var count: Number = noImpl
        open fun bindGraphics(graphics: Graphics, webGLData: Array<Any>, renderSession: RenderSession): Unit = noImpl
        open fun destroy(): Unit = noImpl
        open fun popStencil(graphics: Graphics, webGLData: Array<Any>, renderSession: RenderSession): Unit = noImpl
        open fun pushStencil(graphics: Graphics, webGLData: Array<Any>, renderSession: RenderSession): Unit = noImpl
        open fun setContext(gl: WebGLRenderingContext): Unit = noImpl
    }
    open class WebGLSpriteBatch {
        open var blendModes: Array<Number> = noImpl
        open var colors: Array<Number> = noImpl
        open var currentBatchSize: Number = noImpl
        open var currentBaseTexture: Texture = noImpl
        open var defaultShader: AbstractFilter = noImpl
        open var dirty: Boolean = noImpl
        open var drawing: Boolean = noImpl
        open var indices: Array<Number> = noImpl
        open var lastIndexCount: Number = noImpl
        open var positions: Array<Number> = noImpl
        open var textures: Array<Texture> = noImpl
        open var shaders: Array<IPixiShader> = noImpl
        open var size: Number = noImpl
        open var sprites: Array<Any> = noImpl
        open var vertices: Array<Number> = noImpl
        open var vertSize: Number = noImpl
        open fun begin(renderSession: RenderSession): Unit = noImpl
        open fun destroy(): Unit = noImpl
        open fun end(): Unit = noImpl
        open fun flush(shader: IPixiShader?): Unit = noImpl
        open fun render(sprite: Sprite): Unit = noImpl
        open fun renderBatch(texture: Texture, size: Number, startIndex: Number): Unit = noImpl
        open fun renderTilingSprite(sprite: TilingSprite): Unit = noImpl
        open fun setBlendMode(blendMode: blendModes): Unit = noImpl
        open fun setContext(gl: WebGLRenderingContext): Unit = noImpl
        open fun start(): Unit = noImpl
        open fun stop(): Unit = noImpl
    }
    /*open class RenderTexture(width: Number?, height: Number?, renderer: PixiRenderer?, scaleMode: scaleModes?, resolution: Number?)
        : Texture() {
        override var frame: Rectangle = noImpl
        override var baseTexture: BaseTexture = noImpl
        open var renderer: PixiRenderer = noImpl
        open var resolution: Number = noImpl
        override var valid: Boolean = noImpl
        open fun clear(): Unit = noImpl
        open fun getBase64(): String = noImpl
        open fun getCanvas(): HTMLCanvasElement = noImpl
        open fun getImage(): HTMLImageElement = noImpl
        open fun resize(width: Number, height: Number, updateBase: Boolean): Unit = noImpl
        open fun render(displayObject: DisplayObject, matrix: Matrix?, clear: Boolean?): Unit = noImpl
    }*/
    open class BoneData(name: String, parent: Any?) {
        open var name: String = noImpl
        open var parent: Any = noImpl
        open var length: Number = noImpl
        open var x: Number = noImpl
        open var y: Number = noImpl
        open var rotation: Number = noImpl
        open var scaleX: Number = noImpl
        open var scaleY: Number = noImpl
    }
    open class SlotData(name: String, boneData: BoneData) {
        open var name: String = noImpl
        open var boneData: BoneData = noImpl
        open var r: Number = noImpl
        open var g: Number = noImpl
        open var b: Number = noImpl
        open var a: Number = noImpl
        open var attachmentName: String = noImpl
    }
    open class Bone(boneData: BoneData, parent: Any?) {
        open var data: BoneData = noImpl
        open var parent: Any = noImpl
        open var yDown: Boolean = noImpl
        open var x: Number = noImpl
        open var y: Number = noImpl
        open var rotation: Number = noImpl
        open var scaleX: Number = noImpl
        open var scaleY: Number = noImpl
        open var worldRotation: Number = noImpl
        open var worldScaleX: Number = noImpl
        open var worldScaleY: Number = noImpl
        open fun updateWorldTransform(flipX: Boolean, flip: Boolean): Unit = noImpl
        open fun setToSetupPose(): Unit = noImpl
    }
    open class Slot(slotData: SlotData, skeleton: Skeleton, bone: Bone) {
        open var data: SlotData = noImpl
        open var skeleton: Skeleton = noImpl
        open var bone: Bone = noImpl
        open var r: Number = noImpl
        open var g: Number = noImpl
        open var b: Number = noImpl
        open var a: Number = noImpl
        open var attachment: RegionAttachment = noImpl
        open fun setAttachment(attachment: RegionAttachment): Unit = noImpl
        open fun setAttachmentTime(time: Number): Unit = noImpl
        open fun getAttachmentTime(): Number = noImpl
        open fun setToSetupPose(): Unit = noImpl
    }
    open class Skin(name: String) {
        open var name: String = noImpl
        open var attachments: Any = noImpl
        open fun addAttachment(slotIndex: Number, name: String, attachment: RegionAttachment): Unit = noImpl
        open fun getAttachment(slotIndex: Number, name: String): Unit = noImpl
    }
    open class Animation(name: String, timelines: Array<ISpineTimeline>, duration: Number) {
        open var name: String = noImpl
        open var timelines: Array<ISpineTimeline> = noImpl
        open var duration: Number = noImpl
        open fun apply(skeleton: Skeleton, time: Number, loop: Boolean): Unit = noImpl
        open fun min(skeleton: Skeleton, time: Number, loop: Boolean, alpha: Number): Unit = noImpl
    }
    open class Curves(frameCount: Number) {
        open var curves: Array<Number> = noImpl
        open fun setLinear(frameIndex: Number): Unit = noImpl
        open fun setStepped(frameIndex: Number): Unit = noImpl
        open fun setCurve(frameIndex: Number, cx1: Number, cy1: Number, cx2: Number, cy2: Number): Unit = noImpl
        open fun getCurvePercent(frameIndex: Number, percent: Number): Number = noImpl
    }
    interface ISpineTimeline {
        var curves: Curves
        var frames: Array<Number>
        fun getFrameCount(): Number
        fun apply(skeleton: Skeleton, time: Number, alpha: Number)
    }
    open class RotateTimeline(frameCount: Number) : ISpineTimeline {
        override var curves: Curves = noImpl
        override var frames: Array<Number> = noImpl
        open var boneIndex: Number = noImpl
        override fun getFrameCount(): Number = noImpl
        open fun setFrame(frameIndex: Number, time: Number, angle: Number): Unit = noImpl
        override fun apply(skeleton: Skeleton, time: Number, alpha: Number): Unit = noImpl
    }
    open class TranslateTimeline(frameCount: Number) : ISpineTimeline {
        override var curves: Curves = noImpl
        override var frames: Array<Number> = noImpl
        open var boneIndex: Number = noImpl
        override fun getFrameCount(): Number = noImpl
        open fun setFrame(frameIndex: Number, time: Number, x: Number, y: Number): Unit = noImpl
        override fun apply(skeleton: Skeleton, time: Number, alpha: Number): Unit = noImpl
    }
    open class ScaleTimeline(frameCount: Number) : ISpineTimeline {
        override var curves: Curves = noImpl
        override var frames: Array<Number> = noImpl
        open var boneIndex: Number = noImpl
        override fun getFrameCount(): Number = noImpl
        open fun setFrame(frameIndex: Number, time: Number, x: Number, y: Number): Unit = noImpl
        override fun apply(skeleton: Skeleton, time: Number, alpha: Number): Unit = noImpl
    }
    open class ColorTimeline(frameCount: Number) : ISpineTimeline {
        override var curves: Curves = noImpl
        override var frames: Array<Number> = noImpl
        open var boneIndex: Number = noImpl
        override fun getFrameCount(): Number = noImpl
        open fun setFrame(frameIndex: Number, time: Number, r: Number, g: Number, b: Number, a: Number): Unit = noImpl
        override fun apply(skeleton: Skeleton, time: Number, alpha: Number): Unit = noImpl
    }
    open class AttachmentTimeline(frameCount: Number) : ISpineTimeline {
        override var curves: Curves = noImpl
        override var frames: Array<Number> = noImpl
        open var attachmentNames: Array<String> = noImpl
        open var slotIndex: Number = noImpl
        override fun getFrameCount(): Number = noImpl
        open fun setFrame(frameIndex: Number, time: Number, attachmentName: String): Unit = noImpl
        override fun apply(skeleton: Skeleton, time: Number, alpha: Number): Unit = noImpl
    }
    open class SkeletonData {
        open var bones: Array<Bone> = noImpl
        open var slots: Array<Slot> = noImpl
        open var skins: Array<Skin> = noImpl
        open var animations: Array<Animation> = noImpl
        open var defaultSkin: Skin = noImpl
        open fun findBone(boneName: String): Bone = noImpl
        open fun findBoneIndex(boneName: String): Number = noImpl
        open fun findSlot(slotName: String): Slot = noImpl
        open fun findSlotIndex(slotName: String): Number = noImpl
        open fun findSkin(skinName: String): Skin = noImpl
        open fun findAnimation(animationName: String): Animation = noImpl
    }
    open class Skeleton(skeletonData: SkeletonData) {
        open var data: SkeletonData = noImpl
        open var bones: Array<Bone> = noImpl
        open var slots: Array<Slot> = noImpl
        open var drawOrder: Array<Any> = noImpl
        open var x: Number = noImpl
        open var y: Number = noImpl
        open var skin: Skin = noImpl
        open var r: Number = noImpl
        open var g: Number = noImpl
        open var b: Number = noImpl
        open var a: Number = noImpl
        open var time: Number = noImpl
        open var flipX: Boolean = noImpl
        open var flipY: Boolean = noImpl
        open fun updateWorldTransform(): Unit = noImpl
        open fun setToSetupPose(): Unit = noImpl
        open fun setBonesToSetupPose(): Unit = noImpl
        open fun setSlotsToSetupPose(): Unit = noImpl
        open fun getRootBone(): Bone = noImpl
        open fun findBone(boneName: String): Bone = noImpl
        open fun fineBoneIndex(boneName: String): Number = noImpl
        open fun findSlot(slotName: String): Slot = noImpl
        open fun findSlotIndex(slotName: String): Number = noImpl
        open fun setSkinByName(skinName: String): Unit = noImpl
        open fun setSkin(newSkin: Skin): Unit = noImpl
        open fun getAttachmentBySlotName(slotName: String, attachmentName: String): RegionAttachment = noImpl
        open fun getAttachmentBySlotIndex(slotIndex: Number, attachmentName: String): RegionAttachment = noImpl
        open fun setAttachment(slotName: String, attachmentName: String): Unit = noImpl
        open fun update(data: Number): Unit = noImpl
    }
    open class RegionAttachment {
        open var offset: Array<Number> = noImpl
        open var uvs: Array<Number> = noImpl
        open var x: Number = noImpl
        open var y: Number = noImpl
        open var rotation: Number = noImpl
        open var scaleX: Number = noImpl
        open var scaleY: Number = noImpl
        open var width: Number = noImpl
        open var height: Number = noImpl
        open var rendererObject: Any = noImpl
        open var regionOffsetX: Number = noImpl
        open var regionOffsetY: Number = noImpl
        open var regionWidth: Number = noImpl
        open var regionHeight: Number = noImpl
        open var regionOriginalWidth: Number = noImpl
        open var regionOriginalHeight: Number = noImpl
        open fun setUVs(u: Number, v: Number, u2: Number, v2: Number, rotate: Number): Unit = noImpl
        open fun updateOffset(): Unit = noImpl
        open fun computeVertices(x: Number, y: Number, bone: Bone, vertices: Array<Number>): Unit = noImpl
    }
    open class AnimationStateData(skeletonData: SkeletonData) {
        open var skeletonData: SkeletonData = noImpl
        open var animationToMixTime: Any = noImpl
        open var defaultMix: Number = noImpl
        open fun setMixByName(fromName: String, toName: String, duration: Number): Unit = noImpl
        open fun setMix(from: String, to: String): Number = noImpl
    }
    open class AnimationState(stateData: Any) {
        open var animationSpeed: Number = noImpl
        open var current: Any = noImpl
        open var previous: Any = noImpl
        open var currentTime: Number = noImpl
        open var previousTime: Number = noImpl
        open var currentLoop: Boolean = noImpl
        open var previousLoop: Boolean = noImpl
        open var mixTime: Number = noImpl
        open var mixDuration: Number = noImpl
        open var queue: Array<Animation> = noImpl
        open fun update(delta: Number): Unit = noImpl
        open fun apply(skeleton: Any): Unit = noImpl
        open fun clearAnimation(): Unit = noImpl
        open fun setAnimation(animation: Any, loop: Boolean): Unit = noImpl
        open fun setAnimationByName(animationName: String, loop: Boolean): Unit = noImpl
        open fun addAnimationByName(animationName: String, loop: Boolean, delay: Number): Unit = noImpl
        open fun addAnimation(animation: Any, loop: Boolean, delay: Number): Unit = noImpl
        open fun isComplete(): Number = noImpl
    }
    open class SkeletonJson(attachmentLoader: AtlasAttachmentLoader) {
        open var attachmentLoader: AtlasAttachmentLoader = noImpl
        open var scale: Number = noImpl
        open fun readSkeletonData(root: Any): SkeletonData = noImpl
        open fun readAttachment(skin: Skin, name: String, map: Any): RegionAttachment = noImpl
        open fun readAnimation(name: String, map: Any, skeletonData: SkeletonData): Unit = noImpl
        open fun readCurve(timeline: ISpineTimeline, frameIndex: Number, valueMap: Any): Unit = noImpl
        open fun toColor(hexString: String, colorIndex: Number): Number = noImpl
    }
    interface `T$4` {
        var alpha: Number
        var intensity: Number
        var luminanceAlpha: Number
        var rgb565: Number
        var rgba4444: Number
        var rgb888: Number
        var rgba8888: Number
    }
    interface `T$5` {
        var nearest: Number
        var linear: Number
        var mipMap: Number
        var mipMapNearestNearest: Number
        var mipMapLinearNearest: Number
        var mipMapNearestLinear: Number
        var mipMapLinearLinear: Number
    }
    interface `T$6` {
        var mirroredRepeat: Number
        var clampToEdge: Number
        var repeat: Number
    }
    open class Atlas(atlasText: String, textureLoader: AtlasLoader) {
        open var textureLoader: AtlasLoader = noImpl
        open var pages: Array<AtlasPage> = noImpl
        open var regions: Array<AtlasRegion> = noImpl
        open fun findRegion(name: String): AtlasRegion = noImpl
        open fun dispose(): Unit = noImpl
        open fun updateUVs(page: AtlasPage): Unit = noImpl
        companion object {
            var FORMAT: `T$4` = noImpl
            var TextureFilter: `T$5` = noImpl
            var textureWrap: `T$6` = noImpl
        }
    }
    open class AtlasPage {
        open var name: String = noImpl
        open var format: Number = noImpl
        open var minFilter: Number = noImpl
        open var magFilter: Number = noImpl
        open var uWrap: Number = noImpl
        open var vWrap: Number = noImpl
        open var rendererObject: Any = noImpl
        open var width: Number = noImpl
        open var height: Number = noImpl
    }
    open class AtlasRegion {
        open var page: AtlasPage = noImpl
        open var name: String = noImpl
        open var x: Number = noImpl
        open var y: Number = noImpl
        open var width: Number = noImpl
        open var height: Number = noImpl
        open var u: Number = noImpl
        open var v: Number = noImpl
        open var u2: Number = noImpl
        open var v2: Number = noImpl
        open var offsetX: Number = noImpl
        open var offsetY: Number = noImpl
        open var originalWidth: Number = noImpl
        open var originalHeight: Number = noImpl
        open var index: Number = noImpl
        open var rotate: Boolean = noImpl
        open var splits: Array<Any> = noImpl
        open var pads: Array<Any> = noImpl
    }
    open class AtlasReader(text: String) {
        open var lines: Array<String> = noImpl
        open var index: Number = noImpl
        open fun trim(value: String): String = noImpl
        open fun readLine(): String = noImpl
        open fun readValue(): String = noImpl
        open fun readTuple(tuple: Number): Number = noImpl
    }
    open class AtlasAttachmentLoader(atlas: Atlas) {
        open var atlas: Atlas = noImpl
        open fun newAttachment(skin: Skin, type: Number, name: String): RegionAttachment = noImpl
    }
    interface `T$7` {
        var name: String
    }
    open class Spine(url: String) : DisplayObjectContainer() {
        open var autoUpdate: Boolean = noImpl
        open var spineData: Any = noImpl
        open var skeleton: Skeleton = noImpl
        open var stateData: AnimationStateData = noImpl
        open var state: AnimationState = noImpl
        open var slotContainers: Array<DisplayObjectContainer> = noImpl
        open fun createSprite(slot: Slot, descriptor: `T$7`): Array<Sprite> = noImpl
        open fun update(dt: Number): Unit = noImpl
    }

    object PolyK {
        fun Triangulate(p: Array<Number>): Array<Number> = noImpl
    }
}

external fun requestAnimFrame(callback: Function<Any>): Unit = noImpl
