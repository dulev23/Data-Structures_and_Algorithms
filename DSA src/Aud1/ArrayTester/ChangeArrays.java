package Aud1.ArrayTester;

public class ChangeArrays<E> {
    public void compareAndChangeArrays(Array<E> niza1, Array<E> niza2) {
        if (niza1.getSize() != niza2.getSize()) {
            System.out.println("Nizite ne se so ista golemina!");
            return;
        }
        int size = niza1.getSize();
        int i = 0;
        while (i<size){
            if(niza1.get(i).equals(niza2.get(i))){
                niza1.delete(i);
                niza2.delete(i);
                size--;
            }else{
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Array<String> niza1 = new Array<>(4);
        niza1.insertLast("nb11");
        niza1.insertLast("b1");
        niza1.insertLast("b2");
        niza1.insertLast("nb12");

        Array<String> niza2 = new Array<>(4);
        niza2.insertLast("nb21");
        niza2.insertLast("b1");
        niza2.insertLast("b2");
        niza2.insertLast("nb22");

        System.out.println("Nizite pred primenuvanjeto na funkcijata: ");
        System.out.println(niza1.toString());
        System.out.println(niza2.toString());

        ChangeArrays<String> pom = new ChangeArrays<>();
        pom.compareAndChangeArrays(niza1,niza2);

        System.out.println("Nizite po primenuvanjeto na funkcijata: ");
        System.out.println(niza1.toString());
        System.out.println(niza2.toString());
    }
}