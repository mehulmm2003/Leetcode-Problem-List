class Solution {
    public boolean makeEqual(String[] words) {
        int []fre=new int [26];
        for (int i=0;i<words.length;i++){
            String str=words[i];
            for(int j=0;j<str.length();j++){
                char ch=str.charAt(j);
                int idx=(int)(ch-'a');
                fre[idx]=fre[idx]+1;
            }
        }
        int len=words.length;
        for(int i=0;i<26;i++){
            if(fre[i]%len!=0){
                return false;
            }
        }
        return true;
        
        
        
    }
}