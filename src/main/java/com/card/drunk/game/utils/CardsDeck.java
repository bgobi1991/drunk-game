package com.card.drunk.game.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardsDeck {

  public Map<String, Integer> cards;

  @Autowired
  public CardsDeck() {
    cards = new HashMap<>();
    cards.put("a", 4);
    cards.put("k", 4);
    cards.put("q", 4);
    cards.put("j", 4);
    cards.put("10", 4);
    cards.put("9", 4);
    cards.put("8", 4);
    cards.put("7", 4);
    cards.put("6", 4);
    cards.put("5", 4);
    cards.put("4", 4);
    cards.put("3", 4);
    cards.put("2", 4);
  }
}
