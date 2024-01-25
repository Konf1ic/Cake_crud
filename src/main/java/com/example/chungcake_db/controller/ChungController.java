package com.example.chungcake_db.controller;

import com.example.chungcake_db.model.Chung;
import com.example.chungcake_db.service.ChungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cakes")
public class ChungController {
    @Autowired
    private ChungService chungService;

    @GetMapping()
    public String showAllCakes(Model model) {
        List<Chung> cakes = chungService.getAllListCake();
        model.addAttribute("cakes", cakes);
        return "list";
    }

    @GetMapping("/add-cake")
    public String showAddCakeForm(Model model) {
        Chung trungCake = new Chung();
        model.addAttribute("cake", trungCake);
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String showEditCakeForm(@PathVariable int id, Model model) {
        model.addAttribute("cake", chungService.findById(id));
        return "edit";
    }

    @GetMapping("/search")
    public String showEditCakeForm(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("cakes", chungService.searchWithKeyword(keyword));
        return "list";
    }

    @PostMapping("/create")
    public String createCake(@ModelAttribute Chung chung) {
        chungService.createCake(chung);
        return "redirect:/cakes";
    }

    @PostMapping("/update")
    public String updateCake(@ModelAttribute Chung chung) {
        chungService.updateCake(chung);
        return "redirect:/cakes";
    }

    @GetMapping("/delete/{id}")
    public String deleteCake(@PathVariable int id) {
        chungService.deleteById(id);
        return "redirect:/cakes";
    }
}

