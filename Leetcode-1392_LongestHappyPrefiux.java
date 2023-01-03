class Solution {
    public String longestPrefix(String s) {
        int len=0;
        int n=s.length();
        char ch[]=s.toCharArray();
        int lps[]=new int[s.length()];
        int i=1;
        while(i<ch.length){
            if(ch[i]==(ch[len])){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        // System.out.println(lps[i-1]);
        if (lps[n-1] == 0)
        {
            return "";
        }
        return s.substring(0,lps[n-1]);
    }
}