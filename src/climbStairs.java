public class climbStairs {
    public int climbStairs(int n){
        if(n==0) return 1;
        if(n==1) return 1;

        int tempMinusOne = 1;
        int tempMinusTwo = 1;
        int ans = 0;
        for(int i=2; i<n; i++){
            ans = tempMinusOne + tempMinusTwo;
            tempMinusTwo = tempMinusOne;
            tempMinusOne = ans;
        }

        return ans;
    }
}
