import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("🎮 Welcome to the WAR Card Game! 🃏");
        System.out.println("------------------------------------");
        System.out.println("Rules of the Game:");
        System.out.println("1. The deck is split evenly between 2 players (26 cards each).");
        System.out.println("2. Each round, both players draw their top card.");
        System.out.println("3. The player with the higher card wins the round and takes both cards.");
        System.out.println("4. If the cards are of equal value, it's WAR!");
        System.out.println("   - Each player places 3 cards face-down and 1 card face-up.");
        System.out.println("   - The face-up cards are compared. Winner takes all cards.");
        System.out.println("   - If it ties again, another WAR begins!");
        System.out.println("5. Game ends when a player runs out of cards or after 100 rounds.");
        System.out.println("6. If 100 rounds pass, the player with the stronger deck (by total card value) wins.");
        System.out.println();
        System.out.println("Let the battle begin! 💥");
        System.out.println("------------------------------------");
        Thread.sleep(5000); // Give player time to read
        new Game();
    }
}
