package Labs1.Sales;

import java.util.Arrays;

public class SalesPerson {

    private String name;
    private QuarterlySales [] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    @Override
    public String toString() {
        return "SalesPerson{" +
                "name='" + name + '\'' +
                ", quarters=" + Arrays.toString(quarters) +
                '}';
    }

    public String getName() {
        return name;
    }

    public QuarterlySales[] getQuarters() {
        return quarters;
    }

    int sumSales(SalesPerson sp){
        int sum=0;
        for (QuarterlySales qs : sp.getQuarters()){
            int[] revenue = qs.getRevenue();
            for (int s : revenue){
                sum+=s;
            }
        }
        return sum;
    }

    SalesPerson salesChampion(SalesPerson [] arr){
        SalesPerson champion = arr[0];
        for (SalesPerson salesPerson : arr){
            if(salesPerson.sumSales(salesPerson)>champion.sumSales(salesPerson)){
                champion=salesPerson;
            }
        }
        return champion;
    }

}
