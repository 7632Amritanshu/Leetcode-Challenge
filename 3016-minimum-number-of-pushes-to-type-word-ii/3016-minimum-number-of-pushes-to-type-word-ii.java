import java.util.*;
class Solution {
    public int minimumPushes(String word) {
       Integer[] fre = new Integer[26];
       Arrays.fill(fre,0);
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            fre[(int)(ch-'a')]++;
        }
         Arrays.sort(fre, Collections.reverseOrder());
         int sum =0,j=1;
        for(int i=0;i<26;i++){
             if(i>0 && i%8==0){
                j++;
            }
            sum += fre[i]*j;
           

        }
        return sum;
    }
}