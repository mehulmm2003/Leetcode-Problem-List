class Solution {
    int count = 0;

    public int countSubstrings(String s) {
        substringMaker(s);
        return count;

    }

    public void substringMaker(String s) {

        for (int i = 0; i < s.length(); i++) {


            for (int j = i + 1; j <= s.length(); j++) {
                
                    String sub = s.substring(i, j);
                    if (palin(sub)) {
                        count++;
                    }

                }

            
        }
    }

    public boolean palin(String s) {
        if(s.length()==0){
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        int st = 0;
        int end = s.length() - 1;
        while (st < end) {
            if (s.charAt(st) != s.charAt(end)) {
                return false;
            }
            st++;
            end--;
        }
        return true;
    }

}