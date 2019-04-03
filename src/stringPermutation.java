import java.util.ArrayList;
public class stringPermutation {
    protected ArrayList<String> ans = new ArrayList();
    //protected StringBuffer sb = new StringBuffer();
    public ArrayList<String> Permutation(String str) {
        if(str == null)
            return null;
        permutation(str,0);
        return ans;
    }
    public String permutation(String str,int p){
        StringBuffer sb = new StringBuffer();
        if(p==str.length()){
            ans.add(sb.toString());
        }else{
            for(int i=p;i<str.length();i++){    //i遍历每一个字母排在头的情况
                char temp = str.charAt(i);
                str.charAt(i) = str.charAt(p);
                str.charAt(p) = temp;
                sb.append(str.charAt(p));
                sb.append(permutation(str,p+1));
                str.charAt(p) = str.charAt(i);
                str.charAt(i) = temp;
            }
        }
        return sb.toString();
    }
}
