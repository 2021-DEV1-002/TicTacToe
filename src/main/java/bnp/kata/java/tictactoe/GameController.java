package bnp.kata.java.tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GameController {

    private char[][] grid;
    int player;
    boolean nobodyWin;
    boolean gameEnd;

    @Autowired
    private GameService gameService;

    public GameController() {
        this.initVariables();
    }

    /**
     * Init class variables
     */
    private void initVariables() {
        this.player = 0;
        this.gameEnd = false;
        this.nobodyWin = false;
        grid = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }

    /**
     * Main service that allows to play the game
     * @param model model of the page
     * @param request request with param
     * @return the html file
     */
    @RequestMapping("/play")
    public String play(Model model, HttpServletRequest request) {
        this.gameService.setLetterAndChangePlayer(this.player, this.gameEnd, this.grid, this.nobodyWin, request);
        model.addAttribute("grid", grid);
        model.addAttribute("gameEnd", gameEnd);
        model.addAttribute("player", player);
        model.addAttribute("nobodyWin", nobodyWin);
        return ("play");
    }

    /**
     * Service to reset the data
     * @return a redirection to the html file
     */
    @GetMapping("/reset")
    public String reset() {
        this.initVariables();
        return "redirect:/play";
    }
}
