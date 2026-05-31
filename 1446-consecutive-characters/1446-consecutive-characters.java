class Solution {
    public int maxPower(String s) {
        if(s.length()==1){
            return 1;
        }
        int fre=1;
        for(int i=1;i<s.length();i++){
char pre=s.charAt(i-1);
char curr=s.charAt(i);
if(pre==curr){
    int j=i;
    int count=1;
    while(j<s.length()&&s.charAt(j)==pre){
        count++;j++;

    }
    if(j==s.length()){
       return Math.max(count,fre);
    }
    else{
fre=Math.max(count,fre);
    }
    i=j-1;

}
        }
        
        return fre;
    }
}