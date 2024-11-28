package com.example.demo.service;

import com.example.demo.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CardService {
    List<Card> findAllCards();

    Card save(Card card);

    void deleteById(Long id);

    Card update(Card card);

    Card findCardById(Long id);
}
