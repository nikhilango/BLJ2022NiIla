import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    Game game;
    private int[][] gameField;
    @BeforeEach
    public void setup(){
        game = new Game();
        gameField = game.getGameField();
    }
    @Test
    public void player_move_right(){
        Game game = new Game();
        game.setPlayerX(8);
        game.setPlayerY(9);

        game.moveRight();

        assertEquals(9, game.getPlayerX());
    }

    @Test
    public void player_move_up(){
        Game game = new Game();
        game.setPlayerX(8);
        game.setPlayerY(9);

        game.moveUp();

        assertEquals(9, game.getPlayerY());
    }

    @Test
    public void player_move_right_into_wall(){
        Game game = new Game();
        game.setPlayerX(4);
        game.setPlayerY(10);

        game.moveRight();

        assertEquals(4, game.getPlayerX());
    }

    @Test
    public void player_move_up_into_wall(){
        Game game = new Game();
        game.setPlayerX(7);
        game.setPlayerY(3);

        game.moveUp();

        assertEquals(3 , game.getPlayerY());
    }

    @Test
    public void player_move_left_into_two_boxes(){
        Game game = new Game();
        game.setPlayerX(10);
        game.setPlayerY(6);

        game.moveLeft();

        assertEquals(10, game.getPlayerX());
    }

    @Test
    public void player_move_right_into_box_on_wall(){
        Game game = new Game();
        game.setPlayerX(5);
        game.setPlayerY(7);

        game.moveRight();

        assertEquals(5, game.getPlayerX());
    }

    @Test
    public void player_move_box_up(){
        Game game = new Game();
        game.setPlayerX(12);
        game.setPlayerY(7);

        game.moveUp();

        assertEquals(3, game.getGameField()[5][12]);
    }

    @Test
    public void player_move_box_right(){
        Game game = new Game();
        game.setPlayerX(8);
        game.setPlayerY(7);

        game.moveRight();

        assertEquals(3, game.getGameField()[7][10]);
    }

    @Test
    public void player_move_over_greenfield(){
        Game game = new Game();
        game.setPlayerX(23);
        game.setPlayerY(15);

        game.moveUp();
        game.moveUp();

        assertEquals(4, game.getGameField()[14][23]);
    }

    @Test
    public void player_move_on_top_of_greenfield(){
        Game game = new Game();
        game.setPlayerX(22);
        game.setPlayerY(17);

        game.moveRight();

        assertEquals(2, game.getGameField()[17][23]);
    }
}
