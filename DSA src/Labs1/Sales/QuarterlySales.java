package Labs1.Sales;

import java.util.Arrays;

public class QuarterlySales {

    private int numOfSales;
    private int [] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    @Override
    public String toString() {
        return "QuarterlySales{" +
                "numOfSales=" + numOfSales +
                ", revenues=" + Arrays.toString(revenues) +
                ", quarterNo=" + quarterNo +
                '}';
    }

    public int getNumOfSales() {
        return numOfSales;
    }

    public int[] getRevenue() {
        return revenues;
    }

    public int getQuarterNo() {
        return quarterNo;
    }

}
