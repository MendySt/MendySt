package tests.geometries;

import geometries.Sphere;
import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dan zilberstein
 */
public class SphereTest {

    Sphere sphere = new Sphere(1d, new Point3D(1, 0, 0));


  //  @Test
   // void getNormalTest1() {
   //     Sphere sp = new Sphere(1.0, new Point3D(0, 0, 1));
  //      assertNotEquals(new Vector(0,0,1),sp.getNormal(new Point3D(0,0,2)));
   //     assertEquals(new Vector(0,0,1),sp.getNormal(new Point3D(0,0,2)));
   // }

    @Test
    void getNormalTest2() {
        Sphere sp = new Sphere(1,new Point3D(0,0,1));
        assertNotEquals(new Vector(0,0,1),sp.getNormal(new Point3D(0,1,1)));
        System.out.println(sp.getNormal(new Point3D(0,1,1)));
    }

}