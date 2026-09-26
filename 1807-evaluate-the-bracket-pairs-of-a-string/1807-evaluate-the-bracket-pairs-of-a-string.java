class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String ,String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();){
            int j=i+1;
            if(s.charAt(i)=='('){
                while(s.charAt(j) != ')'){
                    j++;
                }
                 String a = s.substring(i+1,j);
                 sb.append( map.getOrDefault(a,"?"));
                i=j+1;
            }else{
                sb.append(s.charAt(i));
                i++;
            }
           
        }
        return sb.toString();
    }
}