package PIXI

import Phaser.Point
import org.khronos.webgl.WebGLFramebuffer

/**
 * The base class for all objects that are rendered on the screen.
 * This is an abstract class and should not be used on its own rather it should be extended.
 */
@JsName("PIXI.DisplayObject")
external abstract class DisplayObject {
    /**
     * The coordinate of the object relative to the local coordinates of the parent.
     */
    open var position: Point = Point()


    /**
     * The position of the displayObject on the x axis relative to the local coordinates of the parent.
     */
    open var x: Double

    /**
     * The position of the displayObject on the y axis relative to the local coordinates of the parent.
     */
    open var y: Double

    /**
     * The scale factor of the object.
     */
    open var scale: Point = Point(1.0, 1.0)

    /**
     * The pivot Point of the displayObject that it rotates around
     */
    open var pivot: Point = Point(0.0, 0.0)

    /**
     * The rotation of the object in radians.
     */
    open var rotation: Number = 0.0

    /**
     * The opacity of the object.
     */
    open var alpha: Number = 1.0

    /**
     * The visibility of the object.
     */
    open var visible: Boolean = true

    /**
     * Indicates if the sprite is globally visible.
     */
    open val worldVisible: Boolean 

    /**
     * This is the defined area that will pick up mouse / touch events. It is null by default.
     * Setting it is a neat way of optimising the hitTest function that the InteractionManager will use (as it will not need to hit test all the children)
     */
    //open var hitArea: Geometry? = null

    /**
     * This is used to indicate if the displayObject should display a mouse hand cursor on rollover
     */
    open var buttonMode: Boolean = false

    /**
     * Can this object be rendered
     */
    open var renderable: Boolean = false

    /**
     * The display object container that contains this display object.
     */
    open val parent: DisplayObjectContainer? 

    /**
     * The stage the display object is connected to, or undefined if it is not connected to the stage.
     */
    //open val stage: Stage? 

    /**
     * The multiplied alpha of the displayObject
     */
    open val worldAlpha: Number = 1.0

    /**
     * This is the cursor that will be used when the mouse is over this object. To enable this the element must have interactive = true and buttonMode = true
     */
    open var defaultCursor: String = "Pointer"

    /**
     * The area the filter is applied to like the hitArea this is used as more of an optimisation
     * rather than figuring out the dimensions of the displayObject each frame you can set this rectangle
     */
    //open var filterArea: Rectangle? = null

    /**
     * Indicates if the sprite will have touch and mouse interactivity. It is false by default
     */
    open var interactive: Boolean = false

    /**
     * Sets a mask for the displayObject. A mask is an object that limits the visibility of an object to the shape of the mask applied to it.
     * In PIXI a regular mask must be a PIXI.Graphics object. This allows for much faster masking in canvas as it utilises shape clipping.
     * To remove a mask, set this property to null.
     */
    //open var mask: Graphics? 

    /**
     * Sets the filters for the displayObject.
     * IMPORTANT: This is a webGL only feature and will be ignored by the canvas renderer.
     * To remove filters simply set this property to 'null'
     */
    //open var filters: Array<AbstractFilter> 

    /**
     * Set if this display object is cached as a bitmap.
     * This basically takes a snap shot of the display object as it is at that moment. It can provide a performance benefit for complex static displayObjects.
     * To remove simply set this property to false
     */
    open var cacheAsBitmap: Boolean 

    /**
     * A callback that is used when the users mouse rolls over the displayObject
     */
    //open var mouseover: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the users mouse leaves the displayObject
     */
    //open var mouseout: DisplayObject.(InteractionData) -> Unit 

    /**
     * Is called when the mouse moves across the renderer element
     * Defined by PIXI.InteractionManager
     */
    //open var mousemove: DisplayObject.(InteractionData) -> Unit 

    /**
     * Is called when a touch is moved across the renderer element
     * Defined by PIXI.InteractionManager
     */
    //open var touchmove: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the users clicks on the displayObject with their mouse's left button
     */
    //open var click: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the user clicks the mouse's left button down over the sprite
     */
    //open var mousedown: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the user releases the mouse's left button that was over the displayObject
     * for this callback to be fired, the mouse's left button must have been pressed down over the displayObject
     */
    //open var mouseup: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the user releases the mouse's left button that was over the displayObject but is no longer over the displayObject
     * for this callback to be fired, the mouse's left button must have been pressed down over the displayObject
     */
    //open var mouseupoutside: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the users clicks on the displayObject with their mouse's right button
     */
    //open var rightclick: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the user clicks the mouse's left button down over the sprite
     */
    //open var rightdown: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the user releases the mouse's right button that was over the displayObject
     * for this callback to be fired, the mouse's right button must have been pressed down over the displayObject
     */
    //open var rightup: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the user releases the mouse's right button that was over the displayObject but is no longer over the displayObject
     * for this callback to be fired, the mouse's right button must have been pressed down over the displayObject
     */
    //open var rightuseupoutside: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the users taps on the sprite with their finger
     * basically a touch version of click
     */
    //open var tap: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the user touches over the displayObject
     */
    //open var touchstart: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the user releases a touch over the displayObject
     */
   // open var touchend: DisplayObject.(InteractionData) -> Unit 

    /**
     * A callback that is used when the user releases the touch that was over the displayObject
     * for this callback to be fired, The touch must have started over the sprite
     */
    //open var touchendoutside: DisplayObject.(InteractionData) -> Unit 

    /**
     * Retrieves the bounds of the displayObject as a rectangle object
     */
    //open public fun getBounds(matrix: Matrix): Rectangle 

    /**
     * Retrieves the local bounds of the displayObject as a rectangle object
     */
    //open public fun getLocalBounds(): Rectangle 

    /**
     * Sets the object's stage reference, the stage this object is connected to
     *
     * @param stage The stage that the object will have as its current stage reference
     */
    //open public fun setStageReference(stage: Stage): Unit 

    /**
     * Useful function that returns a texture of the displayObject object that can then be used to create sprites
     * This can be quite useful if your displayObject is static / complicated and needs to be reused multiple times.
     *
     * @param resolution The resolution of the texture being generated
     * @param scaleMode Should be one of the PIXI.scaleMode consts
     * @param renderer The renderer used to generate the texture.
     * @return a texture of the graphics object
     */
    //public fun generateTexture(resolution: Int, scaleMode: Int, renderer: Renderer): Texture 

    /**
     * Generates and updates the cached sprite for this object
     */
    public fun updateCache(): Unit 

    /**
     * Calculates the global position of the display object
     *
     * @param position The world origin to calculate from
     * @return A Point object representing the position of this object
     */
    fun toGlobal(position: Point): Point 

    /**
     * Calculates the local position of the display object relative to another Point
     *
     * @param position The world origin to calculate from
     * @param [from] The DisplayObject to calculate the global position from
     * @return A Point object representing the position of this object
     */
    fun toLocal(position: Point): Point 
    fun toLocal(position: Point, from: DisplayObject): Point 
}
@JsName("PIXI.DisplayObjectContainer")
external open class DisplayObjectContainer : DisplayObject() {

    /**
     *  The array of children of this container.
     */
    open val children: Array<DisplayObject> 

    /**
     * Adds a child to the container.
     *
     * @param child The DisplayObject to add to the container
     * @return child that was added.
     */
    public fun addChild(child: DisplayObject): DisplayObject 

    /**
     * Adds a child to the container at a specified index. If the index is out of bounds an error will be thrown
     *
     * @param child The child to add
     * @param index The index to place the child in
     * @return The child that was added.
     */
    public fun addChildAt(child: DisplayObject, index: Int): DisplayObject 

    /**
     * Swaps the position of 2 Display Objects within this container.
     */
    public fun swapChildren(child: DisplayObject, child2: DisplayObject): Unit 

    /**
     * Returns the index position of a child DisplayObject instance
     *
     * @param child The DisplayObject instance to identify
     * @return The index position of the child display object to identify
     */
    public fun getChildIndex(child: DisplayObject): Int 

    /**
     * Changes the position of an existing child in the display object container
     *
     * @param child The child DisplayObject instance for which you want to change the index number
     * @param index The resulting index number for the child display object
     */
    public fun setChildIndex(child: DisplayObject, index: Int): Unit 

    /**
     * Returns the child at the specified index
     *
     * @param index The index to get the child from
     * @return The child at the given index, if any.
     */
    public fun getChildAt(index: Int): DisplayObject 

    /**
     * Removes a child from the container.
     *
     * @param child The DisplayObject to remove
     * @return The child that was removed.
     */
    public fun removeChild(child: DisplayObject): Unit 

    /**
     * Removes a child from the specified index position.
     *
     * @param index The index to get the child from
     * @return The child that was removed.
     */
    public fun removeChildAt(index: Int): DisplayObject 

    /**
     * Removes all children from this container that are within the begin and end indexes.
     *
     * @param beginIndex The beginning position. Default value is 0.
     * @param endIndex The ending position. Default value is size of the container.
     */
    //public fun removeChildren(beginIndex: Int = 0, endIndex: Int = children.size): Array<DisplayObject>
    fun removeChildren(): Array<DisplayObject> {
        return removeChildren(0)
    }
    fun removeChildren(beginIndex: Int): Array<DisplayObject> {
        return removeChildren(beginIndex, children.size)
    }
    fun removeChildren(beginIndex: Int, endIndex: Int): Array<DisplayObject>

    /**
     * Retrieves the bounds of the displayObjectContainer as a rectangle. The bounds calculation takes all visible children into consideration.
     *
     * @return The rectangular bounding area
     */
    //open public fun getBounds(): Rectangle 

    /**
     * Retrieves the non-global local bounds of the displayObjectContainer as a rectangle. The calculation takes all visible children into consideration.
     *
     * @return The rectangular bounding area
     */
    //override public fun getLocalBounds(): Rectangle 

    /**
     * Sets the containers Stage reference. This is the Stage that this object, and all of its children, is connected to.
     *
     * @param stage The stage that the container will have as its current stage reference
     */
    //override public fun setStageReference(stage: Stage): Unit 

    /**
     * Removes the current stage reference from the container and all of its children.
     */
    public fun removeStageReference(): Unit 

    /**
     * The width of the displayObjectContainer, setting this will actually modify the scale to achieve the value set
     */
    public open var width: Number

    /**
     * The height of the displayObjectContainer, setting this will actually modify the scale to achieve the value set
     */
    public open var height: Number
}

