package Labs3.Zadaca2;
import java.util.Scanner;

public class CountWordPairs {

    //TODO: implement function
    public static int countWordPairs(String [] words) {
        int pairs=0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++){
                String word1 = words[i];
                String word2 = words[j];
                if(word1.charAt(0) == word2.charAt(0)){
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        String words[] = new String[N];

        for(int i=0;i<N;i++) {
            words[i] = input.next();
        }

        System.out.println(countWordPairs(words));
    }
}