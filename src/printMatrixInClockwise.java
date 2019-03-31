import java.util.ArrayList;
public class printMatrixInClockwise {
    public ArrayList<Integer> printInClockwise(int[][] arr){
        if(arr == null)
            throw new RuntimeException("invalid input");
        int rows = arr.length; //获取行数
        int cols = arr[0].length; //获取列数
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        while(count*2 <rows && count*2 <cols){
            ans = addMatrixInCircle(ans,count,arr,rows,cols);
            count++;
        }
        return ans;
    }
    public ArrayList<Integer> addMatrixInCircle(ArrayList<Integer> ans, int start, int[][] arr,int row,int col){
        int endRow = row-start-1;
        int endCol = col-start-1;
        for(int i=start;i<=endCol;i++){
            ans.add(arr[start][i]);
        }
        if(start<endRow && start<endCol){
            for(int i=start;i<=endRow;i++){
                ans.add(arr[i][endCol]);
            }
        }
        if(start<endCol && start<endRow){
            for(int i=endCol-1;i>=start;i--){
                ans.add(arr[endRow][i]);
            }
        }
        if(start<endRow-1 && start<endCol){
            for(int i=endRow-1;i>start+1;i--){
                ans.add(arr[i][start]);
            }
        }
        return ans;
    }
}
