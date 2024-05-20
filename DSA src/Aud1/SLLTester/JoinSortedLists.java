package Aud1.SLLTester;

public class JoinSortedLists<E extends Comparable<E>> {
    public SLL<E> join(SLL<E> firstList, SLL<E> secondList) {
        SLL<E> rezultat = new SLL<E>();
        SLLNode<E> node1 = firstList.getFirst();
        SLLNode<E> node2 = secondList.getFirst();

        while (node1 != null && node2 != null) {
            if (node1.element.compareTo(node2.element) < 0) {
                rezultat.insertLast(node1.element);
                node1 = node1.succ;
            } else {
                rezultat.insertLast(node2.element);
                node2 = node2.succ;
            }
        }

        if (node1 != null) {
            while (node1 != null) {
                rezultat.insertLast(node1.element);
                node1 = node1.succ;
            }
        }

        if (node2 != null) {
            while (node2 != null) {
                rezultat.insertLast(node2.element);
                node2 = node2.succ;
            }
        }

        return rezultat;
    }

    public static void main(String[] args) {
        SLL<String> lista1 = new SLL<String>();
        lista1.insertLast("Ana");
        lista1.insertLast("Bojana");
        lista1.insertLast("Dejan");

        SLL<String> lista2 = new SLL<String>();
        lista2.insertLast("Andrijana");
        lista2.insertLast("Biljana");
        lista2.insertLast("Darko");

        JoinSortedLists<String> js = new JoinSortedLists<>();
        System.out.println(js.join(lista1, lista2));
    }
}
