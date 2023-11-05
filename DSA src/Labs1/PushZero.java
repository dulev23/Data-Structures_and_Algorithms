package Labs1;

import java.util.Scanner;

public class PushZero {
    static void pushZerosToBeginning(int[] arr, int n) {
        int count = n - 1;
        for (int i = count; i >= 0; i--) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        pushZerosToBeginning(arr, n);

        System.out.println("Transformiranata niza e: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}