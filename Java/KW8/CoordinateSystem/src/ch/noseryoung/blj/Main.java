package ch.noseryoung.blj;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int CoordinateSystemSize = 500;
        ArrayList<CSPoint> AllPoints = new ArrayList<>();

        if (CoordinateSystemSize % 20 == 0 && CoordinateSystemSize > 0){
            CSPoint point1 = new CSPoint(100,200);
            CSPoint point2 = new CSPoint(500,60);
            CSPoint point3 = new CSPoint(10,100);
            CSPoint point4 = new CSPoint(-10,50);
            AllPoints.add(point1);
            AllPoints.add(point2);
            AllPoints.add(point3);
            AllPoints.add(point4);
            CoordinateSystem cs = new CoordinateSystem(CoordinateSystemSize, AllPoints);
            new CSRenderer(cs, 1, 10);
        }
        else  {
            throw new IllegalArgumentException();
        }

    }
}