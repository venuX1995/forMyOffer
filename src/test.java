import java.math.BigDecimal;
import java.text.DecimalFormat;

public class test {
    public static String makeDrink(int n, int v, double[] a, double[] b){
        double min = Double.MAX_VALUE;
        double sum_a = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, b[i] / a[i]);
            sum_a += a[i];
        }
        double res = min * sum_a;
        if (res > v)
            res = v;
        DecimalFormat df = new DecimalFormat("#.0000");
        return df.format(res);
    }
    public static BigDecimal makeDrink(int n, int v, int[] ratio, int[] mat){
        if(n<=0 || n!=ratio.length || n!=mat.length || v<=0)
            return null;
        BigDecimal ans;
        float rMin = Math.round(mat[0]/ratio[0]*10000)/10000;
        int sum = 0;
        float[] rat = new float[ratio.length];
        for(int i=0;i<ratio.length;i++){
            rat[i] = Math.round(mat[i]/ratio[i]*10000)/10000;
            if(rat[i]<rMin) {
                rMin = rat[i];
            }
            sum += ratio[i];
        }
        float drink = Math.round(sum*rMin*10000)/10000;
        if(drink<v){
            ans = new BigDecimal(String.valueOf(drink)).setScale(4,BigDecimal.ROUND_CEILING) ;
        }else{
            ans = new BigDecimal(String.valueOf(v)).setScale(4,BigDecimal.ROUND_CEILING);
        }
        return ans;
    }
}
