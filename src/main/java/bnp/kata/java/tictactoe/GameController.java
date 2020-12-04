package bnp.kata.java.tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    private char[][] grid = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private int player;
    boolean firstTime;

    @Autowired
    private GameService gameService;

    public GameController() {
        this.player = 0;
        this.firstTime = true;
    }

    @RequestMapping("/play")
    public String play(@ModelAttribute CellInformation cellinformation, Model model) {
        setLetterAndChangePlayer(cellinformation);
        this.firstTime = false;
        model.addAttribute("grid", grid);
        return ("play");
    }

    private void setLetterAndChangePlayer(CellInformation cellinformation)
    {
        if (cellinformation != null && !this.firstTime) {
            grid[cellinformation.getCellX()][cellinformation.getCellY()] = player == 0 ? 'x' : 'o';
            player = player == 0 ? 1 : 0;
        }
    }
}
