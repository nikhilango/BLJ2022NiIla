import java.util.ArrayList;

public class Game {

    private int[][] gameField;

    private Timer timer = new Timer();
    private int previousField = 0;
    private int playerY;
    private int playerX;
    private boolean isGoal(int x, int y){
        for (int i = 0; i < goals.size(); i++) {
            Goal goal = goals.get(i);
            if (goal.x == x && goal.y == y) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Goal> goals = new ArrayList<>();

    public class Goal{
        int x;
        int y;

        public Goal(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public Game() {
        gameField = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 1, 4, 2, 3, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 3, 4, 1, 0, 0},
                {0, 1, 4, 1, 1, 3, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 4, 0, 1, 1, 0},
                {0, 1, 3, 0, 3, 3, 3, 4, 1, 0},
                {0, 1, 0, 0, 0, 4, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        for (int y = 0; y < getColCount(); y++) {
            for (int x = 0; x < getRowCount(); x++) {
                if (gameField[y][x] == 2) {
                    playerY = y;
                    playerX = x;
                }
                else if (gameField[y][x] == 4 || y == 7 && x == 4) {
                    goals.add(new Goal(x, y));
                }
            }
        }
    }

    public void moveUp() {
        if (isWall("up", "player")) {
            if (gameField[playerY - 1][playerX] == 3) {
                if (playerY - 2 < getColCount() && gameField[playerY - 2][playerX] != 1 && gameField[playerY - 2][playerX] != 3) {
                    gameField[playerY - 2][playerX] = 3;
                } else {
                    return;
                }
            }
            if (isGoal(playerX, playerY)){
                gameField[playerY][playerX] = 4;
            }
            else {
                gameField[playerY][playerX] = 0;
            }
            gameField[playerY - 1][playerX] = 2;
            playerY -= 1;

        }
        checkIfWon();
        checkIfLost();
    }

    public void moveDown() {
        if (isWall("down", "player")) {
            if (gameField[playerY + 1][playerX] == 3) {
                if (playerY + 2 < getColCount() && gameField[playerY + 2][playerX] != 1 && gameField[playerY + 2][playerX] != 3) {
                    //move the player also
                    gameField[playerY + 2][playerX] = 3;
                } else {
                    return;
                }
            }
            if (isGoal(playerX, playerY)){
                gameField[playerY][playerX] = 4;
            }
            else {
                gameField[playerY][playerX] = 0;
            }
            gameField[playerY + 1][playerX] = 2;
            playerY += 1;
        }
        checkIfWon();
        checkIfLost();
    }

    public void moveLeft() {
        if (isWall("left", "player")) {
            if (gameField[playerY][playerX - 1] == 3) {
                if (playerX - 2 >= 0 && gameField[playerY][playerX - 2] != 1 && gameField[playerY][playerX - 2] != 3) {
                    gameField[playerY][playerX - 2] = 3;
                } else {
                    return;
                }
            }
            if (isGoal(playerX, playerY)){
                gameField[playerY][playerX] = 4;
            }
            else {
                gameField[playerY][playerX] = 0;
            }
            gameField[playerY][playerX - 1] = 2;
            playerX -= 1;
        }
        checkIfWon();
        checkIfLost();
    }

    public void moveRight() {
        if (isWall("right", "player")) {
            if (gameField[playerY][playerX + 1] == 3) {
                if (playerX + 2 < getRowCount() && gameField[playerY][playerX + 2] != 1 && gameField[playerY][playerX + 2] != 3) {
                    gameField[playerY][playerX + 2] = 3;
                } else {
                    return;
                }
            }
            if (isGoal(playerX, playerY)){
                gameField[playerY][playerX] = 4;
            }
            else {
                gameField[playerY][playerX] = 0;
            }
            gameField[playerY][playerX + 1] = 2;
            playerX += 1;
        }
        checkIfWon();
        checkIfLost();
    }


    public void escAction() {
        System.out.println("ESC");
    }

    public int[][] getField() {
        return gameField;
    }

    public int getColCount() {
        return gameField.length;
    }

    public int getRowCount() {
        return gameField[0].length;
    }

    public boolean isWall(String direction, String type) {
        int box = 1;
        if (type.equals("player")) {
            box = 0;
        } else if (type.equals("box2")) {
            box = 2;
        }
        switch (direction) {
            case "up":
                if (gameField[playerY - 1 - box][playerX] == 1) {
                    return false;
                } else {
                    return true;
                }
            case "down":
                if (gameField[playerY + 1 + box][playerX] == 1) {
                    return false;
                } else {
                    return true;
                }
            case "right":
                if (gameField[playerY][playerX + 1 + box] == 1) {
                    return false;
                } else {
                    return true;
                }
            case "left":
                if (gameField[playerY][playerX - 1 - box] == 1) {
                    return false;
                } else {
                    return true;
                }
            default:
                return true;
        }
    }
    public void checkIfWon() {
        int counter = 0;
        for (int i = 0; i < goals.size(); i++) {
            Goal goal = goals.get(i);
            int goalX = goal.x;
            int goalY = goal.y;

            if (gameField[goalY][goalX] == 3){
                counter++;
            }

            if (counter == 7){
                System.out.println("YOU WON MY MANNN!!!");
                System.exit(0);
            }
        }
    }
    public void checkIfLost(){
        int boxXPos = 0;
        int boxYPos = 0;
        for (int y = 0; y < getColCount(); y++) {
            for (int x = 0; x < getRowCount(); x++) {
                if (gameField[y][x] == 3 && !isGoal(x, y)){
                    boxXPos = x;
                    boxYPos = y;
                    if (gameField[boxYPos + 1][boxXPos] == 1 && gameField[boxYPos][boxXPos - 1] == 1){
                        System.out.println("YOU LOST!!");
                        System.exit(0);
                    }
                    else if(gameField[boxYPos][boxXPos - 1] == 1 && gameField[boxYPos - 1][boxXPos] == 1){
                        System.out.println("YOU LOST!!");
                        System.exit(0);
                    }
                    else if(gameField[boxYPos - 1][boxXPos] == 1 && gameField[boxYPos][boxXPos + 1] == 1){
                        System.out.println("YOU LOST!!");
                        System.exit(0);
                    }
                    else if(gameField[boxYPos][boxXPos + 1] == 1 && gameField[boxYPos + 1][boxXPos] == 1){
                        System.out.println("YOU LOST!!");
                        System.exit(0);
                    }
                }
            }
        }
    }
}
