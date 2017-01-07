
external object p2 {
    interface `T$0` {
        var upperBound: Array<Number>? get() = noImpl; set(value){}
        var lowerBound: Array<Number>? get() = noImpl; set(value){}
    }
    open class AABB(options: `T$0`? = null) {
        open fun setFromPoints(points: Array<Array<Number>>, position: Array<Number>, angle: Number, skinSize: Number): Unit = noImpl
        open fun copy(aabb: AABB): Unit = noImpl
        open fun extend(aabb: AABB): Unit = noImpl
        open fun overlaps(aabb: AABB): Boolean = noImpl
    }
    open class Broadphase() {
        constructor(type: Number):this()
        open var type: Number = noImpl
        open var result: Array<Body> = noImpl
        open var world: World = noImpl
        open var boundingVolumeType: Number = noImpl
        open fun setWorld(world: World): Unit = noImpl
        open fun getCollisionPairs(world: World): Array<Body> = noImpl
        open fun boundingVolumeCheck(bodyA: Body, bodyB: Body): Boolean = noImpl
        companion object {
            var AABB: Number = noImpl
            var BOUNDING_CIRCLE: Number = noImpl
            var NAIVE: Number = noImpl
            var SAP: Number = noImpl
            fun boundingRadiusCheck(bodyA: Body, bodyB: Body): Boolean = noImpl
            fun aabbCheck(bodyA: Body, bodyB: Body): Boolean = noImpl
            fun canCollide(bodyA: Body, bodyB: Body): Boolean = noImpl
        }
    }
    interface `T$1` {
        var xmin: Number? get() = noImpl; set(value){}
        var xmax: Number? get() = noImpl; set(value){}
        var ymin: Number? get() = noImpl; set(value){}
        var ymax: Number? get() = noImpl; set(value){}
        var nx: Number? get() = noImpl; set(value){}
        var ny: Number? get() = noImpl; set(value){}
    }
    open class GridBroadphase(options: `T$1`? = null) : Broadphase() {
        open var xmin: Number = noImpl
        open var xmax: Number = noImpl
        open var ymin: Number = noImpl
        open var ymax: Number = noImpl
        open var nx: Number = noImpl
        open var ny: Number = noImpl
        open var binsizeX: Number = noImpl
        open var binsizeY: Number = noImpl
    }
    open class NativeBroadphase : Broadphase()
    open class Narrowphase {
        open var contactEquations: Array<ContactEquation> = noImpl
        open var frictionEquations: Array<FrictionEquation> = noImpl
        open var enableFriction: Boolean = noImpl
        open var slipForce: Number = noImpl
        open var frictionCoefficient: Number = noImpl
        open var surfaceVelocity: Number = noImpl
        open var reuseObjects: Boolean = noImpl
        open var resuableContactEquations: Array<Any> = noImpl
        open var reusableFrictionEquations: Array<Any> = noImpl
        open var restitution: Number = noImpl
        open var stiffness: Number = noImpl
        open var relaxation: Number = noImpl
        open var frictionStiffness: Number = noImpl
        open var frictionRelaxation: Number = noImpl
        open var enableFrictionReduction: Boolean = noImpl
        open var contactSkinSize: Number = noImpl
        open fun collidedLastStep(bodyA: Body, bodyB: Body): Boolean = noImpl
        open fun reset(): Unit = noImpl
        open fun createContactEquation(bodyA: Body, bodyB: Body, shapeA: Shape, shapeB: Shape): ContactEquation = noImpl
        open fun createFrictionFromContact(c: ContactEquation): FrictionEquation = noImpl
    }
    open class SAPBroadphase : Broadphase() {
        open var axisList: Array<Body> = noImpl
        open var axisIndex: Number = noImpl
    }
    interface `T$2` {
        var collideConnected: Boolean? get() = noImpl; set(value){}
        var wakeUpBodies: Boolean? get() = noImpl; set(value){}
    }
    open class Constraint() {
        constructor(bodyA: Body, bodyB: Body, type: Number, options: `T$2`? = null):this()
        open var type: Number = noImpl
        open var equeations: Array<Equation> = noImpl
        open var bodyA: Body = noImpl
        open var bodyB: Body = noImpl
        open var collideConnected: Boolean = noImpl
        open fun update(): Unit = noImpl
        open fun setStiffness(stiffness: Number): Unit = noImpl
        open fun setRelaxation(relaxation: Number): Unit = noImpl
        companion object {
            var DISTANCE: Number = noImpl
            var GEAR: Number = noImpl
            var LOCK: Number = noImpl
            var PRISMATIC: Number = noImpl
            var REVOLUTE: Number = noImpl
        }
    }
    interface `T$3` {
        var collideConnected: Boolean? get() = noImpl; set(value){}
        var wakeUpBodies: Boolean? get() = noImpl; set(value){}
        var distance: Number? get() = noImpl; set(value){}
        var localAnchorA: Array<Number>? get() = noImpl; set(value){}
        var localAnchorB: Array<Number>? get() = noImpl; set(value){}
        var maxForce: Number? get() = noImpl; set(value){}
    }
    open class DistanceConstraint(bodyA: Body, bodyB: Body, type: Number, options: `T$3`? = null) : Constraint() {
        open var localAnchorA: Array<Number> = noImpl
        open var localAnchorB: Array<Number> = noImpl
        open var distance: Number = noImpl
        open var maxForce: Number = noImpl
        open var upperLimitEnabled: Boolean = noImpl
        open var upperLimit: Number = noImpl
        open var lowerLimitEnabled: Boolean = noImpl
        open var lowerLimit: Number = noImpl
        open var position: Number = noImpl
        open fun setMaxForce(f: Number): Unit = noImpl
        open fun getMaxForce(): Number = noImpl
    }
    interface `T$4` {
        var collideConnected: Boolean? get() = noImpl; set(value){}
        var wakeUpBodies: Boolean? get() = noImpl; set(value){}
        var angle: Number? get() = noImpl; set(value){}
        var ratio: Number? get() = noImpl; set(value){}
        var maxTorque: Number? get() = noImpl; set(value){}
    }
    open class GearConstraint(bodyA: Body, bodyB: Body, type: Number, options: `T$4`? = null) : Constraint() {
        open var ratio: Number = noImpl
        open var angle: Number = noImpl
        open fun setMaxTorque(torque: Number): Unit = noImpl
        open fun getMaxTorque(): Number = noImpl
    }
    interface `T$5` {
        var collideConnected: Boolean? get() = noImpl; set(value){}
        var wakeUpBodies: Boolean? get() = noImpl; set(value){}
        var localOffsetB: Array<Number>? get() = noImpl; set(value){}
        var localAngleB: Number? get() = noImpl; set(value){}
        var maxForce: Number? get() = noImpl; set(value){}
    }
    open class LockConstraint(bodyA: Body, bodyB: Body, type: Number, options: `T$5`? = null) : Constraint() {
        open fun setMaxForce(force: Number): Unit = noImpl
        open fun getMaxForce(): Number = noImpl
    }
    interface `T$6` {
        var collideConnected: Boolean? get() = noImpl; set(value){}
        var wakeUpBodies: Boolean? get() = noImpl; set(value){}
        var maxForce: Number? get() = noImpl; set(value){}
        var localAnchorA: Array<Number>? get() = noImpl; set(value){}
        var localAnchorB: Array<Number>? get() = noImpl; set(value){}
        var localAxisA: Array<Number>? get() = noImpl; set(value){}
        var disableRotationalLock: Boolean? get() = noImpl; set(value){}
        var upperLimit: Number? get() = noImpl; set(value){}
        var lowerLimit: Number? get() = noImpl; set(value){}
    }
    open class PrismaticConstraint(bodyA: Body, bodyB: Body, type: Number, options: `T$6`? = null) : Constraint() {
        open var localAnchorA: Array<Number> = noImpl
        open var localAnchorB: Array<Number> = noImpl
        open var localAxisA: Array<Number> = noImpl
        open var position: Number = noImpl
        open var velocity: Number = noImpl
        open var lowerLimitEnabled: Boolean = noImpl
        open var upperLimitEnabled: Boolean = noImpl
        open var lowerLimit: Number = noImpl
        open var upperLimit: Number = noImpl
        open var upperLimitEquation: ContactEquation = noImpl
        open var lowerLimitEquation: ContactEquation = noImpl
        open var motorEquation: Equation = noImpl
        open var motorEnabled: Boolean = noImpl
        open var motorSpeed: Number = noImpl
        open fun enableMotor(): Unit = noImpl
        open fun disableMotor(): Unit = noImpl
        open fun setLimits(lower: Number, upper: Number): Unit = noImpl
    }
    interface `T$7` {
        var collideConnected: Boolean? get() = noImpl; set(value){}
        var wakeUpBodies: Boolean? get() = noImpl; set(value){}
        var worldPivot: Array<Number>? get() = noImpl; set(value){}
        var localPivotA: Array<Number>? get() = noImpl; set(value){}
        var localPivotB: Array<Number>? get() = noImpl; set(value){}
        var maxForce: Number? get() = noImpl; set(value){}
    }
    open class RevoluteConstraint(bodyA: Body, bodyB: Body, type: Number, options: `T$7`? = null) : Constraint() {
        open var pivotA: Array<Number> = noImpl
        open var pivotB: Array<Number> = noImpl
        open var motorEquation: RotationalVelocityEquation = noImpl
        open var motorEnabled: Boolean = noImpl
        open var angle: Number = noImpl
        open var lowerLimitEnabled: Boolean = noImpl
        open var upperLimitEnabled: Boolean = noImpl
        open var lowerLimit: Number = noImpl
        open var upperLimit: Number = noImpl
        open var upperLimitEquation: ContactEquation = noImpl
        open var lowerLimitEquation: ContactEquation = noImpl
        open fun enableMotor(): Unit = noImpl
        open fun disableMotor(): Unit = noImpl
        open fun motorIsEnabled(): Boolean = noImpl
        open fun setLimits(lower: Number, upper: Number): Unit = noImpl
        open fun setMotorSpeed(speed: Number): Unit = noImpl
        open fun getMotorSpeed(): Number = noImpl
    }
    interface `T$8` {
        var angle: Number? get() = noImpl; set(value){}
        var ratio: Number? get() = noImpl; set(value){}
    }
    open class AngleLockEquation(bodyA: Body, bodyB: Body, options: `T$8`? = null) : Equation() {
        override fun computeGq(): Number = noImpl
        open fun setRatio(ratio: Number): Number = noImpl
        open fun setMaxTorque(torque: Number): Number = noImpl
    }
    open class ContactEquation(bodyA: Body, bodyB: Body) : Equation() {
        open var contactPointA: Array<Number> = noImpl
        open var penetrationVec: Array<Number> = noImpl
        open var contactPointB: Array<Number> = noImpl
        open var normalA: Array<Number> = noImpl
        open var restitution: Number = noImpl
        open var firstImpact: Boolean = noImpl
        open var shapeA: Shape = noImpl
        open var shapeB: Shape = noImpl
        override fun computeB(a: Number, b: Number, h: Number): Number = noImpl
    }
    open class Equation() {
        constructor(bodyA: Body, bodyB: Body, minForce: Number? = null, maxForce: Number? = null):this()
        open var minForce: Number = noImpl
        open var maxForce: Number = noImpl
        open var bodyA: Body = noImpl
        open var bodyB: Body = noImpl
        open var stiffness: Number = noImpl
        open var relaxation: Number = noImpl
        open var G: Array<Number> = noImpl
        open var offset: Number = noImpl
        open var a: Number = noImpl
        open var b: Number = noImpl
        open var epsilon: Number = noImpl
        open var timeStep: Number = noImpl
        open var needsUpdate: Boolean = noImpl
        open var multiplier: Number = noImpl
        open var relativeVelocity: Number = noImpl
        open var enabled: Boolean = noImpl
        open fun gmult(G: Array<Number>, vi: Array<Number>, wi: Array<Number>, vj: Array<Number>, wj: Array<Number>): Number = noImpl
        open fun computeB(a: Number, b: Number, h: Number): Number = noImpl
        open fun computeGq(): Number = noImpl
        open fun computeGW(): Number = noImpl
        open fun computeGWlambda(): Number = noImpl
        open fun computeGiMf(): Number = noImpl
        open fun computeGiMGt(): Number = noImpl
        open fun addToWlambda(deltalambda: Number): Number = noImpl
        open fun computeInvC(eps: Number): Number = noImpl
        companion object {
            var DEFAULT_STIFFNESS: Number = noImpl
            var DEFAULT_RELAXATION: Number = noImpl
        }
    }
    open class FrictionEquation(bodyA: Body, bodyB: Body, slipForce: Number) : Equation() {
        open var contactPointA: Array<Number> = noImpl
        open var contactPointB: Array<Number> = noImpl
        open var t: Array<Number> = noImpl
        open var shapeA: Shape = noImpl
        open var shapeB: Shape = noImpl
        open var frictionCoefficient: Number = noImpl
        open fun setSlipForce(slipForce: Number): Number = noImpl
        open fun getSlipForce(): Number = noImpl
        override fun computeB(a: Number, b: Number, h: Number): Number = noImpl
    }
    interface `T$9` {
        var angle: Number? get() = noImpl; set(value){}
    }
    open class RotationalLockEquation(bodyA: Body, bodyB: Body, options: `T$9`? = null) : Equation() {
        open var angle: Number = noImpl
        override fun computeGq(): Number = noImpl
    }
    open class RotationalVelocityEquation(bodyA: Body, bodyB: Body) : Equation() {
        override fun computeB(a: Number, b: Number, h: Number): Number = noImpl
    }
    open class EventEmitter {
        open fun on(type: String, listener: Function<Any>, context: Any): EventEmitter = noImpl
        open fun has(type: String, listener: Function<Any>): Boolean = noImpl
        open fun off(type: String, listener: Function<Any>): EventEmitter = noImpl
        open fun emit(event: Any): EventEmitter = noImpl
    }
    open class ContactMaterialOptions {
        open var friction: Number = noImpl
        open var restitution: Number = noImpl
        open var stiffness: Number = noImpl
        open var relaxation: Number = noImpl
        open var frictionStiffness: Number = noImpl
        open var frictionRelaxation: Number = noImpl
        open var surfaceVelocity: Number = noImpl
    }
    open class ContactMaterial() {
        constructor(materialA: Material, materialB: Material, options: ContactMaterialOptions? = null):this()
        open var id: Number = noImpl
        open var materialA: Material = noImpl
        open var materialB: Material = noImpl
        open var friction: Number = noImpl
        open var restitution: Number = noImpl
        open var stiffness: Number = noImpl
        open var relaxation: Number = noImpl
        open var frictionStiffness: Number = noImpl
        open var frictionRelaxation: Number = noImpl
        open var surfaceVelocity: Number = noImpl
        open var contactSkinSize: Number = noImpl
        companion object {
            var idCounter: Number = noImpl
        }
    }
    open class Material() {
        constructor(id: Number):this()
        open var id: Number = noImpl
        companion object {
            var idCounter: Number = noImpl
        }
    }
    open class vec2 {
        companion object {
            fun crossLength(a: Array<Number>, b: Array<Number>): Number = noImpl
            fun crossVZ(out: Array<Number>, vec: Array<Number>, zcomp: Number): Number = noImpl
            fun crossZV(out: Array<Number>, zcomp: Number, vec: Array<Number>): Number = noImpl
            fun rotate(out: Array<Number>, a: Array<Number>, angle: Number): Unit = noImpl
            fun rotate90cw(out: Array<Number>, a: Array<Number>): Number = noImpl
            fun centroid(out: Array<Number>, a: Array<Number>, b: Array<Number>, c: Array<Number>): Array<Number> = noImpl
            fun create(): Array<Number> = noImpl
            fun clone(a: Array<Number>): Array<Number> = noImpl
            fun fromValues(x: Number, y: Number): Array<Number> = noImpl
            fun copy(out: Array<Number>, a: Array<Number>): Array<Number> = noImpl
            fun set(out: Array<Number>, x: Number, y: Number): Array<Number> = noImpl
            fun toLocalFrame(out: Array<Number>, worldPoint: Array<Number>, framePosition: Array<Number>, frameAngle: Number): Unit = noImpl
            fun toGlobalFrame(out: Array<Number>, localPoint: Array<Number>, framePosition: Array<Number>, frameAngle: Number): Unit = noImpl
            fun add(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = noImpl
            fun subtract(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = noImpl
            fun sub(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = noImpl
            fun multiply(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = noImpl
            fun mul(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = noImpl
            fun divide(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = noImpl
            fun div(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = noImpl
            fun scale(out: Array<Number>, a: Array<Number>, b: Number): Array<Number> = noImpl
            fun distance(a: Array<Number>, b: Array<Number>): Number = noImpl
            fun dist(a: Array<Number>, b: Array<Number>): Number = noImpl
            fun squaredDistance(a: Array<Number>, b: Array<Number>): Number = noImpl
            fun sqrDist(a: Array<Number>, b: Array<Number>): Number = noImpl
            fun length(a: Array<Number>): Number = noImpl
            fun len(a: Array<Number>): Number = noImpl
            fun squaredLength(a: Array<Number>): Number = noImpl
            fun sqrLen(a: Array<Number>): Number = noImpl
            fun negate(out: Array<Number>, a: Array<Number>): Array<Number> = noImpl
            fun normalize(out: Array<Number>, a: Array<Number>): Array<Number> = noImpl
            fun dot(a: Array<Number>, b: Array<Number>): Double = noImpl
            fun str(a: Array<Number>): String = noImpl
        }
    }
    open class BodyOptions {
        open var mass: Number = noImpl
        open var position: Array<Number> = noImpl
        open var velocity: Array<Number> = noImpl
        open var angle: Number = noImpl
        open var angularVelocity: Number = noImpl
        open var force: Array<Number> = noImpl
        open var angularForce: Number = noImpl
        open var fixedRotation: Number = noImpl
    }
    interface `T$10` {
        var type: String
    }
    interface `T$11` {
        var optimalDecomp: Boolean? get() = noImpl; set(value){}
        var skipSimpleCheck: Boolean? get() = noImpl; set(value){}
        var removeCollinearPoints: Any? get() = noImpl; set(value){}
    }
    open class Body() : EventEmitter() {
        constructor(options: BodyOptions? = null):this()
        open var sleepyEvent: `T$10` = noImpl
        open var sleepEvent: `T$10` = noImpl
        open var wakeUpEvent: `T$10` = noImpl
        open var id: Number = noImpl
        open var world: World = noImpl
        open var shapes: Array<Shape> = noImpl
        open var shapeOffsets: Array<Array<Number>> = noImpl
        open var shapeAngles: Array<Number> = noImpl
        open var mass: Number = noImpl
        open var invMass: Number = noImpl
        open var inertia: Number = noImpl
        open var invInertia: Number = noImpl
        open var invMassSolve: Number = noImpl
        open var invInertiaSolve: Number = noImpl
        open var fixedRotation: Number = noImpl
        open var position: Array<Number> = noImpl
        open var interpolatedPosition: Array<Number> = noImpl
        open var interpolatedAngle: Number = noImpl
        open var previousPosition: Array<Number> = noImpl
        open var previousAngle: Number = noImpl
        open var velocity: Array<Number> = noImpl
        open var vlambda: Array<Number> = noImpl
        open var wlambda: Array<Number> = noImpl
        open var angle: Number = noImpl
        open var angularVelocity: Number = noImpl
        open var force: Array<Number> = noImpl
        open var angularForce: Number = noImpl
        open var damping: Number = noImpl
        open var angularDamping: Number = noImpl
        open var type: Number = noImpl
        open var boundingRadius: Number = noImpl
        open var aabb: AABB = noImpl
        open var aabbNeedsUpdate: Boolean = noImpl
        open var allowSleep: Boolean = noImpl
        open var wantsToSleep: Boolean = noImpl
        open var sleepState: Number = noImpl
        open var sleepSpeedLimit: Number = noImpl
        open var sleepTimeLimit: Number = noImpl
        open var gravityScale: Number = noImpl
        open fun updateSolveMassProperties(): Unit = noImpl
        open fun setDensity(density: Number): Unit = noImpl
        open fun getArea(): Number = noImpl
        open fun getAABB(): AABB = noImpl
        open fun updateAABB(): Unit = noImpl
        open fun updateBoundingRadius(): Unit = noImpl
        open fun addShape(shape: Shape, offset: Array<Number>? = null, angle: Number? = null): Unit = noImpl
        open fun removeShape(shape: Shape): Boolean = noImpl
        open fun updateMassProperties(): Unit = noImpl
        open fun applyForce(force: Array<Number>, worldPoint: Array<Number>): Unit = noImpl
        open fun toLocalFrame(out: Array<Number>, worldPoint: Array<Number>): Unit = noImpl
        open fun toWorldFrame(out: Array<Number>, localPoint: Array<Number>): Unit = noImpl
        open fun fromPolygon(path: Array<Array<Number>>, options: `T$11`? = null): Boolean = noImpl
        open fun adjustCenterOfMass(): Unit = noImpl
        open fun setZeroForce(): Unit = noImpl
        open fun resetConstraintVelocity(): Unit = noImpl
        open fun applyDamping(dy: Number): Unit = noImpl
        open fun wakeUp(): Unit = noImpl
        open fun sleep(): Unit = noImpl
        open fun sleepTick(time: Number, dontSleep: Boolean, dt: Number): Unit = noImpl
        open fun getVelocityFromPosition(story: Array<Number>, dt: Number): Array<Number> = noImpl
        open fun getAngularVelocityFromPosition(timeStep: Number): Number = noImpl
        open fun overlaps(body: Body): Boolean = noImpl
        companion object {
            var DYNAMIC: Number = noImpl
            var STATIC: Number = noImpl
            var KINEMATIC: Number = noImpl
            var AWAKE: Number = noImpl
            var SLEEPY: Number = noImpl
            var SLEEPING: Number = noImpl
        }
    }
    interface `T$12` {
        var stiffness: Number? get() = noImpl; set(value){}
        var damping: Number? get() = noImpl; set(value){}
        var localAnchorA: Array<Number>? get() = noImpl; set(value){}
        var localAnchorB: Array<Number>? get() = noImpl; set(value){}
        var worldAnchorA: Array<Number>? get() = noImpl; set(value){}
        var worldAnchorB: Array<Number>? get() = noImpl; set(value){}
    }
    open class Spring() {
        constructor(bodyA: Body, bodyB: Body, options: `T$12`? = null):this()
        open var stiffness: Number = noImpl
        open var damping: Number = noImpl
        open var bodyA: Body = noImpl
        open var bodyB: Body = noImpl
        open fun applyForce(): Unit = noImpl
    }
    open class LinearSpring : Spring() {
        open var localAnchorA: Array<Number> = noImpl
        open var localAnchorB: Array<Number> = noImpl
        open var restLength: Number = noImpl
        open fun setWorldAnchorA(worldAnchorA: Array<Number>): Unit = noImpl
        open fun setWorldAnchorB(worldAnchorB: Array<Number>): Unit = noImpl
        open fun getWorldAnchorA(result: Array<Number>): Array<Number> = noImpl
        open fun getWorldAnchorB(result: Array<Number>): Array<Number> = noImpl
        override fun applyForce(): Unit = noImpl
    }
    interface `T$13` {
        var restAngle: Number? get() = noImpl; set(value){}
        var stiffness: Number? get() = noImpl; set(value){}
        var damping: Number? get() = noImpl; set(value){}
    }
    open class RotationalSpring(bodyA: Body, bodyB: Body, options: `T$13`? = null) : Spring() {
        open var restAngle: Number = noImpl
    }
    open class Capsule(length: Number? = null, radius: Number? = null) : Shape() {
        open var length: Number = noImpl
        open var radius: Number = noImpl
    }
    open class Circle(radius: Number) : Shape() {
        open var radius: Number = noImpl
    }
    open class Convex(vertices: Array<Array<Number>>, axes: Array<Number>) : Shape() {
        open var vertices: Array<Array<Number>> = noImpl
        open var axes: Array<Number> = noImpl
        open var centerOfMass: Array<Number> = noImpl
        open var triangles: Array<Number> = noImpl
        override var boundingRadius: Number = noImpl
        open fun projectOntoLocalAxis(localAxis: Array<Number>, result: Array<Number>): Unit = noImpl
        open fun projectOntoWorldAxis(localAxis: Array<Number>, shapeOffset: Array<Number>, shapeAngle: Number, result: Array<Number>): Unit = noImpl
        open fun updateCenterOfMass(): Unit = noImpl
        companion object {
            fun triangleArea(a: Array<Number>, b: Array<Number>, c: Array<Number>): Number = noImpl
        }
    }
    interface `T$14` {
        var minValue: Number? get() = noImpl; set(value){}
        var maxValue: Number? get() = noImpl; set(value){}
        var elementWidth: Number
    }
    open class Heightfield(data: Array<Number>, options: `T$14`? = null) : Shape() {
        open var data: Array<Number> = noImpl
        open var maxValue: Number = noImpl
        open var minValue: Number = noImpl
        open var elementWidth: Number = noImpl
    }
    open class Shape(){
        constructor(type: Number):this()
        open var type: Number = noImpl
        open var id: Number = noImpl
        open var boundingRadius: Number = noImpl
        open var collisionGroup: Number = noImpl
        open var collisionMask: Number = noImpl
        open var material: Material = noImpl
        open var area: Number = noImpl
        open var sensor: Boolean = noImpl
        open fun computeMomentOfInertia(mass: Number): Number = noImpl
        open fun updateBoundingRadius(): Number = noImpl
        open fun updateArea(): Unit = noImpl
        open fun computeAABB(out: AABB, position: Array<Number>, angle: Number): Unit = noImpl
        companion object {
            var idCounter: Number = noImpl
            var CIRCLE: Number = noImpl
            var PARTICLE: Number = noImpl
            var PLANE: Number = noImpl
            var CONVEX: Number = noImpl
            var LINE: Number = noImpl
            var RECTANGLE: Number = noImpl
            var CAPSULE: Number = noImpl
            var HEIGHTFIELD: Number = noImpl
        }
    }
    open class Line(length: Number? = null) : Shape() {
        open var length: Number = noImpl
    }
    open class Particle : Shape()
    open class Plane : Shape()
    open class Rectangle(width: Number? = null, height: Number? = null) : Shape() {
        open var width: Number = noImpl
        open var height: Number = noImpl
        companion object {
            fun sameDimensions(a: Rectangle, b: Rectangle): Boolean = noImpl
        }
    }
    open class Solver(options: Any? = null, type: Number? = null) : EventEmitter() {
        open var type: Number = noImpl
        open var equations: Array<Equation> = noImpl
        open var equationSortFunction: Equation = noImpl
        open fun solve(dy: Number, world: World): Unit = noImpl
        open fun solveIsland(dy: Number, island: Island): Unit = noImpl
        open fun sortEquations(): Unit = noImpl
        open fun addEquation(eq: Equation): Unit = noImpl
        open fun addEquations(eqs: Array<Equation>): Unit = noImpl
        open fun removeEquation(eq: Equation): Unit = noImpl
        open fun removeAllEquations(): Unit = noImpl
        companion object {
            var GS: Number = noImpl
            var ISLAND: Number = noImpl
        }
    }
    interface `T$15` {
        var iterations: Number? get() = noImpl; set(value){}
        var tolerance: Number? get() = noImpl; set(value){}
    }
    open class GSSolver(options: `T$15`? = null) : Solver() {
        open var iterations: Number = noImpl
        open var tolerance: Number = noImpl
        open var useZeroRHS: Boolean = noImpl
        open var frictionIterations: Number = noImpl
        open var usedIterations: Number = noImpl
        override fun solve(h: Number, world: World): Unit = noImpl
    }
    open class OverlapKeeper(bodyA: Body, shapeA: Shape, bodyB: Body, shapeB: Shape) {
        open var shapeA: Shape = noImpl
        open var shapeB: Shape = noImpl
        open var bodyA: Body = noImpl
        open var bodyB: Body = noImpl
        open fun tick(): Unit = noImpl
        open fun setOverlapping(bodyA: Body, shapeA: Shape, bodyB: Body, shapeB: Body): Unit = noImpl
        open fun bodiesAreOverlapping(bodyA: Body, bodyB: Body): Boolean = noImpl
        open fun set(bodyA: Body, shapeA: Shape, bodyB: Body, shapeB: Shape): Unit = noImpl
    }
    open class TupleDictionary {
        open var data: Array<Number> = noImpl
        open var keys: Array<Number> = noImpl
        open fun getKey(id1: Number, id2: Number): String = noImpl
        open fun getByKey(key: Number): Number = noImpl
        open fun get(i: Number, j: Number): Number = noImpl
        open fun set(i: Number, j: Number, value: Number): Number = noImpl
        open fun reset(): Unit = noImpl
        open fun copy(dict: TupleDictionary): Unit = noImpl
    }
    open class Utils {
        companion object {
            fun <T> appendArray(a: Array<T>, b: Array<T>): Array<T> = noImpl
            fun chanceRoll(chance: Number): Boolean = noImpl
            fun defaults(options: Any, defaults: Any): Any = noImpl
            fun extend(a: Any, b: Any): Unit = noImpl
            fun randomChoice(choice1: Any, choice2: Any): Any = noImpl
            fun rotateArray(matrix: Array<Any>, direction: Any): Array<Any> = noImpl
            fun <T> splice(array: Array<T>, index: Number, howMany: Number): Unit = noImpl
            fun <T> shuffle(array: Array<T>): Array<T> = noImpl
            fun <T> transposeArray(array: Array<T>): Array<T> = noImpl
        }
    }
    open class Island {
        open var equations: Array<Equation> = noImpl
        open var bodies: Array<Body> = noImpl
        open fun reset(): Unit = noImpl
        open fun getBodies(result: Any): Array<Body> = noImpl
        open fun wantsToSleep(): Boolean = noImpl
        open fun sleep(): Boolean = noImpl
    }
    open class IslandManager : Solver() {
        override var equations: Array<Equation> = noImpl
        open var islands: Array<Island> = noImpl
        open var nodes: Array<IslandNode> = noImpl
        open fun visit(node: IslandNode, bds: Array<Body>, eqs: Array<Equation>): Unit = noImpl
        open fun bfs(root: IslandNode, bds: Array<Body>, eqs: Array<Equation>): Unit = noImpl
        open fun split(world: World): Array<Island> = noImpl
        companion object {
            fun getUnvisitedNode(nodes: Array<IslandNode>): IslandNode = noImpl
        }
    }
    open class IslandNode(body: Body) {
        open var body: Body = noImpl
        open var neighbors: Array<IslandNode> = noImpl
        open var equations: Array<Equation> = noImpl
        open var visited: Boolean = noImpl
        open fun reset(): Unit = noImpl
    }
    interface `T$16` {
        var type: String
        var bodyA: Body
        var bodyB: Body
        var shapeA: Shape
        var shapeB: Shape
        var contactEquation: ContactEquation
    }
    interface `T$17` {
        var type: String
        var pairs: Array<Body>
    }
    interface `T$18` {
        var type: String
        var shapeA: Shape
        var shapeB: Shape
        var bodyA: Body
        var bodyB: Body
        var contactEquations: Array<ContactEquation>
    }
    interface `T$19` {
        var type: String
        var shapeA: Shape
        var shapeB: Shape
        var bodyA: Body
        var bodyB: Body
    }
    interface `T$20` {
        var type: String
        var contactEquations: Array<ContactEquation>
        var frictionEquations: Array<FrictionEquation>
    }
    interface `T$21` {
        var solver: Solver? get() = noImpl; set(value){}
        var gravity: Array<Number>? get() = noImpl; set(value){}
        var broadphase: Broadphase? get() = noImpl; set(value){}
        var islandSplit: Boolean? get() = noImpl; set(value){}
        var doProfiling: Boolean? get() = noImpl; set(value){}
    }
    interface `T$22` {
        var relaxation: Number? get() = noImpl; set(value){}
        var stiffness: Number? get() = noImpl; set(value){}
    }
    open class World(options: `T$21`? = null) : EventEmitter() {
        open var postStepEvent: `T$10` = noImpl
        open var addBodyEvent: `T$10` = noImpl
        open var removeBodyEvent: `T$10` = noImpl
        open var addSpringEvent: `T$10` = noImpl
        open var impactEvent: `T$16` = noImpl
        open var postBroadphaseEvent: `T$17` = noImpl
        open var beginContactEvent: `T$18` = noImpl
        open var endContactEvent: `T$19` = noImpl
        open var preSolveEvent: `T$20` = noImpl
        open var springs: Array<Spring> = noImpl
        open var bodies: Array<Body> = noImpl
        open var solver: Solver = noImpl
        open var narrowphase: Narrowphase = noImpl
        open var islandManager: IslandManager = noImpl
        open var gravity: Array<Number> = noImpl
        open var frictionGravity: Number = noImpl
        open var useWorldGravityAsFrictionGravity: Boolean = noImpl
        open var useFrictionGravityOnZeroGravity: Boolean = noImpl
        open var doProfiling: Boolean = noImpl
        open var lastStepTime: Number = noImpl
        open var broadphase: Broadphase = noImpl
        open var constraints: Array<Constraint> = noImpl
        open var defaultMaterial: Material = noImpl
        open var defaultContactMaterial: ContactMaterial = noImpl
        open var lastTimeStep: Number = noImpl
        open var applySpringForces: Boolean = noImpl
        open var applyDamping: Boolean = noImpl
        open var applyGravity: Boolean = noImpl
        open var solveConstraints: Boolean = noImpl
        open var contactMaterials: Array<ContactMaterial> = noImpl
        open var time: Number = noImpl
        open var stepping: Boolean = noImpl
        open var islandSplit: Boolean = noImpl
        open var emitImpactEvent: Boolean = noImpl
        open var sleepMode: Number = noImpl
        open fun addConstraint(c: Constraint): Unit = noImpl
        open fun addContactMaterial(contactMaterial: ContactMaterial): Unit = noImpl
        open fun removeContactMaterial(cm: ContactMaterial): Unit = noImpl
        open fun getContactMaterial(materialA: Material, materialB: Material): ContactMaterial = noImpl
        open fun removeConstraint(c: Constraint): Unit = noImpl
        open fun step(dy: Number, timeSinceLastCalled: Number? = null, maxSubSteps: Number? = null): Unit = noImpl
        open fun runNarrowphase(np: Narrowphase, bi: Body, si: Shape, xi: Array<Any>, ai: Number, bj: Body, sj: Shape, xj: Array<Any>, aj: Number, cm: Number, glen: Number): Unit = noImpl
        open fun addSpring(s: Spring): Unit = noImpl
        open fun removeSpring(s: Spring): Unit = noImpl
        open fun addBody(body: Body): Unit = noImpl
        open fun removeBody(body: Body): Unit = noImpl
        open fun getBodyByID(id: Number): Body = noImpl
        open fun disableBodyCollision(bodyA: Body, bodyB: Body): Unit = noImpl
        open fun enableBodyCollision(bodyA: Body, bodyB: Body): Unit = noImpl
        open fun clear(): Unit = noImpl
        open fun clone(): World = noImpl
        open fun hitTest(worldPoint: Array<Number>, bodies: Array<Body>, precision: Number): Array<Body> = noImpl
        open fun setGlobalEquationParameters(parameters: `T$22`): Unit = noImpl
        open fun setGlobalStiffness(stiffness: Number): Unit = noImpl
        open fun setGlobalRelaxation(relaxation: Number): Unit = noImpl
        companion object {
            var NO_SLEEPING: Number = noImpl
            var BODY_SLEEPING: Number = noImpl
            var ISLAND_SLEEPING: Number = noImpl
            fun integrateBody(body: Body, dy: Number): Unit = noImpl
        }
    }
}
