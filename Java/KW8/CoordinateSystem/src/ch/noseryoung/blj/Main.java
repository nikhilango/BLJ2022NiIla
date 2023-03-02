package ch.noseryoung.blj;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int CoordinateSystemSize = 500;

        ArrayList<Showable> Shapes = new ArrayList<>();
        if (CoordinateSystemSize % 20 == 0 && CoordinateSystemSize > 0){
            CSPoint point1 = new CSPoint(40,70);
            CSPoint point2 = new CSPoint(-20, -202);
            CSPoint point3 = new CSPoint(50, -69);
            CSPoint point4 = new CSPoint(-60, 55);
            Shapes.add(point1);
            Shapes.add(point2);
            Shapes.add(point3);
            Shapes.add(point4);

            CSLineSegment line1 = new CSLineSegment(point1, point2);
            CSLineSegment line2 = new CSLineSegment(point3, point4);
            Shapes.add(line1);
            Shapes.add(line2);

            CSTriangle tri1 = new CSTriangle(point1, point2);
            CSTriangle tri2 = new CSTriangle(point3, point1);
            CSTriangle tri3 = new CSTriangle(point2, point3);
            Shapes.add(tri1);
            Shapes.add(tri2);
            Shapes.add(tri3);
            CoordinateSystem cs = new CoordinateSystem(CoordinateSystemSize, Shapes);
            new CSRenderer(cs, 1, 10);
        }
        else  {
            throw new IllegalArgumentException();
        }

    }
}