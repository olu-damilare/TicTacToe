import TicTacToe.Game;
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
     assertEquals("""
             EMPTY EMPTY EMPTY 
             EMPTY EMPTY EMPTY 
             EMPTY EMPTY EMPTY 
             """, game.visualizeBoard());

    }

    @Test
    void testThatPlayer1CanPlayGame(){
        game.visualizeBoard();
        game.playerOneGamePlay(9);

        assertEquals("""
                        EMPTY EMPTY EMPTY 
                        EMPTY EMPTY EMPTY 
                        EMPTY EMPTY O 
                        """
             , game.visualizeBoard());
        assertTrue(game.playerOneHasPlayed());
    }

    @Test
    void testThatPlayer2CanPlayGame(){
        game.visualizeBoard();
        game.playerTwoGamePlay(5);

        assertEquals("""
                        EMPTY EMPTY EMPTY 
                        EMPTY X EMPTY 
                        EMPTY EMPTY EMPTY 
                        """
                , game.visualizeBoard());
        assertTrue(game.playerTwoHasPlayed());
    }

    @Test
    void testThatTwoPlayersCanPlayAgainstEachOther(){
        game.playerOneGamePlay(4);
        game.playerTwoGamePlay(8);
        assertEquals("""
                        EMPTY EMPTY EMPTY 
                        O EMPTY EMPTY 
                        EMPTY X EMPTY 
                        """
                , game.visualizeBoard());
    }

    @Test
    void testThatComputerCanPlayGame(){
        game.visualizeBoard();
        game.computerPlay();

        assertTrue(game.computerHasPlayed());
    }
    @Test
    void testThatPlayerOneCannotInputInvalidPositionNumber(){
        assertThrows(IndexOutOfBoundsException.class, ()-> game.playerOneGamePlay(20));
    }
    @Test
    void testThatPlayerTwoCannotInputInvalidPositionNumber(){
        assertThrows(IndexOutOfBoundsException.class, ()-> game.playerTwoGamePlay(-1));
    }

    @Test
    void testThatValueCannotBePlayedInAPreviouslyPlayedPositionByPlayer(){
        game.visualizeBoard();
        game.playerOneGamePlay(9);
        assertEquals("""
                        EMPTY EMPTY EMPTY 
                        EMPTY EMPTY EMPTY 
                        EMPTY EMPTY O 
                        """
                , game.visualizeBoard());
        assertThrows(IllegalArgumentException.class, ()-> game.playerOneGamePlay(9));
    }

    @Test
    void testThatValueCannotBePlayedInAPreviouslyPlayedPositionByComputer(){
        game.visualizeBoard();
        game.playerOneGamePlay(1);
        game.playerOneGamePlay(2);
        game.playerOneGamePlay(3);
        game.playerOneGamePlay(7);

        game.computerPlay();

        assertTrue(game.computerHasPlayed());
    }

    @Test
    void testThatSystemCanDetermineWinnerByFirstRow(){
        game.visualizeBoard();
        game.playerOneGamePlay(1);
        game.playerOneGamePlay(2);
        game.playerOneGamePlay(3);
        game.determineWinner();

        assertEquals("""
                O O O 
                EMPTY EMPTY EMPTY 
                EMPTY EMPTY EMPTY 
                """, game.visualizeBoard());
        assertEquals("Player One win", game.displayWinner());
    }

    @Test
    void testThatSystemCanDetermineWinnerBySecondRow(){
        game.visualizeBoard();
        game.playerOneGamePlay(4);
        game.playerOneGamePlay(5);
        game.playerOneGamePlay(6);
        game.determineWinner();

        assertEquals("""
                EMPTY EMPTY EMPTY 
                O O O 
                EMPTY EMPTY EMPTY 
                """, game.visualizeBoard());
        assertEquals("Player One win", game.displayWinner());
    }

    @Test
    void testThatSystemCanDetermineWinnerByThirdRow(){
        game.playerOneGamePlay(7);
        game.playerOneGamePlay(8);
        game.playerOneGamePlay(9);
        game.determineWinner();

        assertEquals("""
                EMPTY EMPTY EMPTY 
                EMPTY EMPTY EMPTY
                O O O 
                """, game.visualizeBoard());
        assertEquals("Player One win", game.displayWinner());
    }
    
    @Test
    void testThatSystemCanDetermineWinnerByFirstColumn(){
        game.visualizeBoard();
        game.playerOneGamePlay(1);
        game.playerOneGamePlay(4);
        game.playerOneGamePlay(7);
        game.determineWinner();

        assertEquals("""
                O EMPTY EMPTY 
                O EMPTY EMPTY 
                O EMPTY EMPTY 
                """, game.visualizeBoard());
        assertEquals("Player One win", game.displayWinner());
    }

    @Test
    void testThatSystemCanDetermineWinnerBySecondColumn(){
        game.playerOneGamePlay(2);
        game.playerOneGamePlay(5);
        game.playerOneGamePlay(8);
        game.determineWinner();

        assertEquals("""
                EMPTY O EMPTY 
                EMPTY O EMPTY 
                EMPTY O EMPTY 
                """, game.visualizeBoard());
        assertEquals("Player One win", game.displayWinner());
    }

    @Test
    void testThatSystemCanDetermineWinnerByThirdColumn(){
        game.playerOneGamePlay(3);
        game.playerOneGamePlay(6);
        game.playerOneGamePlay(9);
        game.determineWinner();

        assertEquals("""
                EMPTY EMPTY O 
                EMPTY EMPTY O 
                EMPTY EMPTY O 
                """, game.visualizeBoard());
        assertEquals("Player One win", game.displayWinner());
    }

    @Test
    void FirstTestThatSystemCanDetermineWinnerByDiagonal(){
        game.playerOneGamePlay(1);
        game.playerOneGamePlay(5);
        game.playerOneGamePlay(9);
        game.determineWinner();

        assertEquals("""
                O EMPTY EMPTY 
                EMPTY O EMPTY 
                EMPTY EMPTY O 
                """, game.visualizeBoard());
        assertEquals("Player One win", game.displayWinner());
    }

    @Test
    void secondTestThatSystemCanDetermineWinnerByDiagonal(){
        game.playerTwoGamePlay(3);
        game.playerTwoGamePlay(5);
        game.playerTwoGamePlay(7);
        game.determineWinner();

        assertEquals("""
                EMPTY EMPTY X 
                EMPTY X EMPTY 
                X EMPTY EMPTY 
                """, game.visualizeBoard());
        assertEquals("Player Two win", game.displayWinner());
    }

    @Test
    void TestThatSystemCanDetermineGameEndInDraw(){
        game.playerOneGamePlay(2);
        game.playerTwoGamePlay(1);
        game.playerOneGamePlay(3);
        game.playerTwoGamePlay(5);
        game.playerOneGamePlay(4);
        game.playerTwoGamePlay(6);
        game.playerTwoGamePlay(7);
        game.playerTwoGamePlay(8);
        game.playerOneGamePlay(9);
        game.determineWinner();

        assertEquals("""
                X O O
                O X X
                X X O
                """, game.visualizeBoard());
        assertEquals("Draw", game.displayWinner());
    }



}
