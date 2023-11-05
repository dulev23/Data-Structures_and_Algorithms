package Aud1.ArrayTester;

import java.util.Arrays;

public class Array<E> {
    private E data[];
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data,size));
    }

    public void insertLast(E o) {
        if (size + 1 > data.length) {
            this.resize();
        }
        data[size++] = o;
    }

    public void insert(int position, E o) {
        if (position >= 0 && position < size) {
            E[] newData = (E[]) new Object[size + 1];
            for (int i = 0; i < position; i++) {
                newData[i] = data[i];
            }

            newData[position] = o;

            for (int i = position; i < size; i++) {
                newData[i + 1] = data[i];
            }
            data = newData;
            size++;
        }
    }

    public void set(int position, E o) {
        if (position >= 0 && position < size)
            data[position] = o;
    }

    public E get(int position) {
        if (position >= 0 && position < size) {
            return data[position];
        }
        return null;
    }

    public int find(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public void delete(int position) {
        if (position >= 0 && position < size) {
            E[] newData = (E[]) new Object[size - 1];
            for (int i = 0; i < position; i++) {
                newData[i] = data[i];
            }
            for (int i = position + 1; i < size; i++) {
                newData[i - 1] = data[i];
            }
            data = newData;
            size--;
        }
    }

    public void resize() {
        E[] newData = (E[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    public static void main(String[] args){
        Array<Integer> niza = new Array<>(4);

        niza.insertLast(4);
        System.out.println("Nizata po vmetnuvanje na 4 kako posleden element: ");
        System.out.println(niza.toString());

        niza.insertLast(7);
        niza.insertLast(13);
        System.out.print("Nizata po dodavanje na 7 i 13 kako elementi: ");
        System.out.println(niza.toString());

        niza.insert(1,3);
        System.out.print("Nizata po dodavanje na 3 kako element na pozicija 1: ");
        System.out.println(niza.toString());

        niza.set(2,6);
        System.out.print("Nizata po menuvanje na vrednosta na elementot na pozicija 2 vo 6: ");
        System.out.println(niza.toString());

        niza.delete(0);
        System.out.print("Nizata po brisenje na elementot na pozicija 0: ");
        System.out.println(niza.toString());

        System.out.print("Na pozicija 2 vo nizata sega se naogja: ");
        System.out.println(niza.get(2));
    }
}