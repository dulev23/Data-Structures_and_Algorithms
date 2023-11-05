package Labs2.Zadaca2;

import java.util.Scanner;

public class SpecialSLLDelete<E> {

    //TODO: implement method
    public void specialDelete(SLL<E> list, int m) {
        SLLNode<E> current = list.getFirst();
        SLLNode<E> previous = null;
        int counter = 1;

        while(current!=null){
            if(counter%m==0){
                list.delete(current);
                current=previous;
            }
            previous=current;
            current=current.succ;
            counter++;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        SLL<Integer> list = new SLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        int m = input.nextInt();

        SpecialSLLDelete<Integer> tmp = new SpecialSLLDelete<>();

        tmp.specialDelete(list, m);

        System.out.println(list);
    }
}
