package TicTacToe;

import java.util.Arrays;
import java.util.Random;
import static TicTacToe.Options.*;

public class Game {
    private final Options[][] gameBoard = new Options[3][3];
    private boolean playerOneHasPlayed;
    private boolean computerHasPlayed;
    private boolean playerOneWin;
    private boolean computerWin;
    private boolean playerTwoHasPlayed;
    private boolean playerTwoWin;
    private boolean gameEndInDraw = true;

    public Game() {
        for (Options[] options : gameBoard) {
            Arrays.fill(options, EMPTY);
        }
    }
    
    public String visualizeBoard() {
        StringBuilder display = new StringBuilder();
        for (Options[] options : gameBoard) {
            for (int j = 0; j < options.length; j++) {
                if (j != options.length - 1)
                    display.append(options[j]).append(" ");

                else
                    display.append(options[j]).append("\n");
            }

        }
        return display.toString();
    }

    public void playerOneGamePlay(int position) {
        validatePosition(position);

        int column = (position - 1) % 3;
        int row = (position - 1) / 3;

        checkPreviouslyPlayedPosition(position, gameBoard[row][column]);

        gameBoard[row][column] = O;
        playerOneHasPlayed = true;

    }

    private void validatePosition(int position) {
        if(position < 1 || position > 9)
            throw new IndexOutOfBoundsException("Invalid position");
    }

    public void playerTwoGamePlay(int position) {
        validatePosition(position);

        int column = (position - 1) % 3;
        int row = (position - 1) / 3;
        checkPreviouslyPlayedPosition(position, gameBoard[row][column]);

        gameBoard[row][column] = X;
        playerTwoHasPlayed = true;

    }

    private void checkPreviouslyPlayedPosition(int position, Options options) {
        boolean positionOccupied = options.equals(O) || options.equals(X);
        if (positionOccupied)
            throw new IllegalArgumentException("Position " + position + " has already been played");
    }

    public void computerPlay() {
        Random random = new Random();
        int generatedPosition;
        int column;
        int row;

        do{
            generatedPosition = 1 + random.nextInt(9);
            column = (generatedPosition - 1) % 3;
            row = (generatedPosition - 1) / 3;
        }
        while(!(gameBoard[row][column].equals(EMPTY))) ;

        gameBoard[row][column] = X;
        computerHasPlayed = true;
    }

    public boolean playerOneHasPlayed() {
        return playerOneHasPlayed;
    }

    public boolean computerHasPlayed() {
        return computerHasPlayed;
    }

    public void determineWinner() {
        checkDiagonal();
        checkFirstColumn();
        checkFirstRow();
        checkSecondColumn();
        checkSecondRow();
        checkThirdColumn();
        checkThirdRow();
        checkGameEndInDraw();
    }

    private void checkDiagonal(){
        boolean computerFirstDiagonalCheck = gameBoard[0][0].equals(X) && gameBoard[1][1].equals(X) && gameBoard[2][2].equals(X);
        boolean computerSecondDiagonalCheck = gameBoard[0][2].equals(X) && gameBoard[1][1].equals(X) && gameBoard[2][0].equals(X);
        boolean playerFirstDiagonalCheck = gameBoard[0][0].equals(O) && gameBoard[1][1].equals(O) && gameBoard[2][2].equals(O);
        boolean playerSecondDiagonalCheck = gameBoard[0][2].equals(O) && gameBoard[1][1].equals(O) && gameBoard[2][0].equals(O);

        if(playerFirstDiagonalCheck || playerSecondDiagonalCheck)
            playerOneWin = true;

        else if(computerFirstDiagonalCheck || computerSecondDiagonalCheck) {
            if(computerHasPlayed)
                computerWin = true;
            else
            playerTwoWin = true;
        }


    }

