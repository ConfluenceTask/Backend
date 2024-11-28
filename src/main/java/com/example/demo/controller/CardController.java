package com.example.demo.controller;

import com.example.demo.model.Card;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {

    private final CardService service;

    public CardController(CardService cardService) {
        this.service = cardService;
    }

    @GetMapping("/all")
    public List<Card> findAll() {
        return service.findAllCards();
    }

    @PostMapping("/save")
    public Card save(@RequestBody Card card) {
        return service.save(card);
    }

    @GetMapping({"/find/{id}"})
    public Card findById(@PathVariable Long id) {
        return service.findCardById(id);
    }

    @PutMapping("/update")
    public Card update(@RequestBody Card card) {
        return service.update(card);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "Deleted " + id;
    }
}
