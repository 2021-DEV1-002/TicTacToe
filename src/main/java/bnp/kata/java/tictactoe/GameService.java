package bnp.kata.java.tictactoe;

import org.springframework.stereotype.Service;

@Service
public class GameService
{
    public boolean isGameFinished(char[][] grid)
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
}