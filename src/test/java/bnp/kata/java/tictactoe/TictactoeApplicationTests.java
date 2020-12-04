package bnp.kata.java.tictactoe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class TictactoeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void isGridFilledOfXAnd0() {
        // TODO Get the current grid
        char[][] tab = {{'x', '0', 'x'}, {'x', '0', '0'}, {'x', '0', '0'}};
        for (char[] line : tab) {
            for (char character : line) {
                Assert.isTrue(character == 'x' || character == '0' || character == ' ', "Grid contains no handle character");
            }
        }
    }

    @Test
    void isGridFull() {
        char[][] tab = {{'x', '0', 'x'}, {'0', ' ', 'x'}, {'x', '0', ' '}};
        // TODO Implement and call the service that check that
        for (char[] line : tab) {
            for (char character : line) {
                    Assert.isTrue(character == 'x' || character == '0', "Grid is not full");
            }
        }
    }

    @Test
	void playerWin()
	{
		char[][] tab = {{'x', '0', ' '}, {'x', ' ', '0'}, {'x', '0', 'x'}};
		// TODO Implement and call the service that check that
	}
}
