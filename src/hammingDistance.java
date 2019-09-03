public class hammingDistance {
    public int hammingDistance(int x, int y){
        int ans = x^y;
        int count = 0 ;
        while(ans != 0){
            if((ans>>1)<<1 != ans)
                count++;
            ans = ans>>1;
        }
        return count;
    }
}
