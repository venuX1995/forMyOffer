import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {
    public static long fibonacci(int n){
        long ans = 0;
        if(n<0)
            return -1;
        if(n==0 || n==1)
            return 1;
        long preOne = 1;
        long preTwo = 1;
        for(int i=2;i<=n;i++){
            ans = preOne+preTwo;
            preTwo = preOne;
            preOne = ans;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        while(in.hasNextLine()){
            String line = in.nextLine();
            if(line.isEmpty())
                break;
            arr.add(Integer.valueOf(line));
        }
        for(int test:arr){
            System.out.print(fibonacci(test)+"\n");
        }
    }
}
