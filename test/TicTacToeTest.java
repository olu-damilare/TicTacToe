import TicTacToe.Game;
import TicTacToe.Options;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    Game game;
    @BeforeEach
    void setUp(){
        game = new Game();
    }

    @Test
    void testThatGameBoardCanBeVisualized(){
        game.designBoardPattern();
     assertEquals("""
             |___|___|___|
             |___|___|___|
             |___|___|___|
             """, game.visualizeBoard());

    }

    @Test
    void testThatUserCanPlayGame(){
        game.designBoardPattern();
        game.visualizeBoard();
        game.play(9);

        assertEquals("""
                |___|___|___|
                |___|___|___|
                |___|___| O |
                """, game.visualizeBoard());
        assertTrue(game.playerHasPlayed());
    }
    @Test
    void testThatComputerCanPlayGame(){
        game.designBoardPattern();
        game.visualizeBoard();
        game.computerPlay();

        assertTrue(game.computerHasPlayed());
    }
    @Test
    void testThatValueCannotBePlayedInAPreviouslyPlayedPosition(){
        game.designBoardPattern();
        game.visualizeBoard();
        game.play(9);
        assertThrows(IllegalArgumentException.class, ()-> game.play(9));
    }
//    @Test
//    void testThatValueCannotBePlayedInAPreviouslyPlayedPositionByComputer(){
//        game.designBoardPattern();
//        game.visualizeBoard();
//        game.play(Options.O, 1);
//        game.play(Options.O, 2);
//        game.play(Options.O, 3);
//
//
//        game.play(Options.O, 7);
//        game.computerPlay(Options.O);
//
//        assertTrue(game.computerHasPlayed());
//    }

    @Test
    void testThatSystemCanDetermineWinnerByFirstRow(){
        game.designBoardPattern();
        game.visualizeBoard();
        game.play(1);
        game.play(2);
        game.play(3);
        game.determineWinner();

        assertEquals("""
                | O | O | O |
                |___|___|___|
                |___|___|___|
                """, game.visualizeBoard());
        assertEquals("You win", game.displayWinner());
    }
    @Test
    void testThatSystemCanDetermineWinnerBySecondRow(){
        game.designBoardPattern();
        game.visualizeBoard();
        game.play(4);
        game.play(5);
        game.play(6);
        game.determineWinner();

        assertEquals("""
                |___|___|___|
                | O | O | O |
                |___|___|___|
                """, game.visualizeBoard());
        assertEquals("You win", game.displayWinner());
    }
    @Test
    void testThatSystemCanDetermineWinnerByThirdRow(){
        game.designBoardPattern();
        game.visualizeBoard();
        game.play(7);
        game.play(8);
        game.play(9);
        game.determineWinner();

        assertEquals("""
                |___|___|___|
                |___|___|___|
                | O | O | O |
                """, game.visualizeBoard());
        assertEquals("You win", game.displayWinner());
    }
    @Test
    void testThatSystemCanDetermineWinnerByFirstColumn(){
        game.designBoardPattern();
        game.visualizeBoard();
        game.play(1);
        game.play(4);
        game.play(7);
        game.determineWinner();

        assertEquals("""
                | O |___|___|
                | O |___|___|
                | O |___|___|
                """, game.visualizeBoard());
        assertEquals("You win", game.displayWinner());
    }
    @Test
    void testThatSystemCanDetermineWinnerBySecondColumn(){
        game.designBoardPattern();
        game.visualizeBoard();
        game.play(2);
        game.play(5);
        game.play(8);
        game.determineWinner();

        assertEquals("""
                |___| O |___|
                |___| O |___|
                |___| O |___|
                """, game.visualizeBoard());
        assertEquals("You win", game.displayWinner());
    }
    @Test
    void testThatSystemCanDetermineWinnerByThirdColumn(){
        game.designBoardPattern();
        game.visualizeBoard();
        game.play(3);
        game.play(6);
        game.play(9);
        game.determineWinner();

        assertEquals("""
                |___|___| O |
                |___|___| O |
                |___|___| O |
                """, game.visualizeBoard());
        assertEquals("You win", game.displayWinner());
    }

    @Test
    void FirstTestThatSystemCanDetermineWinnerByDiagonal(){
        game.designBoardPattern();
        game.visualizeBoard();
        game.play(1);
        game.play(5);
        game.play(9);
        game.determineWinner();

        assertEquals("""
                | O |___|___|
                |___| O |___|
                |___|___| O |
                """, game.visualizeBoard());
        assertEquals("You win", game.displayWinner());
    }

    @Test
    void secondTestThatSystemCanDetermineWinnerByDiaognal(){
        game.designBoardPattern();
        game.visualizeBoard();
        game.play(3);
        game.play(5);
        game.play(7);
        game.determineWinner();

        assertEquals("""
                |___|___| O |
                |___| O |___|
                | O |___|___|
                """, game.visualizeBoard());
        assertEquals("You win", game.displayWinner());
    }

}
