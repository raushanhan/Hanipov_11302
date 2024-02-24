import java.util.Scanner;

public class Task01Better {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();
        int p = sc.nextInt();

        double res = 1;
        for (int i = 0; i < p; i++) {
            res *= x;
        }



    }
}