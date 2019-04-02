public class topK {
    public static int partition(int[] arr,int start,int end){
        if(arr == null||arr.length==0 ||start >=end)
            throw new RuntimeException("无效输入!");
        int flag = arr[start];
        int i = start;
        int j = end;
        while(i<j){
            while(arr[j]>=flag && i<j)
                j--;
//            if(arr[j]<flag){
            arr[i]=arr[j];
//                i++;
//            }
            while(arr[i]<flag && i<j)
                i++;
            if(arr[i]>=flag){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = flag;
        return i;
    }

    public static void main(String args[]){
        int[] arr = {6,1,4,2,7,9,2,5};
        int k = 3;
        int start = 0;
        int end = arr.length-1;
        int index = partition(arr,start,end);
        while(k!=index){
            if(k<index){
                end = index - 1;
            }else{
                start = index + 1;
            }
            index = partition(arr,start,end);
        }
        System.out.println(arr[k]);
    }
}
