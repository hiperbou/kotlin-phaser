
external object p2 {
    interface `T$0` {
        var upperBound: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var lowerBound: Array<Number>? get() = definedExternally; set(value) = definedExternally
    }
    open class AABB(options: `T$0`? = definedExternally) {
        open fun setFromPoints(points: Array<Array<Number>>, position: Array<Number>, angle: Number, skinSize: Number): Unit = definedExternally
        open fun copy(aabb: AABB): Unit = definedExternally
        open fun extend(aabb: AABB): Unit = definedExternally
        open fun overlaps(aabb: AABB): Boolean = definedExternally
    }
    open class Broadphase() {
        constructor(type: Number)
        open var type: Number = definedExternally
        open var result: Array<Body> = definedExternally
        open var world: World = definedExternally
        open var boundingVolumeType: Number = definedExternally
        open fun setWorld(world: World): Unit = definedExternally
        open fun getCollisionPairs(world: World): Array<Body> = definedExternally
        open fun boundingVolumeCheck(bodyA: Body, bodyB: Body): Boolean = definedExternally
        companion object {
            var AABB: Number = definedExternally
            var BOUNDING_CIRCLE: Number = definedExternally
            var NAIVE: Number = definedExternally
            var SAP: Number = definedExternally
            fun boundingRadiusCheck(bodyA: Body, bodyB: Body): Boolean = definedExternally
            fun aabbCheck(bodyA: Body, bodyB: Body): Boolean = definedExternally
            fun canCollide(bodyA: Body, bodyB: Body): Boolean = definedExternally
        }
    }
    interface `T$1` {
        var xmin: Number? get() = definedExternally; set(value) = definedExternally
        var xmax: Number? get() = definedExternally; set(value) = definedExternally
        var ymin: Number? get() = definedExternally; set(value) = definedExternally
        var ymax: Number? get() = definedExternally; set(value) = definedExternally
        var nx: Number? get() = definedExternally; set(value) = definedExternally
        var ny: Number? get() = definedExternally; set(value) = definedExternally
    }
    open class GridBroadphase(options: `T$1`? = definedExternally) : Broadphase {
        open var xmin: Number = definedExternally
        open var xmax: Number = definedExternally
        open var ymin: Number = definedExternally
        open var ymax: Number = definedExternally
        open var nx: Number = definedExternally
        open var ny: Number = definedExternally
        open var binsizeX: Number = definedExternally
        open var binsizeY: Number = definedExternally
    }
    open class NativeBroadphase : Broadphase
    open class Narrowphase {
        open var contactEquations: Array<ContactEquation> = definedExternally
        open var frictionEquations: Array<FrictionEquation> = definedExternally
        open var enableFriction: Boolean = definedExternally
        open var slipForce: Number = definedExternally
        open var frictionCoefficient: Number = definedExternally
        open var surfaceVelocity: Number = definedExternally
        open var reuseObjects: Boolean = definedExternally
        open var resuableContactEquations: Array<Any> = definedExternally
        open var reusableFrictionEquations: Array<Any> = definedExternally
        open var restitution: Number = definedExternally
        open var stiffness: Number = definedExternally
        open var relaxation: Number = definedExternally
        open var frictionStiffness: Number = definedExternally
        open var frictionRelaxation: Number = definedExternally
        open var enableFrictionReduction: Boolean = definedExternally
        open var contactSkinSize: Number = definedExternally
        open fun collidedLastStep(bodyA: Body, bodyB: Body): Boolean = definedExternally
        open fun reset(): Unit = definedExternally
        open fun createContactEquation(bodyA: Body, bodyB: Body, shapeA: Shape, shapeB: Shape): ContactEquation = definedExternally
        open fun createFrictionFromContact(c: ContactEquation): FrictionEquation = definedExternally
    }
    open class SAPBroadphase : Broadphase {
        open var axisList: Array<Body> = definedExternally
        open var axisIndex: Number = definedExternally
    }
    interface `T$2` {
        var collideConnected: Boolean? get() = definedExternally; set(value) = definedExternally
        var wakeUpBodies: Boolean? get() = definedExternally; set(value) = definedExternally
    }
    open class Constraint() {
        constructor(bodyA: Body, bodyB: Body, type: Number, options: `T$2`? = definedExternally)
        open var type: Number = definedExternally
        open var equeations: Array<Equation> = definedExternally
        open var bodyA: Body = definedExternally
        open var bodyB: Body = definedExternally
        open var collideConnected: Boolean = definedExternally
        open fun update(): Unit = definedExternally
        open fun setStiffness(stiffness: Number): Unit = definedExternally
        open fun setRelaxation(relaxation: Number): Unit = definedExternally
        companion object {
            var DISTANCE: Number = definedExternally
            var GEAR: Number = definedExternally
            var LOCK: Number = definedExternally
            var PRISMATIC: Number = definedExternally
            var REVOLUTE: Number = definedExternally
        }
    }
    interface `T$3` {
        var collideConnected: Boolean? get() = definedExternally; set(value) = definedExternally
        var wakeUpBodies: Boolean? get() = definedExternally; set(value) = definedExternally
        var distance: Number? get() = definedExternally; set(value) = definedExternally
        var localAnchorA: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var localAnchorB: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var maxForce: Number? get() = definedExternally; set(value) = definedExternally
    }
    open class DistanceConstraint(bodyA: Body, bodyB: Body, type: Number, options: `T$3`? = definedExternally) : Constraint {
        open var localAnchorA: Array<Number> = definedExternally
        open var localAnchorB: Array<Number> = definedExternally
        open var distance: Number = definedExternally
        open var maxForce: Number = definedExternally
        open var upperLimitEnabled: Boolean = definedExternally
        open var upperLimit: Number = definedExternally
        open var lowerLimitEnabled: Boolean = definedExternally
        open var lowerLimit: Number = definedExternally
        open var position: Number = definedExternally
        open fun setMaxForce(f: Number): Unit = definedExternally
        open fun getMaxForce(): Number = definedExternally
    }
    interface `T$4` {
        var collideConnected: Boolean? get() = definedExternally; set(value) = definedExternally
        var wakeUpBodies: Boolean? get() = definedExternally; set(value) = definedExternally
        var angle: Number? get() = definedExternally; set(value) = definedExternally
        var ratio: Number? get() = definedExternally; set(value) = definedExternally
        var maxTorque: Number? get() = definedExternally; set(value) = definedExternally
    }
    open class GearConstraint(bodyA: Body, bodyB: Body, type: Number, options: `T$4`? = definedExternally) : Constraint {
        open var ratio: Number = definedExternally
        open var angle: Number = definedExternally
        open fun setMaxTorque(torque: Number): Unit = definedExternally
        open fun getMaxTorque(): Number = definedExternally
    }
    interface `T$5` {
        var collideConnected: Boolean? get() = definedExternally; set(value) = definedExternally
        var wakeUpBodies: Boolean? get() = definedExternally; set(value) = definedExternally
        var localOffsetB: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var localAngleB: Number? get() = definedExternally; set(value) = definedExternally
        var maxForce: Number? get() = definedExternally; set(value) = definedExternally
    }
    open class LockConstraint(bodyA: Body, bodyB: Body, type: Number, options: `T$5`? = definedExternally) : Constraint {
        open fun setMaxForce(force: Number): Unit = definedExternally
        open fun getMaxForce(): Number = definedExternally
    }
    interface `T$6` {
        var collideConnected: Boolean? get() = definedExternally; set(value) = definedExternally
        var wakeUpBodies: Boolean? get() = definedExternally; set(value) = definedExternally
        var maxForce: Number? get() = definedExternally; set(value) = definedExternally
        var localAnchorA: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var localAnchorB: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var localAxisA: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var disableRotationalLock: Boolean? get() = definedExternally; set(value) = definedExternally
        var upperLimit: Number? get() = definedExternally; set(value) = definedExternally
        var lowerLimit: Number? get() = definedExternally; set(value) = definedExternally
    }
    open class PrismaticConstraint(bodyA: Body, bodyB: Body, type: Number, options: `T$6`? = definedExternally) : Constraint {
        open var localAnchorA: Array<Number> = definedExternally
        open var localAnchorB: Array<Number> = definedExternally
        open var localAxisA: Array<Number> = definedExternally
        open var position: Number = definedExternally
        open var velocity: Number = definedExternally
        open var lowerLimitEnabled: Boolean = definedExternally
        open var upperLimitEnabled: Boolean = definedExternally
        open var lowerLimit: Number = definedExternally
        open var upperLimit: Number = definedExternally
        open var upperLimitEquation: ContactEquation = definedExternally
        open var lowerLimitEquation: ContactEquation = definedExternally
        open var motorEquation: Equation = definedExternally
        open var motorEnabled: Boolean = definedExternally
        open var motorSpeed: Number = definedExternally
        open fun enableMotor(): Unit = definedExternally
        open fun disableMotor(): Unit = definedExternally
        open fun setLimits(lower: Number, upper: Number): Unit = definedExternally
    }
    interface `T$7` {
        var collideConnected: Boolean? get() = definedExternally; set(value) = definedExternally
        var wakeUpBodies: Boolean? get() = definedExternally; set(value) = definedExternally
        var worldPivot: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var localPivotA: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var localPivotB: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var maxForce: Number? get() = definedExternally; set(value) = definedExternally
    }
    open class RevoluteConstraint(bodyA: Body, bodyB: Body, type: Number, options: `T$7`? = definedExternally) : Constraint {
        open var pivotA: Array<Number> = definedExternally
        open var pivotB: Array<Number> = definedExternally
        open var motorEquation: RotationalVelocityEquation = definedExternally
        open var motorEnabled: Boolean = definedExternally
        open var angle: Number = definedExternally
        open var lowerLimitEnabled: Boolean = definedExternally
        open var upperLimitEnabled: Boolean = definedExternally
        open var lowerLimit: Number = definedExternally
        open var upperLimit: Number = definedExternally
        open var upperLimitEquation: ContactEquation = definedExternally
        open var lowerLimitEquation: ContactEquation = definedExternally
        open fun enableMotor(): Unit = definedExternally
        open fun disableMotor(): Unit = definedExternally
        open fun motorIsEnabled(): Boolean = definedExternally
        open fun setLimits(lower: Number, upper: Number): Unit = definedExternally
        open fun setMotorSpeed(speed: Number): Unit = definedExternally
        open fun getMotorSpeed(): Number = definedExternally
    }
    interface `T$8` {
        var angle: Number? get() = definedExternally; set(value) = definedExternally
        var ratio: Number? get() = definedExternally; set(value) = definedExternally
    }
    open class AngleLockEquation(bodyA: Body, bodyB: Body, options: `T$8`? = definedExternally) : Equation {
        override fun computeGq(): Number = definedExternally
        open fun setRatio(ratio: Number): Number = definedExternally
        open fun setMaxTorque(torque: Number): Number = definedExternally
    }
    open class ContactEquation(bodyA: Body, bodyB: Body) : Equation {
        open var contactPointA: Array<Number> = definedExternally
        open var penetrationVec: Array<Number> = definedExternally
        open var contactPointB: Array<Number> = definedExternally
        open var normalA: Array<Number> = definedExternally
        open var restitution: Number = definedExternally
        open var firstImpact: Boolean = definedExternally
        open var shapeA: Shape = definedExternally
        open var shapeB: Shape = definedExternally
        override fun computeB(a: Number, b: Number, h: Number): Number = definedExternally
    }
    open class Equation() {
        constructor(bodyA: Body, bodyB: Body, minForce: Number? = definedExternally, maxForce: Number? = definedExternally)
        open var minForce: Number = definedExternally
        open var maxForce: Number = definedExternally
        open var bodyA: Body = definedExternally
        open var bodyB: Body = definedExternally
        open var stiffness: Number = definedExternally
        open var relaxation: Number = definedExternally
        open var G: Array<Number> = definedExternally
        open var offset: Number = definedExternally
        open var a: Number = definedExternally
        open var b: Number = definedExternally
        open var epsilon: Number = definedExternally
        open var timeStep: Number = definedExternally
        open var needsUpdate: Boolean = definedExternally
        open var multiplier: Number = definedExternally
        open var relativeVelocity: Number = definedExternally
        open var enabled: Boolean = definedExternally
        open fun gmult(G: Array<Number>, vi: Array<Number>, wi: Array<Number>, vj: Array<Number>, wj: Array<Number>): Number = definedExternally
        open fun computeB(a: Number, b: Number, h: Number): Number = definedExternally
        open fun computeGq(): Number = definedExternally
        open fun computeGW(): Number = definedExternally
        open fun computeGWlambda(): Number = definedExternally
        open fun computeGiMf(): Number = definedExternally
        open fun computeGiMGt(): Number = definedExternally
        open fun addToWlambda(deltalambda: Number): Number = definedExternally
        open fun computeInvC(eps: Number): Number = definedExternally
        companion object {
            var DEFAULT_STIFFNESS: Number = definedExternally
            var DEFAULT_RELAXATION: Number = definedExternally
        }
    }
    open class FrictionEquation(bodyA: Body, bodyB: Body, slipForce: Number) : Equation {
        open var contactPointA: Array<Number> = definedExternally
        open var contactPointB: Array<Number> = definedExternally
        open var t: Array<Number> = definedExternally
        open var shapeA: Shape = definedExternally
        open var shapeB: Shape = definedExternally
        open var frictionCoefficient: Number = definedExternally
        open fun setSlipForce(slipForce: Number): Number = definedExternally
        open fun getSlipForce(): Number = definedExternally
        override fun computeB(a: Number, b: Number, h: Number): Number = definedExternally
    }
    interface `T$9` {
        var angle: Number? get() = definedExternally; set(value) = definedExternally
    }
    open class RotationalLockEquation(bodyA: Body, bodyB: Body, options: `T$9`? = definedExternally) : Equation {
        open var angle: Number = definedExternally
        override fun computeGq(): Number = definedExternally
    }
    open class RotationalVelocityEquation(bodyA: Body, bodyB: Body) : Equation {
        override fun computeB(a: Number, b: Number, h: Number): Number = definedExternally
    }
    open class EventEmitter {
        open fun on(type: String, listener: Function<Any>, context: Any): EventEmitter = definedExternally
        open fun has(type: String, listener: Function<Any>): Boolean = definedExternally
        open fun off(type: String, listener: Function<Any>): EventEmitter = definedExternally
        open fun emit(event: Any): EventEmitter = definedExternally
    }
    open class ContactMaterialOptions {
        open var friction: Number = definedExternally
        open var restitution: Number = definedExternally
        open var stiffness: Number = definedExternally
        open var relaxation: Number = definedExternally
        open var frictionStiffness: Number = definedExternally
        open var frictionRelaxation: Number = definedExternally
        open var surfaceVelocity: Number = definedExternally
    }
    open class ContactMaterial() {
        constructor(materialA: Material, materialB: Material, options: ContactMaterialOptions? = definedExternally)
        open var id: Number = definedExternally
        open var materialA: Material = definedExternally
        open var materialB: Material = definedExternally
        open var friction: Number = definedExternally
        open var restitution: Number = definedExternally
        open var stiffness: Number = definedExternally
        open var relaxation: Number = definedExternally
        open var frictionStiffness: Number = definedExternally
        open var frictionRelaxation: Number = definedExternally
        open var surfaceVelocity: Number = definedExternally
        open var contactSkinSize: Number = definedExternally
        companion object {
            var idCounter: Number = definedExternally
        }
    }
    open class Material() {
        constructor(id: Number)
        open var id: Number = definedExternally
        companion object {
            var idCounter: Number = definedExternally
        }
    }
    open class vec2 {
        companion object {
            fun crossLength(a: Array<Number>, b: Array<Number>): Number = definedExternally
            fun crossVZ(out: Array<Number>, vec: Array<Number>, zcomp: Number): Number = definedExternally
            fun crossZV(out: Array<Number>, zcomp: Number, vec: Array<Number>): Number = definedExternally
            fun rotate(out: Array<Number>, a: Array<Number>, angle: Number): Unit = definedExternally
            fun rotate90cw(out: Array<Number>, a: Array<Number>): Number = definedExternally
            fun centroid(out: Array<Number>, a: Array<Number>, b: Array<Number>, c: Array<Number>): Array<Number> = definedExternally
            fun create(): Array<Number> = definedExternally
            fun clone(a: Array<Number>): Array<Number> = definedExternally
            fun fromValues(x: Number, y: Number): Array<Number> = definedExternally
            fun copy(out: Array<Number>, a: Array<Number>): Array<Number> = definedExternally
            fun set(out: Array<Number>, x: Number, y: Number): Array<Number> = definedExternally
            fun toLocalFrame(out: Array<Number>, worldPoint: Array<Number>, framePosition: Array<Number>, frameAngle: Number): Unit = definedExternally
            fun toGlobalFrame(out: Array<Number>, localPoint: Array<Number>, framePosition: Array<Number>, frameAngle: Number): Unit = definedExternally
            fun add(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = definedExternally
            fun subtract(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = definedExternally
            fun sub(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = definedExternally
            fun multiply(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = definedExternally
            fun mul(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = definedExternally
            fun divide(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = definedExternally
            fun div(out: Array<Number>, a: Array<Number>, b: Array<Number>): Array<Number> = definedExternally
            fun scale(out: Array<Number>, a: Array<Number>, b: Number): Array<Number> = definedExternally
            fun distance(a: Array<Number>, b: Array<Number>): Number = definedExternally
            fun dist(a: Array<Number>, b: Array<Number>): Number = definedExternally
            fun squaredDistance(a: Array<Number>, b: Array<Number>): Number = definedExternally
            fun sqrDist(a: Array<Number>, b: Array<Number>): Number = definedExternally
            fun length(a: Array<Number>): Number = definedExternally
            fun len(a: Array<Number>): Number = definedExternally
            fun squaredLength(a: Array<Number>): Number = definedExternally
            fun sqrLen(a: Array<Number>): Number = definedExternally
            fun negate(out: Array<Number>, a: Array<Number>): Array<Number> = definedExternally
            fun normalize(out: Array<Number>, a: Array<Number>): Array<Number> = definedExternally
            fun dot(a: Array<Number>, b: Array<Number>): Double = definedExternally
            fun str(a: Array<Number>): String = definedExternally
        }
    }
    open class BodyOptions {
        open var mass: Number = definedExternally
        open var position: Array<Number> = definedExternally
        open var velocity: Array<Number> = definedExternally
        open var angle: Number = definedExternally
        open var angularVelocity: Number = definedExternally
        open var force: Array<Number> = definedExternally
        open var angularForce: Number = definedExternally
        open var fixedRotation: Number = definedExternally
    }
    interface `T$10` {
        var type: String
    }
    interface `T$11` {
        var optimalDecomp: Boolean? get() = definedExternally; set(value) = definedExternally
        var skipSimpleCheck: Boolean? get() = definedExternally; set(value) = definedExternally
        var removeCollinearPoints: Any? get() = definedExternally; set(value) = definedExternally
    }
    open class Body() : EventEmitter {
        constructor(options: BodyOptions? = definedExternally)
        open var sleepyEvent: `T$10` = definedExternally
        open var sleepEvent: `T$10` = definedExternally
        open var wakeUpEvent: `T$10` = definedExternally
        open var id: Number = definedExternally
        open var world: World = definedExternally
        open var shapes: Array<Shape> = definedExternally
        open var shapeOffsets: Array<Array<Number>> = definedExternally
        open var shapeAngles: Array<Number> = definedExternally
        open var mass: Number = definedExternally
        open var invMass: Number = definedExternally
        open var inertia: Number = definedExternally
        open var invInertia: Number = definedExternally
        open var invMassSolve: Number = definedExternally
        open var invInertiaSolve: Number = definedExternally
        open var fixedRotation: Number = definedExternally
        open var position: Array<Number> = definedExternally
        open var interpolatedPosition: Array<Number> = definedExternally
        open var interpolatedAngle: Number = definedExternally
        open var previousPosition: Array<Number> = definedExternally
        open var previousAngle: Number = definedExternally
        open var velocity: Array<Number> = definedExternally
        open var vlambda: Array<Number> = definedExternally
        open var wlambda: Array<Number> = definedExternally
        open var angle: Number = definedExternally
        open var angularVelocity: Number = definedExternally
        open var force: Array<Number> = definedExternally
        open var angularForce: Number = definedExternally
        open var damping: Number = definedExternally
        open var angularDamping: Number = definedExternally
        open var type: Number = definedExternally
        open var boundingRadius: Number = definedExternally
        open var aabb: AABB = definedExternally
        open var aabbNeedsUpdate: Boolean = definedExternally
        open var allowSleep: Boolean = definedExternally
        open var wantsToSleep: Boolean = definedExternally
        open var sleepState: Number = definedExternally
        open var sleepSpeedLimit: Number = definedExternally
        open var sleepTimeLimit: Number = definedExternally
        open var gravityScale: Number = definedExternally
        open fun updateSolveMassProperties(): Unit = definedExternally
        open fun setDensity(density: Number): Unit = definedExternally
        open fun getArea(): Number = definedExternally
        open fun getAABB(): AABB = definedExternally
        open fun updateAABB(): Unit = definedExternally
        open fun updateBoundingRadius(): Unit = definedExternally
        open fun addShape(shape: Shape, offset: Array<Number>? = definedExternally, angle: Number? = definedExternally): Unit = definedExternally
        open fun removeShape(shape: Shape): Boolean = definedExternally
        open fun updateMassProperties(): Unit = definedExternally
        open fun applyForce(force: Array<Number>, worldPoint: Array<Number>): Unit = definedExternally
        open fun toLocalFrame(out: Array<Number>, worldPoint: Array<Number>): Unit = definedExternally
        open fun toWorldFrame(out: Array<Number>, localPoint: Array<Number>): Unit = definedExternally
        open fun fromPolygon(path: Array<Array<Number>>, options: `T$11`? = definedExternally): Boolean = definedExternally
        open fun adjustCenterOfMass(): Unit = definedExternally
        open fun setZeroForce(): Unit = definedExternally
        open fun resetConstraintVelocity(): Unit = definedExternally
        open fun applyDamping(dy: Number): Unit = definedExternally
        open fun wakeUp(): Unit = definedExternally
        open fun sleep(): Unit = definedExternally
        open fun sleepTick(time: Number, dontSleep: Boolean, dt: Number): Unit = definedExternally
        open fun getVelocityFromPosition(story: Array<Number>, dt: Number): Array<Number> = definedExternally
        open fun getAngularVelocityFromPosition(timeStep: Number): Number = definedExternally
        open fun overlaps(body: Body): Boolean = definedExternally
        companion object {
            var DYNAMIC: Number = definedExternally
            var STATIC: Number = definedExternally
            var KINEMATIC: Number = definedExternally
            var AWAKE: Number = definedExternally
            var SLEEPY: Number = definedExternally
            var SLEEPING: Number = definedExternally
        }
    }
    interface `T$12` {
        var stiffness: Number? get() = definedExternally; set(value) = definedExternally
        var damping: Number? get() = definedExternally; set(value) = definedExternally
        var localAnchorA: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var localAnchorB: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var worldAnchorA: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var worldAnchorB: Array<Number>? get() = definedExternally; set(value) = definedExternally
    }
    open class Spring() {
        constructor(bodyA: Body, bodyB: Body, options: `T$12`? = definedExternally)
        open var stiffness: Number = definedExternally
        open var damping: Number = definedExternally
        open var bodyA: Body = definedExternally
        open var bodyB: Body = definedExternally
        open fun applyForce(): Unit = definedExternally
    }
    open class LinearSpring : Spring {
        open var localAnchorA: Array<Number> = definedExternally
        open var localAnchorB: Array<Number> = definedExternally
        open var restLength: Number = definedExternally
        open fun setWorldAnchorA(worldAnchorA: Array<Number>): Unit = definedExternally
        open fun setWorldAnchorB(worldAnchorB: Array<Number>): Unit = definedExternally
        open fun getWorldAnchorA(result: Array<Number>): Array<Number> = definedExternally
        open fun getWorldAnchorB(result: Array<Number>): Array<Number> = definedExternally
        override fun applyForce(): Unit = definedExternally
    }
    interface `T$13` {
        var restAngle: Number? get() = definedExternally; set(value) = definedExternally
        var stiffness: Number? get() = definedExternally; set(value) = definedExternally
        var damping: Number? get() = definedExternally; set(value) = definedExternally
    }
    open class RotationalSpring(bodyA: Body, bodyB: Body, options: `T$13`? = definedExternally) : Spring {
        open var restAngle: Number = definedExternally
    }
    open class Capsule(length: Number? = definedExternally, radius: Number? = definedExternally) : Shape {
        open var length: Number = definedExternally
        open var radius: Number = definedExternally
    }
    open class Circle(radius: Number) : Shape {
        open var radius: Number = definedExternally
    }
    open class Convex(vertices: Array<Array<Number>>, axes: Array<Number>) : Shape {
        open var vertices: Array<Array<Number>> = definedExternally
        open var axes: Array<Number> = definedExternally
        open var centerOfMass: Array<Number> = definedExternally
        open var triangles: Array<Number> = definedExternally
        override var boundingRadius: Number = definedExternally
        open fun projectOntoLocalAxis(localAxis: Array<Number>, result: Array<Number>): Unit = definedExternally
        open fun projectOntoWorldAxis(localAxis: Array<Number>, shapeOffset: Array<Number>, shapeAngle: Number, result: Array<Number>): Unit = definedExternally
        open fun updateCenterOfMass(): Unit = definedExternally
        companion object {
            fun triangleArea(a: Array<Number>, b: Array<Number>, c: Array<Number>): Number = definedExternally
        }
    }
    interface `T$14` {
        var minValue: Number? get() = definedExternally; set(value) = definedExternally
        var maxValue: Number? get() = definedExternally; set(value) = definedExternally
        var elementWidth: Number
    }
    open class Heightfield(data: Array<Number>, options: `T$14`? = definedExternally) : Shape {
        open var data: Array<Number> = definedExternally
        open var maxValue: Number = definedExternally
        open var minValue: Number = definedExternally
        open var elementWidth: Number = definedExternally
    }
    open class Shape(){
        constructor(type: Number)
        open var type: Number = definedExternally
        open var id: Number = definedExternally
        open var boundingRadius: Number = definedExternally
        open var collisionGroup: Number = definedExternally
        open var collisionMask: Number = definedExternally
        open var material: Material = definedExternally
        open var area: Number = definedExternally
        open var sensor: Boolean = definedExternally
        open fun computeMomentOfInertia(mass: Number): Number = definedExternally
        open fun updateBoundingRadius(): Number = definedExternally
        open fun updateArea(): Unit = definedExternally
        open fun computeAABB(out: AABB, position: Array<Number>, angle: Number): Unit = definedExternally
        companion object {
            var idCounter: Number = definedExternally
            var CIRCLE: Number = definedExternally
            var PARTICLE: Number = definedExternally
            var PLANE: Number = definedExternally
            var CONVEX: Number = definedExternally
            var LINE: Number = definedExternally
            var RECTANGLE: Number = definedExternally
            var CAPSULE: Number = definedExternally
            var HEIGHTFIELD: Number = definedExternally
        }
    }
    open class Line(length: Number? = definedExternally) : Shape {
        open var length: Number = definedExternally
    }
    open class Particle : Shape
    open class Plane : Shape
    open class Rectangle(width: Number? = definedExternally, height: Number? = definedExternally) : Shape {
        open var width: Number = definedExternally
        open var height: Number = definedExternally
        companion object {
            fun sameDimensions(a: Rectangle, b: Rectangle): Boolean = definedExternally
        }
    }
    open class Solver(options: Any? = definedExternally, type: Number? = definedExternally) : EventEmitter {
        open var type: Number = definedExternally
        open var equations: Array<Equation> = definedExternally
        open var equationSortFunction: Equation = definedExternally
        open fun solve(dy: Number, world: World): Unit = definedExternally
        open fun solveIsland(dy: Number, island: Island): Unit = definedExternally
        open fun sortEquations(): Unit = definedExternally
        open fun addEquation(eq: Equation): Unit = definedExternally
        open fun addEquations(eqs: Array<Equation>): Unit = definedExternally
        open fun removeEquation(eq: Equation): Unit = definedExternally
        open fun removeAllEquations(): Unit = definedExternally
        companion object {
            var GS: Number = definedExternally
            var ISLAND: Number = definedExternally
        }
    }
    interface `T$15` {
        var iterations: Number? get() = definedExternally; set(value) = definedExternally
        var tolerance: Number? get() = definedExternally; set(value) = definedExternally
    }
    open class GSSolver(options: `T$15`? = definedExternally) : Solver {
        open var iterations: Number = definedExternally
        open var tolerance: Number = definedExternally
        open var useZeroRHS: Boolean = definedExternally
        open var frictionIterations: Number = definedExternally
        open var usedIterations: Number = definedExternally
        override fun solve(h: Number, world: World): Unit = definedExternally
    }
    open class OverlapKeeper(bodyA: Body, shapeA: Shape, bodyB: Body, shapeB: Shape) {
        open var shapeA: Shape = definedExternally
        open var shapeB: Shape = definedExternally
        open var bodyA: Body = definedExternally
        open var bodyB: Body = definedExternally
        open fun tick(): Unit = definedExternally
        open fun setOverlapping(bodyA: Body, shapeA: Shape, bodyB: Body, shapeB: Body): Unit = definedExternally
        open fun bodiesAreOverlapping(bodyA: Body, bodyB: Body): Boolean = definedExternally
        open fun set(bodyA: Body, shapeA: Shape, bodyB: Body, shapeB: Shape): Unit = definedExternally
    }
    open class TupleDictionary {
        open var data: Array<Number> = definedExternally
        open var keys: Array<Number> = definedExternally
        open fun getKey(id1: Number, id2: Number): String = definedExternally
        open fun getByKey(key: Number): Number = definedExternally
        open fun get(i: Number, j: Number): Number = definedExternally
        open fun set(i: Number, j: Number, value: Number): Number = definedExternally
        open fun reset(): Unit = definedExternally
        open fun copy(dict: TupleDictionary): Unit = definedExternally
    }
    open class Utils {
        companion object {
            fun <T> appendArray(a: Array<T>, b: Array<T>): Array<T> = definedExternally
            fun chanceRoll(chance: Number): Boolean = definedExternally
            fun defaults(options: Any, defaults: Any): Any = definedExternally
            fun extend(a: Any, b: Any): Unit = definedExternally
            fun randomChoice(choice1: Any, choice2: Any): Any = definedExternally
            fun rotateArray(matrix: Array<Any>, direction: Any): Array<Any> = definedExternally
            fun <T> splice(array: Array<T>, index: Number, howMany: Number): Unit = definedExternally
            fun <T> shuffle(array: Array<T>): Array<T> = definedExternally
            fun <T> transposeArray(array: Array<T>): Array<T> = definedExternally
        }
    }
    open class Island {
        open var equations: Array<Equation> = definedExternally
        open var bodies: Array<Body> = definedExternally
        open fun reset(): Unit = definedExternally
        open fun getBodies(result: Any): Array<Body> = definedExternally
        open fun wantsToSleep(): Boolean = definedExternally
        open fun sleep(): Boolean = definedExternally
    }
    open class IslandManager : Solver {
        override var equations: Array<Equation> = definedExternally
        open var islands: Array<Island> = definedExternally
        open var nodes: Array<IslandNode> = definedExternally
        open fun visit(node: IslandNode, bds: Array<Body>, eqs: Array<Equation>): Unit = definedExternally
        open fun bfs(root: IslandNode, bds: Array<Body>, eqs: Array<Equation>): Unit = definedExternally
        open fun split(world: World): Array<Island> = definedExternally
        companion object {
            fun getUnvisitedNode(nodes: Array<IslandNode>): IslandNode = definedExternally
        }
    }
    open class IslandNode(body: Body) {
        open var body: Body = definedExternally
        open var neighbors: Array<IslandNode> = definedExternally
        open var equations: Array<Equation> = definedExternally
        open var visited: Boolean = definedExternally
        open fun reset(): Unit = definedExternally
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
        var solver: Solver? get() = definedExternally; set(value) = definedExternally
        var gravity: Array<Number>? get() = definedExternally; set(value) = definedExternally
        var broadphase: Broadphase? get() = definedExternally; set(value) = definedExternally
        var islandSplit: Boolean? get() = definedExternally; set(value) = definedExternally
        var doProfiling: Boolean? get() = definedExternally; set(value) = definedExternally
    }
    interface `T$22` {
        var relaxation: Number? get() = definedExternally; set(value) = definedExternally
        var stiffness: Number? get() = definedExternally; set(value) = definedExternally
    }
    open class World(options: `T$21`? = definedExternally) : EventEmitter {
        open var postStepEvent: `T$10` = definedExternally
        open var addBodyEvent: `T$10` = definedExternally
        open var removeBodyEvent: `T$10` = definedExternally
        open var addSpringEvent: `T$10` = definedExternally
        open var impactEvent: `T$16` = definedExternally
        open var postBroadphaseEvent: `T$17` = definedExternally
        open var beginContactEvent: `T$18` = definedExternally
        open var endContactEvent: `T$19` = definedExternally
        open var preSolveEvent: `T$20` = definedExternally
        open var springs: Array<Spring> = definedExternally
        open var bodies: Array<Body> = definedExternally
        open var solver: Solver = definedExternally
        open var narrowphase: Narrowphase = definedExternally
        open var islandManager: IslandManager = definedExternally
        open var gravity: Array<Number> = definedExternally
        open var frictionGravity: Number = definedExternally
        open var useWorldGravityAsFrictionGravity: Boolean = definedExternally
        open var useFrictionGravityOnZeroGravity: Boolean = definedExternally
        open var doProfiling: Boolean = definedExternally
        open var lastStepTime: Number = definedExternally
        open var broadphase: Broadphase = definedExternally
        open var constraints: Array<Constraint> = definedExternally
        open var defaultMaterial: Material = definedExternally
        open var defaultContactMaterial: ContactMaterial = definedExternally
        open var lastTimeStep: Number = definedExternally
        open var applySpringForces: Boolean = definedExternally
        open var applyDamping: Boolean = definedExternally
        open var applyGravity: Boolean = definedExternally
        open var solveConstraints: Boolean = definedExternally
        open var contactMaterials: Array<ContactMaterial> = definedExternally
        open var time: Number = definedExternally
        open var stepping: Boolean = definedExternally
        open var islandSplit: Boolean = definedExternally
        open var emitImpactEvent: Boolean = definedExternally
        open var sleepMode: Number = definedExternally
        open fun addConstraint(c: Constraint): Unit = definedExternally
        open fun addContactMaterial(contactMaterial: ContactMaterial): Unit = definedExternally
        open fun removeContactMaterial(cm: ContactMaterial): Unit = definedExternally
        open fun getContactMaterial(materialA: Material, materialB: Material): ContactMaterial = definedExternally
        open fun removeConstraint(c: Constraint): Unit = definedExternally
        open fun step(dy: Number, timeSinceLastCalled: Number? = definedExternally, maxSubSteps: Number? = definedExternally): Unit = definedExternally
        open fun runNarrowphase(np: Narrowphase, bi: Body, si: Shape, xi: Array<Any>, ai: Number, bj: Body, sj: Shape, xj: Array<Any>, aj: Number, cm: Number, glen: Number): Unit = definedExternally
        open fun addSpring(s: Spring): Unit = definedExternally
        open fun removeSpring(s: Spring): Unit = definedExternally
        open fun addBody(body: Body): Unit = definedExternally
        open fun removeBody(body: Body): Unit = definedExternally
        open fun getBodyByID(id: Number): Body = definedExternally
        open fun disableBodyCollision(bodyA: Body, bodyB: Body): Unit = definedExternally
        open fun enableBodyCollision(bodyA: Body, bodyB: Body): Unit = definedExternally
        open fun clear(): Unit = definedExternally
        open fun clone(): World = definedExternally
        open fun hitTest(worldPoint: Array<Number>, bodies: Array<Body>, precision: Number): Array<Body> = definedExternally
        open fun setGlobalEquationParameters(parameters: `T$22`): Unit = definedExternally
        open fun setGlobalStiffness(stiffness: Number): Unit = definedExternally
        open fun setGlobalRelaxation(relaxation: Number): Unit = definedExternally
        companion object {
            var NO_SLEEPING: Number = definedExternally
            var BODY_SLEEPING: Number = definedExternally
            var ISLAND_SLEEPING: Number = definedExternally
            fun integrateBody(body: Body, dy: Number): Unit = definedExternally
        }
    }
}
