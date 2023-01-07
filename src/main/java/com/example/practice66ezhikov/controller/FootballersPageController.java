package com.example.practice66ezhikov.controller;

import com.example.practice66ezhikov.dto.FootballerForm;
import com.example.practice66ezhikov.enums.Countries;
import com.example.practice66ezhikov.enums.Sexes;
import com.example.practice66ezhikov.service.db.FootballerEntityService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/footballers")
public class FootballersPageController {
    FootballerEntityService footballerEntityService;

    @GetMapping
    public String getPage(Model model) {
        model.addAttribute("footballerForm", new FootballerForm());
        model.addAttribute("footballerList", footballerEntityService.getAllFootballers());
        model.addAttribute("teams", footballerEntityService.getAllTeamNames());
        model.addAttribute("countries", Countries.values());
        model.addAttribute("sexes", Sexes.values());
        model.addAttribute("linkToMainPage", "/");
        return "footballers";
    }

    @PostMapping
    public String changeFootballerData(FootballerForm modifiedForm) {
        String insteadTeamName = modifiedForm.getInsteadTeamName();
        if (!insteadTeamName.isBlank()) {
            modifiedForm.setTeamName(insteadTeamName);
        }
        footballerEntityService.updateFootballerInfo(modifiedForm);
        return "redirect:/footballers";
    }
}
