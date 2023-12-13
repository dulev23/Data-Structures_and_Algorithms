package Aud5.Stack;

import Aud1.SLLTester.SLLNode;
import Aud5.Stack.Stack;

public class LinkedStack<E> implements Stack<E> {
    // top e link do prviot jazol ednostrano-povrzanata
    // lista koja sodrzi gi elementite na stekot .
    private SLLNode<E> top;
    int size;
    public LinkedStack() {
    // Konstrukcija na nov, prazen stek.
        top = null;
        size = 0;
    }
    public boolean isEmpty() {
    // Vrakja true ako i samo ako stekot e prazen.
        return (top == null);
    }
    public E peek() {
    // Go vrakja elementot na vrvot od stekot.
        if (top == null)
            return null;
    //            throw new NoSuchElementException();
        return top.element;
    }
    public void clear() {
    // Go prazni stekot.
        top = null;
        size = 0;
    }
    public void push(E x) {
    // Go dodava x na vrvot na stekot.
        top = new SLLNode<E>(x, top);
        size++;
    }
    public int size() {
    // Ja vrakja dolzinata na stekot.
        return size;
    }
    public E pop() {
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (top == null)
            return null;
    //      throw new NoSuchElementException();
        E topElem = top.element;
        size--;
        top = top.succ;
        return topElem;
    }
}
