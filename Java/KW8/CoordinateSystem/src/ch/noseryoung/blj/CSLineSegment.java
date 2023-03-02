package ch.noseryoung.blj;

import java.awt.*;
import java.util.ArrayList;

public class CSLineSegment implements Showable{
    private int CoordinateSystemSize;
    private CSPoint startPoint;
    private CSPoint endPoint;
    private ArrayList AllLines;

    public CSLineSegment(CSPoint startPoint, CSPoint endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    public CSPoint getStartPoint() {
        return startPoint;
    }
    public CSPoint getEndPoint() {
        return endPoint;
    }

    @Override
    public void showShapes(Graphics g2d, CoordinateSystem cs, int fieldScale) {
        CSPoint translatedPoint = translatePoint(endPoint, cs, fieldScale);
        CSPoint translatedPoint2 = translatePoint(startPoint, cs, fieldScale);
        g2d.setColor(Color.BLUE);
    g2d.drawLine(translatedPoint2.x + 69, translatedPoint2.y -67, translatedPoint.x + 23, translatedPoint.y - 31);
    }
}
