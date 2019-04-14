import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SplitString {
    public static ArrayList<String> split(String[] str){
        if(str == null || str.length==0)
            return null;
        ArrayList<String> ans = new ArrayList<>();
        for(String s:str){
            int size = 0;
            size = s.length()%8==0?s.length()/8:s.length()/8+1;
            char[] cha = s.toCharArray();
            for(int i=0;i<size;i++){
                StringBuffer sb = new StringBuffer();
                for(int j=0;j<8;j++)
                    if(i*8+j<s.length()){
                        sb.append(cha[i*8+j]);
                    }else{
                        sb.append('0');
                    }
                ans.add(sb.toString());
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] test = {};
        if(in.hasNextLine()){
            String line = in.nextLine();
            if(!line.isEmpty()){
                String[] strs = line.split(" ");
                int num = Integer.valueOf(strs[0]);
                test = new String[strs.length-1];
                for(int i=1;i<strs.length;i++){
                    test[i-1] = strs[i];
                }
            }
        }
        ArrayList<String> ans = split(test);
        Collections.sort(ans);
        for(String s:ans){
            System.out.print(s+" ");
        }
    }
}