@JsName("PIXI.RoundedRectangle")
external open class RoundedRectangle:Rectangle() {
    open var radius: Number
    open fun clone(): RoundedRectangle
}
@JsName("PIXI.Rectangle")
external open class Rectangle {
    open var x: Number
    open var y: Number
    open var width: Number
    open var height: Number
    open fun contains(x: Number, y: Number): Boolean
}
@JsName("PIXI.Graphics")
external open class Graphics:DisplayObjectContainer()
@JsName("PIXI.BaseTexture")
external open class BaseTexture
@JsName("PIXI.Texture")
external open class Texture
@JsName("PIXI.TilingSprite")
external open class TilingSprite:DisplayObjectContainer(){
    open var exists: Boolean
}
@JsName("PIXI.RenderTexture")
external open class RenderTexture {
    open var crop: PIXI.Rectangle
}
external open class Sprite():DisplayObjectContainer() {
    open var anchor: Point
    open var exists: Boolean
    open var tint: Int
}
@JsName("PIXI.AbstractFilter")
external open class AbstractFilter(){
    open fun apply(frameBuffer: WebGLFramebuffer): Unit
    open fun syncUniforms(): Unit
}
@JsName("PIXI.Rope")
external open class Rope{
    open var points: Array<Phaser.Point>
    open var position: Phaser.Point
    open var x: Number
    open var y: Number
}
@JsName("PIXI.Point")
external open class Point(){
    open var x: Number
    open var y: Number
    open fun set(x: Number, y: Number?):Point
}

