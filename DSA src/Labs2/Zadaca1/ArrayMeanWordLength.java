package Labs2.Zadaca1;

import java.util.Scanner;

public class ArrayMeanWordLength {

    //TODO: implement function
    public static String wordClosestToAverageLength(Array<String> arr) {
        int total=0;
        for (int i=0; i<arr.getSize();i++){
            total+=arr.get(i).length();
        }
        double average = (double) total/arr.getSize();

        String closestWord = arr.get(0);
        double closestDistance = Math.abs(arr.get(0).length() - average);

        for (int i=0; i<arr.getSize();i++){
            String word = arr.get(i);
            double distance = Math.abs(word.length() - average);
            if(distance < closestDistance){
                closestWord = word;
                closestDistance = distance;
            }
        }
        return closestWord;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        Array<String> arr = new Array<>(N);
        input.nextLine();

        for(int i=0;i<N;i++) {
            arr.insertLast(input.nextLine());
        }

        System.out.println(wordClosestToAverageLength(arr));
    }
}
