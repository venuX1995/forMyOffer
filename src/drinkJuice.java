import java.util.Arrays;

public class drinkJuice {
    public static long juice(int[] arr,int out){
        if(arr==null || arr.length==0 || out<=0)
            return -2;
        long sum = 0;
        for(int num:arr)
            sum +=num;
        if(sum<out)
            return -1;
        Arrays.sort(arr);
        long flag = sum - arr.length*arr[0];
        if(flag>=0){
            return arr[0];
        }else{
            long sub = 0;
            if(flag%arr.length==0){
                sub = flag/arr.length;
            }else{
                sub = flag/arr.length+1;
            }
            return arr[0]-sub;
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,1,5,3,2};
        int out = 5;
        long ans = juice(arr,out);
        System.out.print(ans);
    }
}
