package com.cobble.engine.math

/**
  * A 3D Vector
  * @constructor Creates a [[Vec3f]]
  * @param x The x component of the vector
  * @param y The y component of the vector
  * @param z The z component of the vector
  */
class Vec3f(var x: Float, var y: Float, var z: Float) {

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
      * @param that The [[Vec3f]] to add
      * @return The sum of the two [[Vec3f]]s
      */
    def +(that: Vec3f): Vec3f = new Vec3f(x)

}
