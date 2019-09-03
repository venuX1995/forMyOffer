import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String t){
        if(s == null || t == null)
            return null;
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> target = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(Character c:t.toCharArray()){
            target.put(c, target.getOrDefault(c,0)+1);
        }

        int left = 0, right = 0;

        while(right < s.length()){
            Character c = s.charAt(right);
            window.put(c , window.getOrDefault(c,0)+1);
            right += 1;

            while (window.get(c) > target.getOrDefault(c,0)){
                Character cLeft = s.charAt(left);
                window.put(cLeft, window.getOrDefault(cLeft,0)-1);
                left += 1;
            }

            if((right - left + 1) == t.length())
                ans.add(left);
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "cbaebabacd";
        String t = "abc";

        List<Integer>  ans = findAnagrams(s,t);
        for(int index:ans){
            System.out.print(index);
        }
    }
}
