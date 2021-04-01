package TicTacToe;

import java.util.Arrays;
import java.util.Random;

public class Game {
    private final String[] gameBoard = new String[9];
    private boolean playerHasPlayed;
    private boolean computerHasPlayed;
    private boolean playerWin;
    private boolean computerWin;

    public String visualizeBoard() {
        StringBuilder board = new StringBuilder();
        for (int i = 1; i <= gameBoard.length; i++) {
            board.append(gameBoard[i - 1]);
            if(i % 3 == 0)
                board.append("|\n");
        }
        return board.toString();
    }

    public void designBoardPattern() {
        Arrays.fill(gameBoard, "|___");
    }

    public void play(int position) {
        boolean positionOccupied = gameBoard[position - 1].equals("| O ") || gameBoard[position - 1].equals("| X ");
        if(positionOccupied)
            throw new IllegalArgumentException("Position " + position + " has already been played");

        gameBoard[position - 1] = "| O ";
        playerHasPlayed = true;

    }

    public void computerPlay() {
        Random random = new Random();
        int generatedPosition;

//        do{
            generatedPosition = 1 + random.nextInt(9);
//        }
//        while(!(gameBoard[generatedPosition - 1].equals("|___ "))) ;

        gameBoard[generatedPosition - 1] = "| X ";
        playerHasPlayed = true;
       computerHasPlayed = true;
    }

    public boolean playerHasPlayed() {
        return playerHasPlayed;
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
    }

    private void checkDiagonal(){
        boolean computerFirstDiagonalCheck = gameBoard[0].equals("| X ") && gameBoard[4].equals("| X ") && gameBoard[8].equals("| X ");
        boolean computerSecondDiagonalCheck = gameBoard[2].equals("| X ") && gameBoard[4].equals("| X ") && gameBoard[6].equals("| X ");
        boolean playerFirstDiagonalCheck = gameBoard[0].equals("| O ") && gameBoard[4].equals("| O ") && gameBoard[8].equals("| O ");
        boolean playerSecondDiagonalCheck = gameBoard[2].equals("| O ") && gameBoard[4].equals("| O ") && gameBoard[6].equals("| O ");

        if(playerFirstDiagonalCheck || playerSecondDiagonalCheck)
            playerWin = true;

        else if(computerFirstDiagonalCheck || computerSecondDiagonalCheck)
            computerWin = true;

    }

    private void checkFirstColumn(){
        boolean computerFirstColumnCheck = gameBoard[0].equals("| X ") && gameBoard[3].equals("| X ") && gameBoard[6].equals("| X ");
        boolean playerFirstColumnCheck = gameBoard[0].equals("| O ") && gameBoard[3].equals("| O ") && gameBoard[6].equals("| O ");
        if(playerFirstColumnCheck)
            playerWin = true;
        else if(computerFirstColumnCheck)
            computerWin = true;

    }
    private void checkSecondColumn(){
        boolean computerSecondColumnCheck = gameBoard[1].equals("| X ") && gameBoard[4].equals("| X ") && gameBoard[7].equals("| X ");
        boolean playerSecondColumnCheck = gameBoard[1].equals("| O ") && gameBoard[4].equals("| O ") && gameBoard[7].equals("| O ");
        if(playerSecondColumnCheck)
            playerWin = true;

        else if(computerSecondColumnCheck)
            computerWin = true;

    }
    private void checkThirdColumn(){
        boolean computerThirdColumnCheck = gameBoard[2].equals("| X ") && gameBoard[5].equals("| X ") && gameBoard[8].equals("| X ");
        boolean playerThirdColumnCheck = gameBoard[2].equals("| O ") && gameBoard[5].equals("| O ") && gameBoard[8].equals("| O ");
        if(playerThirdColumnCheck)
            playerWin = true;

        else if(computerThirdColumnCheck)
            computerWin = true;

    }

    private void checkFirstRow(){
        boolean computerFirstRowCheck = gameBoard[0].equals("| X ") && gameBoard[1].equals("| X ") && gameBoard[2].equals("| X ");
        boolean playerFirstRowCheck = gameBoard[0].equals("| O ") && gameBoard[1].equals("| O ") && gameBoard[2].equals("| O ");
        if(playerFirstRowCheck)
            playerWin = true;

        else if(computerFirstRowCheck)
            computerWin = true;

    }

    private void checkSecondRow(){
        boolean computerSecondRowCheck = gameBoard[3].equals("| X ") && gameBoard[4].equals("| X ") && gameBoard[5].equals("| X ");
        boolean playerSecondCheck = gameBoard[3].equals("| O ") && gameBoard[4].equals("| O ") && gameBoard[5].equals("| O ");
        if(playerSecondCheck)
            playerWin = true;

        else if(computerSecondRowCheck)
            computerWin = true;
    }

    private void checkThirdRow(){
        boolean computerThirdRowCheck = gameBoard[6].equals("| X ") && gameBoard[7].equals("| X ") && gameBoard[8].equals("| X ");
        boolean playerThirdRowCheck = gameBoard[6].equals("| O ") && gameBoard[7].equals("| O ") && gameBoard[8].equals("| O ");
        if(playerThirdRowCheck)
            playerWin = true;

        else if(computerThirdRowCheck)
            computerWin = true;

    }

    public String displayWinner(){
        if(playerWin)
            return "You win";
        else if(computerWin)
            return "You lose";
        else
            return "Game in progress";
    }



}
