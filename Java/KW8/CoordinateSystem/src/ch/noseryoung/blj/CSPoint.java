package ch.noseryoung.blj;
import java.awt.*;

public class CSPoint extends Point implements Showable{
    private int id;
    private static int IdCounter = 0;
    public CSPoint(int x, int y) {
        super(x, y);
        IdCounter++;
        id = IdCounter;
    }
    @Override
    public String toString(){
        return "CSPoint [id=" + id + ", x=" + x + ", y=" + y + "]";
    }

    @Override
    public void showShapes(Graphics g2d, CoordinateSystem cs, int fieldScale) {
        CSPoint translatedPoint = translatePoint(this, cs, fieldScale);
        g2d.setColor(Color.BLUE);
        g2d.drawLine(translatedPoint.x, translatedPoint.y, translatedPoint.x, translatedPoint.y);
    }
}
