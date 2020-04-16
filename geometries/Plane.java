package geometries;

import primitives.Point3D;
import primitives.*;
import java.util.List;
import java.util.Objects;

public class Plane implements Geometry {

    Point3D _point;
    Vector _normal;

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
         _point= new Point3D(p1);
         Vector U = p1.subtract(p2);
         Vector V = p1.subtract(p3);
         Vector N = U.crossProduct(V);
         N.normalize();
         _normal.scale(-1);
    }




    public Plane(Point3D point3D, Vector vector){
        _point= new Point3D(point3D);
        _normal = new Vector( vector.normalize());
        _normal.scale(-1);
    }

    @Override
    public Vector getNormal(Point3D point3D) {
        return _normal;
    }

    public Vector getNormal() {
        return _normal;
    }

    public Point3D get_point() {
        return _point;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "_point=" + _point +
                ", _normal=" + _normal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Objects.equals(_point, plane._point) &&
                Objects.equals(_normal, plane._normal);
    }


}
