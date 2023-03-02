package ch.noseryoung.blj;

import java.awt.*;
import java.util.ArrayList;

public class CSTriangle implements Showable{
    private int CoordinateSystemSize;
    private CSPoint point1;
    private CSPoint point2;
    private CSPoint point3;

    public CSTriangle(CSPoint point1, CSPoint point2){
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public void showShapes(Graphics g2d, CoordinateSystem cs, int fieldScale) {
        CSPoint translatedPoint = translatePoint(point1, cs, fieldScale);
        CSPoint translatedPoint2 = translatePoint(point2, cs, fieldScale);
        g2d.setColor(Color.BLUE);
        g2d.drawLine(translatedPoint2.x, translatedPoint2.y, translatedPoint.x, translatedPoint.y);
    }
}
