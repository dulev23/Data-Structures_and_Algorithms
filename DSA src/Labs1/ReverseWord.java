package Labs1;

import java.util.Scanner;

public class ReverseWord {
    public static void printReversed(String word) {
        String reverse =" ";
        char ch;
        for (int i =0;i<word.length();i++){
            ch = word.charAt(i);
            reverse=ch+reverse;
        }
        System.out.println(reverse);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        for (int i = 0; i < n; i++) {
            printReversed(arr[i]);
        }
    }
}
