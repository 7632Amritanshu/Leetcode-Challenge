class Solution {
    public int minimumPushes(String word) {
        if(word.length() <= 8 ) return word.length();
        int n= word.length();
        int sum =0;int i=1;
        while(n> 0){
            if(n>8){
                sum += 8*i;
            }else{
                sum += n*i;
            }
            n = n-8;
            i++;
        }
        return sum ;
    }
}