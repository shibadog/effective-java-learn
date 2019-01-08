package jp.shibadog.learn.effective.learn45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartesianProduct {

    public void run() {
        log.info(newDeck().toString());
        log.info(newDeck2().toString());
    }

    private List<Card> newDeck() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                result.add(new Card(suit, rank));
        return result;
    }

    private List<Card> newDeck2() {
        return Stream.of(Suit.values())
            .flatMap(suit ->
                Stream.of(Rank.values())
                    .map(rank -> new Card(suit, rank)))
            .collect(Collectors.toList());
    }

    public static enum Suit {
        SPADE("\u2664"),
        CLOVER("\u2667"),
        DIAMOND("\u2662"),
        HEART("\u2661"),
        ;

        @Getter
        private String value;
        private Suit(String value) {
            this.value = value;
        }

        // @Override
        // public String toString() {
        //     return getValue();
        // }
    }

    public static enum Rank {
        ONE("A"),
        TWE("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        ELEVEN("J"),
        TWELVE("Q"),
        THIRTEEN("K"),
        ;

        @Getter
        private String value;
        private Rank(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return getValue();
        }
    }

    @Data
    @AllArgsConstructor
    public static class Card {
        private Suit suit;
        private Rank rank;
    }
}