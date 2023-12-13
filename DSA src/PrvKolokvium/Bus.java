 package PrvKolokvium;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        int ticket = 100,sumVozrasni=N*ticket,sumDeca=M*ticket;
        int sum=sumVozrasni+sumDeca;
        if(M!=0){
            sum-=100;
            System.out.println(Math.max(sumVozrasni,sumDeca));
            System.out.println(sum);
        } else{
            System.out.println(Math.max(sumVozrasni,sumDeca));
            System.out.println(sum);
        }
    }

}
