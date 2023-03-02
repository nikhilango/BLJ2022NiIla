package ch.noseryoung.blj;

import java.util.ArrayList;

public class CoordinateSystem {
    private int CoordinateSystemSize;

    private ArrayList Shapes;

    public CoordinateSystem(int CoordinateSystemSize, ArrayList Shapes){
        this.Shapes = Shapes;
        this.CoordinateSystemSize = CoordinateSystemSize;
    }

    public int getCoordinateSystemSize() {
        return CoordinateSystemSize;
    }

    public ArrayList<CSPoint> getShapes() {
        return Shapes;
    }
}
