package geometries;

import primitives.Ray;

import java.util.Objects;

public class Cylinder extends Tube{
    private double _height;

    public double get_height() {
        return _height;
    }

    public Cylinder(double radius, Ray axisRay, double height) {
        super(radius, axisRay);
        _height = height;
    }

    public Cylinder(RadialGeometry _radial, Ray axisRay, double height) {
        super(_radial, axisRay);
        _height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cylinder)) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(cylinder.get_height(), get_height()) == 0;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "_height=" + _height +
                ", _axisRay=" + _axisRay +
                ", _radius=" + _radius +
                '}';
    }
}
