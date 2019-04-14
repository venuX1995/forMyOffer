import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Ratio {
    public static BigDecimal makeDrink(int n, int v, int[] ratio, int[] mat){
        if(n<=0 || n!=ratio.length || n!=mat.length || v<=0)
            return null;
        BigDecimal ans;
        float rMin = Math.round(mat[0]/ratio[0]*10000)/10000;
        int sum = 0;
        float[] rat = new float[ratio.length];
        for(int i=0;i<ratio.length;i++){
            if(ratio[i]!=0)
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
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<String> arrInput = new ArrayList<>();
        for(int i=0;i<3;i++){
            String line = in.nextLine();
            arrInput.add(line);
        }
        String[] firstLine = arrInput.get(0).split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int v = Integer.valueOf(firstLine[1]);
        String[] secondLine = arrInput.get(1).split(" ");
        int[] ratio = new int[secondLine.length];
        for(int i=0;i<ratio.length;i++){
            ratio[i] = Integer.valueOf(secondLine[i]);
        }
        String[] thirdLine = arrInput.get(2).split(" ");
        int[] material = new int[thirdLine.length];
        for(int i=0;i<material.length;i++){
            material[i] = Integer.valueOf(thirdLine[i]);
        }
        System.out.print(makeDrink(n,v,ratio,material));
    }
}
