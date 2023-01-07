package com.example.practice66ezhikov.controller;

import com.example.practice66ezhikov.dto.FootballerFormDto;
import com.example.practice66ezhikov.enums.Countries;
import com.example.practice66ezhikov.service.db.FootballerEntityService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/")
public class MainPageController {
    FootballerEntityService footballerEntityService;

    @GetMapping
    public String getPage(Model model) {
        model.addAttribute("footballerForm", new FootballerFormDto());
        model.addAttribute("countries", Countries.values());
        model.addAttribute("teams", footballerEntityService.getAllTeamNames());
        model.addAttribute("linkToFootballersPage", "footballers");
        return "index";
    }

    @PostMapping("/form")
    public String saveNewFootballer(@Valid FootballerFormDto form) {
        String insteadTeamName = form.getInsteadTeamName();
        if (insteadTeamName != null && !insteadTeamName.isBlank()) {
            form.setTeamName(insteadTeamName);
        }
        footballerEntityService.addFootballer(form);
        return "redirect:/";
    }
}
