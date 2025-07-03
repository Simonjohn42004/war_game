import card.Card;
import card.CardName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    Deck(){
        cards = generateCards();
    }

    private List<Card> generateCards(){
        List<Card> cards = new ArrayList<>();
        for(CardName cardName : CardName.values()){
            for(int i = 2; i <= 14; i++){
                Card newCard = new Card(cardName, i);
                cards.add(newCard);
            }
        }
        shuffle(cards);
        return cards;
    }


    private void shuffle(List<Card> cards){
        Collections.shuffle(cards);
    }




    public List<List<Card>> deal() {
        List<Card> firstHalf = new ArrayList<>(cards.subList(0, 26));
        List<Card> secondHalf = new ArrayList<>(cards.subList(26, 52));
        return List.of(firstHalf, secondHalf);
    }

}