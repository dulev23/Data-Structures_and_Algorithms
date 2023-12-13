package Aud6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();

    // Vrakja true ako i samo ako redicata e prazena.
    public int size();

    // Ja vrakja dolzinata na redicata.
    public E peek();

    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
    // Metodi za transformacija:
    public void clear();

    // Ja prazni redicata.
    public void enqueue(E x);

    // Go dodava x na kraj od redicata.
    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}

class ArrayQueue<E> implements Queue<E> {
    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public void clear() {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0; // arbitrary
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            return null;
        //      throw new NoSuchElementException();
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}

interface Stack<E> {
    // Elementi na stekot se objekti od proizvolen tip.
// Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako stekot e prazen.
    public E peek();
    // Go vrakja elementot na vrvot od stekot.
// Metodi za transformacija:
    public void clear();
    // Go prazni stekot.
    public void push(E x);
    // Go dodava x na vrvot na stekot.
    public E pop();
// Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {
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
public class card_trick {
    public static int count(int N) {
        Queue<Integer> cards = new ArrayQueue<>(51);
        Stack<Integer> shuffle = new ArrayStack<>(7);

        for (int i = 0; i <= 51; i++)
            cards.enqueue(i);
        int totalNumShuffles = 0;

        while(cards.peek() != N){
            for (int i = 0; i < 7; i++)
                shuffle.push(cards.dequeue());

            while(!shuffle.isEmpty()){
                cards.enqueue(shuffle.pop());
                cards.enqueue(cards.dequeue());
            }
            totalNumShuffles++;
        }
        return totalNumShuffles;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine());
    }
}