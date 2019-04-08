import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class stringPermutation {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if(str==null||str.length()==0)
            return ans;
        HashSet<String> set = new HashSet<>();
        char[] arr = str.toCharArray();
        permutation(arr,0,ans,set);
        return ans;
    }
    public static void permutation(char[] str,int p,ArrayList<String> list,HashSet<String> set){
        if(p==str.length && !set.contains(String.valueOf(str))){
            set.add(String.valueOf(str));
            list.add(String.valueOf(str));
            Collections.sort(list);
        }else{
            for(int i =p;i<str.length;i++){
                swap(str,i,p);
                permutation(str,p+1,list,set);
                swap(str,i,p);
            }
        }
    }
    public static void swap(char[] str,int i,int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    public static void main(String args[]){
        String test = "abc";
        ArrayList<String> ans = Permutation(test);
        System.out.println(ans);
    }
}
