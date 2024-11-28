package com.example.demo.repository;

import com.example.demo.model.Card;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryCardDAO {
    private final List<Card> CARDS = new ArrayList<>();

    public List<Card> findAllCards() {
        return CARDS;
    }

    public Card save(Card card) {
        CARDS.add(card);
        return card;
    }

    public Card findCardById(Long id) {
        return CARDS.stream()
                .filter(card -> card.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Card update(Card card) {
        var cardIndex = IntStream.range(0, CARDS.size())
                .filter(i -> CARDS.get(i).getId().equals(card.getId()))
                .findFirst()
                .orElse(-1);

        if (cardIndex != -1) {
            CARDS.set(cardIndex, card);
        }

        return null;
    }


    public void deleteById(Long id) {
        var card = findCardById(id);
        if (card != null) {
            CARDS.remove(card);
        }
    }
}
