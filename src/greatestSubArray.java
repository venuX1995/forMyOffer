public class greatestSubArray {
    public static int FindGreatestSumOfSubArray(int[] arr){
        if(arr == null || arr.length == 0)
            return -1;
        int ansSum = arr[0];
        int nowSum = arr[0];
        for(int i=1;i<arr.length;i++){
            if((arr[i]+nowSum)<arr[i]){
                nowSum = arr[i];
            }else{
                nowSum += arr[i];
            }
            ansSum = ansSum>nowSum?ansSum:nowSum;
        }
        return ansSum;
    }
    public static void main(String[] args){
        int[] arr1 = {-3,-6,-2,-6,-3,-8,-9};//-3
        int[] arr2 = {1,2,3,4,5,6,7,8};//36
        int[] arr3 = {-1,-3,2,-9,15,1};//16
        System.out.print(FindGreatestSumOfSubArray(arr1));
        System.out.print(FindGreatestSumOfSubArray(arr2));
        System.out.print(FindGreatestSumOfSubArray(arr3));
    }
}
