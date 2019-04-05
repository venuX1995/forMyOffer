public class HeapSort {
    private static int[] buildMaxHeap(int[] arr){
        int length = arr.length;
        for(int i =(length-2)/2;i>=0;i--){
            modifyToMaxHeap(arr,i,length);
        }
        return arr;
    }
    private static void modifyToMaxHeap(int[] arr, int k, int length){
        int flag = arr[k];
        for(int i=2*k+1;i<length;i=2*i+1){
            if(i<length-1 && arr[i]<arr[i+1])
                i++;
            if(flag>=arr[i]){
                break;
            }else{
                arr[k] = arr[i];
                k = i;
            }
        }
        arr[k] = flag;
    }
    private static void Heapsort(int[] arr){
        buildMaxHeap(arr);
        for(int i=arr.length-1;i>=1;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            modifyToMaxHeap(arr,0,i);
        }
    }
    public static void main(String[] args){
        int[] arr = {1,4,2,7,8,3,9,43,25,66};
        Heapsort(arr);
        for(int num:arr){
            System.out.println(num);
        }

    }
}
