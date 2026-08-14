class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry =1 ;
        int i = digits.length-1;
        while(carry ==1 && i>=0){
            digits[i]= digits[i]+1;
            carry = (digits[i]/10);
            digits[i] = digits[i]%10;
            i--;
        }
        if(carry ==1) {
            int[] num = new int[digits.length+1];
            num[0] = 1;
            for(int j=1;j<num.length;j++){
                num[j]=digits[j-1];
            }
            return num;
        }
        return digits;
    }
}