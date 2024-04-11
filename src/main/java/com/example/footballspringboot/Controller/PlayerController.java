package com.example.footballspringboot.Controller;

import com.example.footballspringboot.Model.FootballPlayers;
import com.example.footballspringboot.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    public String showPlayers(Model model){
        model.addAttribute("players", playerService.readAll());
        return "show-players";
    }

    @GetMapping("/players/add")
    public String showAddForm(Model model){
        model.addAttribute("players", new PlayerService());
        return "add-players";
    }
    @GetMapping("/players/edit/{ID}")
    public String showEditForm(@PathVariable Long ID, Model model){
        playerService.findPlayer(ID).ifPresent(playerService -> model.addAttribute("fodboldspillere"));
        return "edit-players";
    }
    @GetMapping("/players/save/")
    public String savePlayers(@ModelAttribute FootballPlayers f){
        playerService.addFootballer(f);
        return "redirect:/";
    }
    @GetMapping("/players/delete/")
    public String deletePlayers(@PathVariable Long ID){
        playerService.deleteFootballer(ID);
        return "redirect:/";
    }
}