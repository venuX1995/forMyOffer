public class moreThanHalf {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null || array.length==0)
            return 0;
        if(array.length == 1)
            return array[0];
        int k = array.length/2;
        int target = topK(array,0,array.length-1,k);
        return freqMoreThanHalf(array,target);
    }
    public int partition(int[] arr,int start,int end){
        if(arr==null || arr.length ==0)
            throw new RuntimeException("invalid input");
        int flag = arr[start];
        while(start<end){
            while(arr[end]>flag && start<end)
                end--;
            arr[start] = arr[end];
            while(arr[start]<=flag && start<end)
                start++;
            arr[end] = arr[start];
        }
        arr[start] = flag;
        return start;
    }
    public int topK(int[] arr,int head,int tail,int k){
        if(arr==null || arr.length ==0 ||head>tail)
            throw new RuntimeException("invalid input");
        int index = partition(arr,head,tail);
        while(index!=k){
            if(index<k){
                head = index+1;
            }else{
                tail = index-1;
            }
            index = partition(arr,head,tail);
        }
        return arr[index];
    }
    public int freqMoreThanHalf(int[] arr,int flag){
        int count = 0;
        for(int num:arr){
            if(num==flag){
                count++;
            }else{
                count--;
            }
        }
        return count>0?flag:0;
    }
}
