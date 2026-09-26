class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        HashMap<String,String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        String result = "";
        int i=0;
        while(i<n){
            if(s.charAt(i)=='('){
               int j = s.indexOf(')', i + 1);
                String temp = s.substring(i+1,j);
                if(map.containsKey(temp)){
                    result += map.get(temp);
                }
                else result += "?";
                i=j;
            }
            else{
                result += s.charAt(i);
            }
            i++;
        }
        return result;
    }
}