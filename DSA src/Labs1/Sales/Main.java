package Labs1.Sales;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static SalesPerson salesChampion(SalesPerson [] arr){
        SalesPerson champion = arr[0];
        for (SalesPerson salesPerson : arr){
            if(salesPerson.sumSales(salesPerson) > champion.sumSales(champion)){
                champion=salesPerson;
            }
        }
        return champion;
    }

    public static void table(SalesPerson[] arr) {
        // Print the header
        System.out.println("SP   1   2   3   4   Total");

        for (SalesPerson salesPerson : arr) {
            // Print the name of the salesperson
            System.out.printf("%-7s", salesPerson.getName());

            // Initialize total sales for the salesperson
            int totalSales = 0;

            for (QuarterlySales qs : salesPerson.getQuarters()) {
                int[] revenues = qs.getRevenue();

                // Print sales for each quarter
                for (int s : revenues) {
                    System.out.printf("%5d", s);
                    totalSales += s; // Update total sales
                }
            }

            // Print the total sales for the salesperson
            System.out.printf("%7d\n", totalSales);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson[] arr = new SalesPerson[n];

        for (int i = 0; i < n; i++) {
            input.nextLine(); // Clear the newline character
            String name = input.nextLine();
            QuarterlySales[] quarters = new QuarterlySales[4];

            for (int quarterNo = 0; quarterNo < 4; quarterNo++) {
                int numOfSales = input.nextInt();
                int[] revenues = new int[numOfSales];
                for (int j = 0; j < numOfSales; j++) {
                    revenues[j] = input.nextInt();
                }
                quarters[quarterNo] = new QuarterlySales(numOfSales, revenues, quarterNo + 1);
            }

            arr[i] = new SalesPerson(name, quarters);
        }

        table(arr); // Print the sales summary
        SalesPerson champion = salesChampion(arr);
        System.out.println("\nSALES CHAMPION: " + champion.getName());
    }
}