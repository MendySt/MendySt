
package primitives;

public class Vector {
    Point3D head;

//    public final static Vector zero = new Vector( new Point3D(0.0,0.0,0.0));

    /**
     * @param head constructor input head
     */
    public Vector(Point3D head) {
        if (head.equals(Point3D.ZERO))
            throw new IllegalArgumentException("Illegal input");
        this.head = head;
    }

    /**
     * constructor of input 3 coordinates
     * @param _x
     * @param _y
     * @param _z
     */
    public Vector(Coordinate _x, Coordinate _y, Coordinate _z) {
        this.head.x = _x;
        this.head.y = _y;
        this.head.z = _z;
    }

    /**
     * copy constructor
     * @param v
     */
    public Vector(Vector v) {
        head= new Point3D(v.getHead());
    }

    /**
     * constructor of input 3 doubles for return vector
     * @param x
     * @param y
     * @param z
     */
    public Vector(double x, double y, double z) {
        if (head.equals(Point3D.ZERO))
            throw new IllegalArgumentException("Illegal input");
        this.head = new Point3D(x, y, z);
    }
    /********************************* getter **********************/
    public Point3D getHead() {
        return head;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Vector)) return false;
        Vector vector = (Vector) o;
        return head.equals(vector.head);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "head=" + head +
                '}';
    }

    /**
     * subtract between 2 vectors
     * @param v the second vector
     * @return new vector
     */
    public Vector subtract(Vector v) {
        return new Vector(new Point3D(
                v.head.getX()._coord - this.head.getX()._coord,
                v.head.getY()._coord - this.head.getY()._coord,
                v.head.getZ()._coord - this.head.getZ()._coord));
    }

    /**
     *
     * @param action add between 2 vectors
     * @return new vector
     */
    public Vector add(Vector v) {
        return new Vector(new Point3D(
                v.head.getX()._coord + this.head.getX()._coord,
                v.head.getY()._coord + this.head.getY()._coord,
                v.head.getZ()._coord + this.head.getZ()._coord));
    }

    /**
     *
     * @param a multiplication of a
     * @return new vector
     */
    public Vector scale(int a) {
        return new Vector(new Point3D(
                this.head.getX()._coord * a,
                this.head.getY()._coord * a,
                this.head.getZ()._coord * a));
    }

    /**
     *
     * @param dot product action between this of v3
     * @return double number
     */
    public double dotProduct(Vector v3) {
        return (this.head.getX()._coord * v3.head.getX()._coord +
                this.head.getY()._coord * v3.head.getY()._coord +
                this.head.getZ()._coord * v3.head.getZ()._coord);
    }

    /**
     *
     * @param crossProduct action between this of edge2
     * @return new vector
     */
    public Vector crossProduct(Vector edge2) {
        return new Vector(new Point3D(
                this.head.getY()._coord * edge2.head.getZ()._coord - this.head.getZ()._coord * edge2.head.getY()._coord,
                this.head.getZ()._coord * edge2.head.getX()._coord - this.head.getX()._coord * edge2.head.getZ()._coord,
                this.head.getX()._coord * edge2.head.getY()._coord - this.head.getY()._coord * edge2.head.getX()._coord));
    }

    /**
     * length of vector in pow
     * @return double number of distance in pow
     */
    public double lengthSquared() {
        return Point3D.ZERO.distanceSquared(this.getHead());
    }

    /**
     * length of vector
     * @return double number of distance
     */
    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    /**
     * normalise vector action
     * @return this vector after change
     */
    public Vector normalize() {
        Vector v=new Vector(new Point3D(
                this.head.x._coord/this.length()
                ,this.head.y._coord/this.length()
                ,this.head.z._coord/this.length()));
        this.head=v.getHead();
        return  this;
    }

    /**
     *  normalise vector action
     * @return new vector
     */
    public Vector normalized() {
        Vector v = new Vector(this.head);
        return v.normalize();
    }

}