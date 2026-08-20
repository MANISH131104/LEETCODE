class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> [] arr = new ArrayList[s.length()+1];
        Map<Character,Integer> map = new HashMap();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Character ch :  map.keySet()){
            if(arr[map.get(ch)]==null){
                arr[map.get(ch)]=new ArrayList();
            }
            arr[map.get(ch)].add(ch);
        }
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]!=null){
                for(Character c:arr[i]){
                    for(int j=0; j<i; j++){
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}