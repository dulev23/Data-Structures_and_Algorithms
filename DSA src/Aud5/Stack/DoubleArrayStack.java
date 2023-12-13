package Aud5.Stack;

public class DoubleArrayStack<E> {
    private E[] elements;
    private int depth1;
    private int depth2;

    public DoubleArrayStack(int maxDepth) {
        elements = (E[]) new Object[maxDepth];
        depth1 = 0;
        depth2 = 0;
    }

    public boolean isFull() {
        return (depth1 + depth2) == elements.length;
    }

    public boolean isEmptyFirst() {
        return (depth1 == 0);
    }

    public boolean isEmptySecond() {
        return (depth2 == 0);
    }

    public void clearFirst() {
        for (int i = 0; i < depth1; i++) elements[i] = null;
        depth1 = 0;
    }

    public void clearSecond() {
        for (int i = elements.length - 1; i > elements.length - depth2; i--) elements[i] = null;
        depth2 = 0;
    }

    public E peekFirst() {
        // Go vrakja elementot na vrvot od stekot.
        if (depth1 == 0)
            return null;
        //      throw new NoSuchElementException();
        return elements[depth1 - 1];
    }

    public E peekSecond() {
        // Go vrakja elementot na vrvot od stekot.
        if (depth2 == 0)
            return null;
        //      throw new NoSuchElementException();
        return elements[elements.length - depth2];
    }

    public void pushFirst(E x) {
        if (!isFull())
            elements[depth1++] = x;
    }

    public void pushSecond(E x) {
        if (!isFull())
            elements[elements.length - (++depth2)] = x;
    }

    public E popFirst() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth1 == 0)
            return null;
        //      throw new NoSuchElementException();
        E topmost = elements[--depth1];
        elements[depth1] = null;
        return topmost;
    }

    public E popSecond() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth2 == 0)
            return null;
        //      throw new NoSuchElementException();
        E topmost = elements[elements.length - depth2];
        elements[depth2] = null;
        return topmost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E element : elements)
            sb.append(element).append(" ");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleArrayStack<Integer> doubleArrayStack = new DoubleArrayStack<Integer>(7);

        doubleArrayStack.pushFirst(1);
        doubleArrayStack.pushFirst(2);
        doubleArrayStack.pushFirst(3);
        doubleArrayStack.pushSecond(-1);
        doubleArrayStack.pushSecond(-2);
        doubleArrayStack.pushSecond(-3);

        System.out.println("Vrv na prv: " + doubleArrayStack.peekFirst() + ", dolzina na prv: " + doubleArrayStack.depth1);
        System.out.println("Vrv na vtor: " + doubleArrayStack.peekSecond() + ", dolzina na vtor: " + doubleArrayStack.depth2);

        doubleArrayStack.pushSecond(-4);
        doubleArrayStack.popSecond( );
        doubleArrayStack.pushSecond(-4);

        System.out.println("Vrv na prv: " + doubleArrayStack.peekSecond() + ", dolzina na vtor: " + doubleArrayStack.depth2);

        doubleArrayStack.toString();

    }
}