    private void checkFirstColumn(){
        boolean computerFirstColumnCheck = gameBoard[0][0].equals(X) && gameBoard[1][0].equals(X) && gameBoard[2][0].equals(X);
        boolean playerFirstColumnCheck = gameBoard[0][0].equals(O) && gameBoard[1][0].equals(O) && gameBoard[2][0].equals(O);
        if(playerFirstColumnCheck)
            playerOneWin = true;
        else if(computerFirstColumnCheck) {
            if(computerHasPlayed)
                computerWin = true;
            else
                playerTwoWin = true;
        }

    }
    private void checkSecondColumn(){
        boolean computerSecondColumnCheck = gameBoard[0][1].equals(X) && gameBoard[1][1].equals(X) && gameBoard[2][1].equals(X);
        boolean playerSecondColumnCheck = gameBoard[0][1].equals(O) && gameBoard[1][1].equals(O) && gameBoard[2][1].equals(O);
        if(playerSecondColumnCheck)
            playerOneWin = true;

        else if(computerSecondColumnCheck) {
            if(computerHasPlayed)
                computerWin = true;
            else
                playerTwoWin = true;
        }

    }
    private void checkThirdColumn(){
        boolean computerThirdColumnCheck = gameBoard[0][2].equals(X) && gameBoard[1][2].equals(X) && gameBoard[2][2].equals(X);
        boolean playerThirdColumnCheck = gameBoard[0][2].equals(O) && gameBoard[1][2].equals(O) && gameBoard[2][2].equals(O);
        if(playerThirdColumnCheck)
            playerOneWin = true;

        else if(computerThirdColumnCheck) {
            if(computerHasPlayed)
                computerWin = true;
            else
                playerTwoWin = true;
        }

    }

    private void checkSecondRow(){
        boolean computerFirstRowCheck = gameBoard[1][0].equals(X) && gameBoard[1][1].equals(X) && gameBoard[1][2].equals(X);
        boolean playerFirstRowCheck = gameBoard[1][0].equals(O) && gameBoard[1][1].equals(O) && gameBoard[1][2].equals(O);
        if(playerFirstRowCheck)
            playerOneWin = true;

        else if(computerFirstRowCheck) {
            if(computerHasPlayed)
                computerWin = true;
            else
                playerTwoWin = true;
        }

    }

    private void checkFirstRow(){
        boolean computerSecondRowCheck = gameBoard[0][0].equals(X) && gameBoard[0][1].equals(X) && gameBoard[0][2].equals(X);
        boolean playerSecondCheck = gameBoard[0][0].equals(O) && gameBoard[0][1].equals(O) && gameBoard[0][2].equals(O);
        if(playerSecondCheck)
            playerOneWin = true;

        else if(computerSecondRowCheck) {
            if(computerHasPlayed)
                computerWin = true;
            else
                playerTwoWin = true;
        }
    }

    private void checkThirdRow(){
        boolean computerThirdRowCheck = gameBoard[2][0].equals(X) && gameBoard[2][1].equals(X) && gameBoard[2][2].equals(X);
        boolean playerThirdRowCheck = gameBoard[2][0].equals(O) && gameBoard[2][1].equals(O) && gameBoard[2][2].equals(O);
        if(playerThirdRowCheck)
            playerOneWin = true;

        else if(computerThirdRowCheck) {
            if(computerHasPlayed)
                computerWin = true;
            else
                playerTwoWin = true;
        }

    }

    public String displayWinner(){
        if(playerOneWin)
            return "Player One win";
        else if(computerWin)
            return "Computer win";
        else if(playerTwoWin)
            return "Player Two win";
        else if(gameEndInDraw)
            return "Draw";
        else
            return "Game in Progress";
    }

    private void checkGameEndInDraw(){
        for (Options[] options : gameBoard)
            for (Options option : options) {
                if (option == EMPTY) {
                    gameEndInDraw = false;
                    break;
                }
            }

    }
    public boolean playerTwoHasPlayed() {
        return playerTwoHasPlayed;
    }
}
