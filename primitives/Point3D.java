//mendy steinmetz 313329427
// issacar tsernovisky 205453855
package primitives;

import geometries.RadialGeometry;
import java.nio.charset.CoderResult;
import java.util.Objects;

/**
 *  the class Point3D contain 3 class of Coordinate and point 0,0,0 (zero point)
 *  he have the function add, subtract, distanceSquared and distance.
 */
public class Point3D {

    Coordinate x, y, z;
    public static final Point3D ZERO = new Point3D(0.0,0.0,0.0);

    /**
     * contractor for Point3D when i got 3 Coordinate
     * @param x to class Coordinate x
     * @param y to class Coordinate y
     * @param z to class Coordinate z
     */
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }
    /**
     * contractor for Point3D when i got 3 numbers and call to first contractor
     * @param x and put him in x
     * @param y and put him in y
     * @param z and put him in z
     *
     */
    public Point3D(double x, double y, double z) {
        this(new Coordinate(x), new Coordinate(y), new Coordinate(z));
    }

    /**
     * copy contractor
     * @param other is Point3D and call to get func and put them in new value
     */
    public Point3D(Point3D other) {
        x = new Coordinate(other.getX());
        y = new Coordinate(other.getY());
        z = new Coordinate(other.getZ());
    }

    /************************************   getter   *************/
    public Coordinate getX() {
        return new Coordinate(x);
    }

    public Coordinate getY() {
        return new Coordinate(y);
    }

    public Coordinate getZ() { return new Coordinate(z); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Point3D)) return false;
        Point3D point3D = (Point3D) obj;
        return this.getX().equals(point3D.x) &&
                this.getY().equals((point3D).y) &&
                this.getZ().equals((point3D.z));
    }




    /**
     *
     *
     * @param vertex get Point3D and subtract them to point the i have
     * @return new Vector
     */
    public Vector subtract(Point3D vertex) {
        return new Vector(x.get()- vertex.getX().get(),y.get()- vertex.getY().get(),z.get()- vertex.getZ().get());
    }

    /**
     * @param vector get Vector and add to 3 coordinate value of Point3D
     * @return new Point3D
     */
    public Point3D add(Vector vector) {
        Point3D temp = vector.getHead();
        return new Point3D(x.get()+ temp.getX().get(),y.get()+ temp.getY().get(),z.get()+ temp.getZ().get());
    }

    /**
     * @param temp get Point3D and take the coordinate and double them with itself
     * @return double
     */
    public double distanceSquared(Point3D temp){
        return
            (x.get()-temp.getX().get() * x.get()-temp.getX().get())
            +(y.get()-temp.getY().get() * y.get()-temp.getY().get())
            + (z.get()-temp.getZ().get() * z.get()-temp.getZ().get());
    }

    /**
     *
     * @param temp get Point3D and take the coordinate and add them to number
     * @return double
     */
    public double distance(Point3D temp){
        return  Math.sqrt(distanceSquared(temp));
    }
}
