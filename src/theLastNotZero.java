import java.util.Scanner;

public class theLastNotZero {
    public static long get_last_num(int n){
        if (n == 0 || n == 1) {
            return 1;
        }

        long res = 1;
        for (int i = n; i > 1; i--) {
            res *= i;
            while (res % 10 == 0) {
                res /= 10;
            }
            res = res % 100000000;
        }
        return res % 10;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 0;
        if(in.hasNextLine()){
            String line = in.nextLine();
            n = Integer.valueOf(line);
        }
        System.out.print(get_last_num(n));
    }
}
