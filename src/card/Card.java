package card;

public class Card{

    /// Values of each card is as follows :
    /// 2 - 2
    /// 3 - 3
    /// 4 - 4
    /// 5 - 5
    /// 6 - 6
    /// 7 - 7
    /// 8 - 8
    /// 9 - 9
    /// 10 - 10
    /// 11 - Jack
    /// 12 - Queen
    /// 13 - King
    /// 14 - Ace
    private final int value;
    private final CardName cardName;

    public Card(CardName cardName, int value){
        this.value = value;
        this.cardName = cardName;
    }

    public int getValue() {
        return this.value;
    }

    public CardName getCardName() {
        return cardName;
    }

    public int compareTo(Card o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return getValueString() + " of " + cardName.toString();
    }

    public String getValueString(){
        if(this.value == 11){
            return "Jack";
        } else if(this.value == 12){
            return "Queen";
        } else if(this.value == 13){
            return "King";
        } else if(this.value == 14){
            return "Ace";
        } else{
            return Integer.toString(this.value);
        }
    }
}
