import card.Card;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

@SuppressWarnings("BusyWait")
public class Game {
    Game() throws InterruptedException {
        Deck deck = new Deck();
        List<List<Card>> cards = deck.deal();
        Player player1 = new Player(cards.get(0));
        Player player2 = new Player(cards.get(1));
        System.out.println("Card in Player 1's deck : " + player1.getCardCount());
        System.out.println("Card in Player 2's deck : " + player2.getCardCount());
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("Player Decks created Successfully");
        int rounds = 1;

        System.out.println("Player 1 has card : " + !player1.hasNoCards());
        System.out.println("Player 2 has card : " + !player2.hasNoCards());
        // Game start here
        while(!player1.hasNoCards() && !player2.hasNoCards()){
            System.out.println("----Round " + rounds + "----");
            // create a list of cards for player using a list
            // to handle ties as well for inserting
            List<Card> cardsPile = new ArrayList<>();

            Card player1TopCard = player1.removeCard();
            Card player2TopCard = player2.removeCard();
            System.out.println("Player 1 Played : " + player1TopCard.toString());
            System.out.println("Player 2 Played : " + player2TopCard.toString());

            // add the top cards to the pile
            cardsPile.add(player1TopCard);
            cardsPile.add(player2TopCard);

            // Check if tie or not
            int isTied = getWinner(player1TopCard, player2TopCard);
            sleep(2000);
            if(isTied > 0){
                System.out.println("Player 1 won the round");
                // Player 1 has won
                player1.addCards(cardsPile);
            } else if(isTied < 0){
                System.out.println("Player 2 won the round");
                // Player 2 has won
                player2.addCards(cardsPile);
            } else{
                System.out.println("It is a tie");
                System.out.println("Players are going to war");
                System.out.println("Fighting");
                sleep(4000);
                // It is a tie
                boolean isTie = true;
                // Continue until one of the face up card has won
                while(isTie){
                    List<Card> player1TiedCards = player1.getCardsForTie();
                    List<Card> player2TiedCards = player2.getCardsForTie();

                    if(player1TiedCards == null){
                        // since player 1 does not have 4 cards, clear the deck for player 2
                        player2.addCards(cardsPile);
                        player1.removeAllCards();
                        System.out.println("Player 1 has no more cards to play");
                        break;
                    } else if(player2TiedCards == null){
                        // since player 2 does not have 4 cards, clear the deck for player 2
                        player1.addCards(cardsPile);
                        player2.removeAllCards();
                        System.out.println("Player 2 has no more cards to play");
                        break;
                    } else {

                        // both have 4 cards to play the war
                        cardsPile.addAll(player1TiedCards);
                        cardsPile.addAll(player2TiedCards);

                        // get the last card for both the player (The Face Up card)
                        Card player1LastCard = player1TiedCards.get(3);
                        Card player2LastCard = player2TiedCards.get(3);
                        System.out.println("Player 1 and Player 2 have put 4 of their cards down");
                        System.out.println("Player 1's face up card is : " + player1LastCard.toString());
                        System.out.println("Player 2's face up card is : " + player2LastCard.toString());
                        sleep(4000);

                        int currentWinner = getWinner(player1LastCard, player2LastCard);
                        if(currentWinner < 0){
                            System.out.println("Player 2 won the war, all cards are added to his deck");
                            // player 2 has won the war
                            player2.addCards(cardsPile);
                            // end the war for the next moves
                            isTie = false;
                        } else if(currentWinner > 0){
                            System.out.println("Player 1 won the war, all cards are added to his deck");
                            // same as the if statement
                            player1.addCards(cardsPile);
                            isTie = false;
                        }
                    }
                    if(isTie){
                        System.out.println("It's a tie again, We go again to WAR!");
                    }
                    sleep(2000);
                }
            }
            if(rounds == 100){
                System.out.println("Players have reached 100 rounds");
                System.out.println("Deciding winner by power of each player");
                sleep(2000);
                // Games end with the person with the most power in his deck
                int player1Power = player1.calculatePowerOfDeck();
                int player2Power = player2.calculatePowerOfDeck();
                System.out.println("Power of player 1 : " + player1Power);
                System.out.println("Power of player 2 : " + player2Power);
                if(player1Power > player2Power){
                    player2.removeAllCards();
                } else if(player2Power > player1Power){
                    player1.removeAllCards();
                }else{
                    // it's a tie in power as well
                    player1.removeAllCards();
                    player2.removeAllCards();
                }
                break;
            }
            rounds++;
            sleep(2000);
        }

        // Get the winner by checking which player has no more cards to play
        String winner = player1.hasNoCards() && player2.hasNoCards()  ?
                "It is a Tie (Very very rare)" : player1.hasNoCards() ?
                "Player 2 has won" : "Player 1 has won";

        System.out.println(winner);
        System.out.println("Game Ended");
    }

    public int getWinner(Card card1, Card card2){
        return card1.compareTo(card2);
    }
}
