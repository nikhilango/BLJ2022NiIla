package ch.noseryoung.blj;
import java.awt.*;

public class CSPoint extends Point {
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
}
