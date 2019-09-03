public class Rob {
    public int rob(int[] nums){
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];

        int moneyMinusTwo = nums[0];
        int moneyMinusOne = Math.max(nums[0],nums[1]);
        int ans = Math.max(moneyMinusOne,moneyMinusTwo);

        for(int i=2; i<nums.length; i++){
            ans = Math.max(moneyMinusOne, nums[i]+moneyMinusTwo);
            moneyMinusTwo = moneyMinusOne;
            moneyMinusOne = ans;
        }

        return ans;
    }
}
