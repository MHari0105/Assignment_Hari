import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Card {
    private final String suit;
    private final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}

class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
}

class Hand {
    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateScore() {
        int score = 0;
        int numAces = 0;

        for (Card card : cards) {
            String rank = card.getRank();
            if (rank.equals("Ace")) {
                numAces++;
                score += 11;
            } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
                score += 10;
            } else {
                score += Integer.parseInt(rank);
            }
        }

        while (score > 21 && numAces > 0) {
            score -= 10;
            numAces--;
        }

        return score;
    }

    public void clear() {
        cards.clear();
    }

    public List<Card> getCards() {
        return cards;
    }
}

public class BlackjackGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        while (true) {
            // Display hands and score
            System.out.println("Your hand: " + playerHand.getCards() + " (Score: " + playerHand.calculateScore() + ")");
            System.out.println("Dealer's hand: " + dealerHand.getCards().get(0));

            // Check for blackjack
            if (playerHand.calculateScore() == 21) {
                System.out.println("Blackjack! You win!");
                break;
            } else if (dealerHand.calculateScore() == 21) {
                System.out.println("Dealer has blackjack. You lose.");
                break;
            }

            // Player's turn
            System.out.print("Do you want to (H)it or (S)tand? ");
            String choice = scanner.next().toUpperCase();
            if (choice.equals("H")) {
                playerHand.addCard(deck.drawCard());
                if (playerHand.calculateScore() > 21) {
                    System.out.println("Bust! You lose.");
                    break;
                }
            } else if (choice.equals("S")) {
                // Dealer's turn
                while (dealerHand.calculateScore() < 17) {
                    dealerHand.addCard(deck.drawCard());
                }

                System.out.println("Dealer's hand: " + dealerHand.getCards() + " (Score: " + dealerHand.calculateScore() + ")");
                if (dealerHand.calculateScore() > 21) {
                    System.out.println("Dealer busts! You win!");
                } else if (dealerHand.calculateScore() > playerHand.calculateScore()) {
                    System.out.println("Dealer wins.");
                } else if (dealerHand.calculateScore() < playerHand.calculateScore()) {
                    System.out.println("You win!");
                } else {
                    System.out.println("It's a tie!");
                }
                break;
            }
        }

        scanner.close();
    }
}
