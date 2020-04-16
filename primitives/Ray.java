package primitives;

import java.util.Objects;

public class Ray {

    private Vector _direction;
    private Point3D _poo;

    public Ray(Point3D p, Vector v){
        v.normalize();
        _direction = new Vector(v);
        _poo = new Point3D(p);
    }

    public Ray(Ray r) {
        _direction = new Vector(r._direction);
        _poo = new Point3D(r._poo);
    }

    public Vector get_direction() {
        return _direction;
    }

    public Point3D get_poo() {
        return _poo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ray)) return false;
        Ray ray = (Ray) o;
        return Objects.equals(get_direction(), ray.get_direction()) &&
                Objects.equals(get_poo(), ray.get_poo());
    }

    @Override
    public String toString() {
        return "Ray{" +
                "_direction=" + _direction +
                ", _poo=" + _poo +
                '}';
    }
}
