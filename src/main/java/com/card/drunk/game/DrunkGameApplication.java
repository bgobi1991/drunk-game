package com.card.drunk.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.card.drunk.game.service.PlayCards;

@SpringBootApplication
public class DrunkGameApplication {

  public static void main(String[] args) {
    // SpringApplication.run(DrunkGameApplication.class, args);

    ApplicationContext applicationContext = SpringApplication.run(DrunkGameApplication.class, args);

    PlayCards playCards = applicationContext.getBean(PlayCards.class);

    playCards.distributeCard(true);
  }
}
