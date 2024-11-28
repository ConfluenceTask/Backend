package com.example.demo.service.Impl;

import com.example.demo.model.Card;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.InMemoryCardDAO;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final InMemoryCardDAO repository;

    public CardServiceImpl(InMemoryCardDAO repository) {
        this.repository = repository;
    }

    @Override
    public List<Card> findAllCards() {
        return repository.findAllCards();
    }

    @Override
    public Card save(Card card) {
        return repository.save(card);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Card update(Card card) {
        return repository.update(card);
    }

    @Override
    public Card findCardById(Long id) {
        return repository.findCardById(id);
    }
}
