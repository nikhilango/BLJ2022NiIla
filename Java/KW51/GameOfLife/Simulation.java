import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;

/**
 * This class is responsible for handling and running a simulation of Conway's
 * Game of Life.
 *
 * @author surber
 *
 */
public class Simulation extends Thread {
    private int speed;
    private boolean wrapField = true;
    private int[][] field;

    private PropertyChangeSupport pCS;
    private volatile boolean running;

    /**
     * A constructor.
     *
     * @param speed     An int value that controls the speed of the simulation.
     *                  Lower value equals faster simulation speed.
     * @param wrapField A boolean value that toggles whether the simulation field is
     *                  finite in size or wraps around itself.
     */
    public Simulation(int speed, boolean wrapField) {
        this.speed = speed;
        this.wrapField = wrapField;

        pCS = new PropertyChangeSupport(this);
        running = true;
    }

    /**
     * A constructor.
     *
     * @param speed     An int value that controls the speed of the simulation.
     *                  Lower value equals faster simulation speed.
     * @param wrapField A boolean value that toggles whether the simulation field is
     *                  finite in size or wraps around itself.
     * @param field     A 2D integer array that represents the simulation state.
     */
    public Simulation(int speed, boolean wrapField, int[][] field) {
        this(speed, wrapField);
        this.field = field;
    }

    /**
     * This method is inherited from {@link Thread} and should be called using the
     * start() method.
     */
    @Override
    public void run() {
        timeoutStart(100);
        startSimulation();
    }

    /**
     * This method is used to halt the simulation. As of this version, the
     * simulation cannot be restarted after it has been stopped.
     */
    public void stopSimulation() {
        running = false;
    }

    /**
     * This method is used for running the simulation.
     */
    private void startSimulation() {
        while (running) {

            /*
             * Changes from the current to the next generation get written into a new array,
             * instead of directly overwriting the old one. Why ist that?
             */
            int[][] newField = new int[field.length][field[0].length];
            for (int i = 1; i < field.length - 1; i++){
                for (int j = 1; j < field[0].length - 1; j++){
                    if (i == 1 && j == 1 || i == field.length - 1 && j == field.length - 1 || i == 1 && j == field.length - 1 || i == field.length - 1 && j == 1){
                        int wrappedNeighbourCount = getWrappedNeighbourCount(i, j);
                        if (field[i][j] == 1) {
                            if (wrappedNeighbourCount == 3 || wrappedNeighbourCount == 2) {
                                newField[i][j] = 1;
                            }
                            else {
                                newField[i][j] = 0;
                            }
                        }
                        else {
                            if (wrappedNeighbourCount == 3) {
                                newField[i][j] = 1;
                            }
                            else {
                                newField[i][j] = 0;
                            }
                        }
                    }
                    else {
                        int neighbourCount = getNeighbourCount(i, j);
                        if (field[i][j] == 1) {
                            if (neighbourCount == 3 || neighbourCount == 2) {
                                newField[i][j] = 1;
                            }
                            else {
                                newField[i][j] = 0;
                            }
                        }
                        else {
                            if (neighbourCount == 3) {
                                newField[i][j] = 1;
                            }
                            else {
                                newField[i][j] = 0;
                            }
                        }
                    }
                }
            }

            /*
             * TODO: Implement the main logic used for running the simulation. Make sure to
             * not implement everything here, but instead use the methods below (also to be
             * implemented). It might be a good start to traverse the entire simulation
             * field, which allows you to look at the values contained in each cell.
             */

            /*
             * TODO: Stop the simulation if the current and next generation are the same. In
             * order to do that, call the method stopSimulation() under the right
             * circumstances.
             */

            if(Arrays.deepEquals(field, newField)){
                stopSimulation();
            }
            pCS.firePropertyChange("field", field, newField);
            field = newField;
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {}
        }
    }

