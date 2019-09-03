import java.util.ArrayList;
import java.util.List;

public class findDisappearNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if((nums[i] != i+1) && (nums[nums[i]-1] != nums[i])){
                int p = i;
                int temp = nums[i];
                while(temp != p+1){
                    p = temp - 1;
                    temp = nums[p];
                    nums[p] = p+1;
                }
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1)
                ans.add(i+1);
        }
        return ans;
    }
    public static void main(String[] args){
        List<Integer> ans = new ArrayList<>();
        int[] nums = {4,3,2,7,8,2,3,1};
        ans = findDisappearedNumbers(nums);
        for(int index:ans)
            System.out.print(index);
    }
}
