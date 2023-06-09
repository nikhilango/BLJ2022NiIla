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
                /*0 */{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                /*1 */{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                /*2 */{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                /*3 */{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 3, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                /*4 */{0, 0, 0, 0, 0, 0, 1, 0, 3, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                /*5 */{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                /*6 */{0, 0, 0, 0, 0, 0, 1, 0, 1, 3, 3, 0, 3, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                /*7 */{0, 0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 3, 0, 1, 1, 1, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                /*8 */{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                /*9 */{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 3, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                /*10*/{0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                /*11*/{0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0},
                /*12*/{0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                /*13*/{1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 3, 0, 3, 1, 0, 3, 0, 1, 0, 0, 0, 4, 4, 4, 4, 4, 1},
                /*14*/{1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 4, 4, 4, 4, 4, 1},
                /*15*/{1, 0, 3, 3, 3, 3, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0, 0, 0, 1, 4, 1, 1, 4, 1},
                /*16*/{1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 1},
                /*17*/{0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 4, 4, 4, 4, 1},
                /*18*/{0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1},
                /*19*/{0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                //     0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27
        };
        /*0 - nothing
        * 1 - wall
        * 2 - player
        * 3 - box
        * 4 - green area
        * */

        for (int y = 0; y < getColCount(); y++) {
            for (int x = 0; x < getRowCount(); x++) {
                if (gameField[y][x] == 2) {
                    playerY = y;
                    playerX = x;
                }
                else if (gameField[y][x] == 4) {
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
        //checkIfLost();
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
        //checkIfLost();
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
        //checkIfLost();
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
        //checkIfLost();
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

            if (counter == 20){
                System.out.println("YOU WON MY MANNN!!!");
                System.exit(0);
            }
        }
    }

    public int[][] getGameField() {
        return gameField;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public int getPlayerX() {
        return playerX;
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
