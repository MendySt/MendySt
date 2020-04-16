
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
        this.head = new Point3D(head.x._coord, head.y._coord, head.z._coord);
    }

    /**
     * constructor of input 3 coordinates
     * @param _x
     * @param _y
     * @param _z
     */
    public Vector(Coordinate _x, Coordinate _y, Coordinate _z) {
        this.head.x = new Coordinate(_x);
        this.head.y = new Coordinate(_y);
        this.head.z = new Coordinate(_z);
    }

    /**
     * copy constructor
     * @param v
     */
    public Vector(Vector v) {
        this(v.head);
    }

    /**
     *
     * @param pointA
     * @param pointB
     */
    public Vector (Point3D pointA, Point3D pointB){
        this(pointA.subtract(pointB));
    }

    /**
     * constructor of input 3 doubles for return vector
     * @param x
     * @param y
     * @param z
     */
    public Vector(double x, double y, double z) {
        this(new Point3D(x, y, z));
    }
    /********************************* getter **********************/
    public Point3D getHead() {
        return new Point3D(head);
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
     *0
     * @param
     * @return new vector
     */
    public Vector add(Vector v) {
        return new Vector(new Point3D(
                v.head.getX()._coord + this.head.getX()._coord,
                v.head.getY()._coord + this.head.getY()._coord,
                v.head.getZ()._coord + this.head.getZ()._coord));
    }

    /**
     *0
     * @param a multiplication of a
     * @return new vector
     */
    public Vector scale(double a) {
        return new Vector(new Point3D(
                        new Coordinate(a*head.x._coord),
                        new Coordinate(a*head.y._coord),
                        new Coordinate(a*head.z._coord)));
    }

    /**
     *0
     * @param
     * @return double number
     */
    public double dotProduct(Vector v3) {
        return (this.head.getX()._coord * v3.head.getX()._coord +
                this.head.getY()._coord * v3.head.getY()._coord +
                this.head.getZ()._coord * v3.head.getZ()._coord);
    }

    /**
     *0
     * @param
     * @return new vector
     */
    public Vector crossProduct(Vector edge2) {
        return new Vector(new Point3D(
                this.head.getY()._coord * edge2.head.getZ()._coord - this.head.getZ()._coord * edge2.head.getY()._coord,
                this.head.getZ()._coord * edge2.head.getX()._coord - this.head.getX()._coord * edge2.head.getZ()._coord,
                this.head.getX()._coord * edge2.head.getY()._coord - this.head.getY()._coord * edge2.head.getX()._coord));
    }

    /**
     * 0
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
     * 0
     * normalise vector action
     * @return this vector after change
     */
    public Vector normalize() {
        double x = this.head.x._coord;
        double y = this.head.y._coord;
        double z = this.head.z._coord;
        double length = this.length();

        if (length == 0)
            throw new ArithmeticException("divide  by zero");

        this.head.x= new Coordinate((x/length));
        this.head.y= new Coordinate((y/length));
        this.head.z= new Coordinate((z/length));

        return this;
    }

    /**
     *  normalise vector action
     * @return new vector
     */
    public Vector normalized() {
        Vector v = new Vector(this);
        return v.normalize();
    }

}