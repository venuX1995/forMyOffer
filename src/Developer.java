import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Developer {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
//        ArrayList<ArrayList<Integer>> arrlist = new ArrayList<>();
//        ArrayList<Integer> eachLine = new ArrayList<>();
//        String line;
//        while(!(line=in.nextLine()).equals("")){
//            String[] str = line.split(" ");
//            for(int i=0;i<str.length;i++){
//                eachLine.add(Integer.valueOf(str[i]));
//                System.out.print(eachLine.get(eachLine.size()-1));
//            }
//            arrlist.add(eachLine);
//            eachLine.clear();
//        }
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
        int row = allArray.size();   //行
        int col = allArray.get(0).length;  //列
        int[] arrInput = new int[row*col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                arrInput[i*row+j]=allArray.get(i)[j];
        }
        System.out.print(minCounts(arrInput,row,col));
    }
    public static int minCounts(int[] arrInput,int row,int col){
        int count = 0;
        int countOfOne = arrInput.length;
        while(countOfOne!=0 ){
            boolean[] isModified = new boolean[arrInput.length];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(arrInput[i*row+j]!=1 && isModified[i*row+j]==false)
                        countOfOne--;
                    if(arrInput[i*row+j]==2 && isModified[i*row+j]==false){
                        set(arrInput,row,col,i,j,isModified,countOfOne);
                    }
                }
            }
            count += 1;
        }
        return count;
    }
    public static void set(int[] input,int row,int col,int i,int j,boolean[] modified,int countOfOne){
        if(countOfOne<=0)
            return;
        if(i+1<row && j<col && input[(i+1)*row+j] == 1 ){
            input[(i+1)*row+j]=2;
            countOfOne -=1;
            modified[(i+1)*row+j] = true;
        }
        if(i-1<row && i-1>=0 && j<col && input[(i-1)*row+j] == 1){
            input[(i-1)*row+j]=2;
            countOfOne -=1;
            modified[(i-1)*row+j] = true;
        }
        if(i<row && j+1<col && input[(i)*row+j+1] == 1){
            input[(i)*row+j+1]=2;
            countOfOne -= 1;
            modified[(i)*row+j+1] = true;
        }
        if(i<row && j-1<col && j-1>=0 && input[(i)*row+j-1] == 1){
            input[(i)*row+j-1]=2;
            countOfOne -= 1;
            modified[(i)*row+j-1] = true;
        }
        return;
    }
}
