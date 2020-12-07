package bnp.kata.java.tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Controller
public class GameController {

    private GameInformation gameInformation;
    private CellInformation cellInformation;

    @Autowired
    private GameService gameService;

    public GameController() {
    }

    /**
     * Call the method that init the variables
     */
    @PostConstruct
    private void init() {
        this.gameInformation = this.gameService.initVariables();
    }

    /**
     * Main service that allows to play the game
     *
     * @param model   model of the page
     * @param request request with param
     * @return the html file
     */
    @GetMapping("/play")
    public String play(Model model, HttpServletRequest request) {
        this.gameService.setLetterAndChangePlayer(this.gameInformation, request);
        model.addAttribute("gameInfo", this.gameInformation);
        model.addAttribute("cellInfo", this.cellInformation);
        return ("play");
    }

    /**
     * Service to reset the data
     *
     * @return a redirection to the html file
     */
    @GetMapping("/reset")
    public String reset() {
        this.init();
        return "redirect:/play";
    }

    /**
     * Service to redirect to /play
     *
     * @return a redirection to the html file
     */
    @GetMapping("/")
    public String home() {
        return "redirect:/play";
    }
}
