import java.util.HashMap;

public class twoSum {
    public int[] twoSum(int[] nums, int target){
        if(nums.length == 0)
            return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=1; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                ans[0] = map.get(nums[i]);
                ans[1] = i;
            }else{
                map.put(target-nums[i],i);
            }
        }
        return ans;
    }

    public static void main(String[] args){

    }
}
