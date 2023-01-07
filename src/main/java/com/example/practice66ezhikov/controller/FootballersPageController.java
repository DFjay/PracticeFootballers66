package com.example.practice66ezhikov.controller;

import com.example.practice66ezhikov.dto.FootballerFormDto;
import com.example.practice66ezhikov.dto.FootballerFormForChangeDataDto;
import com.example.practice66ezhikov.enums.Countries;
import com.example.practice66ezhikov.service.db.FootballerEntityService;
import jakarta.validation.Valid;
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
        model.addAttribute("footballerForm", new FootballerFormDto());
        model.addAttribute("changeDataForm", new FootballerFormForChangeDataDto());
        model.addAttribute("footballerList", footballerEntityService.getAllFootballers());
        model.addAttribute("teams", footballerEntityService.getAllTeamNames());
        model.addAttribute("countries", Countries.values());
        model.addAttribute("linkToMainPage", "/");
        return "footballers";
    }

    @PostMapping
    public String changeFootballerData(@Valid FootballerFormForChangeDataDto form) {
        String insteadTeamName = form.getInsteadTeamName();
        if (insteadTeamName != null && !insteadTeamName.isBlank()) {
            form.setTeamName(insteadTeamName);
        }
        footballerEntityService.updateFootballerInfo(form);
        return "redirect:/footballers";
    }
}
