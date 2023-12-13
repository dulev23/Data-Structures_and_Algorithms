package Aud5.Stack;
import Aud5.Stack.Stack;

public class ArrayStack<E> implements Stack<E> {
    private E[] elems; //elems[0...depth-1] se negovite elementi.
    private int depth; //depth e dlabochinata na stekot

    public ArrayStack(int maxDepth) {
    // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth=0;
    }

    public boolean isEmpty() {
    // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }

    public E peek() {
    // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            return null;
    //      throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
    // Go prazni stekot.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
    // Go dodava x na vrvot na stekot.
        if(depth<elems.length)
            elems[depth++] = x;
    }

    public int size() {
    // Ja vrakja dolzinata na stack-ot.
        return depth;
    }

    public E pop() {
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            return null;
    //      throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}