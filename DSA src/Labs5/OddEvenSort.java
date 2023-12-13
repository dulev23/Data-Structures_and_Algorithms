package Labs5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

    static void sortAscending(int[] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void sortDescending(int[] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void oddEvenSort(int[] a, int arrLength) {
        int[] oddNumbers = new int[arrLength];
        int[] evenNumbers = new int[arrLength];
        int oddIndex = 0, evenIndex = 0;

        for (int i = 0; i < arrLength; i++) {
            if (a[i] % 2 != 0) {
                oddNumbers[oddIndex++] = a[i];
            } else {
                evenNumbers[evenIndex++] = a[i];
            }
        }

        sortAscending(oddNumbers, oddIndex);
        sortDescending(evenNumbers, evenIndex);

        int index = 0;
        for (int i = 0; i < oddIndex; i++) {
            a[index++] = oddNumbers[i];
        }
        for (int i = 0; i < evenIndex; i++) {
            a[index++] = evenNumbers[i];
        }
    }


    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}