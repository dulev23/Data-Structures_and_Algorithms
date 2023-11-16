package Labs3.Zadaca1;

import java.util.Scanner;

public class DLLBattalion {

    //TODO: implement function
    public static void battalion(DLL<Integer> list, int a, int b) {
        DLLNode<Integer> nodeA = list.find(a);
        DLLNode<Integer> nodeB = list.find(b);

        if (nodeA == list.getFirst() && nodeB == list.getLast()) {
            list.mirror();
        } else {
            DLL<Integer> tempList = new DLL<>();
            DLLNode<Integer> current = nodeA;

            while (current != nodeB.succ) {
                tempList.insertFirst(current.element);
                current = current.succ;
            }

            current = nodeA;

            while (tempList.getFirst() != null) {
                current.element = tempList.deleteFirst();
                current = current.succ;
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(input.nextInt());
        }

        int a = input.nextInt();
        int b = input.nextInt();

        battalion(list, a, b);

        System.out.println(list);
        System.out.println(list.toStringR());

    }
}