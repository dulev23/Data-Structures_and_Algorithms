package Labs4.Zadaca1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {

    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char[] c, int l, int r) {
        if (l == r) {
            return c[l] + '0';
        }

        int zagradi = 0, index = 1;
        for (int i = l; i < r; i++) {
            if (c[i] == '(') {
                zagradi++;
            } else if (c[i] == ')') {
                zagradi--;
            }

            if ((c[i] == '+' || c[i] == '-') && zagradi == 0) {
                index = i;
            }
        }

        if (index == 1) {
            return presmetaj(c, l + 1, r - 1);
        }

        if (c[index] == '+') {
            return presmetaj(c, l, index - 1) + presmetaj(c, index + 1, r);
        }
        if (c[index] == '-') {
            return presmetaj(c, l, index - 1) - presmetaj(c, index + 1, r);
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char[] exp = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length - 1);
        System.out.println(rez);

        br.close();

    }

}