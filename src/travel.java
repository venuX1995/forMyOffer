import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class travel {

        public static void travel(int[][] distance){
            int b=(int)Math.pow(2,distance.length-1);
            int n = distance.length;
            int[][] F = new int[n][b];
            for(int i=0;i<b;i++){
                for(int j=0;j<n;j++) {
                    F[j][i] = -1;
                }
            }

            for(int i=0;i<n;i++){
                F[i][0] = distance[i][0];
            }

            for(int i=1;i<b-1;i++)
                for(int j=1;j<n;j++) {
                    if( ((int)Math.pow(2,j-1) & i) == 0)
                    {
                        int min = Integer.MAX_VALUE;
                        for(int k=1;k<n;k++)
                            if(((int)Math.pow(2,k-1) & i )!=0)
                            {
                                int temp = distance[j][k] + F[k][i-(int)Math.pow(2,k-1)];
                                if(temp < min) {
                                    min = temp;
                                    F[j][i] = min;
                                }
                            }
                    }
                }

            int min = Integer.MAX_VALUE;
            for(int k=1;k<n;k++) {
                int temp = distance[0][k] + F[k][b-1 - (int)Math.pow(2,k-1)];
                if(temp < min) {
                    min = temp;
                    F[0][b-1] = min;
                }
            }
            //总最优解
            System.out.println(F[0][b-1]);
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            List<int[]> allArray = new LinkedList<>();
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.isEmpty())
                    break;
                String[] strs = line.split(" ");
                int[] numArray = new int[strs.length];
                for (int j = 0; j < strs.length; j++) {
                    numArray[j] = Integer.valueOf(strs[j]);
                }
                allArray.add(numArray);
            }
            int row = allArray.size()-1;   //行
            int col = allArray.get(1).length;  //列
            int[][] distance = new int[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    distance[i][j] = allArray.get(i+1)[j];
                }
            }
            travel(distance);

        }
}
