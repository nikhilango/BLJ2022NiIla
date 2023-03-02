package ch.noseryoung.blj;

import java.awt.*;

public interface Showable {

    void showShapes(Graphics g2d, CoordinateSystem cs, int fieldScale);
    default CSPoint translatePoint(Point point, CoordinateSystem cs, int fieldScale) {
        return new CSPoint(point.x * fieldScale + cs.getCoordinateSystemSize() * fieldScale / 2, cs.getCoordinateSystemSize() * fieldScale / 2 - point.y * fieldScale);
    }
}