    /**
     * This helper method is used to get the number of neighbours, based on the
     * provided coordinates of a cell. See the following example as to what counts
     * as neighbour (N) of a cell (C): <br>
     * N|N|N <br>
     * -+-+- <br>
     * N|C|N <br>
     * -+-+- <br>
     * N|N|N <br>
     *
     * @param x The x-coordinate of a cell.
     * @param y The y-coordinate of a cell.
     * @return An int value representing the number of neighbours of a cell.
     */
    private int getNeighbourCount(int x, int y) {
        int neighbourCount = 0;
        //below
        if(field[x + 1][y] == 1){
            neighbourCount++;
        }

        //above
        if(field[x - 1][y] == 1){
            neighbourCount++;
        }

        //right
        if(field[x][y + 1] == 1){
            neighbourCount++;
        }
        //left
        if(field[x][y - 1] == 1){
            neighbourCount++;
        }
        //top left
        if(field[x - 1][y - 1] == 1){
            neighbourCount++;
        }
        //bottom right
        if(field[x + 1][y + 1] == 1){
            neighbourCount++;
        }
        //bottom left
        if(field[x + 1][y - 1] == 1){
            neighbourCount++;
        }
        //top right
        if(field[x - 1][y + 1] == 1){
            neighbourCount++;
        }

        /*
         * TODO: Implement logic that counts the neighbours of a given cell. Neighbours
         * are up to 8 living cells next to the cell in question, according to the
         * comment above.
         */

        return neighbourCount;
    }

    /**
     * This helper method is used to check whether the coordinates of a cell are
     * valid i.e. the coordinates are in bounds of the simulation field.
     *
     * @param x The x-coordinate of a cell to check.
     * @param y The y-coordinate of a cell to check.
     * @return A boolean value representing the fact whether a cell's coordinates
     *         are valid or not.
     */
    private boolean coordsInBounds(int x, int y) {
        if (x < 0){
            return false;
        }
        else if (x > field.length){
            return false;
        }
        else if (y < 0) {
            return false;
        }
        else if (y > field.length) {
            return false;
        }
        else {
            return true;
        }
        /*
         * TODO: Implement logic that checks if the given coordinates are in bounds,
         * i.e. neither the x or y coordinate is negative or greater than the width or
         * height of the simulation field.
         */
    }

    /**
     * This helper method is used to count additional neighbours in the case of a
     * wrapped simulation field. It is only relevant for cells that are positioned
     * on the edges (including corners) of the simulation field.
     *
     * @param x The x-coordinate of a cell.
     * @param y The y-coordinate of a cell.
     * @return An int value representing the number of wrapped neighbours of a cell.
     */
    private int getWrappedNeighbourCount(int x, int y) {
        int wrappedNeighbourCount = 0;
        //top left
        if (x == 0 && y == 0){
            //bottom right
            if(field[x + 1][y + 1] == 1){
                wrappedNeighbourCount++;
            }
            //right
            else if(field[x][y + 1] == 1){
                wrappedNeighbourCount++;
            }
            //below
            if(field[x + 1][y] == 1){
                wrappedNeighbourCount++;
            }
        }
        //bottom right
        else if (x == field.length && y == field.length) {
            //top left
            if(field[x - 1][y - 1] == 1){
                wrappedNeighbourCount++;
            }
            //left
            else if(field[x][y - 1] == 1){
                wrappedNeighbourCount++;
            }
            //above
            else if(field[x - 1][y] == 1){
                wrappedNeighbourCount++;
            }
        }
        //top right
        else if (x == 0 && y == field.length) {
            //bottom left
            if(field[x + 1][y - 1] == 1){
                wrappedNeighbourCount++;
            }
            //left
            else if(field[x][y - 1] == 1){
                wrappedNeighbourCount++;
            }
            //below
            if(field[x + 1][y] == 1){
                wrappedNeighbourCount++;
            }
        }
        //bottom left
        else if (x == field.length && y == 0) {
            //top right
            if(field[x - 1][y + 1] == 1){
                wrappedNeighbourCount++;
            }
            //right
            else if(field[x][y + 1] == 1){
                wrappedNeighbourCount++;
            }
            //above
            else if(field[x - 1][y] == 1){
                wrappedNeighbourCount++;
            }
        }
        /*
         * TODO: INTERMEDIATE TASK - The simulation field is limited in size and has a
         * border. Having the simulation field wrap around itself means that something
         * can disappear at the right border and reappear on the left. Same for top and
         * bottom and in all directions.
         */

        return wrappedNeighbourCount;
    }

    /**
     * This helper method is used to prolong the initial state of the simulation
     * before continuing with the given simulation speed.
     *
     * @param timeout The amount of time (in milliseconds) to hold the initial
     *                simulation state.
     */
    private void timeoutStart(int timeout) {
        pCS.firePropertyChange("field", null, field);
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {}
    }

    /**
     * This method is used to add a {@link PropertyChangeListener} to the
     * {@link PropertyChangeSupport} object of this class.
     *
     * @param pCL The PropertyChangeListener object to add.
     */
    public void addListener(PropertyChangeListener pCL) {
        pCS.addPropertyChangeListener(pCL);
    }

    public int getFieldWidth() {
        return field[0].length;
    }

    public int getFieldHeight() {
        return field.length;
    }
}