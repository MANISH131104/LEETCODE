class Solution {
    private String s;
    private int index;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;

        Set<String> result = parseExpression();
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parseExpression() {
        Set<String> result = parseTerm();
        while (index < s.length() && s.charAt(index) == ',') {
            index++;
            Set<String> next = parseTerm();
            result.addAll(next);
        }
        return result;
    }
    private Set<String> parseTerm() {
        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != '}'
                && s.charAt(index) != ',') {

            Set<String> factor = parseFactor();
            Set<String> temp = new HashSet<>();
            for (String a : result) {
                for (String b : factor) {
                    temp.add(a + b);
                }
            }
            result = temp;
        }
        return result;
    }
    private Set<String> parseFactor() {
        Set<String> result = new HashSet<>();
        if (Character.isLetter(s.charAt(index))) {
            result.add(String.valueOf(s.charAt(index)));
            index++;
        }
        else if (s.charAt(index) == '{') {
            index++; 
            result = parseExpression();
            index++; // skip '}'
        }
        return result;
    }
}