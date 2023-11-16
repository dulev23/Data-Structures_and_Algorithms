package Aud4;

public class Power {
    public static int power(int x, int k) { //linearna kompleksnost
        if (k == 0) return 1;
        else if (k % 2 == 0)
            return power(x, (k / 2)) * power(x, (k / 2));
        else
            return power(x, (k / 2)) * power(x, (k / 2)) * x;
    }

    public static int power2(int x, int k) { //logaritamska kompleksnost
        int result;
        if (k == 0) return 1;
        else if (k % 2 == 0) {
            result = power(x, (k / 2));
            return result * result;
        } else {
            result = power(x, (k / 2));
            return result * result * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(power(3, 2));
        System.out.println(power2(3,2));
    }
}
