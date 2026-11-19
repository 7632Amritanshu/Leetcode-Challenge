class Solution {
    public String digitSum(String s, int k) {
        if(s.length()<=k){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int sum =0;
        int b=0;
        for( int i=0;i<s.length()-k;){
            int a =i;
            sum =0;
            while(a<i+k){
                sum += s.charAt(a)-'0';
                a++;
            }
            sb.append(sum);
            i= i+k;
            b=i;
        }
        sum =0;
        while(b<s.length()){
            sum += s.charAt(b)-'0';
            b++;
        }
        sb.append(sum);
        return digitSum(sb.toString(),k);
    }
}