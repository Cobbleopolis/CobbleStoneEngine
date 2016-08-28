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
      * Adds two [[Vec3f]]s
      * @param that The [[Vec3f]] to add
      * @return The sum of the two [[Vec3f]]s
      */
    def +(that: Vec3f): Vec3f = new Vec3f(x + that.x, y + that.y, z + that.z)

    /**
      * Subtracts two [[Vec3f]]s
      * @param that The [[Vec3f]] to subtract
      * @return The difference of the two [[Vec3f]]s
      */
    def -(that: Vec3f): Vec3f = new Vec3f(x - that.x, y - that.y, z - that.z)

    /**
      * Multiples a [[Vec3f]] by a float. Similar to scaling by `that`
      * @param that The factor to multiply by.
      * @return The product of the vector being multiplied by `that`
      */
    def *(that: Float): Vec3f = new Vec3f(x * that, y * that, z * that)

    /**
      * Divides a [[Vec3f]] by a float.
      * @param that The factor to divide by.
      * @return The quotient of the vector being divided by `that`
      */
    def /(that: Float): Vec3f = new Vec3f(x / that, y / that, z / that)

    /**
      * Calculates the dot product between two [[Vec3f]]s
      * @param that The other [[Vec3f]] in the operation
      * @return The dot product of the two vectors
      */
    def dot(that: Vec3f): Float = (x * that.x) + (y * that.y) + (z * that.z)

    /**
      * Calculates the cross product between two [[Vec3f]]s
      * @param that The other [[Vec3f]] in the operation
      * @return The cross product between the two [[Vec3f]]s
      */
    def cross(that: Vec3f): Float = ??? //TODO implement

    /**
      * Creates a string representation of a vector
      * @return The string representation of a vector
      */
    override def toString: String = s"<$x, $y, $z>"

    /**
      * Sets the components of the vector
      * @param x The new x component of the vector
      * @param y The new y component of the vector
      * @param z The new z component of the vector
      */
    def set(x: Float, y: Float, z: Float): Unit = {
        this.x = x
        this.y = y
        this.z = z
    }

    /**
      * Copies the components of `vec3f` into the current [[Vec3f]]
      * @param vec3f The [[Vec3f]] to copy the new components from
      */
    def set(vec3f: Vec3f): Unit = {
        this.x = vec3f.x
        this.y = vec3f.y
        this.z = vec3f.z
    }

    /**
      * Calculates the magnitude of the vector
      * @return The magnitude of the vector
      */
    def getMagnitude: Float = Math.sqrt(x * x + y * y + z * z).toFloat

}
