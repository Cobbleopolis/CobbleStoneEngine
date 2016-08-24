package com.cobble.engine.math

/**
  * A 3D Vector
  * @constructor Creates a [[Vec3f]]
  * @param x The x component of the vector
  * @param y The y component of the vector
  * @param z The z component of the vector
  */
case class Vec3f(x: Float, y: Float, z: Float) {

    /**
      * A 3D Vector
      * @constructor Creates a copy of a [[Vec3f]]
      * @param vec3f The [[Vec3f]] to copy from
      */
    def this(vec3f: Vec3f) = this(vec3f.x, vec3f.y, vec3f.z)

    /**
      * A 3D Vector
      * @constructor Creates a [[Vec3f]] with x, y, and z components of 0
      */
    def this() = this(0.0f, 0.0f, 0.0f)

    /** A 3D Vector
      * @constructor Creates a [[Vec3f]] with x, y, and z components of `xyz`
      * @param xyz The value that will be stored in the x, y, and z components
      */
    def this(xyz: Float) = this(xyz, xyz, xyz)

    /**
      * Adds two vectors
      * @param that
      * @return
      */
    def +(that: Vec3f): Vec3f = Vec3f(x)

}

object Vec3f {

    def apply(vec3f: Vec3f): Vec3f = new Vec3f(vec3f)

    def apply(): Vec3f = new Vec3f()

    def apply(xyz: Float): Vec3f = new Vec3f(xyz)

}
