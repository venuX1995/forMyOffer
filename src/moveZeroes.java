public class moveZeroes {
    public void moveZeroes(int[] nums){
        if(nums.length == 0 || nums.length == 1)
            return;
        int p = 0;
        for(int num:nums){
            if(num != 0){
                nums[p] = num;
                p++;
            }
        }
        for(int i=p; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}
