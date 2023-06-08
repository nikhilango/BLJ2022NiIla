package ch.noseryoung.test;

import ch.noseryoung.main.ShapeSideCreator;
import ch.noseryoung.main.Triangle;
import ch.noseryoung.main.TriangleManager;
import ch.noseryoung.main.TriangleValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleValidatorTest {
    Triangle t;
    TriangleValidator tv;

    TriangleManager tm;

    ShapeSideCreator generator;
    @BeforeEach
    public void setup() {
        t = new Triangle(3, 4, 5);
        tv = new TriangleValidator();

        generator = new ShapeSideCreator() {
            @Override
            public double createSide() {
                return 0;
            }
        };

        tm = new TriangleManager(generator);
    }

    @Test
    public void isEquilateralTest(){
        boolean result = tv.isEquilateral(t);
        assertTrue(result);
    }
    @Test
    public void isIsosceles(){
        boolean result = tv.isIsosceles(t);
        assertTrue(result);
    }

    @Test
    public void isScalene(){
        boolean result = tv.isScalene(t);
        assertTrue(result);
    }

    @Test
    public void shortestSide(){
        double result = tm.getShortestSide(t);
        double expected = 3.0;

        assertEquals(expected, result);
    }

    @Test
    public void longestSide(){
        double result = tm.getLongestSide(t);
        double expected = 5.0;

        assertEquals(expected, result);
    }
}
