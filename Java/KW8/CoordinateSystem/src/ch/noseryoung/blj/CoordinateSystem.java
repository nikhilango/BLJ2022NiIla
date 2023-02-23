package ch.noseryoung.blj;

import java.util.ArrayList;

public class CoordinateSystem {
    private int CoordinateSystemSize;

    private ArrayList AllPoints;

    public CoordinateSystem(int CoordinateSystemSize, ArrayList AllPoints){
        this.AllPoints = AllPoints;
        this.CoordinateSystemSize = CoordinateSystemSize;
    }

    public int getCoordinateSystemSize() {
        return CoordinateSystemSize;
    }

    public ArrayList<CSPoint> getAllPoints() {
        return AllPoints;
    }
}
