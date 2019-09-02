public class maxSubArray {
    public int maxSubArray(int[] nums){
        if(nums.length == 0)
            return -1;
        int maxNow = nums[0];
        int ans = nums[0];
        for(int i=1; i<nums.length; i++){
            if(maxNow > 0){
                maxNow += nums[i];
            }else{
                maxNow = nums[i];
            }
            ans = Math.max(ans,maxNow);
        }
        return ans;
    }
}
