import card.Card;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/// The player class has the following functionalities:
/// Adding a set of card
/// Removing card
/// Checking if the player has cards to player
/// Dealing with Tie Situation
public class Player{

    private final Queue<Card> playerDeck;

    Player(List<Card> cards){
        playerDeck = new LinkedList<>();
        for(Card i : cards){
            playerDeck.offer(i);
        }
    }

    public void addCards(List<Card> card){
        card.forEach(playerDeck::offer);
    }

    public Card removeCard(){
        if(hasNoCards()){
            return null;
        }
        return playerDeck.poll();
    }

    public void removeAllCards(){
        while(!hasNoCards()){
            playerDeck.poll();
        }
    }

    public boolean hasNoCards(){
        return playerDeck.isEmpty();
    }


    public List<Card> getCardsForTie(){
        List<Card> list = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            if(hasNoCards()) return null;
            list.add(playerDeck.poll());
        }

        return list;
    }

    public int getCardCount(){
        return playerDeck.size();
    }

    @Override
    public String toString() {
        return playerDeck.toString();
    }

    public int calculatePowerOfDeck(){
        int power = 0;
        for(Card card : playerDeck){
            power += card.getValue();
        }

        return power;
    }
}
