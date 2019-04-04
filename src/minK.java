import java.util.ArrayList;

public class minK {
    public static void main(String args[]){
        int[] arr = {1,2,5,4,3,6,8,7};
        ArrayList<Integer> test ;
        test = GetLeastNumbers_Solution(arr,8);
        System.out.println(test);
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(input==null||input.length==0||k>input.length || k<1)
            return ans;
        int start = 0;
        int end = input.length-1;
        int index = partition(input,start,end);
        while(index!=k-1){
            if(index<k){
                start = index+1;
            }else{
                end = index-1;
            }
            index = partition(input,start,end);
        }
        for(int i=0;i<=index;i++){
            ans.add(input[i]);
        }
        return ans;
    }
    public static int partition(int[] input,int start,int end){
        if(input==null ||input.length==0||start>end)
            throw new RuntimeException("invalid input");
        int flag=input[start];
        while(start!=end){
            while(input[end]>flag && start<end)
                end--;
            input[start] = input[end];
            while(input[start]<=flag && start<end)
                start++;
            input[end] = input[start];
        }
        input[start] = flag;
        return start;
    }
}
