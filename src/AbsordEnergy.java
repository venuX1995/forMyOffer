import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class AbsordEnergy {
    public static void main(){
        Scanner in = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        while(in.hasNextLine()){
            String line = in.nextLine();
            if(line.isEmpty())
                break;
            arr.add(line);
        }
        int N = Integer.valueOf(arr.get(0));
        String[] energy = arr.get(1).split(" ");
        if(N==1)
            System.out.print(energy[3]);
    }
//    public static int greatestEnergy(int[][][] arr,int[] start,int zs){
//        Stack<int[]> s = new Stack<>();
//        s.add(start);
//        while(!s.isEmpty()){
//            int[] p = s.pop();
//
//        }
//    }
}
