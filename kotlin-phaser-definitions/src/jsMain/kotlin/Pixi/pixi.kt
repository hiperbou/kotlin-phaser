@file:JsQualifier("PIXI")

package PIXI

import Phaser.RenderTexture
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.xhr.XMLHttpRequest
import Phaser.Point

external var game: Phaser.Game = definedExternally
external var WEBGL_RENDERER: Number = definedExternally
external var CANVAS_RENDERER: Number = definedExternally
external var VERSION: String = definedExternally
external enum class blendModes {
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
external enum class scaleModes {
    DEFAULT,
    LINEAR,
    NEAREST
}

external var defaultRenderOptions: PixiRendererOptions = definedExternally
external var INTERACTION_REQUENCY: Number = definedExternally
external var AUTO_PREVENT_DEFAULT: Boolean = definedExternally
external var PI_2: Number = definedExternally
external var RAD_TO_DEG: Number = definedExternally
external var DEG_TO_RAD: Number = definedExternally
external var RETINA_PREFIX: String = definedExternally
external var identityMatrix: Matrix = definedExternally
external var glContexts: Array<WebGLRenderingContext> = definedExternally
external var instances: Array<Any> = definedExternally
external var TextureSilentFail: Boolean = definedExternally

external interface `T$0` {
    var fonts: Any
}

external var BitmapText: `T$0` = definedExternally
external fun isPowerOfTwo(width: Number, height: Number): Boolean = definedExternally
external fun rgb2hex(rgb: Array<Number>): String = definedExternally
external fun hex2rgb(hex: String): Array<Number> = definedExternally
external fun autoDetectRenderer(width: Number?, height: Number?, options: PixiRendererOptions?): PixiRenderer = definedExternally
external fun autoDetectRecommendedRenderer(width: Number?, height: Number?, options: PixiRendererOptions?): PixiRenderer = definedExternally
external fun canUseNewCanvasBlendModes(): Boolean = definedExternally
external fun getNextPowerOfTwo(value: Number): Number = definedExternally
external fun AjaxRequest(): XMLHttpRequest = definedExternally
external fun CompileFragmentShader(gl: WebGLRenderingContext, shaderSrc: Array<String>): Any = definedExternally
external fun CompileProgram(gl: WebGLRenderingContext, vertexSrc: Array<String>, fragmentSrc: Array<String>): Any = definedExternally
external interface IEventCallback {
    fun invoke(e: IEvent?)
}

external interface IEvent {
    var type: String
    var content: Any
}

external interface HitArea {
    fun contains(x: Number, y: Number): Boolean
}

external interface IInteractionDataCallback {
    fun invoke(interactionData: InteractionData)
}

external interface PixiRenderer {
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

external interface PixiRendererOptions {
    var autoResize: Boolean? get() = definedExternally; set(value) = definedExternally
    var antialias: Boolean? get() = definedExternally; set(value) = definedExternally
    var clearBeforeRender: Boolean? get() = definedExternally; set(value) = definedExternally
    var preserveDrawingBuffer: Boolean? get() = definedExternally; set(value) = definedExternally
    var resolution: Number? get() = definedExternally; set(value) = definedExternally
    var transparent: Boolean? get() = definedExternally; set(value) = definedExternally
    var view: HTMLCanvasElement? get() = definedExternally; set(value) = definedExternally
}

external interface BitmapTextStyle {
    var font: String? get() = definedExternally; set(value) = definedExternally
    var align: String? get() = definedExternally; set(value) = definedExternally
    var tint: String? get() = definedExternally; set(value) = definedExternally
}

external interface TextStyle {
    var align: String? get() = definedExternally; set(value) = definedExternally
    var dropShadow: Boolean? get() = definedExternally; set(value) = definedExternally
    var dropShadowColor: String? get() = definedExternally; set(value) = definedExternally
    var dropShadowAngle: Number? get() = definedExternally; set(value) = definedExternally
    var dropShadowDistance: Number? get() = definedExternally; set(value) = definedExternally
    var fill: String? get() = definedExternally; set(value) = definedExternally
    var font: String? get() = definedExternally; set(value) = definedExternally
    var lineJoin: String? get() = definedExternally; set(value) = definedExternally
    var stroke: String? get() = definedExternally; set(value) = definedExternally
    var strokeThickness: Number? get() = definedExternally; set(value) = definedExternally
    var wordWrap: Boolean? get() = definedExternally; set(value) = definedExternally
    var wordWrapWidth: Number? get() = definedExternally; set(value) = definedExternally
}

external interface Loader {
    fun load()
}

external interface MaskData {
    var alpha: Number
    var worldTransform: Array<Number>
}

external interface RenderSession {
    var context: CanvasRenderingContext2D
    var maskManager: CanvasMaskManager
    var scaleMode: scaleModes
    var smoothProperty: String
    var roundPixels: Boolean
}

external interface ShaderAttribute
external interface FilterBlock {
    var visible: Boolean
    var renderable: Boolean
}
external open class AbstractFilter() {
    constructor(fragmentSrc: String, uniforms: Any)
    constructor(fragmentSrc: Array<String>, uniforms: Any)

    open var dirty: Boolean = definedExternally
    open var padding: Number = definedExternally
    open var uniforms: Any = definedExternally
    open var fragmentSrc: dynamic /* String | Array<String> */ = definedExternally
    open fun apply(frameBuffer: WebGLFramebuffer): Unit = definedExternally
    open fun syncUniforms(): Unit = definedExternally
}
external open class AlphaMaskFilter(texture: Texture) : AbstractFilter {
    open var map: Texture = definedExternally
    open fun onTextureLoaded(): Unit = definedExternally
}
external open class AsciiFilter : AbstractFilter {
    open var size: Number = definedExternally
}

external interface `T$1` {
    fun get(key: String): Loader?
    fun set(key: String, value: Loader)
}
external open class AssetLoader(assetURLs: Array<String>, crossorigin: Boolean) : Mixin {
    open var assetURLs: Array<String> = definedExternally
    open var crossorigin: Boolean = definedExternally
    open var loadersByType: `T$1` = definedExternally
    override fun listeners(eventName: String): Array<Function<Any>> = definedExternally
    override fun emit(eventName: String, data: Any?): Boolean = definedExternally
    override fun dispatchEvent(eventName: String, data: Any?): Boolean = definedExternally
    override fun on(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun once(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun off(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun removeAllEventListeners(eventName: String): Unit = definedExternally
    open fun load(): Unit = definedExternally
}
external open class AtlasLoader(url: String, crossorigin: Boolean) : Mixin {
    open var url: String = definedExternally
    open var baseUrl: String = definedExternally
    open var crossorigin: Boolean = definedExternally
    open var loaded: Boolean = definedExternally
    override fun listeners(eventName: String): Array<Function<Any>> = definedExternally
    override fun emit(eventName: String, data: Any?): Boolean = definedExternally
    override fun dispatchEvent(eventName: String, data: Any?): Boolean = definedExternally
    override fun on(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun once(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun off(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun removeAllEventListeners(eventName: String): Unit = definedExternally
    open fun load(): Unit = definedExternally
}
external open class BaseTexture() : Mixin {
    constructor(source: HTMLImageElement, scaleMode: scaleModes)
    constructor(source: HTMLCanvasElement, scaleMode: scaleModes)

    open var height: Number = definedExternally
    open var hasLoaded: Boolean = definedExternally
    open var mipmap: Boolean = definedExternally
    open var premultipliedAlpha: Boolean = definedExternally
    open var resolution: Number = definedExternally
    open var scaleMode: scaleModes = definedExternally
    open var skipRender: Boolean = definedExternally
    open var source: HTMLImageElement = definedExternally
    open var textureIndex: Number = definedExternally
    open var width: Number = definedExternally
    override fun listeners(eventName: String): Array<Function<Any>> = definedExternally
    override fun emit(eventName: String, data: Any?): Boolean = definedExternally
    override fun dispatchEvent(eventName: String, data: Any?): Boolean = definedExternally
    override fun on(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun once(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun off(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun removeAllEventListeners(eventName: String): Unit = definedExternally
    open fun forceLoaded(width: Number, height: Number): Unit = definedExternally
    open fun destroy(): Unit = definedExternally
    open fun dirty(): Unit = definedExternally
    open fun unloadFromGPU(): Unit = definedExternally

    companion object {
        fun fromCanvas(canvas: HTMLCanvasElement, scaleMode: scaleModes?): BaseTexture = definedExternally
    }
}
external open class BitmapFontLoader(url: String, crossorigin: Boolean) : Mixin {
    open var baseUrl: String = definedExternally
    open var crossorigin: Boolean = definedExternally
    open var texture: Texture = definedExternally
    open var url: String = definedExternally
    override fun listeners(eventName: String): Array<Function<Any>> = definedExternally
    override fun emit(eventName: String, data: Any?): Boolean = definedExternally
    override fun dispatchEvent(eventName: String, data: Any?): Boolean = definedExternally
    override fun on(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun once(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun off(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun removeAllEventListeners(eventName: String): Unit = definedExternally
    open fun load(): Unit = definedExternally
}
external open class BlurFilter : AbstractFilter {
    open var blur: Number = definedExternally
    open var blurX: Number = definedExternally
    open var blurY: Number = definedExternally
}
external open class BlurXFilter : AbstractFilter {
    open var blur: Number = definedExternally
}
external open class BlurYFilter : AbstractFilter {
    open var blur: Number = definedExternally
}
external open class CanvasBuffer(width: Number, height: Number) {
    open var canvas: HTMLCanvasElement = definedExternally
    open var context: CanvasRenderingContext2D = definedExternally
    open var height: Number = definedExternally
    open var width: Number = definedExternally
    open fun destroy(): Unit = definedExternally
    open fun clear(): Unit = definedExternally
    open fun resize(width: Number, height: Number): Unit = definedExternally
}
external open class CanvasPool {
    companion object {
        fun create(parent: HTMLElement, width: Number?, height: Number?): HTMLCanvasElement = definedExternally
        fun getFirst(): HTMLCanvasElement = definedExternally
        fun remove(parent: HTMLElement): Unit = definedExternally
        fun removeByCanvas(canvas: HTMLCanvasElement): HTMLCanvasElement = definedExternally
        fun getTotal(): Number = definedExternally
        fun getFree(): Number = definedExternally
    }
}
external open class CanvasMaskManager {
    open fun pushMask(maskData: MaskData, renderSession: RenderSession): Unit = definedExternally
    open fun popMask(renderSession: RenderSession): Unit = definedExternally
}
external abstract class CanvasRenderer(game: Phaser.Game) : PixiRenderer {
    open var game: Phaser.Game = definedExternally
    override var type: Number = definedExternally
    override var resolution: Number = definedExternally
    override var clearBeforeRender: Boolean = definedExternally
    override var transparent: Boolean = definedExternally
    override var autoResize: Boolean = definedExternally
    override var width: Number = definedExternally
    override var height: Number = definedExternally
    override var view: HTMLCanvasElement = definedExternally
    open var context: CanvasRenderingContext2D = definedExternally
    open var refresh: Boolean = definedExternally
    open var count: Number = definedExternally
    open var maskManager: CanvasMaskManager = definedExternally
    open var renderSession: RenderSession = definedExternally
    override fun render(stage: DisplayObjectContainer): Unit = definedExternally
    override fun resize(width: Number, height: Number): Unit = definedExternally
    open fun destroy(removeView: Boolean?): Unit = definedExternally
}
external open class CanvasTinter {
    companion object {
        fun getTintedTexture(sprite: Sprite, color: Number): HTMLCanvasElement = definedExternally
        fun tintWithMultiply(texture: Texture, color: Number, canvas: HTMLCanvasElement): Unit = definedExternally
        fun tintWithOverlay(texture: Texture, color: Number, canvas: HTMLCanvasElement): Unit = definedExternally
        fun tintWithPerPixel(texture: Texture, color: Number, canvas: HTMLCanvasElement): Unit = definedExternally
        var canUseMultiply: Boolean = definedExternally
        //var tintMethod: Any = definedExternally
        fun tintMethod(texture: Texture, color: Number, canvas: HTMLCanvasElement): Unit = definedExternally

    }
}
external open class Circle(x: Number, y: Number, radius: Number) : HitArea {
    open var x: Number = definedExternally
    open var y: Number = definedExternally
    open var radius: Number = definedExternally
    open fun clone(): Circle = definedExternally
    override fun contains(x: Number, y: Number): Boolean = definedExternally
    open fun getBounds(): Rectangle = definedExternally
}
external open class ColorMatrixFilter : AbstractFilter {
    open var matrix: Array<Number> = definedExternally
}
external open class ColorStepFilter : AbstractFilter {
    open var step: Number = definedExternally
}
external open class ConvolutionFilter(matrix: Array<Number>, width: Number, height: Number) : AbstractFilter {
    open var matrix: Matrix = definedExternally
    open var width: Number = definedExternally
    open var height: Number = definedExternally
}
external open class CrossHatchFilter : AbstractFilter {
    open var blur: Number = definedExternally
}
external open class DisplacementFilter(texture: Texture) : AbstractFilter {
    open var map: Texture = definedExternally
    open var offset: Point = definedExternally
    open var scale: Point = definedExternally
}
external open class DotScreenFilter : AbstractFilter {
    open var angle: Number = definedExternally
    open var scale: Point = definedExternally
}

external abstract class DisplayObject {
    open var alpha: Double = definedExternally
    open var buttonMode: Boolean = definedExternally
    open var cacheAsBitmap: Boolean = definedExternally
    open var defaultCursor: String = definedExternally
    open var filterArea: Rectangle = definedExternally
    open var filters: Array<AbstractFilter> = definedExternally
    open var hitArea: HitArea = definedExternally
    open var interactive: Boolean = definedExternally
    open var mask: Graphics = definedExternally
    open var parent: DisplayObjectContainer = definedExternally
    open var pivot: Point = definedExternally
    open var position: Phaser.Point = definedExternally
    open var renderable: Boolean = definedExternally
    open var rotation: Double = definedExternally
    open var scale: Phaser.Point = definedExternally
    open var stage: DisplayObjectContainer = definedExternally
    open var visible: Boolean = definedExternally
    open var worldAlpha: Number = definedExternally
    open var worldPosition: Point = definedExternally
    open var worldScale: Point = definedExternally
    open var worldTransform: Matrix = definedExternally
    open var worldRotation: Number = definedExternally
    open var worldVisible: Boolean = definedExternally
    open var x: Double = definedExternally
    open var y: Double = definedExternally
    open var z: Double = definedExternally
    open fun click(e: InteractionData): Unit = definedExternally
    open fun displayObjectUpdateTransform(parent: DisplayObjectContainer?): Unit = definedExternally
    open fun generateTexture(resolution: Number?, scaleMode: Number?, renderer: Any?): RenderTexture = definedExternally
    //open fun generateTexture(resolution: Number? , scaleMode: Number? , renderer: PixiRenderer?): RenderTexture = definedExternally
    //open fun generateTexture(resolution: Number? , scaleMode: Number? , renderer: Number? ): RenderTexture = definedExternally
    open fun mousedown(e: InteractionData): Unit = definedExternally

    open fun mouseout(e: InteractionData): Unit = definedExternally
    open fun mouseover(e: InteractionData): Unit = definedExternally
    open fun mouseup(e: InteractionData): Unit = definedExternally
    open fun mousemove(e: InteractionData): Unit = definedExternally
    open fun mouseupoutside(e: InteractionData): Unit = definedExternally
    open fun rightclick(e: InteractionData): Unit = definedExternally
    open fun rightdown(e: InteractionData): Unit = definedExternally
    open fun rightup(e: InteractionData): Unit = definedExternally
    open fun rightupoutside(e: InteractionData): Unit = definedExternally
    open fun setStageReference(stage: DisplayObjectContainer): Unit = definedExternally
    open fun tap(e: InteractionData): Unit = definedExternally
    open fun toGlobal(position: Point): Point = definedExternally
    open fun toLocal(position: Point, from: DisplayObject): Point = definedExternally
    open fun touchend(e: InteractionData): Unit = definedExternally
    open fun touchendoutside(e: InteractionData): Unit = definedExternally
    open fun touchstart(e: InteractionData): Unit = definedExternally
    open fun touchmove(e: InteractionData): Unit = definedExternally
    open fun updateTransform(parent: DisplayObjectContainer?): Unit = definedExternally
    //open fun alignTo(container: DisplayObject, position: Number?): Sprite
    //open fun alignTo(container: DisplayObject, position: Number?, offsetX: Number?): Sprite
    //open fun alignTo(container: DisplayObject, position: Number?, offsetX: Number?, offsetY: Number?): Sprite
    @JsName("alignTo")
    open fun alignToJs(container: Any, position: Number?, offsetX: Number?, offsetY: Number?): Sprite

    open var userData: dynamic
    open var id: Int
}

external open class DisplayObjectContainer : DisplayObject {
    open var children: Array<DisplayObject> = definedExternally
    open var height: Double = definedExternally
    open var width: Double = definedExternally
    open var ignoreChildInput: Boolean = definedExternally
    open fun <T : DisplayObject> addChild(child: T): T = definedExternally
    //open fun addChild(child: DisplayObject): DisplayObject = definedExternally
    open fun addChildAt(child: DisplayObject, index: Number): DisplayObject = definedExternally

    //open fun getBounds(): Rectangle
    //open fun getBounds(targetCoordinateSpace: DisplayObject): Rectangle
    //open fun getBounds(): Phaser.Rectangle
    //open fun getBounds(targetCoordinateSpace: Matrix): Phaser.Rectangle
    @JsName("getBounds")
    open fun getBoundsJs(targetCoordinateSpace: Any?): Phaser.Rectangle

    open fun getChildAt(index: Number): DisplayObject = definedExternally
    open fun getChildIndex(child: DisplayObject): Number = definedExternally
    open fun getLocalBounds(): Phaser.Rectangle = definedExternally
    open fun removeChild(child: DisplayObject): DisplayObject = definedExternally
    open fun removeChildAt(index: Number): DisplayObject = definedExternally
    open fun removeChildren(beginIndex: Number?, endIndex: Number?): Array<DisplayObject> = definedExternally
    open fun removeStageReference(): Unit = definedExternally
    open fun setChildIndex(child: DisplayObject, index: Number): Unit = definedExternally
    open fun swapChildren(child: DisplayObject, child2: DisplayObject): Unit = definedExternally
    open fun contains(child: DisplayObject): Boolean = definedExternally
}
external open class Ellipse(x: Number, y: Number, width: Number, height: Number) : HitArea {
    open var x: Number = definedExternally
    open var y: Number = definedExternally
    open var width: Number = definedExternally
    open var height: Number = definedExternally
    open fun clone(): Ellipse = definedExternally
    override fun contains(x: Number, y: Number): Boolean = definedExternally
    open fun getBounds(): Rectangle = definedExternally
}
external open class Event(target: Any, name: String, data: Any) {
    open var target: Any = definedExternally
    open var type: String = definedExternally
    open var data: Any = definedExternally
    open var timeStamp: Number = definedExternally
    open fun stopPropagation(): Unit = definedExternally
    open fun preventDefault(): Unit = definedExternally
    open fun stopImmediatePropagation(): Unit = definedExternally
}
external open class EventTarget {
    companion object {
        fun mixin(obj: Any): Unit = definedExternally
    }
}
external open class FilterTexture(gl: WebGLRenderingContext, width: Number, height: Number, scaleMode: scaleModes) {
    open var fragmentSrc: Array<String> = definedExternally
    open var frameBuffer: WebGLFramebuffer = definedExternally
    open var gl: WebGLRenderingContext = definedExternally
    open var program: WebGLProgram = definedExternally
    open var scaleMode: Number = definedExternally
    open var texture: WebGLTexture = definedExternally
    open fun clear(): Unit = definedExternally
    open fun resize(width: Number, height: Number): Unit = definedExternally
    open fun destroy(): Unit = definedExternally
}
external open class GraphicsData(lineWidth: Number?, lineColor: Number?, lineAlpha: Number?, fillColor: Number?, fillAlpha: Number?, fill: Boolean?, shape: Any?) {
    open var lineWidth: Number = definedExternally
    open var lineColor: Number = definedExternally
    open var lineAlpha: Number = definedExternally
    open var fillColor: Number = definedExternally
    open var fillAlpha: Number = definedExternally
    open var fill: Boolean = definedExternally
    open var shape: Any = definedExternally
    open var type: Number = definedExternally
}
external open class Graphics : DisplayObjectContainer {
    open var blendMode: Number = definedExternally
    open var boundsPadding: Number = definedExternally
    open var fillAlpha: Number = definedExternally
    open var isMask: Boolean = definedExternally
    open var lineWidth: Number = definedExternally
    open var lineColor: Number = definedExternally
    open var tint: Number = definedExternally
    override var worldAlpha: Number = definedExternally
    open fun arc(cx: Number, cy: Number, radius: Number, startAngle: Number, endAngle: Number, anticlockwise: Boolean): Graphics = definedExternally
    open fun arcTo(x1: Number, y1: Number, x2: Number, y2: Number, radius: Number): Graphics = definedExternally
    open fun beginFill(color: Number?): Graphics = definedExternally
    open fun beginFill(color: Number?, alpha: Number?): Graphics = definedExternally
    open fun bezierCurveTo(cpX: Number, cpY: Number, cpX2: Number, cpY2: Number, toX: Number, toY: Number): Graphics = definedExternally
    open fun clear(): Graphics = definedExternally
    open fun destroyCachedSprite(): Unit = definedExternally
    open fun drawCircle(x: Number, y: Number, diameter: Number): Graphics = definedExternally
    open fun drawEllipse(x: Number, y: Number, width: Number, height: Number): Graphics = definedExternally
    open fun drawPolygon(vararg path: Any): Graphics = definedExternally
    open fun drawRect(x: Number, y: Number, width: Number, height: Number): Graphics = definedExternally
    open fun drawRoundedRect(x: Number, y: Number, width: Number, height: Number, radius: Number): Graphics = definedExternally
    open fun drawShape(shape: Circle): GraphicsData = definedExternally
    open fun drawShape(shape: Rectangle): GraphicsData = definedExternally
    open fun drawShape(shape: Ellipse): GraphicsData = definedExternally
    open fun drawShape(shape: Polygon): GraphicsData = definedExternally
    open fun endFill(): Graphics = definedExternally
    open fun generateTexture(): RenderTexture = definedExternally
    open fun generateTexture(resolution: Number?, scaleMode: Number?, padding: Number?): RenderTexture = definedExternally
    open fun lineStyle(lineWidth: Number?): Graphics = definedExternally
    open fun lineStyle(lineWidth: Number?, color: Number?): Graphics = definedExternally
    open fun lineStyle(lineWidth: Number?, color: Number?, alpha: Number?): Graphics = definedExternally
    open fun lineTo(x: Number, y: Number): Graphics = definedExternally
    open fun moveTo(x: Number, y: Number): Graphics = definedExternally
    open fun quadraticCurveTo(cpX: Number, cpY: Number, toX: Number, toY: Number): Graphics = definedExternally

    companion object {
        var POLY: Number = definedExternally
        var RECT: Number = definedExternally
        var CIRC: Number = definedExternally
        var ELIP: Number = definedExternally
        var RREC: Number = definedExternally
    }
}
external open class GrayFilter : AbstractFilter {
    open var gray: Number = definedExternally
}
external open class ImageLoader(url: String, crossorigin: Boolean?) : Mixin {
    open var texture: Texture = definedExternally
    override fun listeners(eventName: String): Array<Function<Any>> = definedExternally
    override fun emit(eventName: String, data: Any?): Boolean = definedExternally
    override fun dispatchEvent(eventName: String, data: Any?): Boolean = definedExternally
    override fun on(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun once(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun off(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun removeAllEventListeners(eventName: String): Unit = definedExternally
    open fun load(): Unit = definedExternally
    open fun loadFramedSpriteSheet(frameWidth: Number, frameHeight: Number, textureName: String): Unit = definedExternally
}
external open class InteractionData {
    open var global: Point = definedExternally
    open var target: Sprite = definedExternally
    open var originalEvent: Event = definedExternally
    open fun getLocalPosition(displayObject: DisplayObject, point: Point?, globalPos: Point?): Point = definedExternally
}

external interface `T$2` {
    fun get(id: String): InteractionData?
    fun set(id: String, value: InteractionData)
}
external open class InteractionManager(stage: DisplayObjectContainer) {
    open var currentCursorStyle: String = definedExternally
    open var last: Number = definedExternally
    open var mouse: InteractionData = definedExternally
    open var mouseOut: Boolean = definedExternally
    open var mouseoverEnabled: Boolean = definedExternally
    open var onMouseMove: Function<Any> = definedExternally
    open var onMouseDown: Function<Any> = definedExternally
    open var onMouseOut: Function<Any> = definedExternally
    open var onMouseUp: Function<Any> = definedExternally
    open var onTouchStart: Function<Any> = definedExternally
    open var onTouchEnd: Function<Any> = definedExternally
    open var onTouchMove: Function<Any> = definedExternally
    open var pool: Array<InteractionData> = definedExternally
    open var resolution: Number = definedExternally
    open var stage: DisplayObjectContainer = definedExternally
    open var touches: `T$2` = definedExternally
}
external open class InvertFilter : AbstractFilter {
    open var invert: Number = definedExternally
}
external open class JsonLoader(url: String, crossorigin: Boolean?) : Mixin {
    open var baseUrl: String = definedExternally
    open var crossorigin: Boolean = definedExternally
    open var loaded: Boolean = definedExternally
    open var url: String = definedExternally
    override fun listeners(eventName: String): Array<Function<Any>> = definedExternally
    override fun emit(eventName: String, data: Any?): Boolean = definedExternally
    override fun dispatchEvent(eventName: String, data: Any?): Boolean = definedExternally
    override fun on(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun once(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun off(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun removeAllEventListeners(eventName: String): Unit = definedExternally
    open fun load(): Unit = definedExternally
}
external open class Matrix {
    open var a: Number = definedExternally
    open var b: Number = definedExternally
    open var c: Number = definedExternally
    open var d: Number = definedExternally
    open var tx: Number = definedExternally
    open var ty: Number = definedExternally
    open fun append(matrix: Matrix): Matrix = definedExternally
    open fun apply(pos: Point, newPos: Point): Point = definedExternally
    open fun applyInverse(pos: Point, newPos: Point): Point = definedExternally
    open fun determineMatrixArrayType(): Array<Number> = definedExternally
    open fun identity(): Matrix = definedExternally
    open fun rotate(angle: Number): Matrix = definedExternally
    open fun fromArray(array: Array<Number>): Unit = definedExternally
    open fun translate(x: Number, y: Number): Matrix = definedExternally
    open fun toArray(transpose: Boolean): Array<Number> = definedExternally
    open fun scale(x: Number, y: Number): Matrix = definedExternally
}

external interface Mixin {
    fun listeners(eventName: String): Array<Function<Any>>
    fun emit(eventName: String, data: Any?): Boolean
    fun dispatchEvent(eventName: String, data: Any?): Boolean
    fun on(eventName: String, fn: Function<Any>): Function<Any>
    fun addEventListener(eventName: String, fn: Function<Any>): Function<Any>
    fun once(eventName: String, fn: Function<Any>): Function<Any>
    fun off(eventName: String, fn: Function<Any>): Function<Any>
    fun removeAllEventListeners(eventName: String)
}
external open class NoiseFilter : AbstractFilter {
    open var noise: Number = definedExternally
}
external open class NormalMapFilter : AbstractFilter {
    open var map: Texture = definedExternally
    open var offset: Point = definedExternally
    open var scale: Point = definedExternally
}
external open class PixelateFilter : AbstractFilter {
    open var size: Number = definedExternally
}

external interface IPixiShader {
    var fragmentSrc: Array<String>
    var gl: WebGLRenderingContext
    var program: WebGLProgram
    var vertexSrc: Array<String>
    fun destroy()
    fun init()
}
external open class PixiShader(gl: WebGLRenderingContext) : IPixiShader {
    open var attributes: Array<ShaderAttribute> = definedExternally
    open var defaultVertexSrc: Array<String> = definedExternally
    open var dirty: Boolean = definedExternally
    open var firstRun: Boolean = definedExternally
    open var textureCount: Number = definedExternally
    override var fragmentSrc: Array<String> = definedExternally
    override var gl: WebGLRenderingContext = definedExternally
    override var program: WebGLProgram = definedExternally
    override var vertexSrc: Array<String> = definedExternally
    open fun initSampler2D(): Unit = definedExternally
    open fun initUniforms(): Unit = definedExternally
    open fun syncUniforms(): Unit = definedExternally
    override fun destroy(): Unit = definedExternally
    override fun init(): Unit = definedExternally
}
external open class PixiFastShader(gl: WebGLRenderingContext) : IPixiShader {
    open var textureCount: Number = definedExternally
    override var fragmentSrc: Array<String> = definedExternally
    override var gl: WebGLRenderingContext = definedExternally
    override var program: WebGLProgram = definedExternally
    override var vertexSrc: Array<String> = definedExternally
    override fun destroy(): Unit = definedExternally
    override fun init(): Unit = definedExternally
}
external open class PrimitiveShader(gl: WebGLRenderingContext) : IPixiShader {
    override var fragmentSrc: Array<String> = definedExternally
    override var gl: WebGLRenderingContext = definedExternally
    override var program: WebGLProgram = definedExternally
    override var vertexSrc: Array<String> = definedExternally
    override fun destroy(): Unit = definedExternally
    override fun init(): Unit = definedExternally
}
external open class ComplexPrimitiveShader(gl: WebGLRenderingContext) : IPixiShader {
    override var fragmentSrc: Array<String> = definedExternally
    override var gl: WebGLRenderingContext = definedExternally
    override var program: WebGLProgram = definedExternally
    override var vertexSrc: Array<String> = definedExternally
    override fun destroy(): Unit = definedExternally
    override fun init(): Unit = definedExternally
}
external open class StripShader(gl: WebGLRenderingContext) : IPixiShader {
    override var fragmentSrc: Array<String> = definedExternally
    override var gl: WebGLRenderingContext = definedExternally
    override var program: WebGLProgram = definedExternally
    override var vertexSrc: Array<String> = definedExternally
    override fun destroy(): Unit = definedExternally
    override fun init(): Unit = definedExternally
}
/*external open class Point(x: Number?, y: Number?) {
    open var x: Double = definedExternally
    open var y: Double = definedExternally
    open fun clone(): Point = definedExternally
    open fun set(x: Number, y: Number?): Unit = definedExternally
}*/
external open class Polygon : HitArea {
    constructor(points: Array<Point>)
    constructor(points: Array<Number>)
    constructor(vararg points: Point)
    constructor(vararg points: Number)

    open var points: Array<Any> = definedExternally
    open fun clone(): Polygon = definedExternally
    override fun contains(x: Number, y: Number): Boolean = definedExternally
}
external open class Rectangle(x: Number?, y: Number?, width: Number?, height: Number?) : HitArea {
    open var x: Number = definedExternally
    open var y: Number = definedExternally
    open var width: Number = definedExternally
    open var height: Number = definedExternally
    open fun clone(): Rectangle = definedExternally
    override fun contains(x: Number, y: Number): Boolean = definedExternally
}
external open class RGBSplitFilter : AbstractFilter {
    open var red: Point = definedExternally
    open var green: Point = definedExternally
    open var blue: Point = definedExternally
}
external open class Rope(texture: Texture?, points: Array<Phaser.Point>?) : Strip {
    //open var points: Array<Point> = definedExternally
    override var vertices: Array<Number> = definedExternally

    open fun refresh(): Unit = definedExternally
    open fun setTexture(texture: Texture): Unit = definedExternally
}
external open class RoundedRectangle(x: Number?, y: Number?, width: Number?, height: Number?, radius: Number?) : HitArea {
    open var x: Number = definedExternally
    open var y: Number = definedExternally
    open var width: Number = definedExternally
    open var height: Number = definedExternally
    open var radius: Number = definedExternally
    open fun clone(): RoundedRectangle = definedExternally
    override fun contains(x: Number, y: Number): Boolean = definedExternally
}
external open class SepiaFilter : AbstractFilter {
    open var sepia: Number = definedExternally
}
external open class SmartBlurFilter : AbstractFilter {
    open var blur: Number = definedExternally
}
external open class SpineLoader(url: String, crossOrigin: Boolean) : Mixin {
    open var url: String = definedExternally
    open var crossorigin: Boolean = definedExternally
    open var loaded: Boolean = definedExternally
    override fun listeners(eventName: String): Array<Function<Any>> = definedExternally
    override fun emit(eventName: String, data: Any?): Boolean = definedExternally
    override fun dispatchEvent(eventName: String, data: Any?): Boolean = definedExternally
    override fun on(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun once(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun off(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun removeAllEventListeners(eventName: String): Unit = definedExternally
    open fun load(): Unit = definedExternally
}
external open class SpineTextureLoader(basePath: String, crossorigin: Boolean) {
    open fun load(page: AtlasPage, file: String): Unit = definedExternally
    open fun unload(texture: BaseTexture): Unit = definedExternally
}
external open class Sprite(texture: Texture?) : DisplayObjectContainer {
    //open var anchor: Point = definedExternally
    open var blendMode: blendModes
    open var exists: Boolean = definedExternally
    open var shader: IPixiShader = definedExternally
    open var texture: Texture = definedExternally
    open var tint: Number = definedExternally
    //open fun setTexture(texture: Any): Unit = definedExternally
    @JsName("setTexture")
    fun setTextureJs(texture: Any, destroyBase: Boolean?): Unit = definedExternally
    //open fun setTexture(texture: Texture, destroyBase: Boolean?): Unit = definedExternally
    //open fun setTexture(texture: RenderTexture): Unit = definedExternally
}
external open class SpriteBatch(texture: Texture?) : DisplayObjectContainer {
    open var ready: Boolean = definedExternally
    open var textureThing: Texture = definedExternally
    open fun initWebGL(gl: WebGLRenderingContext): Unit = definedExternally
}
external open class SpriteSheetLoader(url: String, crossorigin: Boolean?) : Mixin {
    open var baseUrl: String = definedExternally
    open var crossorigin: Boolean = definedExternally
    open var frames: Any = definedExternally
    open var texture: Texture = definedExternally
    open var url: String = definedExternally
    override fun listeners(eventName: String): Array<Function<Any>> = definedExternally
    override fun emit(eventName: String, data: Any?): Boolean = definedExternally
    override fun dispatchEvent(eventName: String, data: Any?): Boolean = definedExternally
    override fun on(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun once(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun off(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun removeAllEventListeners(eventName: String): Unit = definedExternally
    open fun load(): Unit = definedExternally
}

external interface `T$3` {
    var TRIANGLE_STRIP: Number
    var TRIANGLES: Number
}
external open class Strip(texture: Texture?) : DisplayObjectContainer {
    open var blendMode: Number = definedExternally
    open var colors: Array<Number> = definedExternally
    open var dirty: Boolean = definedExternally
    open var indices: Array<Number> = definedExternally
    open var canvasPadding: Number = definedExternally
    open var texture: Texture = definedExternally
    open var uvs: Array<Number> = definedExternally
    open var vertices: Array<Number> = definedExternally

    //override fun getBounds(matrix: Matrix): Phaser.Rectangle
    companion object {
        var DrawModes: `T$3` = definedExternally
    }
}
external open class Texture(baseTexture: BaseTexture, frame: Rectangle?, crop: Rectangle?, trim: Rectangle?) : Mixin {
    open var baseTexture: BaseTexture = definedExternally
    open var crop: Rectangle = definedExternally
    open var frame: Rectangle = definedExternally
    open var height: Number = definedExternally
    open var noFrame: Boolean = definedExternally
    open var requiresUpdate: Boolean = definedExternally
    open var trim: Point = definedExternally
    open var width: Number = definedExternally
    open var scope: Any = definedExternally
    open var valid: Boolean = definedExternally
    open var rotated: Boolean = definedExternally
    override fun listeners(eventName: String): Array<Function<Any>> = definedExternally
    override fun emit(eventName: String, data: Any?): Boolean = definedExternally
    override fun dispatchEvent(eventName: String, data: Any?): Boolean = definedExternally
    override fun on(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun addEventListener(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun once(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun off(eventName: String, fn: Function<Any>): Function<Any> = definedExternally
    override fun removeAllEventListeners(eventName: String): Unit = definedExternally
    open fun destroy(destroyBase: Boolean): Unit = definedExternally
    open fun setFrame(frame: Rectangle): Unit = definedExternally

    companion object {
        var emptyTexture: Texture = definedExternally
        fun fromCanvas(canvas: HTMLCanvasElement, scaleMode: scaleModes?): Texture = definedExternally
    }
}
external open class TilingSprite(texture: Texture?, width: Number?, height: Number?) : Sprite {
    open var canvasBuffer: PIXI.CanvasBuffer = definedExternally
    //override var blendMode: Number
    open var refreshTexture: Boolean = definedExternally
    override var texture: Texture = definedExternally
    open var textureDebug: Boolean = definedExternally
    override var tint: Number = definedExternally
    open var tilePosition: Point = definedExternally
    open var tilePattern: PIXI.Texture = definedExternally
    open var tileScale: Point = definedExternally
    open var tileScaleOffset: Point = definedExternally
    open fun destroy(): Unit = definedExternally
    open fun generateTilingTexture(forcePowerOfTwo: Boolean?): Unit = definedExternally
    open fun setTexture(texture: Texture): Unit = definedExternally
}
external open class TiltShiftFilter : AbstractFilter {
    open var blur: Number = definedExternally
    open var gradientBlur: Number = definedExternally
    open var start: Number = definedExternally
    open var end: Number = definedExternally
}
external open class TiltShiftXFilter : AbstractFilter {
    open var blur: Number = definedExternally
    open var gradientBlur: Number = definedExternally
    open var start: Number = definedExternally
    open var end: Number = definedExternally
    open fun updateDelta(): Unit = definedExternally
}
external open class TiltShiftYFilter : AbstractFilter {
    open var blur: Number = definedExternally
    open var gradientBlur: Number = definedExternally
    open var start: Number = definedExternally
    open var end: Number = definedExternally
    open fun updateDelta(): Unit = definedExternally
}
external open class TwistFilter : AbstractFilter {
    open var angle: Number = definedExternally
    open var offset: Point = definedExternally
    open var radius: Number = definedExternally
}
external open class VideoTexture() : BaseTexture {
    open var controls: Boolean = definedExternally
    open var autoUpdate: Boolean = definedExternally
    open var type: String = definedExternally
    open fun changeSource(src: String, type: String, loop: Boolean): Unit = definedExternally
    open fun play(): Unit = definedExternally
    open fun stop(): Unit = definedExternally
    override fun destroy(): Unit = definedExternally
    open fun updateBound(): Unit = definedExternally
    open var onPlayStart: () -> Unit = definedExternally
    open var onPlayStop: () -> Unit = definedExternally
    open var onCanPlay: (event: Any) -> Unit = definedExternally

    companion object {
        fun baseTextureFromVideo(video: HTMLVideoElement, scaleMode: Number): BaseTexture = definedExternally
        fun textureFromVideo(video: HTMLVideoElement, scaleMode: Number): Texture = definedExternally
        fun fromUrl(videoSrc: String, scaleMode: Number?, autoPlay: Boolean?, type: String?, loop: Boolean?): Texture = definedExternally
    }
}
external open class WebGLBlendModeManager {
    open var currentBlendMode: Number = definedExternally
    open fun destroy(): Unit = definedExternally
    open fun setBlendMode(blendMode: Number): Boolean = definedExternally
    open fun setContext(gl: WebGLRenderingContext): Unit = definedExternally
}
external open class WebGLFastSpriteBatch(gl: CanvasRenderingContext2D) {
    open var currentBatchSize: Number = definedExternally
    open var currentBaseTexture: BaseTexture = definedExternally
    open var currentBlendMode: Number = definedExternally
    open var renderSession: RenderSession = definedExternally
    open var drawing: Boolean = definedExternally
    open var indexBuffer: Any = definedExternally
    open var indices: Array<Number> = definedExternally
    open var lastIndexCount: Number = definedExternally
    open var matrix: Matrix = definedExternally
    open var maxSize: Number = definedExternally
    open var shader: IPixiShader = definedExternally
    open var size: Number = definedExternally
    open var vertexBuffer: Any = definedExternally
    open var vertices: Array<Number> = definedExternally
    open var vertSize: Number = definedExternally
    open fun end(): Unit = definedExternally
    open fun begin(spriteBatch: SpriteBatch, renderSession: RenderSession): Unit = definedExternally
    open fun destroy(removeView: Boolean?): Unit = definedExternally
    open fun flush(): Unit = definedExternally
    open fun render(spriteBatch: SpriteBatch): Unit = definedExternally
    open fun renderSprite(sprite: Sprite): Unit = definedExternally
    open fun setContext(gl: WebGLRenderingContext): Unit = definedExternally
    open fun start(): Unit = definedExternally
    open fun stop(): Unit = definedExternally
}
external open class WebGLFilterManager {
    open var filterStack: Array<AbstractFilter> = definedExternally
    open var transparent: Boolean = definedExternally
    open var offsetX: Number = definedExternally
    open var offsetY: Number = definedExternally
    open fun applyFilterPass(filter: AbstractFilter, filterArea: Texture, width: Number, height: Number): Unit = definedExternally
    open fun begin(renderSession: RenderSession, buffer: ArrayBuffer): Unit = definedExternally
    open fun destroy(): Unit = definedExternally
    open fun initShaderBuffers(): Unit = definedExternally
    open fun popFilter(): Unit = definedExternally
    open fun pushFilter(filterBlock: FilterBlock): Unit = definedExternally
    open fun setContext(gl: WebGLRenderingContext): Unit = definedExternally
}
external open class WebGLGraphics {
    open fun reset(): Unit = definedExternally
    open fun upload(): Unit = definedExternally

    companion object {
        var graphicsDataPool: Array<Any> = definedExternally
        fun renderGraphics(graphics: Graphics, renderRession: RenderSession): Unit = definedExternally
        fun updateGraphics(graphics: Graphics, gl: WebGLRenderingContext): Unit = definedExternally
        fun switchMode(webGL: WebGLRenderingContext, type: Number): Any = definedExternally
        fun buildRectangle(graphicsData: GraphicsData, webGLData: Any): Unit = definedExternally
        fun buildRoundedRectangle(graphicsData: GraphicsData, webGLData: Any): Unit = definedExternally
        fun quadraticBezierCurve(fromX: Number, fromY: Number, cpX: Number, cpY: Number, toX: Number, toY: Number): Array<Number> = definedExternally
        fun buildCircle(graphicsData: GraphicsData, webGLData: Any): Unit = definedExternally
        fun buildLine(graphicsData: GraphicsData, webGLData: Any): Unit = definedExternally
        fun buildComplexPoly(graphicsData: GraphicsData, webGLData: Any): Unit = definedExternally
        fun buildPoly(graphicsData: GraphicsData, webGLData: Any): Boolean = definedExternally
    }
}
external open class WebGLGraphicsData(gl: WebGLRenderingContext) {
    open var gl: WebGLRenderingContext = definedExternally
    open var glPoints: Array<Any> = definedExternally
    open var color: Array<Number> = definedExternally
    open var points: Array<Any> = definedExternally
    open var indices: Array<Any> = definedExternally
    open var buffer: WebGLBuffer = definedExternally
    open var indexBuffer: WebGLBuffer = definedExternally
    open var mode: Number = definedExternally
    open var alpha: Number = definedExternally
    open var dirty: Boolean = definedExternally
    open fun reset(): Unit = definedExternally
    open fun upload(): Unit = definedExternally
}
external open class WebGLMaskManager {
    open fun destroy(): Unit = definedExternally
    open fun popMask(renderSession: RenderSession): Unit = definedExternally
    open fun pushMask(maskData: Array<Any>, renderSession: RenderSession): Unit = definedExternally
    open fun setContext(gl: WebGLRenderingContext): Unit = definedExternally
}
external open class WebGLRenderer(game: Phaser.Game) : PixiRenderer {
    open var game: Phaser.Game = definedExternally
    override var type: Number = definedExternally
    override var resolution: Number = definedExternally
    override var transparent: Boolean = definedExternally
    override var autoResize: Boolean = definedExternally
    open var preserveDrawingBuffer: Boolean = definedExternally
    override var clearBeforeRender: Boolean = definedExternally
    override var width: Number = definedExternally
    override var height: Number = definedExternally
    open var currentBatchedTextures: Array<String> = definedExternally
    override var view: HTMLCanvasElement = definedExternally
    open var projection: Point = definedExternally
    open var offset: Point = definedExternally
    open var shaderManager: WebGLShaderManager = definedExternally
    open var spriteBatch: WebGLSpriteBatch = definedExternally
    open var maskManager: WebGLMaskManager = definedExternally
    open var filterManager: WebGLFilterManager = definedExternally
    open var stencilManager: WebGLStencilManager = definedExternally
    open var blendModeManager: WebGLBlendModeManager = definedExternally
    open var renderSession: RenderSession = definedExternally
    open fun initContext(): Unit = definedExternally
    override fun render(stage: DisplayObjectContainer): Unit = definedExternally
    open fun renderDisplayObject(displayObject: DisplayObject, projection: Point, buffer: WebGLBuffer): Unit = definedExternally
    override fun resize(width: Number, height: Number): Unit = definedExternally
    open fun updateTexture(texture: Texture): Unit = definedExternally
    override fun destroy(): Unit = definedExternally
    open fun mapBlendModes(): Unit = definedExternally
    open fun setTexturePriority(textureNameCollection: Array<String>): Array<String> = definedExternally

    companion object {
        fun createWebGLTexture(texture: Texture, gl: WebGLRenderingContext): Unit = definedExternally
    }
}
external open class WebGLShaderManager {
    open var maxAttibs: Number = definedExternally
    open var attribState: Array<Any> = definedExternally
    open var stack: Array<Any> = definedExternally
    open var tempAttribState: Array<Any> = definedExternally
    open fun destroy(): Unit = definedExternally
    open fun setAttribs(attribs: Array<ShaderAttribute>): Unit = definedExternally
    open fun setContext(gl: WebGLRenderingContext): Unit = definedExternally
    open fun setShader(shader: IPixiShader): Boolean = definedExternally
}
external open class WebGLStencilManager {
    open var stencilStack: Array<Any> = definedExternally
    open var reverse: Boolean = definedExternally
    open var count: Number = definedExternally
    open fun bindGraphics(graphics: Graphics, webGLData: Array<Any>, renderSession: RenderSession): Unit = definedExternally
    open fun destroy(): Unit = definedExternally
    open fun popStencil(graphics: Graphics, webGLData: Array<Any>, renderSession: RenderSession): Unit = definedExternally
    open fun pushStencil(graphics: Graphics, webGLData: Array<Any>, renderSession: RenderSession): Unit = definedExternally
    open fun setContext(gl: WebGLRenderingContext): Unit = definedExternally
}
external open class WebGLSpriteBatch {
    open var blendModes: Array<Number> = definedExternally
    open var colors: Array<Number> = definedExternally
    open var currentBatchSize: Number = definedExternally
    open var currentBaseTexture: Texture = definedExternally
    open var defaultShader: AbstractFilter = definedExternally
    open var dirty: Boolean = definedExternally
    open var drawing: Boolean = definedExternally
    open var indices: Array<Number> = definedExternally
    open var lastIndexCount: Number = definedExternally
    open var positions: Array<Number> = definedExternally
    open var textures: Array<Texture> = definedExternally
    open var shaders: Array<IPixiShader> = definedExternally
    open var size: Number = definedExternally
    open var sprites: Array<Any> = definedExternally
    open var vertices: Array<Number> = definedExternally
    open var vertSize: Number = definedExternally
    open fun begin(renderSession: RenderSession): Unit = definedExternally
    open fun destroy(): Unit = definedExternally
    open fun end(): Unit = definedExternally
    open fun flush(shader: IPixiShader?): Unit = definedExternally
    open fun render(sprite: Sprite): Unit = definedExternally
    open fun renderBatch(texture: Texture, size: Number, startIndex: Number): Unit = definedExternally
    open fun renderTilingSprite(sprite: TilingSprite): Unit = definedExternally
    open fun setBlendMode(blendMode: blendModes): Unit = definedExternally
    open fun setContext(gl: WebGLRenderingContext): Unit = definedExternally
    open fun start(): Unit = definedExternally
    open fun stop(): Unit = definedExternally
}
/*external open class RenderTexture(width: Number?, height: Number?, renderer: PixiRenderer?, scaleMode: scaleModes?, resolution: Number?)
    : Texture {
    override var frame: Rectangle = definedExternally
    override var baseTexture: BaseTexture = definedExternally
    open var renderer: PixiRenderer = definedExternally
    open var resolution: Number = definedExternally
    override var valid: Boolean = definedExternally
    open fun clear(): Unit = definedExternally
    open fun getBase64(): String = definedExternally
    open fun getCanvas(): HTMLCanvasElement = definedExternally
    open fun getImage(): HTMLImageElement = definedExternally
    open fun resize(width: Number, height: Number, updateBase: Boolean): Unit = definedExternally
    open fun render(displayObject: DisplayObject, matrix: Matrix?, clear: Boolean?): Unit = definedExternally
}*/
external open class BoneData(name: String, parent: Any?) {
    open var name: String = definedExternally
    open var parent: Any = definedExternally
    open var length: Number = definedExternally
    open var x: Number = definedExternally
    open var y: Number = definedExternally
    open var rotation: Number = definedExternally
    open var scaleX: Number = definedExternally
    open var scaleY: Number = definedExternally
}
external open class SlotData(name: String, boneData: BoneData) {
    open var name: String = definedExternally
    open var boneData: BoneData = definedExternally
    open var r: Number = definedExternally
    open var g: Number = definedExternally
    open var b: Number = definedExternally
    open var a: Number = definedExternally
    open var attachmentName: String = definedExternally
}
external open class Bone(boneData: BoneData, parent: Any?) {
    open var data: BoneData = definedExternally
    open var parent: Any = definedExternally
    open var yDown: Boolean = definedExternally
    open var x: Number = definedExternally
    open var y: Number = definedExternally
    open var rotation: Number = definedExternally
    open var scaleX: Number = definedExternally
    open var scaleY: Number = definedExternally
    open var worldRotation: Number = definedExternally
    open var worldScaleX: Number = definedExternally
    open var worldScaleY: Number = definedExternally
    open fun updateWorldTransform(flipX: Boolean, flip: Boolean): Unit = definedExternally
    open fun setToSetupPose(): Unit = definedExternally
}
external open class Slot(slotData: SlotData, skeleton: Skeleton, bone: Bone) {
    open var data: SlotData = definedExternally
    open var skeleton: Skeleton = definedExternally
    open var bone: Bone = definedExternally
    open var r: Number = definedExternally
    open var g: Number = definedExternally
    open var b: Number = definedExternally
    open var a: Number = definedExternally
    open var attachment: RegionAttachment = definedExternally
    open fun setAttachment(attachment: RegionAttachment): Unit = definedExternally
    open fun setAttachmentTime(time: Number): Unit = definedExternally
    open fun getAttachmentTime(): Number = definedExternally
    open fun setToSetupPose(): Unit = definedExternally
}
external open class Skin(name: String) {
    open var name: String = definedExternally
    open var attachments: Any = definedExternally
    open fun addAttachment(slotIndex: Number, name: String, attachment: RegionAttachment): Unit = definedExternally
    open fun getAttachment(slotIndex: Number, name: String): Unit = definedExternally
}
external open class Animation(name: String, timelines: Array<ISpineTimeline>, duration: Number) {
    open var name: String = definedExternally
    open var timelines: Array<ISpineTimeline> = definedExternally
    open var duration: Number = definedExternally
    open fun apply(skeleton: Skeleton, time: Number, loop: Boolean): Unit = definedExternally
    open fun min(skeleton: Skeleton, time: Number, loop: Boolean, alpha: Number): Unit = definedExternally
}
external open class Curves(frameCount: Number) {
    open var curves: Array<Number> = definedExternally
    open fun setLinear(frameIndex: Number): Unit = definedExternally
    open fun setStepped(frameIndex: Number): Unit = definedExternally
    open fun setCurve(frameIndex: Number, cx1: Number, cy1: Number, cx2: Number, cy2: Number): Unit = definedExternally
    open fun getCurvePercent(frameIndex: Number, percent: Number): Number = definedExternally
}

external interface ISpineTimeline {
    var curves: Curves
    var frames: Array<Number>
    fun getFrameCount(): Number
    fun apply(skeleton: Skeleton, time: Number, alpha: Number)
}
external open class RotateTimeline(frameCount: Number) : ISpineTimeline {
    override var curves: Curves = definedExternally
    override var frames: Array<Number> = definedExternally
    open var boneIndex: Number = definedExternally
    override fun getFrameCount(): Number = definedExternally
    open fun setFrame(frameIndex: Number, time: Number, angle: Number): Unit = definedExternally
    override fun apply(skeleton: Skeleton, time: Number, alpha: Number): Unit = definedExternally
}
external open class TranslateTimeline(frameCount: Number) : ISpineTimeline {
    override var curves: Curves = definedExternally
    override var frames: Array<Number> = definedExternally
    open var boneIndex: Number = definedExternally
    override fun getFrameCount(): Number = definedExternally
    open fun setFrame(frameIndex: Number, time: Number, x: Number, y: Number): Unit = definedExternally
    override fun apply(skeleton: Skeleton, time: Number, alpha: Number): Unit = definedExternally
}
external open class ScaleTimeline(frameCount: Number) : ISpineTimeline {
    override var curves: Curves = definedExternally
    override var frames: Array<Number> = definedExternally
    open var boneIndex: Number = definedExternally
    override fun getFrameCount(): Number = definedExternally
    open fun setFrame(frameIndex: Number, time: Number, x: Number, y: Number): Unit = definedExternally
    override fun apply(skeleton: Skeleton, time: Number, alpha: Number): Unit = definedExternally
}
external open class ColorTimeline(frameCount: Number) : ISpineTimeline {
    override var curves: Curves = definedExternally
    override var frames: Array<Number> = definedExternally
    open var boneIndex: Number = definedExternally
    override fun getFrameCount(): Number = definedExternally
    open fun setFrame(frameIndex: Number, time: Number, r: Number, g: Number, b: Number, a: Number): Unit = definedExternally
    override fun apply(skeleton: Skeleton, time: Number, alpha: Number): Unit = definedExternally
}
external open class AttachmentTimeline(frameCount: Number) : ISpineTimeline {
    override var curves: Curves = definedExternally
    override var frames: Array<Number> = definedExternally
    open var attachmentNames: Array<String> = definedExternally
    open var slotIndex: Number = definedExternally
    override fun getFrameCount(): Number = definedExternally
    open fun setFrame(frameIndex: Number, time: Number, attachmentName: String): Unit = definedExternally
    override fun apply(skeleton: Skeleton, time: Number, alpha: Number): Unit = definedExternally
}
external open class SkeletonData {
    open var bones: Array<Bone> = definedExternally
    open var slots: Array<Slot> = definedExternally
    open var skins: Array<Skin> = definedExternally
    open var animations: Array<Animation> = definedExternally
    open var defaultSkin: Skin = definedExternally
    open fun findBone(boneName: String): Bone = definedExternally
    open fun findBoneIndex(boneName: String): Number = definedExternally
    open fun findSlot(slotName: String): Slot = definedExternally
    open fun findSlotIndex(slotName: String): Number = definedExternally
    open fun findSkin(skinName: String): Skin = definedExternally
    open fun findAnimation(animationName: String): Animation = definedExternally
}
external open class Skeleton(skeletonData: SkeletonData) {
    open var data: SkeletonData = definedExternally
    open var bones: Array<Bone> = definedExternally
    open var slots: Array<Slot> = definedExternally
    open var drawOrder: Array<Any> = definedExternally
    open var x: Number = definedExternally
    open var y: Number = definedExternally
    open var skin: Skin = definedExternally
    open var r: Number = definedExternally
    open var g: Number = definedExternally
    open var b: Number = definedExternally
    open var a: Number = definedExternally
    open var time: Number = definedExternally
    open var flipX: Boolean = definedExternally
    open var flipY: Boolean = definedExternally
    open fun updateWorldTransform(): Unit = definedExternally
    open fun setToSetupPose(): Unit = definedExternally
    open fun setBonesToSetupPose(): Unit = definedExternally
    open fun setSlotsToSetupPose(): Unit = definedExternally
    open fun getRootBone(): Bone = definedExternally
    open fun findBone(boneName: String): Bone = definedExternally
    open fun fineBoneIndex(boneName: String): Number = definedExternally
    open fun findSlot(slotName: String): Slot = definedExternally
    open fun findSlotIndex(slotName: String): Number = definedExternally
    open fun setSkinByName(skinName: String): Unit = definedExternally
    open fun setSkin(newSkin: Skin): Unit = definedExternally
    open fun getAttachmentBySlotName(slotName: String, attachmentName: String): RegionAttachment = definedExternally
    open fun getAttachmentBySlotIndex(slotIndex: Number, attachmentName: String): RegionAttachment = definedExternally
    open fun setAttachment(slotName: String, attachmentName: String): Unit = definedExternally
    open fun update(data: Number): Unit = definedExternally
}
external open class RegionAttachment {
    open var offset: Array<Number> = definedExternally
    open var uvs: Array<Number> = definedExternally
    open var x: Number = definedExternally
    open var y: Number = definedExternally
    open var rotation: Number = definedExternally
    open var scaleX: Number = definedExternally
    open var scaleY: Number = definedExternally
    open var width: Number = definedExternally
    open var height: Number = definedExternally
    open var rendererObject: Any = definedExternally
    open var regionOffsetX: Number = definedExternally
    open var regionOffsetY: Number = definedExternally
    open var regionWidth: Number = definedExternally
    open var regionHeight: Number = definedExternally
    open var regionOriginalWidth: Number = definedExternally
    open var regionOriginalHeight: Number = definedExternally
    open fun setUVs(u: Number, v: Number, u2: Number, v2: Number, rotate: Number): Unit = definedExternally
    open fun updateOffset(): Unit = definedExternally
    open fun computeVertices(x: Number, y: Number, bone: Bone, vertices: Array<Number>): Unit = definedExternally
}
external open class AnimationStateData(skeletonData: SkeletonData) {
    open var skeletonData: SkeletonData = definedExternally
    open var animationToMixTime: Any = definedExternally
    open var defaultMix: Number = definedExternally
    open fun setMixByName(fromName: String, toName: String, duration: Number): Unit = definedExternally
    open fun setMix(from: String, to: String): Number = definedExternally
}
external open class AnimationState(stateData: Any) {
    open var animationSpeed: Number = definedExternally
    open var current: Any = definedExternally
    open var previous: Any = definedExternally
    open var currentTime: Number = definedExternally
    open var previousTime: Number = definedExternally
    open var currentLoop: Boolean = definedExternally
    open var previousLoop: Boolean = definedExternally
    open var mixTime: Number = definedExternally
    open var mixDuration: Number = definedExternally
    open var queue: Array<Animation> = definedExternally
    open fun update(delta: Number): Unit = definedExternally
    open fun apply(skeleton: Any): Unit = definedExternally
    open fun clearAnimation(): Unit = definedExternally
    open fun setAnimation(animation: Any, loop: Boolean): Unit = definedExternally
    open fun setAnimationByName(animationName: String, loop: Boolean): Unit = definedExternally
    open fun addAnimationByName(animationName: String, loop: Boolean, delay: Number): Unit = definedExternally
    open fun addAnimation(animation: Any, loop: Boolean, delay: Number): Unit = definedExternally
    open fun isComplete(): Number = definedExternally
}
external open class SkeletonJson(attachmentLoader: AtlasAttachmentLoader) {
    open var attachmentLoader: AtlasAttachmentLoader = definedExternally
    open var scale: Number = definedExternally
    open fun readSkeletonData(root: Any): SkeletonData = definedExternally
    open fun readAttachment(skin: Skin, name: String, map: Any): RegionAttachment = definedExternally
    open fun readAnimation(name: String, map: Any, skeletonData: SkeletonData): Unit = definedExternally
    open fun readCurve(timeline: ISpineTimeline, frameIndex: Number, valueMap: Any): Unit = definedExternally
    open fun toColor(hexString: String, colorIndex: Number): Number = definedExternally
}

external interface `T$4` {
    var alpha: Number
    var intensity: Number
    var luminanceAlpha: Number
    var rgb565: Number
    var rgba4444: Number
    var rgb888: Number
    var rgba8888: Number
}

external interface `T$5` {
    var nearest: Number
    var linear: Number
    var mipMap: Number
    var mipMapNearestNearest: Number
    var mipMapLinearNearest: Number
    var mipMapNearestLinear: Number
    var mipMapLinearLinear: Number
}

external interface `T$6` {
    var mirroredRepeat: Number
    var clampToEdge: Number
    var repeat: Number
}
external open class Atlas(atlasText: String, textureLoader: AtlasLoader) {
    open var textureLoader: AtlasLoader = definedExternally
    open var pages: Array<AtlasPage> = definedExternally
    open var regions: Array<AtlasRegion> = definedExternally
    open fun findRegion(name: String): AtlasRegion = definedExternally
    open fun dispose(): Unit = definedExternally
    open fun updateUVs(page: AtlasPage): Unit = definedExternally

    companion object {
        var FORMAT: `T$4` = definedExternally
        var TextureFilter: `T$5` = definedExternally
        var textureWrap: `T$6` = definedExternally
    }
}
external open class AtlasPage {
    open var name: String = definedExternally
    open var format: Number = definedExternally
    open var minFilter: Number = definedExternally
    open var magFilter: Number = definedExternally
    open var uWrap: Number = definedExternally
    open var vWrap: Number = definedExternally
    open var rendererObject: Any = definedExternally
    open var width: Number = definedExternally
    open var height: Number = definedExternally
}
external open class AtlasRegion {
    open var page: AtlasPage = definedExternally
    open var name: String = definedExternally
    open var x: Number = definedExternally
    open var y: Number = definedExternally
    open var width: Number = definedExternally
    open var height: Number = definedExternally
    open var u: Number = definedExternally
    open var v: Number = definedExternally
    open var u2: Number = definedExternally
    open var v2: Number = definedExternally
    open var offsetX: Number = definedExternally
    open var offsetY: Number = definedExternally
    open var originalWidth: Number = definedExternally
    open var originalHeight: Number = definedExternally
    open var index: Number = definedExternally
    open var rotate: Boolean = definedExternally
    open var splits: Array<Any> = definedExternally
    open var pads: Array<Any> = definedExternally
}
external open class AtlasReader(text: String) {
    open var lines: Array<String> = definedExternally
    open var index: Number = definedExternally
    open fun trim(value: String): String = definedExternally
    open fun readLine(): String = definedExternally
    open fun readValue(): String = definedExternally
    open fun readTuple(tuple: Number): Number = definedExternally
}
external open class AtlasAttachmentLoader(atlas: Atlas) {
    open var atlas: Atlas = definedExternally
    open fun newAttachment(skin: Skin, type: Number, name: String): RegionAttachment = definedExternally
}

external interface `T$7` {
    var name: String
}
external open class Spine(url: String) : DisplayObjectContainer {
    open var autoUpdate: Boolean = definedExternally
    open var spineData: Any = definedExternally
    open var skeleton: Skeleton = definedExternally
    open var stateData: AnimationStateData = definedExternally
    open var state: AnimationState = definedExternally
    open var slotContainers: Array<DisplayObjectContainer> = definedExternally
    open fun createSprite(slot: Slot, descriptor: `T$7`): Array<Sprite> = definedExternally
    open fun update(dt: Number): Unit = definedExternally
}

external object PolyK {
    fun Triangulate(p: Array<Number>): Array<Number> = definedExternally
}


external fun requestAnimFrame(callback: Function<Any>): Unit = definedExternally
