package bnp.kata.java.tictactoe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class TictactoeApplicationTests {

    @Autowired
    private GameService gameService;

    @Test
    void contextLoads() {
    }

    @Test
    void isGridFull() {
        char[][] tab = {{'x', 'o', 'x'}, {'o', 'x', 'x'}, {'x', 'o', 'o'}};
        Assert.isTrue(this.gameService.isGridFilled(tab), "Grid is not filled");
    }

    @Test
	void playerWin()
	{
		char[][] tab = {{'x', '0', ' '}, {'x', ' ', '0'}, {'x', '0', 'x'}};
		Assert.isTrue(this.gameService.doesUserWon(tab, 'x'), "User 0 has not won");
	}
}
