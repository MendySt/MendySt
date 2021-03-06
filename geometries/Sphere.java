package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public class Sphere extends RadialGeometry {

    Point3D _center;

    public Point3D get_center() {
        return new Point3D(_center);
    }

    public Sphere(double radius, Point3D point) {
        super(radius);
        _center = new Point3D(point);
    }

    public Sphere(RadialGeometry _radial, Point3D point3D) {
        super(_radial);
        _center = new Point3D(point3D);
    }

    @Override
    public Vector getNormal(Point3D point) {
        return point.subtract(_center).normalize();
    }
}
