package bnp.kata.java.tictactoe;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class GameService
{
    /**
     * is game finished (all the cells are filled) ?
     * @param grid the table
     * @return true if the table is filled
     */
    public boolean isGridFilled(char[][] grid)
    {
        boolean gameFinished = true;
        for (char[] line : grid) {
            for (char character : line) {
                if (character == ' ')
                    gameFinished = false;
            }
        }
        return gameFinished;
    }

    /**
     * Check if the user has won
     * @param letter letter used in the table
     * @return true if user won
     */
    public boolean doesUserWon(char [][] grid, char letter) {
        // Check the lines
        if (grid[0][0] == letter && grid[0][1] == letter && grid[0][2] == letter)
            return true;
        if (grid[1][0] == letter && grid[1][1] == letter && grid[1][2] == letter)
            return true;
        if (grid[2][0] == letter && grid[2][1] == letter && grid[2][2] == letter)
            return true;
        // Check the columns
        if (grid[0][0] == letter && grid[1][0] == letter && grid[2][0] == letter)
            return true;
        if (grid[0][1] == letter && grid[1][1] == letter && grid[2][1] == letter)
            return true;
        if (grid[0][2] == letter && grid[1][2] == letter && grid[2][2] == letter)
            return true;
        // Check the diagonals
        if (grid[0][0] == letter && grid[1][1] == letter && grid[2][2] == letter)
            return true;
        if (grid[0][2] == letter && grid[1][1] == letter && grid[2][0] == letter)
            return true;
        return false;
    }

    /**
     * Update the table with the correct letter
     * @param param the param of the url
     * @param letter the letter of the user
     */
    private void updateGrid(char [][] grid, String param, char letter) {
        if (param.compareTo(CellPosition.LEFT_TOP.value) == 0)
            grid[0][0] = letter;
        if (param.compareTo(CellPosition.MIDDLE_TOP.value) == 0)
            grid[0][1] = letter;
        if (param.compareTo(CellPosition.RIGHT_TOP.value) == 0)
            grid[0][2] = letter;
        if (param.compareTo(CellPosition.LEFT_MIDDLE.value) == 0)
            grid[1][0] = letter;
        if (param.compareTo(CellPosition.MIDDLE_MIDDLE.value) == 0)
            grid[1][1] = letter;
        if (param.compareTo(CellPosition.RIGHT_MIDDLE.value) == 0)
            grid[1][2] = letter;
        if (param.compareTo(CellPosition.LEFT_BOTTOM.value) == 0)
            grid[2][0] = letter;
        if (param.compareTo(CellPosition.MIDDLE_BOTTOM.value) == 0)
            grid[2][1] = letter;
        if (param.compareTo(CellPosition.RIGHT_BOTTOM.value) == 0)
            grid[2][2] = letter;
    }

    /**
     * Main logic method :
     * 1) Has user played ? If yes, we retrieve the location of the table and update the table with the letter
     * 2) Has user won ? If yes, gameEnd to true
     * 3) Is the table filled ? If yes, nobodyWin to true, else the played changes
     * @param request
     */
    public void setLetterAndChangePlayer(int player, boolean gameEnd, char[][] grid, boolean nobodyWin, HttpServletRequest request) {
        if (request.getParameterMap().containsKey("submitButton")) {
            String param = request.getParameter("submitButton");
            char letter = player == 0 ? 'x' : 'o';
            this.updateGrid(grid, param, letter);
            if (this.doesUserWon(grid, letter)) {
                gameEnd = true;
            } else {
                if (this.isGridFilled(grid))
                    nobodyWin = true;
                else
                    player = player == 0 ? 1 : 0;
            }
        }
    }
}