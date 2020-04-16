package geometries;
import java.util.Objects;
import static primitives.Util.isZero;

public abstract class  RadialGeometry implements Geometry {
    double _radius;

    /**
     * default constructor
     * @param radius
     */

    RadialGeometry(double radius) {
        if (isZero(_radius) || (_radius < 0.0))
            throw new IllegalArgumentException("radius "+ _radius +" is not valid");
        this._radius = radius;
    }

    /**
     * copy constructor
     * @param other
     */
    RadialGeometry(RadialGeometry other) {
        this._radius = other.get_radius();
    }


    /**********************************   getter      ****************/
    public double get_radius() {
        return _radius;
    }

}

