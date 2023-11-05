package Labs2.Zadaca3;

import java.util.Scanner;

public class MysticalCardGame {

    //TODO: implement function
    public static void startDuel(SLL<Card> firstSorcererCards, SLL<Card> secondSorcererCards) {
        SLLNode<Card> current = firstSorcererCards.getFirst();
        SLLNode<Card> previous = null;

        int largestPower = -1;
        while (current != null) {
            int power = current.element.getMagicPower() * current.element.getHealth();
            if (power > largestPower) {
                largestPower = power;
                previous = current;
            }

            current = current.succ;
        }

        if (previous != null) {
            Card card = firstSorcererCards.delete(previous);

            SLLNode<Card> midNode = secondSorcererCards.getFirst();
            int halfNodeSize = secondSorcererCards.size();
            for (int i = 0; i < halfNodeSize / 2; i++) {
                midNode = midNode.succ;
            }
            secondSorcererCards.insertBefore(card, midNode);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLL<Card> firstSorcererCards = new SLL<Card>();
        SLL<Card> secondSorcererCards = new SLL<Card>();

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            firstSorcererCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            secondSorcererCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        startDuel(firstSorcererCards, secondSorcererCards);
        System.out.println(firstSorcererCards);
        System.out.println(secondSorcererCards);
    }
}